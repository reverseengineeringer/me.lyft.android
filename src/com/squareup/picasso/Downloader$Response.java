package com.squareup.picasso;

import android.graphics.Bitmap;
import java.io.InputStream;

public class Downloader$Response
{
  final Bitmap bitmap;
  final boolean cached;
  final long contentLength;
  final InputStream stream;
  
  @Deprecated
  public Downloader$Response(Bitmap paramBitmap, boolean paramBoolean)
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
  public Downloader$Response(Bitmap paramBitmap, boolean paramBoolean, long paramLong)
  {
    this(paramBitmap, paramBoolean);
  }
  
  @Deprecated
  public Downloader$Response(InputStream paramInputStream, boolean paramBoolean)
  {
    this(paramInputStream, paramBoolean, -1L);
  }
  
  public Downloader$Response(InputStream paramInputStream, boolean paramBoolean, long paramLong)
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

/* Location:
 * Qualified Name:     com.squareup.picasso.Downloader.Response
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */