package com.google.android.gms.internal;

import android.text.TextUtils;
import com.google.android.gms.ads.internal.zzu;
import com.google.android.gms.common.util.zze;
import java.util.Map;

@zzir
public final class zzeq
  implements zzet
{
  private void zzb(zzll paramzzll, Map<String, String> paramMap)
  {
    String str2 = (String)paramMap.get("label");
    String str1 = (String)paramMap.get("start_label");
    paramMap = (String)paramMap.get("timestamp");
    if (TextUtils.isEmpty(str2))
    {
      zzkh.zzcy("No label given for CSI tick.");
      return;
    }
    if (TextUtils.isEmpty(paramMap))
    {
      zzkh.zzcy("No timestamp given for CSI tick.");
      return;
    }
    try
    {
      long l = zzd(Long.parseLong(paramMap));
      paramMap = str1;
      if (TextUtils.isEmpty(str1)) {
        paramMap = "native:view_load";
      }
      paramzzll.zzut().zza(str2, paramMap, l);
      return;
    }
    catch (NumberFormatException paramzzll)
    {
      zzkh.zzd("Malformed timestamp for CSI tick.", paramzzll);
    }
  }
  
  private void zzc(zzll paramzzll, Map<String, String> paramMap)
  {
    paramMap = (String)paramMap.get("value");
    if (TextUtils.isEmpty(paramMap))
    {
      zzkh.zzcy("No value given for CSI experiment.");
      return;
    }
    paramzzll = paramzzll.zzut().zzkf();
    if (paramzzll == null)
    {
      zzkh.zzcy("No ticker for WebView, dropping experiment ID.");
      return;
    }
    paramzzll.zzh("e", paramMap);
  }
  
  private long zzd(long paramLong)
  {
    return paramLong - zzu.zzfu().currentTimeMillis() + zzu.zzfu().elapsedRealtime();
  }
  
  private void zzd(zzll paramzzll, Map<String, String> paramMap)
  {
    String str = (String)paramMap.get("name");
    paramMap = (String)paramMap.get("value");
    if (TextUtils.isEmpty(paramMap))
    {
      zzkh.zzcy("No value given for CSI extra.");
      return;
    }
    if (TextUtils.isEmpty(str))
    {
      zzkh.zzcy("No name given for CSI extra.");
      return;
    }
    paramzzll = paramzzll.zzut().zzkf();
    if (paramzzll == null)
    {
      zzkh.zzcy("No ticker for WebView, dropping extra parameter.");
      return;
    }
    paramzzll.zzh(str, paramMap);
  }
  
  public void zza(zzll paramzzll, Map<String, String> paramMap)
  {
    String str = (String)paramMap.get("action");
    if ("tick".equals(str)) {
      zzb(paramzzll, paramMap);
    }
    do
    {
      return;
      if ("experiment".equals(str))
      {
        zzc(paramzzll, paramMap);
        return;
      }
    } while (!"extra".equals(str));
    zzd(paramzzll, paramMap);
  }
}

/* Location:
 * Qualified Name:     com.google.android.gms.internal.zzeq
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */