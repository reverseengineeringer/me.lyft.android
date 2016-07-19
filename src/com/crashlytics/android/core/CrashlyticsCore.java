package com.crashlytics.android.core;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.app.AlertDialog.Builder;
import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.content.pm.PackageManager.NameNotFoundException;
import android.content.res.Resources;
import android.util.DisplayMetrics;
import android.widget.ScrollView;
import android.widget.TextView;
import com.crashlytics.android.answers.Answers;
import com.crashlytics.android.core.internal.CrashEventDataProvider;
import com.crashlytics.android.core.internal.models.SessionEventData;
import io.fabric.sdk.android.Fabric;
import io.fabric.sdk.android.Kit;
import io.fabric.sdk.android.Logger;
import io.fabric.sdk.android.services.common.ApiKey;
import io.fabric.sdk.android.services.common.CommonUtils;
import io.fabric.sdk.android.services.common.Crash.FatalException;
import io.fabric.sdk.android.services.common.Crash.LoggedException;
import io.fabric.sdk.android.services.common.ExecutorUtils;
import io.fabric.sdk.android.services.common.IdManager;
import io.fabric.sdk.android.services.concurrency.DependsOn;
import io.fabric.sdk.android.services.concurrency.Priority;
import io.fabric.sdk.android.services.concurrency.PriorityCallable;
import io.fabric.sdk.android.services.concurrency.Task;
import io.fabric.sdk.android.services.concurrency.UnmetDependencyException;
import io.fabric.sdk.android.services.network.DefaultHttpRequestFactory;
import io.fabric.sdk.android.services.network.HttpRequestFactory;
import io.fabric.sdk.android.services.persistence.FileStore;
import io.fabric.sdk.android.services.persistence.FileStoreImpl;
import io.fabric.sdk.android.services.persistence.PreferenceStore;
import io.fabric.sdk.android.services.persistence.PreferenceStoreImpl;
import io.fabric.sdk.android.services.settings.AppSettingsData;
import io.fabric.sdk.android.services.settings.FeaturesSettingsData;
import io.fabric.sdk.android.services.settings.PromptSettingsData;
import io.fabric.sdk.android.services.settings.SessionSettingsData;
import io.fabric.sdk.android.services.settings.Settings;
import io.fabric.sdk.android.services.settings.Settings.SettingsAccess;
import io.fabric.sdk.android.services.settings.SettingsData;
import java.io.File;
import java.util.Collection;
import java.util.Collections;
import java.util.Iterator;
import java.util.Map;
import java.util.concurrent.Callable;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;

@DependsOn({CrashEventDataProvider.class})
public class CrashlyticsCore
  extends Kit<Void>
{
  private String apiKey;
  private final ConcurrentHashMap<String, String> attributes;
  private String buildId;
  private CrashlyticsFileMarker crashMarker;
  private float delay;
  private boolean disabled;
  private CrashlyticsExecutorServiceWrapper executorServiceWrapper;
  private CrashEventDataProvider externalCrashEventDataProvider;
  private FileStore fileStore;
  private CrashlyticsUncaughtExceptionHandler handler;
  private HttpRequestFactory httpRequestFactory;
  private CrashlyticsFileMarker initializationMarker;
  private String installerPackageName;
  private CrashlyticsListener listener;
  private String packageName;
  private final PinningInfoProvider pinningInfo;
  private File sdkDir;
  private final long startTime;
  private String userEmail = null;
  private String userId = null;
  private String userName = null;
  private String versionCode;
  private String versionName;
  
  public CrashlyticsCore()
  {
    this(1.0F, null, null, false);
  }
  
  CrashlyticsCore(float paramFloat, CrashlyticsListener paramCrashlyticsListener, PinningInfoProvider paramPinningInfoProvider, boolean paramBoolean)
  {
    this(paramFloat, paramCrashlyticsListener, paramPinningInfoProvider, paramBoolean, ExecutorUtils.buildSingleThreadExecutorService("Crashlytics Exception Handler"));
  }
  
  CrashlyticsCore(float paramFloat, CrashlyticsListener paramCrashlyticsListener, PinningInfoProvider paramPinningInfoProvider, boolean paramBoolean, ExecutorService paramExecutorService)
  {
    delay = paramFloat;
    if (paramCrashlyticsListener != null) {}
    for (;;)
    {
      listener = paramCrashlyticsListener;
      pinningInfo = paramPinningInfoProvider;
      disabled = paramBoolean;
      executorServiceWrapper = new CrashlyticsExecutorServiceWrapper(paramExecutorService);
      attributes = new ConcurrentHashMap();
      startTime = System.currentTimeMillis();
      return;
      paramCrashlyticsListener = new NoOpListener(null);
    }
  }
  
  private void checkForPreviousCrash()
  {
    Boolean localBoolean = (Boolean)executorServiceWrapper.executeSyncLoggingException(new CrashMarkerCheck(crashMarker));
    if (!Boolean.TRUE.equals(localBoolean)) {
      return;
    }
    try
    {
      listener.crashlyticsDidDetectCrashDuringPreviousExecution();
      return;
    }
    catch (Exception localException)
    {
      Fabric.getLogger().e("CrashlyticsCore", "Exception thrown by CrashlyticsListener while notifying of previous crash.", localException);
    }
  }
  
  private static int dipsToPixels(float paramFloat, int paramInt)
  {
    return (int)(paramInt * paramFloat);
  }
  
  private void doLog(int paramInt, String paramString1, String paramString2)
  {
    if (disabled) {}
    while (!ensureFabricWithCalled("prior to logging messages.")) {
      return;
    }
    long l1 = System.currentTimeMillis();
    long l2 = startTime;
    handler.writeToLog(l1 - l2, formatLogMessage(paramInt, paramString1, paramString2));
  }
  
  private static boolean ensureFabricWithCalled(String paramString)
  {
    CrashlyticsCore localCrashlyticsCore = getInstance();
    if ((localCrashlyticsCore == null) || (handler == null))
    {
      Fabric.getLogger().e("CrashlyticsCore", "Crashlytics must be initialized by calling Fabric.with(Context) " + paramString, null);
      return false;
    }
    return true;
  }
  
  private void finishInitSynchronously()
  {
    Object localObject = new PriorityCallable()
    {
      public Void call()
        throws Exception
      {
        return doInBackground();
      }
      
      public Priority getPriority()
      {
        return Priority.IMMEDIATE;
      }
    };
    Iterator localIterator = getDependencies().iterator();
    while (localIterator.hasNext()) {
      ((PriorityCallable)localObject).addDependency((Task)localIterator.next());
    }
    localObject = getFabric().getExecutorService().submit((Callable)localObject);
    Fabric.getLogger().d("CrashlyticsCore", "Crashlytics detected incomplete initialization on previous app launch. Will initialize synchronously.");
    try
    {
      ((Future)localObject).get(4L, TimeUnit.SECONDS);
      return;
    }
    catch (InterruptedException localInterruptedException)
    {
      Fabric.getLogger().e("CrashlyticsCore", "Crashlytics was interrupted during initialization.", localInterruptedException);
      return;
    }
    catch (ExecutionException localExecutionException)
    {
      Fabric.getLogger().e("CrashlyticsCore", "Problem encountered during Crashlytics initialization.", localExecutionException);
      return;
    }
    catch (TimeoutException localTimeoutException)
    {
      Fabric.getLogger().e("CrashlyticsCore", "Crashlytics timed out during initialization.", localTimeoutException);
    }
  }
  
  private static String formatLogMessage(int paramInt, String paramString1, String paramString2)
  {
    return CommonUtils.logPriorityToString(paramInt) + "/" + paramString1 + " " + paramString2;
  }
  
  public static CrashlyticsCore getInstance()
  {
    return (CrashlyticsCore)Fabric.getKit(CrashlyticsCore.class);
  }
  
  private boolean getSendDecisionFromUser(final Activity paramActivity, final PromptSettingsData paramPromptSettingsData)
  {
    final DialogStringResolver localDialogStringResolver = new DialogStringResolver(paramActivity, paramPromptSettingsData);
    final OptInLatch localOptInLatch = new OptInLatch(null);
    paramActivity.runOnUiThread(new Runnable()
    {
      public void run()
      {
        AlertDialog.Builder localBuilder = new AlertDialog.Builder(paramActivity);
        Object localObject = new DialogInterface.OnClickListener()
        {
          public void onClick(DialogInterface paramAnonymous2DialogInterface, int paramAnonymous2Int)
          {
            val$latch.setOptIn(true);
            paramAnonymous2DialogInterface.dismiss();
          }
        };
        float f = paramActivitygetResourcesgetDisplayMetricsdensity;
        int i = CrashlyticsCore.dipsToPixels(f, 5);
        TextView localTextView = new TextView(paramActivity);
        localTextView.setAutoLinkMask(15);
        localTextView.setText(localDialogStringResolver.getMessage());
        localTextView.setTextAppearance(paramActivity, 16973892);
        localTextView.setPadding(i, i, i, i);
        localTextView.setFocusable(false);
        ScrollView localScrollView = new ScrollView(paramActivity);
        localScrollView.setPadding(CrashlyticsCore.dipsToPixels(f, 14), CrashlyticsCore.dipsToPixels(f, 2), CrashlyticsCore.dipsToPixels(f, 10), CrashlyticsCore.dipsToPixels(f, 12));
        localScrollView.addView(localTextView);
        localBuilder.setView(localScrollView).setTitle(localDialogStringResolver.getTitle()).setCancelable(false).setNeutralButton(localDialogStringResolver.getSendButtonTitle(), (DialogInterface.OnClickListener)localObject);
        if (paramPromptSettingsDatashowCancelButton)
        {
          localObject = new DialogInterface.OnClickListener()
          {
            public void onClick(DialogInterface paramAnonymous2DialogInterface, int paramAnonymous2Int)
            {
              val$latch.setOptIn(false);
              paramAnonymous2DialogInterface.dismiss();
            }
          };
          localBuilder.setNegativeButton(localDialogStringResolver.getCancelButtonTitle(), (DialogInterface.OnClickListener)localObject);
        }
        if (paramPromptSettingsDatashowAlwaysSendButton)
        {
          localObject = new DialogInterface.OnClickListener()
          {
            public void onClick(DialogInterface paramAnonymous2DialogInterface, int paramAnonymous2Int)
            {
              setShouldSendUserReportsWithoutPrompting(true);
              val$latch.setOptIn(true);
              paramAnonymous2DialogInterface.dismiss();
            }
          };
          localBuilder.setPositiveButton(localDialogStringResolver.getAlwaysSendButtonTitle(), (DialogInterface.OnClickListener)localObject);
        }
        localBuilder.show();
      }
    });
    Fabric.getLogger().d("CrashlyticsCore", "Waiting for user opt-in.");
    localOptInLatch.await();
    return localOptInLatch.getOptIn();
  }
  
  static SessionSettingsData getSessionSettingsData()
  {
    SettingsData localSettingsData = Settings.getInstance().awaitSettingsData();
    if (localSettingsData == null) {
      return null;
    }
    return sessionData;
  }
  
  private void installExceptionHandler(UnityVersionProvider paramUnityVersionProvider)
  {
    try
    {
      Fabric.getLogger().d("CrashlyticsCore", "Installing exception handler...");
      handler = new CrashlyticsUncaughtExceptionHandler(Thread.getDefaultUncaughtExceptionHandler(), executorServiceWrapper, getIdManager(), paramUnityVersionProvider, fileStore, this);
      handler.openSession();
      Thread.setDefaultUncaughtExceptionHandler(handler);
      Fabric.getLogger().d("CrashlyticsCore", "Successfully installed exception handler.");
      return;
    }
    catch (Exception paramUnityVersionProvider)
    {
      Fabric.getLogger().e("CrashlyticsCore", "There was a problem installing the exception handler.", paramUnityVersionProvider);
    }
  }
  
  private static boolean isRequiringBuildId(Context paramContext)
  {
    return CommonUtils.getBooleanResourceValue(paramContext, "com.crashlytics.RequireBuildId", true);
  }
  
  static void recordFatalExceptionEvent(String paramString)
  {
    Answers localAnswers = (Answers)Fabric.getKit(Answers.class);
    if (localAnswers != null) {
      localAnswers.onException(new Crash.FatalException(paramString));
    }
  }
  
  static void recordLoggedExceptionEvent(String paramString)
  {
    Answers localAnswers = (Answers)Fabric.getKit(Answers.class);
    if (localAnswers != null) {
      localAnswers.onException(new Crash.LoggedException(paramString));
    }
  }
  
  private static String sanitizeAttribute(String paramString)
  {
    String str = paramString;
    if (paramString != null)
    {
      paramString = paramString.trim();
      str = paramString;
      if (paramString.length() > 1024) {
        str = paramString.substring(0, 1024);
      }
    }
    return str;
  }
  
  private void setAndValidateKitProperties(Context paramContext, String paramString)
    throws PackageManager.NameNotFoundException
  {
    if (pinningInfo != null)
    {
      localObject = new CrashlyticsPinningInfoProvider(pinningInfo);
      httpRequestFactory = new DefaultHttpRequestFactory(Fabric.getLogger());
      httpRequestFactory.setPinningInfoProvider((io.fabric.sdk.android.services.network.PinningInfoProvider)localObject);
      packageName = paramContext.getPackageName();
      installerPackageName = getIdManager().getInstallerPackageName();
      Fabric.getLogger().d("CrashlyticsCore", "Installer package name is: " + installerPackageName);
      localObject = paramContext.getPackageManager().getPackageInfo(packageName, 0);
      versionCode = Integer.toString(versionCode);
      if (versionName != null) {
        break label169;
      }
    }
    label169:
    for (Object localObject = "0.0";; localObject = versionName)
    {
      versionName = ((String)localObject);
      buildId = CommonUtils.resolveBuildId(paramContext);
      getBuildIdValidator(buildId, isRequiringBuildId(paramContext)).validate(paramString, packageName);
      return;
      localObject = null;
      break;
    }
  }
  
  boolean canSendWithUserApproval()
  {
    ((Boolean)Settings.getInstance().withSettings(new Settings.SettingsAccess()
    {
      public Boolean usingSettings(SettingsData paramAnonymousSettingsData)
      {
        boolean bool2 = true;
        Activity localActivity = getFabric().getCurrentActivity();
        boolean bool1 = bool2;
        if (localActivity != null)
        {
          bool1 = bool2;
          if (!localActivity.isFinishing())
          {
            bool1 = bool2;
            if (shouldPromptUserBeforeSendingCrashReports()) {
              bool1 = CrashlyticsCore.this.getSendDecisionFromUser(localActivity, promptData);
            }
          }
        }
        return Boolean.valueOf(bool1);
      }
    }, Boolean.valueOf(true))).booleanValue();
  }
  
  void createCrashMarker()
  {
    crashMarker.create();
  }
  
  boolean didPreviousInitializationFail()
  {
    ((Boolean)executorServiceWrapper.executeSyncLoggingException(new Callable()
    {
      public Boolean call()
        throws Exception
      {
        return Boolean.valueOf(initializationMarker.isPresent());
      }
    })).booleanValue();
  }
  
  protected Void doInBackground()
  {
    markInitializationStarted();
    handler.cleanInvalidTempFiles();
    try
    {
      Object localObject1 = Settings.getInstance().awaitSettingsData();
      if (localObject1 == null)
      {
        Fabric.getLogger().w("CrashlyticsCore", "Received null settings, skipping initialization!");
        return null;
      }
      if (!featuresData.collectReports)
      {
        Fabric.getLogger().d("CrashlyticsCore", "Collection of crash reports disabled in Crashlytics settings.");
        return null;
      }
      handler.finalizeSessions();
      localObject1 = getCreateReportSpiCall((SettingsData)localObject1);
      if (localObject1 == null)
      {
        Fabric.getLogger().w("CrashlyticsCore", "Unable to create a call to upload reports.");
        return null;
      }
      new ReportUploader((CreateReportSpiCall)localObject1).uploadReports(delay);
      return null;
    }
    catch (Exception localException)
    {
      Fabric.getLogger().e("CrashlyticsCore", "Crashlytics encountered a problem during asynchronous initialization.", localException);
      return null;
    }
    finally
    {
      markInitializationComplete();
    }
  }
  
  String getApiKey()
  {
    return apiKey;
  }
  
  Map<String, String> getAttributes()
  {
    return Collections.unmodifiableMap(attributes);
  }
  
  String getBuildId()
  {
    return buildId;
  }
  
  BuildIdValidator getBuildIdValidator(String paramString, boolean paramBoolean)
  {
    return new BuildIdValidator(paramString, paramBoolean);
  }
  
  CreateReportSpiCall getCreateReportSpiCall(SettingsData paramSettingsData)
  {
    if (paramSettingsData != null) {
      return new DefaultCreateReportSpiCall(this, getOverridenSpiEndpoint(), appData.reportsUrl, httpRequestFactory);
    }
    return null;
  }
  
  SessionEventData getExternalCrashEventData()
  {
    SessionEventData localSessionEventData = null;
    if (externalCrashEventDataProvider != null) {
      localSessionEventData = externalCrashEventDataProvider.getCrashEventData();
    }
    return localSessionEventData;
  }
  
  CrashlyticsUncaughtExceptionHandler getHandler()
  {
    return handler;
  }
  
  public String getIdentifier()
  {
    return "com.crashlytics.sdk.android.crashlytics-core";
  }
  
  String getInstallerPackageName()
  {
    return installerPackageName;
  }
  
  String getOverridenSpiEndpoint()
  {
    return CommonUtils.getStringsFileValue(getContext(), "com.crashlytics.ApiEndpoint");
  }
  
  String getPackageName()
  {
    return packageName;
  }
  
  File getSdkDirectory()
  {
    if (sdkDir == null) {
      sdkDir = new FileStoreImpl(this).getFilesDir();
    }
    return sdkDir;
  }
  
  String getUserEmail()
  {
    if (getIdManager().canCollectUserIds()) {
      return userEmail;
    }
    return null;
  }
  
  String getUserIdentifier()
  {
    if (getIdManager().canCollectUserIds()) {
      return userId;
    }
    return null;
  }
  
  String getUserName()
  {
    if (getIdManager().canCollectUserIds()) {
      return userName;
    }
    return null;
  }
  
  public String getVersion()
  {
    return "2.3.8.97";
  }
  
  String getVersionCode()
  {
    return versionCode;
  }
  
  String getVersionName()
  {
    return versionName;
  }
  
  public void log(String paramString)
  {
    doLog(3, "CrashlyticsCore", paramString);
  }
  
  public void logException(Throwable paramThrowable)
  {
    if (disabled) {}
    while (!ensureFabricWithCalled("prior to logging exceptions.")) {
      return;
    }
    if (paramThrowable == null)
    {
      Fabric.getLogger().log(5, "CrashlyticsCore", "Crashlytics is ignoring a request to log a null exception.");
      return;
    }
    handler.writeNonFatalException(Thread.currentThread(), paramThrowable);
  }
  
  void markInitializationComplete()
  {
    executorServiceWrapper.executeAsync(new Callable()
    {
      public Boolean call()
        throws Exception
      {
        try
        {
          boolean bool = initializationMarker.remove();
          Fabric.getLogger().d("CrashlyticsCore", "Initialization marker file removed: " + bool);
          return Boolean.valueOf(bool);
        }
        catch (Exception localException)
        {
          Fabric.getLogger().e("CrashlyticsCore", "Problem encountered deleting Crashlytics initialization marker.", localException);
        }
        return Boolean.valueOf(false);
      }
    });
  }
  
  void markInitializationStarted()
  {
    executorServiceWrapper.executeSyncLoggingException(new Callable()
    {
      public Void call()
        throws Exception
      {
        initializationMarker.create();
        Fabric.getLogger().d("CrashlyticsCore", "Initialization marker file created.");
        return null;
      }
    });
  }
  
  protected boolean onPreExecute()
  {
    return onPreExecute(super.getContext());
  }
  
  boolean onPreExecute(Context paramContext)
  {
    if (disabled) {}
    do
    {
      return false;
      apiKey = new ApiKey().getValue(paramContext);
    } while (apiKey == null);
    Fabric.getLogger().i("CrashlyticsCore", "Initializing Crashlytics " + getVersion());
    fileStore = new FileStoreImpl(this);
    crashMarker = new CrashlyticsFileMarker("crash_marker", fileStore);
    initializationMarker = new CrashlyticsFileMarker("initialization_marker", fileStore);
    try
    {
      setAndValidateKitProperties(paramContext, apiKey);
      ManifestUnityVersionProvider localManifestUnityVersionProvider = new ManifestUnityVersionProvider(paramContext, getPackageName());
      boolean bool = didPreviousInitializationFail();
      checkForPreviousCrash();
      installExceptionHandler(localManifestUnityVersionProvider);
      if ((bool) && (CommonUtils.canTryConnection(paramContext)))
      {
        finishInitSynchronously();
        return false;
      }
    }
    catch (CrashlyticsMissingDependencyException paramContext)
    {
      throw new UnmetDependencyException(paramContext);
      return true;
    }
    catch (Exception paramContext)
    {
      Fabric.getLogger().e("CrashlyticsCore", "Crashlytics was not started due to an exception during initialization", paramContext);
    }
    return false;
  }
  
  @SuppressLint({"CommitPrefEdits"})
  void setShouldSendUserReportsWithoutPrompting(boolean paramBoolean)
  {
    PreferenceStoreImpl localPreferenceStoreImpl = new PreferenceStoreImpl(this);
    localPreferenceStoreImpl.save(localPreferenceStoreImpl.edit().putBoolean("always_send_reports_opt_in", paramBoolean));
  }
  
  public void setString(String paramString1, String paramString2)
  {
    if (disabled) {
      return;
    }
    if (paramString1 == null)
    {
      paramString1 = getContext();
      if ((paramString1 != null) && (CommonUtils.isAppDebuggable(paramString1))) {
        throw new IllegalArgumentException("Custom attribute key must not be null.");
      }
      Fabric.getLogger().e("CrashlyticsCore", "Attempting to set custom attribute with null key, ignoring.", null);
      return;
    }
    String str = sanitizeAttribute(paramString1);
    if ((attributes.size() >= 64) && (!attributes.containsKey(str)))
    {
      Fabric.getLogger().d("CrashlyticsCore", "Exceeded maximum number of custom attributes (64)");
      return;
    }
    if (paramString2 == null) {}
    for (paramString1 = "";; paramString1 = sanitizeAttribute(paramString2))
    {
      attributes.put(str, paramString1);
      handler.cacheKeyData(attributes);
      return;
    }
  }
  
  public void setUserEmail(String paramString)
  {
    if (disabled) {
      return;
    }
    userEmail = sanitizeAttribute(paramString);
    handler.cacheUserData(userId, userName, userEmail);
  }
  
  public void setUserIdentifier(String paramString)
  {
    if (disabled) {
      return;
    }
    userId = sanitizeAttribute(paramString);
    handler.cacheUserData(userId, userName, userEmail);
  }
  
  public void setUserName(String paramString)
  {
    if (disabled) {
      return;
    }
    userName = sanitizeAttribute(paramString);
    handler.cacheUserData(userId, userName, userEmail);
  }
  
  boolean shouldPromptUserBeforeSendingCrashReports()
  {
    ((Boolean)Settings.getInstance().withSettings(new Settings.SettingsAccess()
    {
      public Boolean usingSettings(SettingsData paramAnonymousSettingsData)
      {
        boolean bool = false;
        if (featuresData.promptEnabled)
        {
          if (!shouldSendReportsWithoutPrompting()) {
            bool = true;
          }
          return Boolean.valueOf(bool);
        }
        return Boolean.valueOf(false);
      }
    }, Boolean.valueOf(false))).booleanValue();
  }
  
  boolean shouldSendReportsWithoutPrompting()
  {
    return new PreferenceStoreImpl(this).get().getBoolean("always_send_reports_opt_in", false);
  }
  
  private static final class CrashMarkerCheck
    implements Callable<Boolean>
  {
    private final CrashlyticsFileMarker crashMarker;
    
    public CrashMarkerCheck(CrashlyticsFileMarker paramCrashlyticsFileMarker)
    {
      crashMarker = paramCrashlyticsFileMarker;
    }
    
    public Boolean call()
      throws Exception
    {
      if (!crashMarker.isPresent()) {
        return Boolean.FALSE;
      }
      Fabric.getLogger().d("CrashlyticsCore", "Found previous crash marker.");
      crashMarker.remove();
      return Boolean.TRUE;
    }
  }
  
  private static final class NoOpListener
    implements CrashlyticsListener
  {
    public void crashlyticsDidDetectCrashDuringPreviousExecution() {}
  }
  
  private static class OptInLatch
  {
    private final CountDownLatch latch = new CountDownLatch(1);
    private boolean send = false;
    
    void await()
    {
      try
      {
        latch.await();
        return;
      }
      catch (InterruptedException localInterruptedException) {}
    }
    
    boolean getOptIn()
    {
      return send;
    }
    
    void setOptIn(boolean paramBoolean)
    {
      send = paramBoolean;
      latch.countDown();
    }
  }
}

/* Location:
 * Qualified Name:     com.crashlytics.android.core.CrashlyticsCore
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */