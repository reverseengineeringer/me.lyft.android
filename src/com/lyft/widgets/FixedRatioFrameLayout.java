package com.lyft.widgets;

import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.view.View.MeasureSpec;
import android.widget.FrameLayout;
import me.lyft.android.logging.L;

public class FixedRatioFrameLayout
  extends FrameLayout
{
  private double aspectRatio;
  
  public FixedRatioFrameLayout(Context paramContext)
  {
    super(paramContext);
  }
  
  public FixedRatioFrameLayout(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    init(paramAttributeSet);
  }
  
  public FixedRatioFrameLayout(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    init(paramAttributeSet);
  }
  
  private void init(AttributeSet paramAttributeSet)
  {
    paramAttributeSet = getContext().obtainStyledAttributes(paramAttributeSet, R.styleable.FixedRatioFrameLayout);
    if (paramAttributeSet != null)
    {
      int j = paramAttributeSet.getIndexCount();
      int i = 0;
      while (i < j)
      {
        if (paramAttributeSet.getIndex(i) == R.styleable.FixedRatioFrameLayout_aspectRatio) {
          aspectRatio = paramAttributeSet.getFloat(R.styleable.FixedRatioFrameLayout_aspectRatio, 0.6306075F);
        }
        i += 1;
      }
    }
    paramAttributeSet.recycle();
  }
  
  public double getAspectRatio()
  {
    return aspectRatio;
  }
  
  protected void onMeasure(int paramInt1, int paramInt2)
  {
    super.onMeasure(paramInt1, paramInt2);
    paramInt1 = View.MeasureSpec.getSize(paramInt1);
    paramInt2 = View.MeasureSpec.getSize(paramInt2);
    L.d("original:" + paramInt1 + "X" + paramInt2, new Object[0]);
    paramInt2 = (int)(paramInt1 * aspectRatio);
    L.d("final:" + paramInt1 + "X" + paramInt2, new Object[0]);
    super.onMeasure(View.MeasureSpec.makeMeasureSpec(paramInt1, 1073741824), View.MeasureSpec.makeMeasureSpec(paramInt2, 1073741824));
  }
  
  public void setAspectRatio(double paramDouble)
  {
    aspectRatio = paramDouble;
  }
}

/* Location:
 * Qualified Name:     com.lyft.widgets.FixedRatioFrameLayout
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */