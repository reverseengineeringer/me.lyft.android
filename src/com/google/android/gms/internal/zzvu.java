package com.google.android.gms.internal;

import android.content.Context;
import android.os.IBinder;
import com.google.android.gms.common.api.GoogleApiClient.ConnectionCallbacks;
import com.google.android.gms.common.api.GoogleApiClient.OnConnectionFailedListener;
import com.google.android.gms.common.internal.zzg;
import com.google.android.gms.common.internal.zzk;

public class zzvu
  extends zzk<zzvt>
{
  public zzvu(Context paramContext, GoogleApiClient.ConnectionCallbacks paramConnectionCallbacks, GoogleApiClient.OnConnectionFailedListener paramOnConnectionFailedListener, zzg paramzzg)
  {
    super(paramContext, paramContext.getMainLooper(), 73, paramzzg, paramConnectionCallbacks, paramOnConnectionFailedListener);
  }
  
  protected zzvt zzkg(IBinder paramIBinder)
  {
    return zzvt.zza.zzkf(paramIBinder);
  }
  
  protected String zzra()
  {
    return "com.google.android.gms.search.service.SEARCH_AUTH_START";
  }
  
  protected String zzrb()
  {
    return "com.google.android.gms.search.internal.ISearchAuthService";
  }
}

/* Location:
 * Qualified Name:     com.google.android.gms.internal.zzvu
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */