package io.fabric.sdk.android.services.network;

import java.io.Closeable;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

class HttpRequest$6
  extends HttpRequest.CloseOperation<HttpRequest>
{
  HttpRequest$6(HttpRequest paramHttpRequest, Closeable paramCloseable, boolean paramBoolean, InputStream paramInputStream, OutputStream paramOutputStream)
  {
    super(paramCloseable, paramBoolean);
  }
  
  public HttpRequest run()
    throws IOException
  {
    byte[] arrayOfByte = new byte[HttpRequest.access$100(this$0)];
    for (;;)
    {
      int i = val$input.read(arrayOfByte);
      if (i == -1) {
        break;
      }
      val$output.write(arrayOfByte, 0, i);
    }
    return this$0;
  }
}

/* Location:
 * Qualified Name:     io.fabric.sdk.android.services.network.HttpRequest.6
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */