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
public final class zzhl
  extends zzg<zzhn>
{
  public zzhl()
  {
    super("com.google.android.gms.ads.AdOverlayCreatorImpl");
  }
  
  protected zzhn zzap(IBinder paramIBinder)
  {
    return zzhn.zza.zzar(paramIBinder);
  }
  
  public zzhm zzf(Activity paramActivity)
  {
    try
    {
      zzd localzzd = zze.zzae(paramActivity);
      paramActivity = zzhm.zza.zzaq(((zzhn)zzcr(paramActivity)).zzn(localzzd));
      return paramActivity;
    }
    catch (RemoteException paramActivity)
    {
      zzb.zzd("Could not create remote AdOverlay.", paramActivity);
      return null;
    }
    catch (zzg.zza paramActivity)
    {
      zzb.zzd("Could not create remote AdOverlay.", paramActivity);
    }
    return null;
  }
}

/* Location:
 * Qualified Name:     com.google.android.gms.internal.zzhl
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */