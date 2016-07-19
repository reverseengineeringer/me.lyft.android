package com.squareup.picasso;

import android.graphics.Bitmap;
import android.net.Uri;
import java.io.IOException;
import java.io.InputStream;

public abstract interface Downloader
{
  public abstract Response load(Uri paramUri, int paramInt)
    throws IOException;
  
  public abstract void shutdown();
  
  public static class Response
  {
    final Bitmap bitmap;
    final boolean cached;
    final long contentLength;
    final InputStream stream;
    
    @Deprecated
    public Response(Bitmap paramBitmap, boolean paramBoolean)
    {
      if (paramBitmap == null) {
        throw new IllegalArgumentException("Bitmap may not be null.");
      }
      stream = null;
      bitmap = paramBitmap;
      cached = paramBoolean;
      contentLength = -1L;
    }
    
    @Deprecated
    public Response(Bitmap paramBitmap, boolean paramBoolean, long paramLong)
    {
      this(paramBitmap, paramBoolean);
    }
    
    @Deprecated
    public Response(InputStream paramInputStream, boolean paramBoolean)
    {
      this(paramInputStream, paramBoolean, -1L);
    }
    
    public Response(InputStream paramInputStream, boolean paramBoolean, long paramLong)
    {
      if (paramInputStream == null) {
        throw new IllegalArgumentException("Stream may not be null.");
      }
      stream = paramInputStream;
      bitmap = null;
      cached = paramBoolean;
      contentLength = paramLong;
    }
    
    @Deprecated
    public Bitmap getBitmap()
    {
      return bitmap;
    }
    
    public long getContentLength()
    {
      return contentLength;
    }
    
    public InputStream getInputStream()
    {
      return stream;
    }
  }
  
  public static class ResponseException
    extends IOException
  {
    final boolean localCacheOnly;
    final int responseCode;
    
    public ResponseException(String paramString, int paramInt1, int paramInt2)
    {
      super();
      localCacheOnly = NetworkPolicy.isOfflineOnly(paramInt1);
      responseCode = paramInt2;
    }
  }
}

/* Location:
 * Qualified Name:     com.squareup.picasso.Downloader
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */