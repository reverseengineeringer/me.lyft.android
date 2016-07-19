package me.lyft.android.infrastructure.locationsettings;

import com.google.android.gms.common.api.ResultCallback;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.location.LocationSettingsResult;
import me.lyft.android.common.Unit;
import me.lyft.android.logging.L;
import rx.Subscriber;

class LocationSettingsService$5$1
  implements ResultCallback<LocationSettingsResult>
{
  LocationSettingsService$5$1(LocationSettingsService.5 param5, Subscriber paramSubscriber) {}
  
  public void onResult(LocationSettingsResult paramLocationSettingsResult)
  {
    paramLocationSettingsResult = paramLocationSettingsResult.getStatus();
    switch (paramLocationSettingsResult.getStatusCode())
    {
    }
    for (;;)
    {
      val$subscriber.onCompleted();
      return;
      val$subscriber.onNext(Unit.create());
      continue;
      try
      {
        paramLocationSettingsResult.startResolutionForResult(LocationSettingsService.access$500(this$1.this$0), 23);
      }
      catch (Throwable paramLocationSettingsResult)
      {
        L.e(paramLocationSettingsResult, "Failure to display location settings.", new Object[0]);
      }
    }
  }
}

/* Location:
 * Qualified Name:     me.lyft.android.infrastructure.locationsettings.LocationSettingsService.5.1
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */