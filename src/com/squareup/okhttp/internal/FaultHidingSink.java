package com.squareup.okhttp.internal;

import java.io.IOException;
import okio.Buffer;
import okio.ForwardingSink;
import okio.Sink;

class FaultHidingSink
  extends ForwardingSink
{
  private boolean hasErrors;
  
  public FaultHidingSink(Sink paramSink)
  {
    super(paramSink);
  }
  
  public void close()
    throws IOException
  {
    if (hasErrors) {
      return;
    }
    try
    {
      super.close();
      return;
    }
    catch (IOException localIOException)
    {
      hasErrors = true;
      onException(localIOException);
    }
  }
  
  public void flush()
    throws IOException
  {
    if (hasErrors) {
      return;
    }
    try
    {
      super.flush();
      return;
    }
    catch (IOException localIOException)
    {
      hasErrors = true;
      onException(localIOException);
    }
  }
  
  protected void onException(IOException paramIOException) {}
  
  public void write(Buffer paramBuffer, long paramLong)
    throws IOException
  {
    if (hasErrors)
    {
      paramBuffer.skip(paramLong);
      return;
    }
    try
    {
      super.write(paramBuffer, paramLong);
      return;
    }
    catch (IOException paramBuffer)
    {
      hasErrors = true;
      onException(paramBuffer);
    }
  }
}

/* Location:
 * Qualified Name:     com.squareup.okhttp.internal.FaultHidingSink
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */