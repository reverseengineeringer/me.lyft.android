package com.paypal.android.sdk;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.content.pm.PackageManager.NameNotFoundException;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.telephony.TelephonyManager;
import android.util.Log;
import java.util.UUID;

public class b
{
  private static final String a = b.class.getSimpleName();
  private Context b;
  private String c;
  
  public b(Context paramContext, String paramString)
  {
    if (paramContext == null) {
      throw new NullPointerException("context == null");
    }
    if (paramString == null) {
      throw new NullPointerException("prefs == null");
    }
    b = paramContext;
    c = paramString;
  }
  
  public final String a(String paramString1, String paramString2)
  {
    return b.getSharedPreferences(c, 0).getString(paramString1, paramString2);
  }
  
  public final boolean a()
  {
    Object localObject = (ConnectivityManager)b.getSystemService("connectivity");
    if (localObject == null)
    {
      Log.w("paypal.sdk", "Unable to retrieve Context.CONNECTIVITY_SERVICE. Ignoring.");
      return true;
    }
    if (((ConnectivityManager)localObject).getAllNetworkInfo() == null)
    {
      Log.w("paypal.sdk", "ConnectivityManager.getAllNetworkInfo() returned null. Ignoring.");
      return true;
    }
    localObject = ((ConnectivityManager)localObject).getAllNetworkInfo();
    int m = localObject.length;
    int i = 0;
    int k;
    for (int j = 0; i < m; j = k)
    {
      k = j;
      if (localObject[i].isConnectedOrConnecting()) {
        k = j + 1;
      }
      i += 1;
    }
    return j > 0;
  }
  
  public final int b()
  {
    return ((TelephonyManager)b.getSystemService("phone")).getPhoneType();
  }
  
  public final void b(String paramString1, String paramString2)
  {
    SharedPreferences.Editor localEditor = b.getSharedPreferences(c, 0).edit();
    localEditor.putString(paramString1, paramString2);
    localEditor.commit();
  }
  
  public final String c()
  {
    try
    {
      Object localObject = b.getPackageManager();
      localObject = getPackageInfob.getPackageName(), 0).applicationInfo.loadLabel((PackageManager)localObject).toString();
      return (String)localObject;
    }
    catch (PackageManager.NameNotFoundException localNameNotFoundException) {}
    return null;
  }
  
  public final String d()
  {
    try
    {
      String str = ((TelephonyManager)b.getSystemService("phone")).getSimOperatorName();
      return str;
    }
    catch (SecurityException localSecurityException)
    {
      localSecurityException.toString();
    }
    return null;
  }
  
  public final String e()
  {
    String str = a("InstallationGUID", null);
    if (str != null) {
      return str;
    }
    b("InstallationGUID", UUID.randomUUID().toString());
    return a("InstallationGUID", null);
  }
  
  public final Context f()
  {
    return b;
  }
}

/* Location:
 * Qualified Name:     com.paypal.android.sdk.b
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */