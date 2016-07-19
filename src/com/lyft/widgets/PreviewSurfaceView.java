package com.lyft.widgets;

import android.content.Context;
import android.util.AttributeSet;
import android.view.SurfaceHolder;
import android.view.SurfaceView;
import android.view.ViewGroup.LayoutParams;

public class PreviewSurfaceView
  extends SurfaceView
{
  public PreviewSurfaceView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    if (isInEditMode()) {
      return;
    }
    setZOrderMediaOverlay(true);
    getHolder().setType(3);
  }
  
  private void setLayoutSize(int paramInt)
  {
    ViewGroup.LayoutParams localLayoutParams = getLayoutParams();
    if ((width != paramInt) || (height != paramInt))
    {
      width = paramInt;
      height = paramInt;
      setLayoutParams(localLayoutParams);
    }
  }
}

/* Location:
 * Qualified Name:     com.lyft.widgets.PreviewSurfaceView
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */