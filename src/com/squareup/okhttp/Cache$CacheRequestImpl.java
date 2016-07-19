package com.squareup.okhttp;

import com.squareup.okhttp.internal.DiskLruCache.Editor;
import com.squareup.okhttp.internal.Util;
import com.squareup.okhttp.internal.http.CacheRequest;
import java.io.IOException;
import okio.ForwardingSink;
import okio.Sink;

final class Cache$CacheRequestImpl
  implements CacheRequest
{
  private Sink body;
  private Sink cacheOut;
  private boolean done;
  private final DiskLruCache.Editor editor;
  
  public Cache$CacheRequestImpl(final Cache paramCache, final DiskLruCache.Editor paramEditor)
    throws IOException
  {
    editor = paramEditor;
    cacheOut = paramEditor.newSink(1);
    body = new ForwardingSink(cacheOut)
    {
      public void close()
        throws IOException
      {
        synchronized (this$0)
        {
          if (done) {
            return;
          }
          Cache.CacheRequestImpl.access$702(Cache.CacheRequestImpl.this, true);
          Cache.access$808(this$0);
          super.close();
          paramEditor.commit();
          return;
        }
      }
    };
  }
  
  public void abort()
  {
    synchronized (this$0)
    {
      if (done) {
        return;
      }
      done = true;
      Cache.access$908(this$0);
      Util.closeQuietly(cacheOut);
      try
      {
        editor.abort();
        return;
      }
      catch (IOException localIOException) {}
    }
  }
  
  public Sink body()
  {
    return body;
  }
}

/* Location:
 * Qualified Name:     com.squareup.okhttp.Cache.CacheRequestImpl
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */