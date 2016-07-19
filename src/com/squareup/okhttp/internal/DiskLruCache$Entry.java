package com.squareup.okhttp.internal;

import com.squareup.okhttp.internal.io.FileSystem;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Arrays;
import okio.BufferedSink;
import okio.Source;

final class DiskLruCache$Entry
{
  private final File[] cleanFiles;
  private DiskLruCache.Editor currentEditor;
  private final File[] dirtyFiles;
  private final String key;
  private final long[] lengths;
  private boolean readable;
  private long sequenceNumber;
  
  private DiskLruCache$Entry(DiskLruCache paramDiskLruCache, String paramString)
  {
    key = paramString;
    lengths = new long[DiskLruCache.access$2300(paramDiskLruCache)];
    cleanFiles = new File[DiskLruCache.access$2300(paramDiskLruCache)];
    dirtyFiles = new File[DiskLruCache.access$2300(paramDiskLruCache)];
    paramString = new StringBuilder(paramString).append('.');
    int j = paramString.length();
    int i = 0;
    while (i < DiskLruCache.access$2300(paramDiskLruCache))
    {
      paramString.append(i);
      cleanFiles[i] = new File(DiskLruCache.access$2800(paramDiskLruCache), paramString.toString());
      paramString.append(".tmp");
      dirtyFiles[i] = new File(DiskLruCache.access$2800(paramDiskLruCache), paramString.toString());
      paramString.setLength(j);
      i += 1;
    }
  }
  
  private IOException invalidLengths(String[] paramArrayOfString)
    throws IOException
  {
    throw new IOException("unexpected journal line: " + Arrays.toString(paramArrayOfString));
  }
  
  private void setLengths(String[] paramArrayOfString)
    throws IOException
  {
    if (paramArrayOfString.length != DiskLruCache.access$2300(this$0)) {
      throw invalidLengths(paramArrayOfString);
    }
    int i = 0;
    try
    {
      while (i < paramArrayOfString.length)
      {
        lengths[i] = Long.parseLong(paramArrayOfString[i]);
        i += 1;
      }
      return;
    }
    catch (NumberFormatException localNumberFormatException)
    {
      throw invalidLengths(paramArrayOfString);
    }
  }
  
  DiskLruCache.Snapshot snapshot()
  {
    if (!Thread.holdsLock(this$0)) {
      throw new AssertionError();
    }
    Source[] arrayOfSource = new Source[DiskLruCache.access$2300(this$0)];
    Object localObject = (long[])lengths.clone();
    int i = 0;
    try
    {
      while (i < DiskLruCache.access$2300(this$0))
      {
        arrayOfSource[i] = DiskLruCache.access$2400(this$0).source(cleanFiles[i]);
        i += 1;
      }
      localObject = new DiskLruCache.Snapshot(this$0, key, sequenceNumber, arrayOfSource, (long[])localObject, null);
      return (DiskLruCache.Snapshot)localObject;
    }
    catch (FileNotFoundException localFileNotFoundException)
    {
      i = 0;
      while ((i < DiskLruCache.access$2300(this$0)) && (arrayOfSource[i] != null))
      {
        Util.closeQuietly(arrayOfSource[i]);
        i += 1;
      }
    }
    return null;
  }
  
  void writeLengths(BufferedSink paramBufferedSink)
    throws IOException
  {
    long[] arrayOfLong = lengths;
    int j = arrayOfLong.length;
    int i = 0;
    while (i < j)
    {
      long l = arrayOfLong[i];
      paramBufferedSink.writeByte(32).writeDecimalLong(l);
      i += 1;
    }
  }
}

/* Location:
 * Qualified Name:     com.squareup.okhttp.internal.DiskLruCache.Entry
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */