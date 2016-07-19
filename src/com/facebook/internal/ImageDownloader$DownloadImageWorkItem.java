package com.facebook.internal;

import android.content.Context;

class ImageDownloader$DownloadImageWorkItem
  implements Runnable
{
  private Context context;
  private ImageDownloader.RequestKey key;
  
  ImageDownloader$DownloadImageWorkItem(Context paramContext, ImageDownloader.RequestKey paramRequestKey)
  {
    context = paramContext;
    key = paramRequestKey;
  }
  
  public void run()
  {
    ImageDownloader.access$200(key, context);
  }
}

/* Location:
 * Qualified Name:     com.facebook.internal.ImageDownloader.DownloadImageWorkItem
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */