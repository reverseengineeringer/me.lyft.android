package com.google.android.gms.internal;

import com.google.android.gms.common.internal.zzaa;

class zzpl$zzb
{
  public final String qM;
  public final long qN;
  public final long qO;
  
  public zzpl$zzb(String paramString, long paramLong1, long paramLong2)
  {
    qM = paramString;
    qN = paramLong1;
    qO = paramLong2;
  }
  
  public boolean equals(Object paramObject)
  {
    if (paramObject == this) {}
    do
    {
      return true;
      if (!(paramObject instanceof zzb)) {
        return false;
      }
      paramObject = (zzb)paramObject;
    } while ((zzaa.equal(qM, qM)) && (zzaa.equal(Long.valueOf(qN), Long.valueOf(qN))) && (zzaa.equal(Long.valueOf(qO), Long.valueOf(qO))));
    return false;
  }
  
  public int hashCode()
  {
    return zzaa.hashCode(new Object[] { qM, Long.valueOf(qN), Long.valueOf(qO) });
  }
}

/* Location:
 * Qualified Name:     com.google.android.gms.internal.zzpl.zzb
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */