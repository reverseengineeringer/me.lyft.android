package com.squareup.okhttp;

import java.io.IOException;
import java.util.List;

class Call$ApplicationInterceptorChain
  implements Interceptor.Chain
{
  private final boolean forWebSocket;
  private final int index;
  private final Request request;
  
  Call$ApplicationInterceptorChain(Call paramCall, int paramInt, Request paramRequest, boolean paramBoolean)
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
    if (index < Call.access$300(this$0).interceptors().size())
    {
      paramRequest = new ApplicationInterceptorChain(this$0, index + 1, paramRequest, forWebSocket);
      Interceptor localInterceptor = (Interceptor)Call.access$300(this$0).interceptors().get(index);
      Response localResponse = localInterceptor.intercept(paramRequest);
      paramRequest = localResponse;
      if (localResponse == null) {
        throw new NullPointerException("application interceptor " + localInterceptor + " returned null");
      }
    }
    else
    {
      paramRequest = this$0.getResponse(paramRequest, forWebSocket);
    }
    return paramRequest;
  }
  
  public Request request()
  {
    return request;
  }
}

/* Location:
 * Qualified Name:     com.squareup.okhttp.Call.ApplicationInterceptorChain
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */