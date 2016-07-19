package com.google.android.gms.internal;

import android.view.View;
import com.google.android.gms.ads.internal.zzh;
import com.google.android.gms.dynamic.zzd;
import com.google.android.gms.dynamic.zze;

@zzir
public final class zzdl
  extends zzdn.zza
{
  private final zzh zzbei;
  private final String zzbej;
  private final String zzbek;
  
  public zzdl(zzh paramzzh, String paramString1, String paramString2)
  {
    zzbei = paramzzh;
    zzbej = paramString1;
    zzbek = paramString2;
  }
  
  public String getContent()
  {
    return zzbek;
  }
  
  public void recordClick()
  {
    zzbei.zzei();
  }
  
  public void recordImpression()
  {
    zzbei.zzej();
  }
  
  public void zzi(zzd paramzzd)
  {
    if (paramzzd == null) {
      return;
    }
    zzbei.zzc((View)zze.zzad(paramzzd));
  }
  
  public String zzkk()
  {
    return zzbej;
  }
}

/* Location:
 * Qualified Name:     com.google.android.gms.internal.zzdl
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */