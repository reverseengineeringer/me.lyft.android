package com.lyft.android.scissors;

import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;

class CropViewConfig
{
  private float maxScale = 10.0F;
  private float minScale = 0.0F;
  private int viewportHeaderFooterColor = -939524096;
  private float viewportHeightRatio = 1.0F;
  
  public static CropViewConfig from(Context paramContext, AttributeSet paramAttributeSet)
  {
    CropViewConfig localCropViewConfig = new CropViewConfig();
    if (paramAttributeSet == null) {
      return localCropViewConfig;
    }
    paramContext = paramContext.obtainStyledAttributes(paramAttributeSet, R.styleable.CropView);
    localCropViewConfig.setViewportHeightRatio(paramContext.getFloat(R.styleable.CropView_cropviewViewportHeightRatio, 1.0F));
    localCropViewConfig.setMaxScale(paramContext.getFloat(R.styleable.CropView_cropviewMaxScale, 10.0F));
    localCropViewConfig.setMinScale(paramContext.getFloat(R.styleable.CropView_cropviewMinScale, 0.0F));
    localCropViewConfig.setViewportHeaderFooterColor(paramContext.getColor(R.styleable.CropView_cropviewViewportHeaderFooterColor, -939524096));
    paramContext.recycle();
    return localCropViewConfig;
  }
  
  public float getMaxScale()
  {
    return maxScale;
  }
  
  public float getMinScale()
  {
    return minScale;
  }
  
  public int getViewportHeaderFooterColor()
  {
    return viewportHeaderFooterColor;
  }
  
  public float getViewportHeightRatio()
  {
    return viewportHeightRatio;
  }
  
  void setMaxScale(float paramFloat)
  {
    float f = paramFloat;
    if (paramFloat <= 0.0F) {
      f = 10.0F;
    }
    maxScale = f;
  }
  
  void setMinScale(float paramFloat)
  {
    float f = paramFloat;
    if (paramFloat <= 0.0F) {
      f = 0.0F;
    }
    minScale = f;
  }
  
  void setViewportHeaderFooterColor(int paramInt)
  {
    int i = paramInt;
    if (paramInt <= 0) {
      i = -939524096;
    }
    viewportHeaderFooterColor = i;
  }
  
  void setViewportHeightRatio(float paramFloat)
  {
    float f = paramFloat;
    if (paramFloat <= 0.0F) {
      f = 1.0F;
    }
    viewportHeightRatio = f;
  }
}

/* Location:
 * Qualified Name:     com.lyft.android.scissors.CropViewConfig
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */