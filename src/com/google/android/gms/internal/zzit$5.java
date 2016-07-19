package com.google.android.gms.internal;

import android.os.RemoteException;
import com.google.android.gms.ads.internal.request.AdRequestInfoParcel;
import com.google.android.gms.ads.internal.request.AdResponseParcel;
import com.google.android.gms.ads.internal.request.zzl;
import com.google.android.gms.ads.internal.zzu;

class zzit$5
  implements Runnable
{
  zzit$5(zzit paramzzit, AdRequestInfoParcel paramAdRequestInfoParcel, zzl paramzzl) {}
  
  public void run()
  {
    try
    {
      AdResponseParcel localAdResponseParcel1 = zzcen.zzd(zzceg);
      localAdResponseParcel2 = localAdResponseParcel1;
      if (localAdResponseParcel1 == null) {
        localAdResponseParcel2 = new AdResponseParcel(0);
      }
    }
    catch (Exception localException)
    {
      for (;;)
      {
        try
        {
          AdResponseParcel localAdResponseParcel2;
          zzceo.zzb(localAdResponseParcel2);
          return;
        }
        catch (RemoteException localRemoteException)
        {
          Object localObject;
          zzkh.zzd("Fail to forward ad response.", localRemoteException);
        }
        localException = localException;
        zzu.zzft().zzb(localException, true);
        zzkh.zzd("Could not fetch ad response due to an Exception.", localException);
        localObject = null;
      }
    }
  }
}

/* Location:
 * Qualified Name:     com.google.android.gms.internal.zzit.5
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */