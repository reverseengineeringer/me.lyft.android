package me.lyft.android.application.ride;

import me.lyft.android.domain.cost.CostEstimate;
import me.lyft.android.domain.location.Location;
import me.lyft.android.domain.passenger.ride.PassengerRideRequest.RequestRideStep;
import me.lyft.android.domain.passenger.ridetypes.RequestRideType;
import me.lyft.android.domain.ride.ScheduledInterval;
import me.lyft.android.domain.time.TimeRange;
import me.lyft.android.domain.venue.VenuePickupLocation;
import rx.Observable;

public abstract interface IRideRequestSession
{
  public abstract void clearConfirmations();
  
  public abstract void clearPartySize();
  
  public abstract void clearRideRequest();
  
  public abstract void confirmDynamicPricing();
  
  public abstract void confirmPickupLocation();
  
  public abstract CostEstimate getCostEstimate();
  
  public abstract RequestRideType getCurrentRideType();
  
  public abstract Location getDropoffLocation();
  
  public abstract String getForceDestinationErrorMessage();
  
  public abstract int getPartySize();
  
  public abstract Location getPickupLocation();
  
  public abstract PassengerRideRequest.RequestRideStep getRequestRideStep();
  
  public abstract ScheduledInterval getScheduledInterval();
  
  public abstract TimeRange getScheduledPickupTimeRange();
  
  public abstract boolean getShouldShowCourierPromoBanner();
  
  public abstract String getVenuePickupLocationAddress();
  
  public abstract float getZoomLevel();
  
  public abstract boolean hasVenuePickupLocation();
  
  public abstract boolean isDynamicPricingConfirmed();
  
  public abstract boolean isForceDestination();
  
  public abstract boolean isPartySizeSet();
  
  public abstract boolean isPickupConfirmed();
  
  public abstract boolean isPriceEstimateEnabled();
  
  public abstract boolean isRideRequestInProgress();
  
  public abstract boolean isSchedulingRideForNonCarpool();
  
  public abstract Observable<RequestRideType> observeCurrentRideType();
  
  public abstract Observable<Location> observeDropoffLocationChange();
  
  public abstract Observable<Boolean> observeForceDestination();
  
  public abstract Observable<Location> observePickupLocationChange();
  
  public abstract Observable<PassengerRideRequest.RequestRideStep> observeRequestRideStepChange();
  
  public abstract Observable<ScheduledInterval> observeScheduledInterval();
  
  public abstract void resetCurrentRideType();
  
  public abstract void resetVenuePickupLocation();
  
  public abstract void restoreRideSession();
  
  public abstract void saveRideSession();
  
  public abstract void setCostEstimate(CostEstimate paramCostEstimate);
  
  public abstract void setCurrentRideTypeById(String paramString);
  
  public abstract void setDropoffLocation(Location paramLocation);
  
  public abstract void setForceDestination(boolean paramBoolean);
  
  public abstract void setForceDestinationErrorMessage(String paramString);
  
  public abstract void setPartySize(int paramInt);
  
  public abstract void setPickupLocation(Location paramLocation);
  
  public abstract void setPriceEstimateEnabled(boolean paramBoolean);
  
  public abstract void setRequestRideStep(PassengerRideRequest.RequestRideStep paramRequestRideStep);
  
  public abstract void setRideRequestInProgress(boolean paramBoolean);
  
  public abstract void setScheduledInterval(ScheduledInterval paramScheduledInterval);
  
  public abstract void setShouldShowCourierPromoBanner(boolean paramBoolean);
  
  public abstract void setVenuePickupLocation(VenuePickupLocation paramVenuePickupLocation);
  
  public abstract void setZoomLevel(float paramFloat);
}

/* Location:
 * Qualified Name:     me.lyft.android.application.ride.IRideRequestSession
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */