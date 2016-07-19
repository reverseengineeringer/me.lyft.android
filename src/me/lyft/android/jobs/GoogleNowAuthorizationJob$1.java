package me.lyft.android.jobs;

import me.lyft.android.common.Unit;
import me.lyft.android.logging.L;
import me.lyft.android.rx.AsyncCall;

class GoogleNowAuthorizationJob$1
  extends AsyncCall<Unit>
{
  GoogleNowAuthorizationJob$1(GoogleNowAuthorizationJob paramGoogleNowAuthorizationJob) {}
  
  public void onFail(Throwable paramThrowable)
  {
    super.onFail(paramThrowable);
    L.w(paramThrowable, paramThrowable.getMessage(), new Object[0]);
  }
}

/* Location:
 * Qualified Name:     me.lyft.android.jobs.GoogleNowAuthorizationJob.1
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */