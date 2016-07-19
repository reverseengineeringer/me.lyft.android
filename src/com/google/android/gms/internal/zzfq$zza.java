package com.google.android.gms.internal;

import com.google.android.gms.ads.internal.client.AdRequestParcel;
import com.google.android.gms.ads.internal.zzl;
import com.google.android.gms.ads.internal.zzu;
import com.google.android.gms.common.util.zze;

class zzfq$zza
{
  zzl zzbkz;
  AdRequestParcel zzbla;
  zzfm zzblb;
  long zzblc;
  boolean zzbld;
  boolean zzble;
  
  zzfq$zza(zzfq paramzzfq, zzfl paramzzfl)
  {
    zzbkz = paramzzfl.zzbe(zzfq.zza(paramzzfq));
    zzblb = new zzfm();
    zzblb.zzc(zzbkz);
  }
  
  zzfq$zza(zzfq paramzzfq, zzfl paramzzfl, AdRequestParcel paramAdRequestParcel)
  {
    this(paramzzfq, paramzzfl);
    zzbla = paramAdRequestParcel;
  }
  
  void zzlx()
  {
    if (zzbld) {
      return;
    }
    if (zzbla != null) {}
    for (AdRequestParcel localAdRequestParcel = zzbla;; localAdRequestParcel = zzfq.zzb(zzblf))
    {
      localAdRequestParcel = zzfo.zzj(localAdRequestParcel);
      zzble = zzbkz.zzb(localAdRequestParcel);
      zzbld = true;
      zzblc = zzu.zzfu().currentTimeMillis();
      return;
    }
  }
}

/* Location:
 * Qualified Name:     com.google.android.gms.internal.zzfq.zza
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */