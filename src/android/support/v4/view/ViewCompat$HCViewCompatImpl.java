package android.support.v4.view;

import android.graphics.Paint;
import android.view.View;

class ViewCompat$HCViewCompatImpl
  extends ViewCompat.GBViewCompatImpl
{
  public float getAlpha(View paramView)
  {
    return ViewCompatHC.getAlpha(paramView);
  }
  
  long getFrameTime()
  {
    return ViewCompatHC.getFrameTime();
  }
  
  public int getLayerType(View paramView)
  {
    return ViewCompatHC.getLayerType(paramView);
  }
  
  public float getScaleX(View paramView)
  {
    return ViewCompatHC.getScaleX(paramView);
  }
  
  public float getTranslationX(View paramView)
  {
    return ViewCompatHC.getTranslationX(paramView);
  }
  
  public float getTranslationY(View paramView)
  {
    return ViewCompatHC.getTranslationY(paramView);
  }
  
  public void offsetLeftAndRight(View paramView, int paramInt)
  {
    ViewCompatHC.offsetLeftAndRight(paramView, paramInt);
  }
  
  public void offsetTopAndBottom(View paramView, int paramInt)
  {
    ViewCompatHC.offsetTopAndBottom(paramView, paramInt);
  }
  
  public void setAlpha(View paramView, float paramFloat)
  {
    ViewCompatHC.setAlpha(paramView, paramFloat);
  }
  
  public void setLayerType(View paramView, int paramInt, Paint paramPaint)
  {
    ViewCompatHC.setLayerType(paramView, paramInt, paramPaint);
  }
  
  public void setSaveFromParentEnabled(View paramView, boolean paramBoolean)
  {
    ViewCompatHC.setSaveFromParentEnabled(paramView, paramBoolean);
  }
  
  public void setScaleX(View paramView, float paramFloat)
  {
    ViewCompatHC.setScaleX(paramView, paramFloat);
  }
  
  public void setScaleY(View paramView, float paramFloat)
  {
    ViewCompatHC.setScaleY(paramView, paramFloat);
  }
  
  public void setTranslationX(View paramView, float paramFloat)
  {
    ViewCompatHC.setTranslationX(paramView, paramFloat);
  }
  
  public void setTranslationY(View paramView, float paramFloat)
  {
    ViewCompatHC.setTranslationY(paramView, paramFloat);
  }
}

/* Location:
 * Qualified Name:     android.support.v4.view.ViewCompat.HCViewCompatImpl
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */