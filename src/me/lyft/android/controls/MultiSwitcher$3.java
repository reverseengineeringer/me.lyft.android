package me.lyft.android.controls;

import android.animation.Animator;
import com.lyft.widgets.SimpleAnimationListener;
import me.lyft.android.common.Unit;
import rx.subjects.PublishSubject;

class MultiSwitcher$3
  extends SimpleAnimationListener
{
  MultiSwitcher$3(MultiSwitcher paramMultiSwitcher) {}
  
  public void onAnimationCancel(Animator paramAnimator)
  {
    super.onAnimationCancel(paramAnimator);
    MultiSwitcher.access$1202(this$0, false);
    MultiSwitcher.access$1300(this$0).onNext(Unit.create());
  }
  
  public void onAnimationEnd(Animator paramAnimator)
  {
    super.onAnimationEnd(paramAnimator);
    MultiSwitcher.access$1202(this$0, false);
    MultiSwitcher.access$1300(this$0).onNext(Unit.create());
    this$0.updateThumb();
  }
}

/* Location:
 * Qualified Name:     me.lyft.android.controls.MultiSwitcher.3
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */