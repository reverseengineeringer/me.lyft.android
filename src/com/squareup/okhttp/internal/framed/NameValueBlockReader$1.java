package com.squareup.okhttp.internal.framed;

import java.io.IOException;
import okio.Buffer;
import okio.ForwardingSource;
import okio.Source;

class NameValueBlockReader$1
  extends ForwardingSource
{
  NameValueBlockReader$1(NameValueBlockReader paramNameValueBlockReader, Source paramSource)
  {
    super(paramSource);
  }
  
  public long read(Buffer paramBuffer, long paramLong)
    throws IOException
  {
    if (NameValueBlockReader.access$000(this$0) == 0) {
      return -1L;
    }
    paramLong = super.read(paramBuffer, Math.min(paramLong, NameValueBlockReader.access$000(this$0)));
    if (paramLong == -1L) {
      return -1L;
    }
    NameValueBlockReader.access$002(this$0, (int)(NameValueBlockReader.access$000(this$0) - paramLong));
    return paramLong;
  }
}

/* Location:
 * Qualified Name:     com.squareup.okhttp.internal.framed.NameValueBlockReader.1
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */