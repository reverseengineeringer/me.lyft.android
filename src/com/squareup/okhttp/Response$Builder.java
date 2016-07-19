package com.squareup.okhttp;

public class Response$Builder
{
  private ResponseBody body;
  private Response cacheResponse;
  private int code = -1;
  private Handshake handshake;
  private Headers.Builder headers;
  private String message;
  private Response networkResponse;
  private Response priorResponse;
  private Protocol protocol;
  private Request request;
  
  public Response$Builder()
  {
    headers = new Headers.Builder();
  }
  
  private Response$Builder(Response paramResponse)
  {
    request = Response.access$1100(paramResponse);
    protocol = Response.access$1200(paramResponse);
    code = Response.access$1300(paramResponse);
    message = Response.access$1400(paramResponse);
    handshake = Response.access$1500(paramResponse);
    headers = Response.access$1600(paramResponse).newBuilder();
    body = Response.access$1700(paramResponse);
    networkResponse = Response.access$1800(paramResponse);
    cacheResponse = Response.access$1900(paramResponse);
    priorResponse = Response.access$2000(paramResponse);
  }
  
  private void checkPriorResponse(Response paramResponse)
  {
    if (Response.access$1700(paramResponse) != null) {
      throw new IllegalArgumentException("priorResponse.body != null");
    }
  }
  
  private void checkSupportResponse(String paramString, Response paramResponse)
  {
    if (Response.access$1700(paramResponse) != null) {
      throw new IllegalArgumentException(paramString + ".body != null");
    }
    if (Response.access$1800(paramResponse) != null) {
      throw new IllegalArgumentException(paramString + ".networkResponse != null");
    }
    if (Response.access$1900(paramResponse) != null) {
      throw new IllegalArgumentException(paramString + ".cacheResponse != null");
    }
    if (Response.access$2000(paramResponse) != null) {
      throw new IllegalArgumentException(paramString + ".priorResponse != null");
    }
  }
  
  public Builder addHeader(String paramString1, String paramString2)
  {
    headers.add(paramString1, paramString2);
    return this;
  }
  
  public Builder body(ResponseBody paramResponseBody)
  {
    body = paramResponseBody;
    return this;
  }
  
  public Response build()
  {
    if (request == null) {
      throw new IllegalStateException("request == null");
    }
    if (protocol == null) {
      throw new IllegalStateException("protocol == null");
    }
    if (code < 0) {
      throw new IllegalStateException("code < 0: " + code);
    }
    return new Response(this, null);
  }
  
  public Builder cacheResponse(Response paramResponse)
  {
    if (paramResponse != null) {
      checkSupportResponse("cacheResponse", paramResponse);
    }
    cacheResponse = paramResponse;
    return this;
  }
  
  public Builder code(int paramInt)
  {
    code = paramInt;
    return this;
  }
  
  public Builder handshake(Handshake paramHandshake)
  {
    handshake = paramHandshake;
    return this;
  }
  
  public Builder header(String paramString1, String paramString2)
  {
    headers.set(paramString1, paramString2);
    return this;
  }
  
  public Builder headers(Headers paramHeaders)
  {
    headers = paramHeaders.newBuilder();
    return this;
  }
  
  public Builder message(String paramString)
  {
    message = paramString;
    return this;
  }
  
  public Builder networkResponse(Response paramResponse)
  {
    if (paramResponse != null) {
      checkSupportResponse("networkResponse", paramResponse);
    }
    networkResponse = paramResponse;
    return this;
  }
  
  public Builder priorResponse(Response paramResponse)
  {
    if (paramResponse != null) {
      checkPriorResponse(paramResponse);
    }
    priorResponse = paramResponse;
    return this;
  }
  
  public Builder protocol(Protocol paramProtocol)
  {
    protocol = paramProtocol;
    return this;
  }
  
  public Builder removeHeader(String paramString)
  {
    headers.removeAll(paramString);
    return this;
  }
  
  public Builder request(Request paramRequest)
  {
    request = paramRequest;
    return this;
  }
}

/* Location:
 * Qualified Name:     com.squareup.okhttp.Response.Builder
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */