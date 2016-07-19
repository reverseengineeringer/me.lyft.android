package com.google.android.gms.location.internal;

import android.location.Location;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.util.Log;
import com.google.android.gms.common.internal.zzab;
import com.google.android.gms.location.LocationListener;
import com.google.android.gms.location.zze.zza;

class zzk$zzc
  extends zze.zza
{
  private Handler adO;
  
  zzk$zzc(LocationListener paramLocationListener, Looper paramLooper)
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

/* Location:
 * Qualified Name:     com.google.android.gms.location.internal.zzk.zzc
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */