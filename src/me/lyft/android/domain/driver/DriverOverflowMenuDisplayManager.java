package me.lyft.android.domain.driver;

import me.lyft.android.application.IUserProvider;
import me.lyft.android.application.features.Features;
import me.lyft.android.application.features.IFeaturesProvider;
import me.lyft.android.application.ride.IDriverRideProvider;
import me.lyft.android.application.ride.IUserUiService;
import me.lyft.android.domain.User;
import me.lyft.android.domain.driver.ride.DriverRide;
import me.lyft.android.domain.driver.ride.DriverStop;
import me.lyft.android.domain.location.Location;

public class DriverOverflowMenuDisplayManager
{
  private final IDriverRideProvider driverRideProvider;
  private final IFeaturesProvider featuresProvider;
  private final IUserProvider userProvider;
  private final IUserUiService userUiService;
  
  public DriverOverflowMenuDisplayManager(IDriverRideProvider paramIDriverRideProvider, IFeaturesProvider paramIFeaturesProvider, IUserUiService paramIUserUiService, IUserProvider paramIUserProvider)
  {
    driverRideProvider = paramIDriverRideProvider;
    featuresProvider = paramIFeaturesProvider;
    userUiService = paramIUserUiService;
    userProvider = paramIUserProvider;
  }
  
  public boolean enableAboutLyftLineToolbarItem()
  {
    return (isRideActive()) && (isCourier());
  }
  
  public boolean enableCallPassengerToolbarItem()
  {
    return (isRideActive()) && (hasIncompleteStops());
  }
  
  public boolean enableCancelRideToolbarItem()
  {
    return (isRideActive()) && (hasIncompleteStops());
  }
  
  public boolean enableDriverDestinationToolbarItem()
  {
    return (!isRideActive()) && (featuresProvider.isEnabled(Features.DESTINY)) && (userUiService.getUiState().isDriverUi()) && (userProvider.getUser().getDriverDestination().isNull());
  }
  
  public boolean enableShowOverflowMenu()
  {
    return (enableAboutLyftLineToolbarItem()) || (enableCancelRideToolbarItem()) || (enableAboutLyftLineToolbarItem()) || (enableCallPassengerToolbarItem()) || (enableDriverDestinationToolbarItem());
  }
  
  public boolean hasIncompleteStops()
  {
    return !driverRideProvider.getDriverRide().getCurrentStop().isNull();
  }
  
  public boolean isCourier()
  {
    return driverRideProvider.getDriverRide().isCourier();
  }
  
  public boolean isRideActive()
  {
    return (driverRideProvider.getDriverRide().isPending()) || (driverRideProvider.getDriverRide().isInProgress());
  }
}

/* Location:
 * Qualified Name:     me.lyft.android.domain.driver.DriverOverflowMenuDisplayManager
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */