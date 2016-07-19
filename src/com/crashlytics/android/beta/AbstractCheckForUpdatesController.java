package com.crashlytics.android.beta;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import io.fabric.sdk.android.Fabric;
import io.fabric.sdk.android.Logger;
import io.fabric.sdk.android.services.common.ApiKey;
import io.fabric.sdk.android.services.common.CurrentTimeProvider;
import io.fabric.sdk.android.services.common.IdManager;
import io.fabric.sdk.android.services.common.IdManager.DeviceIdentifierType;
import io.fabric.sdk.android.services.network.HttpRequestFactory;
import io.fabric.sdk.android.services.persistence.PreferenceStore;
import io.fabric.sdk.android.services.settings.BetaSettingsData;
import java.util.Map;
import java.util.concurrent.atomic.AtomicBoolean;

abstract class AbstractCheckForUpdatesController
  implements UpdatesController
{
  private Beta beta;
  private BetaSettingsData betaSettings;
  private BuildProperties buildProps;
  private Context context;
  private CurrentTimeProvider currentTimeProvider;
  private final AtomicBoolean externallyReady;
  private HttpRequestFactory httpRequestFactory;
  private IdManager idManager;
  private final AtomicBoolean initialized = new AtomicBoolean();
  private long lastCheckTimeMillis = 0L;
  private PreferenceStore preferenceStore;
  
  public AbstractCheckForUpdatesController()
  {
    this(false);
  }
  
  public AbstractCheckForUpdatesController(boolean paramBoolean)
  {
    externallyReady = new AtomicBoolean(paramBoolean);
  }
  
  private void performUpdateCheck()
  {
    Fabric.getLogger().d("Beta", "Performing update check");
    String str1 = new ApiKey().getValue(context);
    String str2 = (String)idManager.getDeviceIdentifiers().get(IdManager.DeviceIdentifierType.FONT_TOKEN);
    new CheckForUpdatesRequest(beta, beta.getOverridenSpiEndpoint(), betaSettings.updateUrl, httpRequestFactory, new CheckForUpdatesResponseTransform()).invoke(str1, str2, buildProps);
  }
  
  @SuppressLint({"CommitPrefEdits"})
  protected void checkForUpdates()
  {
    long l1;
    synchronized (preferenceStore)
    {
      if (preferenceStore.get().contains("last_update_check")) {
        preferenceStore.save(preferenceStore.edit().remove("last_update_check"));
      }
      l1 = currentTimeProvider.getCurrentTimeMillis();
      long l2 = betaSettings.updateSuspendDurationSeconds * 1000L;
      Fabric.getLogger().d("Beta", "Check for updates delay: " + l2);
      Fabric.getLogger().d("Beta", "Check for updates last check time: " + getLastCheckTimeMillis());
      l2 = getLastCheckTimeMillis() + l2;
      Fabric.getLogger().d("Beta", "Check for updates current time: " + l1 + ", next check time: " + l2);
      if (l1 < l2) {}
    }
    Fabric.getLogger().d("Beta", "Check for updates next check time was not passed");
  }
  
  long getLastCheckTimeMillis()
  {
    return lastCheckTimeMillis;
  }
  
  public void initialize(Context paramContext, Beta paramBeta, IdManager paramIdManager, BetaSettingsData paramBetaSettingsData, BuildProperties paramBuildProperties, PreferenceStore paramPreferenceStore, CurrentTimeProvider paramCurrentTimeProvider, HttpRequestFactory paramHttpRequestFactory)
  {
    context = paramContext;
    beta = paramBeta;
    idManager = paramIdManager;
    betaSettings = paramBetaSettingsData;
    buildProps = paramBuildProperties;
    preferenceStore = paramPreferenceStore;
    currentTimeProvider = paramCurrentTimeProvider;
    httpRequestFactory = paramHttpRequestFactory;
    if (signalInitialized()) {
      checkForUpdates();
    }
  }
  
  void setLastCheckTimeMillis(long paramLong)
  {
    lastCheckTimeMillis = paramLong;
  }
  
  protected boolean signalExternallyReady()
  {
    externallyReady.set(true);
    return initialized.get();
  }
  
  boolean signalInitialized()
  {
    initialized.set(true);
    return externallyReady.get();
  }
}

/* Location:
 * Qualified Name:     com.crashlytics.android.beta.AbstractCheckForUpdatesController
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */