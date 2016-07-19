package com.lyft.widgets;

import android.graphics.Rect;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnTouchListener;

class Toggle$2
  implements View.OnTouchListener
{
  Toggle$2(Toggle paramToggle) {}
  
  public boolean onTouch(View paramView, MotionEvent paramMotionEvent)
  {
    boolean bool = false;
    if (paramMotionEvent.getAction() == 0)
    {
      float f = Toggle.access$000(this$0).getWidth() - Toggle.access$100(this$0).getWidth();
      Toggle.access$200(this$0, (int)f);
    }
    for (;;)
    {
      return true;
      if (paramMotionEvent.getAction() != 1) {
        break;
      }
      if (new Rect(paramView.getLeft(), paramView.getTop(), paramView.getRight(), paramView.getBottom()).contains(paramView.getLeft() + (int)paramMotionEvent.getX(), paramView.getTop() + (int)paramMotionEvent.getY()))
      {
        paramView = this$0;
        if (!Toggle.access$300(this$0)) {
          bool = true;
        }
        paramView.setChecked(bool, true);
      }
    }
    this$0.setChecked(Toggle.access$300(this$0), false);
    return false;
  }
}

/* Location:
 * Qualified Name:     com.lyft.widgets.Toggle.2
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */