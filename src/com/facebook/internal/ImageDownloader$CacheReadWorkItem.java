package com.facebook.internal;

import android.content.Context;

class ImageDownloader$CacheReadWorkItem
  implements Runnable
{
  private boolean allowCachedRedirects;
  private Context context;
  private ImageDownloader.RequestKey key;
  
  ImageDownloader$CacheReadWorkItem(Context paramContext, ImageDownloader.RequestKey paramRequestKey, boolean paramBoolean)
  {
    context = paramContext;
    key = paramRequestKey;
    allowCachedRedirects = paramBoolean;
  }
  
  public void run()
  {
    ImageDownloader.access$100(key, context, allowCachedRedirects);
  }
}

/* Location:
 * Qualified Name:     com.facebook.internal.ImageDownloader.CacheReadWorkItem
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */