package me.lyft.android.infrastructure.device;

import android.accounts.Account;
import android.accounts.AccountManager;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.content.pm.PackageManager.NameNotFoundException;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.graphics.Point;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Build;
import android.os.Build.VERSION;
import android.os.SystemClock;
import android.provider.Settings.Secure;
import android.telephony.TelephonyManager;
import android.util.DisplayMetrics;
import android.view.Display;
import android.view.WindowManager;
import java.util.Locale;
import me.lyft.android.LyftApplication;
import me.lyft.android.common.Objects;
import me.lyft.android.common.Strings;
import me.lyft.android.logging.L;
import me.lyft.android.utils.DeviceNetworkUtils;

public class Device
  implements IDevice
{
  private static final int MINIMAL_TABLET_DIMENSION = 480;
  private static final String platform = "android";
  final AccountManager accountManager;
  final ConnectivityManager connectivityManager;
  final LyftApplication context;
  final DisplayMetrics displayMetrics;
  private BatteryStatus lastKnownBatteryStatus;
  String mobileCountryCode;
  String mobileNetworkCode;
  final String networkCountryIso;
  final PackageManager packageManager;
  final TelephonyManager telephonyManager;
  final WindowManager windowManager;
  
  public Device(LyftApplication paramLyftApplication, WindowManager paramWindowManager, TelephonyManager paramTelephonyManager, ConnectivityManager paramConnectivityManager, AccountManager paramAccountManager, PackageManager paramPackageManager)
  {
    context = paramLyftApplication;
    windowManager = paramWindowManager;
    telephonyManager = paramTelephonyManager;
    connectivityManager = paramConnectivityManager;
    accountManager = paramAccountManager;
    packageManager = paramPackageManager;
    displayMetrics = new DisplayMetrics();
    paramWindowManager.getDefaultDisplay().getMetrics(displayMetrics);
    networkCountryIso = paramTelephonyManager.getNetworkCountryIso();
    paramLyftApplication = paramTelephonyManager.getNetworkOperator();
    if (!Strings.isNullOrEmpty(paramLyftApplication))
    {
      mobileCountryCode = paramLyftApplication.substring(0, 3);
      mobileNetworkCode = paramLyftApplication.substring(3);
    }
  }
  
  private Account getGoogleAccount()
  {
    Account[] arrayOfAccount = accountManager.getAccountsByType("com.google");
    if (arrayOfAccount.length > 0) {
      return arrayOfAccount[0];
    }
    return null;
  }
  
  private void refreshBatterStatus()
  {
    Object localObject = new IntentFilter("android.intent.action.BATTERY_CHANGED");
    localObject = context.registerReceiver(null, (IntentFilter)localObject);
    int i = ((Intent)localObject).getIntExtra("level", -1);
    int j = ((Intent)localObject).getIntExtra("scale", -1);
    float f = i / j;
    i = ((Intent)localObject).getIntExtra("status", -1);
    if ((i == 2) || (i == 5)) {}
    for (boolean bool = true;; bool = false)
    {
      lastKnownBatteryStatus = new BatteryStatus(f * 100.0F, bool, System.currentTimeMillis());
      return;
    }
  }
  
  public String getAndroidId()
  {
    String str = Settings.Secure.getString(context.getContentResolver(), "android_id");
    if (!Strings.isNullOrEmpty(str)) {
      return str;
    }
    return ((TelephonyManager)context.getSystemService("phone")).getDeviceId();
  }
  
  public long getApplicationInstallTimestamp()
  {
    try
    {
      long l = context.getPackageManager().getPackageInfo(context.getPackageName(), 0).firstInstallTime;
      return l;
    }
    catch (PackageManager.NameNotFoundException localNameNotFoundException)
    {
      L.e(localNameNotFoundException, "getApplicationInstallTimestamp", new Object[0]);
    }
    return 0L;
  }
  
  public String getApplicationVersion()
  {
    try
    {
      String str = context.getPackageManager().getPackageInfo(context.getPackageName(), 0).versionName;
      return str;
    }
    catch (Exception localException)
    {
      L.e(localException, "getApplicationVersion", new Object[0]);
    }
    return "";
  }
  
  public int getApplicationVersionCode()
  {
    try
    {
      int i = context.getPackageManager().getPackageInfo(context.getPackageName(), 0).versionCode;
      return i;
    }
    catch (PackageManager.NameNotFoundException localNameNotFoundException)
    {
      L.e(localNameNotFoundException, "getApplicationVersionCode", new Object[0]);
    }
    return 0;
  }
  
  public BatteryStatus getBatteryStatus()
  {
    if ((lastKnownBatteryStatus == null) || (lastKnownBatteryStatus.needsRefresh())) {
      refreshBatterStatus();
    }
    return lastKnownBatteryStatus;
  }
  
  public Integer getDensity()
  {
    return Integer.valueOf((int)(displayMetrics.density * 160.0F));
  }
  
  public int getDensityDpi()
  {
    return displayMetrics.densityDpi;
  }
  
  public String getDeviceInfo()
  {
    return Build.MODEL + " " + Build.PRODUCT + " " + Build.MANUFACTURER;
  }
  
  public String getDeviceLocale()
  {
    return context.getResources().getConfiguration().locale.toString();
  }
  
  public String getDeviceName()
  {
    String str1 = Build.MANUFACTURER;
    String str2 = Build.MODEL;
    if (str2.toUpperCase().startsWith(str1.toUpperCase())) {
      return str2;
    }
    return str1 + " " + str2;
  }
  
  public int getDisplayRotation()
  {
    switch (windowManager.getDefaultDisplay().getRotation())
    {
    case 0: 
    default: 
      return 0;
    case 1: 
      return 90;
    case 2: 
      return 180;
    }
    return 270;
  }
  
  public long getElapsedRealtime()
  {
    return SystemClock.elapsedRealtime();
  }
  
  public String getGoogleAccountEmail()
  {
    Account localAccount = getGoogleAccount();
    if (localAccount == null) {
      return "";
    }
    return name;
  }
  
  public String getLocaleCountryIso()
  {
    return Locale.getDefault().getCountry().toLowerCase();
  }
  
  public String getMobileCountryCode()
  {
    return mobileCountryCode;
  }
  
  public String getMobileNetworkCode()
  {
    return mobileNetworkCode;
  }
  
  public boolean getNetworkConnected()
  {
    NetworkInfo localNetworkInfo = connectivityManager.getActiveNetworkInfo();
    return (localNetworkInfo != null) && (localNetworkInfo.isConnectedOrConnecting());
  }
  
  public String getNetworkIso()
  {
    return networkCountryIso;
  }
  
  public boolean getNetworkLocationEnabled()
  {
    return Settings.Secure.isLocationProviderEnabled(context.getContentResolver(), "network");
  }
  
  public String getNetworkType()
  {
    return DeviceNetworkUtils.getNetworkType(connectivityManager.getActiveNetworkInfo());
  }
  
  public String getOSVersion()
  {
    return Build.VERSION.RELEASE;
  }
  
  public String getOperatorName()
  {
    return telephonyManager.getNetworkOperatorName();
  }
  
  public String getPhoneNumber()
  {
    return (String)Objects.firstNonNull(telephonyManager.getLine1Number(), "");
  }
  
  public String getPlatform()
  {
    return "android";
  }
  
  public String getRadioType()
  {
    return DeviceNetworkUtils.getRadioType(telephonyManager.getNetworkType());
  }
  
  public int getSDKVersion()
  {
    return Build.VERSION.SDK_INT;
  }
  
  public Integer getScreenHeight()
  {
    Display localDisplay = windowManager.getDefaultDisplay();
    Point localPoint;
    if (Build.VERSION.SDK_INT >= 13)
    {
      localPoint = new Point();
      localDisplay.getSize(localPoint);
    }
    for (int i = y;; i = localDisplay.getHeight()) {
      return Integer.valueOf(i);
    }
  }
  
  public Integer getScreenWidth()
  {
    Display localDisplay = windowManager.getDefaultDisplay();
    Point localPoint;
    if (Build.VERSION.SDK_INT >= 13)
    {
      localPoint = new Point();
      localDisplay.getSize(localPoint);
    }
    for (int i = x;; i = localDisplay.getWidth()) {
      return Integer.valueOf(i);
    }
  }
  
  public String getSimCountryIso()
  {
    return telephonyManager.getSimCountryIso();
  }
  
  public String getUserAgent()
  {
    return String.format(context.getString(2131166403), new Object[] { getOSVersion(), getApplicationVersion() });
  }
  
  public String getUuid()
  {
    return getAndroidId();
  }
  
  public float getXDensity()
  {
    return displayMetrics.xdpi;
  }
  
  public float getYDensity()
  {
    return displayMetrics.ydpi;
  }
  
  public boolean hasCamera()
  {
    return context.getPackageManager().hasSystemFeature("android.hardware.camera");
  }
  
  public boolean hasCameraFlash()
  {
    return context.getPackageManager().hasSystemFeature("android.hardware.camera.flash");
  }
  
  public boolean isGPSEnabled()
  {
    return Settings.Secure.isLocationProviderEnabled(context.getContentResolver(), "gps");
  }
  
  public boolean isModel(String paramString)
  {
    return Build.MODEL.equalsIgnoreCase(paramString);
  }
  
  public boolean isPackageInstalled(String paramString)
  {
    boolean bool = false;
    try
    {
      paramString = packageManager.getPackageInfo(paramString, 0);
      if (paramString != null) {
        bool = true;
      }
      return bool;
    }
    catch (PackageManager.NameNotFoundException paramString) {}
    return false;
  }
  
  public boolean isTabletScreenSize()
  {
    DisplayMetrics localDisplayMetrics = new DisplayMetrics();
    windowManager.getDefaultDisplay().getMetrics(localDisplayMetrics);
    Display localDisplay = windowManager.getDefaultDisplay();
    return Math.min(localDisplay.getWidth(), localDisplay.getHeight()) / density >= 480.0F;
  }
}

/* Location:
 * Qualified Name:     me.lyft.android.infrastructure.device.Device
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */