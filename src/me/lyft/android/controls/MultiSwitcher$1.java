package me.lyft.android.controls;

import android.view.GestureDetector.SimpleOnGestureListener;
import android.view.MotionEvent;
import me.lyft.android.common.Unit;
import rx.functions.Action0;
import rx.subjects.PublishSubject;

class MultiSwitcher$1
  extends GestureDetector.SimpleOnGestureListener
{
  MultiSwitcher$1(MultiSwitcher paramMultiSwitcher) {}
  
  public boolean onSingleTapUp(MotionEvent paramMotionEvent)
  {
    if (MultiSwitcher.access$000(this$0) == MultiSwitcher.access$100(this$0))
    {
      MultiSwitcher.access$200(this$0).onNext(Unit.create());
      MultiSwitcher.access$300(this$0).call();
    }
    return false;
  }
}

/* Location:
 * Qualified Name:     me.lyft.android.controls.MultiSwitcher.1
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */