package com.google.android.gms.location.internal;

import android.os.Handler;
import android.os.Message;
import android.util.Log;
import com.google.android.gms.location.LocationAvailability;
import com.google.android.gms.location.LocationResult;
import com.google.android.gms.location.zzd.zza;

class zzk$zza
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

/* Location:
 * Qualified Name:     com.google.android.gms.location.internal.zzk.zza
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */