package com.squareup.okhttp.internal.framed;

import java.io.IOException;
import java.util.List;
import okio.BufferedSource;

final class PushObserver$1
  implements PushObserver
{
  public boolean onData(int paramInt1, BufferedSource paramBufferedSource, int paramInt2, boolean paramBoolean)
    throws IOException
  {
    paramBufferedSource.skip(paramInt2);
    return true;
  }
  
  public boolean onHeaders(int paramInt, List<Header> paramList, boolean paramBoolean)
  {
    return true;
  }
  
  public boolean onRequest(int paramInt, List<Header> paramList)
  {
    return true;
  }
  
  public void onReset(int paramInt, ErrorCode paramErrorCode) {}
}

/* Location:
 * Qualified Name:     com.squareup.okhttp.internal.framed.PushObserver.1
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */