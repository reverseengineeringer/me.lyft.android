package com.google.android.gms.maps;

import com.google.android.gms.dynamic.zzd;
import com.google.android.gms.dynamic.zze;
import com.google.android.gms.maps.internal.zzd.zza;
import com.google.android.gms.maps.model.Marker;
import com.google.android.gms.maps.model.internal.zzf;

class GoogleMap$3
  extends zzd.zza
{
  GoogleMap$3(GoogleMap paramGoogleMap, GoogleMap.InfoWindowAdapter paramInfoWindowAdapter) {}
  
  public zzd zzb(zzf paramzzf)
  {
    return zze.zzae(agB.getInfoWindow(new Marker(paramzzf)));
  }
  
  public zzd zzc(zzf paramzzf)
  {
    return zze.zzae(agB.getInfoContents(new Marker(paramzzf)));
  }
}

/* Location:
 * Qualified Name:     com.google.android.gms.maps.GoogleMap.3
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */