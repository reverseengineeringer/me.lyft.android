package com.squareup.okhttp;

import com.squareup.okhttp.internal.http.HttpMethod;
import java.io.IOException;
import java.net.URI;
import java.net.URL;
import java.util.List;

public final class Request
{
  private final RequestBody body;
  private volatile CacheControl cacheControl;
  private final Headers headers;
  private volatile URI javaNetUri;
  private volatile URL javaNetUrl;
  private final String method;
  private final Object tag;
  private final HttpUrl url;
  
  private Request(Builder paramBuilder)
  {
    url = url;
    method = method;
    headers = headers.build();
    body = body;
    if (tag != null) {}
    for (paramBuilder = tag;; paramBuilder = this)
    {
      tag = paramBuilder;
      return;
    }
  }
  
  public RequestBody body()
  {
    return body;
  }
  
  public CacheControl cacheControl()
  {
    CacheControl localCacheControl = cacheControl;
    if (localCacheControl != null) {
      return localCacheControl;
    }
    localCacheControl = CacheControl.parse(headers);
    cacheControl = localCacheControl;
    return localCacheControl;
  }
  
  public String header(String paramString)
  {
    return headers.get(paramString);
  }
  
  public Headers headers()
  {
    return headers;
  }
  
  public List<String> headers(String paramString)
  {
    return headers.values(paramString);
  }
  
  public HttpUrl httpUrl()
  {
    return url;
  }
  
  public boolean isHttps()
  {
    return url.isHttps();
  }
  
  public String method()
  {
    return method;
  }
  
  public Builder newBuilder()
  {
    return new Builder(this, null);
  }
  
  public Object tag()
  {
    return tag;
  }
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder().append("Request{method=").append(method).append(", url=").append(url).append(", tag=");
    if (tag != this) {}
    for (Object localObject = tag;; localObject = null) {
      return localObject + '}';
    }
  }
  
  public URI uri()
    throws IOException
  {
    try
    {
      URI localURI = javaNetUri;
      if (localURI != null) {
        return localURI;
      }
      localURI = url.uri();
      javaNetUri = localURI;
      return localURI;
    }
    catch (IllegalStateException localIllegalStateException)
    {
      throw new IOException(localIllegalStateException.getMessage());
    }
  }
  
  public URL url()
  {
    URL localURL = javaNetUrl;
    if (localURL != null) {
      return localURL;
    }
    localURL = url.url();
    javaNetUrl = localURL;
    return localURL;
  }
  
  public String urlString()
  {
    return url.toString();
  }
  
  public static class Builder
  {
    private RequestBody body;
    private Headers.Builder headers;
    private String method;
    private Object tag;
    private HttpUrl url;
    
    public Builder()
    {
      method = "GET";
      headers = new Headers.Builder();
    }
    
    private Builder(Request paramRequest)
    {
      url = url;
      method = method;
      body = body;
      tag = tag;
      headers = headers.newBuilder();
    }
    
    public Builder addHeader(String paramString1, String paramString2)
    {
      headers.add(paramString1, paramString2);
      return this;
    }
    
    public Request build()
    {
      if (url == null) {
        throw new IllegalStateException("url == null");
      }
      return new Request(this, null);
    }
    
    public Builder cacheControl(CacheControl paramCacheControl)
    {
      paramCacheControl = paramCacheControl.toString();
      if (paramCacheControl.isEmpty()) {
        return removeHeader("Cache-Control");
      }
      return header("Cache-Control", paramCacheControl);
    }
    
    public Builder delete()
    {
      return delete(RequestBody.create(null, new byte[0]));
    }
    
    public Builder delete(RequestBody paramRequestBody)
    {
      return method("DELETE", paramRequestBody);
    }
    
    public Builder get()
    {
      return method("GET", null);
    }
    
    public Builder head()
    {
      return method("HEAD", null);
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
    
    public Builder method(String paramString, RequestBody paramRequestBody)
    {
      if ((paramString == null) || (paramString.length() == 0)) {
        throw new IllegalArgumentException("method == null || method.length() == 0");
      }
      if ((paramRequestBody != null) && (!HttpMethod.permitsRequestBody(paramString))) {
        throw new IllegalArgumentException("method " + paramString + " must not have a request body.");
      }
      if ((paramRequestBody == null) && (HttpMethod.requiresRequestBody(paramString))) {
        throw new IllegalArgumentException("method " + paramString + " must have a request body.");
      }
      method = paramString;
      body = paramRequestBody;
      return this;
    }
    
    public Builder patch(RequestBody paramRequestBody)
    {
      return method("PATCH", paramRequestBody);
    }
    
    public Builder post(RequestBody paramRequestBody)
    {
      return method("POST", paramRequestBody);
    }
    
    public Builder put(RequestBody paramRequestBody)
    {
      return method("PUT", paramRequestBody);
    }
    
    public Builder removeHeader(String paramString)
    {
      headers.removeAll(paramString);
      return this;
    }
    
    public Builder tag(Object paramObject)
    {
      tag = paramObject;
      return this;
    }
    
    public Builder url(HttpUrl paramHttpUrl)
    {
      if (paramHttpUrl == null) {
        throw new IllegalArgumentException("url == null");
      }
      url = paramHttpUrl;
      return this;
    }
    
    public Builder url(String paramString)
    {
      if (paramString == null) {
        throw new IllegalArgumentException("url == null");
      }
      String str;
      if (paramString.regionMatches(true, 0, "ws:", 0, 3)) {
        str = "http:" + paramString.substring(3);
      }
      for (;;)
      {
        paramString = HttpUrl.parse(str);
        if (paramString != null) {
          break;
        }
        throw new IllegalArgumentException("unexpected url: " + str);
        str = paramString;
        if (paramString.regionMatches(true, 0, "wss:", 0, 4)) {
          str = "https:" + paramString.substring(4);
        }
      }
      return url(paramString);
    }
    
    public Builder url(URL paramURL)
    {
      if (paramURL == null) {
        throw new IllegalArgumentException("url == null");
      }
      HttpUrl localHttpUrl = HttpUrl.get(paramURL);
      if (localHttpUrl == null) {
        throw new IllegalArgumentException("unexpected url: " + paramURL);
      }
      return url(localHttpUrl);
    }
  }
}

/* Location:
 * Qualified Name:     com.squareup.okhttp.Request
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */