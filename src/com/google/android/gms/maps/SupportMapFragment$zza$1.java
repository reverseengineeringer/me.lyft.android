package com.google.android.gms.maps;

import android.os.RemoteException;
import com.google.android.gms.maps.internal.IGoogleMapDelegate;
import com.google.android.gms.maps.internal.zzp.zza;

class SupportMapFragment$zza$1
  extends zzp.zza
{
  SupportMapFragment$zza$1(SupportMapFragment.zza paramzza, OnMapReadyCallback paramOnMapReadyCallback) {}
  
  public void zza(IGoogleMapDelegate paramIGoogleMapDelegate)
    throws RemoteException
  {
    ahk.onMapReady(new GoogleMap(paramIGoogleMapDelegate));
  }
}

/* Location:
 * Qualified Name:     com.google.android.gms.maps.SupportMapFragment.zza.1
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */