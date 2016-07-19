package me.lyft.android.ui.ridehistory;

import android.content.res.Resources;
import android.support.v4.view.ViewPager;
import android.view.View;
import javax.inject.Inject;
import me.lyft.android.common.RxViewController;
import me.lyft.android.controls.Toolbar;
import me.lyft.android.ui.driver.ViewPagerTabLayout;

public class PassengerRideHistoryController
  extends RxViewController
{
  private PassengerRideHistoryPagerAdapter passengerRideHistoryPagerAdapter;
  ViewPager rideHistoryPager;
  ViewPagerTabLayout tabsLayout;
  Toolbar toolbar;
  
  protected int layoutId()
  {
    return 2130903354;
  }
  
  public void onAttach()
  {
    super.onAttach();
    toolbar.setTitle(getResources().getString(2131166272));
    toolbar.hideDivider();
    passengerRideHistoryPagerAdapter = new PassengerRideHistoryPagerAdapter(getView().getContext());
    rideHistoryPager.setAdapter(passengerRideHistoryPagerAdapter);
    tabsLayout.setViewPager(rideHistoryPager);
    tabsLayout.selectTab(0);
  }
}

/* Location:
 * Qualified Name:     me.lyft.android.ui.ridehistory.PassengerRideHistoryController
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */