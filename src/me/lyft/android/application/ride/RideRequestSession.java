package me.lyft.android.application.ride;

import me.lyft.android.ILyftPreferences;
import me.lyft.android.application.requestridetypes.IRequestRideTypeService;
import me.lyft.android.common.Objects;
import me.lyft.android.common.Strings;
import me.lyft.android.domain.cost.CostEstimate;
import me.lyft.android.domain.location.Location;
import me.lyft.android.domain.location.Location.PlaceType;
import me.lyft.android.domain.location.NullLocation;
import me.lyft.android.domain.passenger.ride.PassengerRideRequest;
import me.lyft.android.domain.passenger.ride.PassengerRideRequest.RequestRideStep;
import me.lyft.android.domain.passenger.ridetypes.RequestRideType;
import me.lyft.android.domain.ride.ScheduledInterval;
import me.lyft.android.domain.time.Time;
import me.lyft.android.domain.time.TimeRange;
import me.lyft.android.domain.venue.VenuePickupLocation;
import me.lyft.android.rx.ReactiveProperty;
import rx.Observable;
import rx.functions.Func1;
import rx.subjects.BehaviorSubject;

public class RideRequestSession
  implements IRideRequestSession
{
  private static final Func1<Location, String> LOCATION_FILTER_FUNC = new Func1()
  {
    public String call(Location paramAnonymousLocation)
    {
      return paramAnonymousLocation.toQueryString();
    }
  };
  private Location confirmedPickupLocation = NullLocation.getInstance();
  private CostEstimate costEstimate;
  private final BehaviorSubject<PassengerRideRequest.RequestRideStep> currentRequestRideStep = BehaviorSubject.create(PassengerRideRequest.RequestRideStep.SET_PICKUP);
  private final ReactiveProperty<RequestRideType> currentRideTypeObservable = ReactiveProperty.create(RequestRideType.empty());
  private final ReactiveProperty<Location> dropoffLocationSubject = ReactiveProperty.create().allowDuplicates();
  private Location dynamicPricingLocation = NullLocation.getInstance();
  private boolean forceDestination = false;
  private String forceDestinationErrorMessage = "";
  private final BehaviorSubject<Boolean> forceDestinationSubject = BehaviorSubject.create(Boolean.valueOf(false));
  private boolean isPriceEstimateEnabled = false;
  private boolean isRideRequestInProgress = false;
  private int partySize;
  private final ReactiveProperty<Location> pickupLocationSubject = ReactiveProperty.create().allowDuplicates();
  private final ILyftPreferences preferences;
  private final IRequestRideTypeService requestRideTypeProvider;
  private final ReactiveProperty<ScheduledInterval> scheduledIntervalSubject = ReactiveProperty.create(ScheduledInterval.empty());
  private boolean showCourierPromoBanner = true;
  private VenuePickupLocation venuePickupLocation;
  private float zoomLevel;
  
  public RideRequestSession(ILyftPreferences paramILyftPreferences, IRequestRideTypeService paramIRequestRideTypeService)
  {
    preferences = paramILyftPreferences;
    requestRideTypeProvider = paramIRequestRideTypeService;
  }
  
  public void clearConfirmations()
  {
    dynamicPricingLocation = NullLocation.getInstance();
    confirmedPickupLocation = NullLocation.getInstance();
    partySize = 0;
    forceDestination = false;
  }
  
  public void clearPartySize()
  {
    partySize = 0;
  }
  
  public void clearRideRequest()
  {
    clearConfirmations();
    preferences.clearRideRequest();
    pickupLocationSubject.onNext(NullLocation.getInstance());
    dropoffLocationSubject.onNext(NullLocation.getInstance());
    currentRequestRideStep.onNext(PassengerRideRequest.RequestRideStep.SET_PICKUP);
    isPriceEstimateEnabled = false;
  }
  
  public void confirmDynamicPricing()
  {
    dynamicPricingLocation = getPickupLocation();
  }
  
  public void confirmPickupLocation()
  {
    confirmedPickupLocation = getPickupLocation();
  }
  
  public CostEstimate getCostEstimate()
  {
    return (CostEstimate)Objects.firstNonNull(costEstimate, CostEstimate.empty());
  }
  
  public RequestRideType getCurrentRideType()
  {
    RequestRideType localRequestRideType2 = (RequestRideType)currentRideTypeObservable.get();
    if (localRequestRideType2.isNull()) {}
    for (RequestRideType localRequestRideType1 = requestRideTypeProvider.getDefaultRideType();; localRequestRideType1 = requestRideTypeProvider.findRideTypeById(localRequestRideType2.getPublicId()))
    {
      if (!Strings.equalsIgnoreCase(localRequestRideType1.getPublicId(), localRequestRideType2.getPublicId())) {
        currentRideTypeObservable.onNext(localRequestRideType1);
      }
      return localRequestRideType1;
    }
  }
  
  public Location getDropoffLocation()
  {
    return (Location)Objects.firstNonNull(dropoffLocationSubject.get(), NullLocation.getInstance());
  }
  
  public String getForceDestinationErrorMessage()
  {
    return forceDestinationErrorMessage;
  }
  
  public int getPartySize()
  {
    return partySize;
  }
  
  public Location getPickupLocation()
  {
    return (Location)Objects.firstNonNull(pickupLocationSubject.get(), NullLocation.getInstance());
  }
  
  public PassengerRideRequest.RequestRideStep getRequestRideStep()
  {
    return (PassengerRideRequest.RequestRideStep)Objects.firstNonNull(currentRequestRideStep.getValue(), PassengerRideRequest.RequestRideStep.SET_PICKUP);
  }
  
  public ScheduledInterval getScheduledInterval()
  {
    return (ScheduledInterval)Objects.firstNonNull(scheduledIntervalSubject.get(), ScheduledInterval.empty());
  }
  
  public TimeRange getScheduledPickupTimeRange()
  {
    Time localTime = getScheduledInterval().getPickupTime();
    if ((!localTime.isNull()) && ((localTime instanceof TimeRange))) {
      return (TimeRange)localTime;
    }
    return TimeRange.empty();
  }
  
  public boolean getShouldShowCourierPromoBanner()
  {
    return showCourierPromoBanner;
  }
  
  public String getVenuePickupLocationAddress()
  {
    return venuePickupLocation.getCopy();
  }
  
  public float getZoomLevel()
  {
    return zoomLevel;
  }
  
  public boolean hasVenuePickupLocation()
  {
    return venuePickupLocation != null;
  }
  
  public boolean isDynamicPricingConfirmed()
  {
    return (dynamicPricingLocation.hasSameCoordinates(getPickupLocation())) && (!dynamicPricingLocation.isNull());
  }
  
  public boolean isForceDestination()
  {
    return forceDestination;
  }
  
  public boolean isPartySizeSet()
  {
    return partySize > 0;
  }
  
  public boolean isPickupConfirmed()
  {
    return (confirmedPickupLocation.hasSameCoordinates(getPickupLocation())) && (!confirmedPickupLocation.isNull());
  }
  
  public boolean isPriceEstimateEnabled()
  {
    return isPriceEstimateEnabled;
  }
  
  public boolean isRideRequestInProgress()
  {
    return isRideRequestInProgress;
  }
  
  public boolean isSchedulingRideForNonCarpool()
  {
    return (!getScheduledInterval().isNull()) && (!getCurrentRideType().isCarpool());
  }
  
  public Observable<RequestRideType> observeCurrentRideType()
  {
    return currentRideTypeObservable.asObservable();
  }
  
  public Observable<Location> observeDropoffLocationChange()
  {
    return dropoffLocationSubject.asObservable().distinctUntilChanged(LOCATION_FILTER_FUNC);
  }
  
  public Observable<Boolean> observeForceDestination()
  {
    return forceDestinationSubject.asObservable();
  }
  
  public Observable<Location> observePickupLocationChange()
  {
    return pickupLocationSubject.asObservable().distinctUntilChanged(LOCATION_FILTER_FUNC);
  }
  
  public Observable<PassengerRideRequest.RequestRideStep> observeRequestRideStepChange()
  {
    return currentRequestRideStep.asObservable();
  }
  
  public Observable<ScheduledInterval> observeScheduledInterval()
  {
    return scheduledIntervalSubject.asObservable();
  }
  
  public void resetCurrentRideType()
  {
    currentRideTypeObservable.onNext(requestRideTypeProvider.getDefaultRideType());
  }
  
  public void resetVenuePickupLocation()
  {
    venuePickupLocation = null;
  }
  
  public void restoreRideSession()
  {
    PassengerRideRequest localPassengerRideRequest = preferences.getRideRequest();
    setZoomLevel(localPassengerRideRequest.getZoomLevel().floatValue());
    setShouldShowCourierPromoBanner(localPassengerRideRequest.getShowCourierPromoBanner().booleanValue());
    if (getPickupLocation().isNull())
    {
      Location localLocation = localPassengerRideRequest.getPickupLocation();
      if (!localLocation.isNull()) {
        setPickupLocation(localLocation);
      }
    }
    if ((getDropoffLocation().isNull()) && (getDropoffLocation().getPlaceType() != Location.PlaceType.REMOVE_DESTINATION)) {
      setDropoffLocation(localPassengerRideRequest.getDropoffLocation());
    }
    if (((RequestRideType)currentRideTypeObservable.get()).isNull())
    {
      setCurrentRideTypeById(localPassengerRideRequest.getSelectedRideTypeId());
      setRequestRideStep(localPassengerRideRequest.getRequestRideStep());
    }
    if (localPassengerRideRequest.getScheduledInterval() != null) {
      setScheduledInterval(localPassengerRideRequest.getScheduledInterval());
    }
  }
  
  public void saveRideSession()
  {
    PassengerRideRequest localPassengerRideRequest = new PassengerRideRequest(getCurrentRideType().getPublicId());
    localPassengerRideRequest.setPickupLocation(getPickupLocation());
    localPassengerRideRequest.setDropoffLocation(getDropoffLocation());
    localPassengerRideRequest.setZoomLevel(Float.valueOf(getZoomLevel()));
    localPassengerRideRequest.setTimestamp(Long.valueOf(System.currentTimeMillis()));
    localPassengerRideRequest.setRequestRideStep(getRequestRideStep());
    localPassengerRideRequest.setShowCourierPromoBanner(getShouldShowCourierPromoBanner());
    localPassengerRideRequest.setScheduledInterval(getScheduledInterval());
    preferences.setRideRequest(localPassengerRideRequest);
  }
  
  public void setCostEstimate(CostEstimate paramCostEstimate)
  {
    costEstimate = paramCostEstimate;
  }
  
  public void setCurrentRideTypeById(String paramString)
  {
    if (!Objects.equals(getCurrentRideType().getPublicId(), paramString)) {
      setScheduledInterval(ScheduledInterval.empty());
    }
    currentRideTypeObservable.onNext(requestRideTypeProvider.findRideTypeById(paramString));
  }
  
  public void setDropoffLocation(Location paramLocation)
  {
    paramLocation = (Location)Objects.firstNonNull(paramLocation, NullLocation.getInstance());
    if (!Objects.equals(paramLocation, getDropoffLocation())) {
      setScheduledInterval(ScheduledInterval.empty());
    }
    dropoffLocationSubject.onNext(paramLocation);
  }
  
  public void setForceDestination(boolean paramBoolean)
  {
    forceDestination = paramBoolean;
    if (!paramBoolean) {
      setForceDestinationErrorMessage("");
    }
    forceDestinationSubject.onNext(Boolean.valueOf(paramBoolean));
  }
  
  public void setForceDestinationErrorMessage(String paramString)
  {
    forceDestinationErrorMessage = paramString;
  }
  
  public void setPartySize(int paramInt)
  {
    partySize = paramInt;
  }
  
  public void setPickupLocation(Location paramLocation)
  {
    paramLocation = (Location)Objects.firstNonNull(paramLocation, NullLocation.getInstance());
    if (!Objects.equals(paramLocation, getPickupLocation())) {
      setScheduledInterval(ScheduledInterval.empty());
    }
    pickupLocationSubject.onNext(paramLocation);
  }
  
  public void setPriceEstimateEnabled(boolean paramBoolean)
  {
    isPriceEstimateEnabled = paramBoolean;
  }
  
  public void setRequestRideStep(PassengerRideRequest.RequestRideStep paramRequestRideStep)
  {
    currentRequestRideStep.onNext(paramRequestRideStep);
  }
  
  public void setRideRequestInProgress(boolean paramBoolean)
  {
    isRideRequestInProgress = paramBoolean;
  }
  
  public void setScheduledInterval(ScheduledInterval paramScheduledInterval)
  {
    scheduledIntervalSubject.onNext(Objects.firstNonNull(paramScheduledInterval, ScheduledInterval.empty()));
  }
  
  public void setShouldShowCourierPromoBanner(boolean paramBoolean)
  {
    showCourierPromoBanner = paramBoolean;
  }
  
  public void setVenuePickupLocation(VenuePickupLocation paramVenuePickupLocation)
  {
    venuePickupLocation = paramVenuePickupLocation;
  }
  
  public void setZoomLevel(float paramFloat)
  {
    zoomLevel = paramFloat;
  }
}

/* Location:
 * Qualified Name:     me.lyft.android.application.ride.RideRequestSession
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */