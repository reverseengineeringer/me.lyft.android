package com.squareup.okhttp.internal.http;

import java.io.IOException;

public final class RequestException
  extends Exception
{
  public RequestException(IOException paramIOException)
  {
    super(paramIOException);
  }
  
  public IOException getCause()
  {
    return (IOException)super.getCause();
  }
}

/* Location:
 * Qualified Name:     com.squareup.okhttp.internal.http.RequestException
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */