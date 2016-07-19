package com.facebook.appevents;

import java.io.Serializable;

class FacebookTimeSpentData$SerializationProxyV1
  implements Serializable
{
  private static final long serialVersionUID = 6L;
  private final int interruptionCount;
  private final long lastResumeTime;
  private final long lastSuspendTime;
  private final long millisecondsSpentInSession;
  
  FacebookTimeSpentData$SerializationProxyV1(long paramLong1, long paramLong2, long paramLong3, int paramInt)
  {
    lastResumeTime = paramLong1;
    lastSuspendTime = paramLong2;
    millisecondsSpentInSession = paramLong3;
    interruptionCount = paramInt;
  }
  
  private Object readResolve()
  {
    return new FacebookTimeSpentData(lastResumeTime, lastSuspendTime, millisecondsSpentInSession, interruptionCount, null);
  }
}

/* Location:
 * Qualified Name:     com.facebook.appevents.FacebookTimeSpentData.SerializationProxyV1
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */