package com.squareup.okhttp.internal.framed;

import com.squareup.okhttp.internal.NamedRunnable;

class FramedConnection$Reader$2
  extends NamedRunnable
{
  FramedConnection$Reader$2(FramedConnection.Reader paramReader, String paramString, Object... paramVarArgs)
  {
    super(paramString, paramVarArgs);
  }
  
  public void execute()
  {
    FramedConnection.access$2000(this$1.this$0).onSettings(this$1.this$0);
  }
}

/* Location:
 * Qualified Name:     com.squareup.okhttp.internal.framed.FramedConnection.Reader.2
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */