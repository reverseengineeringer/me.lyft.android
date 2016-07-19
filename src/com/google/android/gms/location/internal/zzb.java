package com.google.android.gms.location.internal;

import android.content.Context;
import android.os.Bundle;
import android.os.DeadObjectException;
import android.os.IBinder;
import android.os.Looper;
import com.google.android.gms.common.api.GoogleApiClient.ConnectionCallbacks;
import com.google.android.gms.common.api.GoogleApiClient.OnConnectionFailedListener;
import com.google.android.gms.common.internal.zzg;
import com.google.android.gms.common.internal.zzk;

public class zzb
  extends zzk<zzi>
{
  private final String adx;
  protected final zzp<zzi> ady = new zzp()
  {
    public void zzarv()
    {
      zzb.zza(zzb.this);
    }
    
    public zzi zzbnj()
      throws DeadObjectException
    {
      return (zzi)zzb.this.zzarw();
    }
  };
  
  public zzb(Context paramContext, Looper paramLooper, GoogleApiClient.ConnectionCallbacks paramConnectionCallbacks, GoogleApiClient.OnConnectionFailedListener paramOnConnectionFailedListener, String paramString, zzg paramzzg)
  {
    super(paramContext, paramLooper, 23, paramzzg, paramConnectionCallbacks, paramOnConnectionFailedListener);
    adx = paramString;
  }
  
  protected Bundle zzaeu()
  {
    Bundle localBundle = new Bundle();
    localBundle.putString("client_name", adx);
    return localBundle;
  }
  
  protected zzi zzgt(IBinder paramIBinder)
  {
    return zzi.zza.zzgw(paramIBinder);
  }
  
  protected String zzra()
  {
    return "com.google.android.location.internal.GoogleLocationManagerService.START";
  }
  
  protected String zzrb()
  {
    return "com.google.android.gms.location.internal.IGoogleLocationManagerService";
  }
}

/* Location:
 * Qualified Name:     com.google.android.gms.location.internal.zzb
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */