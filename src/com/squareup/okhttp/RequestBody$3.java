package com.squareup.okhttp;

import com.squareup.okhttp.internal.Util;
import java.io.Closeable;
import java.io.File;
import java.io.IOException;
import okio.BufferedSink;
import okio.Okio;
import okio.Source;

final class RequestBody$3
  extends RequestBody
{
  RequestBody$3(MediaType paramMediaType, File paramFile) {}
  
  public long contentLength()
  {
    return val$file.length();
  }
  
  public MediaType contentType()
  {
    return val$contentType;
  }
  
  public void writeTo(BufferedSink paramBufferedSink)
    throws IOException
  {
    Object localObject = null;
    try
    {
      Source localSource = Okio.source(val$file);
      localObject = localSource;
      paramBufferedSink.writeAll(localSource);
      Util.closeQuietly(localSource);
      return;
    }
    finally
    {
      Util.closeQuietly((Closeable)localObject);
    }
  }
}

/* Location:
 * Qualified Name:     com.squareup.okhttp.RequestBody.3
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */