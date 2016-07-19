package com.google.android.gms.ads.internal;

import android.os.RemoteException;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.View.OnTouchListener;
import com.google.android.gms.ads.internal.request.AdResponseParcel;
import com.google.android.gms.internal.zzdk;
import com.google.android.gms.internal.zzdl;
import com.google.android.gms.internal.zzdn;
import com.google.android.gms.internal.zzdo;
import com.google.android.gms.internal.zzig;
import com.google.android.gms.internal.zzjs;
import com.google.android.gms.internal.zzjy.zza;
import com.google.android.gms.internal.zzkh;
import com.google.android.gms.internal.zzkl;
import com.google.android.gms.internal.zzll;

class zzc$3
  implements Runnable
{
  zzc$3(zzc paramzzc, zzjy.zza paramzza, zzjs paramzzjs, zzdk paramzzdk) {}
  
  public void run()
  {
    if ((zzake.zzciu.zzccl) && (zzakd.zzajs.zzapo != null))
    {
      Object localObject = null;
      if (zzake.zzciu.zzbts != null) {
        localObject = zzu.zzfq().zzcp(zzake.zzciu.zzbts);
      }
      localObject = new zzdl(zzakd, (String)localObject, zzake.zzciu.body);
      zzakd.zzajs.zzapu = 1;
      try
      {
        zzakd.zzajq = false;
        zzakd.zzajs.zzapo.zza((zzdn)localObject);
        return;
      }
      catch (RemoteException localRemoteException)
      {
        zzkh.zzd("Could not call the onCustomRenderedAdLoadedListener.", localRemoteException);
        zzakd.zzajq = true;
      }
    }
    final zze localzze = new zze(zzakd.zzajs.zzagf, zzake);
    zzll localzzll = zzakd.zza(zzake, localzze, zzakf);
    localzzll.setOnTouchListener(new View.OnTouchListener()
    {
      public boolean onTouch(View paramAnonymousView, MotionEvent paramAnonymousMotionEvent)
      {
        localzze.recordClick();
        return false;
      }
    });
    localzzll.setOnClickListener(new View.OnClickListener()
    {
      public void onClick(View paramAnonymousView)
      {
        localzze.recordClick();
      }
    });
    zzakd.zzajs.zzapu = 0;
    zzakd.zzajs.zzaox = zzu.zzfp().zza(zzakd.zzajs.zzagf, zzakd, zzake, zzakd.zzajs.zzaot, localzzll, zzakd.zzajz, zzakd, zzakg);
  }
}

/* Location:
 * Qualified Name:     com.google.android.gms.ads.internal.zzc.3
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */