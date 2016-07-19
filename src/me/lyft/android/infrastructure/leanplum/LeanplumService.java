package me.lyft.android.infrastructure.leanplum;

import android.app.Activity;
import android.app.Application;
import android.os.Bundle;
import android.os.SystemClock;
import com.leanplum.Leanplum;
import com.leanplum.LeanplumActivityHelper;
import com.leanplum.callbacks.StartCallback;
import com.leanplum.callbacks.VariablesChangedCallback;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicBoolean;
import me.lyft.android.ILyftPreferences;
import me.lyft.android.analytics.core.CallAnalytics;
import me.lyft.android.analytics.core.ExperimentAnalytics;
import me.lyft.android.analytics.core.events.CallEvent.Call;
import me.lyft.android.application.IUserProvider;
import me.lyft.android.application.constants.Constants;
import me.lyft.android.application.constants.IConstantsProvider;
import me.lyft.android.application.constants.ILeanplumOverrideService;
import me.lyft.android.application.constants.Priority;
import me.lyft.android.common.Strings;
import me.lyft.android.domain.User;
import me.lyft.android.infrastructure.activity.ActivityService;
import me.lyft.android.logging.L;
import rx.Observable;
import rx.Scheduler;
import rx.Scheduler.Worker;
import rx.Subscription;
import rx.functions.Action0;
import rx.functions.Action1;
import rx.schedulers.Schedulers;
import rx.subscriptions.Subscriptions;

public class LeanplumService
  extends ActivityService
  implements ILeanplumService
{
  private static final Object DISPATCH_LOCK = new Object();
  private static final AtomicBoolean INITIALIZED_SDK = new AtomicBoolean(false);
  private static final Map<String, Object> LEANPLUM_ATTRIBUTES = new ConcurrentHashMap() {};
  private static final long LEANPLUM_REFRESH_THRESHOLD_MS = 30000L;
  private static volatile boolean outstandingUpdate = false;
  private static volatile boolean pendingUpdate = false;
  private static volatile long updateTimestamp;
  private final IConstantsProvider constantsProvider;
  private LeanplumActivityHelper helper;
  private final ILeanplumOverrideService leanplumOverrideService;
  private Subscription pollingSubscription = Subscriptions.empty();
  private final ILyftPreferences preferences;
  private final IUserProvider userProvider;
  
  public LeanplumService(Application paramApplication, ILeanplumOverrideService paramILeanplumOverrideService, ILyftPreferences paramILyftPreferences, final IConstantsProvider paramIConstantsProvider, IUserProvider paramIUserProvider)
  {
    leanplumOverrideService = paramILeanplumOverrideService;
    preferences = paramILyftPreferences;
    constantsProvider = paramIConstantsProvider;
    userProvider = paramIUserProvider;
    paramILeanplumOverrideService.observeLeanplumOverride().subscribe(new Action1()
    {
      public void call(Boolean paramAnonymousBoolean)
      {
        if (!paramAnonymousBoolean.booleanValue()) {
          LeanplumService.clearLeanplumVariables(paramIConstantsProvider);
        }
      }
    });
    Leanplum.setApplicationContext(paramApplication);
    LeanplumActivityHelper.enableLifecycleCallbacks(paramApplication);
  }
  
  private static void clearLeanplumVariables(IConstantsProvider paramIConstantsProvider)
  {
    updateConstants(Collections.emptyMap(), paramIConstantsProvider);
  }
  
  private static List<Long> getVariantIds()
  {
    List localList = Leanplum.variants();
    ArrayList localArrayList = new ArrayList(localList.size());
    int i = 0;
    while (i < localList.size())
    {
      Object localObject = ((Map)localList.get(i)).get("id");
      if ((localObject != null) && ((localObject instanceof Long))) {
        localArrayList.add((Long)localObject);
      }
      i += 1;
    }
    return localArrayList;
  }
  
  private void initializeSDK(Activity paramActivity)
  {
    if (!INITIALIZED_SDK.compareAndSet(false, true))
    {
      Leanplum.setApplicationContext(paramActivity.getApplicationContext());
      return;
    }
    String str1 = preferences.getLeanplumAppId();
    ??? = preferences.getLeanplumKey();
    if ("prod".equals("dev"))
    {
      Leanplum.setAppIdForDevelopmentMode(str1, (String)???);
      L.d("Starting leanplum in development mode with key and appId: " + (String)??? + " " + str1, new Object[0]);
    }
    for (;;)
    {
      updateTimestamp = SystemClock.elapsedRealtime();
      ??? = new CallAnalytics(CallEvent.Call.LEANPLUM_START);
      Leanplum.addStartResponseHandler(new StartCallback()
      {
        public void onResponse(boolean paramAnonymousBoolean)
        {
          if (paramAnonymousBoolean)
          {
            localObject.trackSuccess();
            LeanplumService.updateConstants((Map)Leanplum.objectForKeyPath(new Object[] { "client" }), constantsProvider);
            ExperimentAnalytics.updateAssignments(LeanplumService.access$300());
          }
          synchronized (LeanplumService.DISPATCH_LOCK)
          {
            LeanplumService.access$502(false);
            if (LeanplumService.pendingUpdate) {
              LeanplumService.refreshConfiguration(true, leanplumOverrideService, constantsProvider);
            }
            return;
            localObject.trackFailure();
          }
        }
      });
      User localUser = userProvider.getUser();
      str1 = localUser.getLyftId();
      String str2 = localUser.getRegion();
      if (!Strings.isNullOrEmpty(str2)) {
        LEANPLUM_ATTRIBUTES.put("region", str2);
      }
      LEANPLUM_ATTRIBUTES.put("approvedDriver", Boolean.valueOf(localUser.isApprovedDriver()));
      ((CallAnalytics)???).trackInitiation();
      synchronized (DISPATCH_LOCK)
      {
        outstandingUpdate = true;
        if (Strings.isNullOrEmpty(str1))
        {
          Leanplum.start(paramActivity.getApplicationContext(), LEANPLUM_ATTRIBUTES);
          updateConstants((Map)Leanplum.objectForKeyPath(new Object[] { "client" }), constantsProvider);
          userProvider.observeUserUpdates().subscribe(new UserUpdateCallback(str1, leanplumOverrideService, constantsProvider, null));
          return;
          Leanplum.setAppIdForProductionMode(str1, (String)???);
          L.d("Starting leanplum in production mode with key: " + (String)???, new Object[0]);
          continue;
        }
        Leanplum.start(paramActivity.getApplicationContext(), str1, LEANPLUM_ATTRIBUTES);
      }
    }
  }
  
  private static void refreshConfiguration(final boolean paramBoolean, final ILeanplumOverrideService paramILeanplumOverrideService, final IConstantsProvider paramIConstantsProvider)
  {
    long l = SystemClock.elapsedRealtime();
    if ((!paramBoolean) && (l < updateTimestamp + 30000L)) {
      return;
    }
    if (!paramILeanplumOverrideService.isLeanplumEnabled())
    {
      clearLeanplumVariables(paramIConstantsProvider);
      return;
    }
    updateTimestamp = l;
    synchronized (DISPATCH_LOCK)
    {
      if (outstandingUpdate)
      {
        pendingUpdate = true;
        return;
      }
    }
    pendingUpdate = false;
    outstandingUpdate = true;
    CallAnalytics localCallAnalytics = new CallAnalytics(CallEvent.Call.LEANPLUM_UPDATE);
    localCallAnalytics.trackInitiation();
    Leanplum.forceContentUpdate(new VariablesChangedCallback()
    {
      public void variablesChanged()
      {
        val$leanplumUpdate.trackSuccess();
        LeanplumService.updateConstants((Map)Leanplum.objectForKeyPath(new Object[] { "client" }), paramIConstantsProvider);
        if (paramBoolean) {
          ExperimentAnalytics.reset();
        }
        ExperimentAnalytics.updateAssignments(LeanplumService.access$300());
        synchronized (LeanplumService.DISPATCH_LOCK)
        {
          LeanplumService.access$502(false);
          if (LeanplumService.pendingUpdate) {
            LeanplumService.refreshConfiguration(true, paramILeanplumOverrideService, paramIConstantsProvider);
          }
          return;
        }
      }
    });
  }
  
  private void startPolling()
  {
    stopPolling();
    final Scheduler.Worker localWorker = Schedulers.computation().createWorker();
    pollingSubscription = localWorker;
    long l = Math.round(1000.0D * ((Double)constantsProvider.get(Constants.LEANPLUM_POLLING_INTERVAL)).doubleValue());
    localWorker.schedule(new Action0()
    {
      public void call()
      {
        LeanplumService.refreshConfiguration(false, leanplumOverrideService, constantsProvider);
        long l = Math.round(((Double)constantsProvider.get(Constants.LEANPLUM_POLLING_INTERVAL)).doubleValue() * 1000.0D);
        localWorker.schedule(this, l, TimeUnit.MILLISECONDS);
      }
    }, l, TimeUnit.MILLISECONDS);
  }
  
  private void stopPolling()
  {
    pollingSubscription.unsubscribe();
  }
  
  private static void updateConstants(Map<String, Object> paramMap, IConstantsProvider paramIConstantsProvider)
  {
    paramIConstantsProvider.update(paramMap, Priority.TERTIARY);
  }
  
  public void onActivityCreated(Activity paramActivity, Bundle paramBundle)
  {
    super.onActivityCreated(paramActivity, paramBundle);
    helper = new LeanplumActivityHelper(paramActivity);
    initializeSDK(paramActivity);
    startPolling();
  }
  
  public void onActivityPaused(Activity paramActivity)
  {
    super.onActivityPaused(paramActivity);
    stopPolling();
    helper.onPause();
  }
  
  public void onActivityResumed(Activity paramActivity)
  {
    super.onActivityResumed(paramActivity);
    refreshConfiguration(false, leanplumOverrideService, constantsProvider);
    startPolling();
    helper.onResume();
  }
  
  public void onActivityStopped(Activity paramActivity)
  {
    super.onActivityStopped(paramActivity);
    stopPolling();
    helper.onStop();
  }
  
  private static final class UserUpdateCallback
    implements Action1<User>
  {
    private final IConstantsProvider constantsProvider;
    private String currentUserId;
    private final ILeanplumOverrideService leanplumOverrideService;
    
    private UserUpdateCallback(String paramString, ILeanplumOverrideService paramILeanplumOverrideService, IConstantsProvider paramIConstantsProvider)
    {
      currentUserId = paramString;
      leanplumOverrideService = paramILeanplumOverrideService;
      constantsProvider = paramIConstantsProvider;
    }
    
    public void call(User paramUser)
    {
      Object localObject = paramUser.getLyftId();
      int j = 0;
      int i = j;
      if (!Strings.isNullOrEmpty((String)localObject))
      {
        i = j;
        if (!((String)localObject).equals(currentUserId))
        {
          currentUserId = ((String)localObject);
          Leanplum.setUserId((String)localObject);
          i = 1;
        }
      }
      localObject = Boolean.valueOf(paramUser.isApprovedDriver());
      j = i;
      if (localObject != null)
      {
        j = i;
        if (!((Boolean)localObject).equals(LeanplumService.LEANPLUM_ATTRIBUTES.get("approvedDriver")))
        {
          LeanplumService.LEANPLUM_ATTRIBUTES.put("approvedDriver", localObject);
          Leanplum.setUserAttributes(LeanplumService.LEANPLUM_ATTRIBUTES);
          j = 1;
        }
      }
      paramUser = paramUser.getRegion();
      i = j;
      if (!Strings.isNullOrEmpty(paramUser))
      {
        i = j;
        if (!paramUser.equals(LeanplumService.LEANPLUM_ATTRIBUTES.get("region")))
        {
          LeanplumService.LEANPLUM_ATTRIBUTES.put("region", paramUser);
          Leanplum.setUserAttributes(LeanplumService.LEANPLUM_ATTRIBUTES);
          i = 1;
        }
      }
      if (i != 0) {
        LeanplumService.refreshConfiguration(true, leanplumOverrideService, constantsProvider);
      }
    }
  }
}

/* Location:
 * Qualified Name:     me.lyft.android.infrastructure.leanplum.LeanplumService
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */