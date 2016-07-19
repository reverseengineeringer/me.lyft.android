package me.lyft.android.application.ride;

import com.lyft.android.api.dto.RideDTO;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.concurrent.atomic.AtomicReference;
import me.lyft.android.common.Objects;
import me.lyft.android.domain.driver.ride.DriverRide;
import me.lyft.android.domain.ride.RouteEqualityComparator;
import me.lyft.android.rx.ReactiveProperty;
import rx.Observable;

public class DriverRideProvider
  implements IDriverRideProvider
{
  private static final List<String> IN_PROGRESS_STATUSES = Arrays.asList(new String[] { "accepted", "approaching", "arrived", "pickedUp", "droppedOff" });
  private final AtomicReference<String> clearedRideId = new AtomicReference("");
  private final AtomicReference<Set<String>> offlineRideIds = new AtomicReference(Collections.emptySet());
  private ReactiveProperty<DriverRide> routeSubject = ReactiveProperty.create(DriverRide.empty());
  
  public DriverRideProvider()
  {
    routeSubject.setEqualityComparator(new RouteEqualityComparator());
  }
  
  private void addOfflineRideId(String paramString)
  {
    HashSet localHashSet = new HashSet((Set)offlineRideIds.get());
    localHashSet.add(paramString);
    offlineRideIds.set(localHashSet);
  }
  
  public void clearRoute()
  {
    clearedRideId.set(((DriverRide)routeSubject.get()).getCurrentRideId());
    routeSubject.onNext(DriverRide.empty());
  }
  
  public DriverRide getDriverRide()
  {
    return (DriverRide)Objects.firstNonNull(routeSubject.get(), DriverRide.empty());
  }
  
  public Observable<DriverRide> observeRide()
  {
    return routeSubject.asObservable();
  }
  
  public void setOfflineRide(DriverRide paramDriverRide)
  {
    if (!paramDriverRide.isNull()) {
      addOfflineRideId(paramDriverRide.getCurrentRideId());
    }
    routeSubject.onNext(paramDriverRide);
  }
  
  public boolean shouldIgnoreRide(RideDTO paramRideDTO)
  {
    if (paramRideDTO == null) {
      return false;
    }
    boolean bool1 = ((Set)offlineRideIds.get()).contains(id);
    boolean bool2 = Objects.equals(clearedRideId.get(), id);
    boolean bool3 = IN_PROGRESS_STATUSES.contains(status);
    if ((bool1) || ((bool2) && (!bool3))) {}
    for (bool1 = true;; bool1 = false) {
      return bool1;
    }
  }
  
  public void updateRide(DriverRide paramDriverRide)
  {
    routeSubject.onNext(paramDriverRide);
  }
}

/* Location:
 * Qualified Name:     me.lyft.android.application.ride.DriverRideProvider
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */