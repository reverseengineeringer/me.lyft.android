package com.google.android.gms.internal;

import android.os.Bundle;
import android.os.DeadObjectException;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.api.Api;
import com.google.android.gms.common.api.Api.zzb;
import com.google.android.gms.common.api.Api.zze;
import com.google.android.gms.common.api.Result;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.internal.zzah;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

public class zzqa
  implements zzqe
{
  private final zzqf tm;
  private boolean tn = false;
  
  public zzqa(zzqf paramzzqf)
  {
    tm = paramzzqf;
  }
  
  private <A extends Api.zzb> void zzf(zzpr.zza<? extends Result, A> paramzza)
    throws DeadObjectException
  {
    tm.sX.ue.zzg(paramzza);
    Api.zze localzze = tm.sX.zzb(paramzza.zzanp());
    if ((!localzze.isConnected()) && (tm.un.containsKey(paramzza.zzanp())))
    {
      paramzza.zzz(new Status(17));
      return;
    }
    Object localObject = localzze;
    if ((localzze instanceof zzah)) {
      localObject = ((zzah)localzze).zzatj();
    }
    paramzza.zzb((Api.zzb)localObject);
  }
  
  public void begin() {}
  
  public void connect()
  {
    if (tn)
    {
      tn = false;
      tm.zza(new zzqf.zza(this)
      {
        public void zzapi()
        {
          zzaur.zzm(null);
        }
      });
    }
  }
  
  public boolean disconnect()
  {
    if (tn) {
      return false;
    }
    if (tm.sX.zzapu())
    {
      tn = true;
      Iterator localIterator = tm.sX.ud.iterator();
      while (localIterator.hasNext()) {
        ((zzrc)localIterator.next()).zzaqt();
      }
      return false;
    }
    tm.zzi(null);
    return true;
  }
  
  public void onConnected(Bundle paramBundle) {}
  
  public void onConnectionSuspended(int paramInt)
  {
    tm.zzi(null);
    tm.ur.zzc(paramInt, tn);
  }
  
  public void zza(ConnectionResult paramConnectionResult, Api<?> paramApi, int paramInt) {}
  
  void zzaph()
  {
    if (tn)
    {
      tn = false;
      tm.sX.ue.release();
      disconnect();
    }
  }
  
  public <A extends Api.zzb, R extends Result, T extends zzpr.zza<R, A>> T zzc(T paramT)
  {
    return zzd(paramT);
  }
  
  public <A extends Api.zzb, T extends zzpr.zza<? extends Result, A>> T zzd(T paramT)
  {
    try
    {
      zzf(paramT);
      return paramT;
    }
    catch (DeadObjectException localDeadObjectException)
    {
      tm.zza(new zzqf.zza(this)
      {
        public void zzapi()
        {
          onConnectionSuspended(1);
        }
      });
    }
    return paramT;
  }
}

/* Location:
 * Qualified Name:     com.google.android.gms.internal.zzqa
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */