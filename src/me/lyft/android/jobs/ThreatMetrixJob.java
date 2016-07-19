package me.lyft.android.jobs;

import com.lyft.android.api.dto.UserDTO;
import com.threatmetrix.TrustDefenderMobile.Config;
import com.threatmetrix.TrustDefenderMobile.EndNotifier;
import com.threatmetrix.TrustDefenderMobile.ProfilingOptions;
import com.threatmetrix.TrustDefenderMobile.ProfilingResult;
import com.threatmetrix.TrustDefenderMobile.THMStatusCode;
import com.threatmetrix.TrustDefenderMobile.TrustDefenderMobile;
import javax.inject.Inject;
import me.lyft.android.LyftApplication;
import me.lyft.android.domain.location.Location;
import me.lyft.android.infrastructure.location.ILocationService;
import me.lyft.android.logging.L;
import me.lyft.android.maps.GoogleLocationMapper;
import me.lyft.android.rx.SimpleSubscriber;
import rx.Observable;

public class ThreatMetrixJob
  implements Job
{
  @Inject
  ILocationService locationService;
  @Inject
  LyftApplication lyftApplication;
  private TrustDefenderMobile trustDefenderMobile;
  private final UserDTO user;
  
  public ThreatMetrixJob(UserDTO paramUserDTO)
  {
    user = paramUserDTO;
  }
  
  public void execute()
    throws Throwable
  {
    L.d("Thread matrix started", new Object[0]);
    trustDefenderMobile = new TrustDefenderMobile(lyftApplication.getString(2131166370));
    trustDefenderMobile.init(new Config().setRegisterForLocationServices(true).setContext(lyftApplication).setEndNotifier(new EndNotifier()
    {
      public void complete(ProfilingResult paramAnonymousProfilingResult)
      {
        if (paramAnonymousProfilingResult.getStatus() == THMStatusCode.THM_OK) {
          L.d("TrustDefender profiling successfully for session id=%s", new Object[] { paramAnonymousProfilingResult.getSessionID() });
        }
        trustDefenderMobile.doPackageScan(0);
        trustDefenderMobile.tidyUp();
      }
    }));
    locationService.getLastLocation().subscribe(new SimpleSubscriber()
    {
      public void onNext(Location paramAnonymousLocation)
      {
        super.onNext(paramAnonymousLocation);
        trustDefenderMobile.doProfileRequest(new ProfilingOptions().setSessionID(user.id).setLocation(GoogleLocationMapper.toAndroidLocation(paramAnonymousLocation)));
      }
    });
  }
}

/* Location:
 * Qualified Name:     me.lyft.android.jobs.ThreatMetrixJob
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */