package me.lyft.android.controls;

import android.view.GestureDetector;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnTouchListener;

class MultiSwitcher$2
  implements View.OnTouchListener
{
  public float lastTouchX;
  
  MultiSwitcher$2(MultiSwitcher paramMultiSwitcher) {}
  
  public boolean onTouch(View paramView, MotionEvent paramMotionEvent)
  {
    switch (paramMotionEvent.getActionMasked())
    {
    }
    for (;;)
    {
      return MultiSwitcher.access$1100(this$0).onTouchEvent(paramMotionEvent);
      MultiSwitcher.access$102(this$0, MultiSwitcher.access$000(this$0));
      lastTouchX = paramMotionEvent.getX();
      MultiSwitcher.access$400(this$0);
      continue;
      float f1 = lastTouchX;
      float f2 = paramMotionEvent.getX();
      f2 = MultiSwitcher.access$500(this$0) - (f1 - f2);
      f1 = f2;
      if (f2 <= 0.0F) {
        f1 = 0.0F;
      }
      f2 = f1;
      if (f1 >= MultiSwitcher.access$600(this$0)) {
        f2 = MultiSwitcher.access$600(this$0);
      }
      if (f2 >= 0.0F) {
        MultiSwitcher.access$700(this$0, (int)f2);
      }
      MultiSwitcher.access$802(this$0, true);
      MultiSwitcher.access$900(this$0);
      continue;
      MultiSwitcher.access$1002(this$0, true);
      MultiSwitcher.access$802(this$0, false);
      this$0.animateToItemIndex(MultiSwitcher.access$000(this$0));
    }
  }
}

/* Location:
 * Qualified Name:     me.lyft.android.controls.MultiSwitcher.2
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */