package com.google.android.gms.maps;

import android.content.Context;
import android.os.RemoteException;
import android.view.ViewGroup;
import com.google.android.gms.common.GooglePlayServicesNotAvailableException;
import com.google.android.gms.dynamic.zza;
import com.google.android.gms.dynamic.zze;
import com.google.android.gms.dynamic.zzf;
import com.google.android.gms.maps.internal.IStreetViewPanoramaViewDelegate;
import com.google.android.gms.maps.internal.zzae;
import com.google.android.gms.maps.internal.zzc;
import com.google.android.gms.maps.model.RuntimeRemoteException;
import java.util.Iterator;
import java.util.List;

class StreetViewPanoramaView$zzb
  extends zza<StreetViewPanoramaView.zza>
{
  private final List<OnStreetViewPanoramaReadyCallback> ahH;
  private final StreetViewPanoramaOptions ahT;
  protected zzf<StreetViewPanoramaView.zza> ahm;
  private final ViewGroup aht;
  private final Context mContext;
  
  protected void zza(zzf<StreetViewPanoramaView.zza> paramzzf)
  {
    ahm = paramzzf;
    zzbpt();
  }
  
  public void zzbpt()
  {
    if ((ahm != null) && (zzbcr() == null)) {}
    try
    {
      Object localObject = zzae.zzdk(mContext).zza(zze.zzae(mContext), ahT);
      ahm.zza(new StreetViewPanoramaView.zza(aht, (IStreetViewPanoramaViewDelegate)localObject));
      localObject = ahH.iterator();
      while (((Iterator)localObject).hasNext())
      {
        OnStreetViewPanoramaReadyCallback localOnStreetViewPanoramaReadyCallback = (OnStreetViewPanoramaReadyCallback)((Iterator)localObject).next();
        ((StreetViewPanoramaView.zza)zzbcr()).getStreetViewPanoramaAsync(localOnStreetViewPanoramaReadyCallback);
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
 * Qualified Name:     com.google.android.gms.maps.StreetViewPanoramaView.zzb
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */