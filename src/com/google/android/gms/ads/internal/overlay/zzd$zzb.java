package com.google.android.gms.ads.internal.overlay;

import android.content.Context;
import android.view.MotionEvent;
import android.widget.RelativeLayout;
import com.google.android.gms.internal.zzir;
import com.google.android.gms.internal.zzko;

@zzir
class zzd$zzb
  extends RelativeLayout
{
  zzko zzaqd;
  boolean zzbti;
  
  public zzd$zzb(Context paramContext, String paramString)
  {
    super(paramContext);
    zzaqd = new zzko(paramContext, paramString);
  }
  
  void disable()
  {
    zzbti = true;
  }
  
  public boolean onInterceptTouchEvent(MotionEvent paramMotionEvent)
  {
    if (!zzbti) {
      zzaqd.zze(paramMotionEvent);
    }
    return false;
  }
}

/* Location:
 * Qualified Name:     com.google.android.gms.ads.internal.overlay.zzd.zzb
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */