package com.crashlytics.android.core;

import io.fabric.sdk.android.Fabric;
import io.fabric.sdk.android.Logger;
import java.io.OutputStream;
import java.io.Writer;

final class ExceptionUtils
{
  private static String getMessage(Throwable paramThrowable)
  {
    paramThrowable = paramThrowable.getLocalizedMessage();
    if (paramThrowable == null) {
      return null;
    }
    return paramThrowable.replaceAll("(\r\n|\n|\f)", " ");
  }
  
  /* Error */
  private static void writeStackTrace(Throwable paramThrowable, OutputStream paramOutputStream)
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore_2
    //   2: aconst_null
    //   3: astore_3
    //   4: new 29	java/io/PrintWriter
    //   7: dup
    //   8: aload_1
    //   9: invokespecial 33	java/io/PrintWriter:<init>	(Ljava/io/OutputStream;)V
    //   12: astore_1
    //   13: aload_0
    //   14: aload_1
    //   15: invokestatic 36	com/crashlytics/android/core/ExceptionUtils:writeStackTrace	(Ljava/lang/Throwable;Ljava/io/Writer;)V
    //   18: aload_1
    //   19: ldc 38
    //   21: invokestatic 44	io/fabric/sdk/android/services/common/CommonUtils:closeOrLog	(Ljava/io/Closeable;Ljava/lang/String;)V
    //   24: return
    //   25: astore_1
    //   26: aload_3
    //   27: astore_0
    //   28: aload_0
    //   29: astore_2
    //   30: invokestatic 50	io/fabric/sdk/android/Fabric:getLogger	()Lio/fabric/sdk/android/Logger;
    //   33: ldc 52
    //   35: ldc 54
    //   37: aload_1
    //   38: invokeinterface 60 4 0
    //   43: aload_0
    //   44: ldc 38
    //   46: invokestatic 44	io/fabric/sdk/android/services/common/CommonUtils:closeOrLog	(Ljava/io/Closeable;Ljava/lang/String;)V
    //   49: return
    //   50: astore_0
    //   51: aload_2
    //   52: ldc 38
    //   54: invokestatic 44	io/fabric/sdk/android/services/common/CommonUtils:closeOrLog	(Ljava/io/Closeable;Ljava/lang/String;)V
    //   57: aload_0
    //   58: athrow
    //   59: astore_0
    //   60: aload_1
    //   61: astore_2
    //   62: goto -11 -> 51
    //   65: astore_2
    //   66: aload_1
    //   67: astore_0
    //   68: aload_2
    //   69: astore_1
    //   70: goto -42 -> 28
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	73	0	paramThrowable	Throwable
    //   0	73	1	paramOutputStream	OutputStream
    //   1	61	2	localObject1	Object
    //   65	4	2	localException	Exception
    //   3	24	3	localObject2	Object
    // Exception table:
    //   from	to	target	type
    //   4	13	25	java/lang/Exception
    //   4	13	50	finally
    //   30	43	50	finally
    //   13	18	59	finally
    //   13	18	65	java/lang/Exception
  }
  
  private static void writeStackTrace(Throwable paramThrowable, Writer paramWriter)
  {
    int i = 1;
    if (paramThrowable != null) {}
    for (;;)
    {
      String str;
      try
      {
        localObject = getMessage(paramThrowable);
        if (localObject == null) {
          break label166;
        }
      }
      catch (Exception paramThrowable)
      {
        int j;
        int k;
        Fabric.getLogger().e("CrashlyticsCore", "Could not write stack trace", paramThrowable);
      }
      paramWriter.write(str + paramThrowable.getClass().getName() + ": " + (String)localObject + "\n");
      j = 0;
      Object localObject = paramThrowable.getStackTrace();
      k = localObject.length;
      i = 0;
      if (i < k)
      {
        str = localObject[i];
        paramWriter.write("\tat " + str.toString() + "\n");
        i += 1;
      }
      else
      {
        paramThrowable = paramThrowable.getCause();
        i = j;
        break;
        return;
        for (;;)
        {
          if (i == 0) {
            break label173;
          }
          str = "";
          break;
          label166:
          localObject = "";
        }
        label173:
        str = "Caused by: ";
      }
    }
  }
  
  public static void writeStackTraceIfNotNull(Throwable paramThrowable, OutputStream paramOutputStream)
  {
    if (paramOutputStream != null) {
      writeStackTrace(paramThrowable, paramOutputStream);
    }
  }
}

/* Location:
 * Qualified Name:     com.crashlytics.android.core.ExceptionUtils
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */