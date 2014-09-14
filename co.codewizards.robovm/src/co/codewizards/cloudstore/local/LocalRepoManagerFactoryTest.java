package co.codewizards.cloudstore.local;

import static org.assertj.core.api.Assertions.*;

import java.io.File;
import java.io.IOException;
import java.lang.reflect.Proxy;

import test.AbstractTest;
import co.codewizards.cloudstore.core.repo.local.FileAlreadyRepositoryException;
import co.codewizards.cloudstore.core.repo.local.FileNoDirectoryException;
import co.codewizards.cloudstore.core.repo.local.FileNoRepositoryException;
import co.codewizards.cloudstore.core.repo.local.FileNotFoundException;
import co.codewizards.cloudstore.core.repo.local.LocalRepoManager;

public class LocalRepoManagerFactoryTest extends AbstractTest {

	public void run(){
		try{
			System.setProperty(LocalRepoManager.SYSTEM_PROPERTY_CLOSE_DEFERRED_MILLIS, "0");
			createLocalRepoManagerForExistingNonRepoDirectory();
			createLocalRepoManagerForNonExistingDirectory();
			createLocalRepoManagerForNonRepoDirInsideRepoDirectory();
			createLocalRepoManagerForRepoDirectory();
			createLocalRepoManagerForRepoDirectoryWithClose();
			System.clearProperty(LocalRepoManager.SYSTEM_PROPERTY_CLOSE_DEFERRED_MILLIS);
		}catch(Exception ex){
			System.out.println("test fail : " + ex.getMessage());
		}
	}

	public void createLocalRepoManagerForExistingNonRepoDirectory() throws Exception {
		File localRoot = newTestRepositoryLocalRoot();
		assertThat(localRoot).doesNotExist();
		localRoot.mkdirs();
		assertThat(localRoot).isDirectory();
		LocalRepoManager localRepoManager = localRepoManagerFactory.createLocalRepoManagerForNewRepository(localRoot);
		assertThat(localRepoManager).isNotNull();

		LocalRepoManager localRepoManager2 = localRepoManagerFactory.createLocalRepoManagerForExistingRepository(new File(new File(localRoot, "bla"), ".."));
		assertThat(localRepoManager2).isNotNull();
		assertThat(localRepoManager2).isNotSameAs(localRepoManager);

		assertThat(Proxy.isProxyClass(localRepoManager.getClass())).isTrue();
		assertThat(Proxy.isProxyClass(localRepoManager2.getClass())).isTrue();

		LocalRepoManagerInvocationHandler invocationHandler = (LocalRepoManagerInvocationHandler) Proxy.getInvocationHandler(localRepoManager);
		LocalRepoManagerInvocationHandler invocationHandler2 = (LocalRepoManagerInvocationHandler) Proxy.getInvocationHandler(localRepoManager2);
		assertThat(invocationHandler).isNotSameAs(invocationHandler2);
		assertThat(invocationHandler.localRepoManagerImpl).isSameAs(invocationHandler2.localRepoManagerImpl);

		localRepoManager.close();
		localRepoManager2.close();
	}

	public void getLocalRepoManagerForExistingRepository() throws Exception {
		File localRoot = newTestRepositoryLocalRoot();
		assertThat(localRoot).doesNotExist();
		localRoot.mkdirs();
		assertThat(localRoot).isDirectory();
		LocalRepoManager localRepoManager = localRepoManagerFactory.createLocalRepoManagerForNewRepository(localRoot);
		assertThat(localRepoManager).isNotNull();

		localRepoManager.close();

		LocalRepoManager localRepoManager2 = localRepoManagerFactory.createLocalRepoManagerForExistingRepository(new File(new File(localRoot, "bla"), ".."));
		assertThat(localRepoManager2).isNotNull();
		assertThat(localRepoManager2).isNotSameAs(localRepoManager);

		localRepoManager2.close();
	}

	public void getLocalRepoManagerForNonExistingDirectory() throws Exception {
		try{
			File localRoot = newTestRepositoryLocalRoot();
			assertThat(localRoot).doesNotExist();
			localRepoManagerFactory.createLocalRepoManagerForExistingRepository(localRoot);
		} catch(Throwable ex){
			assertThat(ex).isInstanceOf(FileNotFoundException.class);
		}
	}

	public void getLocalRepoManagerForExistingNonDirectoryFile() throws Exception {
		try{
			File localRoot = newTestRepositoryLocalRoot();
			File localRootParent = localRoot.getParentFile();
	
			localRootParent.mkdirs();
			assertThat(localRootParent).isDirectory();
	
			localRoot.createNewFile();
			assertThat(localRoot).isFile();
	
			localRepoManagerFactory.createLocalRepoManagerForExistingRepository(localRoot);
		} catch(Throwable ex){
			assertThat(ex).isInstanceOf(FileNoDirectoryException.class);
		}
	}

	public void getLocalRepoManagerForExistingNonRepoDirectory() throws Exception {
		try{
			File localRoot = newTestRepositoryLocalRoot();
			localRoot.mkdirs();
			assertThat(localRoot).isDirectory();
			LocalRepoManager localRepoManager = localRepoManagerFactory.createLocalRepoManagerForExistingRepository(localRoot);
			localRepoManager.close();
		} catch(Throwable ex){
			assertThat(ex).isInstanceOf(FileNoRepositoryException.class);
		}
	}

	public void createLocalRepoManagerForNonExistingDirectory() throws Exception {
		try{
			File localRoot = newTestRepositoryLocalRoot();
			assertThat(localRoot).doesNotExist();
			localRepoManagerFactory.createLocalRepoManagerForNewRepository(localRoot);
		} catch(Throwable ex){
			assertThat(ex).isInstanceOf(FileNotFoundException.class);
		}
	}

	public void createLocalRepoManagerForRepoDirectory() throws Exception {
		try{
			File localRoot = newTestRepositoryLocalRoot();
			assertThat(localRoot).doesNotExist();
			localRoot.mkdirs();
			assertThat(localRoot).isDirectory();
			LocalRepoManager localRepoManager = localRepoManagerFactory.createLocalRepoManagerForNewRepository(localRoot);
			assertThat(localRepoManager).isNotNull();
			localRepoManager.close();
	
			localRepoManagerFactory.createLocalRepoManagerForNewRepository(localRoot);
		} catch(Throwable ex){
			assertThat(ex).isInstanceOf(FileAlreadyRepositoryException.class);
		}
	}

	/**
	 * Expects the same behaviour as {@link #createLocalRepoManagerForRepoDirectory()}
	 */
	public void createLocalRepoManagerForRepoDirectoryWithClose() throws Exception {
		try{
			File localRoot = newTestRepositoryLocalRoot();
			assertThat(localRoot).doesNotExist();
			localRoot.mkdirs();
			assertThat(localRoot).isDirectory();
			LocalRepoManager localRepoManager = localRepoManagerFactory.createLocalRepoManagerForNewRepository(localRoot);
			assertThat(localRepoManager).isNotNull();
			localRepoManager.close();
			localRepoManagerFactory.createLocalRepoManagerForNewRepository(localRoot);
		} catch(Throwable ex){
			assertThat(ex).isInstanceOf(FileAlreadyRepositoryException.class);
		}
	}

	public void createLocalRepoManagerForNonRepoDirInsideRepoDirectory() throws Exception {
		try{
			File localRoot = newTestRepositoryLocalRoot();
			localRoot.mkdirs();
			assertThat(localRoot).isDirectory();
			LocalRepoManager localRepoManager = localRepoManagerFactory.createLocalRepoManagerForNewRepository(localRoot);
	
			assertThat(localRepoManager.getLocalRoot()).isEqualTo(localRoot.getCanonicalFile());
	
			File sub1Dir = new File(localRepoManager.getLocalRoot(), "sub1");
			File sub1SubAaaDir = new File(sub1Dir, "aaa");
	
			sub1SubAaaDir.mkdirs();
			assertThat(sub1SubAaaDir).isDirectory();
	
			localRepoManager.close();
	
			localRepoManagerFactory.createLocalRepoManagerForNewRepository(sub1SubAaaDir);
		} catch(Throwable ex){
			assertThat(ex).isInstanceOf(FileAlreadyRepositoryException.class);
		}
	}

	private File newTestRepositoryLocalRoot() throws IOException {
		return newTestRepositoryLocalRoot("");
	}

}
