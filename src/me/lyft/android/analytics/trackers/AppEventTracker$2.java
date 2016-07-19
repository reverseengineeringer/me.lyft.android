package me.lyft.android.analytics.trackers;

import com.google.android.gms.ads.identifier.AdvertisingIdClient.Info;
import com.mobileapptracker.MobileAppTracker;
import me.lyft.android.ILyftPreferences;
import me.lyft.android.common.Unit;
import me.lyft.android.rx.AsyncCall;
import me.lyft.android.rx.ReactiveProperty;

class AppEventTracker$2
  extends AsyncCall<AdvertisingIdClient.Info>
{
  AppEventTracker$2(AppEventTracker paramAppEventTracker) {}
  
  public void onFail(Throwable paramThrowable)
  {
    super.onFail(paramThrowable);
    AppEventTracker.access$200(this$0).onNext(Unit.create());
  }
  
  public void onSuccess(AdvertisingIdClient.Info paramInfo)
  {
    super.onSuccess(paramInfo);
    AppEventTracker.access$000(this$0).setGoogleAdvertisingId(paramInfo.getId(), paramInfo.isLimitAdTrackingEnabled());
    AppEventTracker.access$100(this$0).setAdvertisingId(paramInfo.getId());
    AppEventTracker.access$100(this$0).setLimitAdvertisingId(paramInfo.isLimitAdTrackingEnabled());
    AppEventTracker.access$200(this$0).onNext(Unit.create());
  }
}

/* Location:
 * Qualified Name:     me.lyft.android.analytics.trackers.AppEventTracker.2
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */