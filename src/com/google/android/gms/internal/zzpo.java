package com.google.android.gms.internal;

import com.google.android.gms.common.api.Api;
import com.google.android.gms.common.api.Api.ApiOptions;
import com.google.android.gms.common.api.Api.zzc;
import com.google.android.gms.common.internal.zzaa;

public final class zzpo<O extends Api.ApiOptions>
{
  private final Api<O> pD;
  private final O rF;
  
  public boolean equals(Object paramObject)
  {
    if (paramObject == this) {}
    do
    {
      return true;
      if (!(paramObject instanceof zzpo)) {
        return false;
      }
      paramObject = (zzpo)paramObject;
    } while ((zzaa.equal(pD, pD)) && (zzaa.equal(rF, rF)));
    return false;
  }
  
  public int hashCode()
  {
    return zzaa.hashCode(new Object[] { pD, rF });
  }
  
  public Api.zzc<?> zzanp()
  {
    return pD.zzanp();
  }
  
  public String zzaok()
  {
    return pD.getName();
  }
}

/* Location:
 * Qualified Name:     com.google.android.gms.internal.zzpo
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */