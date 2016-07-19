package me.lyft.android.controls;

import android.view.GestureDetector.SimpleOnGestureListener;
import android.view.MotionEvent;

class HorizontalCarouselView$FlingGestureDetector$1
  extends GestureDetector.SimpleOnGestureListener
{
  HorizontalCarouselView$FlingGestureDetector$1(HorizontalCarouselView paramHorizontalCarouselView) {}
  
  public boolean onFling(MotionEvent paramMotionEvent1, MotionEvent paramMotionEvent2, float paramFloat1, float paramFloat2)
  {
    if ((paramMotionEvent1 == null) || (paramMotionEvent2 == null)) {
      return true;
    }
    paramFloat2 = paramMotionEvent1.getX();
    float f = paramMotionEvent2.getX();
    if ((HorizontalCarouselView.access$100(val$this$0, paramFloat2, f)) || (HorizontalCarouselView.access$700(val$this$0, paramFloat1)))
    {
      HorizontalCarouselView.access$300(val$this$0, HorizontalCarouselView.access$200(val$this$0));
      return true;
    }
    if ((HorizontalCarouselView.access$400(val$this$0, paramFloat2, f)) || (HorizontalCarouselView.access$800(val$this$0, paramFloat1)))
    {
      HorizontalCarouselView.access$300(val$this$0, HorizontalCarouselView.access$500(val$this$0));
      return true;
    }
    return false;
  }
}

/* Location:
 * Qualified Name:     me.lyft.android.controls.HorizontalCarouselView.FlingGestureDetector.1
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */