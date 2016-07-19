package com.facebook.appevents;

import android.content.Context;
import android.os.Bundle;
import com.facebook.GraphRequest;
import com.facebook.internal.AppEventsLoggerUtility;
import com.facebook.internal.AppEventsLoggerUtility.GraphAPIActivityType;
import com.facebook.internal.AttributionIdentifiers;
import com.facebook.internal.Utility;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

class SessionEventsState
{
  private final int MAX_ACCUMULATED_LOG_EVENTS = 1000;
  private List<AppEvent> accumulatedEvents = new ArrayList();
  private String anonymousAppDeviceGUID;
  private AttributionIdentifiers attributionIdentifiers;
  private List<AppEvent> inFlightEvents = new ArrayList();
  private int numSkippedEventsDueToFullBuffer;
  
  public SessionEventsState(AttributionIdentifiers paramAttributionIdentifiers, String paramString)
  {
    attributionIdentifiers = paramAttributionIdentifiers;
    anonymousAppDeviceGUID = paramString;
  }
  
  private byte[] getStringAsByteArray(String paramString)
  {
    try
    {
      paramString = paramString.getBytes("UTF-8");
      return paramString;
    }
    catch (UnsupportedEncodingException paramString)
    {
      Utility.logd("Encoding exception: ", paramString);
    }
    return null;
  }
  
  private void populateRequest(GraphRequest paramGraphRequest, Context paramContext, int paramInt, JSONArray paramJSONArray, boolean paramBoolean)
  {
    try
    {
      localObject = AppEventsLoggerUtility.getJSONObjectForGraphAPICall(AppEventsLoggerUtility.GraphAPIActivityType.CUSTOM_APP_EVENTS, attributionIdentifiers, anonymousAppDeviceGUID, paramBoolean, paramContext);
      paramContext = (Context)localObject;
      if (numSkippedEventsDueToFullBuffer > 0)
      {
        ((JSONObject)localObject).put("num_skipped_events", paramInt);
        paramContext = (Context)localObject;
      }
    }
    catch (JSONException paramContext)
    {
      for (;;)
      {
        Object localObject;
        paramContext = new JSONObject();
      }
    }
    paramGraphRequest.setGraphObject(paramContext);
    localObject = paramGraphRequest.getParameters();
    paramContext = (Context)localObject;
    if (localObject == null) {
      paramContext = new Bundle();
    }
    paramJSONArray = paramJSONArray.toString();
    if (paramJSONArray != null)
    {
      paramContext.putByteArray("custom_events_file", getStringAsByteArray(paramJSONArray));
      paramGraphRequest.setTag(paramJSONArray);
    }
    paramGraphRequest.setParameters(paramContext);
  }
  
  public void accumulatePersistedEvents(List<AppEvent> paramList)
  {
    try
    {
      accumulatedEvents.addAll(paramList);
      return;
    }
    finally
    {
      paramList = finally;
      throw paramList;
    }
  }
  
  /* Error */
  public void addEvent(AppEvent paramAppEvent)
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_0
    //   3: getfield 25	com/facebook/appevents/SessionEventsState:accumulatedEvents	Ljava/util/List;
    //   6: invokeinterface 131 1 0
    //   11: aload_0
    //   12: getfield 27	com/facebook/appevents/SessionEventsState:inFlightEvents	Ljava/util/List;
    //   15: invokeinterface 131 1 0
    //   20: iadd
    //   21: sipush 1000
    //   24: if_icmplt +16 -> 40
    //   27: aload_0
    //   28: aload_0
    //   29: getfield 71	com/facebook/appevents/SessionEventsState:numSkippedEventsDueToFullBuffer	I
    //   32: iconst_1
    //   33: iadd
    //   34: putfield 71	com/facebook/appevents/SessionEventsState:numSkippedEventsDueToFullBuffer	I
    //   37: aload_0
    //   38: monitorexit
    //   39: return
    //   40: aload_0
    //   41: getfield 25	com/facebook/appevents/SessionEventsState:accumulatedEvents	Ljava/util/List;
    //   44: aload_1
    //   45: invokeinterface 135 2 0
    //   50: pop
    //   51: goto -14 -> 37
    //   54: astore_1
    //   55: aload_0
    //   56: monitorexit
    //   57: aload_1
    //   58: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	59	0	this	SessionEventsState
    //   0	59	1	paramAppEvent	AppEvent
    // Exception table:
    //   from	to	target	type
    //   2	37	54	finally
    //   40	51	54	finally
  }
  
  public void clearInFlightAndStats(boolean paramBoolean)
  {
    if (paramBoolean) {}
    try
    {
      accumulatedEvents.addAll(inFlightEvents);
      inFlightEvents.clear();
      numSkippedEventsDueToFullBuffer = 0;
      return;
    }
    finally {}
  }
  
  public int getAccumulatedEventCount()
  {
    try
    {
      int i = accumulatedEvents.size();
      return i;
    }
    finally
    {
      localObject = finally;
      throw ((Throwable)localObject);
    }
  }
  
  public List<AppEvent> getEventsToPersist()
  {
    try
    {
      List localList = accumulatedEvents;
      accumulatedEvents = new ArrayList();
      return localList;
    }
    finally
    {
      localObject = finally;
      throw ((Throwable)localObject);
    }
  }
  
  public int populateRequest(GraphRequest paramGraphRequest, Context paramContext, boolean paramBoolean1, boolean paramBoolean2)
  {
    int i;
    JSONArray localJSONArray;
    try
    {
      i = numSkippedEventsDueToFullBuffer;
      inFlightEvents.addAll(accumulatedEvents);
      accumulatedEvents.clear();
      localJSONArray = new JSONArray();
      Iterator localIterator = inFlightEvents.iterator();
      while (localIterator.hasNext())
      {
        AppEvent localAppEvent = (AppEvent)localIterator.next();
        if ((paramBoolean1) || (!localAppEvent.getIsImplicit())) {
          localJSONArray.put(localAppEvent.getJSONObject());
        }
      }
      if (localJSONArray.length() != 0) {
        break label116;
      }
    }
    finally {}
    return 0;
    label116:
    populateRequest(paramGraphRequest, paramContext, i, localJSONArray, paramBoolean2);
    return localJSONArray.length();
  }
}

/* Location:
 * Qualified Name:     com.facebook.appevents.SessionEventsState
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */