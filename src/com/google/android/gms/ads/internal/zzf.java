package com.google.android.gms.ads.internal;

import android.content.Context;
import android.graphics.Rect;
import android.os.Bundle;
import android.view.View;
import android.view.ViewTreeObserver.OnGlobalLayoutListener;
import android.view.ViewTreeObserver.OnScrollChangedListener;
import com.google.android.gms.ads.AdSize;
import com.google.android.gms.ads.internal.client.AdRequestParcel;
import com.google.android.gms.ads.internal.client.AdSizeParcel;
import com.google.android.gms.ads.internal.client.VideoOptionsParcel;
import com.google.android.gms.ads.internal.client.zzm;
import com.google.android.gms.ads.internal.request.AdResponseParcel;
import com.google.android.gms.ads.internal.util.client.VersionInfoParcel;
import com.google.android.gms.ads.internal.util.client.zza;
import com.google.android.gms.internal.zzcd;
import com.google.android.gms.internal.zzcg;
import com.google.android.gms.internal.zzcy;
import com.google.android.gms.internal.zzdc;
import com.google.android.gms.internal.zzes;
import com.google.android.gms.internal.zzgn;
import com.google.android.gms.internal.zzir;
import com.google.android.gms.internal.zzjs;
import com.google.android.gms.internal.zzjy;
import com.google.android.gms.internal.zzjy.zza;
import com.google.android.gms.internal.zzkh;
import com.google.android.gms.internal.zzkl;
import com.google.android.gms.internal.zzlg;
import com.google.android.gms.internal.zzll;
import com.google.android.gms.internal.zzlm;
import com.google.android.gms.internal.zzlm.zzb;
import com.google.android.gms.internal.zzlq;
import java.util.List;

@zzir
public class zzf
  extends zzc
  implements ViewTreeObserver.OnGlobalLayoutListener, ViewTreeObserver.OnScrollChangedListener
{
  private boolean zzakp;
  
  public zzf(Context paramContext, AdSizeParcel paramAdSizeParcel, String paramString, zzgn paramzzgn, VersionInfoParcel paramVersionInfoParcel, zzd paramzzd)
  {
    super(paramContext, paramAdSizeParcel, paramString, paramzzgn, paramVersionInfoParcel, paramzzd);
  }
  
  private AdSizeParcel zzb(zzjy.zza paramzza)
  {
    if (zzciu.zzaut) {
      return zzajs.zzaoy;
    }
    paramzza = zzciu.zzccf;
    if (paramzza != null)
    {
      paramzza = paramzza.split("[xX]");
      paramzza[0] = paramzza[0].trim();
      paramzza[1] = paramzza[1].trim();
    }
    for (paramzza = new AdSize(Integer.parseInt(paramzza[0]), Integer.parseInt(paramzza[1]));; paramzza = zzajs.zzaoy.zzij()) {
      return new AdSizeParcel(zzajs.zzagf, paramzza);
    }
  }
  
  private boolean zzb(zzjy paramzzjy1, zzjy paramzzjy2)
  {
    View localView1;
    if (zzccc)
    {
      localView1 = zzn.zzf(paramzzjy2);
      if (localView1 == null)
      {
        zzkh.zzcy("Could not get mediation view");
        return false;
      }
      View localView2 = zzajs.zzaov.getNextView();
      if (localView2 != null)
      {
        if ((localView2 instanceof zzll)) {
          ((zzll)localView2).destroy();
        }
        zzajs.zzaov.removeView(localView2);
      }
      if (zzn.zzg(paramzzjy2)) {}
    }
    for (;;)
    {
      try
      {
        zzb(localView1);
        if (zzajs.zzaov.getChildCount() > 1) {
          zzajs.zzaov.showNext();
        }
        if (paramzzjy1 != null)
        {
          paramzzjy1 = zzajs.zzaov.getNextView();
          if (!(paramzzjy1 instanceof zzll)) {
            break label271;
          }
          ((zzll)paramzzjy1).zza(zzajs.zzagf, zzajs.zzaoy, zzajn);
          zzajs.zzgo();
        }
        zzajs.zzaov.setVisibility(0);
        return true;
      }
      catch (Throwable paramzzjy1)
      {
        zzkh.zzd("Could not add mediation view to view hierarchy.", paramzzjy1);
        return false;
      }
      if ((zzcim != null) && (zzbtq != null))
      {
        zzbtq.zza(zzcim);
        zzajs.zzaov.removeAllViews();
        zzajs.zzaov.setMinimumWidth(zzcim.widthPixels);
        zzajs.zzaov.setMinimumHeight(zzcim.heightPixels);
        zzb(zzbtq.getView());
        continue;
        label271:
        if (paramzzjy1 != null) {
          zzajs.zzaov.removeView(paramzzjy1);
        }
      }
    }
  }
  
  private void zzd(final zzjy paramzzjy)
  {
    if (zzajs.zzgp()) {
      if (zzbtq != null)
      {
        if (zzcii != null) {
          zzaju.zza(zzajs.zzaoy, paramzzjy);
        }
        if (!paramzzjy.zzho()) {
          break label70;
        }
        zzaju.zza(zzajs.zzaoy, paramzzjy).zza(zzbtq);
      }
    }
    label70:
    while ((zzajs.zzapt == null) || (zzcii == null))
    {
      return;
      zzbtq.zzuk().zza(new zzlm.zzb()
      {
        public void zzen()
        {
          zzaju.zza(zzajs.zzaoy, paramzzjy).zza(paramzzjyzzbtq);
        }
      });
      return;
    }
    zzaju.zza(zzajs.zzaoy, paramzzjy, zzajs.zzapt);
  }
  
  public void onGlobalLayout()
  {
    zze(zzajs.zzaoz);
  }
  
  public void onScrollChanged()
  {
    zze(zzajs.zzaoz);
  }
  
  public void setManualImpressionsEnabled(boolean paramBoolean)
  {
    com.google.android.gms.common.internal.zzab.zzhj("setManualImpressionsEnabled must be called from the main thread.");
    zzakp = paramBoolean;
  }
  
  public void showInterstitial()
  {
    throw new IllegalStateException("Interstitial is NOT supported by BannerAdManager.");
  }
  
  protected zzll zza(zzjy.zza paramzza, zze paramzze, zzjs paramzzjs)
  {
    if (zzajs.zzaoy.zzaut) {
      zzajs.zzaoy = zzb(paramzza);
    }
    paramzza = super.zza(paramzza, paramzze, paramzzjs);
    zzes.zzd(paramzza);
    return paramzza;
  }
  
  protected void zza(zzjy paramzzjy, boolean paramBoolean)
  {
    super.zza(paramzzjy, paramBoolean);
    if (zzn.zzg(paramzzjy)) {
      zzn.zza(paramzzjy, new zza());
    }
  }
  
  public boolean zza(zzjy paramzzjy1, zzjy paramzzjy2)
  {
    if (!super.zza(paramzzjy1, paramzzjy2)) {
      return false;
    }
    if ((zzajs.zzgp()) && (!zzb(paramzzjy1, paramzzjy2)))
    {
      zzh(0);
      return false;
    }
    if (zzccu)
    {
      zze(paramzzjy2);
      zzu.zzgk().zza(zzajs.zzaov, this);
      zzu.zzgk().zza(zzajs.zzaov, this);
    }
    for (;;)
    {
      paramzzjy1 = null;
      if (zzbtq != null)
      {
        zzlq localzzlq = zzbtq.zzuu();
        zzlm localzzlm = zzbtq.zzuk();
        paramzzjy1 = localzzlq;
        if (localzzlm != null)
        {
          localzzlm.zzvb();
          paramzzjy1 = localzzlq;
        }
      }
      if ((zzajs.zzapn != null) && (paramzzjy1 != null)) {
        paramzzjy1.zzam(zzajs.zzapn.zzaxk);
      }
      zzd(paramzzjy2);
      return true;
      if ((!zzajs.zzgq()) || (((Boolean)zzdc.zzbcc.get()).booleanValue())) {
        zza(paramzzjy2, false);
      }
    }
  }
  
  public boolean zzb(AdRequestParcel paramAdRequestParcel)
  {
    return super.zzb(zze(paramAdRequestParcel));
  }
  
  public com.google.android.gms.ads.internal.client.zzab zzdr()
  {
    com.google.android.gms.common.internal.zzab.zzhj("getVideoController must be called from the main thread.");
    if ((zzajs.zzaoz != null) && (zzajs.zzaoz.zzbtq != null)) {
      return zzajs.zzaoz.zzbtq.zzuu();
    }
    return null;
  }
  
  protected boolean zzdx()
  {
    boolean bool = true;
    if (!zzu.zzfq().zza(zzajs.zzagf.getPackageManager(), zzajs.zzagf.getPackageName(), "android.permission.INTERNET"))
    {
      zzm.zziw().zza(zzajs.zzaov, zzajs.zzaoy, "Missing internet permission in AndroidManifest.xml.", "Missing internet permission in AndroidManifest.xml. You must have the following declaration: <uses-permission android:name=\"android.permission.INTERNET\" />");
      bool = false;
    }
    if (!zzu.zzfq().zzac(zzajs.zzagf))
    {
      zzm.zziw().zza(zzajs.zzaov, zzajs.zzaoy, "Missing AdActivity with android:configChanges in AndroidManifest.xml.", "Missing AdActivity with android:configChanges in AndroidManifest.xml. You must have the following declaration within the <application> element: <activity android:name=\"com.google.android.gms.ads.AdActivity\" android:configChanges=\"keyboard|keyboardHidden|orientation|screenLayout|uiMode|screenSize|smallestScreenSize\" />");
      bool = false;
    }
    if ((!bool) && (zzajs.zzaov != null)) {
      zzajs.zzaov.setVisibility(0);
    }
    return bool;
  }
  
  AdRequestParcel zze(AdRequestParcel paramAdRequestParcel)
  {
    if (zzatp == zzakp) {
      return paramAdRequestParcel;
    }
    int i = versionCode;
    long l = zzatk;
    Bundle localBundle = extras;
    int j = zzatl;
    List localList = zzatm;
    boolean bool2 = zzatn;
    int k = zzato;
    if ((zzatp) || (zzakp)) {}
    for (boolean bool1 = true;; bool1 = false) {
      return new AdRequestParcel(i, l, localBundle, j, localList, bool2, k, bool1, zzatq, zzatr, zzats, zzatt, zzatu, zzatv, zzatw, zzatx, zzaty, zzatz);
    }
  }
  
  void zze(zzjy paramzzjy)
  {
    if (paramzzjy == null) {}
    while ((zzcij) || (zzajs.zzaov == null) || (!zzu.zzfq().zza(zzajs.zzaov, zzajs.zzagf)) || (!zzajs.zzaov.getGlobalVisibleRect(new Rect(), null))) {
      return;
    }
    zza(paramzzjy, false);
    zzcij = true;
  }
  
  public class zza
  {
    public zza() {}
    
    public void onClick()
    {
      onAdClicked();
    }
  }
}

/* Location:
 * Qualified Name:     com.google.android.gms.ads.internal.zzf
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */