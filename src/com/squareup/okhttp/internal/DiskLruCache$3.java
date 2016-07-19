package com.squareup.okhttp.internal;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.NoSuchElementException;

class DiskLruCache$3
  implements Iterator<DiskLruCache.Snapshot>
{
  final Iterator<DiskLruCache.Entry> delegate = new ArrayList(DiskLruCache.access$2000(this$0).values()).iterator();
  DiskLruCache.Snapshot nextSnapshot;
  DiskLruCache.Snapshot removeSnapshot;
  
  DiskLruCache$3(DiskLruCache paramDiskLruCache) {}
  
  public boolean hasNext()
  {
    if (nextSnapshot != null) {
      return true;
    }
    synchronized (this$0)
    {
      if (DiskLruCache.access$100(this$0)) {
        return false;
      }
      while (delegate.hasNext())
      {
        DiskLruCache.Snapshot localSnapshot = ((DiskLruCache.Entry)delegate.next()).snapshot();
        if (localSnapshot != null)
        {
          nextSnapshot = localSnapshot;
          return true;
        }
      }
    }
    return false;
  }
  
  public DiskLruCache.Snapshot next()
  {
    if (!hasNext()) {
      throw new NoSuchElementException();
    }
    removeSnapshot = nextSnapshot;
    nextSnapshot = null;
    return removeSnapshot;
  }
  
  public void remove()
  {
    if (removeSnapshot == null) {
      throw new IllegalStateException("remove() before next()");
    }
    try
    {
      this$0.remove(DiskLruCache.Snapshot.access$2100(removeSnapshot));
      removeSnapshot = null;
      return;
    }
    catch (IOException localIOException)
    {
      localIOException = localIOException;
      removeSnapshot = null;
      return;
    }
    finally
    {
      localObject = finally;
      removeSnapshot = null;
      throw ((Throwable)localObject);
    }
  }
}

/* Location:
 * Qualified Name:     com.squareup.okhttp.internal.DiskLruCache.3
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */