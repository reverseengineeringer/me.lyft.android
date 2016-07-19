package com.paypal.android.sdk;

import android.content.ContentResolver;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.content.pm.PackageManager.NameNotFoundException;
import android.database.Cursor;
import android.net.Uri;
import android.os.Build.VERSION;
import android.os.Environment;
import android.os.Looper;
import android.os.StatFs;
import com.google.android.gms.ads.identifier.AdvertisingIdClient;
import com.google.android.gms.ads.identifier.AdvertisingIdClient.Info;
import com.google.android.gms.common.GooglePlayServicesUtil;
import java.io.File;
import java.net.Inet6Address;
import java.net.InetAddress;
import java.net.NetworkInterface;
import java.util.ArrayList;
import java.util.Enumeration;
import java.util.List;
import java.util.UUID;

public final class ao
{
  private static final boolean a = Boolean.valueOf(System.getProperty("dyson.debug.mode", Boolean.FALSE.toString())).booleanValue();
  private static final Uri b;
  
  static
  {
    try
    {
      Uri localUri = Uri.parse("content://com.google.android.gsf.gservices");
      b = localUri;
      return;
    }
    catch (Exception localException)
    {
      for (;;)
      {
        Object localObject = null;
      }
    }
  }
  
  /* Error */
  public static android.location.Location a(android.location.LocationManager paramLocationManager)
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore_2
    //   2: aload_0
    //   3: iconst_1
    //   4: invokevirtual 60	android/location/LocationManager:getProviders	(Z)Ljava/util/List;
    //   7: astore 4
    //   9: aload 4
    //   11: invokeinterface 66 1 0
    //   16: istore_1
    //   17: iload_1
    //   18: iconst_1
    //   19: isub
    //   20: istore_1
    //   21: iload_1
    //   22: iflt +42 -> 64
    //   25: aload_0
    //   26: aload 4
    //   28: iload_1
    //   29: invokeinterface 70 2 0
    //   34: checkcast 72	java/lang/String
    //   37: invokevirtual 76	android/location/LocationManager:getLastKnownLocation	(Ljava/lang/String;)Landroid/location/Location;
    //   40: astore_3
    //   41: aload_3
    //   42: astore_2
    //   43: aload_2
    //   44: astore_3
    //   45: aload_2
    //   46: ifnonnull +13 -> 59
    //   49: iload_1
    //   50: iconst_1
    //   51: isub
    //   52: istore_1
    //   53: goto -32 -> 21
    //   56: astore_0
    //   57: aconst_null
    //   58: astore_3
    //   59: aload_3
    //   60: areturn
    //   61: astore_0
    //   62: aload_2
    //   63: areturn
    //   64: aload_2
    //   65: areturn
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	66	0	paramLocationManager	android.location.LocationManager
    //   16	37	1	i	int
    //   1	64	2	localObject1	Object
    //   40	20	3	localObject2	Object
    //   7	20	4	localList	List
    // Exception table:
    //   from	to	target	type
    //   2	17	56	java/lang/RuntimeException
    //   25	41	61	java/lang/RuntimeException
  }
  
  public static V a(Context paramContext)
  {
    V localV = new V();
    localV.a(paramContext.getPackageName());
    try
    {
      localV.b(getPackageManagergetPackageInfoa0versionName);
      return localV;
    }
    catch (PackageManager.NameNotFoundException paramContext) {}
    return localV;
  }
  
  public static String a()
  {
    X localX = new X();
    localX.a(Environment.getExternalStorageDirectory().getAbsolutePath() + "/Android/data/com.ebay.lid/");
    String str2 = localX.b("fb.bin");
    String str1 = str2;
    if ("".equals(str2.trim()))
    {
      str1 = UUID.randomUUID().toString();
      localX.a("fb.bin", str1.getBytes("UTF-8"));
    }
    return str1;
  }
  
  public static String a(Context paramContext, Z paramZ)
  {
    try
    {
      if ((Build.VERSION.SDK_INT >= 9) && (GooglePlayServicesUtil.isGooglePlayServicesAvailable(paramContext) == 0))
      {
        if (Looper.myLooper() != Looper.getMainLooper()) {
          return AdvertisingIdClient.getAdvertisingIdInfo(paramContext).getId();
        }
        new Thread(new ap(paramContext, paramZ)).start();
      }
    }
    catch (Throwable paramContext)
    {
      for (;;)
      {
        paramContext.getLocalizedMessage();
      }
    }
    return null;
  }
  
  public static List a(boolean paramBoolean)
  {
    ArrayList localArrayList = new ArrayList();
    for (;;)
    {
      String str;
      try
      {
        Enumeration localEnumeration1 = NetworkInterface.getNetworkInterfaces();
        if (localEnumeration1.hasMoreElements())
        {
          Enumeration localEnumeration2 = ((NetworkInterface)localEnumeration1.nextElement()).getInetAddresses();
          if (localEnumeration2.hasMoreElements())
          {
            InetAddress localInetAddress = (InetAddress)localEnumeration2.nextElement();
            if (localInetAddress.isLoopbackAddress()) {
              continue;
            }
            str = localInetAddress.getHostAddress();
            if (!(localInetAddress instanceof Inet6Address)) {
              break label100;
            }
            if (!paramBoolean) {
              continue;
            }
            localArrayList.add(str);
          }
        }
        else
        {
          return localArrayList;
        }
      }
      catch (Exception localException)
      {
        localException.printStackTrace();
      }
      label100:
      localArrayList.add(str);
    }
  }
  
  public static void a(String paramString1, String paramString2, Throwable paramThrowable) {}
  
  public static boolean a(Context paramContext, String paramString)
  {
    return paramContext.getApplicationContext().checkCallingOrSelfPermission(paramString) == 0;
  }
  
  public static boolean a(PackageManager paramPackageManager, Intent paramIntent)
  {
    paramPackageManager = paramPackageManager.queryIntentActivities(paramIntent, 65536);
    return (paramPackageManager != null) && (paramPackageManager.size() > 0);
  }
  
  public static String b()
  {
    List localList = a(false);
    if (localList.isEmpty()) {
      return "";
    }
    return (String)localList.get(0);
  }
  
  public static String b(Context paramContext)
  {
    if ((b != null) && (paramContext.getApplicationContext().checkCallingOrSelfPermission("com.google.android.providers.gsf.permission.READ_GSERVICES") == 0))
    {
      paramContext = paramContext.getContentResolver().query(b, null, null, new String[] { "android_id" }, null);
      if (paramContext != null) {}
    }
    else
    {
      return null;
    }
    try
    {
      if (paramContext.moveToFirst())
      {
        int i = paramContext.getColumnCount();
        if (i >= 2) {}
      }
      else
      {
        return null;
      }
      String str = Long.toHexString(Long.parseLong(paramContext.getString(1)));
      return str;
    }
    catch (NumberFormatException localNumberFormatException)
    {
      return null;
    }
    finally
    {
      paramContext.close();
    }
  }
  
  public static long c()
  {
    try
    {
      StatFs localStatFs = new StatFs(Environment.getExternalStorageDirectory().getPath());
      long l = localStatFs.getBlockSize();
      int i = localStatFs.getBlockCount();
      return i * l;
    }
    catch (IllegalArgumentException localIllegalArgumentException)
    {
      localIllegalArgumentException.getLocalizedMessage();
    }
    return 0L;
  }
}

/* Location:
 * Qualified Name:     com.paypal.android.sdk.ao
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */