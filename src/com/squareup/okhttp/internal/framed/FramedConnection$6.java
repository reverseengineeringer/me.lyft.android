package com.squareup.okhttp.internal.framed;

import com.squareup.okhttp.internal.NamedRunnable;
import java.io.IOException;
import java.util.Set;
import okio.Buffer;

class FramedConnection$6
  extends NamedRunnable
{
  FramedConnection$6(FramedConnection paramFramedConnection, String paramString, Object[] paramArrayOfObject, int paramInt1, Buffer paramBuffer, int paramInt2, boolean paramVarArgs)
  {
    super(paramString, paramArrayOfObject);
  }
  
  public void execute()
  {
    try
    {
      boolean bool = FramedConnection.access$2700(this$0).onData(val$streamId, val$buffer, val$byteCount, val$inFinished);
      if (bool) {
        this$0.frameWriter.rstStream(val$streamId, ErrorCode.CANCEL);
      }
      if ((bool) || (val$inFinished)) {
        synchronized (this$0)
        {
          FramedConnection.access$2800(this$0).remove(Integer.valueOf(val$streamId));
          return;
        }
      }
      return;
    }
    catch (IOException localIOException) {}
  }
}

/* Location:
 * Qualified Name:     com.squareup.okhttp.internal.framed.FramedConnection.6
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */