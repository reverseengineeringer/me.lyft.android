package com.google.android.gms.internal;

import android.os.DeadObjectException;
import android.os.RemoteException;
import com.google.android.gms.common.api.Api;
import com.google.android.gms.common.api.Api.zzb;
import com.google.android.gms.common.api.Api.zzc;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.Result;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.internal.zzab;
import java.util.concurrent.atomic.AtomicReference;

public class zzpr
{
  public static abstract class zza<R extends Result, A extends Api.zzb>
    extends zzpt<R>
    implements zzpr.zzb<R>
  {
    private final Api<?> pD;
    private AtomicReference<zzrd.zzb> sA = new AtomicReference();
    private final Api.zzc<A> sz;
    
    protected zza(Api<?> paramApi, GoogleApiClient paramGoogleApiClient)
    {
      super();
      sz = paramApi.zzanp();
      pD = paramApi;
    }
    
    private void zza(RemoteException paramRemoteException)
    {
      zzz(new Status(8, paramRemoteException.getLocalizedMessage(), null));
    }
    
    protected abstract void zza(A paramA)
      throws RemoteException;
    
    public void zza(zzrd.zzb paramzzb)
    {
      sA.set(paramzzb);
    }
    
    public final Api.zzc<A> zzanp()
    {
      return sz;
    }
    
    public final Api<?> zzanw()
    {
      return pD;
    }
    
    public void zzaoo()
    {
      setResultCallback(null);
    }
    
    protected void zzaop()
    {
      zzrd.zzb localzzb = (zzrd.zzb)sA.getAndSet(null);
      if (localzzb != null) {
        localzzb.zzh(this);
      }
    }
    
    public final void zzb(A paramA)
      throws DeadObjectException
    {
      try
      {
        zza(paramA);
        return;
      }
      catch (DeadObjectException paramA)
      {
        zza(paramA);
        throw paramA;
      }
      catch (RemoteException paramA)
      {
        zza(paramA);
      }
    }
    
    protected void zzb(R paramR) {}
    
    public final void zzz(Status paramStatus)
    {
      if (!paramStatus.isSuccess()) {}
      for (boolean bool = true;; bool = false)
      {
        zzab.zzb(bool, "Failed result must not be success");
        paramStatus = zzc(paramStatus);
        zzc(paramStatus);
        zzb(paramStatus);
        return;
      }
    }
  }
  
  public static abstract interface zzb<R>
  {
    public abstract void setResult(R paramR);
  }
}

/* Location:
 * Qualified Name:     com.google.android.gms.internal.zzpr
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */