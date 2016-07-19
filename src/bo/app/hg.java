package bo.app;

import android.graphics.Bitmap;
import android.graphics.Bitmap.CompressFormat;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;

public final class hg
  implements gw
{
  public static final Bitmap.CompressFormat a = Bitmap.CompressFormat.PNG;
  protected gz b;
  protected final hk c;
  protected int d = 32768;
  protected Bitmap.CompressFormat e = a;
  protected int f = 100;
  private File g;
  
  public hg(File paramFile1, File paramFile2, hk paramhk, long paramLong, int paramInt)
  {
    if (paramFile1 == null) {
      throw new IllegalArgumentException("cacheDir argument must be not null");
    }
    if (paramLong < 0L) {
      throw new IllegalArgumentException("cacheMaxSize argument must be positive number");
    }
    if (paramInt < 0) {
      throw new IllegalArgumentException("cacheMaxFileCount argument must be positive number");
    }
    if (paramhk == null) {
      throw new IllegalArgumentException("fileNameGenerator argument must be not null");
    }
    if (paramLong == 0L) {
      paramLong = Long.MAX_VALUE;
    }
    for (;;)
    {
      if (paramInt == 0) {
        paramInt = Integer.MAX_VALUE;
      }
      for (;;)
      {
        g = paramFile2;
        c = paramhk;
        a(paramFile1, paramFile2, paramLong, paramInt);
        return;
      }
    }
  }
  
  private void a(File paramFile1, File paramFile2, long paramLong, int paramInt)
  {
    try
    {
      b = gz.a(paramFile1, paramLong, paramInt);
      return;
    }
    catch (IOException paramFile1)
    {
      do
      {
        jx.a(paramFile1);
        if (paramFile2 != null) {
          a(paramFile2, null, paramLong, paramInt);
        }
      } while (b != null);
      throw paramFile1;
    }
  }
  
  private String b(String paramString)
  {
    return c.a(paramString);
  }
  
  /* Error */
  public final File a(String paramString)
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore 4
    //   3: aconst_null
    //   4: astore_2
    //   5: aload_0
    //   6: getfield 71	bo/app/hg:b	Lbo/app/gz;
    //   9: aload_0
    //   10: aload_1
    //   11: invokespecial 84	bo/app/hg:b	(Ljava/lang/String;)Ljava/lang/String;
    //   14: invokevirtual 87	bo/app/gz:a	(Ljava/lang/String;)Lbo/app/hf;
    //   17: astore_1
    //   18: aload_1
    //   19: ifnonnull +17 -> 36
    //   22: aload_2
    //   23: astore_3
    //   24: aload_1
    //   25: ifnull +9 -> 34
    //   28: aload_1
    //   29: invokevirtual 92	bo/app/hf:close	()V
    //   32: aload_2
    //   33: astore_3
    //   34: aload_3
    //   35: areturn
    //   36: aload_1
    //   37: astore_2
    //   38: aload_1
    //   39: getfield 95	bo/app/hf:a	[Ljava/io/File;
    //   42: iconst_0
    //   43: aaload
    //   44: astore_3
    //   45: aload_3
    //   46: astore_2
    //   47: goto -25 -> 22
    //   50: astore_3
    //   51: aconst_null
    //   52: astore_1
    //   53: aload_1
    //   54: astore_2
    //   55: aload_3
    //   56: invokestatic 76	bo/app/jx:a	(Ljava/lang/Throwable;)V
    //   59: aload 4
    //   61: astore_3
    //   62: aload_1
    //   63: ifnull -29 -> 34
    //   66: aload_1
    //   67: invokevirtual 92	bo/app/hf:close	()V
    //   70: aconst_null
    //   71: areturn
    //   72: astore_1
    //   73: aconst_null
    //   74: astore_2
    //   75: aload_2
    //   76: ifnull +7 -> 83
    //   79: aload_2
    //   80: invokevirtual 92	bo/app/hf:close	()V
    //   83: aload_1
    //   84: athrow
    //   85: astore_1
    //   86: goto -11 -> 75
    //   89: astore_3
    //   90: goto -37 -> 53
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	93	0	this	hg
    //   0	93	1	paramString	String
    //   4	76	2	localObject1	Object
    //   23	23	3	localObject2	Object
    //   50	6	3	localIOException1	IOException
    //   61	1	3	localObject3	Object
    //   89	1	3	localIOException2	IOException
    //   1	59	4	localObject4	Object
    // Exception table:
    //   from	to	target	type
    //   5	18	50	java/io/IOException
    //   5	18	72	finally
    //   38	45	85	finally
    //   55	59	85	finally
    //   38	45	89	java/io/IOException
  }
  
  public final boolean a(String paramString, Bitmap paramBitmap)
  {
    hc localhc = b.b(b(paramString));
    if (localhc == null) {
      return false;
    }
    paramString = new BufferedOutputStream(localhc.a(), d);
    boolean bool;
    try
    {
      bool = paramBitmap.compress(e, f, paramString);
      jv.a(paramString);
      if (bool)
      {
        localhc.b();
        return bool;
      }
    }
    finally
    {
      jv.a(paramString);
    }
    localhc.c();
    return bool;
  }
  
  public final boolean a(String paramString, InputStream paramInputStream, jw paramjw)
  {
    paramString = b.b(b(paramString));
    if (paramString == null) {
      return false;
    }
    BufferedOutputStream localBufferedOutputStream = new BufferedOutputStream(paramString.a(), d);
    try
    {
      boolean bool = jv.a(paramInputStream, localBufferedOutputStream, paramjw, d);
      jv.a(localBufferedOutputStream);
      if (bool)
      {
        paramString.b();
        return bool;
      }
      paramString.c();
      return bool;
    }
    finally
    {
      jv.a(localBufferedOutputStream);
      paramString.c();
    }
  }
}

/* Location:
 * Qualified Name:     bo.app.hg
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */