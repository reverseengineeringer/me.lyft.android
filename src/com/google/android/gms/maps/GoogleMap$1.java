package com.google.android.gms.maps;

import com.google.android.gms.maps.internal.zzh.zza;
import com.google.android.gms.maps.model.IndoorBuilding;
import com.google.android.gms.maps.model.internal.zzd;

class GoogleMap$1
  extends zzh.zza
{
  public void onIndoorBuildingFocused()
  {
    agy.onIndoorBuildingFocused();
  }
  
  public void zza(zzd paramzzd)
  {
    agy.onIndoorLevelActivated(new IndoorBuilding(paramzzd));
  }
}

/* Location:
 * Qualified Name:     com.google.android.gms.maps.GoogleMap.1
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */