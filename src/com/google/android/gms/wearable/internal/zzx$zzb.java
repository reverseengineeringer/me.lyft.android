package com.google.android.gms.wearable.internal;

import com.google.android.gms.common.api.Status;
import com.google.android.gms.wearable.DataApi.DeleteDataItemsResult;

public class zzx$zzb
  implements DataApi.DeleteDataItemsResult
{
  private final int aKz;
  private final Status cc;
  
  public zzx$zzb(Status paramStatus, int paramInt)
  {
    cc = paramStatus;
    aKz = paramInt;
  }
  
  public Status getStatus()
  {
    return cc;
  }
}

/* Location:
 * Qualified Name:     com.google.android.gms.wearable.internal.zzx.zzb
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */