package com.squareup.okhttp.internal;

import com.squareup.okhttp.internal.io.FileSystem;
import java.io.Closeable;
import java.io.EOFException;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.NoSuchElementException;
import java.util.concurrent.Executor;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import okio.Buffer;
import okio.BufferedSink;
import okio.BufferedSource;
import okio.Okio;
import okio.Sink;
import okio.Source;
import okio.Timeout;

public final class DiskLruCache
  implements Closeable
{
  static final long ANY_SEQUENCE_NUMBER = -1L;
  private static final String CLEAN = "CLEAN";
  private static final String DIRTY = "DIRTY";
  static final String JOURNAL_FILE = "journal";
  static final String JOURNAL_FILE_BACKUP = "journal.bkp";
  static final String JOURNAL_FILE_TEMP = "journal.tmp";
  static final Pattern LEGAL_KEY_PATTERN;
  static final String MAGIC = "libcore.io.DiskLruCache";
  private static final Sink NULL_SINK;
  private static final String READ = "READ";
  private static final String REMOVE = "REMOVE";
  static final String VERSION_1 = "1";
  private final int appVersion;
  private final Runnable cleanupRunnable = new Runnable()
  {
    public void run()
    {
      int i = 0;
      synchronized (DiskLruCache.this)
      {
        if (!initialized) {
          i = 1;
        }
        if ((i | closed) != 0) {
          return;
        }
      }
    }
  };
  private boolean closed;
  private final File directory;
  private final Executor executor;
  private final FileSystem fileSystem;
  private boolean hasJournalErrors;
  private boolean initialized;
  private final File journalFile;
  private final File journalFileBackup;
  private final File journalFileTmp;
  private BufferedSink journalWriter;
  private final LinkedHashMap<String, Entry> lruEntries = new LinkedHashMap(0, 0.75F, true);
  private long maxSize;
  private long nextSequenceNumber = 0L;
  private int redundantOpCount;
  private long size = 0L;
  private final int valueCount;
  
  static
  {
    if (!DiskLruCache.class.desiredAssertionStatus()) {}
    for (boolean bool = true;; bool = false)
    {
      $assertionsDisabled = bool;
      LEGAL_KEY_PATTERN = Pattern.compile("[a-z0-9_-]{1,120}");
      NULL_SINK = new Sink()
      {
        public void close()
          throws IOException
        {}
        
        public void flush()
          throws IOException
        {}
        
        public Timeout timeout()
        {
          return Timeout.NONE;
        }
        
        public void write(Buffer paramAnonymousBuffer, long paramAnonymousLong)
          throws IOException
        {
          paramAnonymousBuffer.skip(paramAnonymousLong);
        }
      };
      return;
    }
  }
  
  DiskLruCache(FileSystem paramFileSystem, File paramFile, int paramInt1, int paramInt2, long paramLong, Executor paramExecutor)
  {
    fileSystem = paramFileSystem;
    directory = paramFile;
    appVersion = paramInt1;
    journalFile = new File(paramFile, "journal");
    journalFileTmp = new File(paramFile, "journal.tmp");
    journalFileBackup = new File(paramFile, "journal.bkp");
    valueCount = paramInt2;
    maxSize = paramLong;
    executor = paramExecutor;
  }
  
  private void checkNotClosed()
  {
    try
    {
      if (isClosed()) {
        throw new IllegalStateException("cache is closed");
      }
    }
    finally {}
  }
  
  private void completeEdit(Editor paramEditor, boolean paramBoolean)
    throws IOException
  {
    Entry localEntry;
    try
    {
      localEntry = entry;
      if (currentEditor != paramEditor) {
        throw new IllegalStateException();
      }
    }
    finally {}
    if ((paramBoolean) && (!readable))
    {
      i = 0;
      while (i < valueCount)
      {
        if (written[i] == 0)
        {
          paramEditor.abort();
          throw new IllegalStateException("Newly created entry didn't create value for index " + i);
        }
        if (!fileSystem.exists(dirtyFiles[i]))
        {
          paramEditor.abort();
          return;
        }
        i += 1;
      }
    }
    int i = 0;
    for (;;)
    {
      long l1;
      if (i < valueCount)
      {
        paramEditor = dirtyFiles[i];
        if (paramBoolean)
        {
          if (fileSystem.exists(paramEditor))
          {
            File localFile = cleanFiles[i];
            fileSystem.rename(paramEditor, localFile);
            l1 = lengths[i];
            long l2 = fileSystem.size(localFile);
            lengths[i] = l2;
            size = (size - l1 + l2);
          }
        }
        else {
          fileSystem.delete(paramEditor);
        }
      }
      else
      {
        redundantOpCount += 1;
        Entry.access$902(localEntry, null);
        if ((readable | paramBoolean))
        {
          Entry.access$802(localEntry, true);
          journalWriter.writeUtf8("CLEAN").writeByte(32);
          journalWriter.writeUtf8(key);
          localEntry.writeLengths(journalWriter);
          journalWriter.writeByte(10);
          if (paramBoolean)
          {
            l1 = nextSequenceNumber;
            nextSequenceNumber = (1L + l1);
            Entry.access$1602(localEntry, l1);
          }
        }
        for (;;)
        {
          journalWriter.flush();
          if ((size <= maxSize) && (!journalRebuildRequired())) {
            break;
          }
          executor.execute(cleanupRunnable);
          break;
          lruEntries.remove(key);
          journalWriter.writeUtf8("REMOVE").writeByte(32);
          journalWriter.writeUtf8(key);
          journalWriter.writeByte(10);
        }
      }
      i += 1;
    }
  }
  
  public static DiskLruCache create(FileSystem paramFileSystem, File paramFile, int paramInt1, int paramInt2, long paramLong)
  {
    if (paramLong <= 0L) {
      throw new IllegalArgumentException("maxSize <= 0");
    }
    if (paramInt2 <= 0) {
      throw new IllegalArgumentException("valueCount <= 0");
    }
    return new DiskLruCache(paramFileSystem, paramFile, paramInt1, paramInt2, paramLong, new ThreadPoolExecutor(0, 1, 60L, TimeUnit.SECONDS, new LinkedBlockingQueue(), Util.threadFactory("OkHttp DiskLruCache", true)));
  }
  
  /* Error */
  private Editor edit(String paramString, long paramLong)
    throws IOException
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore 8
    //   3: aload_0
    //   4: monitorenter
    //   5: aload_0
    //   6: invokevirtual 368	com/squareup/okhttp/internal/DiskLruCache:initialize	()V
    //   9: aload_0
    //   10: invokespecial 370	com/squareup/okhttp/internal/DiskLruCache:checkNotClosed	()V
    //   13: aload_0
    //   14: aload_1
    //   15: invokespecial 373	com/squareup/okhttp/internal/DiskLruCache:validateKey	(Ljava/lang/String;)V
    //   18: aload_0
    //   19: getfield 123	com/squareup/okhttp/internal/DiskLruCache:lruEntries	Ljava/util/LinkedHashMap;
    //   22: aload_1
    //   23: invokevirtual 376	java/util/LinkedHashMap:get	(Ljava/lang/Object;)Ljava/lang/Object;
    //   26: checkcast 21	com/squareup/okhttp/internal/DiskLruCache$Entry
    //   29: astore 7
    //   31: lload_2
    //   32: ldc2_w 30
    //   35: lcmp
    //   36: ifeq +35 -> 71
    //   39: aload 8
    //   41: astore 6
    //   43: aload 7
    //   45: ifnull +21 -> 66
    //   48: aload 7
    //   50: invokestatic 380	com/squareup/okhttp/internal/DiskLruCache$Entry:access$1600	(Lcom/squareup/okhttp/internal/DiskLruCache$Entry;)J
    //   53: lstore 4
    //   55: lload 4
    //   57: lload_2
    //   58: lcmp
    //   59: ifeq +12 -> 71
    //   62: aload 8
    //   64: astore 6
    //   66: aload_0
    //   67: monitorexit
    //   68: aload 6
    //   70: areturn
    //   71: aload 7
    //   73: ifnull +15 -> 88
    //   76: aload 8
    //   78: astore 6
    //   80: aload 7
    //   82: invokestatic 230	com/squareup/okhttp/internal/DiskLruCache$Entry:access$900	(Lcom/squareup/okhttp/internal/DiskLruCache$Entry;)Lcom/squareup/okhttp/internal/DiskLruCache$Editor;
    //   85: ifnonnull -19 -> 66
    //   88: aload_0
    //   89: getfield 295	com/squareup/okhttp/internal/DiskLruCache:journalWriter	Lokio/BufferedSink;
    //   92: ldc 36
    //   94: invokeinterface 301 2 0
    //   99: bipush 32
    //   101: invokeinterface 305 2 0
    //   106: aload_1
    //   107: invokeinterface 301 2 0
    //   112: bipush 10
    //   114: invokeinterface 305 2 0
    //   119: pop
    //   120: aload_0
    //   121: getfield 295	com/squareup/okhttp/internal/DiskLruCache:journalWriter	Lokio/BufferedSink;
    //   124: invokeinterface 320 1 0
    //   129: aload 8
    //   131: astore 6
    //   133: aload_0
    //   134: getfield 211	com/squareup/okhttp/internal/DiskLruCache:hasJournalErrors	Z
    //   137: ifne -71 -> 66
    //   140: aload 7
    //   142: astore 6
    //   144: aload 7
    //   146: ifnonnull +26 -> 172
    //   149: new 21	com/squareup/okhttp/internal/DiskLruCache$Entry
    //   152: dup
    //   153: aload_0
    //   154: aload_1
    //   155: aconst_null
    //   156: invokespecial 383	com/squareup/okhttp/internal/DiskLruCache$Entry:<init>	(Lcom/squareup/okhttp/internal/DiskLruCache;Ljava/lang/String;Lcom/squareup/okhttp/internal/DiskLruCache$1;)V
    //   159: astore 6
    //   161: aload_0
    //   162: getfield 123	com/squareup/okhttp/internal/DiskLruCache:lruEntries	Ljava/util/LinkedHashMap;
    //   165: aload_1
    //   166: aload 6
    //   168: invokevirtual 387	java/util/LinkedHashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   171: pop
    //   172: new 16	com/squareup/okhttp/internal/DiskLruCache$Editor
    //   175: dup
    //   176: aload_0
    //   177: aload 6
    //   179: aconst_null
    //   180: invokespecial 390	com/squareup/okhttp/internal/DiskLruCache$Editor:<init>	(Lcom/squareup/okhttp/internal/DiskLruCache;Lcom/squareup/okhttp/internal/DiskLruCache$Entry;Lcom/squareup/okhttp/internal/DiskLruCache$1;)V
    //   183: astore_1
    //   184: aload 6
    //   186: aload_1
    //   187: invokestatic 289	com/squareup/okhttp/internal/DiskLruCache$Entry:access$902	(Lcom/squareup/okhttp/internal/DiskLruCache$Entry;Lcom/squareup/okhttp/internal/DiskLruCache$Editor;)Lcom/squareup/okhttp/internal/DiskLruCache$Editor;
    //   190: pop
    //   191: aload_1
    //   192: astore 6
    //   194: goto -128 -> 66
    //   197: astore_1
    //   198: aload_0
    //   199: monitorexit
    //   200: aload_1
    //   201: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	202	0	this	DiskLruCache
    //   0	202	1	paramString	String
    //   0	202	2	paramLong	long
    //   53	3	4	l	long
    //   41	152	6	localObject1	Object
    //   29	116	7	localEntry	Entry
    //   1	129	8	localObject2	Object
    // Exception table:
    //   from	to	target	type
    //   5	31	197	finally
    //   48	55	197	finally
    //   80	88	197	finally
    //   88	129	197	finally
    //   133	140	197	finally
    //   149	172	197	finally
    //   172	191	197	finally
  }
  
  private boolean journalRebuildRequired()
  {
    return (redundantOpCount >= 2000) && (redundantOpCount >= lruEntries.size());
  }
  
  private BufferedSink newJournalWriter()
    throws FileNotFoundException
  {
    Okio.buffer(new FaultHidingSink(fileSystem.appendingSink(journalFile))
    {
      static
      {
        if (!DiskLruCache.class.desiredAssertionStatus()) {}
        for (boolean bool = true;; bool = false)
        {
          $assertionsDisabled = bool;
          return;
        }
      }
      
      protected void onException(IOException paramAnonymousIOException)
      {
        assert (Thread.holdsLock(DiskLruCache.this));
        DiskLruCache.access$602(DiskLruCache.this, true);
      }
    });
  }
  
  private void processJournal()
    throws IOException
  {
    fileSystem.delete(journalFileTmp);
    Iterator localIterator = lruEntries.values().iterator();
    while (localIterator.hasNext())
    {
      Entry localEntry = (Entry)localIterator.next();
      int i;
      if (currentEditor == null)
      {
        i = 0;
        while (i < valueCount)
        {
          size += lengths[i];
          i += 1;
        }
      }
      else
      {
        Entry.access$902(localEntry, null);
        i = 0;
        while (i < valueCount)
        {
          fileSystem.delete(cleanFiles[i]);
          fileSystem.delete(dirtyFiles[i]);
          i += 1;
        }
        localIterator.remove();
      }
    }
  }
  
  private void readJournal()
    throws IOException
  {
    BufferedSource localBufferedSource = Okio.buffer(fileSystem.source(journalFile));
    label241:
    try
    {
      String str1 = localBufferedSource.readUtf8LineStrict();
      String str2 = localBufferedSource.readUtf8LineStrict();
      String str3 = localBufferedSource.readUtf8LineStrict();
      String str4 = localBufferedSource.readUtf8LineStrict();
      String str5 = localBufferedSource.readUtf8LineStrict();
      if ((!"libcore.io.DiskLruCache".equals(str1)) || (!"1".equals(str2)) || (!Integer.toString(appVersion).equals(str3)) || (!Integer.toString(valueCount).equals(str4)) || (!"".equals(str5))) {
        throw new IOException("unexpected journal header: [" + str1 + ", " + str2 + ", " + str4 + ", " + str5 + "]");
      }
    }
    finally
    {
      Util.closeQuietly(localBufferedSource);
      throw ((Throwable)localObject);
      int i = 0;
      try
      {
        for (;;)
        {
          readJournalLine(localBufferedSource.readUtf8LineStrict());
          i += 1;
        }
        rebuildJournal();
      }
      catch (EOFException localEOFException)
      {
        redundantOpCount = (i - lruEntries.size());
        if (localBufferedSource.exhausted()) {
          break label241;
        }
      }
      Util.closeQuietly(localBufferedSource);
      return;
    }
  }
  
  private void readJournalLine(String paramString)
    throws IOException
  {
    int i = paramString.indexOf(' ');
    if (i == -1) {
      throw new IOException("unexpected journal line: " + paramString);
    }
    int j = i + 1;
    int k = paramString.indexOf(' ', j);
    Object localObject2;
    Object localObject1;
    if (k == -1)
    {
      localObject2 = paramString.substring(j);
      localObject1 = localObject2;
      if (i != "REMOVE".length()) {
        break label112;
      }
      localObject1 = localObject2;
      if (!paramString.startsWith("REMOVE")) {
        break label112;
      }
      lruEntries.remove(localObject2);
    }
    label112:
    do
    {
      return;
      localObject1 = paramString.substring(j, k);
      Entry localEntry = (Entry)lruEntries.get(localObject1);
      localObject2 = localEntry;
      if (localEntry == null)
      {
        localObject2 = new Entry((String)localObject1, null);
        lruEntries.put(localObject1, localObject2);
      }
      if ((k != -1) && (i == "CLEAN".length()) && (paramString.startsWith("CLEAN")))
      {
        paramString = paramString.substring(k + 1).split(" ");
        Entry.access$802((Entry)localObject2, true);
        Entry.access$902((Entry)localObject2, null);
        ((Entry)localObject2).setLengths(paramString);
        return;
      }
      if ((k == -1) && (i == "DIRTY".length()) && (paramString.startsWith("DIRTY")))
      {
        Entry.access$902((Entry)localObject2, new Editor((Entry)localObject2, null));
        return;
      }
    } while ((k == -1) && (i == "READ".length()) && (paramString.startsWith("READ")));
    throw new IOException("unexpected journal line: " + paramString);
  }
  
  private void rebuildJournal()
    throws IOException
  {
    for (;;)
    {
      Entry localEntry;
      try
      {
        if (journalWriter != null) {
          journalWriter.close();
        }
        BufferedSink localBufferedSink1 = Okio.buffer(fileSystem.sink(journalFileTmp));
        try
        {
          localBufferedSink1.writeUtf8("libcore.io.DiskLruCache").writeByte(10);
          localBufferedSink1.writeUtf8("1").writeByte(10);
          localBufferedSink1.writeDecimalLong(appVersion).writeByte(10);
          localBufferedSink1.writeDecimalLong(valueCount).writeByte(10);
          localBufferedSink1.writeByte(10);
          Iterator localIterator = lruEntries.values().iterator();
          if (!localIterator.hasNext()) {
            break;
          }
          localEntry = (Entry)localIterator.next();
          if (currentEditor != null)
          {
            localBufferedSink1.writeUtf8("DIRTY").writeByte(32);
            localBufferedSink1.writeUtf8(key);
            localBufferedSink1.writeByte(10);
            continue;
            localBufferedSink2 = finally;
          }
        }
        finally
        {
          localBufferedSink1.close();
        }
        localBufferedSink2.writeUtf8("CLEAN").writeByte(32);
      }
      finally {}
      localBufferedSink2.writeUtf8(key);
      localEntry.writeLengths(localBufferedSink2);
      localBufferedSink2.writeByte(10);
    }
    localBufferedSink2.close();
    if (fileSystem.exists(journalFile)) {
      fileSystem.rename(journalFile, journalFileBackup);
    }
    fileSystem.rename(journalFileTmp, journalFile);
    fileSystem.delete(journalFileBackup);
    journalWriter = newJournalWriter();
    hasJournalErrors = false;
  }
  
  private boolean removeEntry(Entry paramEntry)
    throws IOException
  {
    if (currentEditor != null) {
      Editor.access$1902(currentEditor, true);
    }
    int i = 0;
    while (i < valueCount)
    {
      fileSystem.delete(cleanFiles[i]);
      size -= lengths[i];
      lengths[i] = 0L;
      i += 1;
    }
    redundantOpCount += 1;
    journalWriter.writeUtf8("REMOVE").writeByte(32).writeUtf8(key).writeByte(10);
    lruEntries.remove(key);
    if (journalRebuildRequired()) {
      executor.execute(cleanupRunnable);
    }
    return true;
  }
  
  private void trimToSize()
    throws IOException
  {
    while (size > maxSize) {
      removeEntry((Entry)lruEntries.values().iterator().next());
    }
  }
  
  private void validateKey(String paramString)
  {
    if (!LEGAL_KEY_PATTERN.matcher(paramString).matches()) {
      throw new IllegalArgumentException("keys must match regex [a-z0-9_-]{1,120}: \"" + paramString + "\"");
    }
  }
  
  public void close()
    throws IOException
  {
    for (;;)
    {
      try
      {
        if ((!initialized) || (closed))
        {
          closed = true;
          return;
        }
        Entry[] arrayOfEntry = (Entry[])lruEntries.values().toArray(new Entry[lruEntries.size()]);
        int j = arrayOfEntry.length;
        int i = 0;
        if (i < j)
        {
          Entry localEntry = arrayOfEntry[i];
          if (currentEditor != null) {
            currentEditor.abort();
          }
        }
        else
        {
          trimToSize();
          journalWriter.close();
          journalWriter = null;
          closed = true;
          continue;
        }
        i += 1;
      }
      finally {}
    }
  }
  
  public void delete()
    throws IOException
  {
    close();
    fileSystem.deleteContents(directory);
  }
  
  public Editor edit(String paramString)
    throws IOException
  {
    return edit(paramString, -1L);
  }
  
  public void evictAll()
    throws IOException
  {
    try
    {
      initialize();
      Entry[] arrayOfEntry = (Entry[])lruEntries.values().toArray(new Entry[lruEntries.size()]);
      int j = arrayOfEntry.length;
      int i = 0;
      while (i < j)
      {
        removeEntry(arrayOfEntry[i]);
        i += 1;
      }
      return;
    }
    finally {}
  }
  
  /* Error */
  public void flush()
    throws IOException
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_0
    //   3: getfield 157	com/squareup/okhttp/internal/DiskLruCache:initialized	Z
    //   6: istore_1
    //   7: iload_1
    //   8: ifne +6 -> 14
    //   11: aload_0
    //   12: monitorexit
    //   13: return
    //   14: aload_0
    //   15: invokespecial 370	com/squareup/okhttp/internal/DiskLruCache:checkNotClosed	()V
    //   18: aload_0
    //   19: invokespecial 166	com/squareup/okhttp/internal/DiskLruCache:trimToSize	()V
    //   22: aload_0
    //   23: getfield 295	com/squareup/okhttp/internal/DiskLruCache:journalWriter	Lokio/BufferedSink;
    //   26: invokeinterface 320 1 0
    //   31: goto -20 -> 11
    //   34: astore_2
    //   35: aload_0
    //   36: monitorexit
    //   37: aload_2
    //   38: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	39	0	this	DiskLruCache
    //   6	2	1	bool	boolean
    //   34	4	2	localObject	Object
    // Exception table:
    //   from	to	target	type
    //   2	7	34	finally
    //   14	31	34	finally
  }
  
  /* Error */
  public Snapshot get(String paramString)
    throws IOException
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_0
    //   3: invokevirtual 368	com/squareup/okhttp/internal/DiskLruCache:initialize	()V
    //   6: aload_0
    //   7: invokespecial 370	com/squareup/okhttp/internal/DiskLruCache:checkNotClosed	()V
    //   10: aload_0
    //   11: aload_1
    //   12: invokespecial 373	com/squareup/okhttp/internal/DiskLruCache:validateKey	(Ljava/lang/String;)V
    //   15: aload_0
    //   16: getfield 123	com/squareup/okhttp/internal/DiskLruCache:lruEntries	Ljava/util/LinkedHashMap;
    //   19: aload_1
    //   20: invokevirtual 376	java/util/LinkedHashMap:get	(Ljava/lang/Object;)Ljava/lang/Object;
    //   23: checkcast 21	com/squareup/okhttp/internal/DiskLruCache$Entry
    //   26: astore_3
    //   27: aload_3
    //   28: ifnull +12 -> 40
    //   31: aload_3
    //   32: invokestatic 234	com/squareup/okhttp/internal/DiskLruCache$Entry:access$800	(Lcom/squareup/okhttp/internal/DiskLruCache$Entry;)Z
    //   35: istore_2
    //   36: iload_2
    //   37: ifne +9 -> 46
    //   40: aconst_null
    //   41: astore_1
    //   42: aload_0
    //   43: monitorexit
    //   44: aload_1
    //   45: areturn
    //   46: aload_3
    //   47: invokevirtual 555	com/squareup/okhttp/internal/DiskLruCache$Entry:snapshot	()Lcom/squareup/okhttp/internal/DiskLruCache$Snapshot;
    //   50: astore_3
    //   51: aload_3
    //   52: ifnonnull +8 -> 60
    //   55: aconst_null
    //   56: astore_1
    //   57: goto -15 -> 42
    //   60: aload_0
    //   61: aload_0
    //   62: getfield 207	com/squareup/okhttp/internal/DiskLruCache:redundantOpCount	I
    //   65: iconst_1
    //   66: iadd
    //   67: putfield 207	com/squareup/okhttp/internal/DiskLruCache:redundantOpCount	I
    //   70: aload_0
    //   71: getfield 295	com/squareup/okhttp/internal/DiskLruCache:journalWriter	Lokio/BufferedSink;
    //   74: ldc 54
    //   76: invokeinterface 301 2 0
    //   81: bipush 32
    //   83: invokeinterface 305 2 0
    //   88: aload_1
    //   89: invokeinterface 301 2 0
    //   94: bipush 10
    //   96: invokeinterface 305 2 0
    //   101: pop
    //   102: aload_3
    //   103: astore_1
    //   104: aload_0
    //   105: invokespecial 199	com/squareup/okhttp/internal/DiskLruCache:journalRebuildRequired	()Z
    //   108: ifeq -66 -> 42
    //   111: aload_0
    //   112: getfield 153	com/squareup/okhttp/internal/DiskLruCache:executor	Ljava/util/concurrent/Executor;
    //   115: aload_0
    //   116: getfield 130	com/squareup/okhttp/internal/DiskLruCache:cleanupRunnable	Ljava/lang/Runnable;
    //   119: invokeinterface 326 2 0
    //   124: aload_3
    //   125: astore_1
    //   126: goto -84 -> 42
    //   129: astore_1
    //   130: aload_0
    //   131: monitorexit
    //   132: aload_1
    //   133: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	134	0	this	DiskLruCache
    //   0	134	1	paramString	String
    //   35	2	2	bool	boolean
    //   26	99	3	localObject	Object
    // Exception table:
    //   from	to	target	type
    //   2	27	129	finally
    //   31	36	129	finally
    //   46	51	129	finally
    //   60	102	129	finally
    //   104	124	129	finally
  }
  
  public File getDirectory()
  {
    return directory;
  }
  
  public long getMaxSize()
  {
    try
    {
      long l = maxSize;
      return l;
    }
    finally
    {
      localObject = finally;
      throw ((Throwable)localObject);
    }
  }
  
  public void initialize()
    throws IOException
  {
    try
    {
      if ((!$assertionsDisabled) && (!Thread.holdsLock(this))) {
        throw new AssertionError();
      }
    }
    finally {}
    boolean bool = initialized;
    if (bool) {
      return;
    }
    if (fileSystem.exists(journalFileBackup))
    {
      if (!fileSystem.exists(journalFile)) {
        break label189;
      }
      fileSystem.delete(journalFileBackup);
    }
    for (;;)
    {
      bool = fileSystem.exists(journalFile);
      if (bool) {
        try
        {
          readJournal();
          processJournal();
          initialized = true;
        }
        catch (IOException localIOException)
        {
          Platform.get().logW("DiskLruCache " + directory + " is corrupt: " + localIOException.getMessage() + ", removing");
          delete();
          closed = false;
        }
      }
      rebuildJournal();
      initialized = true;
      break;
      label189:
      fileSystem.rename(journalFileBackup, journalFile);
    }
  }
  
  public boolean isClosed()
  {
    try
    {
      boolean bool = closed;
      return bool;
    }
    finally
    {
      localObject = finally;
      throw ((Throwable)localObject);
    }
  }
  
  /* Error */
  public boolean remove(String paramString)
    throws IOException
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_0
    //   3: invokevirtual 368	com/squareup/okhttp/internal/DiskLruCache:initialize	()V
    //   6: aload_0
    //   7: invokespecial 370	com/squareup/okhttp/internal/DiskLruCache:checkNotClosed	()V
    //   10: aload_0
    //   11: aload_1
    //   12: invokespecial 373	com/squareup/okhttp/internal/DiskLruCache:validateKey	(Ljava/lang/String;)V
    //   15: aload_0
    //   16: getfield 123	com/squareup/okhttp/internal/DiskLruCache:lruEntries	Ljava/util/LinkedHashMap;
    //   19: aload_1
    //   20: invokevirtual 376	java/util/LinkedHashMap:get	(Ljava/lang/Object;)Ljava/lang/Object;
    //   23: checkcast 21	com/squareup/okhttp/internal/DiskLruCache$Entry
    //   26: astore_1
    //   27: aload_1
    //   28: ifnonnull +9 -> 37
    //   31: iconst_0
    //   32: istore_2
    //   33: aload_0
    //   34: monitorexit
    //   35: iload_2
    //   36: ireturn
    //   37: aload_0
    //   38: aload_1
    //   39: invokespecial 193	com/squareup/okhttp/internal/DiskLruCache:removeEntry	(Lcom/squareup/okhttp/internal/DiskLruCache$Entry;)Z
    //   42: istore_2
    //   43: goto -10 -> 33
    //   46: astore_1
    //   47: aload_0
    //   48: monitorexit
    //   49: aload_1
    //   50: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	51	0	this	DiskLruCache
    //   0	51	1	paramString	String
    //   32	11	2	bool	boolean
    // Exception table:
    //   from	to	target	type
    //   2	27	46	finally
    //   37	43	46	finally
  }
  
  public void setMaxSize(long paramLong)
  {
    try
    {
      maxSize = paramLong;
      if (initialized) {
        executor.execute(cleanupRunnable);
      }
      return;
    }
    finally
    {
      localObject = finally;
      throw ((Throwable)localObject);
    }
  }
  
  public long size()
    throws IOException
  {
    try
    {
      initialize();
      long l = size;
      return l;
    }
    finally
    {
      localObject = finally;
      throw ((Throwable)localObject);
    }
  }
  
  public Iterator<Snapshot> snapshots()
    throws IOException
  {
    try
    {
      initialize();
      Iterator local3 = new Iterator()
      {
        final Iterator<DiskLruCache.Entry> delegate = new ArrayList(lruEntries.values()).iterator();
        DiskLruCache.Snapshot nextSnapshot;
        DiskLruCache.Snapshot removeSnapshot;
        
        public boolean hasNext()
        {
          if (nextSnapshot != null) {
            return true;
          }
          synchronized (DiskLruCache.this)
          {
            if (closed) {
              return false;
            }
            while (delegate.hasNext())
            {
              DiskLruCache.Snapshot localSnapshot = ((DiskLruCache.Entry)delegate.next()).snapshot();
              if (localSnapshot != null)
              {
                nextSnapshot = localSnapshot;
                return true;
              }
            }
          }
          return false;
        }
        
        public DiskLruCache.Snapshot next()
        {
          if (!hasNext()) {
            throw new NoSuchElementException();
          }
          removeSnapshot = nextSnapshot;
          nextSnapshot = null;
          return removeSnapshot;
        }
        
        public void remove()
        {
          if (removeSnapshot == null) {
            throw new IllegalStateException("remove() before next()");
          }
          try
          {
            remove(DiskLruCache.Snapshot.access$2100(removeSnapshot));
            removeSnapshot = null;
            return;
          }
          catch (IOException localIOException)
          {
            localIOException = localIOException;
            removeSnapshot = null;
            return;
          }
          finally
          {
            localObject = finally;
            removeSnapshot = null;
            throw ((Throwable)localObject);
          }
        }
      };
      return local3;
    }
    finally
    {
      localObject = finally;
      throw ((Throwable)localObject);
    }
  }
  
  public final class Editor
  {
    private boolean committed;
    private final DiskLruCache.Entry entry;
    private boolean hasErrors;
    private final boolean[] written;
    
    private Editor(DiskLruCache.Entry paramEntry)
    {
      entry = paramEntry;
      if (DiskLruCache.Entry.access$800(paramEntry)) {}
      for (this$1 = null;; this$1 = new boolean[valueCount])
      {
        written = DiskLruCache.this;
        return;
      }
    }
    
    public void abort()
      throws IOException
    {
      synchronized (DiskLruCache.this)
      {
        DiskLruCache.this.completeEdit(this, false);
        return;
      }
    }
    
    public void abortUnlessCommitted()
    {
      synchronized (DiskLruCache.this)
      {
        boolean bool = committed;
        if (bool) {}
      }
      try
      {
        DiskLruCache.this.completeEdit(this, false);
        return;
        localObject = finally;
        throw ((Throwable)localObject);
      }
      catch (IOException localIOException)
      {
        for (;;) {}
      }
    }
    
    public void commit()
      throws IOException
    {
      synchronized (DiskLruCache.this)
      {
        if (hasErrors)
        {
          DiskLruCache.this.completeEdit(this, false);
          DiskLruCache.this.removeEntry(entry);
          committed = true;
          return;
        }
        DiskLruCache.this.completeEdit(this, true);
      }
    }
    
    public Sink newSink(int paramInt)
      throws IOException
    {
      synchronized (DiskLruCache.this)
      {
        if (DiskLruCache.Entry.access$900(entry) != this) {
          throw new IllegalStateException();
        }
      }
      if (!DiskLruCache.Entry.access$800(entry)) {
        written[paramInt] = true;
      }
      Object localObject2 = DiskLruCache.Entry.access$1400(entry)[paramInt];
      try
      {
        localObject2 = fileSystem.sink((File)localObject2);
        localObject2 = new FaultHidingSink((Sink)localObject2)
        {
          protected void onException(IOException arg1)
          {
            synchronized (DiskLruCache.this)
            {
              DiskLruCache.Editor.access$1902(DiskLruCache.Editor.this, true);
              return;
            }
          }
        };
        return (Sink)localObject2;
      }
      catch (FileNotFoundException localFileNotFoundException)
      {
        Sink localSink = DiskLruCache.NULL_SINK;
        return localSink;
      }
    }
    
    public Source newSource(int paramInt)
      throws IOException
    {
      synchronized (DiskLruCache.this)
      {
        if (DiskLruCache.Entry.access$900(entry) != this) {
          throw new IllegalStateException();
        }
      }
      if (!DiskLruCache.Entry.access$800(entry)) {
        return null;
      }
      try
      {
        Source localSource = fileSystem.source(DiskLruCache.Entry.access$1300(entry)[paramInt]);
        return localSource;
      }
      catch (FileNotFoundException localFileNotFoundException) {}
      return null;
    }
  }
  
  private final class Entry
  {
    private final File[] cleanFiles;
    private DiskLruCache.Editor currentEditor;
    private final File[] dirtyFiles;
    private final String key;
    private final long[] lengths;
    private boolean readable;
    private long sequenceNumber;
    
    private Entry(String paramString)
    {
      key = paramString;
      lengths = new long[valueCount];
      cleanFiles = new File[valueCount];
      dirtyFiles = new File[valueCount];
      paramString = new StringBuilder(paramString).append('.');
      int j = paramString.length();
      int i = 0;
      while (i < valueCount)
      {
        paramString.append(i);
        cleanFiles[i] = new File(directory, paramString.toString());
        paramString.append(".tmp");
        dirtyFiles[i] = new File(directory, paramString.toString());
        paramString.setLength(j);
        i += 1;
      }
    }
    
    private IOException invalidLengths(String[] paramArrayOfString)
      throws IOException
    {
      throw new IOException("unexpected journal line: " + Arrays.toString(paramArrayOfString));
    }
    
    private void setLengths(String[] paramArrayOfString)
      throws IOException
    {
      if (paramArrayOfString.length != valueCount) {
        throw invalidLengths(paramArrayOfString);
      }
      int i = 0;
      try
      {
        while (i < paramArrayOfString.length)
        {
          lengths[i] = Long.parseLong(paramArrayOfString[i]);
          i += 1;
        }
        return;
      }
      catch (NumberFormatException localNumberFormatException)
      {
        throw invalidLengths(paramArrayOfString);
      }
    }
    
    DiskLruCache.Snapshot snapshot()
    {
      if (!Thread.holdsLock(DiskLruCache.this)) {
        throw new AssertionError();
      }
      Source[] arrayOfSource = new Source[valueCount];
      Object localObject = (long[])lengths.clone();
      int i = 0;
      try
      {
        while (i < valueCount)
        {
          arrayOfSource[i] = fileSystem.source(cleanFiles[i]);
          i += 1;
        }
        localObject = new DiskLruCache.Snapshot(DiskLruCache.this, key, sequenceNumber, arrayOfSource, (long[])localObject, null);
        return (DiskLruCache.Snapshot)localObject;
      }
      catch (FileNotFoundException localFileNotFoundException)
      {
        i = 0;
        while ((i < valueCount) && (arrayOfSource[i] != null))
        {
          Util.closeQuietly(arrayOfSource[i]);
          i += 1;
        }
      }
      return null;
    }
    
    void writeLengths(BufferedSink paramBufferedSink)
      throws IOException
    {
      long[] arrayOfLong = lengths;
      int j = arrayOfLong.length;
      int i = 0;
      while (i < j)
      {
        long l = arrayOfLong[i];
        paramBufferedSink.writeByte(32).writeDecimalLong(l);
        i += 1;
      }
    }
  }
  
  public final class Snapshot
    implements Closeable
  {
    private final String key;
    private final long[] lengths;
    private final long sequenceNumber;
    private final Source[] sources;
    
    private Snapshot(String paramString, long paramLong, Source[] paramArrayOfSource, long[] paramArrayOfLong)
    {
      key = paramString;
      sequenceNumber = paramLong;
      sources = paramArrayOfSource;
      lengths = paramArrayOfLong;
    }
    
    public void close()
    {
      Source[] arrayOfSource = sources;
      int j = arrayOfSource.length;
      int i = 0;
      while (i < j)
      {
        Util.closeQuietly(arrayOfSource[i]);
        i += 1;
      }
    }
    
    public DiskLruCache.Editor edit()
      throws IOException
    {
      return DiskLruCache.this.edit(key, sequenceNumber);
    }
    
    public long getLength(int paramInt)
    {
      return lengths[paramInt];
    }
    
    public Source getSource(int paramInt)
    {
      return sources[paramInt];
    }
    
    public String key()
    {
      return key;
    }
  }
}

/* Location:
 * Qualified Name:     com.squareup.okhttp.internal.DiskLruCache
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */