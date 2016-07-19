package com.google.android.gms.maps;

import com.google.android.gms.maps.internal.zzr.zza;
import com.google.android.gms.maps.model.Marker;
import com.google.android.gms.maps.model.internal.zzf;

class GoogleMap$17
  extends zzr.zza
{
  public void zze(zzf paramzzf)
  {
    agR.onMarkerDragStart(new Marker(paramzzf));
  }
  
  public void zzf(zzf paramzzf)
  {
    agR.onMarkerDragEnd(new Marker(paramzzf));
  }
  
  public void zzg(zzf paramzzf)
  {
    agR.onMarkerDrag(new Marker(paramzzf));
  }
}

/* Location:
 * Qualified Name:     com.google.android.gms.maps.GoogleMap.17
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */