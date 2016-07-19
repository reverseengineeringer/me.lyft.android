package com.google.android.gms.ads.internal.formats;

import android.widget.FrameLayout;
import com.google.android.gms.internal.zzll;

class zzk$1
  implements Runnable
{
  zzk$1(zzk paramzzk, zzi paramzzi) {}
  
  public void run()
  {
    zzll localzzll = zzbhd.zzld();
    if ((localzzll != null) && (zzk.zza(zzbhe) != null)) {
      zzk.zza(zzbhe).addView(localzzll.getView());
    }
  }
}

/* Location:
 * Qualified Name:     com.google.android.gms.ads.internal.formats.zzk.1
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */