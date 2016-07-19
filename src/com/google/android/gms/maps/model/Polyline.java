package com.google.android.gms.maps.model;

import android.os.RemoteException;
import com.google.android.gms.common.internal.zzab;
import com.google.android.gms.maps.model.internal.IPolylineDelegate;

public final class Polyline
{
  private final IPolylineDelegate aiR;
  
  public Polyline(IPolylineDelegate paramIPolylineDelegate)
  {
    aiR = ((IPolylineDelegate)zzab.zzaa(paramIPolylineDelegate));
  }
  
  public boolean equals(Object paramObject)
  {
    if (!(paramObject instanceof Polyline)) {
      return false;
    }
    try
    {
      boolean bool = aiR.equalsRemote(aiR);
      return bool;
    }
    catch (RemoteException paramObject)
    {
      throw new RuntimeRemoteException((RemoteException)paramObject);
    }
  }
  
  public int hashCode()
  {
    try
    {
      int i = aiR.hashCodeRemote();
      return i;
    }
    catch (RemoteException localRemoteException)
    {
      throw new RuntimeRemoteException(localRemoteException);
    }
  }
  
  public void remove()
  {
    try
    {
      aiR.remove();
      return;
    }
    catch (RemoteException localRemoteException)
    {
      throw new RuntimeRemoteException(localRemoteException);
    }
  }
}

/* Location:
 * Qualified Name:     com.google.android.gms.maps.model.Polyline
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */