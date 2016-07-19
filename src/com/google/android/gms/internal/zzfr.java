package com.google.android.gms.internal;

import android.content.Context;
import android.os.Bundle;
import android.os.RemoteException;
import com.google.android.gms.ads.internal.client.AdRequestParcel;
import com.google.android.gms.ads.internal.client.AdSizeParcel;
import com.google.android.gms.ads.internal.client.VideoOptionsParcel;
import com.google.android.gms.ads.internal.client.zzab;
import com.google.android.gms.ads.internal.client.zzp;
import com.google.android.gms.ads.internal.client.zzq;
import com.google.android.gms.ads.internal.client.zzu.zza;
import com.google.android.gms.ads.internal.client.zzw;
import com.google.android.gms.ads.internal.client.zzy;
import com.google.android.gms.ads.internal.util.client.VersionInfoParcel;
import com.google.android.gms.ads.internal.zzl;
import com.google.android.gms.ads.internal.zzu;

@zzir
public class zzfr
  extends zzu.zza
{
  private String zzall;
  private zzfl zzbku;
  private zzl zzbkz;
  private zzfn zzblg;
  private zzhw zzblh;
  private String zzbli;
  
  public zzfr(Context paramContext, String paramString, zzgn paramzzgn, VersionInfoParcel paramVersionInfoParcel, com.google.android.gms.ads.internal.zzd paramzzd)
  {
    this(paramString, new zzfl(paramContext, paramzzgn, paramVersionInfoParcel, paramzzd));
  }
  
  zzfr(String paramString, zzfl paramzzfl)
  {
    zzall = paramString;
    zzbku = paramzzfl;
    zzblg = new zzfn();
    zzu.zzgb().zza(paramzzfl);
  }
  
  private void zzly()
  {
    if ((zzbkz != null) && (zzblh != null)) {
      zzbkz.zza(zzblh, zzbli);
    }
  }
  
  static boolean zzn(AdRequestParcel paramAdRequestParcel)
  {
    paramAdRequestParcel = zzfo.zzi(paramAdRequestParcel);
    return (paramAdRequestParcel != null) && (paramAdRequestParcel.containsKey("gw"));
  }
  
  static boolean zzo(AdRequestParcel paramAdRequestParcel)
  {
    paramAdRequestParcel = zzfo.zzi(paramAdRequestParcel);
    return (paramAdRequestParcel != null) && (paramAdRequestParcel.containsKey("_ad"));
  }
  
  void abort()
  {
    if (zzbkz != null) {
      return;
    }
    zzbkz = zzbku.zzbd(zzall);
    zzblg.zzc(zzbkz);
    zzly();
  }
  
  public void destroy()
    throws RemoteException
  {
    if (zzbkz != null) {
      zzbkz.destroy();
    }
  }
  
  public String getMediationAdapterClassName()
    throws RemoteException
  {
    if (zzbkz != null) {
      return zzbkz.getMediationAdapterClassName();
    }
    return null;
  }
  
  public boolean isLoading()
    throws RemoteException
  {
    return (zzbkz != null) && (zzbkz.isLoading());
  }
  
  public boolean isReady()
    throws RemoteException
  {
    return (zzbkz != null) && (zzbkz.isReady());
  }
  
  public void pause()
    throws RemoteException
  {
    if (zzbkz != null) {
      zzbkz.pause();
    }
  }
  
  public void resume()
    throws RemoteException
  {
    if (zzbkz != null) {
      zzbkz.resume();
    }
  }
  
  public void setManualImpressionsEnabled(boolean paramBoolean)
    throws RemoteException
  {
    abort();
    if (zzbkz != null) {
      zzbkz.setManualImpressionsEnabled(paramBoolean);
    }
  }
  
  public void setUserId(String paramString) {}
  
  public void showInterstitial()
    throws RemoteException
  {
    if (zzbkz != null)
    {
      zzbkz.showInterstitial();
      return;
    }
    zzkh.zzcy("Interstitial ad must be loaded before showInterstitial().");
  }
  
  public void stopLoading()
    throws RemoteException
  {
    if (zzbkz != null) {
      zzbkz.stopLoading();
    }
  }
  
  public void zza(AdSizeParcel paramAdSizeParcel)
    throws RemoteException
  {
    if (zzbkz != null) {
      zzbkz.zza(paramAdSizeParcel);
    }
  }
  
  public void zza(VideoOptionsParcel paramVideoOptionsParcel)
  {
    throw new IllegalStateException("getVideoController not implemented for interstitials");
  }
  
  public void zza(zzp paramzzp)
    throws RemoteException
  {
    zzblg.zzbko = paramzzp;
    if (zzbkz != null) {
      zzblg.zzc(zzbkz);
    }
  }
  
  public void zza(zzq paramzzq)
    throws RemoteException
  {
    zzblg.zzald = paramzzq;
    if (zzbkz != null) {
      zzblg.zzc(zzbkz);
    }
  }
  
  public void zza(zzw paramzzw)
    throws RemoteException
  {
    zzblg.zzbkl = paramzzw;
    if (zzbkz != null) {
      zzblg.zzc(zzbkz);
    }
  }
  
  public void zza(zzy paramzzy)
    throws RemoteException
  {
    abort();
    if (zzbkz != null) {
      zzbkz.zza(paramzzy);
    }
  }
  
  public void zza(com.google.android.gms.ads.internal.reward.client.zzd paramzzd)
  {
    zzblg.zzbkp = paramzzd;
    if (zzbkz != null) {
      zzblg.zzc(zzbkz);
    }
  }
  
  public void zza(zzdo paramzzdo)
    throws RemoteException
  {
    zzblg.zzbkn = paramzzdo;
    if (zzbkz != null) {
      zzblg.zzc(zzbkz);
    }
  }
  
  public void zza(zzhs paramzzhs)
    throws RemoteException
  {
    zzblg.zzbkm = paramzzhs;
    if (zzbkz != null) {
      zzblg.zzc(zzbkz);
    }
  }
  
  public void zza(zzhw paramzzhw, String paramString)
    throws RemoteException
  {
    zzblh = paramzzhw;
    zzbli = paramString;
    zzly();
  }
  
  public boolean zzb(AdRequestParcel paramAdRequestParcel)
    throws RemoteException
  {
    if (!zzn(paramAdRequestParcel)) {
      abort();
    }
    if (zzfo.zzk(paramAdRequestParcel)) {
      abort();
    }
    if (zzatr != null) {
      abort();
    }
    if (zzbkz != null) {
      return zzbkz.zzb(paramAdRequestParcel);
    }
    Object localObject = zzu.zzgb();
    if (zzo(paramAdRequestParcel)) {
      ((zzfo)localObject).zzb(paramAdRequestParcel, zzall);
    }
    localObject = ((zzfo)localObject).zza(paramAdRequestParcel, zzall);
    if (localObject != null)
    {
      if (!zzbld) {
        ((zzfq.zza)localObject).zzlx();
      }
      zzbkz = zzbkz;
      zzblb.zza(zzblg);
      zzblg.zzc(zzbkz);
      zzly();
      return zzble;
    }
    abort();
    return zzbkz.zzb(paramAdRequestParcel);
  }
  
  public com.google.android.gms.dynamic.zzd zzdn()
    throws RemoteException
  {
    if (zzbkz != null) {
      return zzbkz.zzdn();
    }
    return null;
  }
  
  public AdSizeParcel zzdo()
    throws RemoteException
  {
    if (zzbkz != null) {
      return zzbkz.zzdo();
    }
    return null;
  }
  
  public void zzdq()
    throws RemoteException
  {
    if (zzbkz != null)
    {
      zzbkz.zzdq();
      return;
    }
    zzkh.zzcy("Interstitial ad must be loaded before pingManualTrackingUrl().");
  }
  
  public zzab zzdr()
  {
    throw new IllegalStateException("getVideoController not implemented for interstitials");
  }
}

/* Location:
 * Qualified Name:     com.google.android.gms.internal.zzfr
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */