package me.lyft.android.services;

import android.view.GestureDetector.SimpleOnGestureListener;
import android.view.MotionEvent;
import me.lyft.android.analytics.studies.DriverAnalytics;

class LyftDriverToggleService$6
  extends GestureDetector.SimpleOnGestureListener
{
  LyftDriverToggleService$6(LyftDriverToggleService paramLyftDriverToggleService) {}
  
  public boolean onSingleTapUp(MotionEvent paramMotionEvent)
  {
    DriverAnalytics.trackDriverDefenseButtonTap();
    LyftDriverToggleService.access$1200(this$0, "driver_toggle_tap");
    this$0.stopSelf();
    return true;
  }
}

/* Location:
 * Qualified Name:     me.lyft.android.services.LyftDriverToggleService.6
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */