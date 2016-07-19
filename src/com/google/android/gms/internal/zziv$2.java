package com.google.android.gms.internal;

import java.util.Map;

class zziv$2
  implements zzet
{
  zziv$2(zziv paramzziv) {}
  
  public void zza(zzll paramzzll, Map<String, String> paramMap)
  {
    zziy localzziy;
    synchronized (zziv.zza(zzcew))
    {
      if (zziv.zzb(zzcew).isDone()) {
        return;
      }
      localzziy = new zziy(-2, paramMap);
      if (!zziv.zzc(zzcew).equals(localzziy.getRequestId())) {
        return;
      }
    }
    String str = localzziy.getUrl();
    if (str == null)
    {
      zzkh.zzcy("URL missing in loadAdUrl GMSG.");
      return;
    }
    if (str.contains("%40mediation_adapters%40"))
    {
      paramzzll = str.replaceAll("%40mediation_adapters%40", zzkf.zza(paramzzll.getContext(), (String)paramMap.get("check_adapters"), zziv.zzd(zzcew)));
      localzziy.setUrl(paramzzll);
      paramzzll = String.valueOf(paramzzll);
      if (paramzzll.length() == 0) {
        break label173;
      }
    }
    label173:
    for (paramzzll = "Ad request URL modified to ".concat(paramzzll);; paramzzll = new String("Ad request URL modified to "))
    {
      zzkh.v(paramzzll);
      zziv.zzb(zzcew).zzi(localzziy);
      return;
    }
  }
}

/* Location:
 * Qualified Name:     com.google.android.gms.internal.zziv.2
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */