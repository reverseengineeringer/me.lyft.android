package com.google.android.gms.maps;

import android.app.Activity;
import android.app.Fragment;
import android.os.RemoteException;
import com.google.android.gms.common.GooglePlayServicesNotAvailableException;
import com.google.android.gms.dynamic.zza;
import com.google.android.gms.dynamic.zze;
import com.google.android.gms.dynamic.zzf;
import com.google.android.gms.maps.internal.IStreetViewPanoramaFragmentDelegate;
import com.google.android.gms.maps.internal.zzae;
import com.google.android.gms.maps.internal.zzc;
import com.google.android.gms.maps.model.RuntimeRemoteException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

class StreetViewPanoramaFragment$zzb
  extends zza<StreetViewPanoramaFragment.zza>
{
  private final Fragment Ma;
  private final List<OnStreetViewPanoramaReadyCallback> ahH = new ArrayList();
  protected zzf<StreetViewPanoramaFragment.zza> ahm;
  private Activity mActivity;
  
  StreetViewPanoramaFragment$zzb(Fragment paramFragment)
  {
    Ma = paramFragment;
  }
  
  private void setActivity(Activity paramActivity)
  {
    mActivity = paramActivity;
    zzbpt();
  }
  
  protected void zza(zzf<StreetViewPanoramaFragment.zza> paramzzf)
  {
    ahm = paramzzf;
    zzbpt();
  }
  
  public void zzbpt()
  {
    if ((mActivity != null) && (ahm != null) && (zzbcr() == null)) {}
    try
    {
      MapsInitializer.initialize(mActivity);
      Object localObject = zzae.zzdk(mActivity).zzah(zze.zzae(mActivity));
      ahm.zza(new StreetViewPanoramaFragment.zza(Ma, (IStreetViewPanoramaFragmentDelegate)localObject));
      localObject = ahH.iterator();
      while (((Iterator)localObject).hasNext())
      {
        OnStreetViewPanoramaReadyCallback localOnStreetViewPanoramaReadyCallback = (OnStreetViewPanoramaReadyCallback)((Iterator)localObject).next();
        ((StreetViewPanoramaFragment.zza)zzbcr()).getStreetViewPanoramaAsync(localOnStreetViewPanoramaReadyCallback);
      }
      return;
    }
    catch (RemoteException localRemoteException)
    {
      throw new RuntimeRemoteException(localRemoteException);
      ahH.clear();
      return;
    }
    catch (GooglePlayServicesNotAvailableException localGooglePlayServicesNotAvailableException) {}
  }
}

/* Location:
 * Qualified Name:     com.google.android.gms.maps.StreetViewPanoramaFragment.zzb
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */