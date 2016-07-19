package com.google.android.gms.internal;

import android.content.Context;
import android.net.Uri;
import android.view.MotionEvent;
import com.google.android.gms.ads.identifier.AdvertisingIdClient.Info;
import com.google.android.gms.dynamic.zzd;
import com.google.android.gms.dynamic.zze;

public final class zzby
  extends zzca.zza
{
  private final zzar zzaiq;
  private final zzas zzair;
  private final zzap zzais;
  private boolean zzait = false;
  
  public zzby(String paramString, Context paramContext, boolean paramBoolean)
  {
    zzaiq = zzar.zza(paramString, paramContext, paramBoolean);
    zzair = new zzas(zzaiq);
    if (paramBoolean) {}
    for (paramString = null;; paramString = zzap.zze(paramContext))
    {
      zzais = paramString;
      return;
    }
  }
  
  private zzd zza(zzd paramzzd1, zzd paramzzd2, boolean paramBoolean)
  {
    try
    {
      paramzzd1 = (Uri)zze.zzad(paramzzd1);
      paramzzd2 = (Context)zze.zzad(paramzzd2);
      if (paramBoolean) {}
      for (paramzzd1 = zzair.zza(paramzzd1, paramzzd2);; paramzzd1 = zzair.zzb(paramzzd1, paramzzd2)) {
        return zze.zzae(paramzzd1);
      }
      return null;
    }
    catch (zzat paramzzd1) {}
  }
  
  public zzd zza(zzd paramzzd1, zzd paramzzd2)
  {
    return zza(paramzzd1, paramzzd2, true);
  }
  
  public String zza(zzd paramzzd, String paramString)
  {
    paramzzd = (Context)zze.zzad(paramzzd);
    return zzaiq.zzb(paramzzd, paramString);
  }
  
  public boolean zza(zzd paramzzd)
  {
    paramzzd = (Uri)zze.zzad(paramzzd);
    return zzair.zza(paramzzd);
  }
  
  public zzd zzb(zzd paramzzd1, zzd paramzzd2)
  {
    return zza(paramzzd1, paramzzd2, false);
  }
  
  public void zzb(String paramString1, String paramString2)
  {
    zzair.zzb(paramString1, paramString2);
  }
  
  public boolean zzb(zzd paramzzd)
  {
    paramzzd = (Uri)zze.zzad(paramzzd);
    return zzair.zzc(paramzzd);
  }
  
  public boolean zzb(String paramString, boolean paramBoolean)
  {
    if (zzais == null) {
      return false;
    }
    paramString = new AdvertisingIdClient.Info(paramString, paramBoolean);
    zzais.zza(paramString);
    zzait = true;
    return true;
  }
  
  public String zzc(zzd paramzzd)
  {
    Object localObject = (Context)zze.zzad(paramzzd);
    paramzzd = zzaiq.zzb((Context)localObject);
    if ((zzais != null) && (zzait))
    {
      localObject = zzais.zzb((Context)localObject);
      paramzzd = zzais.zza(paramzzd, (String)localObject);
      zzait = false;
      return paramzzd;
    }
    return paramzzd;
  }
  
  public void zzd(zzd paramzzd)
  {
    paramzzd = (MotionEvent)zze.zzad(paramzzd);
    zzair.zza(paramzzd);
  }
  
  public String zzdg()
  {
    return "ms";
  }
  
  public void zzk(String paramString)
  {
    zzair.zzk(paramString);
  }
}

/* Location:
 * Qualified Name:     com.google.android.gms.internal.zzby
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */