package me.lyft.android.ui.driver.carpool.screens;

import dagger.Module;
import me.lyft.android.ui.driver.carpool.DriverCarpoolRequestFooterView;
import me.lyft.android.ui.driver.carpool.DriverCarpoolRidesModule;

@Module(addsTo=DriverCarpoolRidesModule.class, injects={DriverRequestsPendingController.class, DriverCarpoolRequestFooterView.class})
public class DriverRequestsPendingModule {}

/* Location:
 * Qualified Name:     me.lyft.android.ui.driver.carpool.screens.DriverRequestsPendingModule
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */