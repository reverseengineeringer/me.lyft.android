package me.lyft.android.controls;

import android.view.GestureDetector;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnTouchListener;

class HorizontalCarouselView$1
  implements View.OnTouchListener
{
  float lastXPosition = 0.0F;
  
  HorizontalCarouselView$1(HorizontalCarouselView paramHorizontalCarouselView) {}
  
  public boolean onTouch(View paramView, MotionEvent paramMotionEvent)
  {
    if (HorizontalCarouselView.access$000(this$0).onTouchEvent(paramMotionEvent)) {
      return true;
    }
    switch (paramMotionEvent.getAction())
    {
    case 2: 
    default: 
    case 0: 
      for (;;)
      {
        return false;
        lastXPosition = paramMotionEvent.getX();
      }
    }
    if (HorizontalCarouselView.access$100(this$0, lastXPosition, paramMotionEvent.getX()))
    {
      HorizontalCarouselView.access$300(this$0, HorizontalCarouselView.access$200(this$0));
      return true;
    }
    if (HorizontalCarouselView.access$400(this$0, lastXPosition, paramMotionEvent.getX()))
    {
      HorizontalCarouselView.access$300(this$0, HorizontalCarouselView.access$500(this$0));
      return true;
    }
    HorizontalCarouselView.access$300(this$0, HorizontalCarouselView.access$600(this$0));
    return true;
  }
}

/* Location:
 * Qualified Name:     me.lyft.android.controls.HorizontalCarouselView.1
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */