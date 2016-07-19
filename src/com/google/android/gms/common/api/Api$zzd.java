package com.google.android.gms.common.api;

import java.util.Collections;
import java.util.List;

public abstract class Api$zzd<T extends Api.zzb, O>
{
  public int getPriority()
  {
    return Integer.MAX_VALUE;
  }
  
  public List<Scope> zzq(O paramO)
  {
    return Collections.emptyList();
  }
}

/* Location:
 * Qualified Name:     com.google.android.gms.common.api.Api.zzd
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */