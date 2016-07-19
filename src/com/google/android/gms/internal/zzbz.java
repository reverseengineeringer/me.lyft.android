package com.google.android.gms.internal;

import android.content.Context;
import android.os.IBinder;
import android.os.RemoteException;
import com.google.android.gms.common.zzc;
import com.google.android.gms.dynamic.zzd;
import com.google.android.gms.dynamic.zze;
import com.google.android.gms.dynamic.zzg;
import com.google.android.gms.dynamic.zzg.zza;

public final class zzbz
  extends zzg<zzcb>
{
  private static final zzbz zzaiu = new zzbz();
  
  private zzbz()
  {
    super("com.google.android.gms.ads.adshield.AdShieldCreatorImpl");
  }
  
  public static zzca zzb(String paramString, Context paramContext, boolean paramBoolean)
  {
    Object localObject;
    if (zzc.zzand().isGooglePlayServicesAvailable(paramContext) == 0)
    {
      zzca localzzca = zzaiu.zzc(paramString, paramContext, paramBoolean);
      localObject = localzzca;
      if (localzzca != null) {}
    }
    else
    {
      localObject = new zzby(paramString, paramContext, paramBoolean);
    }
    return (zzca)localObject;
  }
  
  private zzca zzc(String paramString, Context paramContext, boolean paramBoolean)
  {
    zzd localzzd = zze.zzae(paramContext);
    if (paramBoolean) {}
    for (;;)
    {
      try
      {
        paramString = ((zzcb)zzcr(paramContext)).zza(paramString, localzzd);
        return zzca.zza.zzd(paramString);
      }
      catch (zzg.zza paramString)
      {
        return null;
      }
      catch (RemoteException paramString)
      {
        continue;
      }
      paramString = ((zzcb)zzcr(paramContext)).zzb(paramString, localzzd);
    }
  }
  
  protected zzcb zzb(IBinder paramIBinder)
  {
    return zzcb.zza.zze(paramIBinder);
  }
}

/* Location:
 * Qualified Name:     com.google.android.gms.internal.zzbz
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */