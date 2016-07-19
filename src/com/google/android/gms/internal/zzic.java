package com.google.android.gms.internal;

import android.content.Context;
import android.os.Handler;
import com.google.android.gms.ads.internal.request.AdRequestInfoParcel;
import com.google.android.gms.ads.internal.request.AdResponseParcel;
import com.google.android.gms.ads.internal.zzu;
import com.google.android.gms.common.internal.zzab;
import java.util.concurrent.atomic.AtomicBoolean;

@zzir
public abstract class zzic
  implements zzkn<Void>, zzlm.zza
{
  protected final Context mContext;
  protected final zzll zzbgj;
  protected final zzig.zza zzbxu;
  protected final zzjy.zza zzbxv;
  protected AdResponseParcel zzbxw;
  private Runnable zzbxx;
  protected final Object zzbxy = new Object();
  private AtomicBoolean zzbxz = new AtomicBoolean(true);
  
  protected zzic(Context paramContext, zzjy.zza paramzza, zzll paramzzll, zzig.zza paramzza1)
  {
    mContext = paramContext;
    zzbxv = paramzza;
    zzbxw = zzbxv.zzciu;
    zzbgj = paramzzll;
    zzbxu = paramzza1;
  }
  
  private zzjy zzak(int paramInt)
  {
    AdRequestInfoParcel localAdRequestInfoParcel = zzbxv.zzcit;
    return new zzjy(zzcav, zzbgj, zzbxw.zzbnq, paramInt, zzbxw.zzbnr, zzbxw.zzcce, zzbxw.orientation, zzbxw.zzbnw, zzcay, zzbxw.zzccc, null, null, null, null, null, zzbxw.zzccd, zzbxv.zzaoy, zzbxw.zzccb, zzbxv.zzcio, zzbxw.zzccg, zzbxw.zzcch, zzbxv.zzcii, null, zzbxw.zzccr, zzbxw.zzccs, zzbxw.zzcct, zzbxw.zzccu, zzbxw.zzccv, null, zzbxw.zzbnt);
  }
  
  public void cancel()
  {
    if (!zzbxz.getAndSet(false)) {
      return;
    }
    zzbgj.stopLoading();
    zzu.zzfs().zzj(zzbgj);
    zzaj(-1);
    zzkl.zzclg.removeCallbacks(zzbxx);
  }
  
  public void zza(zzll paramzzll, boolean paramBoolean)
  {
    int i = 0;
    zzkh.zzcw("WebView finished loading.");
    if (!zzbxz.getAndSet(false)) {
      return;
    }
    if (paramBoolean) {
      i = zzpy();
    }
    zzaj(i);
    zzkl.zzclg.removeCallbacks(zzbxx);
  }
  
  protected void zzaj(int paramInt)
  {
    if (paramInt != -2) {
      zzbxw = new AdResponseParcel(paramInt, zzbxw.zzbnw);
    }
    zzbgj.zzue();
    zzbxu.zzb(zzak(paramInt));
  }
  
  public final Void zzpw()
  {
    zzab.zzhj("Webview render task needs to be called on UI thread.");
    zzbxx = new Runnable()
    {
      public void run()
      {
        if (!zzic.zza(zzic.this).get()) {
          return;
        }
        zzkh.e("Timed out waiting for WebView to finish loading.");
        cancel();
      }
    };
    zzkl.zzclg.postDelayed(zzbxx, ((Long)zzdc.zzbbf.get()).longValue());
    zzpx();
    return null;
  }
  
  protected abstract void zzpx();
  
  protected int zzpy()
  {
    return -2;
  }
}

/* Location:
 * Qualified Name:     com.google.android.gms.internal.zzic
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */