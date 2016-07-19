package io.fabric.sdk.android.services.network;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.Proxy;
import java.net.URL;

public abstract interface HttpRequest$ConnectionFactory
{
  public static final ConnectionFactory DEFAULT = new ConnectionFactory()
  {
    public HttpURLConnection create(URL paramAnonymousURL)
      throws IOException
    {
      return (HttpURLConnection)paramAnonymousURL.openConnection();
    }
    
    public HttpURLConnection create(URL paramAnonymousURL, Proxy paramAnonymousProxy)
      throws IOException
    {
      return (HttpURLConnection)paramAnonymousURL.openConnection(paramAnonymousProxy);
    }
  };
  
  public abstract HttpURLConnection create(URL paramURL)
    throws IOException;
  
  public abstract HttpURLConnection create(URL paramURL, Proxy paramProxy)
    throws IOException;
}

/* Location:
 * Qualified Name:     io.fabric.sdk.android.services.network.HttpRequest.ConnectionFactory
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */