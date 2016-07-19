package com.squareup.okhttp.internal.framed;

import com.squareup.okhttp.internal.NamedRunnable;
import java.util.Set;

class FramedConnection$7
  extends NamedRunnable
{
  FramedConnection$7(FramedConnection paramFramedConnection, String paramString, Object[] paramArrayOfObject, int paramInt, ErrorCode paramVarArgs)
  {
    super(paramString, paramArrayOfObject);
  }
  
  public void execute()
  {
    FramedConnection.access$2700(this$0).onReset(val$streamId, val$errorCode);
    synchronized (this$0)
    {
      FramedConnection.access$2800(this$0).remove(Integer.valueOf(val$streamId));
      return;
    }
  }
}

/* Location:
 * Qualified Name:     com.squareup.okhttp.internal.framed.FramedConnection.7
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */