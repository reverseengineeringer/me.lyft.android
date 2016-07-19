package com.google.android.gms.internal;

import android.content.Context;
import android.os.IBinder;
import android.os.Looper;
import android.os.RemoteException;
import com.google.android.gms.clearcut.LogEventParcelable;
import com.google.android.gms.common.api.GoogleApiClient.ConnectionCallbacks;
import com.google.android.gms.common.api.GoogleApiClient.OnConnectionFailedListener;
import com.google.android.gms.common.internal.zzg;
import com.google.android.gms.common.internal.zzk;

public class zzph
  extends zzk<zzpk>
{
  public zzph(Context paramContext, Looper paramLooper, zzg paramzzg, GoogleApiClient.ConnectionCallbacks paramConnectionCallbacks, GoogleApiClient.OnConnectionFailedListener paramOnConnectionFailedListener)
  {
    super(paramContext, paramLooper, 40, paramzzg, paramConnectionCallbacks, paramOnConnectionFailedListener);
  }
  
  public void zza(zzpj paramzzpj, LogEventParcelable paramLogEventParcelable)
    throws RemoteException
  {
    ((zzpk)zzarw()).zza(paramzzpj, paramLogEventParcelable);
  }
  
  protected zzpk zzdk(IBinder paramIBinder)
  {
    return zzpk.zza.zzdm(paramIBinder);
  }
  
  protected String zzra()
  {
    return "com.google.android.gms.clearcut.service.START";
  }
  
  protected String zzrb()
  {
    return "com.google.android.gms.clearcut.internal.IClearcutLoggerService";
  }
}

/* Location:
 * Qualified Name:     com.google.android.gms.internal.zzph
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */