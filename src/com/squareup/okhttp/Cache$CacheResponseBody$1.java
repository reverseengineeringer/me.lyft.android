package com.squareup.okhttp;

import com.squareup.okhttp.internal.DiskLruCache.Snapshot;
import java.io.IOException;
import okio.ForwardingSource;
import okio.Source;

class Cache$CacheResponseBody$1
  extends ForwardingSource
{
  Cache$CacheResponseBody$1(Cache.CacheResponseBody paramCacheResponseBody, Source paramSource, DiskLruCache.Snapshot paramSnapshot)
  {
    super(paramSource);
  }
  
  public void close()
    throws IOException
  {
    val$snapshot.close();
    super.close();
  }
}

/* Location:
 * Qualified Name:     com.squareup.okhttp.Cache.CacheResponseBody.1
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */