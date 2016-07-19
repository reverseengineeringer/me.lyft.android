package com.squareup.okhttp;

import java.io.IOException;

public abstract interface Interceptor$Chain
{
  public abstract Connection connection();
  
  public abstract Response proceed(Request paramRequest)
    throws IOException;
  
  public abstract Request request();
}

/* Location:
 * Qualified Name:     com.squareup.okhttp.Interceptor.Chain
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */