package com.appboy.ui.inappmessage.listeners;

import android.view.MotionEvent;
import android.view.View;

public class TouchAwareSwipeDismissTouchListener
  extends SwipeDismissTouchListener
{
  private ITouchListener mTouchListener;
  
  public TouchAwareSwipeDismissTouchListener(View paramView, Object paramObject, SwipeDismissTouchListener.DismissCallbacks paramDismissCallbacks)
  {
    super(paramView, paramObject, paramDismissCallbacks);
  }
  
  public boolean onTouch(View paramView, MotionEvent paramMotionEvent)
  {
    switch (paramMotionEvent.getAction())
    {
    }
    for (;;)
    {
      return super.onTouch(paramView, paramMotionEvent);
      if (mTouchListener != null)
      {
        mTouchListener.onTouchStartedOrContinued();
        continue;
        if (mTouchListener != null) {
          mTouchListener.onTouchEnded();
        }
      }
    }
  }
  
  public void setTouchListener(ITouchListener paramITouchListener)
  {
    mTouchListener = paramITouchListener;
  }
  
  public static abstract interface ITouchListener
  {
    public abstract void onTouchEnded();
    
    public abstract void onTouchStartedOrContinued();
  }
}

/* Location:
 * Qualified Name:     com.appboy.ui.inappmessage.listeners.TouchAwareSwipeDismissTouchListener
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */