package com.squareup.okhttp.internal.framed;

import com.squareup.okhttp.internal.NamedRunnable;
import java.io.IOException;

class FramedConnection$1
  extends NamedRunnable
{
  FramedConnection$1(FramedConnection paramFramedConnection, String paramString, Object[] paramArrayOfObject, int paramInt, ErrorCode paramVarArgs)
  {
    super(paramString, paramArrayOfObject);
  }
  
  public void execute()
  {
    try
    {
      this$0.writeSynReset(val$streamId, val$errorCode);
      return;
    }
    catch (IOException localIOException) {}
  }
}

/* Location:
 * Qualified Name:     com.squareup.okhttp.internal.framed.FramedConnection.1
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */