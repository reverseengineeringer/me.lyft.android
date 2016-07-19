package com.google.android.gms.ads.internal.request;

import com.google.android.gms.internal.zzir;
import java.lang.ref.WeakReference;

@zzir
public final class zzg
  extends zzl.zza
{
  private final WeakReference<zzc.zza> zzcca;
  
  public zzg(zzc.zza paramzza)
  {
    zzcca = new WeakReference(paramzza);
  }
  
  public void zzb(AdResponseParcel paramAdResponseParcel)
  {
    zzc.zza localzza = (zzc.zza)zzcca.get();
    if (localzza != null) {
      localzza.zzb(paramAdResponseParcel);
    }
  }
}

/* Location:
 * Qualified Name:     com.google.android.gms.ads.internal.request.zzg
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */