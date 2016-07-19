package com.google.android.gms.common.api;

import android.support.v4.util.ArrayMap;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.internal.zzpo;

public class zzb
  implements Result
{
  private final Status cc;
  private final ArrayMap<zzpo<?>, ConnectionResult> rw;
  
  public zzb(Status paramStatus, ArrayMap<zzpo<?>, ConnectionResult> paramArrayMap)
  {
    cc = paramStatus;
    rw = paramArrayMap;
  }
  
  public Status getStatus()
  {
    return cc;
  }
}

/* Location:
 * Qualified Name:     com.google.android.gms.common.api.zzb
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */