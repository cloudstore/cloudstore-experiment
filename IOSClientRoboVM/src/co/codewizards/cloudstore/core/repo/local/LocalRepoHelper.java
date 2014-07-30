package co.codewizards.cloudstore.core.repo.local;

import static co.codewizards.cloudstore.core.util.Util.*;

import java.io.File;

public final class LocalRepoHelper {

	private LocalRepoHelper() { }

	/**
	 * Gets the local root containing the given {@code file}.
	 * <p>
	 * If {@code file} itself is the root of a repository, it is returned directly.
	 * <p>
	 * If {@code file} is a directory or file inside the repository, the parent-directory
	 * being the repository's root is returned.
	 * <p>
	 * If {@code file} is not contained in any repository, <code>null</code> is returned.
	 *
	 * @param file the directory or file for which to search the repository's local root. Must not be <code>null</code>.
	 * @return the repository's local root. Is <code>null</code>, if {@code file} is not located inside a repository.
	 */
	public static File getLocalRootContainingFile(final File file) {
		File parentFile = assertNotNull("file", file);
		while (parentFile != null) {
			File parentMetaDir = new File(parentFile, LocalRepoManager.META_DIR_NAME);
			if (parentMetaDir.exists())
				return parentFile;

			parentFile = parentFile.getParentFile();
		}
		return null;
	}

}
