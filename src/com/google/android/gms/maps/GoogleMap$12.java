package com.google.android.gms.maps;

import android.location.Location;
import android.os.RemoteException;
import com.google.android.gms.maps.internal.ILocationSourceDelegate.zza;
import com.google.android.gms.maps.internal.zzl;
import com.google.android.gms.maps.model.RuntimeRemoteException;

class GoogleMap$12
  extends ILocationSourceDelegate.zza
{
  GoogleMap$12(GoogleMap paramGoogleMap, LocationSource paramLocationSource) {}
  
  public void activate(final zzl paramzzl)
  {
    agK.activate(new LocationSource.OnLocationChangedListener()
    {
      public void onLocationChanged(Location paramAnonymousLocation)
      {
        try
        {
          paramzzl.zzd(paramAnonymousLocation);
          return;
        }
        catch (RemoteException paramAnonymousLocation)
        {
          throw new RuntimeRemoteException(paramAnonymousLocation);
        }
      }
    });
  }
  
  public void deactivate()
  {
    agK.deactivate();
  }
}

/* Location:
 * Qualified Name:     com.google.android.gms.maps.GoogleMap.12
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */