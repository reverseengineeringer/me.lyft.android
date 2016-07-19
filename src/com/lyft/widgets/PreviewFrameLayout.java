package com.lyft.widgets;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View.MeasureSpec;
import android.view.ViewGroup;
import android.widget.FrameLayout;

public class PreviewFrameLayout
  extends ViewGroup
{
  private double aspectRatio = 1.3333333333333333D;
  private FrameLayout frame;
  private OnSizeChangedListener sizeChangedListener;
  
  public PreviewFrameLayout(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
  }
  
  protected void onFinishInflate()
  {
    super.onFinishInflate();
    frame = ((FrameLayout)findViewById(R.id.frame));
    if (frame == null) {
      throw new IllegalStateException("must provide child with id as \"frame\"");
    }
  }
  
  protected void onLayout(boolean paramBoolean, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    int m = getWidth();
    getHeight();
    FrameLayout localFrameLayout = frame;
    int k = localFrameLayout.getPaddingLeft() + localFrameLayout.getPaddingRight();
    int i = localFrameLayout.getPaddingBottom();
    int j = localFrameLayout.getPaddingTop();
    int n = m - k;
    m = (int)(n / aspectRatio + 0.5D);
    k = n + k;
    i = m + (i + j);
    j = (paramInt3 - paramInt1 - k) / 2;
    m = (paramInt4 - paramInt2 - i) / 2;
    frame.measure(View.MeasureSpec.makeMeasureSpec(k, 1073741824), View.MeasureSpec.makeMeasureSpec(i, 1073741824));
    frame.layout(paramInt1 + j, paramInt2 + m, paramInt3 - j, paramInt4 - m);
    if (sizeChangedListener != null) {
      sizeChangedListener.onSizeChanged();
    }
  }
  
  public void setAspectRatio(double paramDouble)
  {
    if (paramDouble <= 0.0D) {
      throw new IllegalArgumentException();
    }
    if (aspectRatio != paramDouble)
    {
      aspectRatio = paramDouble;
      requestLayout();
    }
  }
  
  public void setOnSizeChangedListener(OnSizeChangedListener paramOnSizeChangedListener)
  {
    sizeChangedListener = paramOnSizeChangedListener;
  }
  
  public static abstract interface OnSizeChangedListener
  {
    public abstract void onSizeChanged();
  }
}

/* Location:
 * Qualified Name:     com.lyft.widgets.PreviewFrameLayout
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */