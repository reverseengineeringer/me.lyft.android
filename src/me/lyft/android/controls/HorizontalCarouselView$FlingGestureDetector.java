package me.lyft.android.controls;

import android.view.GestureDetector;
import android.view.GestureDetector.SimpleOnGestureListener;
import android.view.MotionEvent;

class HorizontalCarouselView$FlingGestureDetector
  extends GestureDetector
{
  public HorizontalCarouselView$FlingGestureDetector(HorizontalCarouselView paramHorizontalCarouselView)
  {
    super(new GestureDetector.SimpleOnGestureListener()
    {
      public boolean onFling(MotionEvent paramAnonymousMotionEvent1, MotionEvent paramAnonymousMotionEvent2, float paramAnonymousFloat1, float paramAnonymousFloat2)
      {
        if ((paramAnonymousMotionEvent1 == null) || (paramAnonymousMotionEvent2 == null)) {
          return true;
        }
        paramAnonymousFloat2 = paramAnonymousMotionEvent1.getX();
        float f = paramAnonymousMotionEvent2.getX();
        if ((HorizontalCarouselView.access$100(HorizontalCarouselView.FlingGestureDetector.this, paramAnonymousFloat2, f)) || (HorizontalCarouselView.access$700(HorizontalCarouselView.FlingGestureDetector.this, paramAnonymousFloat1)))
        {
          HorizontalCarouselView.access$300(HorizontalCarouselView.FlingGestureDetector.this, HorizontalCarouselView.access$200(HorizontalCarouselView.FlingGestureDetector.this));
          return true;
        }
        if ((HorizontalCarouselView.access$400(HorizontalCarouselView.FlingGestureDetector.this, paramAnonymousFloat2, f)) || (HorizontalCarouselView.access$800(HorizontalCarouselView.FlingGestureDetector.this, paramAnonymousFloat1)))
        {
          HorizontalCarouselView.access$300(HorizontalCarouselView.FlingGestureDetector.this, HorizontalCarouselView.access$500(HorizontalCarouselView.FlingGestureDetector.this));
          return true;
        }
        return false;
      }
    });
  }
}

/* Location:
 * Qualified Name:     me.lyft.android.controls.HorizontalCarouselView.FlingGestureDetector
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */