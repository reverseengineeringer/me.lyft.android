package me.lyft.android.controls;

import android.view.View;
import android.view.View.OnClickListener;
import me.lyft.android.common.AppFlow;
import me.lyft.android.ui.MainScreens.DriverRideScreen;

class DriverBottomNavigationView$1
  implements View.OnClickListener
{
  DriverBottomNavigationView$1(DriverBottomNavigationView paramDriverBottomNavigationView) {}
  
  public void onClick(View paramView)
  {
    this$0.appFlow.replaceWith(new MainScreens.DriverRideScreen());
  }
}

/* Location:
 * Qualified Name:     me.lyft.android.controls.DriverBottomNavigationView.1
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */