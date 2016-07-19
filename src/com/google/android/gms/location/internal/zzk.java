package com.google.android.gms.location.internal;

import android.content.ContentProviderClient;
import android.content.Context;
import android.location.Location;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.os.RemoteException;
import android.util.Log;
import com.google.android.gms.common.internal.zzab;
import com.google.android.gms.location.LocationAvailability;
import com.google.android.gms.location.LocationListener;
import com.google.android.gms.location.LocationRequest;
import com.google.android.gms.location.LocationResult;
import com.google.android.gms.location.zzd;
import com.google.android.gms.location.zzd.zza;
import com.google.android.gms.location.zze;
import com.google.android.gms.location.zze.zza;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

public class zzk
{
  private Map<LocationListener, zzc> Py = new HashMap();
  private ContentProviderClient adL = null;
  private boolean adM = false;
  private Map<Object, zza> adN = new HashMap();
  private final zzp<zzi> ady;
  private final Context mContext;
  
  public zzk(Context paramContext, zzp<zzi> paramzzp)
  {
    mContext = paramContext;
    ady = paramzzp;
  }
  
  private zzc zza(LocationListener paramLocationListener, Looper paramLooper)
  {
    synchronized (Py)
    {
      zzc localzzc2 = (zzc)Py.get(paramLocationListener);
      zzc localzzc1 = localzzc2;
      if (localzzc2 == null) {
        localzzc1 = new zzc(paramLocationListener, paramLooper);
      }
      Py.put(paramLocationListener, localzzc1);
      return localzzc1;
    }
  }
  
  public Location getLastLocation()
  {
    ady.zzarv();
    try
    {
      Location localLocation = ((zzi)ady.zzarw()).zzkn(mContext.getPackageName());
      return localLocation;
    }
    catch (RemoteException localRemoteException)
    {
      throw new IllegalStateException(localRemoteException);
    }
  }
  
  public void removeAllListeners()
  {
    Object localObject3;
    try
    {
      synchronized (Py)
      {
        Iterator localIterator1 = Py.values().iterator();
        while (localIterator1.hasNext())
        {
          localObject3 = (zzc)localIterator1.next();
          if (localObject3 != null) {
            ((zzi)ady.zzarw()).zza(LocationRequestUpdateData.zza((zze)localObject3, null));
          }
        }
      }
      Py.clear();
    }
    catch (RemoteException localRemoteException)
    {
      throw new IllegalStateException(localRemoteException);
    }
    synchronized (adN)
    {
      Iterator localIterator2 = adN.values().iterator();
      while (localIterator2.hasNext())
      {
        localObject3 = (zza)localIterator2.next();
        if (localObject3 != null) {
          ((zzi)ady.zzarw()).zza(LocationRequestUpdateData.zza((zzd)localObject3, null));
        }
      }
    }
    adN.clear();
  }
  
  public void zza(LocationListener paramLocationListener, zzg paramzzg)
    throws RemoteException
  {
    ady.zzarv();
    zzab.zzb(paramLocationListener, "Invalid null listener");
    synchronized (Py)
    {
      paramLocationListener = (zzc)Py.remove(paramLocationListener);
      if (paramLocationListener != null)
      {
        paramLocationListener.release();
        ((zzi)ady.zzarw()).zza(LocationRequestUpdateData.zza(paramLocationListener, paramzzg));
      }
      return;
    }
  }
  
  public void zza(LocationRequest paramLocationRequest, LocationListener paramLocationListener, Looper paramLooper, zzg paramzzg)
    throws RemoteException
  {
    ady.zzarv();
    paramLocationListener = zza(paramLocationListener, paramLooper);
    ((zzi)ady.zzarw()).zza(LocationRequestUpdateData.zza(LocationRequestInternal.zzb(paramLocationRequest), paramLocationListener, paramzzg));
  }
  
  public void zzbnm()
  {
    if (adM) {}
    try
    {
      zzbx(false);
      return;
    }
    catch (RemoteException localRemoteException)
    {
      throw new IllegalStateException(localRemoteException);
    }
  }
  
  public void zzbx(boolean paramBoolean)
    throws RemoteException
  {
    ady.zzarv();
    ((zzi)ady.zzarw()).zzbx(paramBoolean);
    adM = paramBoolean;
  }
  
  private static class zza
    extends zzd.zza
  {
    private Handler adO;
    
    private void zzb(int paramInt, Object paramObject)
    {
      if (adO == null)
      {
        Log.e("LocationClientHelper", "Received a data in client after calling removeLocationUpdates.");
        return;
      }
      Message localMessage = Message.obtain();
      what = paramInt;
      obj = paramObject;
      adO.sendMessage(localMessage);
    }
    
    public void onLocationAvailability(LocationAvailability paramLocationAvailability)
    {
      zzb(1, paramLocationAvailability);
    }
    
    public void onLocationResult(LocationResult paramLocationResult)
    {
      zzb(0, paramLocationResult);
    }
  }
  
  private static class zzb
    extends Handler
  {
    private final LocationListener adQ;
    
    public zzb(LocationListener paramLocationListener)
    {
      adQ = paramLocationListener;
    }
    
    public zzb(LocationListener paramLocationListener, Looper paramLooper)
    {
      super();
      adQ = paramLocationListener;
    }
    
    public void handleMessage(Message paramMessage)
    {
      switch (what)
      {
      default: 
        Log.e("LocationClientHelper", "unknown message in LocationHandler.handleMessage");
        return;
      }
      paramMessage = new Location((Location)obj);
      adQ.onLocationChanged(paramMessage);
    }
  }
  
  private static class zzc
    extends zze.zza
  {
    private Handler adO;
    
    zzc(LocationListener paramLocationListener, Looper paramLooper)
    {
      boolean bool;
      if (paramLooper == null)
      {
        if (Looper.myLooper() != null)
        {
          bool = true;
          zzab.zza(bool, "Can't create handler inside thread that has not called Looper.prepare()");
        }
      }
      else {
        if (paramLooper != null) {
          break label46;
        }
      }
      label46:
      for (paramLocationListener = new zzk.zzb(paramLocationListener);; paramLocationListener = new zzk.zzb(paramLocationListener, paramLooper))
      {
        adO = paramLocationListener;
        return;
        bool = false;
        break;
      }
    }
    
    public void onLocationChanged(Location paramLocation)
    {
      if (adO == null)
      {
        Log.e("LocationClientHelper", "Received a location in client after calling removeLocationUpdates.");
        return;
      }
      Message localMessage = Message.obtain();
      what = 1;
      obj = paramLocation;
      adO.sendMessage(localMessage);
    }
    
    public void release()
    {
      adO = null;
    }
  }
}

/* Location:
 * Qualified Name:     com.google.android.gms.location.internal.zzk
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */