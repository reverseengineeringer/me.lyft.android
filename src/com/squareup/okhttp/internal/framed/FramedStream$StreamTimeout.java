package com.squareup.okhttp.internal.framed;

import java.io.IOException;
import java.net.SocketTimeoutException;
import okio.AsyncTimeout;

class FramedStream$StreamTimeout
  extends AsyncTimeout
{
  FramedStream$StreamTimeout(FramedStream paramFramedStream) {}
  
  public void exitAndThrowIfTimedOut()
    throws IOException
  {
    if (exit()) {
      throw newTimeoutException(null);
    }
  }
  
  protected IOException newTimeoutException(IOException paramIOException)
  {
    SocketTimeoutException localSocketTimeoutException = new SocketTimeoutException("timeout");
    if (paramIOException != null) {
      localSocketTimeoutException.initCause(paramIOException);
    }
    return localSocketTimeoutException;
  }
  
  protected void timedOut()
  {
    this$0.closeLater(ErrorCode.CANCEL);
  }
}

/* Location:
 * Qualified Name:     com.squareup.okhttp.internal.framed.FramedStream.StreamTimeout
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */