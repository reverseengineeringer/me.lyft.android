package com.facebook.appevents;

import java.io.Serializable;

class FacebookTimeSpentData$SerializationProxyV2
  implements Serializable
{
  private static final long serialVersionUID = 6L;
  private final String firstOpenSourceApplication;
  private final int interruptionCount;
  private final long lastResumeTime;
  private final long lastSuspendTime;
  private final long millisecondsSpentInSession;
  
  FacebookTimeSpentData$SerializationProxyV2(long paramLong1, long paramLong2, long paramLong3, int paramInt, String paramString)
  {
    lastResumeTime = paramLong1;
    lastSuspendTime = paramLong2;
    millisecondsSpentInSession = paramLong3;
    interruptionCount = paramInt;
    firstOpenSourceApplication = paramString;
  }
  
  private Object readResolve()
  {
    return new FacebookTimeSpentData(lastResumeTime, lastSuspendTime, millisecondsSpentInSession, interruptionCount, firstOpenSourceApplication, null);
  }
}

/* Location:
 * Qualified Name:     com.facebook.appevents.FacebookTimeSpentData.SerializationProxyV2
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */