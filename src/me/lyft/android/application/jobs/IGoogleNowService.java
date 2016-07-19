package me.lyft.android.application.jobs;

import me.lyft.android.common.Unit;
import me.lyft.android.domain.job.GoogleNowAuthCode;
import rx.Observable;

public abstract interface IGoogleNowService
{
  public abstract Observable<Unit> updateGoogleAuthToken(String paramString, GoogleNowAuthCode paramGoogleNowAuthCode);
}

/* Location:
 * Qualified Name:     me.lyft.android.application.jobs.IGoogleNowService
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */