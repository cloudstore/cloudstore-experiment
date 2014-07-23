package test;


import java.io.File;
import java.util.Collection;


import co.codewizards.cloudstore.core.repo.local.LocalRepoManager;
import co.codewizards.cloudstore.core.repo.local.LocalRepoTransaction;

public class PersistenceTest {

	private static final int modificationCount = 10000;

	public void run(){
		beforeClass();
		
	}
	
	public static void beforeClass() {
		
	}
	
	private void testCopyModification(){
		RemoteRepository remoteRepository = new RemoteRepository();
		remoteRepository.setLocalPathPrefix("");
		remoteRepository.setPublicKey(new byte[] { 1, 2, 3, 4, 5, 6, 7, 8, 9, 0 });
		remoteRepository = transaction.getDAO(RemoteRepositoryDAO.class).makePersistent(remoteRepository);
	}


//	@Test
//	public void getModifications() throws Exception {
//		File remoteRoot = newTestRepositoryLocalRoot("remote");
//		remoteRoot.mkdirs();
//		LocalRepoManager localRepoManager = localRepoManagerFactory.createLocalRepoManagerForNewRepository(remoteRoot);
//		assertThat(localRepoManager).isNotNull();
//		LocalRepoTransaction transaction = localRepoManager.beginWriteTransaction();
//		try {
//			RemoteRepository remoteRepository = new RemoteRepository();
//			remoteRepository.setLocalPathPrefix("");
//			remoteRepository.setPublicKey(new byte[] { 1, 2, 3, 4, 5, 6, 7, 8, 9, 0 });
//			remoteRepository = transaction.getDAO(RemoteRepositoryDAO.class).makePersistent(remoteRepository);
//
//			CopyModificationDAO copyModificationDAO = transaction.getDAO(CopyModificationDAO.class);
//			for (int i = 0; i < modificationCount; ++i) {
//				CopyModification copyModification = new CopyModification();
//				copyModification.setRemoteRepository(remoteRepository);
//				copyModification.setFromPath("/from/" + i);
//				copyModification.setToPath("/to/" + i);
//				copyModification.setLength(100000);
//				copyModification.setSha1("TEST" + i);
//				copyModificationDAO.makePersistent(copyModification);
//			}
//			transaction.commit();
//		} finally {
//			transaction.rollbackIfActive();
//		}
//
//		localRepoManager.close();
//		localRepoManager = localRepoManagerFactory.createLocalRepoManagerForExistingRepository(remoteRoot);
//
//		transaction = localRepoManager.beginReadTransaction();
//		try {
//			RemoteRepository remoteRepository = transaction.getDAO(RemoteRepositoryDAO.class).getObjects().iterator().next();
//			ModificationDAO modificationDAO = transaction.getDAO(ModificationDAO.class);
//			Collection<Modification> modifications = modificationDAO.getModifications(remoteRepository);
//			assertThat(modifications).hasSize(modificationCount);
//			System.out.println("*** Accessing fromPath and toPath ***");
//			for (Modification modification : modifications) {
//				if (modification instanceof CopyModification) {
//					CopyModification copyModification = (CopyModification)modification;
//					System.out.println(String.format("%s => %s",
//							copyModification.getFromPath(),
//							copyModification.getToPath()));
//				}
//			}
//			transaction.commit();
//		} finally {
//			transaction.rollbackIfActive();
//		}
//
//		localRepoManager.close();
//	}
}
