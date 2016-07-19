package me.lyft.android.infrastructure.locationsettings;

import com.google.android.gms.common.api.PendingResult;
import com.google.android.gms.common.api.ResultCallback;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.location.LocationServices;
import com.google.android.gms.location.LocationSettingsResult;
import com.google.android.gms.location.SettingsApi;
import me.lyft.android.common.Unit;
import me.lyft.android.logging.L;
import rx.Observable.OnSubscribe;
import rx.Subscriber;

class LocationSettingsService$5
  implements Observable.OnSubscribe<Unit>
{
  LocationSettingsService$5(LocationSettingsService paramLocationSettingsService) {}
  
  public void call(final Subscriber<? super Unit> paramSubscriber)
  {
    LocationServices.SettingsApi.checkLocationSettings(LocationSettingsService.access$300(this$0), LocationSettingsService.access$400(this$0)).setResultCallback(new ResultCallback()
    {
      public void onResult(LocationSettingsResult paramAnonymousLocationSettingsResult)
      {
        paramAnonymousLocationSettingsResult = paramAnonymousLocationSettingsResult.getStatus();
        switch (paramAnonymousLocationSettingsResult.getStatusCode())
        {
        }
        for (;;)
        {
          paramSubscriber.onCompleted();
          return;
          paramSubscriber.onNext(Unit.create());
          continue;
          try
          {
            paramAnonymousLocationSettingsResult.startResolutionForResult(LocationSettingsService.access$500(this$0), 23);
          }
          catch (Throwable paramAnonymousLocationSettingsResult)
          {
            L.e(paramAnonymousLocationSettingsResult, "Failure to display location settings.", new Object[0]);
          }
        }
      }
    });
  }
}

/* Location:
 * Qualified Name:     me.lyft.android.infrastructure.locationsettings.LocationSettingsService.5
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */