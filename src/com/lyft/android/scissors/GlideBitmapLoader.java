package com.lyft.android.scissors;

import android.widget.ImageView;
import com.bumptech.glide.BitmapRequestBuilder;
import com.bumptech.glide.BitmapTypeRequest;
import com.bumptech.glide.DrawableTypeRequest;
import com.bumptech.glide.Glide;
import com.bumptech.glide.RequestManager;
import com.bumptech.glide.load.engine.DiskCacheStrategy;
import com.bumptech.glide.load.engine.bitmap_recycle.BitmapPool;
import com.bumptech.glide.load.resource.bitmap.BitmapTransformation;

public class GlideBitmapLoader
  implements BitmapLoader
{
  private final RequestManager requestManager;
  private final BitmapTransformation transformation;
  
  public GlideBitmapLoader(RequestManager paramRequestManager, BitmapTransformation paramBitmapTransformation)
  {
    requestManager = paramRequestManager;
    transformation = paramBitmapTransformation;
  }
  
  public static BitmapLoader createUsing(CropView paramCropView)
  {
    return createUsing(paramCropView, Glide.with(paramCropView.getContext()), Glide.get(paramCropView.getContext()).getBitmapPool());
  }
  
  public static BitmapLoader createUsing(CropView paramCropView, RequestManager paramRequestManager, BitmapPool paramBitmapPool)
  {
    return new GlideBitmapLoader(paramRequestManager, GlideFillViewportTransformation.createUsing(paramBitmapPool, paramCropView.getViewportWidth(), paramCropView.getViewportHeight()));
  }
  
  public void load(Object paramObject, ImageView paramImageView)
  {
    requestManager.load(paramObject).asBitmap().skipMemoryCache(true).diskCacheStrategy(DiskCacheStrategy.SOURCE).transform(new BitmapTransformation[] { transformation }).into(paramImageView);
  }
}

/* Location:
 * Qualified Name:     com.lyft.android.scissors.GlideBitmapLoader
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */