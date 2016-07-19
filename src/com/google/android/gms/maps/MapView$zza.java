package com.google.android.gms.maps;

import android.app.Activity;
import android.os.Bundle;
import android.os.RemoteException;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.google.android.gms.common.internal.zzab;
import com.google.android.gms.dynamic.zze;
import com.google.android.gms.maps.internal.IGoogleMapDelegate;
import com.google.android.gms.maps.internal.IMapViewDelegate;
import com.google.android.gms.maps.internal.MapLifecycleDelegate;
import com.google.android.gms.maps.internal.zzp.zza;
import com.google.android.gms.maps.model.RuntimeRemoteException;

class MapView$zza
  implements MapLifecycleDelegate
{
  private final ViewGroup ahp;
  private final IMapViewDelegate ahq;
  private View ahr;
  
  public MapView$zza(ViewGroup paramViewGroup, IMapViewDelegate paramIMapViewDelegate)
  {
    ahq = ((IMapViewDelegate)zzab.zzaa(paramIMapViewDelegate));
    ahp = ((ViewGroup)zzab.zzaa(paramViewGroup));
  }
  
  public void getMapAsync(final OnMapReadyCallback paramOnMapReadyCallback)
  {
    try
    {
      ahq.getMapAsync(new zzp.zza()
      {
        public void zza(IGoogleMapDelegate paramAnonymousIGoogleMapDelegate)
          throws RemoteException
        {
          paramOnMapReadyCallback.onMapReady(new GoogleMap(paramAnonymousIGoogleMapDelegate));
        }
      });
      return;
    }
    catch (RemoteException paramOnMapReadyCallback)
    {
      throw new RuntimeRemoteException(paramOnMapReadyCallback);
    }
  }
  
  public void onCreate(Bundle paramBundle)
  {
    try
    {
      ahq.onCreate(paramBundle);
      ahr = ((View)zze.zzad(ahq.getView()));
      ahp.removeAllViews();
      ahp.addView(ahr);
      return;
    }
    catch (RemoteException paramBundle)
    {
      throw new RuntimeRemoteException(paramBundle);
    }
  }
  
  public View onCreateView(LayoutInflater paramLayoutInflater, ViewGroup paramViewGroup, Bundle paramBundle)
  {
    throw new UnsupportedOperationException("onCreateView not allowed on MapViewDelegate");
  }
  
  public void onDestroy()
  {
    try
    {
      ahq.onDestroy();
      return;
    }
    catch (RemoteException localRemoteException)
    {
      throw new RuntimeRemoteException(localRemoteException);
    }
  }
  
  public void onDestroyView()
  {
    throw new UnsupportedOperationException("onDestroyView not allowed on MapViewDelegate");
  }
  
  public void onEnterAmbient(Bundle paramBundle)
  {
    try
    {
      ahq.onEnterAmbient(paramBundle);
      return;
    }
    catch (RemoteException paramBundle)
    {
      throw new RuntimeRemoteException(paramBundle);
    }
  }
  
  public void onExitAmbient()
  {
    try
    {
      ahq.onExitAmbient();
      return;
    }
    catch (RemoteException localRemoteException)
    {
      throw new RuntimeRemoteException(localRemoteException);
    }
  }
  
  public void onInflate(Activity paramActivity, Bundle paramBundle1, Bundle paramBundle2)
  {
    throw new UnsupportedOperationException("onInflate not allowed on MapViewDelegate");
  }
  
  public void onLowMemory()
  {
    try
    {
      ahq.onLowMemory();
      return;
    }
    catch (RemoteException localRemoteException)
    {
      throw new RuntimeRemoteException(localRemoteException);
    }
  }
  
  public void onPause()
  {
    try
    {
      ahq.onPause();
      return;
    }
    catch (RemoteException localRemoteException)
    {
      throw new RuntimeRemoteException(localRemoteException);
    }
  }
  
  public void onResume()
  {
    try
    {
      ahq.onResume();
      return;
    }
    catch (RemoteException localRemoteException)
    {
      throw new RuntimeRemoteException(localRemoteException);
    }
  }
  
  public void onSaveInstanceState(Bundle paramBundle)
  {
    try
    {
      ahq.onSaveInstanceState(paramBundle);
      return;
    }
    catch (RemoteException paramBundle)
    {
      throw new RuntimeRemoteException(paramBundle);
    }
  }
  
  public void onStart() {}
  
  public void onStop() {}
}

/* Location:
 * Qualified Name:     com.google.android.gms.maps.MapView.zza
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */