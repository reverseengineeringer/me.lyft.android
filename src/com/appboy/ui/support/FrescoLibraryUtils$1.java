package com.appboy.ui.support;

import android.graphics.drawable.Animatable;
import com.facebook.drawee.controller.BaseControllerListener;
import com.facebook.drawee.view.SimpleDraweeView;
import com.facebook.imagepipeline.image.ImageInfo;

final class FrescoLibraryUtils$1
  extends BaseControllerListener<ImageInfo>
{
  FrescoLibraryUtils$1(boolean paramBoolean, float paramFloat, SimpleDraweeView paramSimpleDraweeView) {}
  
  public void onFinalImageSet(String paramString, ImageInfo paramImageInfo, Animatable paramAnimatable)
  {
    if (paramImageInfo == null) {
      return;
    }
    if (val$respectAspectRatio) {}
    for (final float f = val$aspectRatio;; f = paramImageInfo.getWidth() / paramImageInfo.getHeight())
    {
      val$simpleDraweeView.post(new Runnable()
      {
        public void run()
        {
          val$simpleDraweeView.setAspectRatio(f);
        }
      });
      return;
    }
  }
}

/* Location:
 * Qualified Name:     com.appboy.ui.support.FrescoLibraryUtils.1
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */