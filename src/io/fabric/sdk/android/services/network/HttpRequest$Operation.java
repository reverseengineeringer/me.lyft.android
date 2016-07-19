package io.fabric.sdk.android.services.network;

import java.io.IOException;
import java.util.concurrent.Callable;

public abstract class HttpRequest$Operation<V>
  implements Callable<V>
{
  /* Error */
  public V call()
    throws HttpRequest.HttpRequestException
  {
    // Byte code:
    //   0: iconst_0
    //   1: istore_1
    //   2: aload_0
    //   3: invokevirtual 24	io/fabric/sdk/android/services/network/HttpRequest$Operation:run	()Ljava/lang/Object;
    //   6: astore_2
    //   7: aload_0
    //   8: invokevirtual 27	io/fabric/sdk/android/services/network/HttpRequest$Operation:done	()V
    //   11: aload_2
    //   12: areturn
    //   13: astore_3
    //   14: iconst_0
    //   15: ifne -4 -> 11
    //   18: new 19	io/fabric/sdk/android/services/network/HttpRequest$HttpRequestException
    //   21: dup
    //   22: aload_3
    //   23: invokespecial 30	io/fabric/sdk/android/services/network/HttpRequest$HttpRequestException:<init>	(Ljava/io/IOException;)V
    //   26: athrow
    //   27: astore_2
    //   28: iconst_1
    //   29: istore_1
    //   30: aload_2
    //   31: athrow
    //   32: astore_2
    //   33: aload_0
    //   34: invokevirtual 27	io/fabric/sdk/android/services/network/HttpRequest$Operation:done	()V
    //   37: aload_2
    //   38: athrow
    //   39: astore_2
    //   40: iconst_1
    //   41: istore_1
    //   42: new 19	io/fabric/sdk/android/services/network/HttpRequest$HttpRequestException
    //   45: dup
    //   46: aload_2
    //   47: invokespecial 30	io/fabric/sdk/android/services/network/HttpRequest$HttpRequestException:<init>	(Ljava/io/IOException;)V
    //   50: athrow
    //   51: astore_3
    //   52: iload_1
    //   53: ifne -16 -> 37
    //   56: new 19	io/fabric/sdk/android/services/network/HttpRequest$HttpRequestException
    //   59: dup
    //   60: aload_3
    //   61: invokespecial 30	io/fabric/sdk/android/services/network/HttpRequest$HttpRequestException:<init>	(Ljava/io/IOException;)V
    //   64: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	65	0	this	Operation
    //   1	52	1	i	int
    //   6	6	2	localObject1	Object
    //   27	4	2	localHttpRequestException	HttpRequest.HttpRequestException
    //   32	6	2	localObject2	Object
    //   39	8	2	localIOException1	IOException
    //   13	10	3	localIOException2	IOException
    //   51	10	3	localIOException3	IOException
    // Exception table:
    //   from	to	target	type
    //   7	11	13	java/io/IOException
    //   2	7	27	io/fabric/sdk/android/services/network/HttpRequest$HttpRequestException
    //   2	7	32	finally
    //   30	32	32	finally
    //   42	51	32	finally
    //   2	7	39	java/io/IOException
    //   33	37	51	java/io/IOException
  }
  
  protected abstract void done()
    throws IOException;
  
  protected abstract V run()
    throws HttpRequest.HttpRequestException, IOException;
}

/* Location:
 * Qualified Name:     io.fabric.sdk.android.services.network.HttpRequest.Operation
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */