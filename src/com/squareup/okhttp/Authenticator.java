package com.squareup.okhttp;

import java.io.IOException;
import java.net.Proxy;

public abstract interface Authenticator
{
  public abstract Request authenticate(Proxy paramProxy, Response paramResponse)
    throws IOException;
  
  public abstract Request authenticateProxy(Proxy paramProxy, Response paramResponse)
    throws IOException;
}

/* Location:
 * Qualified Name:     com.squareup.okhttp.Authenticator
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */