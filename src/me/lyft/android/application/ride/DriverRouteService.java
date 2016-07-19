package me.lyft.android.application.ride;

import com.lyft.android.api.dto.RideUpdateRequestDTOBuilder;
import com.lyft.android.api.dto.UniversalDTO;
import com.lyft.android.api.dto.UpdateUserRequestBuilder;
import com.lyft.android.api.dto.UpdateUserRequestDTO;
import me.lyft.android.analytics.core.ActionAnalytics;
import me.lyft.android.analytics.studies.DriverAcceptAnalytics;
import me.lyft.android.analytics.studies.OfflineDropOffAnalytics;
import me.lyft.android.analytics.utils.AnalyticsUtils;
import me.lyft.android.application.IUserProvider;
import me.lyft.android.application.features.Features;
import me.lyft.android.application.features.IFeaturesProvider;
import me.lyft.android.common.DeviceClock;
import me.lyft.android.common.Strings;
import me.lyft.android.common.Unit;
import me.lyft.android.domain.User;
import me.lyft.android.domain.driver.ride.DriverRide;
import me.lyft.android.domain.driver.ride.DriverRidePassenger;
import me.lyft.android.domain.driver.ride.DriverStop;
import me.lyft.android.domain.location.Location;
import me.lyft.android.domain.location.LocationMapper;
import me.lyft.android.domain.ride.CancellationOption;
import me.lyft.android.infrastructure.deferred.IDeferredCallService;
import me.lyft.android.infrastructure.deferred.deferredcalls.DropOffDeferredCall;
import me.lyft.android.infrastructure.deferred.deferredcalls.RateDeferredCall;
import me.lyft.android.infrastructure.googleplaces.IGooglePlaceService;
import me.lyft.android.infrastructure.location.ILocationService;
import me.lyft.android.infrastructure.lyft.ILyftApi;
import me.lyft.android.rx.SimpleSubscriber;
import rx.Notification;
import rx.Observable;
import rx.functions.Action1;
import rx.functions.Func1;

public class DriverRouteService
  implements IDriverRouteService
{
  private final IDeferredCallService deferredCallService;
  private final IFeaturesProvider featuresProvider;
  private final IGooglePlaceService googlePlaceService;
  private final ILocationService locationService;
  private final ILyftApi lyftApi;
  private final IRatingSession ratingSession;
  private final IDriverRideProvider routeProvider;
  private final IUserDispatchService userModeService;
  private final IUserProvider userProvider;
  
  public DriverRouteService(ILyftApi paramILyftApi, IDriverRideProvider paramIDriverRideProvider, IUserProvider paramIUserProvider, ILocationService paramILocationService, IGooglePlaceService paramIGooglePlaceService, IUserDispatchService paramIUserDispatchService, IRatingSession paramIRatingSession, IDeferredCallService paramIDeferredCallService, IFeaturesProvider paramIFeaturesProvider)
  {
    lyftApi = paramILyftApi;
    routeProvider = paramIDriverRideProvider;
    userProvider = paramIUserProvider;
    locationService = paramILocationService;
    googlePlaceService = paramIGooglePlaceService;
    userModeService = paramIUserDispatchService;
    ratingSession = paramIRatingSession;
    deferredCallService = paramIDeferredCallService;
    featuresProvider = paramIFeaturesProvider;
  }
  
  private Observable<Unit> changeRideStatus(final String paramString1, final String paramString2)
  {
    locationService.getLastLocation().flatMap(new Func1()
    {
      public Observable<UniversalDTO> call(Location paramAnonymousLocation)
      {
        return lyftApi.updateRide(paramString2, new RideUpdateRequestDTOBuilder().withStatus(paramString1).withActionTimestampMs(Long.valueOf(DeviceClock.getCurrentTimeMs())).withLocation(LocationMapper.toLocationDTO(paramAnonymousLocation)).build());
      }
    }).map(Unit.func1()).first();
  }
  
  public Observable<Unit> acceptRoute()
  {
    final ActionAnalytics localActionAnalytics = DriverAcceptAnalytics.initiateRideAcceptedAction();
    changeRideStatus("accepted", routeProvider.getDriverRide().getCurrentStop().getRideId()).doOnNext(new Action1()
    {
      public void call(Unit paramAnonymousUnit)
      {
        localActionAnalytics.trackSuccess();
      }
    }).doOnError(new Action1()
    {
      public void call(Throwable paramAnonymousThrowable)
      {
        localActionAnalytics.trackFailure(paramAnonymousThrowable);
      }
    });
  }
  
  public Observable<Unit> arrive(final DriverStop paramDriverStop, final String paramString)
  {
    locationService.getLastLocation().flatMap(new Func1()
    {
      public Observable<UniversalDTO> call(Location paramAnonymousLocation)
      {
        return lyftApi.updateRide(paramDriverStop.getRideId(), new RideUpdateRequestDTOBuilder().withStatus("arrived").withActionTimestampMs(Long.valueOf(DeviceClock.getCurrentTimeMs())).withArrivedReason(Strings.emptyToNull(paramString)).withLocation(LocationMapper.toLocationDTO(paramAnonymousLocation)).build());
      }
    }).map(Unit.func1());
  }
  
  public Observable<Unit> cancelRoute(final CancellationOption paramCancellationOption)
  {
    locationService.getLastLocation().flatMap(new Func1()
    {
      public Observable<UniversalDTO> call(Location paramAnonymousLocation)
      {
        return lyftApi.updateRide(routeProvider.getDriverRide().getCurrentStop().getRideId(), new RideUpdateRequestDTOBuilder().withStatus(paramCancellationOption.getStatus()).withActionTimestampMs(Long.valueOf(DeviceClock.getCurrentTimeMs())).withLocation(LocationMapper.toLocationDTO(paramAnonymousLocation)).withCanceledReason(Strings.emptyToNull(paramCancellationOption.getId())).build());
      }
    }).map(Unit.func1()).first();
  }
  
  public Observable<Unit> clearRoute()
  {
    routeProvider.clearRoute();
    return Observable.just(Unit.create());
  }
  
  public Observable<Unit> dropOff(final DriverRidePassenger paramDriverRidePassenger)
  {
    final ActionAnalytics localActionAnalytics = OfflineDropOffAnalytics.initiateDropOffAction();
    final DriverRide localDriverRide = routeProvider.getDriverRide();
    final String str = localDriverRide.getCurrentStop().getLocation().getPlaceId();
    locationService.getLastLocation().flatMap(new Func1()
    {
      public Observable<Unit> call(Location paramAnonymousLocation)
      {
        if (featuresProvider.isEnabled(Features.OFFLINE_DROP_OFF_ENABLED))
        {
          DriverRide localDriverRide = localDriverRide.dropOff(paramDriverRidePassenger);
          routeProvider.setOfflineRide(localDriverRide);
          deferredCallService.add(new DropOffDeferredCall(paramDriverRidePassenger.getRideId(), paramAnonymousLocation, DeviceClock.getCurrentTimeMs()));
          return Unit.just();
        }
        return lyftApi.updateRide(paramDriverRidePassenger.getRideId(), new RideUpdateRequestDTOBuilder().withStatus("droppedOff").withActionTimestampMs(Long.valueOf(DeviceClock.getCurrentTimeMs())).withLocation(LocationMapper.toLocationDTO(paramAnonymousLocation)).build()).map(Unit.func1());
      }
    }).doOnNext(new Action1()
    {
      public void call(Unit paramAnonymousUnit)
      {
        googlePlaceService.reportPlace(str, "passenger_dropoff").subscribe(new SimpleSubscriber());
      }
    }).map(Unit.func1()).doOnEach(new Action1()
    {
      public void call(Notification<? super Unit> paramAnonymousNotification)
      {
        AnalyticsUtils.trackResult(localActionAnalytics, paramAnonymousNotification);
      }
    });
  }
  
  public Observable<Unit> enterLastRide()
  {
    UpdateUserRequestDTO localUpdateUserRequestDTO = new UpdateUserRequestBuilder().withDriverLastRide(Boolean.valueOf(true)).build();
    return lyftApi.updateUser(userProvider.getUser().getId(), localUpdateUserRequestDTO).map(Unit.func1());
  }
  
  public Observable<Unit> exitLastRide()
  {
    UpdateUserRequestDTO localUpdateUserRequestDTO = new UpdateUserRequestBuilder().withDriverLastRide(Boolean.valueOf(false)).build();
    return lyftApi.updateUser(userProvider.getUser().getId(), localUpdateUserRequestDTO).map(Unit.func1());
  }
  
  public Observable<Unit> lapseRoute(final boolean paramBoolean)
  {
    if (paramBoolean) {
      return Observable.just(Unit.create());
    }
    paramBoolean = routeProvider.getDriverRide().isSignOutOnLapse();
    changeRideStatus("lapsed", routeProvider.getDriverRide().getCurrentStop().getRideId()).flatMap(new Func1()
    {
      public Observable<Unit> call(Unit paramAnonymousUnit)
      {
        if (paramBoolean) {
          return userModeService.switchToDispatchable(false);
        }
        return Unit.just();
      }
    });
  }
  
  public Observable<Unit> pickup(final DriverRidePassenger paramDriverRidePassenger)
  {
    locationService.getLastLocation().flatMap(new Func1()
    {
      public Observable<UniversalDTO> call(Location paramAnonymousLocation)
      {
        return lyftApi.updateRide(paramDriverRidePassenger.getRideId(), new RideUpdateRequestDTOBuilder().withStatus("pickedUp").withActionTimestampMs(Long.valueOf(DeviceClock.getCurrentTimeMs())).withLocation(LocationMapper.toLocationDTO(paramAnonymousLocation)).build());
      }
    }).map(Unit.func1());
  }
  
  public Observable<Unit> pickup(final DriverRidePassenger paramDriverRidePassenger, final int paramInt)
  {
    locationService.getLastLocation().flatMap(new Func1()
    {
      public Observable<UniversalDTO> call(Location paramAnonymousLocation)
      {
        return lyftApi.updateRide(paramDriverRidePassenger.getRideId(), new RideUpdateRequestDTOBuilder().withStatus("pickedUp").withLocation(LocationMapper.toLocationDTO(paramAnonymousLocation)).withActionTimestampMs(Long.valueOf(DeviceClock.getCurrentTimeMs())).withPartySize(Integer.valueOf(paramInt)).build());
      }
    }).map(Unit.func1());
  }
  
  public Observable<Unit> rate(DriverRidePassenger paramDriverRidePassenger, int paramInt, String paramString)
  {
    final ActionAnalytics localActionAnalytics = OfflineDropOffAnalytics.initiateRateAction();
    if (featuresProvider.isEnabled(Features.OFFLINE_DROP_OFF_ENABLED))
    {
      deferredCallService.add(new RateDeferredCall(paramDriverRidePassenger.getRideId(), paramInt, paramString, DeviceClock.getCurrentTimeMs()));
      paramDriverRidePassenger = routeProvider.getDriverRide().rate(paramDriverRidePassenger).advanceRoute();
      routeProvider.setOfflineRide(paramDriverRidePassenger);
    }
    for (paramDriverRidePassenger = Unit.just();; paramDriverRidePassenger = lyftApi.updateRide(paramDriverRidePassenger.getRideId(), new RideUpdateRequestDTOBuilder().withPassengerRating(Integer.valueOf(paramInt)).withPassengerFeedback(Strings.emptyToNull(paramString)).withActionTimestampMs(Long.valueOf(DeviceClock.getCurrentTimeMs())).build()).map(Unit.func1())) {
      paramDriverRidePassenger.doOnNext(new Action1()
      {
        public void call(Unit paramAnonymousUnit)
        {
          ratingSession.reset();
          localActionAnalytics.trackSuccess();
        }
      }).doOnError(new Action1()
      {
        public void call(Throwable paramAnonymousThrowable)
        {
          localActionAnalytics.trackFailure(paramAnonymousThrowable);
        }
      });
    }
  }
  
  public Observable<Unit> setDropoff(Location paramLocation)
  {
    return lyftApi.updateRide(routeProvider.getDriverRide().getCurrentRideId(), new RideUpdateRequestDTOBuilder().withEndLocation(LocationMapper.toDeprecatedPlaceDTO(paramLocation)).build()).map(Unit.func1());
  }
  
  public Observable<Unit> skipNoShow(DriverRidePassenger paramDriverRidePassenger)
  {
    return changeRideStatus("canceledNoShow", paramDriverRidePassenger.getRideId());
  }
  
  public Observable<Unit> skipWrongPartySize(final DriverRidePassenger paramDriverRidePassenger, final int paramInt)
  {
    locationService.getLastLocation().flatMap(new Func1()
    {
      public Observable<UniversalDTO> call(Location paramAnonymousLocation)
      {
        return lyftApi.updateRide(paramDriverRidePassenger.getRideId(), new RideUpdateRequestDTOBuilder().withStatus("canceledWrongPartySize").withLocation(LocationMapper.toLocationDTO(paramAnonymousLocation)).withActionTimestampMs(Long.valueOf(DeviceClock.getCurrentTimeMs())).withPartySize(Integer.valueOf(paramInt)).build());
      }
    }).map(Unit.func1());
  }
  
  public Observable<Unit> startRoute()
  {
    return acceptRoute();
  }
}

/* Location:
 * Qualified Name:     me.lyft.android.application.ride.DriverRouteService
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */