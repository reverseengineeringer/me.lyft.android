package me.lyft.android.jobs;

import com.threatmetrix.TrustDefenderMobile.EndNotifier;
import com.threatmetrix.TrustDefenderMobile.ProfilingResult;
import com.threatmetrix.TrustDefenderMobile.THMStatusCode;
import com.threatmetrix.TrustDefenderMobile.TrustDefenderMobile;
import me.lyft.android.logging.L;

class ThreatMetrixJob$1
  implements EndNotifier
{
  ThreatMetrixJob$1(ThreatMetrixJob paramThreatMetrixJob) {}
  
  public void complete(ProfilingResult paramProfilingResult)
  {
    if (paramProfilingResult.getStatus() == THMStatusCode.THM_OK) {
      L.d("TrustDefender profiling successfully for session id=%s", new Object[] { paramProfilingResult.getSessionID() });
    }
    ThreatMetrixJob.access$000(this$0).doPackageScan(0);
    ThreatMetrixJob.access$000(this$0).tidyUp();
  }
}

/* Location:
 * Qualified Name:     me.lyft.android.jobs.ThreatMetrixJob.1
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */