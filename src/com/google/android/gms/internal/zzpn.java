package com.google.android.gms.internal;

import android.os.DeadObjectException;
import android.util.SparseArray;
import com.google.android.gms.common.api.Api.zzb;
import com.google.android.gms.common.api.Result;
import com.google.android.gms.common.api.Status;

public abstract class zzpn
{
  public final int it;
  public final int sn;
  
  public boolean cancel()
  {
    return true;
  }
  
  public void zza(SparseArray<zzrd> paramSparseArray) {}
  
  public abstract void zzb(Api.zzb paramzzb)
    throws DeadObjectException;
  
  public abstract void zzx(Status paramStatus);
  
  public static final class zza
    extends zzpn
  {
    public final zzpr.zza<? extends Result, Api.zzb> so;
    
    public boolean cancel()
    {
      return so.zzaos();
    }
    
    public void zza(SparseArray<zzrd> paramSparseArray)
    {
      paramSparseArray = (zzrd)paramSparseArray.get(sn);
      if (paramSparseArray != null) {
        paramSparseArray.zzg(so);
      }
    }
    
    public void zzb(Api.zzb paramzzb)
      throws DeadObjectException
    {
      so.zzb(paramzzb);
    }
    
    public void zzx(Status paramStatus)
    {
      so.zzz(paramStatus);
    }
  }
}

/* Location:
 * Qualified Name:     com.google.android.gms.internal.zzpn
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */