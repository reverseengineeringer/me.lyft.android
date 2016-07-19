package com.squareup.okhttp.internal.framed;

import com.squareup.okhttp.internal.NamedRunnable;
import java.io.IOException;
import java.util.List;
import java.util.Set;

class FramedConnection$4
  extends NamedRunnable
{
  FramedConnection$4(FramedConnection paramFramedConnection, String paramString, Object[] paramArrayOfObject, int paramInt, List paramVarArgs)
  {
    super(paramString, paramArrayOfObject);
  }
  
  public void execute()
  {
    if (FramedConnection.access$2700(this$0).onRequest(val$streamId, val$requestHeaders)) {
      try
      {
        this$0.frameWriter.rstStream(val$streamId, ErrorCode.CANCEL);
        synchronized (this$0)
        {
          FramedConnection.access$2800(this$0).remove(Integer.valueOf(val$streamId));
          return;
        }
        return;
      }
      catch (IOException localIOException) {}
    }
  }
}

/* Location:
 * Qualified Name:     com.squareup.okhttp.internal.framed.FramedConnection.4
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */