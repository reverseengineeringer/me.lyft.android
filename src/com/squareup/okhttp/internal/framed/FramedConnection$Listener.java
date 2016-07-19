package com.squareup.okhttp.internal.framed;

import java.io.IOException;

public abstract class FramedConnection$Listener
{
  public static final Listener REFUSE_INCOMING_STREAMS = new Listener()
  {
    public void onStream(FramedStream paramAnonymousFramedStream)
      throws IOException
    {
      paramAnonymousFramedStream.close(ErrorCode.REFUSED_STREAM);
    }
  };
  
  public void onSettings(FramedConnection paramFramedConnection) {}
  
  public abstract void onStream(FramedStream paramFramedStream)
    throws IOException;
}

/* Location:
 * Qualified Name:     com.squareup.okhttp.internal.framed.FramedConnection.Listener
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */