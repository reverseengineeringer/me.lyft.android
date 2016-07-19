package me.lyft.android.application.ride.services;

import com.jakewharton.rxrelay.BehaviorRelay;
import com.lyft.android.api.dto.ScheduledRideDTOBuilder;
import com.lyft.android.api.dto.ScheduledRideResponseDTO;
import java.util.Collections;
import java.util.List;
import me.lyft.android.application.features.IFeaturesProvider;
import me.lyft.android.application.requestridetypes.IRequestRideTypeService;
import me.lyft.android.common.Unit;
import me.lyft.android.domain.ride.ScheduledRide;
import me.lyft.android.domain.ride.ScheduledRideMapper;
import me.lyft.android.infrastructure.lyft.ILyftApi;
import me.lyft.android.rx.AsyncCall;
import rx.Observable;
import rx.Subscription;
import rx.subscriptions.Subscriptions;

public class ScheduledRideService
  implements IScheduledRideService
{
  final ILyftApi api;
  final IFeaturesProvider featuresProvider;
  final BehaviorRelay<List<ScheduledRide>> relay = BehaviorRelay.create(Collections.emptyList());
  final IRequestRideTypeService requestRideTypeService;
  Subscription subscription = Subscriptions.empty();
  
  public ScheduledRideService(ILyftApi paramILyftApi, IFeaturesProvider paramIFeaturesProvider, IRequestRideTypeService paramIRequestRideTypeService)
  {
    api = paramILyftApi;
    featuresProvider = paramIFeaturesProvider;
    requestRideTypeService = paramIRequestRideTypeService;
  }
  
  private void updateCache(List<ScheduledRide> paramList)
  {
    relay.call(paramList);
  }
  
  public Observable<Unit> cancelScheduledRide(ScheduledRide paramScheduledRide)
  {
    paramScheduledRide = new ScheduledRideDTOBuilder().withId(paramScheduledRide.getId()).build();
    return api.cancelScheduledRide(paramScheduledRide).map(Unit.func1());
  }
  
  public void fetchScheduledRides()
  {
    subscription.unsubscribe();
    subscription = api.getScheduledRides().subscribe(new AsyncCall()
    {
      public void onSuccess(ScheduledRideResponseDTO paramAnonymousScheduledRideResponseDTO)
      {
        super.onSuccess(paramAnonymousScheduledRideResponseDTO);
        paramAnonymousScheduledRideResponseDTO = ScheduledRideMapper.fromScheduledRideResponseDTO(paramAnonymousScheduledRideResponseDTO, requestRideTypeService.getRideTypes());
        ScheduledRideService.this.updateCache(paramAnonymousScheduledRideResponseDTO);
      }
    });
  }
  
  public List<ScheduledRide> getScheduledRides()
  {
    return (List)relay.getValue();
  }
  
  public Observable<List<ScheduledRide>> observeScheduledRides()
  {
    return relay.asObservable();
  }
  
  public void resetCache()
  {
    relay.call(Collections.emptyList());
  }
}

/* Location:
 * Qualified Name:     me.lyft.android.application.ride.services.ScheduledRideService
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */