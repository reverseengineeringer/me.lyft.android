package com.google.android.gms.common.api;

import android.support.v4.util.ArrayMap;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.internal.zzpo;

public class zza
  extends zzb
{
  private final ConnectionResult rv;
  
  public zza(Status paramStatus, ArrayMap<zzpo<?>, ConnectionResult> paramArrayMap)
  {
    super(paramStatus, paramArrayMap);
    rv = ((ConnectionResult)paramArrayMap.get(paramArrayMap.keyAt(0)));
  }
}

/* Location:
 * Qualified Name:     com.google.android.gms.common.api.zza
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */