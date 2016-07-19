package io.fabric.sdk.android;

import android.content.Context;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.content.pm.PackageManager.NameNotFoundException;
import io.fabric.sdk.android.services.common.ApiKey;
import io.fabric.sdk.android.services.common.CommonUtils;
import io.fabric.sdk.android.services.common.DeliveryMechanism;
import io.fabric.sdk.android.services.common.IdManager;
import io.fabric.sdk.android.services.network.DefaultHttpRequestFactory;
import io.fabric.sdk.android.services.network.HttpRequestFactory;
import io.fabric.sdk.android.services.settings.AppRequestData;
import io.fabric.sdk.android.services.settings.AppSettingsData;
import io.fabric.sdk.android.services.settings.CreateAppSpiCall;
import io.fabric.sdk.android.services.settings.IconRequest;
import io.fabric.sdk.android.services.settings.Settings;
import io.fabric.sdk.android.services.settings.SettingsData;
import io.fabric.sdk.android.services.settings.UpdateAppSpiCall;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.concurrent.Future;

class Onboarding
  extends Kit<Boolean>
{
  private String applicationLabel;
  private String installerPackageName;
  private final Future<Map<String, KitInfo>> kitsFinder;
  private PackageInfo packageInfo;
  private PackageManager packageManager;
  private String packageName;
  private final Collection<Kit> providedKits;
  private final HttpRequestFactory requestFactory = new DefaultHttpRequestFactory();
  private String targetAndroidSdkVersion;
  private String versionCode;
  private String versionName;
  
  public Onboarding(Future<Map<String, KitInfo>> paramFuture, Collection<Kit> paramCollection)
  {
    kitsFinder = paramFuture;
    providedKits = paramCollection;
  }
  
  private AppRequestData buildAppRequest(IconRequest paramIconRequest, Collection<KitInfo> paramCollection)
  {
    Object localObject = getContext();
    String str = new ApiKey().getValue((Context)localObject);
    localObject = CommonUtils.createInstanceIdFrom(new String[] { CommonUtils.resolveBuildId((Context)localObject) });
    int i = DeliveryMechanism.determineFrom(installerPackageName).getId();
    return new AppRequestData(str, getIdManager().getAppIdentifier(), versionName, versionCode, (String)localObject, applicationLabel, i, targetAndroidSdkVersion, "0", paramIconRequest, paramCollection);
  }
  
  private boolean performAutoConfigure(String paramString, AppSettingsData paramAppSettingsData, Collection<KitInfo> paramCollection)
  {
    boolean bool = true;
    if ("new".equals(status)) {
      if (performCreateApp(paramString, paramAppSettingsData, paramCollection)) {
        bool = Settings.getInstance().loadSettingsSkippingCache();
      }
    }
    do
    {
      return bool;
      Fabric.getLogger().e("Fabric", "Failed to create app with Crashlytics service.", null);
      return false;
      if ("configured".equals(status)) {
        return Settings.getInstance().loadSettingsSkippingCache();
      }
    } while (!updateRequired);
    Fabric.getLogger().d("Fabric", "Server says an update is required - forcing a full App update.");
    performUpdateApp(paramString, paramAppSettingsData, paramCollection);
    return true;
  }
  
  private boolean performCreateApp(String paramString, AppSettingsData paramAppSettingsData, Collection<KitInfo> paramCollection)
  {
    paramString = buildAppRequest(IconRequest.build(getContext(), paramString), paramCollection);
    return new CreateAppSpiCall(this, getOverridenSpiEndpoint(), url, requestFactory).invoke(paramString);
  }
  
  private boolean performUpdateApp(AppSettingsData paramAppSettingsData, IconRequest paramIconRequest, Collection<KitInfo> paramCollection)
  {
    paramIconRequest = buildAppRequest(paramIconRequest, paramCollection);
    return new UpdateAppSpiCall(this, getOverridenSpiEndpoint(), url, requestFactory).invoke(paramIconRequest);
  }
  
  private boolean performUpdateApp(String paramString, AppSettingsData paramAppSettingsData, Collection<KitInfo> paramCollection)
  {
    return performUpdateApp(paramAppSettingsData, IconRequest.build(getContext(), paramString), paramCollection);
  }
  
  private SettingsData retrieveSettingsData()
  {
    try
    {
      Settings.getInstance().initialize(this, idManager, requestFactory, versionCode, versionName, getOverridenSpiEndpoint()).loadSettingsData();
      SettingsData localSettingsData = Settings.getInstance().awaitSettingsData();
      return localSettingsData;
    }
    catch (Exception localException)
    {
      Fabric.getLogger().e("Fabric", "Error dealing with settings", localException);
    }
    return null;
  }
  
  protected Boolean doInBackground()
  {
    String str = CommonUtils.getAppIconHashOrNull(getContext());
    bool2 = false;
    SettingsData localSettingsData = retrieveSettingsData();
    bool1 = bool2;
    if (localSettingsData != null) {}
    for (;;)
    {
      try
      {
        if (kitsFinder == null) {
          continue;
        }
        localObject = (Map)kitsFinder.get();
        localObject = mergeKits((Map)localObject, providedKits);
        bool1 = performAutoConfigure(str, appData, ((Map)localObject).values());
      }
      catch (Exception localException)
      {
        Object localObject;
        Fabric.getLogger().e("Fabric", "Error performing auto configuration.", localException);
        bool1 = bool2;
        continue;
      }
      return Boolean.valueOf(bool1);
      localObject = new HashMap();
    }
  }
  
  public String getIdentifier()
  {
    return "io.fabric.sdk.android:fabric";
  }
  
  String getOverridenSpiEndpoint()
  {
    return CommonUtils.getStringsFileValue(getContext(), "com.crashlytics.ApiEndpoint");
  }
  
  public String getVersion()
  {
    return "1.3.10.97";
  }
  
  Map<String, KitInfo> mergeKits(Map<String, KitInfo> paramMap, Collection<Kit> paramCollection)
  {
    paramCollection = paramCollection.iterator();
    while (paramCollection.hasNext())
    {
      Kit localKit = (Kit)paramCollection.next();
      if (!paramMap.containsKey(localKit.getIdentifier())) {
        paramMap.put(localKit.getIdentifier(), new KitInfo(localKit.getIdentifier(), localKit.getVersion(), "binary"));
      }
    }
    return paramMap;
  }
  
  protected boolean onPreExecute()
  {
    try
    {
      installerPackageName = getIdManager().getInstallerPackageName();
      packageManager = getContext().getPackageManager();
      packageName = getContext().getPackageName();
      packageInfo = packageManager.getPackageInfo(packageName, 0);
      versionCode = Integer.toString(packageInfo.versionCode);
      if (packageInfo.versionName == null) {}
      for (String str = "0.0";; str = packageInfo.versionName)
      {
        versionName = str;
        applicationLabel = packageManager.getApplicationLabel(getContext().getApplicationInfo()).toString();
        targetAndroidSdkVersion = Integer.toString(getContextgetApplicationInfotargetSdkVersion);
        return true;
      }
      return false;
    }
    catch (PackageManager.NameNotFoundException localNameNotFoundException)
    {
      Fabric.getLogger().e("Fabric", "Failed init", localNameNotFoundException);
    }
  }
}

/* Location:
 * Qualified Name:     io.fabric.sdk.android.Onboarding
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */