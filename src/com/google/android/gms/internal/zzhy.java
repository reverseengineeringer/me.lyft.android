package com.google.android.gms.internal;

import android.app.Activity;
import android.os.IBinder;
import android.os.RemoteException;
import com.google.android.gms.ads.internal.util.client.zzb;
import com.google.android.gms.dynamic.zzd;
import com.google.android.gms.dynamic.zze;
import com.google.android.gms.dynamic.zzg;
import com.google.android.gms.dynamic.zzg.zza;

@zzir
public final class zzhy
  extends zzg<zzhu>
{
  public zzhy()
  {
    super("com.google.android.gms.ads.InAppPurchaseManagerCreatorImpl");
  }
  
  protected zzhu zzaz(IBinder paramIBinder)
  {
    return zzhu.zza.zzaw(paramIBinder);
  }
  
  public zzht zzg(Activity paramActivity)
  {
    try
    {
      zzd localzzd = zze.zzae(paramActivity);
      paramActivity = zzht.zza.zzav(((zzhu)zzcr(paramActivity)).zzo(localzzd));
      return paramActivity;
    }
    catch (RemoteException paramActivity)
    {
      zzb.zzd("Could not create remote InAppPurchaseManager.", paramActivity);
      return null;
    }
    catch (zzg.zza paramActivity)
    {
      zzb.zzd("Could not create remote InAppPurchaseManager.", paramActivity);
    }
    return null;
  }
}

/* Location:
 * Qualified Name:     com.google.android.gms.internal.zzhy
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */