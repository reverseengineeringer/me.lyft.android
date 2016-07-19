package me.lyft.android.jobs;

import com.facebook.FacebookSdk;
import java.util.concurrent.TimeUnit;
import javax.inject.Inject;
import me.lyft.android.ILyftPreferences;
import me.lyft.android.LyftApplication;
import me.lyft.android.application.profile.IProfileService;
import me.lyft.android.common.Unit;
import me.lyft.android.infrastructure.facebook.IFacebookTokenService;
import me.lyft.android.rx.SimpleSubscriber;
import rx.Observable;
import rx.functions.Func1;

public class InitFacebookSdkJob
  implements Job
{
  @Inject
  LyftApplication application;
  @Inject
  IFacebookTokenService facebookService;
  @Inject
  ILyftPreferences preferences;
  @Inject
  IProfileService profileService;
  
  public void execute()
    throws Throwable
  {
    FacebookSdk.sdkInitialize(application);
    FacebookSdk.setApplicationId(preferences.getFacebookAppId());
    Observable.timer(5L, TimeUnit.SECONDS).flatMap(new Func1()
    {
      public Observable<Unit> call(Long paramAnonymousLong)
      {
        return profileService.refreshFacebookToken(facebookService.getFacebookToken());
      }
    }).subscribe(new SimpleSubscriber());
  }
}

/* Location:
 * Qualified Name:     me.lyft.android.jobs.InitFacebookSdkJob
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */