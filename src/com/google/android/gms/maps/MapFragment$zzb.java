package com.google.android.gms.maps;

import android.app.Activity;
import android.app.Fragment;
import android.os.RemoteException;
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

class MapFragment$zzb
  extends zza<MapFragment.zza>
{
  private final Fragment Ma;
  protected zzf<MapFragment.zza> ahm;
  private final List<OnMapReadyCallback> ahn = new ArrayList();
  private Activity mActivity;
  
  MapFragment$zzb(Fragment paramFragment)
  {
    Ma = paramFragment;
  }
  
  private void setActivity(Activity paramActivity)
  {
    mActivity = paramActivity;
    zzbpt();
  }
  
  protected void zza(zzf<MapFragment.zza> paramzzf)
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
        ahm.zza(new MapFragment.zza(Ma, (IMapFragmentDelegate)localObject));
        localObject = ahn.iterator();
        while (((Iterator)localObject).hasNext())
        {
          OnMapReadyCallback localOnMapReadyCallback = (OnMapReadyCallback)((Iterator)localObject).next();
          ((MapFragment.zza)zzbcr()).getMapAsync(localOnMapReadyCallback);
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
 * Qualified Name:     com.google.android.gms.maps.MapFragment.zzb
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */