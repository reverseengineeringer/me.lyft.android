package com.google.android.gms.internal;

import android.os.Bundle;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.api.Api;
import com.google.android.gms.common.api.Api.zzb;
import com.google.android.gms.common.api.Result;
import java.util.Collections;
import java.util.Queue;

public class zzqc
  implements zzqe
{
  private final zzqf tm;
  
  public zzqc(zzqf paramzzqf)
  {
    tm = paramzzqf;
  }
  
  public void begin()
  {
    tm.zzapy();
    tm.sX.tZ = Collections.emptySet();
  }
  
  public void connect()
  {
    tm.zzapw();
  }
  
  public boolean disconnect()
  {
    return true;
  }
  
  public void onConnected(Bundle paramBundle) {}
  
  public void onConnectionSuspended(int paramInt) {}
  
  public void zza(ConnectionResult paramConnectionResult, Api<?> paramApi, int paramInt) {}
  
  public <A extends Api.zzb, R extends Result, T extends zzpr.zza<R, A>> T zzc(T paramT)
  {
    tm.sX.tS.add(paramT);
    return paramT;
  }
  
  public <A extends Api.zzb, T extends zzpr.zza<? extends Result, A>> T zzd(T paramT)
  {
    throw new IllegalStateException("GoogleApiClient is not connected yet.");
  }
}

/* Location:
 * Qualified Name:     com.google.android.gms.internal.zzqc
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */