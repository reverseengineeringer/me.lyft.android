package com.squareup.okhttp;

import com.squareup.okhttp.internal.DiskLruCache.Editor;
import java.io.IOException;
import okio.ForwardingSink;
import okio.Sink;

class Cache$CacheRequestImpl$1
  extends ForwardingSink
{
  Cache$CacheRequestImpl$1(Cache.CacheRequestImpl paramCacheRequestImpl, Sink paramSink, Cache paramCache, DiskLruCache.Editor paramEditor)
  {
    super(paramSink);
  }
  
  public void close()
    throws IOException
  {
    synchronized (this$1.this$0)
    {
      if (Cache.CacheRequestImpl.access$700(this$1)) {
        return;
      }
      Cache.CacheRequestImpl.access$702(this$1, true);
      Cache.access$808(this$1.this$0);
      super.close();
      val$editor.commit();
      return;
    }
  }
}

/* Location:
 * Qualified Name:     com.squareup.okhttp.Cache.CacheRequestImpl.1
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */