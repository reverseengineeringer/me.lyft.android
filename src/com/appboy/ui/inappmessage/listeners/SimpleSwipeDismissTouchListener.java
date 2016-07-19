package com.appboy.ui.inappmessage.listeners;

import android.content.Context;
import android.view.GestureDetector;
import android.view.GestureDetector.SimpleOnGestureListener;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnTouchListener;

public class SimpleSwipeDismissTouchListener
  implements View.OnTouchListener
{
  private final GestureDetector mSwipeGestureListener = new GestureDetector(paramContext, new SwipeGestureListener(null));
  
  public SimpleSwipeDismissTouchListener(Context paramContext) {}
  
  public void onSwipeLeft() {}
  
  public void onSwipeRight() {}
  
  public boolean onTouch(View paramView, MotionEvent paramMotionEvent)
  {
    return mSwipeGestureListener.onTouchEvent(paramMotionEvent);
  }
  
  private final class SwipeGestureListener
    extends GestureDetector.SimpleOnGestureListener
  {
    private static final int SWIPE_DISTANCE_THRESHOLD = 120;
    private static final int SWIPE_VELOCITY_THRESHOLD = 90;
    
    private SwipeGestureListener() {}
    
    public boolean onFling(MotionEvent paramMotionEvent1, MotionEvent paramMotionEvent2, float paramFloat1, float paramFloat2)
    {
      paramFloat2 = paramMotionEvent2.getX() - paramMotionEvent1.getX();
      float f1 = paramMotionEvent2.getY();
      float f2 = paramMotionEvent1.getY();
      if ((Math.abs(paramFloat2) > Math.abs(f1 - f2)) && (Math.abs(paramFloat2) > 120.0F) && (Math.abs(paramFloat1) > 90.0F))
      {
        if (paramFloat2 > 0.0F) {
          onSwipeRight();
        }
        for (;;)
        {
          return true;
          onSwipeLeft();
        }
      }
      return false;
    }
  }
}

/* Location:
 * Qualified Name:     com.appboy.ui.inappmessage.listeners.SimpleSwipeDismissTouchListener
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */