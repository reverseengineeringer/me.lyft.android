package com.lyft.widgets;

import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnTouchListener;
import android.view.ViewParent;

class Toggle$3
  implements View.OnTouchListener
{
  private final int TAP_DRAG_THRESHOLD = 10;
  private float touchDownX;
  
  Toggle$3(Toggle paramToggle) {}
  
  public boolean onTouch(View paramView, MotionEvent paramMotionEvent)
  {
    boolean bool2 = false;
    boolean bool1 = false;
    if (paramMotionEvent.getAction() == 0)
    {
      this$0.getParent().requestDisallowInterceptTouchEvent(true);
      touchDownX = paramMotionEvent.getX();
    }
    for (;;)
    {
      bool1 = true;
      do
      {
        return bool1;
        if (paramMotionEvent.getAction() == 2)
        {
          float f2 = paramView.getTranslationX() + paramMotionEvent.getX() - touchDownX;
          float f1;
          if (f2 < 0.0F) {
            f1 = 0.0F;
          }
          for (;;)
          {
            Toggle.access$200(this$0, (int)f1);
            break;
            f1 = f2;
            if (f2 > Toggle.access$000(this$0).getWidth() - Toggle.access$100(this$0).getWidth()) {
              f1 = Toggle.access$000(this$0).getWidth() - Toggle.access$100(this$0).getWidth();
            }
          }
        }
      } while (paramMotionEvent.getAction() != 1);
      if (Math.abs(paramMotionEvent.getX() - touchDownX) < 10.0F)
      {
        paramView = this$0;
        bool1 = bool2;
        if (!Toggle.access$300(this$0)) {
          bool1 = true;
        }
        paramView.setChecked(bool1, true);
      }
      else
      {
        Toggle.access$400(this$0);
      }
    }
  }
}

/* Location:
 * Qualified Name:     com.lyft.widgets.Toggle.3
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */