package com.squareup.okhttp;

import com.squareup.okhttp.internal.Util;
import java.io.IOException;
import java.util.List;
import okio.Buffer;
import okio.BufferedSink;
import okio.ByteString;

final class MultipartBuilder$MultipartRequestBody
  extends RequestBody
{
  private final ByteString boundary;
  private long contentLength = -1L;
  private final MediaType contentType;
  private final List<RequestBody> partBodies;
  private final List<Headers> partHeaders;
  
  public MultipartBuilder$MultipartRequestBody(MediaType paramMediaType, ByteString paramByteString, List<Headers> paramList, List<RequestBody> paramList1)
  {
    if (paramMediaType == null) {
      throw new NullPointerException("type == null");
    }
    boundary = paramByteString;
    contentType = MediaType.parse(paramMediaType + "; boundary=" + paramByteString.utf8());
    partHeaders = Util.immutableList(paramList);
    partBodies = Util.immutableList(paramList1);
  }
  
  private long writeOrCountBytes(BufferedSink paramBufferedSink, boolean paramBoolean)
    throws IOException
  {
    long l1 = 0L;
    Buffer localBuffer = null;
    if (paramBoolean)
    {
      localBuffer = new Buffer();
      paramBufferedSink = localBuffer;
    }
    int i = 0;
    int k = partHeaders.size();
    if (i < k)
    {
      Object localObject = (Headers)partHeaders.get(i);
      RequestBody localRequestBody = (RequestBody)partBodies.get(i);
      paramBufferedSink.write(MultipartBuilder.access$000());
      paramBufferedSink.write(boundary);
      paramBufferedSink.write(MultipartBuilder.access$100());
      if (localObject != null)
      {
        int j = 0;
        int m = ((Headers)localObject).size();
        while (j < m)
        {
          paramBufferedSink.writeUtf8(((Headers)localObject).name(j)).write(MultipartBuilder.access$200()).writeUtf8(((Headers)localObject).value(j)).write(MultipartBuilder.access$100());
          j += 1;
        }
      }
      localObject = localRequestBody.contentType();
      if (localObject != null) {
        paramBufferedSink.writeUtf8("Content-Type: ").writeUtf8(((MediaType)localObject).toString()).write(MultipartBuilder.access$100());
      }
      l2 = localRequestBody.contentLength();
      if (l2 != -1L)
      {
        paramBufferedSink.writeUtf8("Content-Length: ").writeDecimalLong(l2).write(MultipartBuilder.access$100());
        label254:
        paramBufferedSink.write(MultipartBuilder.access$100());
        if (!paramBoolean) {
          break label305;
        }
        l1 += l2;
      }
      for (;;)
      {
        paramBufferedSink.write(MultipartBuilder.access$100());
        i += 1;
        break;
        if (!paramBoolean) {
          break label254;
        }
        localBuffer.clear();
        return -1L;
        label305:
        ((RequestBody)partBodies.get(i)).writeTo(paramBufferedSink);
      }
    }
    paramBufferedSink.write(MultipartBuilder.access$000());
    paramBufferedSink.write(boundary);
    paramBufferedSink.write(MultipartBuilder.access$000());
    paramBufferedSink.write(MultipartBuilder.access$100());
    long l2 = l1;
    if (paramBoolean)
    {
      l2 = l1 + localBuffer.size();
      localBuffer.clear();
    }
    return l2;
  }
  
  public long contentLength()
    throws IOException
  {
    long l = contentLength;
    if (l != -1L) {
      return l;
    }
    l = writeOrCountBytes(null, true);
    contentLength = l;
    return l;
  }
  
  public MediaType contentType()
  {
    return contentType;
  }
  
  public void writeTo(BufferedSink paramBufferedSink)
    throws IOException
  {
    writeOrCountBytes(paramBufferedSink, false);
  }
}

/* Location:
 * Qualified Name:     com.squareup.okhttp.MultipartBuilder.MultipartRequestBody
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */