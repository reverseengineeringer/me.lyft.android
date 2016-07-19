package com.squareup.okhttp;

import java.io.IOException;

public abstract interface Callback
{
  public abstract void onFailure(Request paramRequest, IOException paramIOException);
  
  public abstract void onResponse(Response paramResponse)
    throws IOException;
}

/* Location:
 * Qualified Name:     com.squareup.okhttp.Callback
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */