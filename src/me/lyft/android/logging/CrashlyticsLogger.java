package me.lyft.android.logging;

import com.crashlytics.android.Crashlytics;
import me.lyft.android.common.Strings;

public class CrashlyticsLogger
  implements ILogger
{
  static void log(String paramString, Object... paramVarArgs)
  {
    try
    {
      Crashlytics.log(Strings.formatString(paramString, paramVarArgs));
      return;
    }
    catch (Exception paramString)
    {
      Crashlytics.logException(paramString);
    }
  }
  
  static void logException(Throwable paramThrowable)
  {
    Crashlytics.logException(paramThrowable);
  }
  
  /* Error */
  static void logExceptionAsString(Throwable paramThrowable)
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore_3
    //   2: aconst_null
    //   3: astore 4
    //   5: aconst_null
    //   6: astore_2
    //   7: aconst_null
    //   8: astore 5
    //   10: new 33	java/io/StringWriter
    //   13: dup
    //   14: invokespecial 34	java/io/StringWriter:<init>	()V
    //   17: astore_1
    //   18: new 36	java/io/PrintWriter
    //   21: dup
    //   22: aload_1
    //   23: invokespecial 39	java/io/PrintWriter:<init>	(Ljava/io/Writer;)V
    //   26: astore_2
    //   27: aload_0
    //   28: aload_2
    //   29: invokevirtual 45	java/lang/Throwable:printStackTrace	(Ljava/io/PrintWriter;)V
    //   32: aload_1
    //   33: invokevirtual 49	java/io/StringWriter:toString	()Ljava/lang/String;
    //   36: iconst_0
    //   37: anewarray 4	java/lang/Object
    //   40: invokestatic 51	me/lyft/android/logging/CrashlyticsLogger:log	(Ljava/lang/String;[Ljava/lang/Object;)V
    //   43: aload_2
    //   44: invokestatic 57	me/lyft/android/common/Closeables:closeQuietly	(Ljava/io/Closeable;)V
    //   47: aload_1
    //   48: invokestatic 57	me/lyft/android/common/Closeables:closeQuietly	(Ljava/io/Closeable;)V
    //   51: return
    //   52: astore_0
    //   53: aload 5
    //   55: astore_0
    //   56: aload 4
    //   58: astore_1
    //   59: aload_1
    //   60: invokestatic 57	me/lyft/android/common/Closeables:closeQuietly	(Ljava/io/Closeable;)V
    //   63: aload_0
    //   64: invokestatic 57	me/lyft/android/common/Closeables:closeQuietly	(Ljava/io/Closeable;)V
    //   67: return
    //   68: astore_1
    //   69: aload_2
    //   70: astore_0
    //   71: aload_3
    //   72: astore_2
    //   73: aload_2
    //   74: invokestatic 57	me/lyft/android/common/Closeables:closeQuietly	(Ljava/io/Closeable;)V
    //   77: aload_0
    //   78: invokestatic 57	me/lyft/android/common/Closeables:closeQuietly	(Ljava/io/Closeable;)V
    //   81: aload_1
    //   82: athrow
    //   83: astore 4
    //   85: aload_1
    //   86: astore_0
    //   87: aload_3
    //   88: astore_2
    //   89: aload 4
    //   91: astore_1
    //   92: goto -19 -> 73
    //   95: astore_3
    //   96: aload_1
    //   97: astore_0
    //   98: aload_3
    //   99: astore_1
    //   100: goto -27 -> 73
    //   103: astore_0
    //   104: aload_1
    //   105: astore_0
    //   106: aload 4
    //   108: astore_1
    //   109: goto -50 -> 59
    //   112: astore_0
    //   113: aload_1
    //   114: astore_0
    //   115: aload_2
    //   116: astore_1
    //   117: goto -58 -> 59
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	120	0	paramThrowable	Throwable
    //   17	43	1	localObject1	Object
    //   68	18	1	localObject2	Object
    //   91	26	1	localObject3	Object
    //   6	110	2	localObject4	Object
    //   1	87	3	localObject5	Object
    //   95	4	3	localObject6	Object
    //   3	54	4	localObject7	Object
    //   83	24	4	localObject8	Object
    //   8	46	5	localObject9	Object
    // Exception table:
    //   from	to	target	type
    //   10	18	52	java/lang/Exception
    //   10	18	68	finally
    //   18	27	83	finally
    //   27	43	95	finally
    //   18	27	103	java/lang/Exception
    //   27	43	112	java/lang/Exception
  }
  
  public void d(String paramString, Object... paramVarArgs)
  {
    log(paramString, paramVarArgs);
  }
  
  public void d(Throwable paramThrowable, String paramString, Object... paramVarArgs)
  {
    log(paramString, paramVarArgs);
    logExceptionAsString(paramThrowable);
  }
  
  public void e(String paramString, Object... paramVarArgs)
  {
    log(paramString, paramVarArgs);
  }
  
  public void e(Throwable paramThrowable, String paramString, Object... paramVarArgs)
  {
    log(paramString, paramVarArgs);
    logException(paramThrowable);
  }
  
  public void i(String paramString, Object... paramVarArgs)
  {
    log(paramString, paramVarArgs);
  }
  
  public void i(Throwable paramThrowable, String paramString, Object... paramVarArgs)
  {
    log(paramString, paramVarArgs);
    logExceptionAsString(paramThrowable);
  }
  
  public void v(String paramString, Object... paramVarArgs)
  {
    log(paramString, paramVarArgs);
  }
  
  public void v(Throwable paramThrowable, String paramString, Object... paramVarArgs)
  {
    log(paramString, paramVarArgs);
    logExceptionAsString(paramThrowable);
  }
  
  public void w(String paramString, Object... paramVarArgs)
  {
    log(paramString, paramVarArgs);
  }
  
  public void w(Throwable paramThrowable, String paramString, Object... paramVarArgs)
  {
    log(paramString, paramVarArgs);
    logExceptionAsString(paramThrowable);
  }
}

/* Location:
 * Qualified Name:     me.lyft.android.logging.CrashlyticsLogger
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */