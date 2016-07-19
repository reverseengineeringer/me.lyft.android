package com.google.android.gms.maps;

import android.location.Location;
import android.os.RemoteException;
import com.google.android.gms.maps.internal.zzl;
import com.google.android.gms.maps.model.RuntimeRemoteException;

class GoogleMap$12$1
  implements LocationSource.OnLocationChangedListener
{
  GoogleMap$12$1(GoogleMap.12 param12, zzl paramzzl) {}
  
  public void onLocationChanged(Location paramLocation)
  {
    try
    {
      agL.zzd(paramLocation);
      return;
    }
    catch (RemoteException paramLocation)
    {
      throw new RuntimeRemoteException(paramLocation);
    }
  }
}

/* Location:
 * Qualified Name:     com.google.android.gms.maps.GoogleMap.12.1
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */