package com.google.android.gms.ads.internal.client;

import android.content.Context;
import android.os.IBinder;
import android.os.RemoteException;
import com.google.android.gms.ads.internal.util.client.zzb;
import com.google.android.gms.dynamic.zze;
import com.google.android.gms.dynamic.zzg;
import com.google.android.gms.dynamic.zzg.zza;
import com.google.android.gms.internal.zzgn;
import com.google.android.gms.internal.zzir;

@zzir
public final class zzd
  extends zzg<zzt>
{
  public zzd()
  {
    super("com.google.android.gms.ads.AdLoaderBuilderCreatorImpl");
  }
  
  public zzs zza(Context paramContext, String paramString, zzgn paramzzgn)
  {
    try
    {
      com.google.android.gms.dynamic.zzd localzzd = zze.zzae(paramContext);
      paramContext = zzs.zza.zzl(((zzt)zzcr(paramContext)).zza(localzzd, paramString, paramzzgn, 9256000));
      return paramContext;
    }
    catch (RemoteException paramContext)
    {
      zzb.zzd("Could not create remote builder for AdLoader.", paramContext);
      return null;
    }
    catch (zzg.zza paramContext)
    {
      for (;;)
      {
        zzb.zzd("Could not create remote builder for AdLoader.", paramContext);
      }
    }
  }
  
  protected zzt zzg(IBinder paramIBinder)
  {
    return zzt.zza.zzm(paramIBinder);
  }
}

/* Location:
 * Qualified Name:     com.google.android.gms.ads.internal.client.zzd
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */