package co.codewizards.cloudstore.local.persistence;

import static co.codewizards.cloudstore.core.util.Util.assertNotNull;

import javax.jdo.annotations.Inheritance;
import javax.jdo.annotations.InheritanceStrategy;
import javax.jdo.annotations.NotPersistent;
import javax.jdo.annotations.NullValue;
import javax.jdo.annotations.PersistenceCapable;
import javax.jdo.annotations.Persistent;
import javax.jdo.annotations.Unique;
import javax.jdo.listener.LoadCallback;
import javax.jdo.listener.StoreCallback;

@PersistenceCapable
@Inheritance(strategy=InheritanceStrategy.NEW_TABLE)
@Unique(name="FileChunk_normalFile_offset", members={"normalFile", "offset"})
public class FileChunk extends Entity implements Comparable<FileChunk>, StoreCallback, LoadCallback {

	@NotPersistent
	private boolean writable = true;

	@Persistent(nullValue=NullValue.EXCEPTION)
	private NormalFile normalFile;

	private long offset;

	private int length;

	private String sha1;

	public NormalFile getNormalFile() {
		return normalFile;
	}
	public void setRepoFile(NormalFile normalFile) {
		assertWritable();
		this.normalFile = normalFile;
	}
	public long getOffset() {
		return offset;
	}
	public void setOffset(long offset) {
		assertWritable();
		this.offset = offset;
	}
	public int getLength() {
		return length;
	}
	public void setLength(int length) {
		assertWritable();
		this.length = length;
	}
	public String getSha1() {
		return sha1;
	}
	public void setSha1(String sha1) {
		assertWritable();
		this.sha1 = sha1;
	}

	protected void assertWritable() {
		if (!writable)
			throw new IllegalStateException("This instance is read-only!");
	}

	public void makeReadOnly() {
		writable = false;
	}

	@Override
	public void jdoPreStore() {
		makeReadOnly();
	}
	@Override
	public void jdoPostLoad() {
		makeReadOnly();
	}

	@Override
	public int compareTo(FileChunk other) {
		assertNotNull("other", other);

		if (this.normalFile != other.normalFile) {
			long thisRepoFileId = this.normalFile == null ? 0 : this.normalFile.getId();
			long otherRepoFileId = other.normalFile == null ? 0 : other.normalFile.getId();

			int result = compare(thisRepoFileId, otherRepoFileId);
			if (result != 0)
				return result;
		}

		int result = compare(this.offset, other.offset);
		if (result != 0)
			return result;

		long thisId = this.getId();
		long otherId = other.getId();

		return compare(thisId, otherId);
	}

	private static int compare(long x, long y) {
        return (x < y) ? -1 : ((x == y) ? 0 : 1);
    }

}
