package com.google.android.gms.maps;

import android.content.Context;
import android.os.Bundle;
import android.os.RemoteException;
import android.view.ViewGroup;
import com.google.android.gms.common.GooglePlayServicesNotAvailableException;
import com.google.android.gms.dynamic.zza;
import com.google.android.gms.dynamic.zze;
import com.google.android.gms.dynamic.zzf;
import com.google.android.gms.maps.internal.IMapViewDelegate;
import com.google.android.gms.maps.internal.zzae;
import com.google.android.gms.maps.internal.zzc;
import com.google.android.gms.maps.model.RuntimeRemoteException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

class MapView$zzb
  extends zza<MapView.zza>
{
  protected zzf<MapView.zza> ahm;
  private final List<OnMapReadyCallback> ahn = new ArrayList();
  private final ViewGroup aht;
  private final GoogleMapOptions ahu;
  private final Context mContext;
  
  MapView$zzb(ViewGroup paramViewGroup, Context paramContext, GoogleMapOptions paramGoogleMapOptions)
  {
    aht = paramViewGroup;
    mContext = paramContext;
    ahu = paramGoogleMapOptions;
  }
  
  public void getMapAsync(OnMapReadyCallback paramOnMapReadyCallback)
  {
    if (zzbcr() != null)
    {
      ((MapView.zza)zzbcr()).getMapAsync(paramOnMapReadyCallback);
      return;
    }
    ahn.add(paramOnMapReadyCallback);
  }
  
  public void onEnterAmbient(Bundle paramBundle)
  {
    if (zzbcr() != null) {
      ((MapView.zza)zzbcr()).onEnterAmbient(paramBundle);
    }
  }
  
  public void onExitAmbient()
  {
    if (zzbcr() != null) {
      ((MapView.zza)zzbcr()).onExitAmbient();
    }
  }
  
  protected void zza(zzf<MapView.zza> paramzzf)
  {
    ahm = paramzzf;
    zzbpt();
  }
  
  public void zzbpt()
  {
    if ((ahm != null) && (zzbcr() == null)) {
      try
      {
        MapsInitializer.initialize(mContext);
        Object localObject = zzae.zzdk(mContext).zza(zze.zzae(mContext), ahu);
        if (localObject == null) {
          return;
        }
        ahm.zza(new MapView.zza(aht, (IMapViewDelegate)localObject));
        localObject = ahn.iterator();
        while (((Iterator)localObject).hasNext())
        {
          OnMapReadyCallback localOnMapReadyCallback = (OnMapReadyCallback)((Iterator)localObject).next();
          ((MapView.zza)zzbcr()).getMapAsync(localOnMapReadyCallback);
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
 * Qualified Name:     com.google.android.gms.maps.MapView.zzb
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */