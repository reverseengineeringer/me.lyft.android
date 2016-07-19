package com.squareup.okhttp;

import com.squareup.okhttp.internal.Internal;
import com.squareup.okhttp.internal.NamedRunnable;
import com.squareup.okhttp.internal.http.HttpEngine;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;

final class Call$AsyncCall
  extends NamedRunnable
{
  private final boolean forWebSocket;
  private final Callback responseCallback;
  
  private Call$AsyncCall(Call paramCall, Callback paramCallback, boolean paramBoolean)
  {
    super("OkHttp %s", new Object[] { originalRequest.urlString() });
    responseCallback = paramCallback;
    forWebSocket = paramBoolean;
  }
  
  void cancel()
  {
    this$0.cancel();
  }
  
  protected void execute()
  {
    int j = 0;
    int i = j;
    for (;;)
    {
      try
      {
        Object localObject1 = Call.access$100(this$0, forWebSocket);
        i = j;
        if (this$0.canceled)
        {
          i = 1;
          responseCallback.onFailure(this$0.originalRequest, new IOException("Canceled"));
          return;
        }
        i = 1;
        responseCallback.onResponse((Response)localObject1);
        continue;
        Request localRequest = this$0.engine.getRequest();
      }
      catch (IOException localIOException)
      {
        if (i != 0)
        {
          Internal.logger.log(Level.INFO, "Callback failure for " + Call.access$200(this$0), localIOException);
          return;
        }
        if (this$0.engine == null)
        {
          localObject1 = this$0.originalRequest;
          responseCallback.onFailure((Request)localObject1, localIOException);
        }
      }
      finally
      {
        Call.access$300(this$0).getDispatcher().finished(this);
      }
    }
  }
  
  Call get()
  {
    return this$0;
  }
  
  String host()
  {
    return this$0.originalRequest.httpUrl().host();
  }
  
  Request request()
  {
    return this$0.originalRequest;
  }
  
  Object tag()
  {
    return this$0.originalRequest.tag();
  }
}

/* Location:
 * Qualified Name:     com.squareup.okhttp.Call.AsyncCall
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */