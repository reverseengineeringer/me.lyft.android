package com.google.android.gms.measurement.internal;

import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.util.Pair;
import com.google.android.gms.common.internal.zzab;
import com.google.android.gms.common.util.zze;
import java.security.SecureRandom;

public final class zzt$zzc
{
  final String alO;
  private final String alP;
  private final String alQ;
  private final long ap;
  
  private zzt$zzc(zzt paramzzt, String paramString, long paramLong)
  {
    zzab.zzhs(paramString);
    if (paramLong > 0L) {}
    for (boolean bool = true;; bool = false)
    {
      zzab.zzbn(bool);
      alO = String.valueOf(paramString).concat(":start");
      alP = String.valueOf(paramString).concat(":count");
      alQ = String.valueOf(paramString).concat(":value");
      ap = paramLong;
      return;
    }
  }
  
  private void zzadt()
  {
    alM.zzwu();
    long l = alM.zzyw().currentTimeMillis();
    SharedPreferences.Editor localEditor = zzt.zza(alM).edit();
    localEditor.remove(alP);
    localEditor.remove(alQ);
    localEditor.putLong(alO, l);
    localEditor.apply();
  }
  
  private long zzadu()
  {
    alM.zzwu();
    long l = zzadw();
    if (l == 0L)
    {
      zzadt();
      return 0L;
    }
    return Math.abs(l - alM.zzyw().currentTimeMillis());
  }
  
  private long zzadw()
  {
    return zzt.zzc(alM).getLong(alO, 0L);
  }
  
  public Pair<String, Long> zzadv()
  {
    alM.zzwu();
    long l = zzadu();
    if (l < ap) {
      return null;
    }
    if (l > ap * 2L)
    {
      zzadt();
      return null;
    }
    String str = zzt.zzc(alM).getString(alQ, null);
    l = zzt.zzc(alM).getLong(alP, 0L);
    zzadt();
    if ((str == null) || (l <= 0L)) {
      return zzt.alt;
    }
    return new Pair(str, Long.valueOf(l));
  }
  
  public void zzew(String paramString)
  {
    zzg(paramString, 1L);
  }
  
  public void zzg(String paramString, long paramLong)
  {
    alM.zzwu();
    if (zzadw() == 0L) {
      zzadt();
    }
    String str = paramString;
    if (paramString == null) {
      str = "";
    }
    long l = zzt.zza(alM).getLong(alP, 0L);
    if (l <= 0L)
    {
      paramString = zzt.zza(alM).edit();
      paramString.putString(alQ, str);
      paramString.putLong(alP, paramLong);
      paramString.apply();
      return;
    }
    if ((zzt.zzb(alM).nextLong() & 0x7FFFFFFFFFFFFFFF) < Long.MAX_VALUE / (l + paramLong) * paramLong) {}
    for (int i = 1;; i = 0)
    {
      paramString = zzt.zza(alM).edit();
      if (i != 0) {
        paramString.putString(alQ, str);
      }
      paramString.putLong(alP, l + paramLong);
      paramString.apply();
      return;
    }
  }
}

/* Location:
 * Qualified Name:     com.google.android.gms.measurement.internal.zzt.zzc
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */