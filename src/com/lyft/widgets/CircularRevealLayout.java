package com.lyft.widgets;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.RectF;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnTouchListener;
import android.view.animation.Animation;
import android.view.animation.Transformation;
import android.widget.RelativeLayout;

public class CircularRevealLayout
  extends RelativeLayout
{
  private RectF boundingBox;
  private float circleCenterX;
  private float circleCenterY;
  private float circleRadius;
  private float currentScaleAmount;
  private Paint paint;
  private float touchX;
  private float touchY;
  private float x;
  private float y;
  
  public CircularRevealLayout(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    initCircularReveal();
    initTouchListener();
  }
  
  private void initCircularReveal()
  {
    setWillNotDraw(false);
    paint = new Paint();
    paint.setColor(0);
    paint.setAntiAlias(true);
    circleRadius = 0.0F;
    x = 100.0F;
    y = 100.0F;
    boundingBox = new RectF();
    boundingBox.left = x;
    boundingBox.top = y;
    boundingBox.right = (x + circleRadius * 2.0F);
    boundingBox.bottom = (y + circleRadius * 2.0F);
    circleCenterX = (x + circleRadius);
    circleCenterY = (y + circleRadius);
  }
  
  private void initTouchListener()
  {
    setOnTouchListener(new View.OnTouchListener()
    {
      public boolean onTouch(View paramAnonymousView, MotionEvent paramAnonymousMotionEvent)
      {
        CircularRevealLayout.access$002(CircularRevealLayout.this, paramAnonymousMotionEvent.getX());
        CircularRevealLayout.access$102(CircularRevealLayout.this, paramAnonymousMotionEvent.getY());
        return false;
      }
    });
  }
  
  public void onDraw(Canvas paramCanvas)
  {
    circleRadius += currentScaleAmount;
    boundingBox.left = x;
    boundingBox.top = y;
    boundingBox.right = (x + circleRadius * 2.0F);
    boundingBox.bottom = (y + circleRadius * 2.0F);
    paramCanvas.drawCircle(circleCenterX, circleCenterY, circleRadius, paint);
  }
  
  public void reveal(int paramInt)
  {
    circleCenterX = touchX;
    circleCenterY = touchY;
    paint.setColor(paramInt);
    currentScaleAmount = 80.0F;
    Animation local1 = new Animation()
    {
      protected void applyTransformation(float paramAnonymousFloat, Transformation paramAnonymousTransformation)
      {
        invalidate();
      }
    };
    local1.setDuration(2000L);
    startAnimation(local1);
  }
}

/* Location:
 * Qualified Name:     com.lyft.widgets.CircularRevealLayout
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */