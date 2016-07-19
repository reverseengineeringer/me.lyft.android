package me.lyft.android.controls;

import android.view.View;
import android.view.View.OnClickListener;
import rx.functions.Action1;

class DriverToolbar$1
  implements View.OnClickListener
{
  DriverToolbar$1(DriverToolbar paramDriverToolbar) {}
  
  public void onClick(View paramView)
  {
    int i = paramView.getId();
    DriverToolbar.access$000(this$0).call(Integer.valueOf(i));
  }
}

/* Location:
 * Qualified Name:     me.lyft.android.controls.DriverToolbar.1
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */