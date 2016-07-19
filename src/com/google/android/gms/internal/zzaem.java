package com.google.android.gms.internal;

import android.app.Activity;
import android.os.IBinder;
import android.os.RemoteException;
import com.google.android.gms.common.GooglePlayServicesNotAvailableException;
import com.google.android.gms.common.GooglePlayServicesUtil;
import com.google.android.gms.dynamic.zzc;
import com.google.android.gms.dynamic.zze;
import com.google.android.gms.dynamic.zzg;
import com.google.android.gms.dynamic.zzg.zza;
import com.google.android.gms.wallet.fragment.WalletFragmentOptions;

public class zzaem
  extends zzg<zzaeh>
{
  private static zzaem aIC;
  
  protected zzaem()
  {
    super("com.google.android.gms.wallet.dynamite.WalletDynamiteCreatorImpl");
  }
  
  public static zzaee zza(Activity paramActivity, zzc paramzzc, WalletFragmentOptions paramWalletFragmentOptions, zzaef paramzzaef)
    throws GooglePlayServicesNotAvailableException
  {
    int i = GooglePlayServicesUtil.isGooglePlayServicesAvailable(paramActivity);
    if (i != 0) {
      throw new GooglePlayServicesNotAvailableException(i);
    }
    try
    {
      paramActivity = ((zzaeh)zzcif().zzcr(paramActivity)).zza(zze.zzae(paramActivity), paramzzc, paramWalletFragmentOptions, paramzzaef);
      return paramActivity;
    }
    catch (RemoteException paramActivity)
    {
      throw new RuntimeException(paramActivity);
    }
    catch (zzg.zza paramActivity)
    {
      throw new RuntimeException(paramActivity);
    }
  }
  
  private static zzaem zzcif()
  {
    if (aIC == null) {
      aIC = new zzaem();
    }
    return aIC;
  }
  
  protected zzaeh zzld(IBinder paramIBinder)
  {
    return zzaeh.zza.zzkz(paramIBinder);
  }
}

/* Location:
 * Qualified Name:     com.google.android.gms.internal.zzaem
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */