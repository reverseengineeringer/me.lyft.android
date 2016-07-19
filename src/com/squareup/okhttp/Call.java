package com.squareup.okhttp;

import com.squareup.okhttp.internal.Internal;
import com.squareup.okhttp.internal.NamedRunnable;
import com.squareup.okhttp.internal.http.HttpEngine;
import java.io.IOException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Call
{
  volatile boolean canceled;
  private final OkHttpClient client;
  HttpEngine engine;
  private boolean executed;
  Request originalRequest;
  
  protected Call(OkHttpClient paramOkHttpClient, Request paramRequest)
  {
    client = paramOkHttpClient.copyWithDefaults();
    originalRequest = paramRequest;
  }
  
  private Response getResponseWithInterceptorChain(boolean paramBoolean)
    throws IOException
  {
    return new ApplicationInterceptorChain(0, originalRequest, paramBoolean).proceed(originalRequest);
  }
  
  private String toLoggableString()
  {
    if (canceled) {}
    for (String str = "canceled call";; str = "call")
    {
      HttpUrl localHttpUrl = originalRequest.httpUrl().resolve("/...");
      return str + " to " + localHttpUrl;
    }
  }
  
  public void cancel()
  {
    canceled = true;
    if (engine != null) {
      engine.cancel();
    }
  }
  
  public void enqueue(Callback paramCallback)
  {
    enqueue(paramCallback, false);
  }
  
  void enqueue(Callback paramCallback, boolean paramBoolean)
  {
    try
    {
      if (executed) {
        throw new IllegalStateException("Already Executed");
      }
    }
    finally {}
    executed = true;
    client.getDispatcher().enqueue(new AsyncCall(paramCallback, paramBoolean, null));
  }
  
  public Response execute()
    throws IOException
  {
    try
    {
      if (executed) {
        throw new IllegalStateException("Already Executed");
      }
    }
    finally {}
    executed = true;
    try
    {
      client.getDispatcher().executed(this);
      Response localResponse1 = getResponseWithInterceptorChain(false);
      if (localResponse1 == null) {
        throw new IOException("Canceled");
      }
    }
    finally
    {
      client.getDispatcher().finished(this);
    }
    client.getDispatcher().finished(this);
    return localResponse2;
  }
  
  /* Error */
  Response getResponse(Request paramRequest, boolean paramBoolean)
    throws IOException
  {
    // Byte code:
    //   0: aload_1
    //   1: invokevirtual 152	com/squareup/okhttp/Request:body	()Lcom/squareup/okhttp/RequestBody;
    //   4: astore 9
    //   6: aload_1
    //   7: astore 8
    //   9: aload 9
    //   11: ifnull +73 -> 84
    //   14: aload_1
    //   15: invokevirtual 156	com/squareup/okhttp/Request:newBuilder	()Lcom/squareup/okhttp/Request$Builder;
    //   18: astore_1
    //   19: aload 9
    //   21: invokevirtual 162	com/squareup/okhttp/RequestBody:contentType	()Lcom/squareup/okhttp/MediaType;
    //   24: astore 8
    //   26: aload 8
    //   28: ifnull +15 -> 43
    //   31: aload_1
    //   32: ldc -92
    //   34: aload 8
    //   36: invokevirtual 167	com/squareup/okhttp/MediaType:toString	()Ljava/lang/String;
    //   39: invokevirtual 173	com/squareup/okhttp/Request$Builder:header	(Ljava/lang/String;Ljava/lang/String;)Lcom/squareup/okhttp/Request$Builder;
    //   42: pop
    //   43: aload 9
    //   45: invokevirtual 177	com/squareup/okhttp/RequestBody:contentLength	()J
    //   48: lstore 6
    //   50: lload 6
    //   52: ldc2_w 178
    //   55: lcmp
    //   56: ifeq +78 -> 134
    //   59: aload_1
    //   60: ldc -75
    //   62: lload 6
    //   64: invokestatic 186	java/lang/Long:toString	(J)Ljava/lang/String;
    //   67: invokevirtual 173	com/squareup/okhttp/Request$Builder:header	(Ljava/lang/String;Ljava/lang/String;)Lcom/squareup/okhttp/Request$Builder;
    //   70: pop
    //   71: aload_1
    //   72: ldc -68
    //   74: invokevirtual 192	com/squareup/okhttp/Request$Builder:removeHeader	(Ljava/lang/String;)Lcom/squareup/okhttp/Request$Builder;
    //   77: pop
    //   78: aload_1
    //   79: invokevirtual 196	com/squareup/okhttp/Request$Builder:build	()Lcom/squareup/okhttp/Request;
    //   82: astore 8
    //   84: aload_0
    //   85: new 103	com/squareup/okhttp/internal/http/HttpEngine
    //   88: dup
    //   89: aload_0
    //   90: getfield 34	com/squareup/okhttp/Call:client	Lcom/squareup/okhttp/OkHttpClient;
    //   93: aload 8
    //   95: iconst_0
    //   96: iconst_0
    //   97: iload_2
    //   98: aconst_null
    //   99: aconst_null
    //   100: aconst_null
    //   101: invokespecial 199	com/squareup/okhttp/internal/http/HttpEngine:<init>	(Lcom/squareup/okhttp/OkHttpClient;Lcom/squareup/okhttp/Request;ZZZLcom/squareup/okhttp/internal/http/StreamAllocation;Lcom/squareup/okhttp/internal/http/RetryableSink;Lcom/squareup/okhttp/Response;)V
    //   104: putfield 101	com/squareup/okhttp/Call:engine	Lcom/squareup/okhttp/internal/http/HttpEngine;
    //   107: iconst_0
    //   108: istore 4
    //   110: aload_0
    //   111: getfield 65	com/squareup/okhttp/Call:canceled	Z
    //   114: ifeq +39 -> 153
    //   117: aload_0
    //   118: getfield 101	com/squareup/okhttp/Call:engine	Lcom/squareup/okhttp/internal/http/HttpEngine;
    //   121: invokevirtual 202	com/squareup/okhttp/internal/http/HttpEngine:releaseStreamAllocation	()V
    //   124: new 41	java/io/IOException
    //   127: dup
    //   128: ldc -118
    //   130: invokespecial 139	java/io/IOException:<init>	(Ljava/lang/String;)V
    //   133: athrow
    //   134: aload_1
    //   135: ldc -68
    //   137: ldc -52
    //   139: invokevirtual 173	com/squareup/okhttp/Request$Builder:header	(Ljava/lang/String;Ljava/lang/String;)Lcom/squareup/okhttp/Request$Builder;
    //   142: pop
    //   143: aload_1
    //   144: ldc -75
    //   146: invokevirtual 192	com/squareup/okhttp/Request$Builder:removeHeader	(Ljava/lang/String;)Lcom/squareup/okhttp/Request$Builder;
    //   149: pop
    //   150: goto -72 -> 78
    //   153: iconst_1
    //   154: istore 5
    //   156: iload 5
    //   158: istore_3
    //   159: aload_0
    //   160: getfield 101	com/squareup/okhttp/Call:engine	Lcom/squareup/okhttp/internal/http/HttpEngine;
    //   163: invokevirtual 207	com/squareup/okhttp/internal/http/HttpEngine:sendRequest	()V
    //   166: iload 5
    //   168: istore_3
    //   169: aload_0
    //   170: getfield 101	com/squareup/okhttp/Call:engine	Lcom/squareup/okhttp/internal/http/HttpEngine;
    //   173: invokevirtual 210	com/squareup/okhttp/internal/http/HttpEngine:readResponse	()V
    //   176: iconst_0
    //   177: ifeq +13 -> 190
    //   180: aload_0
    //   181: getfield 101	com/squareup/okhttp/Call:engine	Lcom/squareup/okhttp/internal/http/HttpEngine;
    //   184: invokevirtual 214	com/squareup/okhttp/internal/http/HttpEngine:close	()Lcom/squareup/okhttp/internal/http/StreamAllocation;
    //   187: invokevirtual 219	com/squareup/okhttp/internal/http/StreamAllocation:release	()V
    //   190: aload_0
    //   191: getfield 101	com/squareup/okhttp/Call:engine	Lcom/squareup/okhttp/internal/http/HttpEngine;
    //   194: invokevirtual 221	com/squareup/okhttp/internal/http/HttpEngine:getResponse	()Lcom/squareup/okhttp/Response;
    //   197: astore 9
    //   199: aload_0
    //   200: getfield 101	com/squareup/okhttp/Call:engine	Lcom/squareup/okhttp/internal/http/HttpEngine;
    //   203: invokevirtual 224	com/squareup/okhttp/internal/http/HttpEngine:followUpRequest	()Lcom/squareup/okhttp/Request;
    //   206: astore 10
    //   208: aload 10
    //   210: ifnonnull +145 -> 355
    //   213: iload_2
    //   214: ifne +10 -> 224
    //   217: aload_0
    //   218: getfield 101	com/squareup/okhttp/Call:engine	Lcom/squareup/okhttp/internal/http/HttpEngine;
    //   221: invokevirtual 202	com/squareup/okhttp/internal/http/HttpEngine:releaseStreamAllocation	()V
    //   224: aload 9
    //   226: areturn
    //   227: astore_1
    //   228: iload 5
    //   230: istore_3
    //   231: aload_1
    //   232: invokevirtual 228	com/squareup/okhttp/internal/http/RequestException:getCause	()Ljava/io/IOException;
    //   235: athrow
    //   236: astore_1
    //   237: iload_3
    //   238: ifeq +13 -> 251
    //   241: aload_0
    //   242: getfield 101	com/squareup/okhttp/Call:engine	Lcom/squareup/okhttp/internal/http/HttpEngine;
    //   245: invokevirtual 214	com/squareup/okhttp/internal/http/HttpEngine:close	()Lcom/squareup/okhttp/internal/http/StreamAllocation;
    //   248: invokevirtual 219	com/squareup/okhttp/internal/http/StreamAllocation:release	()V
    //   251: aload_1
    //   252: athrow
    //   253: astore_1
    //   254: iload 5
    //   256: istore_3
    //   257: aload_0
    //   258: getfield 101	com/squareup/okhttp/Call:engine	Lcom/squareup/okhttp/internal/http/HttpEngine;
    //   261: aload_1
    //   262: invokevirtual 232	com/squareup/okhttp/internal/http/HttpEngine:recover	(Lcom/squareup/okhttp/internal/http/RouteException;)Lcom/squareup/okhttp/internal/http/HttpEngine;
    //   265: astore 8
    //   267: aload 8
    //   269: ifnull +28 -> 297
    //   272: iconst_0
    //   273: istore_3
    //   274: aload_0
    //   275: aload 8
    //   277: putfield 101	com/squareup/okhttp/Call:engine	Lcom/squareup/okhttp/internal/http/HttpEngine;
    //   280: iconst_0
    //   281: ifeq -171 -> 110
    //   284: aload_0
    //   285: getfield 101	com/squareup/okhttp/Call:engine	Lcom/squareup/okhttp/internal/http/HttpEngine;
    //   288: invokevirtual 214	com/squareup/okhttp/internal/http/HttpEngine:close	()Lcom/squareup/okhttp/internal/http/StreamAllocation;
    //   291: invokevirtual 219	com/squareup/okhttp/internal/http/StreamAllocation:release	()V
    //   294: goto -184 -> 110
    //   297: iload 5
    //   299: istore_3
    //   300: aload_1
    //   301: invokevirtual 235	com/squareup/okhttp/internal/http/RouteException:getLastConnectException	()Ljava/io/IOException;
    //   304: athrow
    //   305: astore_1
    //   306: iload 5
    //   308: istore_3
    //   309: aload_0
    //   310: getfield 101	com/squareup/okhttp/Call:engine	Lcom/squareup/okhttp/internal/http/HttpEngine;
    //   313: aload_1
    //   314: aconst_null
    //   315: invokevirtual 238	com/squareup/okhttp/internal/http/HttpEngine:recover	(Ljava/io/IOException;Lokio/Sink;)Lcom/squareup/okhttp/internal/http/HttpEngine;
    //   318: astore 8
    //   320: aload 8
    //   322: ifnull +28 -> 350
    //   325: iconst_0
    //   326: istore_3
    //   327: aload_0
    //   328: aload 8
    //   330: putfield 101	com/squareup/okhttp/Call:engine	Lcom/squareup/okhttp/internal/http/HttpEngine;
    //   333: iconst_0
    //   334: ifeq -224 -> 110
    //   337: aload_0
    //   338: getfield 101	com/squareup/okhttp/Call:engine	Lcom/squareup/okhttp/internal/http/HttpEngine;
    //   341: invokevirtual 214	com/squareup/okhttp/internal/http/HttpEngine:close	()Lcom/squareup/okhttp/internal/http/StreamAllocation;
    //   344: invokevirtual 219	com/squareup/okhttp/internal/http/StreamAllocation:release	()V
    //   347: goto -237 -> 110
    //   350: iload 5
    //   352: istore_3
    //   353: aload_1
    //   354: athrow
    //   355: aload_0
    //   356: getfield 101	com/squareup/okhttp/Call:engine	Lcom/squareup/okhttp/internal/http/HttpEngine;
    //   359: invokevirtual 214	com/squareup/okhttp/internal/http/HttpEngine:close	()Lcom/squareup/okhttp/internal/http/StreamAllocation;
    //   362: astore 8
    //   364: iload 4
    //   366: iconst_1
    //   367: iadd
    //   368: istore 4
    //   370: iload 4
    //   372: bipush 20
    //   374: if_icmple +36 -> 410
    //   377: aload 8
    //   379: invokevirtual 219	com/squareup/okhttp/internal/http/StreamAllocation:release	()V
    //   382: new 240	java/net/ProtocolException
    //   385: dup
    //   386: new 83	java/lang/StringBuilder
    //   389: dup
    //   390: invokespecial 84	java/lang/StringBuilder:<init>	()V
    //   393: ldc -14
    //   395: invokevirtual 88	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   398: iload 4
    //   400: invokevirtual 245	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   403: invokevirtual 96	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   406: invokespecial 246	java/net/ProtocolException:<init>	(Ljava/lang/String;)V
    //   409: athrow
    //   410: aload 8
    //   412: astore_1
    //   413: aload_0
    //   414: getfield 101	com/squareup/okhttp/Call:engine	Lcom/squareup/okhttp/internal/http/HttpEngine;
    //   417: aload 10
    //   419: invokevirtual 73	com/squareup/okhttp/Request:httpUrl	()Lcom/squareup/okhttp/HttpUrl;
    //   422: invokevirtual 250	com/squareup/okhttp/internal/http/HttpEngine:sameConnection	(Lcom/squareup/okhttp/HttpUrl;)Z
    //   425: ifne +10 -> 435
    //   428: aload 8
    //   430: invokevirtual 219	com/squareup/okhttp/internal/http/StreamAllocation:release	()V
    //   433: aconst_null
    //   434: astore_1
    //   435: aload_0
    //   436: new 103	com/squareup/okhttp/internal/http/HttpEngine
    //   439: dup
    //   440: aload_0
    //   441: getfield 34	com/squareup/okhttp/Call:client	Lcom/squareup/okhttp/OkHttpClient;
    //   444: aload 10
    //   446: iconst_0
    //   447: iconst_0
    //   448: iload_2
    //   449: aload_1
    //   450: aconst_null
    //   451: aload 9
    //   453: invokespecial 199	com/squareup/okhttp/internal/http/HttpEngine:<init>	(Lcom/squareup/okhttp/OkHttpClient;Lcom/squareup/okhttp/Request;ZZZLcom/squareup/okhttp/internal/http/StreamAllocation;Lcom/squareup/okhttp/internal/http/RetryableSink;Lcom/squareup/okhttp/Response;)V
    //   456: putfield 101	com/squareup/okhttp/Call:engine	Lcom/squareup/okhttp/internal/http/HttpEngine;
    //   459: goto -349 -> 110
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	462	0	this	Call
    //   0	462	1	paramRequest	Request
    //   0	462	2	paramBoolean	boolean
    //   158	195	3	i	int
    //   108	291	4	j	int
    //   154	197	5	k	int
    //   48	15	6	l	long
    //   7	422	8	localObject1	Object
    //   4	448	9	localObject2	Object
    //   206	239	10	localRequest	Request
    // Exception table:
    //   from	to	target	type
    //   159	166	227	com/squareup/okhttp/internal/http/RequestException
    //   169	176	227	com/squareup/okhttp/internal/http/RequestException
    //   159	166	236	finally
    //   169	176	236	finally
    //   231	236	236	finally
    //   257	267	236	finally
    //   274	280	236	finally
    //   300	305	236	finally
    //   309	320	236	finally
    //   327	333	236	finally
    //   353	355	236	finally
    //   159	166	253	com/squareup/okhttp/internal/http/RouteException
    //   169	176	253	com/squareup/okhttp/internal/http/RouteException
    //   159	166	305	java/io/IOException
    //   169	176	305	java/io/IOException
  }
  
  public boolean isCanceled()
  {
    return canceled;
  }
  
  public boolean isExecuted()
  {
    try
    {
      boolean bool = executed;
      return bool;
    }
    finally
    {
      localObject = finally;
      throw ((Throwable)localObject);
    }
  }
  
  Object tag()
  {
    return originalRequest.tag();
  }
  
  class ApplicationInterceptorChain
    implements Interceptor.Chain
  {
    private final boolean forWebSocket;
    private final int index;
    private final Request request;
    
    ApplicationInterceptorChain(int paramInt, Request paramRequest, boolean paramBoolean)
    {
      index = paramInt;
      request = paramRequest;
      forWebSocket = paramBoolean;
    }
    
    public Connection connection()
    {
      return null;
    }
    
    public Response proceed(Request paramRequest)
      throws IOException
    {
      if (index < client.interceptors().size())
      {
        paramRequest = new ApplicationInterceptorChain(Call.this, index + 1, paramRequest, forWebSocket);
        Interceptor localInterceptor = (Interceptor)client.interceptors().get(index);
        Response localResponse = localInterceptor.intercept(paramRequest);
        paramRequest = localResponse;
        if (localResponse == null) {
          throw new NullPointerException("application interceptor " + localInterceptor + " returned null");
        }
      }
      else
      {
        paramRequest = getResponse(paramRequest, forWebSocket);
      }
      return paramRequest;
    }
    
    public Request request()
    {
      return request;
    }
  }
  
  final class AsyncCall
    extends NamedRunnable
  {
    private final boolean forWebSocket;
    private final Callback responseCallback;
    
    private AsyncCall(Callback paramCallback, boolean paramBoolean)
    {
      super(new Object[] { originalRequest.urlString() });
      responseCallback = paramCallback;
      forWebSocket = paramBoolean;
    }
    
    void cancel()
    {
      Call.this.cancel();
    }
    
    protected void execute()
    {
      int j = 0;
      int i = j;
      for (;;)
      {
        try
        {
          Object localObject1 = Call.this.getResponseWithInterceptorChain(forWebSocket);
          i = j;
          if (canceled)
          {
            i = 1;
            responseCallback.onFailure(originalRequest, new IOException("Canceled"));
            return;
          }
          i = 1;
          responseCallback.onResponse((Response)localObject1);
          continue;
          Request localRequest = engine.getRequest();
        }
        catch (IOException localIOException)
        {
          if (i != 0)
          {
            Internal.logger.log(Level.INFO, "Callback failure for " + Call.this.toLoggableString(), localIOException);
            return;
          }
          if (engine == null)
          {
            localObject1 = originalRequest;
            responseCallback.onFailure((Request)localObject1, localIOException);
          }
        }
        finally
        {
          client.getDispatcher().finished(this);
        }
      }
    }
    
    Call get()
    {
      return Call.this;
    }
    
    String host()
    {
      return originalRequest.httpUrl().host();
    }
    
    Request request()
    {
      return originalRequest;
    }
    
    Object tag()
    {
      return originalRequest.tag();
    }
  }
}

/* Location:
 * Qualified Name:     com.squareup.okhttp.Call
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */