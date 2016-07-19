package com.google.android.gms.flags.impl;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.pm.PackageManager.NameNotFoundException;
import com.google.android.gms.common.util.DynamiteApi;
import com.google.android.gms.dynamic.zzd;
import com.google.android.gms.dynamic.zze;
import com.google.android.gms.internal.zzug.zza;

@DynamiteApi
public class FlagProviderImpl
  extends zzug.zza
{
  private boolean zzamr = false;
  private SharedPreferences zzaxs;
  
  public boolean getBooleanFlagValue(String paramString, boolean paramBoolean, int paramInt)
  {
    if (!zzamr) {
      return paramBoolean;
    }
    return zza.zza.zza(zzaxs, paramString, Boolean.valueOf(paramBoolean)).booleanValue();
  }
  
  public int getIntFlagValue(String paramString, int paramInt1, int paramInt2)
  {
    if (!zzamr) {
      return paramInt1;
    }
    return zza.zzb.zza(zzaxs, paramString, Integer.valueOf(paramInt1)).intValue();
  }
  
  public long getLongFlagValue(String paramString, long paramLong, int paramInt)
  {
    if (!zzamr) {
      return paramLong;
    }
    return zza.zzc.zza(zzaxs, paramString, Long.valueOf(paramLong)).longValue();
  }
  
  public String getStringFlagValue(String paramString1, String paramString2, int paramInt)
  {
    if (!zzamr) {
      return paramString2;
    }
    return zza.zzd.zza(zzaxs, paramString1, paramString2);
  }
  
  public void init(zzd paramzzd)
  {
    paramzzd = (Context)zze.zzad(paramzzd);
    if (zzamr) {
      return;
    }
    try
    {
      zzaxs = zzb.zzn(paramzzd.createPackageContext("com.google.android.gms", 0));
      zzamr = true;
      return;
    }
    catch (PackageManager.NameNotFoundException paramzzd) {}
  }
}

/* Location:
 * Qualified Name:     com.google.android.gms.flags.impl.FlagProviderImpl
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */