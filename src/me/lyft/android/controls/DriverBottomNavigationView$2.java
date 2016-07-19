package me.lyft.android.controls;

import android.view.View;
import android.view.View.OnClickListener;
import me.lyft.android.application.features.Features;
import me.lyft.android.application.features.IFeaturesProvider;
import me.lyft.android.common.AppFlow;
import me.lyft.android.ui.driver.ridescreens.tabs.DriverEarningsScreen;
import me.lyft.android.ui.driver.ridescreens.tabs.DriverEarningsScreenV2;

class DriverBottomNavigationView$2
  implements View.OnClickListener
{
  DriverBottomNavigationView$2(DriverBottomNavigationView paramDriverBottomNavigationView) {}
  
  public void onClick(View paramView)
  {
    if (this$0.featuresProvider.isEnabled(Features.SHOW_DRIVER_EARNINGS_V2))
    {
      this$0.appFlow.replaceWith(new DriverEarningsScreenV2());
      return;
    }
    this$0.appFlow.replaceWith(new DriverEarningsScreen());
  }
}

/* Location:
 * Qualified Name:     me.lyft.android.controls.DriverBottomNavigationView.2
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */