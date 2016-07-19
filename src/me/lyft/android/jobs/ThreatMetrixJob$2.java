package me.lyft.android.jobs;

import com.lyft.android.api.dto.UserDTO;
import com.threatmetrix.TrustDefenderMobile.ProfilingOptions;
import com.threatmetrix.TrustDefenderMobile.TrustDefenderMobile;
import me.lyft.android.domain.location.Location;
import me.lyft.android.maps.GoogleLocationMapper;
import me.lyft.android.rx.SimpleSubscriber;

class ThreatMetrixJob$2
  extends SimpleSubscriber<Location>
{
  ThreatMetrixJob$2(ThreatMetrixJob paramThreatMetrixJob) {}
  
  public void onNext(Location paramLocation)
  {
    super.onNext(paramLocation);
    ThreatMetrixJob.access$000(this$0).doProfileRequest(new ProfilingOptions().setSessionID(access$100this$0).id).setLocation(GoogleLocationMapper.toAndroidLocation(paramLocation)));
  }
}

/* Location:
 * Qualified Name:     me.lyft.android.jobs.ThreatMetrixJob.2
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */