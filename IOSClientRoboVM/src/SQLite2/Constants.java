/* DO NOT EDIT */

package SQLite2;

/**
 * Container for SQLite constants.
 * 
 * Usually generated by "native/mkconst.c". For Android, I pasted in the output of this one-liner:
 * 
 * perl -ne '$_ =~ s/#define\s+(SQLITE\S+)\s+([0-9x]+)/    public static final int $1 = $2;/ && print $_;' external/sqlite/dist/sqlite3.h
 */
public final class Constants {
    // Copied from VERSION.
    public static final int drv_minor = 20100131;
    // Generated by the one-liner above.
    public static final int SQLITE_VERSION_NUMBER = 3006022;
    public static final int SQLITE_OK = 0;   /* Successful result */
    public static final int SQLITE_ERROR = 1;   /* SQL error or missing database */
    public static final int SQLITE_INTERNAL = 2;   /* Internal logic error in SQLite */
    public static final int SQLITE_PERM = 3;   /* Access permission denied */
    public static final int SQLITE_ABORT = 4;   /* Callback routine requested an abort */
    public static final int SQLITE_BUSY = 5;   /* The database file is locked */
    public static final int SQLITE_LOCKED = 6;   /* A table in the database is locked */
    public static final int SQLITE_NOMEM = 7;   /* A malloc() failed */
    public static final int SQLITE_READONLY = 8;   /* Attempt to write a readonly database */
    public static final int SQLITE_INTERRUPT = 9;   /* Operation terminated by sqlite3_interrupt()*/
    public static final int SQLITE_IOERR = 10;   /* Some kind of disk I/O error occurred */
    public static final int SQLITE_CORRUPT = 11;   /* The database disk image is malformed */
    public static final int SQLITE_NOTFOUND = 12;   /* NOT USED. Table or record not found */
    public static final int SQLITE_FULL = 13;   /* Insertion failed because database is full */
    public static final int SQLITE_CANTOPEN = 14;   /* Unable to open the database file */
    public static final int SQLITE_PROTOCOL = 15;   /* NOT USED. Database lock protocol error */
    public static final int SQLITE_EMPTY = 16;   /* Database is empty */
    public static final int SQLITE_SCHEMA = 17;   /* The database schema changed */
    public static final int SQLITE_TOOBIG = 18;   /* String or BLOB exceeds size limit */
    public static final int SQLITE_CONSTRAINT = 19;   /* Abort due to constraint violation */
    public static final int SQLITE_MISMATCH = 20;   /* Data type mismatch */
    public static final int SQLITE_MISUSE = 21;   /* Library used incorrectly */
    public static final int SQLITE_NOLFS = 22;   /* Uses OS features not supported on host */
    public static final int SQLITE_AUTH = 23;   /* Authorization denied */
    public static final int SQLITE_FORMAT = 24;   /* Auxiliary database format error */
    public static final int SQLITE_RANGE = 25;   /* 2nd parameter to sqlite3_bind out of range */
    public static final int SQLITE_NOTADB = 26;   /* File opened that is not a database file */
    public static final int SQLITE_ROW = 100;  /* sqlite3_step() has another row ready */
    public static final int SQLITE_DONE = 101;  /* sqlite3_step() has finished executing */
    public static final int SQLITE_OPEN_READONLY = 0x00000001;  /* Ok for sqlite3_open_v2() */
    public static final int SQLITE_OPEN_READWRITE = 0x00000002;  /* Ok for sqlite3_open_v2() */
    public static final int SQLITE_OPEN_CREATE = 0x00000004;  /* Ok for sqlite3_open_v2() */
    public static final int SQLITE_OPEN_DELETEONCLOSE = 0x00000008;  /* VFS only */
    public static final int SQLITE_OPEN_EXCLUSIVE = 0x00000010;  /* VFS only */
    public static final int SQLITE_OPEN_MAIN_DB = 0x00000100;  /* VFS only */
    public static final int SQLITE_OPEN_TEMP_DB = 0x00000200;  /* VFS only */
    public static final int SQLITE_OPEN_TRANSIENT_DB = 0x00000400;  /* VFS only */
    public static final int SQLITE_OPEN_MAIN_JOURNAL = 0x00000800;  /* VFS only */
    public static final int SQLITE_OPEN_TEMP_JOURNAL = 0x00001000;  /* VFS only */
    public static final int SQLITE_OPEN_SUBJOURNAL = 0x00002000;  /* VFS only */
    public static final int SQLITE_OPEN_MASTER_JOURNAL = 0x00004000;  /* VFS only */
    public static final int SQLITE_OPEN_NOMUTEX = 0x00008000;  /* Ok for sqlite3_open_v2() */
    public static final int SQLITE_OPEN_FULLMUTEX = 0x00010000;  /* Ok for sqlite3_open_v2() */
    public static final int SQLITE_OPEN_SHAREDCACHE = 0x00020000;  /* Ok for sqlite3_open_v2() */
    public static final int SQLITE_OPEN_PRIVATECACHE = 0x00040000;  /* Ok for sqlite3_open_v2() */
    public static final int SQLITE_IOCAP_ATOMIC = 0x00000001;
    public static final int SQLITE_IOCAP_ATOMIC512 = 0x00000002;
    public static final int SQLITE_IOCAP_ATOMIC1K = 0x00000004;
    public static final int SQLITE_IOCAP_ATOMIC2K = 0x00000008;
    public static final int SQLITE_IOCAP_ATOMIC4K = 0x00000010;
    public static final int SQLITE_IOCAP_ATOMIC8K = 0x00000020;
    public static final int SQLITE_IOCAP_ATOMIC16K = 0x00000040;
    public static final int SQLITE_IOCAP_ATOMIC32K = 0x00000080;
    public static final int SQLITE_IOCAP_ATOMIC64K = 0x00000100;
    public static final int SQLITE_IOCAP_SAFE_APPEND = 0x00000200;
    public static final int SQLITE_IOCAP_SEQUENTIAL = 0x00000400;
    public static final int SQLITE_LOCK_NONE = 0;
    public static final int SQLITE_LOCK_SHARED = 1;
    public static final int SQLITE_LOCK_RESERVED = 2;
    public static final int SQLITE_LOCK_PENDING = 3;
    public static final int SQLITE_LOCK_EXCLUSIVE = 4;
    public static final int SQLITE_SYNC_NORMAL = 0x00002;
    public static final int SQLITE_SYNC_FULL = 0x00003;
    public static final int SQLITE_SYNC_DATAONLY = 0x00010;
    public static final int SQLITE_FCNTL_LOCKSTATE = 1;
    public static final int SQLITE_GET_LOCKPROXYFILE = 2;
    public static final int SQLITE_SET_LOCKPROXYFILE = 3;
    public static final int SQLITE_LAST_ERRNO = 4;
    public static final int SQLITE_ACCESS_EXISTS = 0;
    public static final int SQLITE_ACCESS_READWRITE = 1;
    public static final int SQLITE_ACCESS_READ = 2;
    public static final int SQLITE_CONFIG_SINGLETHREAD = 1;  /* nil */
    public static final int SQLITE_CONFIG_MULTITHREAD = 2;  /* nil */
    public static final int SQLITE_CONFIG_SERIALIZED = 3;  /* nil */
    public static final int SQLITE_CONFIG_MALLOC = 4;  /* sqlite3_mem_methods* */
    public static final int SQLITE_CONFIG_GETMALLOC = 5;  /* sqlite3_mem_methods* */
    public static final int SQLITE_CONFIG_SCRATCH = 6;  /* void*, int sz, int N */
    public static final int SQLITE_CONFIG_PAGECACHE = 7;  /* void*, int sz, int N */
    public static final int SQLITE_CONFIG_HEAP = 8;  /* void*, int nByte, int min */
    public static final int SQLITE_CONFIG_MEMSTATUS = 9;  /* boolean */
    public static final int SQLITE_CONFIG_MUTEX = 10;  /* sqlite3_mutex_methods* */
    public static final int SQLITE_CONFIG_GETMUTEX = 11;  /* sqlite3_mutex_methods* */
    public static final int SQLITE_CONFIG_LOOKASIDE = 13;  /* int int */
    public static final int SQLITE_CONFIG_PCACHE = 14;  /* sqlite3_pcache_methods* */
    public static final int SQLITE_CONFIG_GETPCACHE = 15;  /* sqlite3_pcache_methods* */
    public static final int SQLITE_DBCONFIG_LOOKASIDE = 1001;  /* void* int int */
    public static final int SQLITE_DENY = 1;   /* Abort the SQL statement with an error */
    public static final int SQLITE_IGNORE = 2;   /* Don't allow access, but don't generate an error */
    public static final int SQLITE_CREATE_INDEX = 1;   /* Index Name      Table Name      */
    public static final int SQLITE_CREATE_TABLE = 2;   /* Table Name      NULL            */
    public static final int SQLITE_CREATE_TEMP_INDEX = 3;   /* Index Name      Table Name      */
    public static final int SQLITE_CREATE_TEMP_TABLE = 4;   /* Table Name      NULL            */
    public static final int SQLITE_CREATE_TEMP_TRIGGER = 5;   /* Trigger Name    Table Name      */
    public static final int SQLITE_CREATE_TEMP_VIEW = 6;   /* View Name       NULL            */
    public static final int SQLITE_CREATE_TRIGGER = 7;   /* Trigger Name    Table Name      */
    public static final int SQLITE_CREATE_VIEW = 8;   /* View Name       NULL            */
    public static final int SQLITE_DELETE = 9;   /* Table Name      NULL            */
    public static final int SQLITE_DROP_INDEX = 10;   /* Index Name      Table Name      */
    public static final int SQLITE_DROP_TABLE = 11;   /* Table Name      NULL            */
    public static final int SQLITE_DROP_TEMP_INDEX = 12;   /* Index Name      Table Name      */
    public static final int SQLITE_DROP_TEMP_TABLE = 13;   /* Table Name      NULL            */
    public static final int SQLITE_DROP_TEMP_TRIGGER = 14;   /* Trigger Name    Table Name      */
    public static final int SQLITE_DROP_TEMP_VIEW = 15;   /* View Name       NULL            */
    public static final int SQLITE_DROP_TRIGGER = 16;   /* Trigger Name    Table Name      */
    public static final int SQLITE_DROP_VIEW = 17;   /* View Name       NULL            */
    public static final int SQLITE_INSERT = 18;   /* Table Name      NULL            */
    public static final int SQLITE_PRAGMA = 19;   /* Pragma Name     1st arg or NULL */
    public static final int SQLITE_READ = 20;   /* Table Name      Column Name     */
    public static final int SQLITE_SELECT = 21;   /* NULL            NULL            */
    public static final int SQLITE_TRANSACTION = 22;   /* Operation       NULL            */
    public static final int SQLITE_UPDATE = 23;   /* Table Name      Column Name     */
    public static final int SQLITE_ATTACH = 24;   /* Filename        NULL            */
    public static final int SQLITE_DETACH = 25;   /* Database Name   NULL            */
    public static final int SQLITE_ALTER_TABLE = 26;   /* Database Name   Table Name      */
    public static final int SQLITE_REINDEX = 27;   /* Index Name      NULL            */
    public static final int SQLITE_ANALYZE = 28;   /* Table Name      NULL            */
    public static final int SQLITE_CREATE_VTABLE = 29;   /* Table Name      Module Name     */
    public static final int SQLITE_DROP_VTABLE = 30;   /* Table Name      Module Name     */
    public static final int SQLITE_FUNCTION = 31;   /* NULL            Function Name   */
    public static final int SQLITE_SAVEPOINT = 32;   /* Operation       Savepoint Name  */
    public static final int SQLITE_COPY = 0;   /* No longer used */
    public static final int SQLITE_LIMIT_LENGTH = 0;
    public static final int SQLITE_LIMIT_SQL_LENGTH = 1;
    public static final int SQLITE_LIMIT_COLUMN = 2;
    public static final int SQLITE_LIMIT_EXPR_DEPTH = 3;
    public static final int SQLITE_LIMIT_COMPOUND_SELECT = 4;
    public static final int SQLITE_LIMIT_VDBE_OP = 5;
    public static final int SQLITE_LIMIT_FUNCTION_ARG = 6;
    public static final int SQLITE_LIMIT_ATTACHED = 7;
    public static final int SQLITE_LIMIT_LIKE_PATTERN_LENGTH = 8;
    public static final int SQLITE_LIMIT_VARIABLE_NUMBER = 9;
    public static final int SQLITE_LIMIT_TRIGGER_DEPTH = 10;
    public static final int SQLITE_INTEGER = 1;
    public static final int SQLITE_FLOAT = 2;
    public static final int SQLITE_BLOB = 4;
    public static final int SQLITE_NULL = 5;
    public static final int SQLITE3_TEXT = 3;
    public static final int SQLITE_UTF8 = 1;
    public static final int SQLITE_UTF16LE = 2;
    public static final int SQLITE_UTF16BE = 3;
    public static final int SQLITE_UTF16 = 4;    /* Use native byte order */
    public static final int SQLITE_ANY = 5;    /* sqlite3_create_function only */
    public static final int SQLITE_UTF16_ALIGNED = 8;    /* sqlite3_create_collation only */
    public static final int SQLITE_INDEX_CONSTRAINT_EQ = 2;
    public static final int SQLITE_INDEX_CONSTRAINT_GT = 4;
    public static final int SQLITE_INDEX_CONSTRAINT_LE = 8;
    public static final int SQLITE_INDEX_CONSTRAINT_LT = 16;
    public static final int SQLITE_INDEX_CONSTRAINT_GE = 32;
    public static final int SQLITE_INDEX_CONSTRAINT_MATCH = 64;
    public static final int SQLITE_MUTEX_FAST = 0;
    public static final int SQLITE_MUTEX_RECURSIVE = 1;
    public static final int SQLITE_MUTEX_STATIC_MASTER = 2;
    public static final int SQLITE_MUTEX_STATIC_MEM = 3;  /* sqlite3_malloc() */
    public static final int SQLITE_MUTEX_STATIC_MEM2 = 4;  /* NOT USED */
    public static final int SQLITE_MUTEX_STATIC_OPEN = 4;  /* sqlite3BtreeOpen() */
    public static final int SQLITE_MUTEX_STATIC_PRNG = 5;  /* sqlite3_random() */
    public static final int SQLITE_MUTEX_STATIC_LRU = 6;  /* lru page list */
    public static final int SQLITE_MUTEX_STATIC_LRU2 = 7;  /* lru page list */
    public static final int SQLITE_TESTCTRL_FIRST = 5;
    public static final int SQLITE_TESTCTRL_PRNG_SAVE = 5;
    public static final int SQLITE_TESTCTRL_PRNG_RESTORE = 6;
    public static final int SQLITE_TESTCTRL_PRNG_RESET = 7;
    public static final int SQLITE_TESTCTRL_BITVEC_TEST = 8;
    public static final int SQLITE_TESTCTRL_FAULT_INSTALL = 9;
    public static final int SQLITE_TESTCTRL_BENIGN_MALLOC_HOOKS = 10;
    public static final int SQLITE_TESTCTRL_PENDING_BYTE = 11;
    public static final int SQLITE_TESTCTRL_ASSERT = 12;
    public static final int SQLITE_TESTCTRL_ALWAYS = 13;
    public static final int SQLITE_TESTCTRL_RESERVE = 14;
    public static final int SQLITE_TESTCTRL_OPTIMIZATIONS = 15;
    public static final int SQLITE_TESTCTRL_ISKEYWORD = 16;
    public static final int SQLITE_TESTCTRL_LAST = 16;
    public static final int SQLITE_STATUS_MEMORY_USED = 0;
    public static final int SQLITE_STATUS_PAGECACHE_USED = 1;
    public static final int SQLITE_STATUS_PAGECACHE_OVERFLOW = 2;
    public static final int SQLITE_STATUS_SCRATCH_USED = 3;
    public static final int SQLITE_STATUS_SCRATCH_OVERFLOW = 4;
    public static final int SQLITE_STATUS_MALLOC_SIZE = 5;
    public static final int SQLITE_STATUS_PARSER_STACK = 6;
    public static final int SQLITE_STATUS_PAGECACHE_SIZE = 7;
    public static final int SQLITE_STATUS_SCRATCH_SIZE = 8;
    public static final int SQLITE_DBSTATUS_LOOKASIDE_USED = 0;
    public static final int SQLITE_STMTSTATUS_FULLSCAN_STEP = 1;
    public static final int SQLITE_STMTSTATUS_SORT = 2;
}
