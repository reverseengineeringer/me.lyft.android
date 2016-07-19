package com.google.android.gms.common.api;

import com.google.android.gms.common.internal.zzab;

public class BooleanResult
  implements Result
{
  private final Status cc;
  private final boolean rD;
  
  public BooleanResult(Status paramStatus, boolean paramBoolean)
  {
    cc = ((Status)zzab.zzb(paramStatus, "Status must not be null"));
    rD = paramBoolean;
  }
  
  public final boolean equals(Object paramObject)
  {
    if (paramObject == this) {}
    do
    {
      return true;
      if (!(paramObject instanceof BooleanResult)) {
        return false;
      }
      paramObject = (BooleanResult)paramObject;
    } while ((cc.equals(cc)) && (rD == rD));
    return false;
  }
  
  public Status getStatus()
  {
    return cc;
  }
  
  public boolean getValue()
  {
    return rD;
  }
  
  public final int hashCode()
  {
    int j = cc.hashCode();
    if (rD) {}
    for (int i = 1;; i = 0) {
      return i + (j + 527) * 31;
    }
  }
}

/* Location:
 * Qualified Name:     com.google.android.gms.common.api.BooleanResult
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */