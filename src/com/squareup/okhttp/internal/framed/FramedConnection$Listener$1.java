package com.squareup.okhttp.internal.framed;

import java.io.IOException;

final class FramedConnection$Listener$1
  extends FramedConnection.Listener
{
  public void onStream(FramedStream paramFramedStream)
    throws IOException
  {
    paramFramedStream.close(ErrorCode.REFUSED_STREAM);
  }
}

/* Location:
 * Qualified Name:     com.squareup.okhttp.internal.framed.FramedConnection.Listener.1
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */