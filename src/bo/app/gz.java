package bo.app;

import java.io.BufferedWriter;
import java.io.Closeable;
import java.io.EOFException;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.io.PrintStream;
import java.io.Writer;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map.Entry;
import java.util.Set;
import java.util.concurrent.Callable;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

final class gz
  implements Closeable
{
  static final Pattern a = Pattern.compile("[a-z0-9_-]{1,64}");
  private static final OutputStream r = new hb();
  final ThreadPoolExecutor b = new ThreadPoolExecutor(0, 1, 60L, TimeUnit.SECONDS, new LinkedBlockingQueue());
  private final File c;
  private final File d;
  private final File e;
  private final File f;
  private final int g;
  private long h;
  private int i;
  private final int j;
  private long k = 0L;
  private int l = 0;
  private Writer m;
  private final LinkedHashMap<String, he> n = new LinkedHashMap(0, 0.75F, true);
  private int o;
  private long p = 0L;
  private final Callable<Void> q = new ha(this);
  
  private gz(File paramFile, long paramLong, int paramInt)
  {
    c = paramFile;
    g = 1;
    d = new File(paramFile, "journal");
    e = new File(paramFile, "journal.tmp");
    f = new File(paramFile, "journal.bkp");
    j = 1;
    h = paramLong;
    i = paramInt;
  }
  
  public static gz a(File paramFile, long paramLong, int paramInt)
  {
    if (paramLong <= 0L) {
      throw new IllegalArgumentException("maxSize <= 0");
    }
    if (paramInt <= 0) {
      throw new IllegalArgumentException("maxFileCount <= 0");
    }
    Object localObject = new File(paramFile, "journal.bkp");
    File localFile;
    if (((File)localObject).exists())
    {
      localFile = new File(paramFile, "journal");
      if (!localFile.exists()) {
        break label147;
      }
      ((File)localObject).delete();
    }
    for (;;)
    {
      localObject = new gz(paramFile, paramLong, paramInt);
      if (!d.exists()) {
        break label213;
      }
      try
      {
        ((gz)localObject).b();
        ((gz)localObject).c();
        m = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(d, true), hj.a));
        return (gz)localObject;
      }
      catch (IOException localIOException)
      {
        label147:
        System.out.println("DiskLruCache " + paramFile + " is corrupt: " + localIOException.getMessage() + ", removing");
        ((gz)localObject).close();
        hj.a(c);
      }
      a((File)localObject, localFile, false);
    }
    label213:
    paramFile.mkdirs();
    paramFile = new gz(paramFile, paramLong, paramInt);
    paramFile.d();
    return paramFile;
  }
  
  private void a(hc paramhc, boolean paramBoolean)
  {
    int i3 = 0;
    he localhe;
    try
    {
      localhe = a;
      if (d != paramhc) {
        throw new IllegalStateException();
      }
    }
    finally {}
    int i2 = i3;
    if (paramBoolean)
    {
      i2 = i3;
      if (!c)
      {
        int i1 = 0;
        for (;;)
        {
          i2 = i3;
          if (i1 >= j) {
            break;
          }
          if (b[i1] == 0)
          {
            paramhc.c();
            throw new IllegalStateException("Newly created entry didn't create value for index " + i1);
          }
          if (!localhe.b(i1).exists())
          {
            paramhc.c();
            return;
          }
          i1 += 1;
        }
      }
    }
    for (;;)
    {
      long l1;
      if (i2 < j)
      {
        paramhc = localhe.b(i2);
        if (paramBoolean)
        {
          if (paramhc.exists())
          {
            File localFile = localhe.a(i2);
            paramhc.renameTo(localFile);
            l1 = b[i2];
            long l2 = localFile.length();
            b[i2] = l2;
            k = (k - l1 + l2);
            l += 1;
          }
        }
        else {
          a(paramhc);
        }
      }
      else
      {
        o += 1;
        d = null;
        if ((c | paramBoolean))
        {
          c = true;
          m.write("CLEAN " + a + localhe.a() + '\n');
          if (paramBoolean)
          {
            l1 = p;
            p = (1L + l1);
            e = l1;
          }
        }
        for (;;)
        {
          m.flush();
          if ((k <= h) && (l <= i) && (!e())) {
            break;
          }
          b.submit(q);
          break;
          n.remove(a);
          m.write("REMOVE " + a + '\n');
        }
      }
      i2 += 1;
    }
  }
  
  private static void a(File paramFile)
  {
    if ((paramFile.exists()) && (!paramFile.delete())) {
      throw new IOException();
    }
  }
  
  private static void a(File paramFile1, File paramFile2, boolean paramBoolean)
  {
    if (paramBoolean) {
      a(paramFile2);
    }
    if (!paramFile1.renameTo(paramFile2)) {
      throw new IOException();
    }
  }
  
  private void b()
  {
    hh localhh = new hh(new FileInputStream(d), hj.a);
    int i1;
    label534:
    try
    {
      String str1 = localhh.a();
      localObject3 = localhh.a();
      localObject4 = localhh.a();
      str2 = localhh.a();
      String str3 = localhh.a();
      if ((!"libcore.io.DiskLruCache".equals(str1)) || (!"1".equals(localObject3)) || (!Integer.toString(g).equals(localObject4)) || (!Integer.toString(j).equals(str2)) || (!"".equals(str3))) {
        throw new IOException("unexpected journal header: [" + str1 + ", " + (String)localObject3 + ", " + str2 + ", " + str3 + "]");
      }
    }
    finally
    {
      Object localObject3;
      Object localObject4;
      String str2;
      hj.a(localhh);
      throw ((Throwable)localObject1);
      i1 = 0;
      int i2;
      try
      {
        str2 = localhh.a();
        i2 = str2.indexOf(' ');
        if (i2 == -1) {
          throw new IOException("unexpected journal line: " + str2);
        }
      }
      catch (EOFException localEOFException)
      {
        o = (i1 - n.size());
        hj.a(localhh);
        return;
      }
      int i3 = i2 + 1;
      int i4 = str2.indexOf(' ', i3);
      Object localObject2;
      if (i4 == -1)
      {
        localObject2 = str2.substring(i3);
        if ((i2 == 6) && (str2.startsWith("REMOVE")))
        {
          n.remove(localObject2);
          break label534;
        }
      }
      else
      {
        localObject2 = str2.substring(i3, i4);
      }
      for (;;)
      {
        localObject4 = (he)n.get(localObject2);
        localObject3 = localObject4;
        if (localObject4 == null)
        {
          localObject3 = new he(this, (String)localObject2, (byte)0);
          n.put(localObject2, localObject3);
        }
        if ((i4 != -1) && (i2 == 5) && (str2.startsWith("CLEAN")))
        {
          localObject2 = str2.substring(i4 + 1).split(" ");
          c = true;
          d = null;
          ((he)localObject3).a((String[])localObject2);
          break;
        }
        if ((i4 == -1) && (i2 == 5) && (str2.startsWith("DIRTY")))
        {
          d = new hc(this, (he)localObject3, (byte)0);
          break;
        }
        if ((i4 == -1) && (i2 == 4) && (str2.startsWith("READ"))) {
          break;
        }
        throw new IOException("unexpected journal line: " + str2);
      }
    }
  }
  
  private void c()
  {
    a(e);
    Iterator localIterator = n.values().iterator();
    while (localIterator.hasNext())
    {
      he localhe = (he)localIterator.next();
      int i1;
      if (d == null)
      {
        i1 = 0;
        while (i1 < j)
        {
          k += b[i1];
          l += 1;
          i1 += 1;
        }
      }
      else
      {
        d = null;
        i1 = 0;
        while (i1 < j)
        {
          a(localhe.a(i1));
          a(localhe.b(i1));
          i1 += 1;
        }
        localIterator.remove();
      }
    }
  }
  
  private void d()
  {
    for (;;)
    {
      try
      {
        if (m != null) {
          m.close();
        }
        BufferedWriter localBufferedWriter = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(e), hj.a));
        he localhe;
        try
        {
          localBufferedWriter.write("libcore.io.DiskLruCache");
          localBufferedWriter.write("\n");
          localBufferedWriter.write("1");
          localBufferedWriter.write("\n");
          localBufferedWriter.write(Integer.toString(g));
          localBufferedWriter.write("\n");
          localBufferedWriter.write(Integer.toString(j));
          localBufferedWriter.write("\n");
          localBufferedWriter.write("\n");
          Iterator localIterator = n.values().iterator();
          if (!localIterator.hasNext()) {
            break;
          }
          localhe = (he)localIterator.next();
          if (d != null)
          {
            localBufferedWriter.write("DIRTY " + a + '\n');
            continue;
            localObject1 = finally;
          }
        }
        finally
        {
          localBufferedWriter.close();
        }
        ((Writer)localObject1).write("CLEAN " + a + localhe.a() + '\n');
      }
      finally {}
    }
    ((Writer)localObject1).close();
    if (d.exists()) {
      a(d, f, true);
    }
    a(e, d, false);
    f.delete();
    m = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(d, true), hj.a));
  }
  
  private static void d(String paramString)
  {
    if (!a.matcher(paramString).matches()) {
      throw new IllegalArgumentException("keys must match regex [a-z0-9_-]{1,64}: \"" + paramString + "\"");
    }
  }
  
  private boolean e()
  {
    return (o >= 2000) && (o >= n.size());
  }
  
  private void f()
  {
    if (m == null) {
      throw new IllegalStateException("cache is closed");
    }
  }
  
  private void g()
  {
    while (k > h) {
      c((String)((Map.Entry)n.entrySet().iterator().next()).getKey());
    }
  }
  
  private void h()
  {
    while (l > i) {
      c((String)((Map.Entry)n.entrySet().iterator().next()).getKey());
    }
  }
  
  /* Error */
  public final hf a(String paramString)
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore 4
    //   3: aload_0
    //   4: monitorenter
    //   5: aload_0
    //   6: invokespecial 462	bo/app/gz:f	()V
    //   9: aload_1
    //   10: invokestatic 464	bo/app/gz:d	(Ljava/lang/String;)V
    //   13: aload_0
    //   14: getfield 69	bo/app/gz:n	Ljava/util/LinkedHashMap;
    //   17: aload_1
    //   18: invokevirtual 369	java/util/LinkedHashMap:get	(Ljava/lang/Object;)Ljava/lang/Object;
    //   21: checkcast 231	bo/app/he
    //   24: astore 6
    //   26: aload 6
    //   28: ifnonnull +10 -> 38
    //   31: aload 4
    //   33: astore_3
    //   34: aload_0
    //   35: monitorexit
    //   36: aload_3
    //   37: areturn
    //   38: aload 4
    //   40: astore_3
    //   41: aload 6
    //   43: getfield 240	bo/app/he:c	Z
    //   46: ifeq -12 -> 34
    //   49: aload_0
    //   50: getfield 119	bo/app/gz:j	I
    //   53: anewarray 102	java/io/File
    //   56: astore_3
    //   57: aload_0
    //   58: getfield 119	bo/app/gz:j	I
    //   61: anewarray 466	java/io/InputStream
    //   64: astore 5
    //   66: iconst_0
    //   67: istore_2
    //   68: iload_2
    //   69: aload_0
    //   70: getfield 119	bo/app/gz:j	I
    //   73: if_icmpge +74 -> 147
    //   76: aload 6
    //   78: iload_2
    //   79: invokevirtual 255	bo/app/he:a	(I)Ljava/io/File;
    //   82: astore 7
    //   84: aload_3
    //   85: iload_2
    //   86: aload 7
    //   88: aastore
    //   89: aload 5
    //   91: iload_2
    //   92: new 308	java/io/FileInputStream
    //   95: dup
    //   96: aload 7
    //   98: invokespecial 310	java/io/FileInputStream:<init>	(Ljava/io/File;)V
    //   101: aastore
    //   102: iload_2
    //   103: iconst_1
    //   104: iadd
    //   105: istore_2
    //   106: goto -38 -> 68
    //   109: astore_1
    //   110: iconst_0
    //   111: istore_2
    //   112: aload 4
    //   114: astore_3
    //   115: iload_2
    //   116: aload_0
    //   117: getfield 119	bo/app/gz:j	I
    //   120: if_icmpge -86 -> 34
    //   123: aload 4
    //   125: astore_3
    //   126: aload 5
    //   128: iload_2
    //   129: aaload
    //   130: ifnull -96 -> 34
    //   133: aload 5
    //   135: iload_2
    //   136: aaload
    //   137: invokestatic 341	bo/app/hj:a	(Ljava/io/Closeable;)V
    //   140: iload_2
    //   141: iconst_1
    //   142: iadd
    //   143: istore_2
    //   144: goto -32 -> 112
    //   147: aload_0
    //   148: aload_0
    //   149: getfield 269	bo/app/gz:o	I
    //   152: iconst_1
    //   153: iadd
    //   154: putfield 269	bo/app/gz:o	I
    //   157: aload_0
    //   158: getfield 170	bo/app/gz:m	Ljava/io/Writer;
    //   161: new 181	java/lang/StringBuilder
    //   164: dup
    //   165: ldc_w 468
    //   168: invokespecial 184	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   171: aload_1
    //   172: invokevirtual 193	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   175: bipush 10
    //   177: invokevirtual 279	java/lang/StringBuilder:append	(C)Ljava/lang/StringBuilder;
    //   180: invokevirtual 202	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   183: invokevirtual 471	java/io/Writer:append	(Ljava/lang/CharSequence;)Ljava/io/Writer;
    //   186: pop
    //   187: aload_0
    //   188: invokespecial 291	bo/app/gz:e	()Z
    //   191: ifeq +15 -> 206
    //   194: aload_0
    //   195: getfield 89	bo/app/gz:b	Ljava/util/concurrent/ThreadPoolExecutor;
    //   198: aload_0
    //   199: getfield 96	bo/app/gz:q	Ljava/util/concurrent/Callable;
    //   202: invokevirtual 295	java/util/concurrent/ThreadPoolExecutor:submit	(Ljava/util/concurrent/Callable;)Ljava/util/concurrent/Future;
    //   205: pop
    //   206: new 473	bo/app/hf
    //   209: dup
    //   210: aload_0
    //   211: aload_1
    //   212: aload 6
    //   214: getfield 286	bo/app/he:e	J
    //   217: aload_3
    //   218: aload 5
    //   220: aload 6
    //   222: getfield 262	bo/app/he:b	[J
    //   225: iconst_0
    //   226: invokespecial 476	bo/app/hf:<init>	(Lbo/app/gz;Ljava/lang/String;J[Ljava/io/File;[Ljava/io/InputStream;[JB)V
    //   229: astore_3
    //   230: goto -196 -> 34
    //   233: astore_1
    //   234: aload_0
    //   235: monitorexit
    //   236: aload_1
    //   237: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	238	0	this	gz
    //   0	238	1	paramString	String
    //   67	77	2	i1	int
    //   33	197	3	localObject1	Object
    //   1	123	4	localObject2	Object
    //   64	155	5	arrayOfInputStream	java.io.InputStream[]
    //   24	197	6	localhe	he
    //   82	15	7	localFile	File
    // Exception table:
    //   from	to	target	type
    //   68	84	109	java/io/FileNotFoundException
    //   89	102	109	java/io/FileNotFoundException
    //   5	26	233	finally
    //   41	66	233	finally
    //   68	84	233	finally
    //   89	102	233	finally
    //   115	123	233	finally
    //   133	140	233	finally
    //   147	206	233	finally
    //   206	230	233	finally
  }
  
  final hc b(String paramString)
  {
    for (;;)
    {
      hc localhc;
      try
      {
        f();
        d(paramString);
        he localhe = (he)n.get(paramString);
        if (-1L != -1L) {
          if (localhe != null)
          {
            long l1 = e;
            if (l1 == -1L) {}
          }
          else
          {
            paramString = null;
            return paramString;
          }
        }
        if (localhe == null)
        {
          localhe = new he(this, paramString, (byte)0);
          n.put(paramString, localhe);
          localhc = new hc(this, localhe, (byte)0);
          d = localhc;
          m.write("DIRTY " + paramString + '\n');
          m.flush();
          paramString = localhc;
          continue;
        }
        localhc = d;
      }
      finally {}
      if (localhc != null) {
        paramString = null;
      }
    }
  }
  
  public final boolean c(String paramString)
  {
    int i1 = 0;
    for (;;)
    {
      try
      {
        f();
        d(paramString);
        he localhe = (he)n.get(paramString);
        Object localObject;
        if (localhe != null)
        {
          localObject = d;
          if (localObject == null) {}
        }
        else
        {
          bool = false;
          return bool;
          k -= b[i1];
          l -= 1;
          b[i1] = 0L;
          i1 += 1;
        }
        if (i1 < j)
        {
          localObject = localhe.a(i1);
          if ((!((File)localObject).exists()) || (((File)localObject).delete())) {
            continue;
          }
          throw new IOException("failed to delete " + localObject);
        }
      }
      finally {}
      o += 1;
      m.append("REMOVE " + paramString + '\n');
      n.remove(paramString);
      if (e()) {
        b.submit(q);
      }
      boolean bool = true;
    }
  }
  
  public final void close()
  {
    for (;;)
    {
      try
      {
        Object localObject1 = m;
        if (localObject1 == null) {
          return;
        }
        localObject1 = new ArrayList(n.values()).iterator();
        if (((Iterator)localObject1).hasNext())
        {
          he localhe = (he)((Iterator)localObject1).next();
          if (d == null) {
            continue;
          }
          d.c();
          continue;
        }
        g();
      }
      finally {}
      h();
      m.close();
      m = null;
    }
  }
}

/* Location:
 * Qualified Name:     bo.app.gz
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */