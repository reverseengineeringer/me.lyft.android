package com.facebook.internal;

import android.graphics.Bitmap;

final class ImageDownloader$1
  implements Runnable
{
  ImageDownloader$1(ImageRequest paramImageRequest, Exception paramException, boolean paramBoolean, Bitmap paramBitmap, ImageRequest.Callback paramCallback) {}
  
  public void run()
  {
    ImageResponse localImageResponse = new ImageResponse(val$request, val$error, val$isCachedRedirect, val$bitmap);
    val$callback.onCompleted(localImageResponse);
  }
}

/* Location:
 * Qualified Name:     com.facebook.internal.ImageDownloader.1
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */