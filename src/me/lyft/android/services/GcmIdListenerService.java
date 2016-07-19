package me.lyft.android.services;

import com.google.firebase.iid.FirebaseInstanceIdService;
import javax.inject.Inject;
import me.lyft.android.LyftApplication;
import me.lyft.android.jobs.JobManager;
import me.lyft.android.jobs.UpdateGcmIdentifierJob;

public class GcmIdListenerService
  extends FirebaseInstanceIdService
{
  @Inject
  JobManager jobManager;
  
  private LyftApplication getLyftApplication()
  {
    return (LyftApplication)getApplication();
  }
  
  public void onTokenRefresh()
  {
    getLyftApplication().inject(this);
    jobManager.queueBackgroundJob(new UpdateGcmIdentifierJob());
  }
}

/* Location:
 * Qualified Name:     me.lyft.android.services.GcmIdListenerService
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */