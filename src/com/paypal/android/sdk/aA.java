package com.paypal.android.sdk;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.content.pm.PackageManager.NameNotFoundException;
import android.location.Location;
import android.location.LocationListener;
import android.location.LocationManager;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.net.wifi.WifiInfo;
import android.net.wifi.WifiManager;
import android.os.Build;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.os.Handler;
import android.os.SystemClock;
import android.provider.Settings.Secure;
import android.telephony.ServiceState;
import android.telephony.TelephonyManager;
import android.telephony.cdma.CdmaCellLocation;
import android.telephony.gsm.GsmCellLocation;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.TimeZone;
import java.util.Timer;
import java.util.UUID;
import org.apache.http.message.BasicNameValuePair;
import org.json.JSONObject;

public final class aa
  implements LocationListener
{
  private static Y x = new Y();
  private static final Object y = new Object();
  private static aa z;
  private Context a;
  private String b;
  private long c;
  private long d;
  private long e;
  private int f;
  private int g;
  private long h;
  private String i;
  private W j;
  private Z k;
  private Z l;
  private String m;
  private Map n;
  private Map o;
  private Location p;
  private Timer q;
  private Handler r;
  private a s;
  private String t;
  private String u;
  private boolean v;
  private String w;
  
  private static long a(Context paramContext)
  {
    if (paramContext == null) {}
    for (;;)
    {
      return 0L;
      try
      {
        if (Build.VERSION.SDK_INT > 8) {
          return getPackageManagergetPackageInfogetPackageName0firstInstallTime;
        }
        paramContext = getPackageManagergetApplicationInfogetPackageName0sourceDir;
        if (paramContext != null)
        {
          long l1 = new File(paramContext).lastModified();
          return l1;
        }
      }
      catch (PackageManager.NameNotFoundException paramContext) {}
    }
    return 0L;
  }
  
  public static aa a()
  {
    synchronized (y)
    {
      if (z == null) {
        z = new aa();
      }
      aa localaa = z;
      return localaa;
    }
  }
  
  private static String a(TelephonyManager paramTelephonyManager)
  {
    try
    {
      paramTelephonyManager = paramTelephonyManager.getSimOperatorName();
      return paramTelephonyManager;
    }
    catch (SecurityException paramTelephonyManager)
    {
      ao.a("RiskComponent", "Known SecurityException on some devices", paramTelephonyManager);
    }
    return null;
  }
  
  private void a(W paramW)
  {
    j = paramW;
    i();
    q = new Timer();
    long l1 = j.c();
    long l2 = j.d();
    long l3 = j.e();
    d = (l1 * 1000L);
    c = (l2 * 1000L);
    e = (l3 * 1000L);
    ae.a(c);
    if ((j == null) || (!i.equals(j.a())))
    {
      i();
      q = new Timer();
      q.scheduleAtFixedRate(new ad(this), 0L, 600000L);
    }
    while (!v) {
      return;
    }
    i();
    q = new Timer();
    q.scheduleAtFixedRate(new ac(this), 0L, d);
  }
  
  private void a(Z paramZ1, Z paramZ2)
  {
    if (paramZ1 == null) {}
    do
    {
      return;
      Z = new HashMap(n);
      o = new HashMap(n);
      if (paramZ2 == null) {
        break;
      }
      paramZ1 = paramZ1.a(paramZ2);
      paramZ2 = new ArrayList();
      paramZ2.add(new BasicNameValuePair("appGuid", b));
      paramZ2.add(new BasicNameValuePair("libraryVersion", c()));
      paramZ2.add(new BasicNameValuePair("additionalData", paramZ1.toString()));
    } while (j == null);
    paramZ1 = j.g();
    boolean bool = j.h();
    Handler localHandler = r;
    if (!bool) {}
    for (bool = true;; bool = false)
    {
      new ak(paramZ1, paramZ2, localHandler, bool, null).a();
      return;
      paramZ1 = paramZ1.a();
      break;
    }
  }
  
  private static long b(Context paramContext)
  {
    if (paramContext == null) {}
    for (;;)
    {
      return 0L;
      try
      {
        if (Build.VERSION.SDK_INT > 8) {
          return getPackageManagergetPackageInfogetPackageName0lastUpdateTime;
        }
        paramContext = getPackageManagergetApplicationInfogetPackageName0sourceDir;
        if (paramContext != null)
        {
          long l1 = new File(paramContext).lastModified();
          return l1;
        }
      }
      catch (PackageManager.NameNotFoundException paramContext) {}
    }
    return 0L;
  }
  
  public static String c()
  {
    return String.format(Locale.US, "Dyson/%S (%S %S)", new Object[] { "3.1.9", "Android", Build.VERSION.RELEASE });
  }
  
  private static String g()
  {
    return UUID.randomUUID().toString().replaceAll("-", "");
  }
  
  private String h()
  {
    StringBuffer localStringBuffer = new StringBuffer("https://b.stats.paypal.com/counter.cgi?p=");
    if ((s == null) || (s == a.a)) {
      return "Beacon not recognize host app";
    }
    int i1 = s.a();
    if (u == null) {
      return "Beacon pairing id empty";
    }
    localStringBuffer.append(u).append("&i=");
    String str = ao.b();
    if (str.equals("")) {}
    for (;;)
    {
      try
      {
        localStringBuffer.append(x.a("emptyIp")).append("&t=");
        localStringBuffer.append(String.valueOf(System.currentTimeMillis() / 1000L)).append("&a=").append(i1);
        new ag(localStringBuffer.toString(), b, t, ao.a(a), r).a();
        return localStringBuffer.toString();
      }
      catch (IOException localIOException)
      {
        localIOException.printStackTrace();
        continue;
      }
      localStringBuffer.append(localIOException).append("&t=");
    }
  }
  
  private void i()
  {
    if (q != null) {
      q.cancel();
    }
  }
  
  private Z j()
  {
    Object localObject6 = null;
    if (a == null) {
      return null;
    }
    Z localZ = new Z();
    Object localObject5;
    NetworkInfo localNetworkInfo;
    label104:
    label133:
    label213:
    label249:
    V localV;
    int i1;
    try
    {
      localTelephonyManager = (TelephonyManager)a.getSystemService("phone");
      localObject3 = (WifiManager)a.getSystemService("wifi");
      localObject1 = (ConnectivityManager)a.getSystemService("connectivity");
      if (!ao.a(a, "android.permission.ACCESS_WIFI_STATE")) {
        break label1243;
      }
      localObject5 = ((WifiManager)localObject3).getConnectionInfo();
      if (!ao.a(a, "android.permission.ACCESS_NETWORK_STATE")) {
        break label1249;
      }
      localNetworkInfo = ((ConnectivityManager)localObject1).getActiveNetworkInfo();
      if (ao.a(a, "android.permission.ACCESS_COARSE_LOCATION")) {
        break label1227;
      }
      if (!ao.a(a, "android.permission.ACCESS_FINE_LOCATION")) {
        break label1255;
      }
    }
    catch (RuntimeException localRuntimeException)
    {
      for (;;)
      {
        TelephonyManager localTelephonyManager;
        Object localObject3;
        Object localObject1;
        throw localRuntimeException;
        i1 = ((CdmaCellLocation)localObject4).getBaseStationId();
        continue;
        i1 = ((CdmaCellLocation)localObject4).getNetworkId();
        continue;
        i1 = ((CdmaCellLocation)localObject4).getSystemId();
        continue;
        localObject4 = ((WifiInfo)localObject5).getBSSID();
        continue;
        i1 = localRuntimeException.getCid();
        continue;
        localObject4 = j.b();
        continue;
        localObject4 = localNetworkInfo.getTypeName();
        continue;
        localObject4 = new Location(p);
      }
    }
    catch (Exception localException1)
    {
      for (;;)
      {
        ao.a("RiskComponent", "Unknown error in RiskComponent", localException1);
        break;
        i1 = localException1.getLac();
        continue;
        localObject2 = ((WifiInfo)localObject5).getMacAddress();
        continue;
        localObject2 = ((WifiInfo)localObject5).getSSID();
        continue;
        localObject2 = null;
        continue;
        boolean bool = false;
        continue;
        continue;
        i1 = 1;
        continue;
        continue;
        bool = true;
      }
    }
    bool = ao.a(a, "android.permission.READ_PHONE_STATE");
    switch (localTelephonyManager.getPhoneType())
    {
    case 0: 
      z = ("unknown (" + localTelephonyManager.getPhoneType() + ")");
      localObject3 = null;
      localObject1 = null;
      a = b;
      R = u;
      if (s == null)
      {
        N = a.a.a();
        O = t;
        W = w;
        U = Settings.Secure.getString(a.getContentResolver(), "android_id");
        localV = ao.a(a);
        b = localV.a();
        c = localV.b();
        if (localObject3 != null) {
          break label1092;
        }
        i1 = -1;
        d = i1;
        if (localObject3 != null) {
          break label1101;
        }
        i1 = -1;
        L = i1;
        if (localObject3 != null) {
          break label1110;
        }
        i1 = -1;
        K = i1;
        if (localObject5 != null) {
          break label1119;
        }
        localObject3 = null;
        e = ((String)localObject3);
        if (localObject1 != null) {
          break label1129;
        }
        i1 = -1;
        f = i1;
        M = localTelephonyManager.getNetworkOperator();
        g = "3.1.9";
        h = i;
        if (j != null) {
          break label1137;
        }
        localObject3 = null;
        i = ((String)localObject3);
        if (localNetworkInfo != null) {
          break label1149;
        }
        localObject3 = null;
        j = ((String)localObject3);
        if (!bool) {
          break label1288;
        }
        localObject3 = localTelephonyManager.getDeviceId();
        label450:
        k = ((String)localObject3);
        l = Build.MODEL;
        m = Build.DEVICE;
        n = SystemClock.uptimeMillis();
        o = ao.b();
        p = ao.a(true);
        if (!bool) {
          break label1294;
        }
        localObject3 = localTelephonyManager.getLine1Number();
        label509:
        r = ((String)localObject3);
        s = ao.a();
        t = Locale.getDefault().getCountry();
        u = Locale.getDefault().getLanguage();
        if (p != null) {
          break label1159;
        }
        localObject3 = null;
        v = ((Location)localObject3);
        if (localObject1 != null) {
          break label1188;
        }
        i1 = -1;
        w = i1;
        if (localObject5 != null) {
          break label1196;
        }
        localObject1 = null;
        x = ((String)localObject1);
        y = Build.VERSION.RELEASE;
        A = ae.b();
        B = new ServiceState().getRoaming();
        C = a(localTelephonyManager);
        if (!bool) {
          break label1300;
        }
      }
      break;
    }
    label1092:
    label1101:
    label1110:
    label1119:
    label1129:
    label1137:
    label1149:
    label1159:
    label1188:
    label1196:
    Object localObject2;
    label1214:
    label1219:
    label1224:
    label1227:
    label1235:
    label1240:
    label1243:
    label1249:
    label1255:
    label1260:
    label1266:
    label1271:
    label1283:
    label1288:
    label1294:
    label1300:
    for (localObject1 = localTelephonyManager.getSimSerialNumber();; localObject2 = null)
    {
      D = ((String)localObject1);
      if (Build.VERSION.SDK_INT >= 9) {
        X = Build.SERIAL;
      }
      E = a.getPackageManager().hasSystemFeature("android.hardware.telephony");
      if (localObject5 == null)
      {
        localObject1 = null;
        F = ((String)localObject1);
        if (!bool) {
          break label1214;
        }
        localObject1 = localTelephonyManager.getSubscriberId();
        G = ((String)localObject1);
        H = System.currentTimeMillis();
        I = ao.c();
        J = TimeZone.getDefault().getDisplayName();
        if ((Build.BRAND.equalsIgnoreCase("generic")) || (Build.PRODUCT.equals("sdk")) || (Build.HARDWARE.equals("goldfish")) || (Build.FINGERPRINT.startsWith("generic")) || (Build.MANUFACTURER.equals("unknown"))) {
          break label1235;
        }
        if (!Build.PRODUCT.matches(".*_?sdk_?.*")) {
          break label1219;
        }
        break label1235;
        P = bool;
        Q = af.a();
        localObject1 = new ArrayList();
        if (j != null)
        {
          localObject3 = j.f();
          try
          {
            localObject3 = ((List)localObject3).iterator();
            while (((Iterator)localObject3).hasNext())
            {
              localObject5 = (String)((Iterator)localObject3).next();
              if (ao.a(a.getPackageManager(), new Intent().setComponent(ComponentName.unflattenFromString((String)localObject5)))) {
                ((List)localObject1).add(localObject5);
              }
            }
            if (((List)localObject1).size() != 0) {
              break label1224;
            }
          }
          catch (Exception localException2)
          {
            ao.a("RiskComponent", "knownApps error", null);
          }
        }
        localObject1 = localObject6;
        q = ((List)localObject1);
        S = a(a);
        T = b(a);
        Z = n;
        Y = ao.b(a);
        V = ao.a(a, localZ);
        break label1240;
        z = "none";
        localObject4 = null;
        localObject1 = null;
        break label213;
        z = "gsm";
        if (i1 == 0) {
          break label1266;
        }
        localObject1 = (GsmCellLocation)localTelephonyManager.getCellLocation();
        break label1260;
        z = "cdma";
        if (i1 == 0) {
          break label1283;
        }
        localObject1 = (CdmaCellLocation)localTelephonyManager.getCellLocation();
        break label1271;
        N = s.a();
        break label249;
      }
      return localZ;
      localObject5 = null;
      break;
      localNetworkInfo = null;
      break label104;
      i1 = 0;
      break label133;
      for (;;)
      {
        localObject4 = null;
        break;
        localObject2 = null;
      }
      for (;;)
      {
        localV = null;
        localObject4 = localObject2;
        localObject2 = localV;
        break;
        localObject2 = null;
      }
      Object localObject4 = null;
      break label450;
      localObject4 = null;
      break label509;
    }
  }
  
  public final String a(Context paramContext, String paramString1, a parama, String paramString2, String paramString3, boolean paramBoolean, String paramString4, String paramString5)
  {
    a = paramContext;
    b = paramString1;
    v = paramBoolean;
    if (parama == null) {}
    for (s = a.a;; s = parama)
    {
      t = paramString2;
      k = null;
      l = null;
      w = paramString5;
      n = new HashMap();
      g = 0;
      f = 0;
      u = g();
      paramContext = paramString3;
      if (paramString3 == null) {
        paramContext = "https://www.paypalobjects.com/webstatic/risk/dyson_config_v2.json";
      }
      try
      {
        i = paramContext;
        h = System.currentTimeMillis();
        if (r == null)
        {
          r = new ab(this);
          paramContext = (LocationManager)a.getSystemService("location");
          if (paramContext != null)
          {
            onLocationChanged(ao.a(paramContext));
            if (paramContext.isProviderEnabled("network")) {
              paramContext.requestLocationUpdates("network", 0L, 0.0F, this);
            }
          }
        }
        i();
      }
      catch (Exception paramContext)
      {
        for (;;)
        {
          ao.a("RiskComponent", null, paramContext);
        }
      }
      h();
      a(new W(a));
      return u;
    }
  }
  
  public final JSONObject b()
  {
    ae.a();
    k = j();
    if (k == null) {
      return null;
    }
    return k.a();
  }
  
  public final void d()
  {
    ae.a();
    k = j();
    a(k, null);
  }
  
  public final void e()
  {
    h = System.currentTimeMillis();
  }
  
  public final String f()
  {
    String str = g();
    u = str;
    d();
    h();
    return str;
  }
  
  public final void onLocationChanged(Location paramLocation)
  {
    if (paramLocation != null) {
      p = new Location(paramLocation);
    }
  }
  
  public final void onProviderDisabled(String paramString) {}
  
  public final void onProviderEnabled(String paramString) {}
  
  public final void onStatusChanged(String paramString, int paramInt, Bundle paramBundle) {}
}

/* Location:
 * Qualified Name:     com.paypal.android.sdk.aa
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */