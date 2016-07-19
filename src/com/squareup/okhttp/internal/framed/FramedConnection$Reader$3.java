package com.squareup.okhttp.internal.framed;

import com.squareup.okhttp.internal.NamedRunnable;
import java.io.IOException;

class FramedConnection$Reader$3
  extends NamedRunnable
{
  FramedConnection$Reader$3(FramedConnection.Reader paramReader, String paramString, Object[] paramArrayOfObject, Settings paramVarArgs)
  {
    super(paramString, paramArrayOfObject);
  }
  
  public void execute()
  {
    try
    {
      this$1.this$0.frameWriter.ackSettings(val$peerSettings);
      return;
    }
    catch (IOException localIOException) {}
  }
}

/* Location:
 * Qualified Name:     com.squareup.okhttp.internal.framed.FramedConnection.Reader.3
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */