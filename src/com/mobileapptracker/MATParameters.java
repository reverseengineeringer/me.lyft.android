package com.mobileapptracker;

import android.content.Context;
import android.location.Location;
import android.provider.Settings.Secure;
import android.util.Log;
import android.webkit.WebSettings;
import android.webkit.WebView;
import java.lang.ref.WeakReference;
import java.lang.reflect.Method;
import org.json.JSONArray;

public class MATParameters
{
  private static MATParameters INSTANCE = null;
  private String mAction = null;
  private String mAdvertiserId = null;
  private String mAge = null;
  private String mAllowDups = null;
  private String mAltitude = null;
  private String mAndroidId = null;
  private String mAndroidIdMd5 = null;
  private String mAndroidIdSha1 = null;
  private String mAndroidIdSha256 = null;
  private String mAppAdTracking = null;
  private String mAppName = null;
  private String mAppVersion = null;
  private String mAppVersionName = null;
  private String mConnectionType = null;
  private Context mContext;
  private String mConversionKey = null;
  private String mCountryCode = null;
  private String mCurrencyCode = null;
  private boolean mDebugMode = false;
  private String mDeviceBrand = null;
  private String mDeviceCarrier = null;
  private String mDeviceCpuSubtype = null;
  private String mDeviceCpuType = null;
  private String mDeviceId = null;
  private String mDeviceModel = null;
  private String mExistingUser = null;
  private String mFbUserId = null;
  private String mGaid = null;
  private String mGaidLimited = null;
  private String mGender = null;
  private String mGgUserId = null;
  private String mInstallDate = null;
  private String mInstallerPackage = null;
  private String mLanguage = null;
  private String mLatitude = null;
  private Location mLocation = null;
  private String mLongitude = null;
  private String mMCC = null;
  private String mMNC = null;
  private String mMacAddress = null;
  private String mOsVersion = null;
  private String mPackageName = null;
  private String mPhoneNumberMd5;
  private String mPhoneNumberSha1;
  private String mPhoneNumberSha256;
  private String mPluginName = null;
  private String mPurchaseStatus = null;
  private String mRefId = null;
  private String mReferralSource = null;
  private String mReferralUrl = null;
  private String mReferrerDelay = null;
  private String mRevenue = null;
  private String mScreenDensity = null;
  private String mScreenHeight = null;
  private String mScreenWidth = null;
  private String mSiteId = null;
  private String mTimeZone = null;
  private String mTrackingId = null;
  private String mTrusteId = null;
  private MobileAppTracker mTune;
  private String mTwUserId = null;
  private String mUserAgent = null;
  private String mUserEmailMd5;
  private String mUserEmailSha1;
  private String mUserEmailSha256;
  private JSONArray mUserEmails = null;
  private String mUserNameMd5;
  private String mUserNameSha1;
  private String mUserNameSha256;
  
  public static MATParameters getInstance()
  {
    return INSTANCE;
  }
  
  public static MATParameters init(MobileAppTracker paramMobileAppTracker, Context paramContext, String paramString1, String paramString2)
  {
    if (INSTANCE == null)
    {
      INSTANCE = new MATParameters();
      INSTANCEmTune = paramMobileAppTracker;
      INSTANCEmContext = paramContext;
      INSTANCE.populateParams(paramContext, paramString1, paramString2);
    }
    return INSTANCE;
  }
  
  /* Error */
  @android.annotation.SuppressLint({"NewApi"})
  private boolean populateParams(Context paramContext, String paramString1, String paramString2)
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_0
    //   3: aload_2
    //   4: invokevirtual 247	java/lang/String:trim	()Ljava/lang/String;
    //   7: invokevirtual 250	com/mobileapptracker/MATParameters:setAdvertiserId	(Ljava/lang/String;)V
    //   10: aload_0
    //   11: aload_3
    //   12: invokevirtual 247	java/lang/String:trim	()Ljava/lang/String;
    //   15: invokevirtual 253	com/mobileapptracker/MATParameters:setConversionKey	(Ljava/lang/String;)V
    //   18: aload_0
    //   19: ldc -1
    //   21: invokevirtual 258	com/mobileapptracker/MATParameters:setCurrencyCode	(Ljava/lang/String;)V
    //   24: new 260	java/lang/Thread
    //   27: dup
    //   28: new 6	com/mobileapptracker/MATParameters$GetGAID
    //   31: dup
    //   32: aload_0
    //   33: aload_1
    //   34: invokespecial 263	com/mobileapptracker/MATParameters$GetGAID:<init>	(Lcom/mobileapptracker/MATParameters;Landroid/content/Context;)V
    //   37: invokespecial 266	java/lang/Thread:<init>	(Ljava/lang/Runnable;)V
    //   40: invokevirtual 269	java/lang/Thread:start	()V
    //   43: new 271	android/os/Handler
    //   46: dup
    //   47: invokestatic 277	android/os/Looper:getMainLooper	()Landroid/os/Looper;
    //   50: invokespecial 280	android/os/Handler:<init>	(Landroid/os/Looper;)V
    //   53: new 9	com/mobileapptracker/MATParameters$GetUserAgent
    //   56: dup
    //   57: aload_0
    //   58: aload_0
    //   59: getfield 228	com/mobileapptracker/MATParameters:mContext	Landroid/content/Context;
    //   62: invokespecial 281	com/mobileapptracker/MATParameters$GetUserAgent:<init>	(Lcom/mobileapptracker/MATParameters;Landroid/content/Context;)V
    //   65: invokevirtual 285	android/os/Handler:post	(Ljava/lang/Runnable;)Z
    //   68: pop
    //   69: aload_0
    //   70: getfield 228	com/mobileapptracker/MATParameters:mContext	Landroid/content/Context;
    //   73: invokevirtual 290	android/content/Context:getPackageName	()Ljava/lang/String;
    //   76: astore_2
    //   77: aload_0
    //   78: aload_2
    //   79: invokevirtual 293	com/mobileapptracker/MATParameters:setPackageName	(Ljava/lang/String;)V
    //   82: aload_0
    //   83: getfield 228	com/mobileapptracker/MATParameters:mContext	Landroid/content/Context;
    //   86: invokevirtual 297	android/content/Context:getPackageManager	()Landroid/content/pm/PackageManager;
    //   89: astore_3
    //   90: aload_0
    //   91: aload_3
    //   92: aload_3
    //   93: aload_2
    //   94: iconst_0
    //   95: invokevirtual 303	android/content/pm/PackageManager:getApplicationInfo	(Ljava/lang/String;I)Landroid/content/pm/ApplicationInfo;
    //   98: invokevirtual 307	android/content/pm/PackageManager:getApplicationLabel	(Landroid/content/pm/ApplicationInfo;)Ljava/lang/CharSequence;
    //   101: invokeinterface 312 1 0
    //   106: invokevirtual 315	com/mobileapptracker/MATParameters:setAppName	(Ljava/lang/String;)V
    //   109: aload_0
    //   110: new 317	java/util/Date
    //   113: dup
    //   114: new 319	java/io/File
    //   117: dup
    //   118: aload_3
    //   119: aload_2
    //   120: iconst_0
    //   121: invokevirtual 303	android/content/pm/PackageManager:getApplicationInfo	(Ljava/lang/String;I)Landroid/content/pm/ApplicationInfo;
    //   124: getfield 324	android/content/pm/ApplicationInfo:sourceDir	Ljava/lang/String;
    //   127: invokespecial 326	java/io/File:<init>	(Ljava/lang/String;)V
    //   130: invokevirtual 330	java/io/File:lastModified	()J
    //   133: invokespecial 333	java/util/Date:<init>	(J)V
    //   136: invokevirtual 336	java/util/Date:getTime	()J
    //   139: ldc2_w 337
    //   142: ldiv
    //   143: invokestatic 343	java/lang/Long:toString	(J)Ljava/lang/String;
    //   146: invokevirtual 346	com/mobileapptracker/MATParameters:setInstallDate	(Ljava/lang/String;)V
    //   149: aload_3
    //   150: aload_2
    //   151: iconst_0
    //   152: invokevirtual 350	android/content/pm/PackageManager:getPackageInfo	(Ljava/lang/String;I)Landroid/content/pm/PackageInfo;
    //   155: astore 7
    //   157: aload_0
    //   158: aload 7
    //   160: getfield 356	android/content/pm/PackageInfo:versionCode	I
    //   163: invokestatic 361	java/lang/Integer:toString	(I)Ljava/lang/String;
    //   166: invokevirtual 364	com/mobileapptracker/MATParameters:setAppVersion	(Ljava/lang/String;)V
    //   169: aload_0
    //   170: aload 7
    //   172: getfield 367	android/content/pm/PackageInfo:versionName	Ljava/lang/String;
    //   175: invokevirtual 370	com/mobileapptracker/MATParameters:setAppVersionName	(Ljava/lang/String;)V
    //   178: aload_0
    //   179: aload_3
    //   180: aload_2
    //   181: invokevirtual 374	android/content/pm/PackageManager:getInstallerPackageName	(Ljava/lang/String;)Ljava/lang/String;
    //   184: invokevirtual 377	com/mobileapptracker/MATParameters:setInstaller	(Ljava/lang/String;)V
    //   187: aload_0
    //   188: getstatic 382	android/os/Build:MODEL	Ljava/lang/String;
    //   191: invokevirtual 385	com/mobileapptracker/MATParameters:setDeviceModel	(Ljava/lang/String;)V
    //   194: aload_0
    //   195: getstatic 388	android/os/Build:MANUFACTURER	Ljava/lang/String;
    //   198: invokevirtual 391	com/mobileapptracker/MATParameters:setDeviceBrand	(Ljava/lang/String;)V
    //   201: aload_0
    //   202: ldc_w 393
    //   205: invokestatic 398	java/lang/System:getProperty	(Ljava/lang/String;)Ljava/lang/String;
    //   208: invokevirtual 401	com/mobileapptracker/MATParameters:setDeviceCpuType	(Ljava/lang/String;)V
    //   211: aload_0
    //   212: getstatic 406	android/os/Build$VERSION:RELEASE	Ljava/lang/String;
    //   215: invokevirtual 409	com/mobileapptracker/MATParameters:setOsVersion	(Ljava/lang/String;)V
    //   218: aload_0
    //   219: aload_1
    //   220: invokevirtual 413	android/content/Context:getResources	()Landroid/content/res/Resources;
    //   223: invokevirtual 419	android/content/res/Resources:getDisplayMetrics	()Landroid/util/DisplayMetrics;
    //   226: getfield 425	android/util/DisplayMetrics:density	F
    //   229: invokestatic 430	java/lang/Float:toString	(F)Ljava/lang/String;
    //   232: invokevirtual 433	com/mobileapptracker/MATParameters:setScreenDensity	(Ljava/lang/String;)V
    //   235: aload_1
    //   236: ldc_w 435
    //   239: invokevirtual 439	android/content/Context:getSystemService	(Ljava/lang/String;)Ljava/lang/Object;
    //   242: checkcast 441	android/view/WindowManager
    //   245: astore_2
    //   246: getstatic 444	android/os/Build$VERSION:SDK_INT	I
    //   249: bipush 13
    //   251: if_icmplt +253 -> 504
    //   254: new 446	android/graphics/Point
    //   257: dup
    //   258: invokespecial 447	android/graphics/Point:<init>	()V
    //   261: astore_3
    //   262: aload_2
    //   263: invokeinterface 451 1 0
    //   268: aload_3
    //   269: invokevirtual 457	android/view/Display:getSize	(Landroid/graphics/Point;)V
    //   272: aload_3
    //   273: getfield 460	android/graphics/Point:x	I
    //   276: istore 5
    //   278: aload_3
    //   279: getfield 463	android/graphics/Point:y	I
    //   282: istore 4
    //   284: aload_0
    //   285: iload 5
    //   287: invokestatic 361	java/lang/Integer:toString	(I)Ljava/lang/String;
    //   290: invokevirtual 466	com/mobileapptracker/MATParameters:setScreenWidth	(Ljava/lang/String;)V
    //   293: aload_0
    //   294: iload 4
    //   296: invokestatic 361	java/lang/Integer:toString	(I)Ljava/lang/String;
    //   299: invokevirtual 469	com/mobileapptracker/MATParameters:setScreenHeight	(Ljava/lang/String;)V
    //   302: aload_0
    //   303: getfield 228	com/mobileapptracker/MATParameters:mContext	Landroid/content/Context;
    //   306: ldc_w 471
    //   309: invokevirtual 439	android/content/Context:getSystemService	(Ljava/lang/String;)Ljava/lang/Object;
    //   312: checkcast 473	android/net/ConnectivityManager
    //   315: iconst_1
    //   316: invokevirtual 477	android/net/ConnectivityManager:getNetworkInfo	(I)Landroid/net/NetworkInfo;
    //   319: invokevirtual 483	android/net/NetworkInfo:isConnected	()Z
    //   322: ifeq +207 -> 529
    //   325: aload_0
    //   326: ldc_w 485
    //   329: invokevirtual 488	com/mobileapptracker/MATParameters:setConnectionType	(Ljava/lang/String;)V
    //   332: aload_0
    //   333: invokestatic 494	java/util/Locale:getDefault	()Ljava/util/Locale;
    //   336: invokevirtual 497	java/util/Locale:getLanguage	()Ljava/lang/String;
    //   339: invokevirtual 500	com/mobileapptracker/MATParameters:setLanguage	(Ljava/lang/String;)V
    //   342: aload_0
    //   343: invokestatic 494	java/util/Locale:getDefault	()Ljava/util/Locale;
    //   346: invokevirtual 503	java/util/Locale:getCountry	()Ljava/lang/String;
    //   349: invokevirtual 506	com/mobileapptracker/MATParameters:setCountryCode	(Ljava/lang/String;)V
    //   352: aload_0
    //   353: invokestatic 511	java/util/TimeZone:getDefault	()Ljava/util/TimeZone;
    //   356: iconst_0
    //   357: iconst_0
    //   358: getstatic 515	java/util/Locale:US	Ljava/util/Locale;
    //   361: invokevirtual 519	java/util/TimeZone:getDisplayName	(ZILjava/util/Locale;)Ljava/lang/String;
    //   364: invokevirtual 522	com/mobileapptracker/MATParameters:setTimeZone	(Ljava/lang/String;)V
    //   367: aload_1
    //   368: ldc_w 524
    //   371: invokevirtual 439	android/content/Context:getSystemService	(Ljava/lang/String;)Ljava/lang/Object;
    //   374: checkcast 526	android/telephony/TelephonyManager
    //   377: astore_1
    //   378: aload_1
    //   379: ifnull +165 -> 544
    //   382: aload_1
    //   383: invokevirtual 529	android/telephony/TelephonyManager:getNetworkCountryIso	()Ljava/lang/String;
    //   386: ifnull +11 -> 397
    //   389: aload_0
    //   390: aload_1
    //   391: invokevirtual 529	android/telephony/TelephonyManager:getNetworkCountryIso	()Ljava/lang/String;
    //   394: invokevirtual 506	com/mobileapptracker/MATParameters:setCountryCode	(Ljava/lang/String;)V
    //   397: aload_0
    //   398: aload_1
    //   399: invokevirtual 532	android/telephony/TelephonyManager:getNetworkOperatorName	()Ljava/lang/String;
    //   402: invokevirtual 535	com/mobileapptracker/MATParameters:setDeviceCarrier	(Ljava/lang/String;)V
    //   405: aload_1
    //   406: invokevirtual 538	android/telephony/TelephonyManager:getNetworkOperator	()Ljava/lang/String;
    //   409: astore_2
    //   410: aload_2
    //   411: ifnull +26 -> 437
    //   414: aload_2
    //   415: iconst_0
    //   416: iconst_3
    //   417: invokevirtual 542	java/lang/String:substring	(II)Ljava/lang/String;
    //   420: astore_1
    //   421: aload_2
    //   422: iconst_3
    //   423: invokevirtual 544	java/lang/String:substring	(I)Ljava/lang/String;
    //   426: astore_2
    //   427: aload_0
    //   428: aload_1
    //   429: invokevirtual 547	com/mobileapptracker/MATParameters:setMCC	(Ljava/lang/String;)V
    //   432: aload_0
    //   433: aload_2
    //   434: invokevirtual 550	com/mobileapptracker/MATParameters:setMNC	(Ljava/lang/String;)V
    //   437: aload_0
    //   438: invokevirtual 553	com/mobileapptracker/MATParameters:getMatId	()Ljava/lang/String;
    //   441: astore_1
    //   442: aload_1
    //   443: ifnull +10 -> 453
    //   446: aload_1
    //   447: invokevirtual 557	java/lang/String:length	()I
    //   450: ifne +13 -> 463
    //   453: aload_0
    //   454: invokestatic 563	java/util/UUID:randomUUID	()Ljava/util/UUID;
    //   457: invokevirtual 564	java/util/UUID:toString	()Ljava/lang/String;
    //   460: invokevirtual 567	com/mobileapptracker/MATParameters:setMatId	(Ljava/lang/String;)V
    //   463: iconst_1
    //   464: istore 6
    //   466: aload_0
    //   467: monitorexit
    //   468: iload 6
    //   470: ireturn
    //   471: astore 7
    //   473: aload_0
    //   474: ldc_w 569
    //   477: invokevirtual 364	com/mobileapptracker/MATParameters:setAppVersion	(Ljava/lang/String;)V
    //   480: goto -302 -> 178
    //   483: astore_1
    //   484: ldc_w 571
    //   487: ldc_w 573
    //   490: invokestatic 579	android/util/Log:d	(Ljava/lang/String;Ljava/lang/String;)I
    //   493: pop
    //   494: aload_1
    //   495: invokevirtual 582	java/lang/Exception:printStackTrace	()V
    //   498: iconst_0
    //   499: istore 6
    //   501: goto -35 -> 466
    //   504: aload_2
    //   505: invokeinterface 451 1 0
    //   510: invokevirtual 585	android/view/Display:getWidth	()I
    //   513: istore 5
    //   515: aload_2
    //   516: invokeinterface 451 1 0
    //   521: invokevirtual 588	android/view/Display:getHeight	()I
    //   524: istore 4
    //   526: goto -242 -> 284
    //   529: aload_0
    //   530: ldc_w 590
    //   533: invokevirtual 488	com/mobileapptracker/MATParameters:setConnectionType	(Ljava/lang/String;)V
    //   536: goto -204 -> 332
    //   539: astore_1
    //   540: aload_0
    //   541: monitorexit
    //   542: aload_1
    //   543: athrow
    //   544: aload_0
    //   545: invokestatic 494	java/util/Locale:getDefault	()Ljava/util/Locale;
    //   548: invokevirtual 503	java/util/Locale:getCountry	()Ljava/lang/String;
    //   551: invokevirtual 506	com/mobileapptracker/MATParameters:setCountryCode	(Ljava/lang/String;)V
    //   554: goto -117 -> 437
    //   557: astore_1
    //   558: goto -121 -> 437
    //   561: astore 7
    //   563: goto -414 -> 149
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	566	0	this	MATParameters
    //   0	566	1	paramContext	Context
    //   0	566	2	paramString1	String
    //   0	566	3	paramString2	String
    //   282	243	4	i	int
    //   276	238	5	j	int
    //   464	36	6	bool	boolean
    //   155	16	7	localPackageInfo	android.content.pm.PackageInfo
    //   471	1	7	localNameNotFoundException1	android.content.pm.PackageManager.NameNotFoundException
    //   561	1	7	localNameNotFoundException2	android.content.pm.PackageManager.NameNotFoundException
    // Exception table:
    //   from	to	target	type
    //   149	178	471	android/content/pm/PackageManager$NameNotFoundException
    //   2	90	483	java/lang/Exception
    //   90	149	483	java/lang/Exception
    //   149	178	483	java/lang/Exception
    //   178	284	483	java/lang/Exception
    //   284	332	483	java/lang/Exception
    //   332	378	483	java/lang/Exception
    //   382	397	483	java/lang/Exception
    //   397	410	483	java/lang/Exception
    //   414	437	483	java/lang/Exception
    //   437	442	483	java/lang/Exception
    //   446	453	483	java/lang/Exception
    //   453	463	483	java/lang/Exception
    //   473	480	483	java/lang/Exception
    //   504	526	483	java/lang/Exception
    //   529	536	483	java/lang/Exception
    //   544	554	483	java/lang/Exception
    //   2	90	539	finally
    //   90	149	539	finally
    //   149	178	539	finally
    //   178	284	539	finally
    //   284	332	539	finally
    //   332	378	539	finally
    //   382	397	539	finally
    //   397	410	539	finally
    //   414	437	539	finally
    //   437	442	539	finally
    //   446	453	539	finally
    //   453	463	539	finally
    //   473	480	539	finally
    //   484	498	539	finally
    //   504	526	539	finally
    //   529	536	539	finally
    //   544	554	539	finally
    //   414	437	557	java/lang/IndexOutOfBoundsException
    //   90	149	561	android/content/pm/PackageManager$NameNotFoundException
  }
  
  private void setUserAgent(String paramString)
  {
    mUserAgent = paramString;
  }
  
  public String getAction()
  {
    try
    {
      String str = mAction;
      return str;
    }
    finally
    {
      localObject = finally;
      throw ((Throwable)localObject);
    }
  }
  
  public String getAdvertiserId()
  {
    try
    {
      String str = mAdvertiserId;
      return str;
    }
    finally
    {
      localObject = finally;
      throw ((Throwable)localObject);
    }
  }
  
  public String getAge()
  {
    try
    {
      String str = mAge;
      return str;
    }
    finally
    {
      localObject = finally;
      throw ((Throwable)localObject);
    }
  }
  
  public String getAllowDuplicates()
  {
    try
    {
      String str = mAllowDups;
      return str;
    }
    finally
    {
      localObject = finally;
      throw ((Throwable)localObject);
    }
  }
  
  public String getAltitude()
  {
    try
    {
      String str = mAltitude;
      return str;
    }
    finally
    {
      localObject = finally;
      throw ((Throwable)localObject);
    }
  }
  
  public String getAndroidId()
  {
    try
    {
      String str = mAndroidId;
      return str;
    }
    finally
    {
      localObject = finally;
      throw ((Throwable)localObject);
    }
  }
  
  public String getAndroidIdMd5()
  {
    try
    {
      String str = mAndroidIdMd5;
      return str;
    }
    finally
    {
      localObject = finally;
      throw ((Throwable)localObject);
    }
  }
  
  public String getAndroidIdSha1()
  {
    try
    {
      String str = mAndroidIdSha1;
      return str;
    }
    finally
    {
      localObject = finally;
      throw ((Throwable)localObject);
    }
  }
  
  public String getAndroidIdSha256()
  {
    try
    {
      String str = mAndroidIdSha256;
      return str;
    }
    finally
    {
      localObject = finally;
      throw ((Throwable)localObject);
    }
  }
  
  public String getAppAdTrackingEnabled()
  {
    try
    {
      String str = mAppAdTracking;
      return str;
    }
    finally
    {
      localObject = finally;
      throw ((Throwable)localObject);
    }
  }
  
  public String getAppName()
  {
    try
    {
      String str = mAppName;
      return str;
    }
    finally
    {
      localObject = finally;
      throw ((Throwable)localObject);
    }
  }
  
  public String getAppVersion()
  {
    try
    {
      String str = mAppVersion;
      return str;
    }
    finally
    {
      localObject = finally;
      throw ((Throwable)localObject);
    }
  }
  
  public String getAppVersionName()
  {
    try
    {
      String str = mAppVersionName;
      return str;
    }
    finally
    {
      localObject = finally;
      throw ((Throwable)localObject);
    }
  }
  
  public String getConnectionType()
  {
    try
    {
      String str = mConnectionType;
      return str;
    }
    finally
    {
      localObject = finally;
      throw ((Throwable)localObject);
    }
  }
  
  public String getConversionKey()
  {
    try
    {
      String str = mConversionKey;
      return str;
    }
    finally
    {
      localObject = finally;
      throw ((Throwable)localObject);
    }
  }
  
  public String getCountryCode()
  {
    try
    {
      String str = mCountryCode;
      return str;
    }
    finally
    {
      localObject = finally;
      throw ((Throwable)localObject);
    }
  }
  
  public String getCurrencyCode()
  {
    try
    {
      String str = mCurrencyCode;
      return str;
    }
    finally
    {
      localObject = finally;
      throw ((Throwable)localObject);
    }
  }
  
  public boolean getDebugMode()
  {
    try
    {
      boolean bool = mDebugMode;
      return bool;
    }
    finally
    {
      localObject = finally;
      throw ((Throwable)localObject);
    }
  }
  
  public String getDeviceBrand()
  {
    try
    {
      String str = mDeviceBrand;
      return str;
    }
    finally
    {
      localObject = finally;
      throw ((Throwable)localObject);
    }
  }
  
  public String getDeviceCarrier()
  {
    try
    {
      String str = mDeviceCarrier;
      return str;
    }
    finally
    {
      localObject = finally;
      throw ((Throwable)localObject);
    }
  }
  
  public String getDeviceCpuSubtype()
  {
    try
    {
      String str = mDeviceCpuSubtype;
      return str;
    }
    finally
    {
      localObject = finally;
      throw ((Throwable)localObject);
    }
  }
  
  public String getDeviceCpuType()
  {
    try
    {
      String str = mDeviceCpuType;
      return str;
    }
    finally
    {
      localObject = finally;
      throw ((Throwable)localObject);
    }
  }
  
  public String getDeviceId()
  {
    try
    {
      String str = mDeviceId;
      return str;
    }
    finally
    {
      localObject = finally;
      throw ((Throwable)localObject);
    }
  }
  
  public String getDeviceModel()
  {
    try
    {
      String str = mDeviceModel;
      return str;
    }
    finally
    {
      localObject = finally;
      throw ((Throwable)localObject);
    }
  }
  
  public String getExistingUser()
  {
    try
    {
      String str = mExistingUser;
      return str;
    }
    finally
    {
      localObject = finally;
      throw ((Throwable)localObject);
    }
  }
  
  public String getFacebookUserId()
  {
    try
    {
      String str = mFbUserId;
      return str;
    }
    finally
    {
      localObject = finally;
      throw ((Throwable)localObject);
    }
  }
  
  public String getGender()
  {
    try
    {
      String str = mGender;
      return str;
    }
    finally
    {
      localObject = finally;
      throw ((Throwable)localObject);
    }
  }
  
  public String getGoogleAdTrackingLimited()
  {
    try
    {
      String str = mGaidLimited;
      return str;
    }
    finally
    {
      localObject = finally;
      throw ((Throwable)localObject);
    }
  }
  
  public String getGoogleAdvertisingId()
  {
    try
    {
      String str = mGaid;
      return str;
    }
    finally
    {
      localObject = finally;
      throw ((Throwable)localObject);
    }
  }
  
  public String getGoogleUserId()
  {
    try
    {
      String str = mGgUserId;
      return str;
    }
    finally
    {
      localObject = finally;
      throw ((Throwable)localObject);
    }
  }
  
  public String getInstallDate()
  {
    try
    {
      String str = mInstallDate;
      return str;
    }
    finally
    {
      localObject = finally;
      throw ((Throwable)localObject);
    }
  }
  
  public String getInstallReferrer()
  {
    try
    {
      String str = MATUtils.getStringFromSharedPreferences(mContext, "mat_referrer");
      return str;
    }
    finally
    {
      localObject = finally;
      throw ((Throwable)localObject);
    }
  }
  
  public String getInstaller()
  {
    try
    {
      String str = mInstallerPackage;
      return str;
    }
    finally
    {
      localObject = finally;
      throw ((Throwable)localObject);
    }
  }
  
  public String getIsPayingUser()
  {
    try
    {
      String str = MATUtils.getStringFromSharedPreferences(mContext, "mat_is_paying_user");
      return str;
    }
    finally
    {
      localObject = finally;
      throw ((Throwable)localObject);
    }
  }
  
  public String getLanguage()
  {
    try
    {
      String str = mLanguage;
      return str;
    }
    finally
    {
      localObject = finally;
      throw ((Throwable)localObject);
    }
  }
  
  public String getLastOpenLogId()
  {
    try
    {
      String str = MATUtils.getStringFromSharedPreferences(mContext, "mat_log_id_last_open");
      return str;
    }
    finally
    {
      localObject = finally;
      throw ((Throwable)localObject);
    }
  }
  
  public String getLatitude()
  {
    try
    {
      String str = mLatitude;
      return str;
    }
    finally
    {
      localObject = finally;
      throw ((Throwable)localObject);
    }
  }
  
  public String getLongitude()
  {
    try
    {
      String str = mLongitude;
      return str;
    }
    finally
    {
      localObject = finally;
      throw ((Throwable)localObject);
    }
  }
  
  public String getMCC()
  {
    try
    {
      String str = mMCC;
      return str;
    }
    finally
    {
      localObject = finally;
      throw ((Throwable)localObject);
    }
  }
  
  public String getMNC()
  {
    try
    {
      String str = mMNC;
      return str;
    }
    finally
    {
      localObject = finally;
      throw ((Throwable)localObject);
    }
  }
  
  public String getMacAddress()
  {
    try
    {
      String str = mMacAddress;
      return str;
    }
    finally
    {
      localObject = finally;
      throw ((Throwable)localObject);
    }
  }
  
  /* Error */
  public String getMatId()
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_0
    //   3: getfield 228	com/mobileapptracker/MATParameters:mContext	Landroid/content/Context;
    //   6: ldc_w 645
    //   9: iconst_0
    //   10: invokevirtual 649	android/content/Context:getSharedPreferences	(Ljava/lang/String;I)Landroid/content/SharedPreferences;
    //   13: ldc_w 645
    //   16: invokeinterface 655 2 0
    //   21: ifeq +30 -> 51
    //   24: aload_0
    //   25: getfield 228	com/mobileapptracker/MATParameters:mContext	Landroid/content/Context;
    //   28: ldc_w 645
    //   31: iconst_0
    //   32: invokevirtual 649	android/content/Context:getSharedPreferences	(Ljava/lang/String;I)Landroid/content/SharedPreferences;
    //   35: ldc_w 645
    //   38: ldc_w 657
    //   41: invokeinterface 661 3 0
    //   46: astore_1
    //   47: aload_0
    //   48: monitorexit
    //   49: aload_1
    //   50: areturn
    //   51: aload_0
    //   52: getfield 228	com/mobileapptracker/MATParameters:mContext	Landroid/content/Context;
    //   55: ldc_w 645
    //   58: invokestatic 631	com/mobileapptracker/MATUtils:getStringFromSharedPreferences	(Landroid/content/Context;Ljava/lang/String;)Ljava/lang/String;
    //   61: astore_1
    //   62: goto -15 -> 47
    //   65: astore_1
    //   66: aload_0
    //   67: monitorexit
    //   68: aload_1
    //   69: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	70	0	this	MATParameters
    //   46	16	1	str	String
    //   65	4	1	localObject	Object
    // Exception table:
    //   from	to	target	type
    //   2	47	65	finally
    //   51	62	65	finally
  }
  
  public String getOpenLogId()
  {
    try
    {
      String str = MATUtils.getStringFromSharedPreferences(mContext, "mat_log_id_open");
      return str;
    }
    finally
    {
      localObject = finally;
      throw ((Throwable)localObject);
    }
  }
  
  public String getOsVersion()
  {
    try
    {
      String str = mOsVersion;
      return str;
    }
    finally
    {
      localObject = finally;
      throw ((Throwable)localObject);
    }
  }
  
  public String getPackageName()
  {
    try
    {
      String str = mPackageName;
      return str;
    }
    finally
    {
      localObject = finally;
      throw ((Throwable)localObject);
    }
  }
  
  public String getPhoneNumberMd5()
  {
    try
    {
      String str = mPhoneNumberMd5;
      return str;
    }
    finally
    {
      localObject = finally;
      throw ((Throwable)localObject);
    }
  }
  
  public String getPhoneNumberSha1()
  {
    try
    {
      String str = mPhoneNumberSha1;
      return str;
    }
    finally
    {
      localObject = finally;
      throw ((Throwable)localObject);
    }
  }
  
  public String getPhoneNumberSha256()
  {
    try
    {
      String str = mPhoneNumberSha256;
      return str;
    }
    finally
    {
      localObject = finally;
      throw ((Throwable)localObject);
    }
  }
  
  public String getPluginName()
  {
    try
    {
      String str = mPluginName;
      return str;
    }
    finally
    {
      localObject = finally;
      throw ((Throwable)localObject);
    }
  }
  
  public String getPurchaseStatus()
  {
    try
    {
      String str = mPurchaseStatus;
      return str;
    }
    finally
    {
      localObject = finally;
      throw ((Throwable)localObject);
    }
  }
  
  public String getReferralSource()
  {
    try
    {
      String str = mReferralSource;
      return str;
    }
    finally
    {
      localObject = finally;
      throw ((Throwable)localObject);
    }
  }
  
  public String getReferralUrl()
  {
    try
    {
      String str = mReferralUrl;
      return str;
    }
    finally
    {
      localObject = finally;
      throw ((Throwable)localObject);
    }
  }
  
  public String getReferrerDelay()
  {
    try
    {
      String str = mReferrerDelay;
      return str;
    }
    finally
    {
      localObject = finally;
      throw ((Throwable)localObject);
    }
  }
  
  public String getScreenDensity()
  {
    try
    {
      String str = mScreenDensity;
      return str;
    }
    finally
    {
      localObject = finally;
      throw ((Throwable)localObject);
    }
  }
  
  public String getScreenHeight()
  {
    try
    {
      String str = mScreenHeight;
      return str;
    }
    finally
    {
      localObject = finally;
      throw ((Throwable)localObject);
    }
  }
  
  public String getScreenWidth()
  {
    try
    {
      String str = mScreenWidth;
      return str;
    }
    finally
    {
      localObject = finally;
      throw ((Throwable)localObject);
    }
  }
  
  public String getSdkVersion()
  {
    return "3.10.1";
  }
  
  public String getSiteId()
  {
    try
    {
      String str = mSiteId;
      return str;
    }
    finally
    {
      localObject = finally;
      throw ((Throwable)localObject);
    }
  }
  
  public String getTRUSTeId()
  {
    try
    {
      String str = mTrusteId;
      return str;
    }
    finally
    {
      localObject = finally;
      throw ((Throwable)localObject);
    }
  }
  
  public String getTimeZone()
  {
    try
    {
      String str = mTimeZone;
      return str;
    }
    finally
    {
      localObject = finally;
      throw ((Throwable)localObject);
    }
  }
  
  public String getTrackingId()
  {
    try
    {
      String str = mTrackingId;
      return str;
    }
    finally
    {
      localObject = finally;
      throw ((Throwable)localObject);
    }
  }
  
  public String getTwitterUserId()
  {
    try
    {
      String str = mTwUserId;
      return str;
    }
    finally
    {
      localObject = finally;
      throw ((Throwable)localObject);
    }
  }
  
  public String getUserAgent()
  {
    try
    {
      String str = mUserAgent;
      return str;
    }
    finally
    {
      localObject = finally;
      throw ((Throwable)localObject);
    }
  }
  
  public String getUserEmailMd5()
  {
    try
    {
      String str = mUserEmailMd5;
      return str;
    }
    finally
    {
      localObject = finally;
      throw ((Throwable)localObject);
    }
  }
  
  public String getUserEmailSha1()
  {
    try
    {
      String str = mUserEmailSha1;
      return str;
    }
    finally
    {
      localObject = finally;
      throw ((Throwable)localObject);
    }
  }
  
  public String getUserEmailSha256()
  {
    try
    {
      String str = mUserEmailSha256;
      return str;
    }
    finally
    {
      localObject = finally;
      throw ((Throwable)localObject);
    }
  }
  
  public JSONArray getUserEmails()
  {
    try
    {
      JSONArray localJSONArray = mUserEmails;
      return localJSONArray;
    }
    finally
    {
      localObject = finally;
      throw ((Throwable)localObject);
    }
  }
  
  public String getUserId()
  {
    try
    {
      String str = MATUtils.getStringFromSharedPreferences(mContext, "mat_user_id");
      return str;
    }
    finally
    {
      localObject = finally;
      throw ((Throwable)localObject);
    }
  }
  
  public String getUserNameMd5()
  {
    try
    {
      String str = mUserNameMd5;
      return str;
    }
    finally
    {
      localObject = finally;
      throw ((Throwable)localObject);
    }
  }
  
  public String getUserNameSha1()
  {
    try
    {
      String str = mUserNameSha1;
      return str;
    }
    finally
    {
      localObject = finally;
      throw ((Throwable)localObject);
    }
  }
  
  public String getUserNameSha256()
  {
    try
    {
      String str = mUserNameSha256;
      return str;
    }
    finally
    {
      localObject = finally;
      throw ((Throwable)localObject);
    }
  }
  
  public void setAction(String paramString)
  {
    try
    {
      mAction = paramString;
      return;
    }
    finally
    {
      paramString = finally;
      throw paramString;
    }
  }
  
  public void setAdvertiserId(String paramString)
  {
    try
    {
      mAdvertiserId = paramString;
      return;
    }
    finally
    {
      paramString = finally;
      throw paramString;
    }
  }
  
  public void setAndroidId(String paramString)
  {
    try
    {
      mAndroidId = paramString;
      return;
    }
    finally
    {
      paramString = finally;
      throw paramString;
    }
  }
  
  public void setAppName(String paramString)
  {
    try
    {
      mAppName = paramString;
      return;
    }
    finally
    {
      paramString = finally;
      throw paramString;
    }
  }
  
  public void setAppVersion(String paramString)
  {
    try
    {
      mAppVersion = paramString;
      return;
    }
    finally
    {
      paramString = finally;
      throw paramString;
    }
  }
  
  public void setAppVersionName(String paramString)
  {
    try
    {
      mAppVersionName = paramString;
      return;
    }
    finally
    {
      paramString = finally;
      throw paramString;
    }
  }
  
  public void setConnectionType(String paramString)
  {
    try
    {
      mConnectionType = paramString;
      return;
    }
    finally
    {
      paramString = finally;
      throw paramString;
    }
  }
  
  public void setConversionKey(String paramString)
  {
    try
    {
      mConversionKey = paramString;
      return;
    }
    finally
    {
      paramString = finally;
      throw paramString;
    }
  }
  
  public void setCountryCode(String paramString)
  {
    try
    {
      mCountryCode = paramString;
      return;
    }
    finally
    {
      paramString = finally;
      throw paramString;
    }
  }
  
  public void setCurrencyCode(String paramString)
  {
    try
    {
      mCurrencyCode = paramString;
      return;
    }
    finally
    {
      paramString = finally;
      throw paramString;
    }
  }
  
  public void setDeviceBrand(String paramString)
  {
    try
    {
      mDeviceBrand = paramString;
      return;
    }
    finally
    {
      paramString = finally;
      throw paramString;
    }
  }
  
  public void setDeviceCarrier(String paramString)
  {
    try
    {
      mDeviceCarrier = paramString;
      return;
    }
    finally
    {
      paramString = finally;
      throw paramString;
    }
  }
  
  public void setDeviceCpuType(String paramString)
  {
    try
    {
      mDeviceCpuType = paramString;
      return;
    }
    finally
    {
      paramString = finally;
      throw paramString;
    }
  }
  
  public void setDeviceModel(String paramString)
  {
    try
    {
      mDeviceModel = paramString;
      return;
    }
    finally
    {
      paramString = finally;
      throw paramString;
    }
  }
  
  public void setGender(MATGender paramMATGender)
  {
    for (;;)
    {
      try
      {
        if (paramMATGender == MATGender.MALE)
        {
          mGender = "0";
          return;
        }
        if (paramMATGender == MATGender.FEMALE) {
          mGender = "1";
        } else {
          mGender = "";
        }
      }
      finally {}
    }
  }
  
  public void setGoogleAdTrackingLimited(String paramString)
  {
    try
    {
      mGaidLimited = paramString;
      return;
    }
    finally
    {
      paramString = finally;
      throw paramString;
    }
  }
  
  public void setGoogleAdvertisingId(String paramString)
  {
    try
    {
      mGaid = paramString;
      return;
    }
    finally
    {
      paramString = finally;
      throw paramString;
    }
  }
  
  public void setInstallDate(String paramString)
  {
    try
    {
      mInstallDate = paramString;
      return;
    }
    finally
    {
      paramString = finally;
      throw paramString;
    }
  }
  
  public void setInstallReferrer(String paramString)
  {
    try
    {
      MATUtils.saveToSharedPreferences(mContext, "mat_referrer", paramString);
      return;
    }
    finally
    {
      paramString = finally;
      throw paramString;
    }
  }
  
  public void setInstaller(String paramString)
  {
    try
    {
      mInstallerPackage = paramString;
      return;
    }
    finally
    {
      paramString = finally;
      throw paramString;
    }
  }
  
  public void setIsPayingUser(String paramString)
  {
    try
    {
      MATUtils.saveToSharedPreferences(mContext, "mat_is_paying_user", paramString);
      return;
    }
    finally
    {
      paramString = finally;
      throw paramString;
    }
  }
  
  public void setLanguage(String paramString)
  {
    try
    {
      mLanguage = paramString;
      return;
    }
    finally
    {
      paramString = finally;
      throw paramString;
    }
  }
  
  public void setLastOpenLogId(String paramString)
  {
    try
    {
      MATUtils.saveToSharedPreferences(mContext, "mat_log_id_last_open", paramString);
      return;
    }
    finally
    {
      paramString = finally;
      throw paramString;
    }
  }
  
  public void setLocation(Location paramLocation)
  {
    try
    {
      mLocation = paramLocation;
      return;
    }
    finally
    {
      paramLocation = finally;
      throw paramLocation;
    }
  }
  
  public void setMCC(String paramString)
  {
    try
    {
      mMCC = paramString;
      return;
    }
    finally
    {
      paramString = finally;
      throw paramString;
    }
  }
  
  public void setMNC(String paramString)
  {
    try
    {
      mMNC = paramString;
      return;
    }
    finally
    {
      paramString = finally;
      throw paramString;
    }
  }
  
  public void setMatId(String paramString)
  {
    try
    {
      MATUtils.saveToSharedPreferences(mContext, "mat_id", paramString);
      return;
    }
    finally
    {
      paramString = finally;
      throw paramString;
    }
  }
  
  public void setOpenLogId(String paramString)
  {
    try
    {
      MATUtils.saveToSharedPreferences(mContext, "mat_log_id_open", paramString);
      return;
    }
    finally
    {
      paramString = finally;
      throw paramString;
    }
  }
  
  public void setOsVersion(String paramString)
  {
    try
    {
      mOsVersion = paramString;
      return;
    }
    finally
    {
      paramString = finally;
      throw paramString;
    }
  }
  
  public void setPackageName(String paramString)
  {
    try
    {
      mPackageName = paramString;
      return;
    }
    finally
    {
      paramString = finally;
      throw paramString;
    }
  }
  
  public void setReferralSource(String paramString)
  {
    try
    {
      mReferralSource = paramString;
      return;
    }
    finally
    {
      paramString = finally;
      throw paramString;
    }
  }
  
  public void setReferralUrl(String paramString)
  {
    try
    {
      mReferralUrl = paramString;
      return;
    }
    finally
    {
      paramString = finally;
      throw paramString;
    }
  }
  
  public void setReferrerDelay(long paramLong)
  {
    try
    {
      mReferrerDelay = Long.toString(paramLong);
      return;
    }
    finally
    {
      localObject = finally;
      throw ((Throwable)localObject);
    }
  }
  
  public void setScreenDensity(String paramString)
  {
    try
    {
      mScreenDensity = paramString;
      return;
    }
    finally
    {
      paramString = finally;
      throw paramString;
    }
  }
  
  public void setScreenHeight(String paramString)
  {
    try
    {
      mScreenHeight = paramString;
      return;
    }
    finally
    {
      paramString = finally;
      throw paramString;
    }
  }
  
  public void setScreenWidth(String paramString)
  {
    try
    {
      mScreenWidth = paramString;
      return;
    }
    finally
    {
      paramString = finally;
      throw paramString;
    }
  }
  
  public void setTimeZone(String paramString)
  {
    try
    {
      mTimeZone = paramString;
      return;
    }
    finally
    {
      paramString = finally;
      throw paramString;
    }
  }
  
  public void setUserId(String paramString)
  {
    try
    {
      MATUtils.saveToSharedPreferences(mContext, "mat_user_id", paramString);
      return;
    }
    finally
    {
      paramString = finally;
      throw paramString;
    }
  }
  
  private class GetGAID
    implements Runnable
  {
    private final WeakReference<Context> weakContext;
    
    public GetGAID(Context paramContext)
    {
      weakContext = new WeakReference(paramContext);
    }
    
    public void run()
    {
      int i = 1;
      try
      {
        Object localObject = Class.forName("com.google.android.gms.ads.identifier.AdvertisingIdClient").getDeclaredMethod("getAdvertisingIdInfo", new Class[] { Context.class }).invoke(null, new Object[] { weakContext.get() });
        String str = (String)Class.forName("com.google.android.gms.ads.identifier.AdvertisingIdClient$Info").getDeclaredMethod("getId", new Class[0]).invoke(localObject, new Object[0]);
        boolean bool = ((Boolean)Class.forName("com.google.android.gms.ads.identifier.AdvertisingIdClient$Info").getDeclaredMethod("isLimitAdTrackingEnabled", new Class[0]).invoke(localObject, new Object[0])).booleanValue();
        if (mTune.params == null)
        {
          setGoogleAdvertisingId(str);
          if (!bool) {
            break label147;
          }
        }
        for (;;)
        {
          setGoogleAdTrackingLimited(Integer.toString(i));
          mTune.setGoogleAdvertisingId(str, bool);
          return;
          label147:
          i = 0;
        }
        return;
      }
      catch (Exception localException)
      {
        localException.printStackTrace();
        Log.d("MobileAppTracker", "MAT SDK failed to get Google Advertising Id, collecting ANDROID_ID instead");
        if (mTune.params == null) {
          setAndroidId(Settings.Secure.getString(((Context)weakContext.get()).getContentResolver(), "android_id"));
        }
        mTune.setAndroidId(Settings.Secure.getString(((Context)weakContext.get()).getContentResolver(), "android_id"));
      }
    }
  }
  
  private class GetUserAgent
    implements Runnable
  {
    private final WeakReference<Context> weakContext;
    
    public GetUserAgent(Context paramContext)
    {
      weakContext = new WeakReference(paramContext);
    }
    
    public void run()
    {
      try
      {
        WebView localWebView = new WebView((Context)weakContext.get());
        String str = localWebView.getSettings().getUserAgentString();
        localWebView.destroy();
        MATParameters.this.setUserAgent(str);
        return;
      }
      catch (VerifyError localVerifyError) {}catch (Exception localException) {}
    }
  }
}

/* Location:
 * Qualified Name:     com.mobileapptracker.MATParameters
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */