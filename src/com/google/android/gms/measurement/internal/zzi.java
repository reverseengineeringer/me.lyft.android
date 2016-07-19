package com.google.android.gms.measurement.internal;

import com.google.android.gms.common.internal.zzab;

class zzi
{
  final long ajZ;
  final long aka;
  final long akb;
  final String mName;
  final String zzcjj;
  
  zzi(String paramString1, String paramString2, long paramLong1, long paramLong2, long paramLong3)
  {
    zzab.zzhs(paramString1);
    zzab.zzhs(paramString2);
    if (paramLong1 >= 0L)
    {
      bool1 = true;
      zzab.zzbn(bool1);
      if (paramLong2 < 0L) {
        break label81;
      }
    }
    label81:
    for (boolean bool1 = bool2;; bool1 = false)
    {
      zzab.zzbn(bool1);
      zzcjj = paramString1;
      mName = paramString2;
      ajZ = paramLong1;
      aka = paramLong2;
      akb = paramLong3;
      return;
      bool1 = false;
      break;
    }
  }
  
  zzi zzbi(long paramLong)
  {
    return new zzi(zzcjj, mName, ajZ, aka, paramLong);
  }
  
  zzi zzbtn()
  {
    return new zzi(zzcjj, mName, ajZ + 1L, aka + 1L, akb);
  }
}

/* Location:
 * Qualified Name:     com.google.android.gms.measurement.internal.zzi
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */