package me.lyft.android.application.jobs;

import me.lyft.android.common.Unit;
import me.lyft.android.domain.job.GoogleNowAuthCode;
import me.lyft.android.domain.job.GoogleNowAuthCodeMapper;
import me.lyft.android.infrastructure.lyft.ILyftApi;
import rx.Observable;

public class GoogleNowService
  implements IGoogleNowService
{
  private final ILyftApi lyftApi;
  
  public GoogleNowService(ILyftApi paramILyftApi)
  {
    lyftApi = paramILyftApi;
  }
  
  public Observable<Unit> updateGoogleAuthToken(String paramString, GoogleNowAuthCode paramGoogleNowAuthCode)
  {
    return lyftApi.updateGoogleAuthToken(paramString, GoogleNowAuthCodeMapper.fromGoogleNowAuthCode(paramGoogleNowAuthCode));
  }
}

/* Location:
 * Qualified Name:     me.lyft.android.application.jobs.GoogleNowService
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */