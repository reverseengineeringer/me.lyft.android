package me.lyft.android.ui.driver.ridescreens;

import dagger.Module;
import me.lyft.android.ui.driver.DriverRideAcceptEtaView;
import me.lyft.android.ui.driver.DriverRideAcceptSlidableView;

@Module(addsTo=DriverRideModule.class, injects={DriverRideAcceptSlidableView.class, DriverRideAcceptEtaView.class, DriverRideAcceptController.class})
public class DriverRideAcceptModule {}

/* Location:
 * Qualified Name:     me.lyft.android.ui.driver.ridescreens.DriverRideAcceptModule
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */