package com.google.android.gms.internal;

import android.annotation.TargetApi;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.pm.ActivityInfo;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.content.pm.PackageManager.NameNotFoundException;
import android.content.pm.ResolveInfo;
import android.content.res.Resources;
import android.media.AudioManager;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.net.NetworkInfo.DetailedState;
import android.net.Uri;
import android.os.Build;
import android.os.Build.VERSION;
import android.telephony.TelephonyManager;
import android.util.DisplayMetrics;
import com.google.android.gms.ads.internal.client.zzm;
import com.google.android.gms.ads.internal.util.client.zza;
import com.google.android.gms.ads.internal.zzu;
import com.google.android.gms.common.util.zzi;
import java.util.Locale;

public final class zziz$zza
{
  private int zzcbf;
  private int zzcbg;
  private float zzcbh;
  private int zzcgh;
  private boolean zzcgi;
  private boolean zzcgj;
  private String zzcgk;
  private String zzcgl;
  private boolean zzcgm;
  private boolean zzcgn;
  private boolean zzcgo;
  private boolean zzcgp;
  private String zzcgq;
  private String zzcgr;
  private int zzcgs;
  private int zzcgt;
  private int zzcgu;
  private int zzcgv;
  private int zzcgw;
  private int zzcgx;
  private double zzcgy;
  private boolean zzcgz;
  private boolean zzcha;
  private int zzchb;
  private String zzchc;
  private boolean zzchd;
  
  public zziz$zza(Context paramContext)
  {
    PackageManager localPackageManager = paramContext.getPackageManager();
    zzv(paramContext);
    zza(paramContext, localPackageManager);
    zzw(paramContext);
    Locale localLocale = Locale.getDefault();
    boolean bool1;
    if (zza(localPackageManager, "geo:0,0?q=donuts") != null)
    {
      bool1 = true;
      zzcgi = bool1;
      if (zza(localPackageManager, "http://www.google.com") == null) {
        break label128;
      }
      bool1 = bool2;
      label63:
      zzcgj = bool1;
      zzcgl = localLocale.getCountry();
      zzcgm = zzm.zziw().zztx();
      zzcgn = zzi.zzcl(paramContext);
      zzcgq = localLocale.getLanguage();
      zzcgr = zza(localPackageManager);
      paramContext = paramContext.getResources();
      if (paramContext != null) {
        break label133;
      }
    }
    label128:
    label133:
    do
    {
      return;
      bool1 = false;
      break;
      bool1 = false;
      break label63;
      paramContext = paramContext.getDisplayMetrics();
    } while (paramContext == null);
    zzcbh = density;
    zzcbf = widthPixels;
    zzcbg = heightPixels;
  }
  
  public zziz$zza(Context paramContext, zziz paramzziz)
  {
    PackageManager localPackageManager = paramContext.getPackageManager();
    zzv(paramContext);
    zza(paramContext, localPackageManager);
    zzw(paramContext);
    zzx(paramContext);
    zzcgi = zzcgi;
    zzcgj = zzcgj;
    zzcgl = zzcgl;
    zzcgm = zzcgm;
    zzcgn = zzcgn;
    zzcgq = zzcgq;
    zzcgr = zzcgr;
    zzcbh = zzcbh;
    zzcbf = zzcbf;
    zzcbg = zzcbg;
  }
  
  private static ResolveInfo zza(PackageManager paramPackageManager, String paramString)
  {
    return paramPackageManager.resolveActivity(new Intent("android.intent.action.VIEW", Uri.parse(paramString)), 65536);
  }
  
  private static String zza(PackageManager paramPackageManager)
  {
    Object localObject = zza(paramPackageManager, "market://details?id=com.google.android.gms.ads");
    if (localObject == null) {}
    for (;;)
    {
      return null;
      localObject = activityInfo;
      if (localObject != null) {
        try
        {
          paramPackageManager = paramPackageManager.getPackageInfo(packageName, 0);
          if (paramPackageManager != null)
          {
            int i = versionCode;
            paramPackageManager = String.valueOf(packageName);
            paramPackageManager = String.valueOf(paramPackageManager).length() + 12 + i + "." + paramPackageManager;
            return paramPackageManager;
          }
        }
        catch (PackageManager.NameNotFoundException paramPackageManager) {}
      }
    }
    return null;
  }
  
  @TargetApi(16)
  private void zza(Context paramContext, PackageManager paramPackageManager)
  {
    TelephonyManager localTelephonyManager = (TelephonyManager)paramContext.getSystemService("phone");
    ConnectivityManager localConnectivityManager = (ConnectivityManager)paramContext.getSystemService("connectivity");
    zzcgk = localTelephonyManager.getNetworkOperator();
    zzcgu = localTelephonyManager.getNetworkType();
    zzcgv = localTelephonyManager.getPhoneType();
    zzcgt = -2;
    zzcha = false;
    zzchb = -1;
    if (zzu.zzfq().zza(paramPackageManager, paramContext.getPackageName(), "android.permission.ACCESS_NETWORK_STATE"))
    {
      paramContext = localConnectivityManager.getActiveNetworkInfo();
      if (paramContext == null) {
        break label126;
      }
      zzcgt = paramContext.getType();
      zzchb = paramContext.getDetailedState().ordinal();
    }
    for (;;)
    {
      if (Build.VERSION.SDK_INT >= 16) {
        zzcha = localConnectivityManager.isActiveNetworkMetered();
      }
      return;
      label126:
      zzcgt = -1;
    }
  }
  
  private void zzv(Context paramContext)
  {
    paramContext = zzu.zzfq().zzak(paramContext);
    if (paramContext != null) {
      try
      {
        zzcgh = paramContext.getMode();
        zzcgo = paramContext.isMusicActive();
        zzcgp = paramContext.isSpeakerphoneOn();
        zzcgs = paramContext.getStreamVolume(3);
        zzcgw = paramContext.getRingerMode();
        zzcgx = paramContext.getStreamVolume(2);
        return;
      }
      catch (Throwable paramContext)
      {
        zzu.zzft().zzb(paramContext, true);
      }
    }
    zzcgh = -2;
    zzcgo = false;
    zzcgp = false;
    zzcgs = 0;
    zzcgw = 0;
    zzcgx = 0;
  }
  
  private void zzw(Context paramContext)
  {
    boolean bool = false;
    paramContext = paramContext.registerReceiver(null, new IntentFilter("android.intent.action.BATTERY_CHANGED"));
    if (paramContext != null)
    {
      int i = paramContext.getIntExtra("status", -1);
      int j = paramContext.getIntExtra("level", -1);
      int k = paramContext.getIntExtra("scale", -1);
      zzcgy = (j / k);
      if ((i == 2) || (i == 5)) {
        bool = true;
      }
      zzcgz = bool;
      return;
    }
    zzcgy = -1.0D;
    zzcgz = false;
  }
  
  private void zzx(Context paramContext)
  {
    zzchc = Build.FINGERPRINT;
    zzchd = zzdq.zzo(paramContext);
  }
  
  public zziz zzro()
  {
    return new zziz(zzcgh, zzcgi, zzcgj, zzcgk, zzcgl, zzcgm, zzcgn, zzcgo, zzcgp, zzcgq, zzcgr, zzcgs, zzcgt, zzcgu, zzcgv, zzcgw, zzcgx, zzcbh, zzcbf, zzcbg, zzcgy, zzcgz, zzcha, zzchb, zzchc, zzchd);
  }
}

/* Location:
 * Qualified Name:     com.google.android.gms.internal.zziz.zza
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */