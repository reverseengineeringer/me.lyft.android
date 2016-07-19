package me.lyft.android.jobs;

import me.lyft.android.application.profile.IProfileService;
import me.lyft.android.common.Unit;
import me.lyft.android.infrastructure.facebook.IFacebookTokenService;
import rx.Observable;
import rx.functions.Func1;

class InitFacebookSdkJob$1
  implements Func1<Long, Observable<Unit>>
{
  InitFacebookSdkJob$1(InitFacebookSdkJob paramInitFacebookSdkJob) {}
  
  public Observable<Unit> call(Long paramLong)
  {
    return this$0.profileService.refreshFacebookToken(this$0.facebookService.getFacebookToken());
  }
}

/* Location:
 * Qualified Name:     me.lyft.android.jobs.InitFacebookSdkJob.1
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */