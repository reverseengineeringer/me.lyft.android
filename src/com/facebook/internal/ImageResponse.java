package com.facebook.internal;

import android.graphics.Bitmap;

public class ImageResponse
{
  private Bitmap bitmap;
  private Exception error;
  private boolean isCachedRedirect;
  private ImageRequest request;
  
  ImageResponse(ImageRequest paramImageRequest, Exception paramException, boolean paramBoolean, Bitmap paramBitmap)
  {
    request = paramImageRequest;
    error = paramException;
    bitmap = paramBitmap;
    isCachedRedirect = paramBoolean;
  }
  
  public Bitmap getBitmap()
  {
    return bitmap;
  }
  
  public Exception getError()
  {
    return error;
  }
  
  public ImageRequest getRequest()
  {
    return request;
  }
  
  public boolean isCachedRedirect()
  {
    return isCachedRedirect;
  }
}

/* Location:
 * Qualified Name:     com.facebook.internal.ImageResponse
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */