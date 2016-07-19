package com.google.android.gms.location.internal;

import android.location.Location;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.util.Log;
import com.google.android.gms.location.LocationListener;

class zzk$zzb
  extends Handler
{
  private final LocationListener adQ;
  
  public zzk$zzb(LocationListener paramLocationListener)
  {
    adQ = paramLocationListener;
  }
  
  public zzk$zzb(LocationListener paramLocationListener, Looper paramLooper)
  {
    super(paramLooper);
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

/* Location:
 * Qualified Name:     com.google.android.gms.location.internal.zzk.zzb
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */