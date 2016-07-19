package com.google.android.gms.ads.internal.request;

import android.content.Context;
import com.google.android.gms.internal.zzcv;
import com.google.android.gms.internal.zzcy;
import com.google.android.gms.internal.zzdc;
import com.google.android.gms.internal.zzir;
import com.google.android.gms.internal.zzis;
import com.google.android.gms.internal.zzit;
import com.google.android.gms.internal.zzle;

@zzir
public final class zzd$zza
  extends zzd
{
  private final Context mContext;
  
  public zzd$zza(Context paramContext, zzle<AdRequestInfoParcel> paramzzle, zzc.zza paramzza)
  {
    super(paramzzle, paramzza);
    mContext = paramContext;
  }
  
  public void zzqx() {}
  
  public zzk zzqy()
  {
    zzcv localzzcv = new zzcv((String)zzdc.zzaxw.get());
    return zzit.zza(mContext, localzzcv, zzis.zzrg());
  }
}

/* Location:
 * Qualified Name:     com.google.android.gms.ads.internal.request.zzd.zza
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */