package com.lyft.widgets;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.Paint.Style;
import android.graphics.RectF;
import android.graphics.SweepGradient;
import android.util.AttributeSet;
import android.view.View;

public class CircularProgressView
  extends View
{
  private final Paint backgroundPaint;
  private int gradientEndColor = -1;
  private int gradientStartColor = -1;
  private float lineThickness;
  private int maxProgress = 100;
  private int progress = 0;
  private final RectF progressOval;
  private final Paint progressPaint = new Paint();
  private int startAngle = -90;
  
  public CircularProgressView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    progressPaint.setColor(46592);
    progressPaint.setStyle(Paint.Style.STROKE);
    progressPaint.setAntiAlias(true);
    backgroundPaint = new Paint();
    backgroundPaint.setColor(-6447459);
    backgroundPaint.setStyle(Paint.Style.STROKE);
    backgroundPaint.setAntiAlias(true);
    progressOval = new RectF();
  }
  
  private void invalidateGradient()
  {
    if ((gradientStartColor != -1) && (gradientEndColor != -1))
    {
      int i = getWidth() / 2;
      int j = getHeight() / 2;
      Matrix localMatrix = new Matrix();
      localMatrix.preRotate(270.0F, i, j);
      SweepGradient localSweepGradient = new SweepGradient(i, j, gradientStartColor, gradientEndColor);
      localSweepGradient.setLocalMatrix(localMatrix);
      progressPaint.setShader(localSweepGradient);
    }
  }
  
  public void draw(Canvas paramCanvas)
  {
    super.draw(paramCanvas);
    progressOval.set(lineThickness, lineThickness, getWidth() - lineThickness, getHeight() - lineThickness);
    float f = 0.0F;
    if (maxProgress > 0) {
      f = progress / maxProgress * 360.0F;
    }
    paramCanvas.drawArc(progressOval, startAngle, 360.0F, false, backgroundPaint);
    paramCanvas.drawArc(progressOval, startAngle, f, false, progressPaint);
  }
  
  protected void onSizeChanged(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    super.onSizeChanged(paramInt1, paramInt2, paramInt3, paramInt4);
    invalidateGradient();
  }
  
  public void setBackgroundColor(int paramInt)
  {
    backgroundPaint.setColor(paramInt);
  }
  
  public void setGradientProgressColors(int paramInt1, int paramInt2)
  {
    gradientStartColor = paramInt1;
    gradientEndColor = paramInt2;
    invalidateGradient();
  }
  
  public void setLineThickness(float paramFloat)
  {
    lineThickness = paramFloat;
    progressPaint.setStrokeWidth(paramFloat);
    backgroundPaint.setStrokeWidth(paramFloat);
  }
  
  public void setMax(int paramInt)
  {
    maxProgress = paramInt;
    invalidate();
  }
  
  public void setProgress(int paramInt)
  {
    progress = paramInt;
    invalidate();
  }
  
  public void setProgressColor(int paramInt)
  {
    progressPaint.setColor(paramInt);
  }
  
  public void setStartAngle(int paramInt)
  {
    startAngle = paramInt;
  }
}

/* Location:
 * Qualified Name:     com.lyft.widgets.CircularProgressView
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */