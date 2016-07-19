package com.facebook.internal;

import android.content.Context;
import android.net.Uri;

public class ImageRequest$Builder
{
  private boolean allowCachedRedirects;
  private ImageRequest.Callback callback;
  private Object callerTag;
  private Context context;
  private Uri imageUrl;
  
  public ImageRequest$Builder(Context paramContext, Uri paramUri)
  {
    Validate.notNull(paramUri, "imageUri");
    context = paramContext;
    imageUrl = paramUri;
  }
  
  public ImageRequest build()
  {
    return new ImageRequest(this, null);
  }
  
  public Builder setAllowCachedRedirects(boolean paramBoolean)
  {
    allowCachedRedirects = paramBoolean;
    return this;
  }
  
  public Builder setCallback(ImageRequest.Callback paramCallback)
  {
    callback = paramCallback;
    return this;
  }
  
  public Builder setCallerTag(Object paramObject)
  {
    callerTag = paramObject;
    return this;
  }
}

/* Location:
 * Qualified Name:     com.facebook.internal.ImageRequest.Builder
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */