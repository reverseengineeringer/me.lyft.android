package me.lyft.android.analytics.trackers;

import android.app.Activity;
import com.google.android.gms.ads.identifier.AdvertisingIdClient.Info;
import com.kochava.android.tracker.Feature;
import com.mobileapptracker.MobileAppTracker;
import java.util.HashMap;
import me.lyft.android.ILyftPreferences;
import me.lyft.android.analytics.IEventTracker;
import me.lyft.android.analytics.core.events.IEvent;
import me.lyft.android.analytics.core.events.LifecycleEvent;
import me.lyft.android.analytics.core.events.LifecycleEvent.Type;
import me.lyft.android.common.Unit;
import me.lyft.android.domain.User;
import me.lyft.android.infrastructure.device.IDevice;
import me.lyft.android.infrastructure.json.IJsonSerializer;
import me.lyft.android.logging.L;
import me.lyft.android.providers.AdvertisingIdProvider;
import me.lyft.android.rx.AsyncCall;
import me.lyft.android.rx.ReactiveProperty;
import rx.Observable;
import rx.android.schedulers.AndroidSchedulers;
import rx.functions.Func2;
import rx.schedulers.Schedulers;

public class AppEventTracker
  implements IEventTracker
{
  private static final String EVENT_USER_INSTALL = "event_user_install";
  private final ReactiveProperty<Unit> advertisingIdFetchedSubject = ReactiveProperty.create();
  private final AdvertisingIdProvider advertisingIdProvider;
  private final IDevice device;
  private final IJsonSerializer jsonSerializer;
  private final Feature kochava;
  private final ILyftPreferences lyftPreferences;
  private final ReactiveProperty<Unit> matIdInitSubject = ReactiveProperty.create();
  private final MobileAppTracker mobileAppTracker;
  
  AppEventTracker(Feature paramFeature, MobileAppTracker paramMobileAppTracker, IJsonSerializer paramIJsonSerializer, IDevice paramIDevice, ILyftPreferences paramILyftPreferences, AdvertisingIdProvider paramAdvertisingIdProvider)
  {
    kochava = paramFeature;
    mobileAppTracker = paramMobileAppTracker;
    jsonSerializer = paramIJsonSerializer;
    device = paramIDevice;
    lyftPreferences = paramILyftPreferences;
    advertisingIdProvider = paramAdvertisingIdProvider;
  }
  
  private void trackUserInstall()
  {
    try
    {
      HashMap localHashMap = new HashMap();
      kochava.event("event_user_install", jsonSerializer.toJson(localHashMap));
      return;
    }
    catch (Throwable localThrowable)
    {
      L.e(localThrowable, "trackUserInstall failed", new Object[0]);
    }
  }
  
  public void flush() {}
  
  public Observable<Unit> observerMobileAppTrackerInit()
  {
    advertisingIdFetchedSubject.zipWith(matIdInitSubject, new Func2()
    {
      public Unit call(Unit paramAnonymousUnit1, Unit paramAnonymousUnit2)
      {
        return Unit.create();
      }
    });
  }
  
  protected void onCreate()
  {
    try
    {
      mobileAppTracker.setAndroidId(device.getAndroidId());
      advertisingIdProvider.getAdvertisingInfo().subscribeOn(Schedulers.newThread()).observeOn(AndroidSchedulers.mainThread()).subscribe(new AsyncCall()
      {
        public void onFail(Throwable paramAnonymousThrowable)
        {
          super.onFail(paramAnonymousThrowable);
          advertisingIdFetchedSubject.onNext(Unit.create());
        }
        
        public void onSuccess(AdvertisingIdClient.Info paramAnonymousInfo)
        {
          super.onSuccess(paramAnonymousInfo);
          mobileAppTracker.setGoogleAdvertisingId(paramAnonymousInfo.getId(), paramAnonymousInfo.isLimitAdTrackingEnabled());
          lyftPreferences.setAdvertisingId(paramAnonymousInfo.getId());
          lyftPreferences.setLimitAdvertisingId(paramAnonymousInfo.isLimitAdTrackingEnabled());
          advertisingIdFetchedSubject.onNext(Unit.create());
        }
      });
      return;
    }
    catch (Exception localException)
    {
      L.e(localException, "onCreate failed", new Object[0]);
    }
  }
  
  protected void onResume(Activity paramActivity)
  {
    try
    {
      mobileAppTracker.setReferralSources(paramActivity);
      mobileAppTracker.measureSession();
      matIdInitSubject.onNext(Unit.create());
      return;
    }
    catch (Exception paramActivity)
    {
      L.e(paramActivity, "mobile app tracker crashed", new Object[0]);
    }
  }
  
  public void track(IEvent paramIEvent)
  {
    if (((paramIEvent instanceof LifecycleEvent)) && (((LifecycleEvent)paramIEvent).getType() == LifecycleEvent.Type.APP_INSTALL)) {
      trackUserInstall();
    }
  }
  
  protected void updateUserInfo(User paramUser)
  {
    try
    {
      mobileAppTracker.setUserId(paramUser.getId());
      return;
    }
    catch (Exception paramUser)
    {
      L.e(paramUser, "updateUserInfo failed", new Object[0]);
    }
  }
}

/* Location:
 * Qualified Name:     me.lyft.android.analytics.trackers.AppEventTracker
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */