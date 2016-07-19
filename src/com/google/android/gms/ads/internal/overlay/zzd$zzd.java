package com.google.android.gms.ads.internal.overlay;

import android.app.Activity;
import android.graphics.Bitmap;
import android.graphics.drawable.Drawable;
import android.os.Handler;
import android.view.Window;
import com.google.android.gms.ads.internal.InterstitialAdParameterParcel;
import com.google.android.gms.ads.internal.zzu;
import com.google.android.gms.internal.zzir;
import com.google.android.gms.internal.zzkg;
import com.google.android.gms.internal.zzkl;
import com.google.android.gms.internal.zzkm;
import com.google.android.gms.internal.zzkt;

@zzir
class zzd$zzd
  extends zzkg
{
  private zzd$zzd(zzd paramzzd) {}
  
  public void onStop() {}
  
  public void zzew()
  {
    final Object localObject = zzu.zzgh().zza(Integer.valueOf(zzbth.zzbss.zzbtz.zzamh));
    if (localObject != null)
    {
      localObject = zzu.zzfs().zza(zzd.zza(zzbth), (Bitmap)localObject, zzbth.zzbss.zzbtz.zzamf, zzbth.zzbss.zzbtz.zzamg);
      zzkl.zzclg.post(new Runnable()
      {
        public void run()
        {
          zzd.zza(zzbth).getWindow().setBackgroundDrawable(localObject);
        }
      });
    }
  }
}

/* Location:
 * Qualified Name:     com.google.android.gms.ads.internal.overlay.zzd.zzd
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */