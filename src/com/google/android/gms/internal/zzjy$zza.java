package com.google.android.gms.internal;

import com.google.android.gms.ads.internal.client.AdSizeParcel;
import com.google.android.gms.ads.internal.request.AdRequestInfoParcel;
import com.google.android.gms.ads.internal.request.AdResponseParcel;
import org.json.JSONObject;

@zzir
public final class zzjy$zza
{
  public final int errorCode;
  public final AdSizeParcel zzaoy;
  public final JSONObject zzcii;
  public final zzge zzcik;
  public final long zzcio;
  public final long zzcip;
  public final AdRequestInfoParcel zzcit;
  public final AdResponseParcel zzciu;
  
  public zzjy$zza(AdRequestInfoParcel paramAdRequestInfoParcel, AdResponseParcel paramAdResponseParcel, zzge paramzzge, AdSizeParcel paramAdSizeParcel, int paramInt, long paramLong1, long paramLong2, JSONObject paramJSONObject)
  {
    zzcit = paramAdRequestInfoParcel;
    zzciu = paramAdResponseParcel;
    zzcik = paramzzge;
    zzaoy = paramAdSizeParcel;
    errorCode = paramInt;
    zzcio = paramLong1;
    zzcip = paramLong2;
    zzcii = paramJSONObject;
  }
}

/* Location:
 * Qualified Name:     com.google.android.gms.internal.zzjy.zza
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */