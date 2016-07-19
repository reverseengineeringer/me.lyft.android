package me.lyft.android.infrastructure.location;

import java.util.concurrent.TimeUnit;
import me.lyft.android.application.features.Features;
import me.lyft.android.application.features.IFeaturesProvider;
import me.lyft.android.application.polling.LocationAnalytics;
import me.lyft.android.domain.location.NullLocation;
import me.lyft.android.locationproviders.android.AndroidLocationClient;
import me.lyft.android.locationproviders.core.LocationCallback;
import me.lyft.android.locationproviders.core.LocationClientConfiguration;
import me.lyft.android.locationproviders.fused.FusedLocationClient;
import me.lyft.android.locationproviders.fused.LocationConnection;
import me.lyft.android.maps.GoogleLocationMapper;
import rx.Observable;
import rx.Observable.OnSubscribe;
import rx.Scheduler;
import rx.Scheduler.Worker;
import rx.Subscriber;
import rx.functions.Action0;
import rx.functions.Action1;
import rx.schedulers.Schedulers;
import rx.subjects.BehaviorSubject;
import rx.subscriptions.Subscriptions;

public class RxLocationService
  implements ILocationService
{
  private static final LocationClientConfiguration BACKGROUND_LOCATION_REQUEST = new LocationClientConfiguration(BACKGROUND_UPDATE_INTERVAL_MS, BACKGROUND_FASTEST_INTERVAL_MS, 500.0F, true);
  private static final int INITIAL_DELAY = 0;
  private static final LocationClientConfiguration LOCATION_REQUEST = new LocationClientConfiguration(UPDATE_INTERVAL_MS, FASTEST_INTERVAL_MS, 0.0F, false);
  private static final int RECONNECTION_DELAY_SEC = 5;
  private final AndroidLocationClient androidLocationClient;
  private final IFeaturesProvider featuresProvider;
  private final FusedLocationClient fusedLocationClient;
  private me.lyft.android.domain.location.Location lastCachedLocation = NullLocation.getInstance();
  private final LocationAnalytics locationAnalytics;
  private final Action1<me.lyft.android.domain.location.Location> onNextLocationUpdates = new Action1()
  {
    public void call(me.lyft.android.domain.location.Location paramAnonymousLocation)
    {
      RxLocationService.access$002(RxLocationService.this, paramAnonymousLocation);
      passiveLocationUpdateSubject.onNext(paramAnonymousLocation);
    }
  };
  private final BehaviorSubject<me.lyft.android.domain.location.Location> passiveLocationUpdateSubject = BehaviorSubject.create();
  
  public RxLocationService(FusedLocationClient paramFusedLocationClient, AndroidLocationClient paramAndroidLocationClient, LocationAnalytics paramLocationAnalytics, IFeaturesProvider paramIFeaturesProvider)
  {
    fusedLocationClient = paramFusedLocationClient;
    androidLocationClient = paramAndroidLocationClient;
    locationAnalytics = paramLocationAnalytics;
    featuresProvider = paramIFeaturesProvider;
  }
  
  private Observable<me.lyft.android.domain.location.Location> createLocationRequestObservable(final LocationClientConfiguration paramLocationClientConfiguration)
  {
    Observable.create(new Observable.OnSubscribe()
    {
      public void call(Subscriber<? super me.lyft.android.domain.location.Location> paramAnonymousSubscriber)
      {
        final LocationConnection localLocationConnection1 = RxLocationService.this.getAndroidLocationConnection(paramAnonymousSubscriber, paramLocationClientConfiguration);
        localLocationConnection1.connect();
        final LocationConnection localLocationConnection2 = RxLocationService.this.getFusedLocationConnection(paramAnonymousSubscriber, paramLocationClientConfiguration);
        final Scheduler.Worker localWorker = Schedulers.newThread().createWorker();
        localWorker.schedulePeriodically(new Action0()
        {
          public void call()
          {
            locationAnalytics.trackFusedLocationInitialization();
            localLocationConnection2.connect();
          }
        }, 0L, 5L, TimeUnit.SECONDS);
        paramAnonymousSubscriber.add(Subscriptions.create(new Action0()
        {
          public void call()
          {
            localWorker.unsubscribe();
            localLocationConnection1.disconnect();
            localLocationConnection2.disconnect();
          }
        }));
      }
    });
  }
  
  private LocationConnection getAndroidLocationConnection(final Subscriber<? super me.lyft.android.domain.location.Location> paramSubscriber, LocationClientConfiguration paramLocationClientConfiguration)
  {
    androidLocationClient.requestLocationUpdates(paramLocationClientConfiguration, new LocationCallback()
    {
      public void onError(String paramAnonymousString, int paramAnonymousInt) {}
      
      public void onLocationChanged(android.location.Location paramAnonymousLocation)
      {
        if (featuresProvider.isEnabled(Features.USE_ANDROID_LOCATION_MANAGER)) {
          paramSubscriber.onNext(GoogleLocationMapper.toDomainLocation(paramAnonymousLocation));
        }
      }
    });
  }
  
  private LocationConnection getFusedLocationConnection(final Subscriber<? super me.lyft.android.domain.location.Location> paramSubscriber, LocationClientConfiguration paramLocationClientConfiguration)
  {
    fusedLocationClient.requestLocationUpdates(paramLocationClientConfiguration, new LocationCallback()
    {
      public void onError(String paramAnonymousString, int paramAnonymousInt)
      {
        locationAnalytics.trackFusedLocationError(paramAnonymousString, paramAnonymousInt);
      }
      
      public void onLocationChanged(android.location.Location paramAnonymousLocation)
      {
        locationAnalytics.trackFusedLocationSuccess();
        if (!featuresProvider.isEnabled(Features.USE_ANDROID_LOCATION_MANAGER)) {
          paramSubscriber.onNext(GoogleLocationMapper.toDomainLocation(paramAnonymousLocation));
        }
      }
    });
  }
  
  private LocationConnection getLastLocationConnection(final Subscriber<? super me.lyft.android.domain.location.Location> paramSubscriber)
  {
    paramSubscriber = new LocationCallback()
    {
      public void onError(String paramAnonymousString, int paramAnonymousInt) {}
      
      public void onLocationChanged(android.location.Location paramAnonymousLocation)
      {
        if (paramAnonymousLocation == null) {
          paramSubscriber.onNext(NullLocation.getInstance());
        }
        for (;;)
        {
          paramSubscriber.onCompleted();
          return;
          paramSubscriber.onNext(GoogleLocationMapper.toDomainLocation(paramAnonymousLocation));
        }
      }
    };
    if (featuresProvider.isEnabled(Features.USE_ANDROID_LOCATION_MANAGER)) {
      return androidLocationClient.requestLastLocation(paramSubscriber);
    }
    return fusedLocationClient.requestLastLocation(paramSubscriber);
  }
  
  public me.lyft.android.domain.location.Location getLastCachedLocation()
  {
    return lastCachedLocation;
  }
  
  public Observable<me.lyft.android.domain.location.Location> getLastLocation()
  {
    Observable.create(new Observable.OnSubscribe()
    {
      public void call(Subscriber<? super me.lyft.android.domain.location.Location> paramAnonymousSubscriber)
      {
        final LocationConnection localLocationConnection = RxLocationService.this.getLastLocationConnection(paramAnonymousSubscriber);
        localLocationConnection.connect();
        paramAnonymousSubscriber.add(Subscriptions.create(new Action0()
        {
          public void call()
          {
            localLocationConnection.disconnect();
          }
        }));
      }
    }).doOnNext(onNextLocationUpdates);
  }
  
  public Observable<me.lyft.android.domain.location.Location> observeBackgroundLocationUpdates()
  {
    return createLocationRequestObservable(BACKGROUND_LOCATION_REQUEST).doOnNext(onNextLocationUpdates);
  }
  
  public Observable<me.lyft.android.domain.location.Location> observeLocationUpdates()
  {
    return createLocationRequestObservable(LOCATION_REQUEST).doOnNext(onNextLocationUpdates);
  }
  
  public Observable<me.lyft.android.domain.location.Location> observePassiveLocationUpdates()
  {
    return passiveLocationUpdateSubject.asObservable();
  }
}

/* Location:
 * Qualified Name:     me.lyft.android.infrastructure.location.RxLocationService
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */