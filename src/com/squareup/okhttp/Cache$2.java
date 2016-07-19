package com.squareup.okhttp;

import com.squareup.okhttp.internal.DiskLruCache;
import com.squareup.okhttp.internal.DiskLruCache.Snapshot;
import java.io.IOException;
import java.util.Iterator;
import java.util.NoSuchElementException;
import okio.BufferedSource;
import okio.Okio;

class Cache$2
  implements Iterator<String>
{
  boolean canRemove;
  final Iterator<DiskLruCache.Snapshot> delegate = Cache.access$600(this$0).snapshots();
  String nextUrl;
  
  Cache$2(Cache paramCache)
    throws IOException
  {}
  
  public boolean hasNext()
  {
    if (nextUrl != null) {
      return true;
    }
    canRemove = false;
    while (delegate.hasNext())
    {
      DiskLruCache.Snapshot localSnapshot = (DiskLruCache.Snapshot)delegate.next();
      try
      {
        nextUrl = Okio.buffer(localSnapshot.getSource(0)).readUtf8LineStrict();
        localSnapshot.close();
        return true;
      }
      catch (IOException localIOException)
      {
        localIOException = localIOException;
        localSnapshot.close();
      }
      finally
      {
        localObject = finally;
        localSnapshot.close();
        throw ((Throwable)localObject);
      }
    }
    return false;
  }
  
  public String next()
  {
    if (!hasNext()) {
      throw new NoSuchElementException();
    }
    String str = nextUrl;
    nextUrl = null;
    canRemove = true;
    return str;
  }
  
  public void remove()
  {
    if (!canRemove) {
      throw new IllegalStateException("remove() before next()");
    }
    delegate.remove();
  }
}

/* Location:
 * Qualified Name:     com.squareup.okhttp.Cache.2
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */