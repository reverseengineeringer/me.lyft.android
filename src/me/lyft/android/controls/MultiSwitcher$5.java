package me.lyft.android.controls;

import com.lyft.widgets.ISwitcherItem;
import com.lyft.widgets.SwitcherSelection;
import me.lyft.android.common.Unit;
import rx.functions.Action1;
import rx.subjects.PublishSubject;

class MultiSwitcher$5
  implements Action1<Unit>
{
  MultiSwitcher$5(MultiSwitcher paramMultiSwitcher, ISwitcherItem paramISwitcherItem, boolean paramBoolean) {}
  
  public void call(Unit paramUnit)
  {
    paramUnit = new SwitcherSelection(val$selectedItem, val$wasUserAction);
    MultiSwitcher.access$1800(this$0).onNext(paramUnit);
    MultiSwitcher.access$1900(this$0).call(paramUnit);
  }
}

/* Location:
 * Qualified Name:     me.lyft.android.controls.MultiSwitcher.5
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */