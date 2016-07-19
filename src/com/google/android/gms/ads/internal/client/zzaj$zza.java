package com.google.android.gms.ads.internal.client;

import android.os.Handler;
import android.os.RemoteException;
import com.google.android.gms.ads.internal.util.client.zza;
import com.google.android.gms.ads.internal.util.client.zzb;

class zzaj$zza
  extends zzr.zza
{
  private zzaj$zza(zzaj paramzzaj) {}
  
  public String getMediationAdapterClassName()
    throws RemoteException
  {
    return null;
  }
  
  public boolean isLoading()
    throws RemoteException
  {
    return false;
  }
  
  public void zzf(AdRequestParcel paramAdRequestParcel)
    throws RemoteException
  {
    zzb.e("This app is using a lightweight version of the Google Mobile Ads SDK that requires the latest Google Play services to be installed, but Google Play services is either missing or out of date.");
    zza.zzcnf.post(new Runnable()
    {
      public void run()
      {
        if (zzaj.zza(zzaws) != null) {}
        try
        {
          zzaj.zza(zzaws).onAdFailedToLoad(1);
          return;
        }
        catch (RemoteException localRemoteException)
        {
          zzb.zzd("Could not notify onAdFailedToLoad event.", localRemoteException);
        }
      }
    });
  }
}

/* Location:
 * Qualified Name:     com.google.android.gms.ads.internal.client.zzaj.zza
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */