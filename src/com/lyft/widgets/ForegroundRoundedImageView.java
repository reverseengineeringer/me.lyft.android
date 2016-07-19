package com.lyft.widgets;

import android.annotation.TargetApi;
import android.content.Context;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import com.makeramen.roundedimageview.RoundedImageView;

public class ForegroundRoundedImageView
  extends RoundedImageView
{
  private Drawable overlayDrawable;
  private float overlayDx;
  private float overlayDy;
  
  public ForegroundRoundedImageView(Context paramContext)
  {
    this(paramContext, null, 0);
  }
  
  public ForegroundRoundedImageView(Context paramContext, AttributeSet paramAttributeSet)
  {
    this(paramContext, paramAttributeSet, 0);
  }
  
  public ForegroundRoundedImageView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    paramContext = paramContext.obtainStyledAttributes(paramAttributeSet, R.styleable.ForegroundRoundedImageView, paramInt, 0);
    setForegroundDrawable(paramContext.getDrawable(R.styleable.ForegroundRoundedImageView_overlay));
    paramContext.recycle();
  }
  
  @TargetApi(21)
  public void drawableHotspotChanged(float paramFloat1, float paramFloat2)
  {
    super.drawableHotspotChanged(paramFloat1, paramFloat2);
    if (overlayDrawable != null) {
      overlayDrawable.setHotspot(paramFloat1, paramFloat2);
    }
  }
  
  protected void drawableStateChanged()
  {
    super.drawableStateChanged();
    Drawable localDrawable = overlayDrawable;
    if ((localDrawable != null) && (localDrawable.isStateful())) {
      localDrawable.setState(getDrawableState());
    }
  }
  
  public void jumpDrawablesToCurrentState()
  {
    super.jumpDrawablesToCurrentState();
    if (overlayDrawable != null) {
      overlayDrawable.jumpToCurrentState();
    }
  }
  
  protected void onDraw(Canvas paramCanvas)
  {
    super.onDraw(paramCanvas);
    if (overlayDrawable != null)
    {
      int i = paramCanvas.save();
      paramCanvas.translate(overlayDx, overlayDy);
      overlayDrawable.draw(paramCanvas);
      paramCanvas.restoreToCount(i);
    }
  }
  
  protected void onSizeChanged(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    super.onSizeChanged(paramInt1, paramInt2, paramInt3, paramInt4);
    if (overlayDrawable != null)
    {
      overlayDrawable.setBounds(0, 0, Math.max(overlayDrawable.getIntrinsicWidth(), paramInt1), Math.max(overlayDrawable.getIntrinsicHeight(), paramInt2));
      Rect localRect = overlayDrawable.getBounds();
      overlayDx = (paramInt1 / 2.0F - localRect.centerX());
      overlayDy = (paramInt2 / 2.0F - localRect.centerY());
      invalidate();
    }
  }
  
  public void setForegroundDrawable(int paramInt)
  {
    setForegroundDrawable(getResources().getDrawable(paramInt));
  }
  
  public void setForegroundDrawable(Drawable paramDrawable)
  {
    if (overlayDrawable != null)
    {
      overlayDrawable.setCallback(null);
      unscheduleDrawable(overlayDrawable);
    }
    overlayDrawable = paramDrawable;
    if (overlayDrawable != null)
    {
      overlayDrawable.setCallback(this);
      if (overlayDrawable.isStateful()) {
        overlayDrawable.setState(getDrawableState());
      }
    }
    requestLayout();
    invalidate();
  }
  
  protected boolean verifyDrawable(Drawable paramDrawable)
  {
    return (super.verifyDrawable(paramDrawable)) || (paramDrawable == overlayDrawable);
  }
}

/* Location:
 * Qualified Name:     com.lyft.widgets.ForegroundRoundedImageView
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */