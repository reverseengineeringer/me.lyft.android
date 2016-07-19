package me.lyft.android.application.autofill;

import me.lyft.android.application.features.Features;
import me.lyft.android.application.features.IFeaturesProvider;
import me.lyft.android.application.ride.IRideRequestSession;
import me.lyft.android.common.Strings;
import me.lyft.android.domain.location.Location;
import me.lyft.android.domain.passenger.ride.PassengerRideRequest.RequestRideStep;

public class AutoFillResolutionService
{
  private final AutoFillAnalytics autoFillAnalytics;
  private final IFeaturesProvider featuresProvider;
  private final IRideRequestSession rideRequestSession;
  
  public AutoFillResolutionService(IRideRequestSession paramIRideRequestSession, AutoFillAnalytics paramAutoFillAnalytics, IFeaturesProvider paramIFeaturesProvider)
  {
    rideRequestSession = paramIRideRequestSession;
    autoFillAnalytics = paramAutoFillAnalytics;
    featuresProvider = paramIFeaturesProvider;
  }
  
  private boolean setDropoff(Location paramLocation)
  {
    if (paramLocation.isNull()) {}
    while (!rideRequestSession.getDropoffLocation().isNull()) {
      return false;
    }
    autoFillAnalytics.trackAutoFillDropoffSuccess();
    rideRequestSession.setDropoffLocation(paramLocation);
    return true;
  }
  
  private boolean setPickup(Location paramLocation)
  {
    if (paramLocation.isNull()) {}
    Location localLocation;
    do
    {
      return false;
      localLocation = rideRequestSession.getPickupLocation();
    } while ((!localLocation.isNull()) && (!Strings.equalsIgnoreCase(localLocation.getSource(), "defaultLocation")));
    autoFillAnalytics.trackAutoFillPickupSuccess();
    rideRequestSession.setPickupLocation(paramLocation);
    return true;
  }
  
  private boolean shouldPrefillRideType(String paramString, boolean paramBoolean)
  {
    return (paramBoolean) && (!Strings.isNullOrEmpty(paramString));
  }
  
  public boolean autoFill(Location paramLocation1, Location paramLocation2, String paramString)
  {
    boolean bool2 = setPickup(paramLocation1);
    boolean bool1 = false;
    if (bool2) {
      bool1 = setDropoff(paramLocation2);
    }
    if (shouldPrefillRideType(paramString, bool2)) {
      rideRequestSession.setCurrentRideTypeById(paramString);
    }
    if ((bool2) && (bool1)) {}
    for (bool1 = true;; bool1 = false)
    {
      if (bool1)
      {
        autoFillAnalytics.trackAutoFillRideStepExposure();
        if (featuresProvider.isEnabled(Features.PREFILL_FORWARD_TO_CONFIRM_STEP)) {
          rideRequestSession.setRequestRideStep(PassengerRideRequest.RequestRideStep.CONFIRM_REQUEST_WITH_DESTINATION);
        }
      }
      return bool1;
    }
  }
}

/* Location:
 * Qualified Name:     me.lyft.android.application.autofill.AutoFillResolutionService
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */