package com.google.android.gms.maps;

import android.app.Activity;
import android.os.RemoteException;
import android.support.v4.app.Fragment;
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

class SupportStreetViewPanoramaFragment$zzb
  extends zza<SupportStreetViewPanoramaFragment.zza>
{
  private final Fragment Md;
  private final List<OnStreetViewPanoramaReadyCallback> ahH = new ArrayList();
  protected zzf<SupportStreetViewPanoramaFragment.zza> ahm;
  private Activity mActivity;
  
  SupportStreetViewPanoramaFragment$zzb(Fragment paramFragment)
  {
    Md = paramFragment;
  }
  
  private void setActivity(Activity paramActivity)
  {
    mActivity = paramActivity;
    zzbpt();
  }
  
  protected void zza(zzf<SupportStreetViewPanoramaFragment.zza> paramzzf)
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
      ahm.zza(new SupportStreetViewPanoramaFragment.zza(Md, (IStreetViewPanoramaFragmentDelegate)localObject));
      localObject = ahH.iterator();
      while (((Iterator)localObject).hasNext())
      {
        OnStreetViewPanoramaReadyCallback localOnStreetViewPanoramaReadyCallback = (OnStreetViewPanoramaReadyCallback)((Iterator)localObject).next();
        ((SupportStreetViewPanoramaFragment.zza)zzbcr()).getStreetViewPanoramaAsync(localOnStreetViewPanoramaReadyCallback);
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
 * Qualified Name:     com.google.android.gms.maps.SupportStreetViewPanoramaFragment.zzb
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */