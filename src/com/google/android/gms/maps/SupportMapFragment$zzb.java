package com.google.android.gms.maps;

import android.app.Activity;
import android.os.RemoteException;
import android.support.v4.app.Fragment;
import com.google.android.gms.common.GooglePlayServicesNotAvailableException;
import com.google.android.gms.dynamic.zza;
import com.google.android.gms.dynamic.zze;
import com.google.android.gms.dynamic.zzf;
import com.google.android.gms.maps.internal.IMapFragmentDelegate;
import com.google.android.gms.maps.internal.zzae;
import com.google.android.gms.maps.internal.zzc;
import com.google.android.gms.maps.model.RuntimeRemoteException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

class SupportMapFragment$zzb
  extends zza<SupportMapFragment.zza>
{
  private final Fragment Md;
  protected zzf<SupportMapFragment.zza> ahm;
  private final List<OnMapReadyCallback> ahn = new ArrayList();
  private Activity mActivity;
  
  SupportMapFragment$zzb(Fragment paramFragment)
  {
    Md = paramFragment;
  }
  
  private void setActivity(Activity paramActivity)
  {
    mActivity = paramActivity;
    zzbpt();
  }
  
  protected void zza(zzf<SupportMapFragment.zza> paramzzf)
  {
    ahm = paramzzf;
    zzbpt();
  }
  
  public void zzbpt()
  {
    if ((mActivity != null) && (ahm != null) && (zzbcr() == null)) {
      try
      {
        MapsInitializer.initialize(mActivity);
        Object localObject = zzae.zzdk(mActivity).zzag(zze.zzae(mActivity));
        if (localObject == null) {
          return;
        }
        ahm.zza(new SupportMapFragment.zza(Md, (IMapFragmentDelegate)localObject));
        localObject = ahn.iterator();
        while (((Iterator)localObject).hasNext())
        {
          OnMapReadyCallback localOnMapReadyCallback = (OnMapReadyCallback)((Iterator)localObject).next();
          ((SupportMapFragment.zza)zzbcr()).getMapAsync(localOnMapReadyCallback);
        }
        return;
      }
      catch (RemoteException localRemoteException)
      {
        throw new RuntimeRemoteException(localRemoteException);
        ahn.clear();
        return;
      }
      catch (GooglePlayServicesNotAvailableException localGooglePlayServicesNotAvailableException) {}
    }
  }
}

/* Location:
 * Qualified Name:     com.google.android.gms.maps.SupportMapFragment.zzb
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */