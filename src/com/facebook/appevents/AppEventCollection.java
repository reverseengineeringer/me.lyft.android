package com.facebook.appevents;

import android.content.Context;
import com.facebook.FacebookSdk;
import com.facebook.internal.AttributionIdentifiers;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Set;

class AppEventCollection
{
  private final HashMap<AccessTokenAppIdPair, SessionEventsState> stateMap = new HashMap();
  
  private SessionEventsState getSessionEventsState(AccessTokenAppIdPair paramAccessTokenAppIdPair)
  {
    try
    {
      SessionEventsState localSessionEventsState = (SessionEventsState)stateMap.get(paramAccessTokenAppIdPair);
      Object localObject = localSessionEventsState;
      if (localSessionEventsState == null)
      {
        localObject = FacebookSdk.getApplicationContext();
        localObject = new SessionEventsState(AttributionIdentifiers.getAttributionIdentifiers((Context)localObject), AppEventsLogger.getAnonymousAppDeviceGUID((Context)localObject));
      }
      stateMap.put(paramAccessTokenAppIdPair, localObject);
      return (SessionEventsState)localObject;
    }
    finally {}
  }
  
  public void addEvent(AccessTokenAppIdPair paramAccessTokenAppIdPair, AppEvent paramAppEvent)
  {
    try
    {
      getSessionEventsState(paramAccessTokenAppIdPair).addEvent(paramAppEvent);
      return;
    }
    finally
    {
      paramAccessTokenAppIdPair = finally;
      throw paramAccessTokenAppIdPair;
    }
  }
  
  /* Error */
  public void addPersistedEvents(PersistedEvents paramPersistedEvents)
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_1
    //   3: ifnonnull +6 -> 9
    //   6: aload_0
    //   7: monitorexit
    //   8: return
    //   9: aload_1
    //   10: invokevirtual 65	com/facebook/appevents/PersistedEvents:keySet	()Ljava/util/Set;
    //   13: invokeinterface 71 1 0
    //   18: astore_2
    //   19: aload_2
    //   20: invokeinterface 77 1 0
    //   25: ifeq -19 -> 6
    //   28: aload_2
    //   29: invokeinterface 81 1 0
    //   34: checkcast 83	com/facebook/appevents/AccessTokenAppIdPair
    //   37: astore 4
    //   39: aload_0
    //   40: aload 4
    //   42: invokespecial 54	com/facebook/appevents/AppEventCollection:getSessionEventsState	(Lcom/facebook/appevents/AccessTokenAppIdPair;)Lcom/facebook/appevents/SessionEventsState;
    //   45: astore_3
    //   46: aload_1
    //   47: aload 4
    //   49: invokevirtual 84	com/facebook/appevents/PersistedEvents:get	(Ljava/lang/Object;)Ljava/lang/Object;
    //   52: checkcast 86	java/util/List
    //   55: invokeinterface 87 1 0
    //   60: astore 4
    //   62: aload 4
    //   64: invokeinterface 77 1 0
    //   69: ifeq -50 -> 19
    //   72: aload_3
    //   73: aload 4
    //   75: invokeinterface 81 1 0
    //   80: checkcast 89	com/facebook/appevents/AppEvent
    //   83: invokevirtual 57	com/facebook/appevents/SessionEventsState:addEvent	(Lcom/facebook/appevents/AppEvent;)V
    //   86: goto -24 -> 62
    //   89: astore_1
    //   90: aload_0
    //   91: monitorexit
    //   92: aload_1
    //   93: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	94	0	this	AppEventCollection
    //   0	94	1	paramPersistedEvents	PersistedEvents
    //   18	11	2	localIterator	Iterator
    //   45	28	3	localSessionEventsState	SessionEventsState
    //   37	37	4	localObject	Object
    // Exception table:
    //   from	to	target	type
    //   9	19	89	finally
    //   19	62	89	finally
    //   62	86	89	finally
  }
  
  public SessionEventsState get(AccessTokenAppIdPair paramAccessTokenAppIdPair)
  {
    try
    {
      paramAccessTokenAppIdPair = (SessionEventsState)stateMap.get(paramAccessTokenAppIdPair);
      return paramAccessTokenAppIdPair;
    }
    finally
    {
      paramAccessTokenAppIdPair = finally;
      throw paramAccessTokenAppIdPair;
    }
  }
  
  public int getEventCount()
  {
    int i = 0;
    try
    {
      Iterator localIterator = stateMap.values().iterator();
      while (localIterator.hasNext())
      {
        int j = ((SessionEventsState)localIterator.next()).getAccumulatedEventCount();
        i += j;
      }
      return i;
    }
    finally {}
  }
  
  public Set<AccessTokenAppIdPair> keySet()
  {
    try
    {
      Set localSet = stateMap.keySet();
      return localSet;
    }
    finally
    {
      localObject = finally;
      throw ((Throwable)localObject);
    }
  }
}

/* Location:
 * Qualified Name:     com.facebook.appevents.AppEventCollection
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */