package io.fabric.sdk.android.services.network;

import java.io.BufferedOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.nio.ByteBuffer;
import java.nio.CharBuffer;
import java.nio.charset.Charset;
import java.nio.charset.CharsetEncoder;

public class HttpRequest$RequestOutputStream
  extends BufferedOutputStream
{
  private final CharsetEncoder encoder;
  
  public HttpRequest$RequestOutputStream(OutputStream paramOutputStream, String paramString, int paramInt)
  {
    super(paramOutputStream, paramInt);
    encoder = Charset.forName(HttpRequest.access$000(paramString)).newEncoder();
  }
  
  public RequestOutputStream write(String paramString)
    throws IOException
  {
    paramString = encoder.encode(CharBuffer.wrap(paramString));
    super.write(paramString.array(), 0, paramString.limit());
    return this;
  }
}

/* Location:
 * Qualified Name:     io.fabric.sdk.android.services.network.HttpRequest.RequestOutputStream
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */