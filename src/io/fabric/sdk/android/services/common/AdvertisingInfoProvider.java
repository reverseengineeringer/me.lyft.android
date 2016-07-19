package io.fabric.sdk.android.services.common;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.text.TextUtils;
import io.fabric.sdk.android.Fabric;
import io.fabric.sdk.android.Logger;
import io.fabric.sdk.android.services.persistence.PreferenceStore;
import io.fabric.sdk.android.services.persistence.PreferenceStoreImpl;

class AdvertisingInfoProvider
{
  private final Context context;
  private final PreferenceStore preferenceStore;
  
  public AdvertisingInfoProvider(Context paramContext)
  {
    context = paramContext.getApplicationContext();
    preferenceStore = new PreferenceStoreImpl(paramContext, "TwitterAdvertisingInfoPreferences");
  }
  
  private AdvertisingInfo getAdvertisingInfoFromStrategies()
  {
    AdvertisingInfo localAdvertisingInfo = getReflectionStrategy().getAdvertisingInfo();
    if (!isInfoValid(localAdvertisingInfo))
    {
      localAdvertisingInfo = getServiceStrategy().getAdvertisingInfo();
      if (!isInfoValid(localAdvertisingInfo))
      {
        Fabric.getLogger().d("Fabric", "AdvertisingInfo not present");
        return localAdvertisingInfo;
      }
      Fabric.getLogger().d("Fabric", "Using AdvertisingInfo from Service Provider");
      return localAdvertisingInfo;
    }
    Fabric.getLogger().d("Fabric", "Using AdvertisingInfo from Reflection Provider");
    return localAdvertisingInfo;
  }
  
  private boolean isInfoValid(AdvertisingInfo paramAdvertisingInfo)
  {
    return (paramAdvertisingInfo != null) && (!TextUtils.isEmpty(advertisingId));
  }
  
  private void refreshInfoIfNeededAsync(final AdvertisingInfo paramAdvertisingInfo)
  {
    new Thread(new BackgroundPriorityRunnable()
    {
      public void onRun()
      {
        AdvertisingInfo localAdvertisingInfo = AdvertisingInfoProvider.this.getAdvertisingInfoFromStrategies();
        if (!paramAdvertisingInfo.equals(localAdvertisingInfo))
        {
          Fabric.getLogger().d("Fabric", "Asychronously getting Advertising Info and storing it to preferences");
          AdvertisingInfoProvider.this.storeInfoToPreferences(localAdvertisingInfo);
        }
      }
    }).start();
  }
  
  @SuppressLint({"CommitPrefEdits"})
  private void storeInfoToPreferences(AdvertisingInfo paramAdvertisingInfo)
  {
    if (isInfoValid(paramAdvertisingInfo))
    {
      preferenceStore.save(preferenceStore.edit().putString("advertising_id", advertisingId).putBoolean("limit_ad_tracking_enabled", limitAdTrackingEnabled));
      return;
    }
    preferenceStore.save(preferenceStore.edit().remove("advertising_id").remove("limit_ad_tracking_enabled"));
  }
  
  public AdvertisingInfo getAdvertisingInfo()
  {
    AdvertisingInfo localAdvertisingInfo = getInfoFromPreferences();
    if (isInfoValid(localAdvertisingInfo))
    {
      Fabric.getLogger().d("Fabric", "Using AdvertisingInfo from Preference Store");
      refreshInfoIfNeededAsync(localAdvertisingInfo);
      return localAdvertisingInfo;
    }
    localAdvertisingInfo = getAdvertisingInfoFromStrategies();
    storeInfoToPreferences(localAdvertisingInfo);
    return localAdvertisingInfo;
  }
  
  protected AdvertisingInfo getInfoFromPreferences()
  {
    return new AdvertisingInfo(preferenceStore.get().getString("advertising_id", ""), preferenceStore.get().getBoolean("limit_ad_tracking_enabled", false));
  }
  
  public AdvertisingInfoStrategy getReflectionStrategy()
  {
    return new AdvertisingInfoReflectionStrategy(context);
  }
  
  public AdvertisingInfoStrategy getServiceStrategy()
  {
    return new AdvertisingInfoServiceStrategy(context);
  }
}

/* Location:
 * Qualified Name:     io.fabric.sdk.android.services.common.AdvertisingInfoProvider
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */