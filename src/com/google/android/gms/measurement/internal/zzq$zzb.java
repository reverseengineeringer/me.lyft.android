package com.google.android.gms.measurement.internal;

import com.google.android.gms.common.internal.zzab;
import java.util.List;
import java.util.Map;

class zzq$zzb
  implements Runnable
{
  private final String aQ;
  private final zzq.zza ala;
  private final Throwable alb;
  private final byte[] alc;
  private final Map<String, List<String>> ald;
  private final int zzblz;
  
  private zzq$zzb(String paramString, zzq.zza paramzza, int paramInt, Throwable paramThrowable, byte[] paramArrayOfByte, Map<String, List<String>> paramMap)
  {
    zzab.zzaa(paramzza);
    ala = paramzza;
    zzblz = paramInt;
    alb = paramThrowable;
    alc = paramArrayOfByte;
    aQ = paramString;
    ald = paramMap;
  }
  
  public void run()
  {
    ala.zza(aQ, zzblz, alb, alc, ald);
  }
}

/* Location:
 * Qualified Name:     com.google.android.gms.measurement.internal.zzq.zzb
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */