package me.lyft.android.infrastructure.appboy;

import android.view.View;
import butterknife.internal.DebouncingOnClickListener;

class CustomAppboyInAppDialog$$ViewBinder$1
  extends DebouncingOnClickListener
{
  CustomAppboyInAppDialog$$ViewBinder$1(CustomAppboyInAppDialog..ViewBinder paramViewBinder, CustomAppboyInAppDialog paramCustomAppboyInAppDialog) {}
  
  public void doClick(View paramView)
  {
    val$target.onCancelClicked();
  }
}

/* Location:
 * Qualified Name:     me.lyft.android.infrastructure.appboy.CustomAppboyInAppDialog..ViewBinder.1
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */