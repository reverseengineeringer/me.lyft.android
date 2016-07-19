package com.google.android.gms.ads.internal;

import android.app.Activity;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Rect;
import android.os.Bundle;
import android.os.Handler;
import android.os.RemoteException;
import android.view.View;
import android.view.Window;
import com.google.android.gms.ads.internal.client.AdRequestParcel;
import com.google.android.gms.ads.internal.client.AdSizeParcel;
import com.google.android.gms.ads.internal.overlay.AdOverlayInfoParcel;
import com.google.android.gms.ads.internal.request.AdRequestInfoParcel;
import com.google.android.gms.ads.internal.request.AdResponseParcel;
import com.google.android.gms.ads.internal.reward.mediation.client.RewardItemParcel;
import com.google.android.gms.ads.internal.util.client.VersionInfoParcel;
import com.google.android.gms.common.internal.zzab;
import com.google.android.gms.internal.zzcg;
import com.google.android.gms.internal.zzcy;
import com.google.android.gms.internal.zzdc;
import com.google.android.gms.internal.zzdk;
import com.google.android.gms.internal.zzes;
import com.google.android.gms.internal.zzex;
import com.google.android.gms.internal.zzfc;
import com.google.android.gms.internal.zzfc.zza;
import com.google.android.gms.internal.zzgd;
import com.google.android.gms.internal.zzge;
import com.google.android.gms.internal.zzgn;
import com.google.android.gms.internal.zzgo;
import com.google.android.gms.internal.zzir;
import com.google.android.gms.internal.zziu;
import com.google.android.gms.internal.zzjs;
import com.google.android.gms.internal.zzjy;
import com.google.android.gms.internal.zzjy.zza;
import com.google.android.gms.internal.zzkg;
import com.google.android.gms.internal.zzkh;
import com.google.android.gms.internal.zzkl;
import com.google.android.gms.internal.zzkm;
import com.google.android.gms.internal.zzkt;
import com.google.android.gms.internal.zzll;
import com.google.android.gms.internal.zzlm;
import com.google.android.gms.internal.zzln;
import java.util.Collections;
import java.util.concurrent.Future;
import org.json.JSONException;
import org.json.JSONObject;

@zzir
public class zzl
  extends zzc
  implements zzex, zzfc.zza
{
  protected transient boolean zzalu = false;
  private int zzalv = -1;
  private boolean zzalw;
  private float zzalx;
  
  public zzl(Context paramContext, AdSizeParcel paramAdSizeParcel, String paramString, zzgn paramzzgn, VersionInfoParcel paramVersionInfoParcel, zzd paramzzd)
  {
    super(paramContext, paramAdSizeParcel, paramString, paramzzgn, paramVersionInfoParcel, paramzzd);
  }
  
  private void zzb(Bundle paramBundle)
  {
    zzu.zzfq().zzb(zzajs.zzagf, zzajs.zzaou.zzcs, "gmob-apps", paramBundle, false);
  }
  
  private zzjy.zza zzc(zzjy.zza paramzza)
  {
    try
    {
      Object localObject1 = zziu.zzc(zzciu).toString();
      Object localObject2 = new JSONObject();
      ((JSONObject)localObject2).put("pubid", zzcit.zzaos);
      localObject2 = ((JSONObject)localObject2).toString();
      localObject1 = new zzge(Collections.singletonList(new zzgd((String)localObject1, null, Collections.singletonList("com.google.ads.mediation.admob.AdMobAdapter"), null, null, Collections.emptyList(), Collections.emptyList(), (String)localObject2, null, Collections.emptyList(), Collections.emptyList(), null, null, null, null, null, Collections.emptyList())), -1L, Collections.emptyList(), Collections.emptyList(), Collections.emptyList(), Collections.emptyList(), false, "", -1L, 0, 1, null, 0, -1, -1L, false);
      localObject2 = zzciu;
      localObject2 = new AdResponseParcel(zzcit, zzbts, body, zzbnq, zzbnr, zzccb, true, zzccd, zzcce, zzbnw, orientation, zzccf, zzccg, zzcch, zzcci, zzccj, zzcck, zzccl, zzaus, zzcbd, zzccm, zzccn, zzccq, zzaut, zzauu, zzccr, zzccs, zzcct, zzccu, zzccv, zzcbu, zzcbv, zzbnt, zzccw, zzbnu, zzccx);
      return new zzjy.zza(zzcit, (AdResponseParcel)localObject2, (zzge)localObject1, zzaoy, errorCode, zzcio, zzcip, zzcii);
    }
    catch (JSONException localJSONException)
    {
      zzkh.zzb("Unable to generate ad state for an interstitial ad with pooling.", localJSONException);
    }
    return paramzza;
  }
  
  public void showInterstitial()
  {
    zzab.zzhj("showInterstitial must be called on the main UI thread.");
    if (zzajs.zzaoz == null)
    {
      zzkh.zzcy("The interstitial has not loaded.");
      return;
    }
    if (((Boolean)zzdc.zzbas.get()).booleanValue()) {
      if (zzajs.zzagf.getApplicationContext() == null) {
        break label235;
      }
    }
    label235:
    for (String str = zzajs.zzagf.getApplicationContext().getPackageName();; localObject = zzajs.zzagf.getPackageName())
    {
      Bundle localBundle;
      if (!zzalu)
      {
        zzkh.zzcy("It is not recommended to show an interstitial before onAdLoaded completes.");
        localBundle = new Bundle();
        localBundle.putString("appid", str);
        localBundle.putString("action", "show_interstitial_before_load_finish");
        zzb(localBundle);
      }
      if (!zzu.zzfq().zzai(zzajs.zzagf))
      {
        zzkh.zzcy("It is not recommended to show an interstitial when app is not in foreground.");
        localBundle = new Bundle();
        localBundle.putString("appid", str);
        localBundle.putString("action", "show_interstitial_app_not_in_foreground");
        zzb(localBundle);
      }
      if (zzajs.zzgq()) {
        break;
      }
      if ((!zzajs.zzaoz.zzccc) || (zzajs.zzaoz.zzbos == null)) {
        break label249;
      }
      try
      {
        zzajs.zzaoz.zzbos.showInterstitial();
        return;
      }
      catch (RemoteException localRemoteException)
      {
        zzkh.zzd("Could not show interstitial.", localRemoteException);
        zzeu();
        return;
      }
    }
    label249:
    if (zzajs.zzaoz.zzbtq == null)
    {
      zzkh.zzcy("The interstitial failed to load.");
      return;
    }
    if (zzajs.zzaoz.zzbtq.zzuo())
    {
      zzkh.zzcy("The interstitial is already showing.");
      return;
    }
    zzajs.zzaoz.zzbtq.zzah(true);
    if (zzajs.zzaoz.zzcii != null) {
      zzaju.zza(zzajs.zzaoy, zzajs.zzaoz);
    }
    if (zzajs.zzamc) {}
    for (Object localObject = zzu.zzfq().zzaj(zzajs.zzagf);; localObject = null)
    {
      zzalv = zzu.zzgh().zzb((Bitmap)localObject);
      if ((!((Boolean)zzdc.zzbby.get()).booleanValue()) || (localObject == null)) {
        break;
      }
      localObject = (Future)new zza(zzalv).zzpz();
      return;
    }
    localObject = new InterstitialAdParameterParcel(zzajs.zzamc, zzet(), false, 0.0F, -1);
    int j = zzajs.zzaoz.zzbtq.getRequestedOrientation();
    int i = j;
    if (j == -1) {
      i = zzajs.zzaoz.orientation;
    }
    localObject = new AdOverlayInfoParcel(this, this, this, zzajs.zzaoz.zzbtq, i, zzajs.zzaou, zzajs.zzaoz.zzcch, (InterstitialAdParameterParcel)localObject);
    zzu.zzfo().zza(zzajs.zzagf, (AdOverlayInfoParcel)localObject);
  }
  
  protected zzll zza(zzjy.zza paramzza, zze paramzze, zzjs paramzzjs)
  {
    zzll localzzll = zzu.zzfr().zza(zzajs.zzagf, zzajs.zzaoy, false, false, zzajs.zzaot, zzajs.zzaou, zzajn, this, zzajv);
    localzzll.zzuk().zza(this, null, this, this, ((Boolean)zzdc.zzazr.get()).booleanValue(), this, this, paramzze, null, paramzzjs);
    zza(localzzll);
    localzzll.zzda(zzcit.zzcbk);
    zzfc.zza(localzzll, this);
    zzes.zzd(localzzll);
    return localzzll;
  }
  
  public void zza(zzjy.zza paramzza, zzdk paramzzdk)
  {
    int j = 1;
    if (!((Boolean)zzdc.zzbac.get()).booleanValue())
    {
      super.zza(paramzza, paramzzdk);
      return;
    }
    if (errorCode != -2)
    {
      super.zza(paramzza, paramzzdk);
      return;
    }
    Bundle localBundle = zzcit.zzcav.zzatu.getBundle("com.google.ads.mediation.admob.AdMobAdapter");
    int i;
    if ((localBundle == null) || (!localBundle.containsKey("gw")))
    {
      i = 1;
      if (zzciu.zzccc) {
        break label125;
      }
    }
    for (;;)
    {
      if ((i != 0) && (j != 0)) {
        zzajs.zzapa = zzc(paramzza);
      }
      super.zza(zzajs.zzapa, paramzzdk);
      return;
      i = 0;
      break;
      label125:
      j = 0;
    }
  }
  
  public void zza(boolean paramBoolean, float paramFloat)
  {
    zzalw = paramBoolean;
    zzalx = paramFloat;
  }
  
  public boolean zza(AdRequestParcel paramAdRequestParcel, zzdk paramzzdk)
  {
    if (zzajs.zzaoz != null)
    {
      zzkh.zzcy("An interstitial is already loading. Aborting.");
      return false;
    }
    return super.zza(paramAdRequestParcel, paramzzdk);
  }
  
  protected boolean zza(AdRequestParcel paramAdRequestParcel, zzjy paramzzjy, boolean paramBoolean)
  {
    if ((zzajs.zzgp()) && (zzbtq != null)) {
      zzu.zzfs().zzj(zzbtq);
    }
    return zzajr.zzfc();
  }
  
  public boolean zza(zzjy paramzzjy1, zzjy paramzzjy2)
  {
    if (!super.zza(paramzzjy1, paramzzjy2)) {
      return false;
    }
    if ((!zzajs.zzgp()) && (zzajs.zzapt != null) && (zzcii != null)) {
      zzaju.zza(zzajs.zzaoy, paramzzjy2, zzajs.zzapt);
    }
    return true;
  }
  
  public void zzb(RewardItemParcel paramRewardItemParcel)
  {
    RewardItemParcel localRewardItemParcel = paramRewardItemParcel;
    if (zzajs.zzaoz != null)
    {
      if (zzajs.zzaoz.zzcct != null) {
        zzu.zzfq().zza(zzajs.zzagf, zzajs.zzaou.zzcs, zzajs.zzaoz.zzcct);
      }
      localRewardItemParcel = paramRewardItemParcel;
      if (zzajs.zzaoz.zzccr != null) {
        localRewardItemParcel = zzajs.zzaoz.zzccr;
      }
    }
    zza(localRewardItemParcel);
  }
  
  protected void zzds()
  {
    zzeu();
    super.zzds();
  }
  
  protected void zzdv()
  {
    super.zzdv();
    zzalu = true;
  }
  
  public void zzdz()
  {
    recordImpression();
    super.zzdz();
    if ((zzajs.zzaoz != null) && (zzajs.zzaoz.zzbtq != null))
    {
      zzlm localzzlm = zzajs.zzaoz.zzbtq.zzuk();
      if (localzzlm != null) {
        localzzlm.zzvb();
      }
    }
  }
  
  protected boolean zzet()
  {
    if (!(zzajs.zzagf instanceof Activity)) {}
    Window localWindow;
    do
    {
      return false;
      localWindow = ((Activity)zzajs.zzagf).getWindow();
    } while ((localWindow == null) || (localWindow.getDecorView() == null));
    Rect localRect1 = new Rect();
    Rect localRect2 = new Rect();
    localWindow.getDecorView().getGlobalVisibleRect(localRect1, null);
    localWindow.getDecorView().getWindowVisibleDisplayFrame(localRect2);
    if ((bottom != 0) && (bottom != 0) && (top == top)) {}
    for (boolean bool = true;; bool = false) {
      return bool;
    }
  }
  
  public void zzeu()
  {
    zzu.zzgh().zzb(Integer.valueOf(zzalv));
    if (zzajs.zzgp())
    {
      zzajs.zzgm();
      zzajs.zzaoz = null;
      zzajs.zzamc = false;
      zzalu = false;
    }
  }
  
  public void zzev()
  {
    if ((zzajs.zzaoz != null) && (zzajs.zzaoz.zzcin != null)) {
      zzu.zzfq().zza(zzajs.zzagf, zzajs.zzaou.zzcs, zzajs.zzaoz.zzcin);
    }
    zzdw();
  }
  
  public void zzg(boolean paramBoolean)
  {
    zzajs.zzamc = paramBoolean;
  }
  
  @zzir
  private class zza
    extends zzkg
  {
    private final int zzaly;
    
    public zza(int paramInt)
    {
      zzaly = paramInt;
    }
    
    public void onStop() {}
    
    public void zzew()
    {
      boolean bool1 = zzajs.zzamc;
      boolean bool2 = zzet();
      boolean bool3 = zzl.zza(zzl.this);
      float f = zzl.zzb(zzl.this);
      int i;
      final Object localObject;
      if (zzajs.zzamc)
      {
        i = zzaly;
        localObject = new InterstitialAdParameterParcel(bool1, bool2, bool3, f, i);
        i = zzajs.zzaoz.zzbtq.getRequestedOrientation();
        if (i != -1) {
          break label192;
        }
        i = zzajs.zzaoz.orientation;
      }
      label192:
      for (;;)
      {
        localObject = new AdOverlayInfoParcel(zzl.this, zzl.this, zzl.this, zzajs.zzaoz.zzbtq, i, zzajs.zzaou, zzajs.zzaoz.zzcch, (InterstitialAdParameterParcel)localObject);
        zzkl.zzclg.post(new Runnable()
        {
          public void run()
          {
            zzu.zzfo().zza(zzajs.zzagf, localObject);
          }
        });
        return;
        i = -1;
        break;
      }
    }
  }
}

/* Location:
 * Qualified Name:     com.google.android.gms.ads.internal.zzl
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */