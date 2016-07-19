package com.appboy.ui;

import android.view.GestureDetector.SimpleOnGestureListener;
import android.view.MotionEvent;
import android.widget.ListView;

public class AppboyFeedFragment$FeedGestureListener
  extends GestureDetector.SimpleOnGestureListener
{
  public AppboyFeedFragment$FeedGestureListener(AppboyFeedFragment paramAppboyFeedFragment) {}
  
  public boolean onDown(MotionEvent paramMotionEvent)
  {
    return true;
  }
  
  public boolean onFling(MotionEvent paramMotionEvent1, MotionEvent paramMotionEvent2, float paramFloat1, float paramFloat2)
  {
    long l = (paramMotionEvent2.getEventTime() - paramMotionEvent1.getEventTime()) * 2L;
    int i = (int)((float)l * paramFloat2 / 1000.0F);
    this$0.getListView().smoothScrollBy(-i, (int)(l * 2L));
    return true;
  }
  
  public boolean onScroll(MotionEvent paramMotionEvent1, MotionEvent paramMotionEvent2, float paramFloat1, float paramFloat2)
  {
    this$0.getListView().smoothScrollBy((int)paramFloat2, 0);
    return true;
  }
}

/* Location:
 * Qualified Name:     com.appboy.ui.AppboyFeedFragment.FeedGestureListener
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */