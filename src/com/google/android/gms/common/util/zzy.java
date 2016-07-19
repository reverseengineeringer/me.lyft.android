package com.google.android.gms.common.util;

import android.annotation.TargetApi;
import android.content.Context;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.content.pm.PackageManager.NameNotFoundException;
import android.util.Log;
import com.google.android.gms.common.zzf;
import com.google.android.gms.internal.zzrt;
import com.google.android.gms.internal.zzru;

public final class zzy
{
  @TargetApi(19)
  public static boolean zzb(Context paramContext, int paramInt, String paramString)
  {
    return zzru.zzcq(paramContext).zzg(paramInt, paramString);
  }
  
  public static boolean zze(Context paramContext, int paramInt)
  {
    if (!zzb(paramContext, paramInt, "com.google.android.gms")) {}
    do
    {
      return false;
      Object localObject = paramContext.getPackageManager();
      try
      {
        localObject = ((PackageManager)localObject).getPackageInfo("com.google.android.gms", 64);
        return zzf.zzbz(paramContext).zzb(paramContext.getPackageManager(), (PackageInfo)localObject);
      }
      catch (PackageManager.NameNotFoundException paramContext) {}
    } while (!Log.isLoggable("UidVerifier", 3));
    Log.d("UidVerifier", "Package manager can't find google play services package, defaulting to false");
    return false;
  }
}

/* Location:
 * Qualified Name:     com.google.android.gms.common.util.zzy
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */