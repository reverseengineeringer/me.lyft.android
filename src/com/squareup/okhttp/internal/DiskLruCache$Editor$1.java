package com.squareup.okhttp.internal;

import java.io.IOException;
import okio.Sink;

class DiskLruCache$Editor$1
  extends FaultHidingSink
{
  DiskLruCache$Editor$1(DiskLruCache.Editor paramEditor, Sink paramSink)
  {
    super(paramSink);
  }
  
  protected void onException(IOException arg1)
  {
    synchronized (this$1.this$0)
    {
      DiskLruCache.Editor.access$1902(this$1, true);
      return;
    }
  }
}

/* Location:
 * Qualified Name:     com.squareup.okhttp.internal.DiskLruCache.Editor.1
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */