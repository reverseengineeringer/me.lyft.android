package com.google.android.gms.measurement.internal;

import android.support.v4.util.ArrayMap;
import com.google.android.gms.common.internal.zzab;
import com.google.android.gms.internal.zzaou;
import com.google.android.gms.internal.zzaov;
import com.google.android.gms.internal.zzuo.zza;
import com.google.android.gms.internal.zzuo.zzb;
import com.google.android.gms.internal.zzuo.zzc;
import com.google.android.gms.measurement.AppMeasurement.zza;
import java.io.IOException;
import java.util.Map;

public class zzv
  extends zzaa
{
  private final Map<String, Map<String, String>> alR = new ArrayMap();
  private final Map<String, Map<String, Boolean>> alS = new ArrayMap();
  private final Map<String, Map<String, Boolean>> alT = new ArrayMap();
  private final Map<String, zzuo.zzb> alU = new ArrayMap();
  private final Map<String, String> alV = new ArrayMap();
  
  zzv(zzx paramzzx)
  {
    super(paramzzx);
  }
  
  private Map<String, String> zza(zzuo.zzb paramzzb)
  {
    ArrayMap localArrayMap = new ArrayMap();
    if ((paramzzb != null) && (aoB != null))
    {
      paramzzb = aoB;
      int j = paramzzb.length;
      int i = 0;
      while (i < j)
      {
        Object localObject = paramzzb[i];
        if (localObject != null) {
          localArrayMap.put(zzcb, value);
        }
        i += 1;
      }
    }
    return localArrayMap;
  }
  
  private void zza(String paramString, zzuo.zzb paramzzb)
  {
    ArrayMap localArrayMap1 = new ArrayMap();
    ArrayMap localArrayMap2 = new ArrayMap();
    if ((paramzzb != null) && (aoC != null))
    {
      paramzzb = aoC;
      int j = paramzzb.length;
      int i = 0;
      while (i < j)
      {
        Object localObject = paramzzb[i];
        if (localObject != null)
        {
          String str = (String)AppMeasurement.zza.ajb.get(name);
          if (str != null) {
            name = str;
          }
          localArrayMap1.put(name, aox);
          localArrayMap2.put(name, aoy);
        }
        i += 1;
      }
    }
    alS.put(paramString, localArrayMap1);
    alT.put(paramString, localArrayMap2);
  }
  
  private zzuo.zzb zze(String paramString, byte[] paramArrayOfByte)
  {
    if (paramArrayOfByte == null) {
      return new zzuo.zzb();
    }
    Object localObject = zzaou.zzaz(paramArrayOfByte);
    paramArrayOfByte = new zzuo.zzb();
    try
    {
      localObject = (zzuo.zzb)paramArrayOfByte.zzb((zzaou)localObject);
      zzbsz().zzbty().zze("Parsed config. version, gmp_app_id", aoz, ajz);
      return paramArrayOfByte;
    }
    catch (IOException paramArrayOfByte)
    {
      zzbsz().zzbtt().zze("Unable to merge remote config", paramString, paramArrayOfByte);
    }
    return null;
  }
  
  private void zzmb(String paramString)
  {
    zzzg();
    zzwu();
    zzab.zzhs(paramString);
    if (!alU.containsKey(paramString))
    {
      localObject = zzbsu().zzlq(paramString);
      if (localObject == null)
      {
        alR.put(paramString, null);
        alS.put(paramString, null);
        alT.put(paramString, null);
        alU.put(paramString, null);
        alV.put(paramString, null);
      }
    }
    else
    {
      return;
    }
    Object localObject = zze(paramString, (byte[])localObject);
    alR.put(paramString, zza((zzuo.zzb)localObject));
    zza(paramString, (zzuo.zzb)localObject);
    alU.put(paramString, localObject);
    alV.put(paramString, null);
  }
  
  String zzaw(String paramString1, String paramString2)
  {
    zzwu();
    zzmb(paramString1);
    paramString1 = (Map)alR.get(paramString1);
    if (paramString1 != null) {
      return (String)paramString1.get(paramString2);
    }
    return null;
  }
  
  boolean zzax(String paramString1, String paramString2)
  {
    zzwu();
    zzmb(paramString1);
    paramString1 = (Map)alS.get(paramString1);
    if (paramString1 != null)
    {
      paramString1 = (Boolean)paramString1.get(paramString2);
      if (paramString1 == null) {
        return false;
      }
      return paramString1.booleanValue();
    }
    return false;
  }
  
  boolean zzay(String paramString1, String paramString2)
  {
    zzwu();
    zzmb(paramString1);
    paramString1 = (Map)alT.get(paramString1);
    if (paramString1 != null)
    {
      paramString1 = (Boolean)paramString1.get(paramString2);
      if (paramString1 == null) {
        return false;
      }
      return paramString1.booleanValue();
    }
    return false;
  }
  
  protected boolean zzb(String paramString1, byte[] paramArrayOfByte, String paramString2)
  {
    zzzg();
    zzwu();
    zzab.zzhs(paramString1);
    zzuo.zzb localzzb = zze(paramString1, paramArrayOfByte);
    if (localzzb == null) {
      return false;
    }
    zza(paramString1, localzzb);
    alU.put(paramString1, localzzb);
    alV.put(paramString1, paramString2);
    alR.put(paramString1, zza(localzzb));
    zzbsp().zza(paramString1, aoD);
    try
    {
      aoD = null;
      paramString2 = new byte[localzzb.ao()];
      localzzb.zza(zzaov.zzba(paramString2));
      paramArrayOfByte = paramString2;
    }
    catch (IOException paramString2)
    {
      for (;;)
      {
        zzbsz().zzbtt().zzj("Unable to serialize reduced-size config.  Storing full config instead.", paramString2);
      }
    }
    zzbsu().zzd(paramString1, paramArrayOfByte);
    return true;
  }
  
  protected zzuo.zzb zzmc(String paramString)
  {
    zzzg();
    zzwu();
    zzab.zzhs(paramString);
    zzmb(paramString);
    return (zzuo.zzb)alU.get(paramString);
  }
  
  protected String zzmd(String paramString)
  {
    zzwu();
    return (String)alV.get(paramString);
  }
  
  protected void zzme(String paramString)
  {
    zzwu();
    alV.put(paramString, null);
  }
  
  protected void zzwv() {}
}

/* Location:
 * Qualified Name:     com.google.android.gms.measurement.internal.zzv
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */