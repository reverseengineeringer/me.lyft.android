package com.google.android.gms.ads.internal;

import android.content.Context;
import android.support.v4.util.SimpleArrayMap;
import android.text.TextUtils;
import com.google.android.gms.ads.internal.client.zzq;
import com.google.android.gms.ads.internal.client.zzr;
import com.google.android.gms.ads.internal.client.zzs.zza;
import com.google.android.gms.ads.internal.client.zzy;
import com.google.android.gms.ads.internal.formats.NativeAdOptionsParcel;
import com.google.android.gms.ads.internal.util.client.VersionInfoParcel;
import com.google.android.gms.internal.zzee;
import com.google.android.gms.internal.zzef;
import com.google.android.gms.internal.zzeg;
import com.google.android.gms.internal.zzeh;
import com.google.android.gms.internal.zzgn;
import com.google.android.gms.internal.zzir;

@zzir
public class zzk
  extends zzs.zza
{
  private final Context mContext;
  private final zzd zzajv;
  private final zzgn zzajz;
  private zzq zzald;
  private NativeAdOptionsParcel zzali;
  private zzy zzalk;
  private final String zzall;
  private final VersionInfoParcel zzalm;
  private zzee zzalq;
  private zzef zzalr;
  private SimpleArrayMap<String, zzeg> zzals;
  private SimpleArrayMap<String, zzeh> zzalt;
  
  public zzk(Context paramContext, String paramString, zzgn paramzzgn, VersionInfoParcel paramVersionInfoParcel, zzd paramzzd)
  {
    mContext = paramContext;
    zzall = paramString;
    zzajz = paramzzgn;
    zzalm = paramVersionInfoParcel;
    zzalt = new SimpleArrayMap();
    zzals = new SimpleArrayMap();
    zzajv = paramzzd;
  }
  
  public void zza(NativeAdOptionsParcel paramNativeAdOptionsParcel)
  {
    zzali = paramNativeAdOptionsParcel;
  }
  
  public void zza(zzee paramzzee)
  {
    zzalq = paramzzee;
  }
  
  public void zza(zzef paramzzef)
  {
    zzalr = paramzzef;
  }
  
  public void zza(String paramString, zzeh paramzzeh, zzeg paramzzeg)
  {
    if (TextUtils.isEmpty(paramString)) {
      throw new IllegalArgumentException("Custom template ID for native custom template ad is empty. Please provide a valid template id.");
    }
    zzalt.put(paramString, paramzzeh);
    zzals.put(paramString, paramzzeg);
  }
  
  public void zzb(zzq paramzzq)
  {
    zzald = paramzzq;
  }
  
  public void zzb(zzy paramzzy)
  {
    zzalk = paramzzy;
  }
  
  public zzr zzes()
  {
    return new zzj(mContext, zzall, zzajz, zzalm, zzald, zzalq, zzalr, zzalt, zzals, zzali, zzalk, zzajv);
  }
}

/* Location:
 * Qualified Name:     com.google.android.gms.ads.internal.zzk
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */