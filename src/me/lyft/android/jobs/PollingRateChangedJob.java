package me.lyft.android.jobs;

import javax.inject.Inject;
import me.lyft.android.ILyftPreferences;
import me.lyft.android.common.Objects;
import me.lyft.android.domain.UserConstants;

public class PollingRateChangedJob
  implements Job
{
  private final long pollingRate;
  @Inject
  ILyftPreferences preferences;
  
  public PollingRateChangedJob(Long paramLong)
  {
    pollingRate = ((Long)Objects.firstNonNull(paramLong, Long.valueOf(UserConstants.DEFAULT_POLLING_RATE))).longValue();
  }
  
  public void execute()
    throws Throwable
  {
    long l3 = preferences.getPollingRate();
    long l2 = pollingRate;
    long l1 = l2;
    if (l2 < ILyftPreferences.MIN_POLLING_RATE) {
      l1 = ILyftPreferences.MIN_POLLING_RATE;
    }
    if (l3 != l1) {
      preferences.setPollingRate(Long.valueOf(l1));
    }
  }
}

/* Location:
 * Qualified Name:     me.lyft.android.jobs.PollingRateChangedJob
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */