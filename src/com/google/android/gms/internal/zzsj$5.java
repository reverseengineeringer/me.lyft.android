package com.google.android.gms.internal;

import android.content.Context;

final class zzsj$5
  implements zzsj.zzb
{
  public zzsj.zzb.zzb zza(Context paramContext, String paramString, zzsj.zzb.zza paramzza)
  {
    zzsj.zzb.zzb localzzb = new zzsj.zzb.zzb();
    Mn = paramzza.zzt(paramContext, paramString);
    Mo = paramzza.zzd(paramContext, paramString, true);
    if ((Mn == 0) && (Mo == 0))
    {
      Mp = 0;
      return localzzb;
    }
    if (Mo >= Mn)
    {
      Mp = 1;
      return localzzb;
    }
    Mp = -1;
    return localzzb;
  }
}

/* Location:
 * Qualified Name:     com.google.android.gms.internal.zzsj.5
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */