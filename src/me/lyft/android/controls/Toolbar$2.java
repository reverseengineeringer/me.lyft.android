package me.lyft.android.controls;

import android.view.View;
import android.view.View.OnClickListener;
import rx.functions.Action1;
import rx.subjects.PublishSubject;

class Toolbar$2
  implements View.OnClickListener
{
  Toolbar$2(Toolbar paramToolbar, Toolbar.ToolbarItem paramToolbarItem) {}
  
  public void onClick(View paramView)
  {
    this$0.itemClick.onNext(val$toolbarItem);
    Toolbar.access$100(this$0).call(Integer.valueOf(Toolbar.ToolbarItem.access$000(val$toolbarItem)));
  }
}

/* Location:
 * Qualified Name:     me.lyft.android.controls.Toolbar.2
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */