package com.squareup.okhttp.internal;

import java.io.Closeable;
import java.io.IOException;
import okio.Source;

public final class DiskLruCache$Snapshot
  implements Closeable
{
  private final String key;
  private final long[] lengths;
  private final long sequenceNumber;
  private final Source[] sources;
  
  private DiskLruCache$Snapshot(DiskLruCache paramDiskLruCache, String paramString, long paramLong, Source[] paramArrayOfSource, long[] paramArrayOfLong)
  {
    key = paramString;
    sequenceNumber = paramLong;
    sources = paramArrayOfSource;
    lengths = paramArrayOfLong;
  }
  
  public void close()
  {
    Source[] arrayOfSource = sources;
    int j = arrayOfSource.length;
    int i = 0;
    while (i < j)
    {
      Util.closeQuietly(arrayOfSource[i]);
      i += 1;
    }
  }
  
  public DiskLruCache.Editor edit()
    throws IOException
  {
    return DiskLruCache.access$2200(this$0, key, sequenceNumber);
  }
  
  public long getLength(int paramInt)
  {
    return lengths[paramInt];
  }
  
  public Source getSource(int paramInt)
  {
    return sources[paramInt];
  }
  
  public String key()
  {
    return key;
  }
}

/* Location:
 * Qualified Name:     com.squareup.okhttp.internal.DiskLruCache.Snapshot
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */