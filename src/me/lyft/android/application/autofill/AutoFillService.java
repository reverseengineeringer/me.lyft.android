package me.lyft.android.application.autofill;

import com.lyft.android.api.dto.UpdateUserLocationRequestDTO;
import java.util.Collections;
import me.lyft.android.application.IAppInfoService;
import me.lyft.android.application.IUserProvider;
import me.lyft.android.application.ride.IRideRequestSession;
import me.lyft.android.common.Unit;
import me.lyft.android.domain.User;
import me.lyft.android.domain.location.Location;
import me.lyft.android.domain.location.LocationMapper;
import me.lyft.android.domain.passenger.ridetypes.RequestRideType;
import me.lyft.android.infrastructure.location.ILocationService;
import me.lyft.android.infrastructure.lyft.ILyftApi;
import rx.Observable;
import rx.Observable.OnSubscribe;
import rx.Subscriber;
import rx.functions.Func1;
import rx.schedulers.Schedulers;

public class AutoFillService
{
  private final IAppInfoService appInfoService;
  private final ILocationService locationService;
  private final ILyftApi lyftApi;
  private final IRideRequestSession rideRequestSession;
  private final IUserProvider userProvider;
  
  public AutoFillService(ILocationService paramILocationService, ILyftApi paramILyftApi, IUserProvider paramIUserProvider, IRideRequestSession paramIRideRequestSession, IAppInfoService paramIAppInfoService)
  {
    locationService = paramILocationService;
    lyftApi = paramILyftApi;
    userProvider = paramIUserProvider;
    rideRequestSession = paramIRideRequestSession;
    appInfoService = paramIAppInfoService;
  }
  
  private UpdateUserLocationRequestDTO createRequest(Location paramLocation)
  {
    return new UpdateUserLocationRequestDTO(Collections.singletonList(LocationMapper.toLocationDTO(paramLocation)), LocationMapper.toDeprecatedPlaceDTO(paramLocation), null, rideRequestSession.getCurrentRideType().getPublicId(), appInfoService.getAppInfoRevision(), null);
  }
  
  private Observable<Unit> updateLocation(final Location paramLocation)
  {
    Observable.create(new Observable.OnSubscribe()
    {
      public void call(Subscriber<? super Unit> paramAnonymousSubscriber)
      {
        try
        {
          UpdateUserLocationRequestDTO localUpdateUserLocationRequestDTO = AutoFillService.this.createRequest(paramLocation);
          lyftApi.updateLocationSync(userProvider.getUser().getId(), localUpdateUserLocationRequestDTO);
          paramAnonymousSubscriber.onNext(Unit.create());
          paramAnonymousSubscriber.onCompleted();
          return;
        }
        catch (Throwable localThrowable)
        {
          paramAnonymousSubscriber.onError(localThrowable);
        }
      }
    }).subscribeOn(Schedulers.io());
  }
  
  public Observable<Unit> requestAutofillLocations()
  {
    if (userProvider.getUser().isNull()) {
      return Observable.empty();
    }
    locationService.getLastLocation().first(new Func1()
    {
      public Boolean call(Location paramAnonymousLocation)
      {
        if (paramAnonymousLocation != null) {}
        for (boolean bool = true;; bool = false) {
          return Boolean.valueOf(bool);
        }
      }
    }).flatMap(new Func1()
    {
      public Observable<Unit> call(Location paramAnonymousLocation)
      {
        return AutoFillService.this.updateLocation(paramAnonymousLocation);
      }
    });
  }
}

/* Location:
 * Qualified Name:     me.lyft.android.application.autofill.AutoFillService
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */