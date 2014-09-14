package SQLite2;

/**
 * Class for SQLite related exceptions.
 */

public class SQLiteException extends java.lang.Exception {

    /**
     * Construct a new SQLite exception.
     *
     * @param string error message
     */

    public SQLiteException(String string) {
	super(string);
    }
}
