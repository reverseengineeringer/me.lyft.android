package com.facebook.appevents;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.content.LocalBroadcastManager;
import android.util.Log;
import com.facebook.FacebookRequestError;
import com.facebook.FacebookSdk;
import com.facebook.GraphRequest;
import com.facebook.GraphRequest.Callback;
import com.facebook.GraphResponse;
import com.facebook.LoggingBehavior;
import com.facebook.internal.Logger;
import com.facebook.internal.Utility;
import com.facebook.internal.Utility.FetchedAppSettings;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import java.util.concurrent.Executor;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.TimeUnit;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

class AppEventQueue
{
  private static final int FLUSH_PERIOD_IN_SECONDS = 15;
  private static final int NUM_LOG_EVENTS_TO_TRY_TO_FLUSH_AFTER = 100;
  private static final String TAG = AppEventQueue.class.getName();
  private static volatile AppEventCollection appEventCollection = new AppEventCollection();
  private static final Runnable flushRunnable = new Runnable()
  {
    public void run()
    {
      AppEventQueue.access$002(null);
      if (AppEventsLogger.getFlushBehavior() != AppEventsLogger.FlushBehavior.EXPLICIT_ONLY) {
        AppEventQueue.flushAndWait(FlushReason.TIMER);
      }
    }
  };
  private static ScheduledFuture scheduledFuture;
  private static final ScheduledExecutorService singleThreadExecutor = Executors.newSingleThreadScheduledExecutor();
  
  public static void add(AccessTokenAppIdPair paramAccessTokenAppIdPair, final AppEvent paramAppEvent)
  {
    singleThreadExecutor.execute(new Runnable()
    {
      public void run()
      {
        AppEventQueue.appEventCollection.addEvent(val$accessTokenAppId, paramAppEvent);
        if ((AppEventsLogger.getFlushBehavior() != AppEventsLogger.FlushBehavior.EXPLICIT_ONLY) && (AppEventQueue.appEventCollection.getEventCount() > 100)) {
          AppEventQueue.flushAndWait(FlushReason.EVENT_THRESHOLD);
        }
        while (AppEventQueue.scheduledFuture != null) {
          return;
        }
        AppEventQueue.access$002(AppEventQueue.singleThreadExecutor.schedule(AppEventQueue.flushRunnable, 15L, TimeUnit.SECONDS));
      }
    });
  }
  
  private static GraphRequest buildRequestForSession(AccessTokenAppIdPair paramAccessTokenAppIdPair, final SessionEventsState paramSessionEventsState, boolean paramBoolean, final FlushStatistics paramFlushStatistics)
  {
    Object localObject1 = paramAccessTokenAppIdPair.getApplicationId();
    Utility.FetchedAppSettings localFetchedAppSettings = Utility.queryAppSettings((String)localObject1, false);
    final GraphRequest localGraphRequest = GraphRequest.newPostRequest(null, String.format("%s/activities", new Object[] { localObject1 }), null, null);
    Object localObject2 = localGraphRequest.getParameters();
    localObject1 = localObject2;
    if (localObject2 == null) {
      localObject1 = new Bundle();
    }
    ((Bundle)localObject1).putString("access_token", paramAccessTokenAppIdPair.getAccessTokenString());
    localObject2 = AppEventsLogger.getPushNotificationsRegistrationId();
    if (localObject2 != null) {
      ((Bundle)localObject1).putString("device_token", (String)localObject2);
    }
    localGraphRequest.setParameters((Bundle)localObject1);
    if (localFetchedAppSettings == null) {
      return null;
    }
    int i = paramSessionEventsState.populateRequest(localGraphRequest, FacebookSdk.getApplicationContext(), localFetchedAppSettings.supportsImplicitLogging(), paramBoolean);
    if (i == 0) {
      return null;
    }
    numEvents += i;
    localGraphRequest.setCallback(new GraphRequest.Callback()
    {
      public void onCompleted(GraphResponse paramAnonymousGraphResponse)
      {
        AppEventQueue.handleResponse(val$accessTokenAppId, localGraphRequest, paramAnonymousGraphResponse, paramSessionEventsState, paramFlushStatistics);
      }
    });
    return localGraphRequest;
  }
  
  public static void flush(FlushReason paramFlushReason)
  {
    singleThreadExecutor.execute(new Runnable()
    {
      public void run()
      {
        AppEventQueue.flushAndWait(val$reason);
      }
    });
  }
  
  static void flushAndWait(FlushReason paramFlushReason)
  {
    Object localObject = AppEventStore.readAndClearStore();
    appEventCollection.addPersistedEvents((PersistedEvents)localObject);
    try
    {
      paramFlushReason = sendEventsToServer(paramFlushReason, appEventCollection);
      if (paramFlushReason != null)
      {
        localObject = new Intent("com.facebook.sdk.APP_EVENTS_FLUSHED");
        ((Intent)localObject).putExtra("com.facebook.sdk.APP_EVENTS_NUM_EVENTS_FLUSHED", numEvents);
        ((Intent)localObject).putExtra("com.facebook.sdk.APP_EVENTS_FLUSH_RESULT", result);
        LocalBroadcastManager.getInstance(FacebookSdk.getApplicationContext()).sendBroadcast((Intent)localObject);
      }
      return;
    }
    catch (Exception paramFlushReason)
    {
      Log.w(TAG, "Caught unexpected exception while flushing app events: ", paramFlushReason);
    }
  }
  
  public static Set<AccessTokenAppIdPair> getKeySet()
  {
    return appEventCollection.keySet();
  }
  
  private static void handleResponse(AccessTokenAppIdPair paramAccessTokenAppIdPair, GraphRequest paramGraphRequest, GraphResponse paramGraphResponse, final SessionEventsState paramSessionEventsState, FlushStatistics paramFlushStatistics)
  {
    FacebookRequestError localFacebookRequestError = paramGraphResponse.getError();
    String str = "Success";
    FlushResult localFlushResult = FlushResult.SUCCESS;
    if (localFacebookRequestError != null)
    {
      if (localFacebookRequestError.getErrorCode() != -1) {
        break label170;
      }
      str = "Failed: No Connectivity";
      localFlushResult = FlushResult.NO_CONNECTIVITY;
    }
    for (;;)
    {
      if (FacebookSdk.isLoggingBehaviorEnabled(LoggingBehavior.APP_EVENTS)) {
        paramGraphResponse = (String)paramGraphRequest.getTag();
      }
      try
      {
        paramGraphResponse = new JSONArray(paramGraphResponse).toString(2);
        Logger.log(LoggingBehavior.APP_EVENTS, TAG, "Flush completed\nParams: %s\n  Result: %s\n  Events JSON: %s", new Object[] { paramGraphRequest.getGraphObject().toString(), str, paramGraphResponse });
        if (localFacebookRequestError != null)
        {
          bool = true;
          paramSessionEventsState.clearInFlightAndStats(bool);
          if (localFlushResult == FlushResult.NO_CONNECTIVITY) {
            FacebookSdk.getExecutor().execute(new Runnable()
            {
              public void run()
              {
                AppEventStore.persistEvents(val$accessTokenAppId, paramSessionEventsState);
              }
            });
          }
          if ((localFlushResult != FlushResult.SUCCESS) && (result != FlushResult.NO_CONNECTIVITY)) {
            result = localFlushResult;
          }
          return;
          label170:
          str = String.format("Failed:\n  Response: %s\n  Error %s", new Object[] { paramGraphResponse.toString(), localFacebookRequestError.toString() });
          localFlushResult = FlushResult.SERVER_ERROR;
        }
      }
      catch (JSONException paramGraphResponse)
      {
        for (;;)
        {
          paramGraphResponse = "<Can't encode events for debug logging>";
          continue;
          boolean bool = false;
        }
      }
    }
  }
  
  public static void persistToDisk()
  {
    singleThreadExecutor.execute(new Runnable()
    {
      public void run()
      {
        AppEventStore.persistEvents(AppEventQueue.appEventCollection);
        AppEventQueue.access$102(new AppEventCollection());
      }
    });
  }
  
  private static FlushStatistics sendEventsToServer(FlushReason paramFlushReason, AppEventCollection paramAppEventCollection)
  {
    FlushStatistics localFlushStatistics = new FlushStatistics();
    boolean bool = FacebookSdk.getLimitEventAndDataUsage(FacebookSdk.getApplicationContext());
    ArrayList localArrayList = new ArrayList();
    Iterator localIterator = paramAppEventCollection.keySet().iterator();
    while (localIterator.hasNext())
    {
      Object localObject = (AccessTokenAppIdPair)localIterator.next();
      localObject = buildRequestForSession((AccessTokenAppIdPair)localObject, paramAppEventCollection.get((AccessTokenAppIdPair)localObject), bool, localFlushStatistics);
      if (localObject != null) {
        localArrayList.add(localObject);
      }
    }
    if (localArrayList.size() > 0)
    {
      Logger.log(LoggingBehavior.APP_EVENTS, TAG, "Flushing %d events due to %s.", new Object[] { Integer.valueOf(numEvents), paramFlushReason.toString() });
      paramAppEventCollection = localArrayList.iterator();
      for (;;)
      {
        paramFlushReason = localFlushStatistics;
        if (!paramAppEventCollection.hasNext()) {
          break;
        }
        ((GraphRequest)paramAppEventCollection.next()).executeAndWait();
      }
    }
    paramFlushReason = null;
    return paramFlushReason;
  }
}

/* Location:
 * Qualified Name:     com.facebook.appevents.AppEventQueue
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */