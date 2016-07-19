package me.lyft.android.analytics.session;

import java.util.UUID;
import java.util.concurrent.TimeUnit;
import me.lyft.android.analytics.IAnalyticsSessionInfoRepository;
import me.lyft.android.common.DeviceClock;

public class AnalyticsSession
  implements IAnalyticsSession
{
  private static final long INACTIVITY_THRESHOLD_MS = TimeUnit.MINUTES.toMillis(30L);
  private AnalyticsSessionInfo analyticsSessionInfo;
  private final IAnalyticsSessionInfoRepository analyticsSessionRepository;
  
  public AnalyticsSession(IAnalyticsSessionInfoRepository paramIAnalyticsSessionInfoRepository)
  {
    analyticsSessionRepository = paramIAnalyticsSessionInfoRepository;
    analyticsSessionInfo = paramIAnalyticsSessionInfoRepository.getAnalyticsSessionInfo();
  }
  
  private void createSession()
  {
    analyticsSessionInfo = new AnalyticsSessionInfo(UUID.randomUUID().toString(), DeviceClock.getElapsedTimeMs());
    analyticsSessionRepository.setAnalyticsSessionInfo(analyticsSessionInfo);
  }
  
  private void updateSession()
  {
    long l = DeviceClock.getElapsedTimeMs();
    if (l - analyticsSessionInfo.getLastActivity() > INACTIVITY_THRESHOLD_MS) {
      analyticsSessionInfo.setSessionId(UUID.randomUUID().toString());
    }
    analyticsSessionInfo.setLastActivity(l);
    analyticsSessionRepository.setAnalyticsSessionInfo(analyticsSessionInfo);
  }
  
  public String getSessionId()
  {
    if (analyticsSessionInfo == null) {
      createSession();
    }
    for (;;)
    {
      return analyticsSessionInfo.getSessionId();
      updateSession();
    }
  }
}

/* Location:
 * Qualified Name:     me.lyft.android.analytics.session.AnalyticsSession
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */