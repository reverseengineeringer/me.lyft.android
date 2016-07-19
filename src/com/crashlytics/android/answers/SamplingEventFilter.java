package com.crashlytics.android.answers;

import java.util.HashSet;
import java.util.Set;

class SamplingEventFilter
  implements EventFilter
{
  static final Set<SessionEvent.Type> EVENTS_TYPE_TO_SAMPLE = new HashSet() {};
  final int samplingRate;
  
  public SamplingEventFilter(int paramInt)
  {
    samplingRate = paramInt;
  }
  
  public boolean skipEvent(SessionEvent paramSessionEvent)
  {
    int i;
    if ((EVENTS_TYPE_TO_SAMPLE.contains(type)) && (sessionEventMetadata.betaDeviceToken == null))
    {
      i = 1;
      if (Math.abs(sessionEventMetadata.installationId.hashCode() % samplingRate) == 0) {
        break label65;
      }
    }
    label65:
    for (int j = 1;; j = 0)
    {
      if ((i == 0) || (j == 0)) {
        break label70;
      }
      return true;
      i = 0;
      break;
    }
    label70:
    return false;
  }
}

/* Location:
 * Qualified Name:     com.crashlytics.android.answers.SamplingEventFilter
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */