package com.google.android.gms.ads.internal;

import android.os.Handler;
import com.google.android.gms.ads.internal.overlay.AdOverlayInfoParcel;
import com.google.android.gms.ads.internal.overlay.zze;
import com.google.android.gms.internal.zzir;
import com.google.android.gms.internal.zzjy;
import com.google.android.gms.internal.zzkg;
import com.google.android.gms.internal.zzkl;
import com.google.android.gms.internal.zzll;

@zzir
class zzl$zza
  extends zzkg
{
  private final int zzaly;
  
  public zzl$zza(zzl paramzzl, int paramInt)
  {
    zzaly = paramInt;
  }
  
  public void onStop() {}
  
  public void zzew()
  {
    boolean bool1 = zzalz.zzajs.zzamc;
    boolean bool2 = zzalz.zzet();
    boolean bool3 = zzl.zza(zzalz);
    float f = zzl.zzb(zzalz);
    int i;
    final Object localObject;
    if (zzalz.zzajs.zzamc)
    {
      i = zzaly;
      localObject = new InterstitialAdParameterParcel(bool1, bool2, bool3, f, i);
      i = zzalz.zzajs.zzaoz.zzbtq.getRequestedOrientation();
      if (i != -1) {
        break label192;
      }
      i = zzalz.zzajs.zzaoz.orientation;
    }
    label192:
    for (;;)
    {
      localObject = new AdOverlayInfoParcel(zzalz, zzalz, zzalz, zzalz.zzajs.zzaoz.zzbtq, i, zzalz.zzajs.zzaou, zzalz.zzajs.zzaoz.zzcch, (InterstitialAdParameterParcel)localObject);
      zzkl.zzclg.post(new Runnable()
      {
        public void run()
        {
          zzu.zzfo().zza(zzalz.zzajs.zzagf, localObject);
        }
      });
      return;
      i = -1;
      break;
    }
  }
}

/* Location:
 * Qualified Name:     com.google.android.gms.ads.internal.zzl.zza
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */