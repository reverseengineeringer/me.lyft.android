package com.squareup.okhttp.internal.http;

import java.io.IOException;
import okio.Sink;

public abstract interface CacheRequest
{
  public abstract void abort();
  
  public abstract Sink body()
    throws IOException;
}

/* Location:
 * Qualified Name:     com.squareup.okhttp.internal.http.CacheRequest
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */