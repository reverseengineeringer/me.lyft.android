package com.squareup.okhttp;

import com.squareup.okhttp.internal.DiskLruCache.Snapshot;
import java.io.IOException;
import okio.BufferedSource;
import okio.ForwardingSource;
import okio.Okio;
import okio.Source;

class Cache$CacheResponseBody
  extends ResponseBody
{
  private final BufferedSource bodySource;
  private final String contentLength;
  private final String contentType;
  private final DiskLruCache.Snapshot snapshot;
  
  public Cache$CacheResponseBody(final DiskLruCache.Snapshot paramSnapshot, String paramString1, String paramString2)
  {
    snapshot = paramSnapshot;
    contentType = paramString1;
    contentLength = paramString2;
    bodySource = Okio.buffer(new ForwardingSource(paramSnapshot.getSource(1))
    {
      public void close()
        throws IOException
      {
        paramSnapshot.close();
        super.close();
      }
    });
  }
  
  public long contentLength()
  {
    long l = -1L;
    try
    {
      if (contentLength != null) {
        l = Long.parseLong(contentLength);
      }
      return l;
    }
    catch (NumberFormatException localNumberFormatException) {}
    return -1L;
  }
  
  public MediaType contentType()
  {
    if (contentType != null) {
      return MediaType.parse(contentType);
    }
    return null;
  }
  
  public BufferedSource source()
  {
    return bodySource;
  }
}

/* Location:
 * Qualified Name:     com.squareup.okhttp.Cache.CacheResponseBody
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */