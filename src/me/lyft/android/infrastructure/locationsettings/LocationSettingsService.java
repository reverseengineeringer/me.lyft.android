package me.lyft.android.infrastructure.locationsettings;

import android.content.Context;
import android.os.Bundle;
import android.provider.Settings.Secure;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.GoogleApiClient.Builder;
import com.google.android.gms.common.api.GoogleApiClient.ConnectionCallbacks;
import com.google.android.gms.common.api.GoogleApiClient.OnConnectionFailedListener;
import com.google.android.gms.common.api.PendingResult;
import com.google.android.gms.common.api.ResultCallback;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.location.LocationRequest;
import com.google.android.gms.location.LocationServices;
import com.google.android.gms.location.LocationSettingsRequest;
import com.google.android.gms.location.LocationSettingsRequest.Builder;
import com.google.android.gms.location.LocationSettingsResult;
import com.google.android.gms.location.SettingsApi;
import java.util.concurrent.atomic.AtomicInteger;
import me.lyft.android.common.Unit;
import me.lyft.android.infrastructure.activity.ActivityService;
import me.lyft.android.logging.L;
import me.lyft.android.utils.VersionUtils;
import rx.Observable;
import rx.Observable.OnSubscribe;
import rx.Subscriber;
import rx.functions.Action0;
import rx.functions.Func1;
import rx.subjects.BehaviorSubject;

public class LocationSettingsService
  extends ActivityService
  implements GoogleApiClient.ConnectionCallbacks, GoogleApiClient.OnConnectionFailedListener, ILocationSettingsService
{
  private final BehaviorSubject<Boolean> connectedSubject = BehaviorSubject.create(Boolean.valueOf(false));
  private final Context context;
  private final GoogleApiClient googleApiClient;
  private final AtomicInteger subscriptionCount = new AtomicInteger(0);
  
  public LocationSettingsService(Context paramContext)
  {
    context = paramContext.getApplicationContext();
    googleApiClient = new GoogleApiClient.Builder(context, this, this).addApi(LocationServices.API).build();
  }
  
  private LocationSettingsRequest createLocationSettingsRequest()
  {
    return new LocationSettingsRequest.Builder().setAlwaysShow(true).addLocationRequest(createLocationUpdateRequest()).build();
  }
  
  private LocationRequest createLocationUpdateRequest()
  {
    LocationRequest localLocationRequest = LocationRequest.create();
    localLocationRequest.setPriority(100);
    return localLocationRequest;
  }
  
  private Observable<Unit> createSettingsObservable()
  {
    Observable.create(new Observable.OnSubscribe()
    {
      public void call(final Subscriber<? super Unit> paramAnonymousSubscriber)
      {
        LocationServices.SettingsApi.checkLocationSettings(googleApiClient, LocationSettingsService.this.createLocationSettingsRequest()).setResultCallback(new ResultCallback()
        {
          public void onResult(LocationSettingsResult paramAnonymous2LocationSettingsResult)
          {
            paramAnonymous2LocationSettingsResult = paramAnonymous2LocationSettingsResult.getStatus();
            switch (paramAnonymous2LocationSettingsResult.getStatusCode())
            {
            }
            for (;;)
            {
              paramAnonymousSubscriber.onCompleted();
              return;
              paramAnonymousSubscriber.onNext(Unit.create());
              continue;
              try
              {
                paramAnonymous2LocationSettingsResult.startResolutionForResult(getCurrentActivity(), 23);
              }
              catch (Throwable paramAnonymous2LocationSettingsResult)
              {
                L.e(paramAnonymous2LocationSettingsResult, "Failure to display location settings.", new Object[0]);
              }
            }
          }
        });
      }
    });
  }
  
  private void tryToConnect()
  {
    if (subscriptionCount.incrementAndGet() == 1) {
      googleApiClient.connect();
    }
  }
  
  private void tryToDisconnect()
  {
    if (subscriptionCount.decrementAndGet() == 0)
    {
      connectedSubject.onNext(Boolean.valueOf(false));
      if (googleApiClient.isConnected()) {
        googleApiClient.disconnect();
      }
    }
  }
  
  public boolean mockLocationEnabled()
  {
    if (VersionUtils.hasMarshmallow()) {}
    while (Settings.Secure.getString(context.getContentResolver(), "mock_location").equals("0")) {
      return false;
    }
    return true;
  }
  
  public Observable<Unit> observeLocationSettingsEnabled()
  {
    connectedSubject.first(new Func1()
    {
      public Boolean call(Boolean paramAnonymousBoolean)
      {
        return paramAnonymousBoolean;
      }
    }).flatMap(new Func1()
    {
      public Observable<Unit> call(Boolean paramAnonymousBoolean)
      {
        return LocationSettingsService.this.createSettingsObservable();
      }
    }).doOnSubscribe(new Action0()
    {
      public void call()
      {
        LocationSettingsService.this.tryToConnect();
      }
    }).doOnUnsubscribe(new Action0()
    {
      public void call()
      {
        LocationSettingsService.this.tryToDisconnect();
      }
    });
  }
  
  public void onConnected(Bundle paramBundle)
  {
    connectedSubject.onNext(Boolean.valueOf(true));
  }
  
  public void onConnectionFailed(ConnectionResult paramConnectionResult) {}
  
  public void onConnectionSuspended(int paramInt)
  {
    connectedSubject.onNext(Boolean.valueOf(false));
  }
}

/* Location:
 * Qualified Name:     me.lyft.android.infrastructure.locationsettings.LocationSettingsService
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */