package me.lyft.android.controls;

import java.lang.annotation.Annotation;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

public abstract interface CustomPicker$OnScrollListener
{
  public static final int SCROLL_STATE_FLING = 2;
  public static final int SCROLL_STATE_IDLE = 0;
  public static final int SCROLL_STATE_TOUCH_SCROLL = 1;
  
  public abstract void onScrollStateChange(CustomPicker paramCustomPicker, int paramInt);
  
  @Retention(RetentionPolicy.SOURCE)
  public static @interface ScrollState {}
}

/* Location:
 * Qualified Name:     me.lyft.android.controls.CustomPicker.OnScrollListener
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */