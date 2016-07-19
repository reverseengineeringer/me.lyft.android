package me.lyft.android.controls;

import android.view.View;
import android.view.View.OnClickListener;
import me.lyft.android.common.AppFlow;
import me.lyft.android.ui.driver.ridescreens.tabs.DriverReferralScreen;

class DriverBottomNavigationView$3
  implements View.OnClickListener
{
  DriverBottomNavigationView$3(DriverBottomNavigationView paramDriverBottomNavigationView) {}
  
  public void onClick(View paramView)
  {
    this$0.appFlow.replaceWith(new DriverReferralScreen());
  }
}

/* Location:
 * Qualified Name:     me.lyft.android.controls.DriverBottomNavigationView.3
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */