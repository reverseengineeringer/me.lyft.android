package com.google.android.gms.internal;

import android.content.Context;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import com.google.android.gms.ads.internal.overlay.zzk;
import com.google.android.gms.common.internal.zzab;

@zzir
public class zzlk
{
  private final Context mContext;
  private final zzll zzbgj;
  private zzk zzbwj;
  private final ViewGroup zzcom;
  
  public zzlk(Context paramContext, ViewGroup paramViewGroup, zzll paramzzll)
  {
    this(paramContext, paramViewGroup, paramzzll, null);
  }
  
  zzlk(Context paramContext, ViewGroup paramViewGroup, zzll paramzzll, zzk paramzzk)
  {
    mContext = paramContext;
    zzcom = paramViewGroup;
    zzbgj = paramzzll;
    zzbwj = paramzzk;
  }
  
  public void onDestroy()
  {
    zzab.zzhj("onDestroy must be called from the UI thread.");
    if (zzbwj != null)
    {
      zzbwj.destroy();
      zzcom.removeView(zzbwj);
      zzbwj = null;
    }
  }
  
  public void onPause()
  {
    zzab.zzhj("onPause must be called from the UI thread.");
    if (zzbwj != null) {
      zzbwj.pause();
    }
  }
  
  public void zza(int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5, boolean paramBoolean)
  {
    if (zzbwj != null) {
      return;
    }
    zzdg.zza(zzbgj.zzut().zzkf(), zzbgj.zzus(), new String[] { "vpr" });
    zzdi localzzdi = zzdg.zzb(zzbgj.zzut().zzkf());
    zzbwj = new zzk(mContext, zzbgj, paramInt5, paramBoolean, zzbgj.zzut().zzkf(), localzzdi);
    zzcom.addView(zzbwj, 0, new ViewGroup.LayoutParams(-1, -1));
    zzbwj.zzd(paramInt1, paramInt2, paramInt3, paramInt4);
    zzbgj.zzuk().zzak(false);
  }
  
  public void zze(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    zzab.zzhj("The underlay may only be modified from the UI thread.");
    if (zzbwj != null) {
      zzbwj.zzd(paramInt1, paramInt2, paramInt3, paramInt4);
    }
  }
  
  public zzk zzuc()
  {
    zzab.zzhj("getAdVideoUnderlay must be called from the UI thread.");
    return zzbwj;
  }
}

/* Location:
 * Qualified Name:     com.google.android.gms.internal.zzlk
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */