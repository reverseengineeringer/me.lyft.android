package com.google.android.gms.ads.internal;

import android.os.RemoteException;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnTouchListener;
import com.google.android.gms.internal.zzbw;
import com.google.android.gms.internal.zzkh;

class zzt$2
  implements View.OnTouchListener
{
  zzt$2(zzt paramzzt) {}
  
  public boolean onTouch(View paramView, MotionEvent paramMotionEvent)
  {
    if (zzt.zzb(zzanm) != null) {}
    try
    {
      zzt.zzb(zzanm).zza(paramMotionEvent);
      return false;
    }
    catch (RemoteException paramView)
    {
      for (;;)
      {
        zzkh.zzd("Unable to process ad data", paramView);
      }
    }
  }
}

/* Location:
 * Qualified Name:     com.google.android.gms.ads.internal.zzt.2
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */