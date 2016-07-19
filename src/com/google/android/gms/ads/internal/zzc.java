package com.google.android.gms.ads.internal;

import android.content.Context;
import android.os.Handler;
import android.os.RemoteException;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.View.OnTouchListener;
import com.google.android.gms.ads.internal.client.AdSizeParcel;
import com.google.android.gms.ads.internal.request.AdRequestInfoParcel;
import com.google.android.gms.ads.internal.request.AdResponseParcel;
import com.google.android.gms.ads.internal.util.client.VersionInfoParcel;
import com.google.android.gms.common.internal.zzab;
import com.google.android.gms.internal.zzcg;
import com.google.android.gms.internal.zzcy;
import com.google.android.gms.internal.zzdc;
import com.google.android.gms.internal.zzdk;
import com.google.android.gms.internal.zzdl;
import com.google.android.gms.internal.zzdn;
import com.google.android.gms.internal.zzdo;
import com.google.android.gms.internal.zzet;
import com.google.android.gms.internal.zzfx;
import com.google.android.gms.internal.zzgn;
import com.google.android.gms.internal.zzhk;
import com.google.android.gms.internal.zzig;
import com.google.android.gms.internal.zzir;
import com.google.android.gms.internal.zzjs;
import com.google.android.gms.internal.zzjt;
import com.google.android.gms.internal.zzjy;
import com.google.android.gms.internal.zzjy.zza;
import com.google.android.gms.internal.zzkh;
import com.google.android.gms.internal.zzkl;
import com.google.android.gms.internal.zzko;
import com.google.android.gms.internal.zzll;
import com.google.android.gms.internal.zzlm;
import com.google.android.gms.internal.zzln;
import java.util.Map;

@zzir
public abstract class zzc
  extends zzb
  implements zzh, zzhk
{
  public zzc(Context paramContext, AdSizeParcel paramAdSizeParcel, String paramString, zzgn paramzzgn, VersionInfoParcel paramVersionInfoParcel, zzd paramzzd)
  {
    super(paramContext, paramAdSizeParcel, paramString, paramzzgn, paramVersionInfoParcel, paramzzd);
  }
  
  protected zzll zza(zzjy.zza paramzza, zze paramzze, zzjs paramzzjs)
  {
    zzll localzzll1 = null;
    View localView = zzajs.zzaov.getNextView();
    if ((localView instanceof zzll))
    {
      localzzll1 = (zzll)localView;
      if (!((Boolean)zzdc.zzazx.get()).booleanValue()) {
        break label223;
      }
      zzkh.zzcw("Reusing webview...");
      localzzll1.zza(zzajs.zzagf, zzajs.zzaoy, zzajn);
    }
    for (;;)
    {
      zzll localzzll2 = localzzll1;
      if (localzzll1 == null)
      {
        if (localView != null) {
          zzajs.zzaov.removeView(localView);
        }
        localzzll1 = zzu.zzfr().zza(zzajs.zzagf, zzajs.zzaoy, false, false, zzajs.zzaot, zzajs.zzaou, zzajn, this, zzajv);
        localzzll2 = localzzll1;
        if (zzajs.zzaoy.zzaur == null)
        {
          zzb(localzzll1.getView());
          localzzll2 = localzzll1;
        }
      }
      localzzll2.zzuk().zza(this, this, this, this, false, this, null, paramzze, this, paramzzjs);
      zza(localzzll2);
      localzzll2.zzda(zzcit.zzcbk);
      return localzzll2;
      label223:
      localzzll1.destroy();
      localzzll1 = null;
    }
  }
  
  public void zza(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    zzdu();
  }
  
  public void zza(zzdo paramzzdo)
  {
    zzab.zzhj("setOnCustomRenderedAdLoadedListener must be called on the main UI thread.");
    zzajs.zzapo = paramzzdo;
  }
  
  protected void zza(zzfx paramzzfx)
  {
    paramzzfx.zza("/trackActiveViewUnit", new zzet()
    {
      public void zza(zzll paramAnonymouszzll, Map<String, String> paramAnonymousMap)
      {
        if (zzajs.zzaoz != null)
        {
          zzaju.zza(zzajs.zzaoy, zzajs.zzaoz, paramAnonymouszzll.getView(), paramAnonymouszzll);
          return;
        }
        zzkh.zzcy("Request to enable ActiveView before adState is available.");
      }
    });
  }
  
  protected void zza(final zzjy.zza paramzza, final zzdk paramzzdk)
  {
    final zzjs localzzjs = null;
    if (errorCode != -2)
    {
      zzkl.zzclg.post(new Runnable()
      {
        public void run()
        {
          zzb(new zzjy(paramzza, null, null, null, null, null, null, null));
        }
      });
      return;
    }
    if (zzaoy != null) {
      zzajs.zzaoy = zzaoy;
    }
    if ((zzciu.zzccc) && (!zzciu.zzauu))
    {
      zzajs.zzapu = 0;
      zzajs.zzaox = zzu.zzfp().zza(zzajs.zzagf, this, paramzza, zzajs.zzaot, null, zzajz, this, paramzzdk);
      return;
    }
    if (((Boolean)zzdc.zzbdd.get()).booleanValue()) {
      localzzjs = zzajv.zzakm.zza(zzajs.zzagf, zzciu);
    }
    zzkl.zzclg.post(new Runnable()
    {
      public void run()
      {
        if ((paramzzazzciu.zzccl) && (zzajs.zzapo != null))
        {
          Object localObject = null;
          if (paramzzazzciu.zzbts != null) {
            localObject = zzu.zzfq().zzcp(paramzzazzciu.zzbts);
          }
          localObject = new zzdl(zzc.this, (String)localObject, paramzzazzciu.body);
          zzajs.zzapu = 1;
          try
          {
            zzajq = false;
            zzajs.zzapo.zza((zzdn)localObject);
            return;
          }
          catch (RemoteException localRemoteException)
          {
            zzkh.zzd("Could not call the onCustomRenderedAdLoadedListener.", localRemoteException);
            zzajq = true;
          }
        }
        final zze localzze = new zze(zzajs.zzagf, paramzza);
        zzll localzzll = zza(paramzza, localzze, localzzjs);
        localzzll.setOnTouchListener(new View.OnTouchListener()
        {
          public boolean onTouch(View paramAnonymous2View, MotionEvent paramAnonymous2MotionEvent)
          {
            localzze.recordClick();
            return false;
          }
        });
        localzzll.setOnClickListener(new View.OnClickListener()
        {
          public void onClick(View paramAnonymous2View)
          {
            localzze.recordClick();
          }
        });
        zzajs.zzapu = 0;
        zzajs.zzaox = zzu.zzfp().zza(zzajs.zzagf, zzc.this, paramzza, zzajs.zzaot, localzzll, zzajz, zzc.this, paramzzdk);
      }
    });
  }
  
  protected boolean zza(zzjy paramzzjy1, zzjy paramzzjy2)
  {
    if ((zzajs.zzgp()) && (zzajs.zzaov != null)) {
      zzajs.zzaov.zzgv().zzct(zzcch);
    }
    return super.zza(paramzzjy1, paramzzjy2);
  }
  
  public void zzc(View paramView)
  {
    zzajs.zzapt = paramView;
    zzb(new zzjy(zzajs.zzapa, null, null, null, null, null, null, null));
  }
  
  public void zzei()
  {
    onAdClicked();
  }
  
  public void zzej()
  {
    recordImpression();
    zzdq();
  }
  
  public void zzek()
  {
    zzds();
  }
}

/* Location:
 * Qualified Name:     com.google.android.gms.ads.internal.zzc
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */