package com.google.android.gms.ads.internal;

import android.os.RemoteException;
import android.support.v4.util.SimpleArrayMap;
import com.google.android.gms.ads.internal.formats.zzf;
import com.google.android.gms.internal.zzeh;
import com.google.android.gms.internal.zzjy;
import com.google.android.gms.internal.zzkh;

class zzq$4
  implements Runnable
{
  zzq$4(zzq paramzzq, String paramString, zzjy paramzzjy) {}
  
  public void run()
  {
    try
    {
      ((zzeh)zzamv.zzajs.zzapl.get(zzamy)).zza((zzf)zzakq.zzciq);
      return;
    }
    catch (RemoteException localRemoteException)
    {
      zzkh.zzd("Could not call onCustomTemplateAdLoadedListener.onCustomTemplateAdLoaded().", localRemoteException);
    }
  }
}

/* Location:
 * Qualified Name:     com.google.android.gms.ads.internal.zzq.4
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */