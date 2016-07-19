package com.google.android.gms.internal;

import com.google.android.gms.ads.internal.client.AdRequestParcel;
import com.google.android.gms.ads.internal.zzl;
import com.google.android.gms.ads.internal.zzu;
import com.google.android.gms.common.internal.zzab;
import com.google.android.gms.common.util.zze;
import java.util.Iterator;
import java.util.LinkedList;

@zzir
class zzfq
{
  private final String zzall;
  private final LinkedList<zza> zzbkv;
  private AdRequestParcel zzbkw;
  private final int zzbkx;
  private boolean zzbky;
  
  zzfq(AdRequestParcel paramAdRequestParcel, String paramString, int paramInt)
  {
    zzab.zzaa(paramAdRequestParcel);
    zzab.zzaa(paramString);
    zzbkv = new LinkedList();
    zzbkw = paramAdRequestParcel;
    zzall = paramString;
    zzbkx = paramInt;
  }
  
  String getAdUnitId()
  {
    return zzall;
  }
  
  int getNetworkType()
  {
    return zzbkx;
  }
  
  int size()
  {
    return zzbkv.size();
  }
  
  void zza(zzfl paramzzfl, AdRequestParcel paramAdRequestParcel)
  {
    paramzzfl = new zza(paramzzfl, paramAdRequestParcel);
    zzbkv.add(paramzzfl);
  }
  
  void zzb(zzfl paramzzfl)
  {
    paramzzfl = new zza(paramzzfl);
    zzbkv.add(paramzzfl);
    paramzzfl.zzlx();
  }
  
  AdRequestParcel zzls()
  {
    return zzbkw;
  }
  
  int zzlt()
  {
    Iterator localIterator = zzbkv.iterator();
    int i = 0;
    if (localIterator.hasNext())
    {
      if (!nextzzbld) {
        break label43;
      }
      i += 1;
    }
    label43:
    for (;;)
    {
      break;
      return i;
    }
  }
  
  void zzlu()
  {
    Iterator localIterator = zzbkv.iterator();
    while (localIterator.hasNext()) {
      ((zza)localIterator.next()).zzlx();
    }
  }
  
  void zzlv()
  {
    zzbky = true;
  }
  
  boolean zzlw()
  {
    return zzbky;
  }
  
  zza zzm(AdRequestParcel paramAdRequestParcel)
  {
    if (paramAdRequestParcel != null) {
      zzbkw = paramAdRequestParcel;
    }
    return (zza)zzbkv.remove();
  }
  
  class zza
  {
    zzl zzbkz;
    AdRequestParcel zzbla;
    zzfm zzblb;
    long zzblc;
    boolean zzbld;
    boolean zzble;
    
    zza(zzfl paramzzfl)
    {
      zzbkz = paramzzfl.zzbe(zzfq.zza(zzfq.this));
      zzblb = new zzfm();
      zzblb.zzc(zzbkz);
    }
    
    zza(zzfl paramzzfl, AdRequestParcel paramAdRequestParcel)
    {
      this(paramzzfl);
      zzbla = paramAdRequestParcel;
    }
    
    void zzlx()
    {
      if (zzbld) {
        return;
      }
      if (zzbla != null) {}
      for (AdRequestParcel localAdRequestParcel = zzbla;; localAdRequestParcel = zzfq.zzb(zzfq.this))
      {
        localAdRequestParcel = zzfo.zzj(localAdRequestParcel);
        zzble = zzbkz.zzb(localAdRequestParcel);
        zzbld = true;
        zzblc = zzu.zzfu().currentTimeMillis();
        return;
      }
    }
  }
}

/* Location:
 * Qualified Name:     com.google.android.gms.internal.zzfq
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */