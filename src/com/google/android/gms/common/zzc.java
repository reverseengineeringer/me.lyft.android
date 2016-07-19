package com.google.android.gms.common;

import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.content.pm.PackageManager.NameNotFoundException;
import android.text.TextUtils;
import com.google.android.gms.common.internal.zzo;
import com.google.android.gms.common.util.zzi;

public class zzc
{
  public static final int GOOGLE_PLAY_SERVICES_VERSION_CODE = zze.GOOGLE_PLAY_SERVICES_VERSION_CODE;
  private static final zzc qV = new zzc();
  
  public static zzc zzand()
  {
    return qV;
  }
  
  private String zzn(Context paramContext, String paramString)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("gcore_");
    localStringBuilder.append(GOOGLE_PLAY_SERVICES_VERSION_CODE);
    localStringBuilder.append("-");
    if (!TextUtils.isEmpty(paramString)) {
      localStringBuilder.append(paramString);
    }
    localStringBuilder.append("-");
    if (paramContext != null) {
      localStringBuilder.append(paramContext.getPackageName());
    }
    localStringBuilder.append("-");
    if (paramContext != null) {}
    try
    {
      localStringBuilder.append(getPackageManagergetPackageInfogetPackageName0versionCode);
      return localStringBuilder.toString();
    }
    catch (PackageManager.NameNotFoundException paramContext)
    {
      for (;;) {}
    }
  }
  
  public PendingIntent getErrorResolutionPendingIntent(Context paramContext, int paramInt1, int paramInt2)
  {
    return zza(paramContext, paramInt1, paramInt2, null);
  }
  
  public int isGooglePlayServicesAvailable(Context paramContext)
  {
    int j = zze.isGooglePlayServicesAvailable(paramContext);
    int i = j;
    if (zze.zzc(paramContext, j)) {
      i = 18;
    }
    return i;
  }
  
  public boolean isUserResolvableError(int paramInt)
  {
    return zze.isUserRecoverableError(paramInt);
  }
  
  public PendingIntent zza(Context paramContext, int paramInt1, int paramInt2, String paramString)
  {
    int i = paramInt1;
    if (zzi.zzck(paramContext))
    {
      i = paramInt1;
      if (paramInt1 == 2) {
        i = 42;
      }
    }
    paramString = zza(paramContext, i, paramString);
    if (paramString == null) {
      return null;
    }
    return PendingIntent.getActivity(paramContext, paramInt2, paramString, 268435456);
  }
  
  public Intent zza(Context paramContext, int paramInt, String paramString)
  {
    switch (paramInt)
    {
    default: 
      return null;
    case 1: 
    case 2: 
      return zzo.zzad("com.google.android.gms", zzn(paramContext, paramString));
    case 42: 
      return zzo.zzasw();
    }
    return zzo.zzhp("com.google.android.gms");
  }
  
  public int zzbn(Context paramContext)
  {
    return zze.zzbn(paramContext);
  }
  
  public void zzbo(Context paramContext)
    throws GooglePlayServicesRepairableException, GooglePlayServicesNotAvailableException
  {
    zze.zzbb(paramContext);
  }
  
  public void zzbp(Context paramContext)
  {
    zze.zzbp(paramContext);
  }
  
  public boolean zzc(Context paramContext, int paramInt)
  {
    return zze.zzc(paramContext, paramInt);
  }
  
  @Deprecated
  public Intent zzfa(int paramInt)
  {
    return zza(null, paramInt, null);
  }
  
  public boolean zzm(Context paramContext, String paramString)
  {
    return zze.zzm(paramContext, paramString);
  }
}

/* Location:
 * Qualified Name:     com.google.android.gms.common.zzc
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */