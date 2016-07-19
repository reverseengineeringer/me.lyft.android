package me.lyft.android.ui.driver.shortcut;

import android.view.MotionEvent;

public abstract interface FloatingViewListener
{
  public abstract void onFinishFloatingView();
  
  public abstract void onModeToggleActionUp();
  
  public abstract void onSingleTapUp(MotionEvent paramMotionEvent);
  
  public abstract void onTrashActionUp();
}

/* Location:
 * Qualified Name:     me.lyft.android.ui.driver.shortcut.FloatingViewListener
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */