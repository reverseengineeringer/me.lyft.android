package com.google.android.gms.internal;

import android.content.ComponentName;
import android.content.Context;
import android.content.pm.ActivityInfo;
import android.content.pm.PackageManager;
import android.content.pm.PackageManager.NameNotFoundException;
import android.content.res.Resources;
import android.os.Bundle;
import com.google.android.gms.ads.internal.client.AdRequestParcel;

@zzir
public class zzkc
{
  private final Object zzail = new Object();
  final String zzcjq;
  long zzckg = -1L;
  long zzckh = -1L;
  int zzcki = -1;
  int zzckj = 0;
  int zzckk = 0;
  
  public zzkc(String paramString)
  {
    zzcjq = paramString;
  }
  
  public static boolean zzab(Context paramContext)
  {
    int i = paramContext.getResources().getIdentifier("Theme.Translucent", "style", "android");
    if (i == 0)
    {
      zzkh.zzcx("Please set theme of AdActivity to @android:style/Theme.Translucent to enable transparent background interstitial ad.");
      return false;
    }
    ComponentName localComponentName = new ComponentName(paramContext.getPackageName(), "com.google.android.gms.ads.AdActivity");
    try
    {
      if (i == getPackageManagergetActivityInfo0theme) {
        return true;
      }
      zzkh.zzcx("Please set theme of AdActivity to @android:style/Theme.Translucent to enable transparent background interstitial ad.");
      return false;
    }
    catch (PackageManager.NameNotFoundException paramContext)
    {
      zzkh.zzcy("Fail to fetch AdActivity theme");
      zzkh.zzcx("Please set theme of AdActivity to @android:style/Theme.Translucent to enable transparent background interstitial ad.");
    }
    return false;
  }
  
  public void zzb(AdRequestParcel paramAdRequestParcel, long paramLong)
  {
    synchronized (zzail)
    {
      if (zzckh == -1L)
      {
        zzckh = paramLong;
        zzckg = zzckh;
        if ((extras == null) || (extras.getInt("gw", 2) != 1)) {}
      }
      else
      {
        zzckg = paramLong;
      }
    }
    zzcki += 1;
  }
  
  public Bundle zzf(Context paramContext, String paramString)
  {
    synchronized (zzail)
    {
      Bundle localBundle = new Bundle();
      localBundle.putString("session_id", zzcjq);
      localBundle.putLong("basets", zzckh);
      localBundle.putLong("currts", zzckg);
      localBundle.putString("seq_num", paramString);
      localBundle.putInt("preqs", zzcki);
      localBundle.putInt("pclick", zzckj);
      localBundle.putInt("pimp", zzckk);
      localBundle.putBoolean("support_transparent_background", zzab(paramContext));
      return localBundle;
    }
  }
  
  public void zzrz()
  {
    synchronized (zzail)
    {
      zzckk += 1;
      return;
    }
  }
  
  public void zzsa()
  {
    synchronized (zzail)
    {
      zzckj += 1;
      return;
    }
  }
  
  public long zzsy()
  {
    return zzckh;
  }
}

/* Location:
 * Qualified Name:     com.google.android.gms.internal.zzkc
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */