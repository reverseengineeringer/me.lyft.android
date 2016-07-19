package com.squareup.okhttp.internal;

import com.squareup.okhttp.internal.io.FileSystem;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import okio.Sink;
import okio.Source;

public final class DiskLruCache$Editor
{
  private boolean committed;
  private final DiskLruCache.Entry entry;
  private boolean hasErrors;
  private final boolean[] written;
  
  private DiskLruCache$Editor(DiskLruCache paramDiskLruCache, DiskLruCache.Entry paramEntry)
  {
    entry = paramEntry;
    if (DiskLruCache.Entry.access$800(paramEntry)) {}
    for (paramDiskLruCache = null;; paramDiskLruCache = new boolean[DiskLruCache.access$2300(paramDiskLruCache)])
    {
      written = paramDiskLruCache;
      return;
    }
  }
  
  public void abort()
    throws IOException
  {
    synchronized (this$0)
    {
      DiskLruCache.access$2600(this$0, this, false);
      return;
    }
  }
  
  public void abortUnlessCommitted()
  {
    synchronized (this$0)
    {
      boolean bool = committed;
      if (bool) {}
    }
    try
    {
      DiskLruCache.access$2600(this$0, this, false);
      return;
      localObject = finally;
      throw ((Throwable)localObject);
    }
    catch (IOException localIOException)
    {
      for (;;) {}
    }
  }
  
  public void commit()
    throws IOException
  {
    synchronized (this$0)
    {
      if (hasErrors)
      {
        DiskLruCache.access$2600(this$0, this, false);
        DiskLruCache.access$2700(this$0, entry);
        committed = true;
        return;
      }
      DiskLruCache.access$2600(this$0, this, true);
    }
  }
  
  public Sink newSink(int paramInt)
    throws IOException
  {
    synchronized (this$0)
    {
      if (DiskLruCache.Entry.access$900(entry) != this) {
        throw new IllegalStateException();
      }
    }
    if (!DiskLruCache.Entry.access$800(entry)) {
      written[paramInt] = true;
    }
    Object localObject2 = DiskLruCache.Entry.access$1400(entry)[paramInt];
    try
    {
      localObject2 = DiskLruCache.access$2400(this$0).sink((File)localObject2);
      localObject2 = new FaultHidingSink((Sink)localObject2)
      {
        protected void onException(IOException arg1)
        {
          synchronized (this$0)
          {
            DiskLruCache.Editor.access$1902(DiskLruCache.Editor.this, true);
            return;
          }
        }
      };
      return (Sink)localObject2;
    }
    catch (FileNotFoundException localFileNotFoundException)
    {
      Sink localSink = DiskLruCache.access$2500();
      return localSink;
    }
  }
  
  public Source newSource(int paramInt)
    throws IOException
  {
    synchronized (this$0)
    {
      if (DiskLruCache.Entry.access$900(entry) != this) {
        throw new IllegalStateException();
      }
    }
    if (!DiskLruCache.Entry.access$800(entry)) {
      return null;
    }
    try
    {
      Source localSource = DiskLruCache.access$2400(this$0).source(DiskLruCache.Entry.access$1300(entry)[paramInt]);
      return localSource;
    }
    catch (FileNotFoundException localFileNotFoundException) {}
    return null;
  }
}

/* Location:
 * Qualified Name:     com.squareup.okhttp.internal.DiskLruCache.Editor
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */