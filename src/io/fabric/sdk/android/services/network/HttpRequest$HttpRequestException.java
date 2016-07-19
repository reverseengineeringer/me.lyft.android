package io.fabric.sdk.android.services.network;

import java.io.IOException;

public class HttpRequest$HttpRequestException
  extends RuntimeException
{
  private static final long serialVersionUID = -1170466989781746231L;
  
  protected HttpRequest$HttpRequestException(IOException paramIOException)
  {
    super(paramIOException);
  }
  
  public IOException getCause()
  {
    return (IOException)super.getCause();
  }
}

/* Location:
 * Qualified Name:     io.fabric.sdk.android.services.network.HttpRequest.HttpRequestException
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */