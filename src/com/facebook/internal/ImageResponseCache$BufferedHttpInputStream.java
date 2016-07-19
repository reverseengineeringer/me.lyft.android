package com.facebook.internal;

import java.io.BufferedInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;

class ImageResponseCache$BufferedHttpInputStream
  extends BufferedInputStream
{
  HttpURLConnection connection;
  
  ImageResponseCache$BufferedHttpInputStream(InputStream paramInputStream, HttpURLConnection paramHttpURLConnection)
  {
    super(paramInputStream, 8192);
    connection = paramHttpURLConnection;
  }
  
  public void close()
    throws IOException
  {
    super.close();
    Utility.disconnectQuietly(connection);
  }
}

/* Location:
 * Qualified Name:     com.facebook.internal.ImageResponseCache.BufferedHttpInputStream
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */