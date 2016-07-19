package io.fabric.sdk.android.services.network;

import java.io.Closeable;
import java.io.Flushable;
import java.io.IOException;

public abstract class HttpRequest$CloseOperation<V>
  extends HttpRequest.Operation<V>
{
  private final Closeable closeable;
  private final boolean ignoreCloseExceptions;
  
  protected HttpRequest$CloseOperation(Closeable paramCloseable, boolean paramBoolean)
  {
    closeable = paramCloseable;
    ignoreCloseExceptions = paramBoolean;
  }
  
  protected void done()
    throws IOException
  {
    if ((closeable instanceof Flushable)) {
      ((Flushable)closeable).flush();
    }
    if (ignoreCloseExceptions) {}
    try
    {
      closeable.close();
      return;
    }
    catch (IOException localIOException) {}
    closeable.close();
    return;
  }
}

/* Location:
 * Qualified Name:     io.fabric.sdk.android.services.network.HttpRequest.CloseOperation
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */