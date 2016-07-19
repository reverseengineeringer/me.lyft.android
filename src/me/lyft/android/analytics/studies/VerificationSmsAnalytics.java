package me.lyft.android.analytics.studies;

import me.lyft.android.analytics.Analytics;
import me.lyft.android.analytics.core.events.CoreEvent;
import me.lyft.android.analytics.core.events.LifecycleEvent;
import me.lyft.android.analytics.core.events.LifecycleEvent.Type;

public class VerificationSmsAnalytics
{
  public void verifySmsReceived(String paramString1, String paramString2)
  {
    Analytics.track(new LifecycleEvent(LifecycleEvent.Type.VERIFICATION_SMS_RECEIVED).setParameter(paramString2).setTag(paramString1));
  }
}

/* Location:
 * Qualified Name:     me.lyft.android.analytics.studies.VerificationSmsAnalytics
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */