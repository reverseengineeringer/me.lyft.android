package com.lyft.widgets;

import me.lyft.android.common.Unit;
import rx.functions.Action1;

class Toggle$1
  implements Action1<Unit>
{
  Toggle$1(Toggle paramToggle) {}
  
  public void call(Unit paramUnit)
  {
    this$0.setChecked(this$0.isChecked(), true);
  }
}

/* Location:
 * Qualified Name:     com.lyft.widgets.Toggle.1
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */