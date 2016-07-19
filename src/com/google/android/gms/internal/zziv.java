package com.google.android.gms.internal;

import java.util.Map;
import java.util.concurrent.Future;

@zzir
public final class zziv
{
  private final Object zzail = new Object();
  private String zzbvu;
  private String zzceq;
  private zzkz<zziy> zzcer = new zzkz();
  zzfw.zzc zzces;
  public final zzet zzcet = new zzet()
  {
    public void zza(zzll arg1, Map<String, String> paramAnonymousMap)
    {
      synchronized (zziv.zza(zziv.this))
      {
        if (zziv.zzb(zziv.this).isDone()) {
          return;
        }
        if (!zziv.zzc(zziv.this).equals(paramAnonymousMap.get("request_id"))) {
          return;
        }
      }
      paramAnonymousMap = new zziy(1, paramAnonymousMap);
      String str1 = String.valueOf(paramAnonymousMap.getType());
      String str2 = String.valueOf(paramAnonymousMap.zzrk());
      zzkh.zzcy(String.valueOf(str1).length() + 24 + String.valueOf(str2).length() + "Invalid " + str1 + " request error: " + str2);
      zziv.zzb(zziv.this).zzi(paramAnonymousMap);
    }
  };
  public final zzet zzceu = new zzet()
  {
    public void zza(zzll paramAnonymouszzll, Map<String, String> paramAnonymousMap)
    {
      zziy localzziy;
      synchronized (zziv.zza(zziv.this))
      {
        if (zziv.zzb(zziv.this).isDone()) {
          return;
        }
        localzziy = new zziy(-2, paramAnonymousMap);
        if (!zziv.zzc(zziv.this).equals(localzziy.getRequestId())) {
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
        paramAnonymouszzll = str.replaceAll("%40mediation_adapters%40", zzkf.zza(paramAnonymouszzll.getContext(), (String)paramAnonymousMap.get("check_adapters"), zziv.zzd(zziv.this)));
        localzziy.setUrl(paramAnonymouszzll);
        paramAnonymouszzll = String.valueOf(paramAnonymouszzll);
        if (paramAnonymouszzll.length() == 0) {
          break label173;
        }
      }
      label173:
      for (paramAnonymouszzll = "Ad request URL modified to ".concat(paramAnonymouszzll);; paramAnonymouszzll = new String("Ad request URL modified to "))
      {
        zzkh.v(paramAnonymouszzll);
        zziv.zzb(zziv.this).zzi(localzziy);
        return;
      }
    }
  };
  public final zzet zzcev = new zzet()
  {
    public void zza(zzll arg1, Map<String, String> paramAnonymousMap)
    {
      synchronized (zziv.zza(zziv.this))
      {
        if (zziv.zzb(zziv.this).isDone()) {
          return;
        }
        paramAnonymousMap = new zziy(-2, paramAnonymousMap);
        if (!zziv.zzc(zziv.this).equals(paramAnonymousMap.getRequestId())) {
          return;
        }
      }
      paramAnonymousMap.zzrn();
      zziv.zzb(zziv.this).zzi(paramAnonymousMap);
    }
  };
  
  public zziv(String paramString1, String paramString2)
  {
    zzceq = paramString2;
    zzbvu = paramString1;
  }
  
  public void zzb(zzfw.zzc paramzzc)
  {
    zzces = paramzzc;
  }
  
  public zzfw.zzc zzrh()
  {
    return zzces;
  }
  
  public Future<zziy> zzri()
  {
    return zzcer;
  }
  
  public void zzrj() {}
}

/* Location:
 * Qualified Name:     com.google.android.gms.internal.zziv
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */