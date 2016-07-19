package com.squareup.okhttp.internal;

import java.io.IOException;
import okio.Sink;

class DiskLruCache$2
  extends FaultHidingSink
{
  static
  {
    if (!DiskLruCache.class.desiredAssertionStatus()) {}
    for (boolean bool = true;; bool = false)
    {
      $assertionsDisabled = bool;
      return;
    }
  }
  
  DiskLruCache$2(DiskLruCache paramDiskLruCache, Sink paramSink)
  {
    super(paramSink);
  }
  
  protected void onException(IOException paramIOException)
  {
    assert (Thread.holdsLock(this$0));
    DiskLruCache.access$602(this$0, true);
  }
}

/* Location:
 * Qualified Name:     com.squareup.okhttp.internal.DiskLruCache.2
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */