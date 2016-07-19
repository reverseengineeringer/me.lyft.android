package com.tune.crosspromo;

import android.graphics.Rect;
import android.view.TouchDelegate;
import android.view.View;
import android.widget.ImageButton;

class TuneCloseButton$1
  implements Runnable
{
  TuneCloseButton$1(TuneCloseButton paramTuneCloseButton, float paramFloat) {}
  
  public void run()
  {
    Object localObject = new Rect();
    TuneCloseButton.access$000(this$0).getHitRect((Rect)localObject);
    int i = (int)(12.0F * val$density + 0.5D);
    top -= i;
    left -= i;
    bottom += i;
    right += i;
    localObject = new TouchDelegate((Rect)localObject, TuneCloseButton.access$000(this$0));
    if (View.class.isInstance(TuneCloseButton.access$000(this$0).getParent())) {
      ((View)TuneCloseButton.access$000(this$0).getParent()).setTouchDelegate((TouchDelegate)localObject);
    }
  }
}

/* Location:
 * Qualified Name:     com.tune.crosspromo.TuneCloseButton.1
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */