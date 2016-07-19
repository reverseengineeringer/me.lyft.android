package com.google.android.gms.wearable.internal;

import com.google.android.gms.common.api.Status;
import com.google.android.gms.internal.zzpr.zzb;
import com.google.android.gms.wearable.DataApi.DeleteDataItemsResult;

final class zzbo
{
  static abstract class zzb<T>
    extends zza
  {
    private zzpr.zzb<T> bF;
    
    public zzb(zzpr.zzb<T> paramzzb)
    {
      bF = paramzzb;
    }
    
    public void zzba(T paramT)
    {
      zzpr.zzb localzzb = bF;
      if (localzzb != null)
      {
        localzzb.setResult(paramT);
        bF = null;
      }
    }
  }
  
  static final class zze
    extends zzbo.zzb<DataApi.DeleteDataItemsResult>
  {
    public zze(zzpr.zzb<DataApi.DeleteDataItemsResult> paramzzb)
    {
      super();
    }
    
    public void zza(DeleteDataItemsResponse paramDeleteDataItemsResponse)
    {
      zzba(new zzx.zzb(zzbk.zzps(statusCode), aKC));
    }
  }
  
  static final class zzo
    extends zza
  {
    public void zza(Status paramStatus) {}
  }
}

/* Location:
 * Qualified Name:     com.google.android.gms.wearable.internal.zzbo
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */