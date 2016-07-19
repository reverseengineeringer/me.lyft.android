package me.lyft.android.ui.driver.ridescreens.tabs;

import dagger.Module;
import me.lyft.android.controls.DriverBottomNavigationView;
import me.lyft.android.controls.DriverToolbar;
import me.lyft.android.ui.MainActivityModule;

@Module(addsTo=MainActivityModule.class, injects={DriverReferralController.class, DriverToolbar.class, DriverBottomNavigationView.class})
public class DriverReferralModule {}

/* Location:
 * Qualified Name:     me.lyft.android.ui.driver.ridescreens.tabs.DriverReferralModule
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */