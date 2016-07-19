package com.squareup.okhttp.internal.framed;

import com.squareup.okhttp.internal.NamedRunnable;
import java.io.IOException;

class FramedConnection$2
  extends NamedRunnable
{
  FramedConnection$2(FramedConnection paramFramedConnection, String paramString, Object[] paramArrayOfObject, int paramInt, long paramVarArgs)
  {
    super(paramString, paramArrayOfObject);
  }
  
  public void execute()
  {
    try
    {
      this$0.frameWriter.windowUpdate(val$streamId, val$unacknowledgedBytesRead);
      return;
    }
    catch (IOException localIOException) {}
  }
}

/* Location:
 * Qualified Name:     com.squareup.okhttp.internal.framed.FramedConnection.2
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */