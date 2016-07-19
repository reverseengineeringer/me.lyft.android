package io.fabric.sdk.android.services.settings;

import io.fabric.sdk.android.Fabric;
import io.fabric.sdk.android.Logger;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.atomic.AtomicReference;

public class Settings
{
  private boolean initialized = false;
  private SettingsController settingsController;
  private final AtomicReference<SettingsData> settingsData = new AtomicReference();
  private final CountDownLatch settingsDataLatch = new CountDownLatch(1);
  
  public static Settings getInstance()
  {
    return LazyHolder.INSTANCE;
  }
  
  private void setSettingsData(SettingsData paramSettingsData)
  {
    settingsData.set(paramSettingsData);
    settingsDataLatch.countDown();
  }
  
  public SettingsData awaitSettingsData()
  {
    try
    {
      settingsDataLatch.await();
      SettingsData localSettingsData = (SettingsData)settingsData.get();
      return localSettingsData;
    }
    catch (InterruptedException localInterruptedException)
    {
      Fabric.getLogger().e("Fabric", "Interrupted while waiting for settings data.");
    }
    return null;
  }
  
  /* Error */
  public Settings initialize(io.fabric.sdk.android.Kit paramKit, io.fabric.sdk.android.services.common.IdManager paramIdManager, io.fabric.sdk.android.services.network.HttpRequestFactory paramHttpRequestFactory, String paramString1, String paramString2, String paramString3)
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_0
    //   3: getfield 39	io/fabric/sdk/android/services/settings/Settings:initialized	Z
    //   6: istore 7
    //   8: iload 7
    //   10: ifeq +7 -> 17
    //   13: aload_0
    //   14: monitorexit
    //   15: aload_0
    //   16: areturn
    //   17: aload_0
    //   18: getfield 89	io/fabric/sdk/android/services/settings/Settings:settingsController	Lio/fabric/sdk/android/services/settings/SettingsController;
    //   21: ifnonnull +180 -> 201
    //   24: aload_1
    //   25: invokevirtual 95	io/fabric/sdk/android/Kit:getContext	()Landroid/content/Context;
    //   28: astore 8
    //   30: aload_2
    //   31: invokevirtual 101	io/fabric/sdk/android/services/common/IdManager:getAppIdentifier	()Ljava/lang/String;
    //   34: astore 15
    //   36: new 103	io/fabric/sdk/android/services/common/ApiKey
    //   39: dup
    //   40: invokespecial 104	io/fabric/sdk/android/services/common/ApiKey:<init>	()V
    //   43: aload 8
    //   45: invokevirtual 108	io/fabric/sdk/android/services/common/ApiKey:getValue	(Landroid/content/Context;)Ljava/lang/String;
    //   48: astore 9
    //   50: aload_2
    //   51: invokevirtual 111	io/fabric/sdk/android/services/common/IdManager:getInstallerPackageName	()Ljava/lang/String;
    //   54: astore 10
    //   56: new 113	io/fabric/sdk/android/services/common/SystemCurrentTimeProvider
    //   59: dup
    //   60: invokespecial 114	io/fabric/sdk/android/services/common/SystemCurrentTimeProvider:<init>	()V
    //   63: astore 11
    //   65: new 116	io/fabric/sdk/android/services/settings/DefaultSettingsJsonTransform
    //   68: dup
    //   69: invokespecial 117	io/fabric/sdk/android/services/settings/DefaultSettingsJsonTransform:<init>	()V
    //   72: astore 12
    //   74: new 119	io/fabric/sdk/android/services/settings/DefaultCachedSettingsIo
    //   77: dup
    //   78: aload_1
    //   79: invokespecial 122	io/fabric/sdk/android/services/settings/DefaultCachedSettingsIo:<init>	(Lio/fabric/sdk/android/Kit;)V
    //   82: astore 13
    //   84: aload 8
    //   86: invokestatic 127	io/fabric/sdk/android/services/common/CommonUtils:getAppIconHashOrNull	(Landroid/content/Context;)Ljava/lang/String;
    //   89: astore 14
    //   91: new 129	io/fabric/sdk/android/services/settings/DefaultSettingsSpiCall
    //   94: dup
    //   95: aload_1
    //   96: aload 6
    //   98: getstatic 135	java/util/Locale:US	Ljava/util/Locale;
    //   101: ldc -119
    //   103: iconst_1
    //   104: anewarray 4	java/lang/Object
    //   107: dup
    //   108: iconst_0
    //   109: aload 15
    //   111: aastore
    //   112: invokestatic 143	java/lang/String:format	(Ljava/util/Locale;Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/String;
    //   115: aload_3
    //   116: invokespecial 146	io/fabric/sdk/android/services/settings/DefaultSettingsSpiCall:<init>	(Lio/fabric/sdk/android/Kit;Ljava/lang/String;Ljava/lang/String;Lio/fabric/sdk/android/services/network/HttpRequestFactory;)V
    //   119: astore_3
    //   120: aload_0
    //   121: new 148	io/fabric/sdk/android/services/settings/DefaultSettingsController
    //   124: dup
    //   125: aload_1
    //   126: new 150	io/fabric/sdk/android/services/settings/SettingsRequest
    //   129: dup
    //   130: aload 9
    //   132: aload_2
    //   133: invokevirtual 153	io/fabric/sdk/android/services/common/IdManager:getModelName	()Ljava/lang/String;
    //   136: aload_2
    //   137: invokevirtual 156	io/fabric/sdk/android/services/common/IdManager:getOsBuildVersionString	()Ljava/lang/String;
    //   140: aload_2
    //   141: invokevirtual 159	io/fabric/sdk/android/services/common/IdManager:getOsDisplayVersionString	()Ljava/lang/String;
    //   144: aload_2
    //   145: invokevirtual 162	io/fabric/sdk/android/services/common/IdManager:getAdvertisingId	()Ljava/lang/String;
    //   148: aload_2
    //   149: invokevirtual 165	io/fabric/sdk/android/services/common/IdManager:getAppInstallIdentifier	()Ljava/lang/String;
    //   152: aload_2
    //   153: invokevirtual 168	io/fabric/sdk/android/services/common/IdManager:getAndroidId	()Ljava/lang/String;
    //   156: iconst_1
    //   157: anewarray 139	java/lang/String
    //   160: dup
    //   161: iconst_0
    //   162: aload 8
    //   164: invokestatic 171	io/fabric/sdk/android/services/common/CommonUtils:resolveBuildId	(Landroid/content/Context;)Ljava/lang/String;
    //   167: aastore
    //   168: invokestatic 175	io/fabric/sdk/android/services/common/CommonUtils:createInstanceIdFrom	([Ljava/lang/String;)Ljava/lang/String;
    //   171: aload 5
    //   173: aload 4
    //   175: aload 10
    //   177: invokestatic 181	io/fabric/sdk/android/services/common/DeliveryMechanism:determineFrom	(Ljava/lang/String;)Lio/fabric/sdk/android/services/common/DeliveryMechanism;
    //   180: invokevirtual 185	io/fabric/sdk/android/services/common/DeliveryMechanism:getId	()I
    //   183: aload 14
    //   185: invokespecial 188	io/fabric/sdk/android/services/settings/SettingsRequest:<init>	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;ILjava/lang/String;)V
    //   188: aload 11
    //   190: aload 12
    //   192: aload 13
    //   194: aload_3
    //   195: invokespecial 191	io/fabric/sdk/android/services/settings/DefaultSettingsController:<init>	(Lio/fabric/sdk/android/Kit;Lio/fabric/sdk/android/services/settings/SettingsRequest;Lio/fabric/sdk/android/services/common/CurrentTimeProvider;Lio/fabric/sdk/android/services/settings/SettingsJsonTransform;Lio/fabric/sdk/android/services/settings/CachedSettingsIo;Lio/fabric/sdk/android/services/settings/SettingsSpiCall;)V
    //   198: putfield 89	io/fabric/sdk/android/services/settings/Settings:settingsController	Lio/fabric/sdk/android/services/settings/SettingsController;
    //   201: aload_0
    //   202: iconst_1
    //   203: putfield 39	io/fabric/sdk/android/services/settings/Settings:initialized	Z
    //   206: goto -193 -> 13
    //   209: astore_1
    //   210: aload_0
    //   211: monitorexit
    //   212: aload_1
    //   213: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	214	0	this	Settings
    //   0	214	1	paramKit	io.fabric.sdk.android.Kit
    //   0	214	2	paramIdManager	io.fabric.sdk.android.services.common.IdManager
    //   0	214	3	paramHttpRequestFactory	io.fabric.sdk.android.services.network.HttpRequestFactory
    //   0	214	4	paramString1	String
    //   0	214	5	paramString2	String
    //   0	214	6	paramString3	String
    //   6	3	7	bool	boolean
    //   28	135	8	localContext	android.content.Context
    //   48	83	9	str1	String
    //   54	122	10	str2	String
    //   63	126	11	localSystemCurrentTimeProvider	io.fabric.sdk.android.services.common.SystemCurrentTimeProvider
    //   72	119	12	localDefaultSettingsJsonTransform	DefaultSettingsJsonTransform
    //   82	111	13	localDefaultCachedSettingsIo	DefaultCachedSettingsIo
    //   89	95	14	str3	String
    //   34	76	15	str4	String
    // Exception table:
    //   from	to	target	type
    //   2	8	209	finally
    //   17	201	209	finally
    //   201	206	209	finally
  }
  
  /* Error */
  public boolean loadSettingsData()
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_0
    //   3: getfield 89	io/fabric/sdk/android/services/settings/Settings:settingsController	Lio/fabric/sdk/android/services/settings/SettingsController;
    //   6: invokeinterface 197 1 0
    //   11: astore_2
    //   12: aload_0
    //   13: aload_2
    //   14: invokespecial 199	io/fabric/sdk/android/services/settings/Settings:setSettingsData	(Lio/fabric/sdk/android/services/settings/SettingsData;)V
    //   17: aload_2
    //   18: ifnull +9 -> 27
    //   21: iconst_1
    //   22: istore_1
    //   23: aload_0
    //   24: monitorexit
    //   25: iload_1
    //   26: ireturn
    //   27: iconst_0
    //   28: istore_1
    //   29: goto -6 -> 23
    //   32: astore_2
    //   33: aload_0
    //   34: monitorexit
    //   35: aload_2
    //   36: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	37	0	this	Settings
    //   22	7	1	bool	boolean
    //   11	7	2	localSettingsData	SettingsData
    //   32	4	2	localObject	Object
    // Exception table:
    //   from	to	target	type
    //   2	17	32	finally
  }
  
  /* Error */
  public boolean loadSettingsSkippingCache()
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_0
    //   3: getfield 89	io/fabric/sdk/android/services/settings/Settings:settingsController	Lio/fabric/sdk/android/services/settings/SettingsController;
    //   6: getstatic 206	io/fabric/sdk/android/services/settings/SettingsCacheBehavior:SKIP_CACHE_LOOKUP	Lio/fabric/sdk/android/services/settings/SettingsCacheBehavior;
    //   9: invokeinterface 209 2 0
    //   14: astore_2
    //   15: aload_0
    //   16: aload_2
    //   17: invokespecial 199	io/fabric/sdk/android/services/settings/Settings:setSettingsData	(Lio/fabric/sdk/android/services/settings/SettingsData;)V
    //   20: aload_2
    //   21: ifnonnull +16 -> 37
    //   24: invokestatic 75	io/fabric/sdk/android/Fabric:getLogger	()Lio/fabric/sdk/android/Logger;
    //   27: ldc 77
    //   29: ldc -45
    //   31: aconst_null
    //   32: invokeinterface 214 4 0
    //   37: aload_2
    //   38: ifnull +9 -> 47
    //   41: iconst_1
    //   42: istore_1
    //   43: aload_0
    //   44: monitorexit
    //   45: iload_1
    //   46: ireturn
    //   47: iconst_0
    //   48: istore_1
    //   49: goto -6 -> 43
    //   52: astore_2
    //   53: aload_0
    //   54: monitorexit
    //   55: aload_2
    //   56: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	57	0	this	Settings
    //   42	7	1	bool	boolean
    //   14	24	2	localSettingsData	SettingsData
    //   52	4	2	localObject	Object
    // Exception table:
    //   from	to	target	type
    //   2	20	52	finally
    //   24	37	52	finally
  }
  
  public <T> T withSettings(SettingsAccess<T> paramSettingsAccess, T paramT)
  {
    SettingsData localSettingsData = (SettingsData)settingsData.get();
    if (localSettingsData == null) {
      return paramT;
    }
    return (T)paramSettingsAccess.usingSettings(localSettingsData);
  }
  
  static class LazyHolder
  {
    private static final Settings INSTANCE = new Settings(null);
  }
  
  public static abstract interface SettingsAccess<T>
  {
    public abstract T usingSettings(SettingsData paramSettingsData);
  }
}

/* Location:
 * Qualified Name:     io.fabric.sdk.android.services.settings.Settings
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */