package com.leanplum.views;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Paint.Style;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import com.leanplum.utils.SizeUtil;

public class CloseButton
  extends View
{
  private Paint a = new Paint();
  private Paint b = new Paint();
  private Paint c = new Paint();
  private float d;
  private float e;
  private float f;
  private float g;
  private float h;
  private boolean i = false;
  
  public CloseButton(Context paramContext)
  {
    super(paramContext);
    a();
  }
  
  public CloseButton(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    a();
  }
  
  private final void a()
  {
    a.setAntiAlias(true);
    a.setColor(-2236963);
    a.setStrokeWidth(2.0F);
    a.setStyle(Paint.Style.FILL_AND_STROKE);
    b.setAntiAlias(true);
    b.setColor(-6710887);
    b.setStrokeWidth(2.0F);
    b.setStyle(Paint.Style.FILL_AND_STROKE);
    c.setAntiAlias(true);
    c.setColor(-16777216);
    c.setStrokeWidth(3.0F);
    c.setStyle(Paint.Style.FILL_AND_STROKE);
    d = SizeUtil.dp30;
    e = (d * 0.33333334F);
    g = (d * 0.6666667F);
    f = (d * 0.33333334F);
    h = (d * 0.6666667F);
  }
  
  protected void onDraw(Canvas paramCanvas)
  {
    super.onDraw(paramCanvas);
    if (i) {}
    for (Paint localPaint = b;; localPaint = a)
    {
      paramCanvas.drawCircle(getWidth() / 2, getHeight() / 2, getWidth() / 2 - 1, localPaint);
      paramCanvas.drawLine(e, f, g, h, c);
      paramCanvas.drawLine(g, f, e, h, c);
      return;
    }
  }
  
  protected void onMeasure(int paramInt1, int paramInt2)
  {
    super.onMeasure(paramInt1, paramInt1);
    setMeasuredDimension((int)d, (int)d);
  }
  
  public boolean onTouchEvent(MotionEvent paramMotionEvent)
  {
    if (paramMotionEvent.getAction() == 0)
    {
      i = true;
      invalidate();
      return true;
    }
    if (paramMotionEvent.getAction() == 1)
    {
      i = false;
      invalidate();
      performClick();
      return true;
    }
    return super.onTouchEvent(paramMotionEvent);
  }
  
  public boolean performClick()
  {
    return super.performClick();
  }
}

/* Location:
 * Qualified Name:     com.leanplum.views.CloseButton
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */