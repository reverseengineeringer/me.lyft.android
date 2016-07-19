package com.squareup.okhttp;

import java.util.concurrent.TimeUnit;

public final class CacheControl$Builder
{
  int maxAgeSeconds = -1;
  int maxStaleSeconds = -1;
  int minFreshSeconds = -1;
  boolean noCache;
  boolean noStore;
  boolean noTransform;
  boolean onlyIfCached;
  
  public CacheControl build()
  {
    return new CacheControl(this, null);
  }
  
  public Builder maxAge(int paramInt, TimeUnit paramTimeUnit)
  {
    if (paramInt < 0) {
      throw new IllegalArgumentException("maxAge < 0: " + paramInt);
    }
    long l = paramTimeUnit.toSeconds(paramInt);
    if (l > 2147483647L) {}
    for (paramInt = Integer.MAX_VALUE;; paramInt = (int)l)
    {
      maxAgeSeconds = paramInt;
      return this;
    }
  }
  
  public Builder maxStale(int paramInt, TimeUnit paramTimeUnit)
  {
    if (paramInt < 0) {
      throw new IllegalArgumentException("maxStale < 0: " + paramInt);
    }
    long l = paramTimeUnit.toSeconds(paramInt);
    if (l > 2147483647L) {}
    for (paramInt = Integer.MAX_VALUE;; paramInt = (int)l)
    {
      maxStaleSeconds = paramInt;
      return this;
    }
  }
  
  public Builder minFresh(int paramInt, TimeUnit paramTimeUnit)
  {
    if (paramInt < 0) {
      throw new IllegalArgumentException("minFresh < 0: " + paramInt);
    }
    long l = paramTimeUnit.toSeconds(paramInt);
    if (l > 2147483647L) {}
    for (paramInt = Integer.MAX_VALUE;; paramInt = (int)l)
    {
      minFreshSeconds = paramInt;
      return this;
    }
  }
  
  public Builder noCache()
  {
    noCache = true;
    return this;
  }
  
  public Builder noStore()
  {
    noStore = true;
    return this;
  }
  
  public Builder noTransform()
  {
    noTransform = true;
    return this;
  }
  
  public Builder onlyIfCached()
  {
    onlyIfCached = true;
    return this;
  }
}

/* Location:
 * Qualified Name:     com.squareup.okhttp.CacheControl.Builder
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */