package com.google.android.gms.ads.internal.client;

import android.os.Handler;
import android.os.RemoteException;
import com.google.android.gms.ads.internal.formats.NativeAdOptionsParcel;
import com.google.android.gms.ads.internal.util.client.zza;
import com.google.android.gms.ads.internal.util.client.zzb;
import com.google.android.gms.internal.zzee;
import com.google.android.gms.internal.zzef;
import com.google.android.gms.internal.zzeg;
import com.google.android.gms.internal.zzeh;

public class zzaj
  extends zzs.zza
{
  private zzq zzald;
  
  public void zza(NativeAdOptionsParcel paramNativeAdOptionsParcel)
    throws RemoteException
  {}
  
  public void zza(zzee paramzzee)
    throws RemoteException
  {}
  
  public void zza(zzef paramzzef)
    throws RemoteException
  {}
  
  public void zza(String paramString, zzeh paramzzeh, zzeg paramzzeg)
    throws RemoteException
  {}
  
  public void zzb(zzq paramzzq)
    throws RemoteException
  {
    zzald = paramzzq;
  }
  
  public void zzb(zzy paramzzy)
    throws RemoteException
  {}
  
  public zzr zzes()
    throws RemoteException
  {
    return new zza(null);
  }
  
  private class zza
    extends zzr.zza
  {
    private zza() {}
    
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
          if (zzaj.zza(zzaj.this) != null) {}
          try
          {
            zzaj.zza(zzaj.this).onAdFailedToLoad(1);
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
}

/* Location:
 * Qualified Name:     com.google.android.gms.ads.internal.client.zzaj
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */