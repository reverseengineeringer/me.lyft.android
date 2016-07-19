package me.lyft.android.domain.driver.ride;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import me.lyft.android.common.DeviceClock;
import me.lyft.android.common.INullable;
import me.lyft.android.common.Iterables;
import me.lyft.android.common.Objects;
import me.lyft.android.common.Strings;
import me.lyft.android.domain.driver.carpool.CarpoolInfo;
import me.lyft.android.domain.location.LatLng;
import me.lyft.android.domain.location.Location;
import me.lyft.android.domain.passenger.ride.RideFeature;
import me.lyft.android.domain.payment.Money;
import me.lyft.android.domain.ride.RideStatus;
import me.lyft.android.domain.ride.RideStatus.Status;
import me.lyft.android.domain.ride.RideType;
import rx.functions.Func1;

public class DriverRide
  implements INullable
{
  private static final int CURRENT_ROUTE_INDEX = 0;
  private static final int CURRENT_STOP_INDEX = 0;
  public static final long DEFAULT_LAPSE_TIMER_SECONDS = 15L;
  private final String bannerStyle;
  private final String bannerText;
  private final CarpoolInfo carpoolInfo;
  private final String currentRideId;
  private final int driverWaitSeconds;
  private final Long eta;
  private final List<RideFeature> features;
  private final boolean isTrainingRide;
  private final long lapseTimerSeconds;
  private final int payStartSeconds;
  private final int primeTimePercent;
  private final Money profitMinusTip;
  private final List<Route> routes;
  private final boolean showEndRideConfirmation;
  private final boolean showHints;
  private final boolean signOutOnLapse;
  private final RideStatus status;
  private final RideType type;
  
  public DriverRide(List<Route> paramList, RideStatus paramRideStatus, RideType paramRideType, Long paramLong, String paramString1, boolean paramBoolean1, long paramLong1, int paramInt1, Money paramMoney, boolean paramBoolean2, boolean paramBoolean3, String paramString2, String paramString3, CarpoolInfo paramCarpoolInfo, int paramInt2, int paramInt3, boolean paramBoolean4, List<RideFeature> paramList1)
  {
    routes = paramList;
    status = paramRideStatus;
    type = paramRideType;
    eta = paramLong;
    currentRideId = paramString1;
    showHints = paramBoolean1;
    lapseTimerSeconds = paramLong1;
    primeTimePercent = paramInt1;
    profitMinusTip = paramMoney;
    isTrainingRide = paramBoolean2;
    showEndRideConfirmation = paramBoolean3;
    bannerText = paramString2;
    bannerStyle = paramString3;
    carpoolInfo = paramCarpoolInfo;
    driverWaitSeconds = paramInt2;
    payStartSeconds = paramInt3;
    signOutOnLapse = paramBoolean4;
    features = paramList1;
  }
  
  private DriverRide advanceToNextRoute()
  {
    List localList = Iterables.skip(routes, 1);
    if (localList.isEmpty()) {
      return empty();
    }
    String str = ((Route)localList.get(0)).getFirstStop().getRideId();
    return withRoutesStatusAndId(localList, new RideStatus(RideStatus.Status.ACCEPTED, DeviceClock.getCurrentTimeMs()), str);
  }
  
  private List<LatLng> createWaypointsForCarpool()
  {
    LinkedList localLinkedList = new LinkedList();
    localLinkedList.add(carpoolInfo.getStartLocation());
    Iterator localIterator = getAllStops().iterator();
    while (localIterator.hasNext()) {
      localLinkedList.add(((DriverStop)localIterator.next()).getLocation());
    }
    localLinkedList.add(carpoolInfo.getEndLocation());
    return localLinkedList;
  }
  
  private List<LatLng> createWaypointsForClassic()
  {
    LinkedList localLinkedList = new LinkedList();
    localLinkedList.add(getCurrentStop().getLocation());
    return localLinkedList;
  }
  
  public static DriverRide empty()
  {
    return NullDriverRide.INSTANCE;
  }
  
  private DriverRidePassenger findUnratedPassenger(List<DriverRidePassenger> paramList)
  {
    paramList = paramList.iterator();
    while (paramList.hasNext())
    {
      DriverRidePassenger localDriverRidePassenger = (DriverRidePassenger)paramList.next();
      if (!localDriverRidePassenger.isRatingCompleted()) {
        return localDriverRidePassenger;
      }
    }
    return DriverRidePassenger.empty();
  }
  
  private DriverStop firstStop()
  {
    return getCurrentRoute().getFirstStop();
  }
  
  private Route getCurrentRoute()
  {
    return (Route)routes.get(0);
  }
  
  private boolean hasCompletedCurrentRoute()
  {
    return getUnratedPassenger().isNull();
  }
  
  private boolean hasStopChanged(DriverStop paramDriverStop1, DriverStop paramDriverStop2)
  {
    return (Strings.equalsIgnoreCase(paramDriverStop1.getPassenger().getId(), paramDriverStop2.getPassenger().getId())) && (!paramDriverStop1.getLocation().hasSameCoordinates(paramDriverStop2.getLocation()));
  }
  
  private DriverStop lastStop()
  {
    return ((Route)routes.get(routes.size() - 1)).getLastStop();
  }
  
  private RideStatus resolveStatusBasedOnPendingStops(List<Route> paramList, Route paramRoute, RideStatus.Status paramStatus)
  {
    if (paramRoute.getIncompleteStops().isEmpty()) {
      return new RideStatus(paramStatus, DeviceClock.getCurrentTimeMs());
    }
    return status;
  }
  
  private List<Route> updateRoutes(Route paramRoute)
  {
    ArrayList localArrayList = new ArrayList(routes);
    localArrayList.set(0, paramRoute);
    return localArrayList;
  }
  
  private DriverRide withRoutesStatusAndId(List<Route> paramList, RideStatus paramRideStatus, String paramString)
  {
    return new DriverRide(paramList, paramRideStatus, type, eta, paramString, showHints, lapseTimerSeconds, primeTimePercent, profitMinusTip, isTrainingRide, showEndRideConfirmation, bannerText, bannerStyle, carpoolInfo, driverWaitSeconds, payStartSeconds, signOutOnLapse, features);
  }
  
  public DriverRide advanceRoute()
  {
    DriverRide localDriverRide = this;
    if (hasCompletedCurrentRoute()) {
      localDriverRide = advanceToNextRoute();
    }
    return localDriverRide;
  }
  
  public List<LatLng> createWaypoints()
  {
    Object localObject;
    if (getType().isCarpool())
    {
      localObject = createWaypointsForCarpool();
      return (List<LatLng>)localObject;
    }
    if (getType().isStandard()) {
      return createWaypointsForClassic();
    }
    LinkedList localLinkedList = new LinkedList();
    Iterator localIterator = getIncompleteStops().iterator();
    for (;;)
    {
      localObject = localLinkedList;
      if (!localIterator.hasNext()) {
        break;
      }
      localLinkedList.add(((DriverStop)localIterator.next()).getLocation());
    }
  }
  
  public DriverRide dropOff(DriverRidePassenger paramDriverRidePassenger)
  {
    if (paramDriverRidePassenger.isNull()) {}
    do
    {
      return this;
      paramDriverRidePassenger = findDropoffStopForPassenger(paramDriverRidePassenger.getId());
    } while (paramDriverRidePassenger.isNull());
    paramDriverRidePassenger = paramDriverRidePassenger.complete();
    paramDriverRidePassenger = getCurrentRoute().advanceTo(paramDriverRidePassenger);
    List localList = updateRoutes(paramDriverRidePassenger);
    return withRoutesStatusAndId(localList, resolveStatusBasedOnPendingStops(localList, paramDriverRidePassenger, RideStatus.Status.DROPPEDOFF), currentRideId);
  }
  
  public DriverStop findDropoffStopForPassenger(String paramString)
  {
    Iterator localIterator = getStopsFromCurrentRoute().iterator();
    while (localIterator.hasNext())
    {
      DriverStop localDriverStop = (DriverStop)localIterator.next();
      if ((localDriverStop.isDropOff()) && (Objects.equals(localDriverStop.getPassenger().getId(), paramString))) {
        return localDriverStop;
      }
    }
    return DriverStop.empty();
  }
  
  public DriverStop findPickupStopForPassenger(String paramString)
  {
    Iterator localIterator = getStopsFromCurrentRoute().iterator();
    while (localIterator.hasNext())
    {
      DriverStop localDriverStop = (DriverStop)localIterator.next();
      if ((localDriverStop.isPickup()) && (Objects.equals(localDriverStop.getPassenger().getId(), paramString))) {
        return localDriverStop;
      }
    }
    return DriverStop.empty();
  }
  
  public List<DriverRidePassenger> getAllPassengers()
  {
    ArrayList localArrayList = new ArrayList();
    Iterator localIterator = routes.iterator();
    while (localIterator.hasNext()) {
      localArrayList.addAll(((Route)localIterator.next()).getPassengers());
    }
    return localArrayList;
  }
  
  public List<DriverStop> getAllStops()
  {
    ArrayList localArrayList = new ArrayList();
    Iterator localIterator = routes.iterator();
    while (localIterator.hasNext()) {
      localArrayList.addAll(((Route)localIterator.next()).getStops());
    }
    return localArrayList;
  }
  
  public String getBannerStyle()
  {
    return bannerStyle;
  }
  
  public String getBannerText()
  {
    return bannerText;
  }
  
  public CarpoolInfo getCarpoolInfo()
  {
    return carpoolInfo;
  }
  
  public DriverRidePassenger getCurrentPassenger()
  {
    return getCurrentStop().getPassenger();
  }
  
  public String getCurrentRideId()
  {
    return currentRideId;
  }
  
  public List<DriverRidePassenger> getCurrentRouteNotDroppedOffPassengers()
  {
    Iterables.where(getPassengersFromCurrentRoute(), new Func1()
    {
      public Boolean call(DriverRidePassenger paramAnonymousDriverRidePassenger)
      {
        if (!paramAnonymousDriverRidePassenger.isDroppedoff()) {}
        for (boolean bool = true;; bool = false) {
          return Boolean.valueOf(bool);
        }
      }
    });
  }
  
  public DriverStop getCurrentStop()
  {
    List localList = getIncompleteStops();
    if (localList.isEmpty()) {
      return DriverStop.empty();
    }
    return (DriverStop)localList.get(0);
  }
  
  public int getDriverWaitSeconds()
  {
    return driverWaitSeconds;
  }
  
  public Long getEta()
  {
    return eta;
  }
  
  public List<LatLng> getIncompleteStopLocations()
  {
    Object localObject = getAllStops();
    ArrayList localArrayList = new ArrayList(((List)localObject).size());
    localObject = ((List)localObject).iterator();
    while (((Iterator)localObject).hasNext())
    {
      DriverStop localDriverStop = (DriverStop)((Iterator)localObject).next();
      if (!localDriverStop.isCompleted()) {
        localArrayList.add(localDriverStop.getLocation());
      }
    }
    return localArrayList;
  }
  
  public List<DriverStop> getIncompleteStops()
  {
    return getCurrentRoute().getIncompleteStops();
  }
  
  public long getLapseTimerSeconds()
  {
    return lapseTimerSeconds;
  }
  
  public DriverStop getNextStop()
  {
    if (getIncompleteStops().size() > 1) {
      return (DriverStop)getIncompleteStops().get(1);
    }
    return DriverStop.empty();
  }
  
  public List<DriverRidePassenger> getNotDroppedOffPassengers()
  {
    ArrayList localArrayList = new ArrayList();
    Iterator localIterator = routes.iterator();
    while (localIterator.hasNext()) {
      localArrayList.addAll(Iterables.where(((Route)localIterator.next()).getPassengers(), new Func1()
      {
        public Boolean call(DriverRidePassenger paramAnonymousDriverRidePassenger)
        {
          if (!paramAnonymousDriverRidePassenger.isDroppedoff()) {}
          for (boolean bool = true;; bool = false) {
            return Boolean.valueOf(bool);
          }
        }
      }));
    }
    return localArrayList;
  }
  
  public List<DriverRidePassenger> getPassengersFromCurrentRoute()
  {
    if (routes.isEmpty()) {
      return Collections.emptyList();
    }
    return getCurrentRoute().getPassengers();
  }
  
  public List<DriverRidePassenger> getPassengersFromNextRoute()
  {
    if (routes.size() > 1) {
      return ((Route)routes.get(1)).getPassengers();
    }
    return Collections.emptyList();
  }
  
  public int getPayStartSeconds()
  {
    return payStartSeconds;
  }
  
  public List<DriverStop> getPickupStops()
  {
    Iterables.where(getCurrentRoute().getStops(), new Func1()
    {
      public Boolean call(DriverStop paramAnonymousDriverStop)
      {
        return Boolean.valueOf(paramAnonymousDriverStop.isPickup());
      }
    });
  }
  
  public int getPrimeTimePercent()
  {
    return primeTimePercent;
  }
  
  public Money getProfitMinusTip()
  {
    return profitMinusTip;
  }
  
  public List<Route> getQueuedRoutes()
  {
    return Iterables.skip(routes, 1);
  }
  
  public List<Route> getRoutes()
  {
    return routes;
  }
  
  public RideStatus getStatus()
  {
    return status;
  }
  
  public List<DriverStop> getStopsFromCurrentRoute()
  {
    if (routes.isEmpty()) {
      return Collections.emptyList();
    }
    return getCurrentRoute().getStops();
  }
  
  public RideType getType()
  {
    return (RideType)Objects.firstNonNull(type, RideType.empty());
  }
  
  public DriverRidePassenger getUnratedPassenger()
  {
    return findUnratedPassenger(getPassengersFromCurrentRoute());
  }
  
  public boolean hasDropoffChanged(DriverRide paramDriverRide)
  {
    DriverStop localDriverStop = getCurrentStop();
    paramDriverRide = paramDriverRide.getCurrentStop();
    return (localDriverStop.isDropOff()) && (paramDriverRide.isDropOff()) && (hasStopChanged(localDriverStop, paramDriverRide));
  }
  
  public boolean hasMultipleStops()
  {
    return (isCourier()) && (!getIncompleteStops().isEmpty());
  }
  
  public boolean hasPickupChanged(DriverRide paramDriverRide)
  {
    DriverStop localDriverStop = getCurrentStop();
    paramDriverRide = paramDriverRide.getCurrentStop();
    return (localDriverStop.isPickup()) && (paramDriverRide.isPickup()) && (hasStopChanged(localDriverStop, paramDriverRide));
  }
  
  public boolean isAccepted()
  {
    return getStatus().isAccepted();
  }
  
  public boolean isActive()
  {
    return getStatus().isActive();
  }
  
  public boolean isArrived()
  {
    return getStatus().isArrived();
  }
  
  public boolean isBannerInfo()
  {
    return bannerStyle.equals("info");
  }
  
  public boolean isBannerSevere()
  {
    return bannerStyle.equals("severe");
  }
  
  public boolean isBannerWarning()
  {
    return bannerStyle.equals("warning");
  }
  
  public boolean isCourier()
  {
    return getType().isCourier();
  }
  
  public boolean isCurrentStop(DriverStop paramDriverStop)
  {
    return getCurrentStop().equals(paramDriverStop);
  }
  
  public boolean isDroppedOff()
  {
    return getStatus().isDroppedOff();
  }
  
  public boolean isDroppingOffPassenger()
  {
    boolean bool = false;
    int i;
    if ((isCourier()) && (isPickedUp()))
    {
      i = 1;
      if ((isCourier()) || ((!isArrived()) && (!isPickedUp()))) {
        break label58;
      }
    }
    label58:
    for (int j = 1;; j = 0)
    {
      if ((i != 0) || (j != 0)) {
        bool = true;
      }
      return bool;
      i = 0;
      break;
    }
  }
  
  public boolean isFeatureEnabled(RideFeature paramRideFeature)
  {
    return features.contains(paramRideFeature);
  }
  
  public boolean isFirstStop(DriverStop paramDriverStop)
  {
    return firstStop().equals(paramDriverStop);
  }
  
  public boolean isInProgress()
  {
    return getStatus().isInProgress();
  }
  
  public boolean isLastStop(DriverStop paramDriverStop)
  {
    return lastStop().equals(paramDriverStop);
  }
  
  public boolean isLastStopInRoute(DriverStop paramDriverStop)
  {
    Iterator localIterator = routes.iterator();
    while (localIterator.hasNext()) {
      if (((Route)localIterator.next()).getLastStop().equals(paramDriverStop)) {
        return true;
      }
    }
    return false;
  }
  
  public boolean isNextStop(DriverStop paramDriverStop)
  {
    return getNextStop().equals(paramDriverStop);
  }
  
  public boolean isNull()
  {
    return false;
  }
  
  public boolean isPending()
  {
    return getStatus().isPending();
  }
  
  public boolean isPickedUp()
  {
    return getStatus().isPickedUp();
  }
  
  public boolean isPlus()
  {
    return getType().isPlus();
  }
  
  public boolean isSignOutOnLapse()
  {
    return signOutOnLapse;
  }
  
  public boolean isTrainingRide()
  {
    return isTrainingRide;
  }
  
  public DriverRide rate(DriverRidePassenger paramDriverRidePassenger)
  {
    if (paramDriverRidePassenger.isNull()) {
      return this;
    }
    paramDriverRidePassenger = paramDriverRidePassenger.asRated();
    Object localObject = getCurrentRoute().withUpdatedPassenger(paramDriverRidePassenger);
    List localList = updateRoutes((Route)localObject);
    DriverRidePassenger localDriverRidePassenger = findUnratedPassenger(((Route)localObject).getPassengers());
    if (localDriverRidePassenger.isNull())
    {
      paramDriverRidePassenger = RideStatus.Status.COMPLETED;
      localObject = resolveStatusBasedOnPendingStops(localList, (Route)localObject, paramDriverRidePassenger);
      if (!localDriverRidePassenger.isNull()) {
        break label90;
      }
    }
    label90:
    for (paramDriverRidePassenger = currentRideId;; paramDriverRidePassenger = localDriverRidePassenger.getRideId())
    {
      return withRoutesStatusAndId(localList, (RideStatus)localObject, paramDriverRidePassenger);
      paramDriverRidePassenger = RideStatus.Status.DROPPEDOFF;
      break;
    }
  }
  
  public boolean showEndRideConfirmation()
  {
    return showEndRideConfirmation;
  }
  
  public boolean showHints()
  {
    return showHints;
  }
  
  public boolean supportsTips()
  {
    return !getType().isCarpool();
  }
  
  public static class NullDriverRide
    extends DriverRide
  {
    private static DriverRide INSTANCE = new NullDriverRide();
    
    private NullDriverRide()
    {
      super(RideStatus.empty(), RideType.empty(), null, "", false, 0L, 0, null, false, false, null, null, CarpoolInfo.empty(), 0, 0, false, Collections.emptyList());
    }
    
    public List<DriverStop> getIncompleteStops()
    {
      return Collections.emptyList();
    }
    
    public boolean isNull()
    {
      return true;
    }
  }
}

/* Location:
 * Qualified Name:     me.lyft.android.domain.driver.ride.DriverRide
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */