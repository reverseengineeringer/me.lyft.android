package com.google.android.gms.ads.internal.client;

import android.content.Context;
import android.os.IBinder;
import android.os.RemoteException;
import com.google.android.gms.ads.internal.util.client.zzb;
import com.google.android.gms.dynamic.zzd;
import com.google.android.gms.dynamic.zzg;
import com.google.android.gms.dynamic.zzg.zza;
import com.google.android.gms.internal.zzgn;
import com.google.android.gms.internal.zzir;

@zzir
public class zze
  extends zzg<zzv>
{
  public zze()
  {
    super("com.google.android.gms.ads.AdManagerCreatorImpl");
  }
  
  public zzu zza(Context paramContext, AdSizeParcel paramAdSizeParcel, String paramString, zzgn paramzzgn, int paramInt)
  {
    try
    {
      zzd localzzd = com.google.android.gms.dynamic.zze.zzae(paramContext);
      paramContext = zzu.zza.zzn(((zzv)zzcr(paramContext)).zza(localzzd, paramAdSizeParcel, paramString, paramzzgn, 9256000, paramInt));
      return paramContext;
    }
    catch (zzg.zza paramContext)
    {
      zzb.zza("Could not create remote AdManager.", paramContext);
      return null;
    }
    catch (RemoteException paramContext)
    {
      for (;;) {}
    }
  }
  
  protected zzv zzh(IBinder paramIBinder)
  {
    return zzv.zza.zzo(paramIBinder);
  }
}

/* Location:
 * Qualified Name:     com.google.android.gms.ads.internal.client.zze
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */