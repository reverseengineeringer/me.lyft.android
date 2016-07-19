package com.google.android.gms.ads.internal.overlay;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.Color;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.os.Handler;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.view.ViewParent;
import android.view.Window;
import android.webkit.WebChromeClient.CustomViewCallback;
import android.widget.FrameLayout;
import android.widget.RelativeLayout;
import android.widget.RelativeLayout.LayoutParams;
import com.google.android.gms.ads.internal.InterstitialAdParameterParcel;
import com.google.android.gms.ads.internal.util.client.VersionInfoParcel;
import com.google.android.gms.internal.zzcy;
import com.google.android.gms.internal.zzdc;
import com.google.android.gms.internal.zzhm.zza;
import com.google.android.gms.internal.zzir;
import com.google.android.gms.internal.zzkg;
import com.google.android.gms.internal.zzkh;
import com.google.android.gms.internal.zzkl;
import com.google.android.gms.internal.zzkm;
import com.google.android.gms.internal.zzko;
import com.google.android.gms.internal.zzkt;
import com.google.android.gms.internal.zzll;
import com.google.android.gms.internal.zzlm;
import com.google.android.gms.internal.zzlm.zza;
import com.google.android.gms.internal.zzln;
import java.util.Collections;
import java.util.Map;
import java.util.concurrent.Future;

@zzir
public class zzd
  extends zzhm.zza
  implements zzu
{
  static final int zzbsr = Color.argb(0, 0, 0, 0);
  private final Activity mActivity;
  zzll zzbgj;
  AdOverlayInfoParcel zzbss;
  zzc zzbst;
  zzo zzbsu;
  boolean zzbsv = false;
  FrameLayout zzbsw;
  WebChromeClient.CustomViewCallback zzbsx;
  boolean zzbsy = false;
  boolean zzbsz = false;
  zzb zzbta;
  boolean zzbtb = false;
  int zzbtc = 0;
  zzl zzbtd;
  private boolean zzbte;
  private boolean zzbtf = false;
  private boolean zzbtg = true;
  
  public zzd(Activity paramActivity)
  {
    mActivity = paramActivity;
    zzbtd = new zzs();
  }
  
  public void close()
  {
    zzbtc = 2;
    mActivity.finish();
  }
  
  public void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent) {}
  
  public void onBackPressed()
  {
    zzbtc = 0;
  }
  
  public void onCreate(Bundle paramBundle)
  {
    boolean bool = false;
    mActivity.requestWindowFeature(1);
    if (paramBundle != null) {
      bool = paramBundle.getBoolean("com.google.android.gms.ads.internal.overlay.hasResumed", false);
    }
    zzbsy = bool;
    try
    {
      zzbss = AdOverlayInfoParcel.zzb(mActivity.getIntent());
      if (zzbss != null) {
        break label80;
      }
      throw new zza("Could not get info for ad overlay.");
    }
    catch (zza paramBundle)
    {
      zzkh.zzcy(paramBundle.getMessage());
      zzbtc = 3;
      mActivity.finish();
    }
    return;
    label80:
    if (zzbss.zzaou.zzcnp > 7500000) {
      zzbtc = 3;
    }
    if (mActivity.getIntent() != null) {
      zzbtg = mActivity.getIntent().getBooleanExtra("shouldCallOnOverlayOpened", true);
    }
    if (zzbss.zzbtz != null)
    {
      zzbsz = zzbss.zzbtz.zzamc;
      label151:
      if ((((Boolean)zzdc.zzbby.get()).booleanValue()) && (zzbsz) && (zzbss.zzbtz.zzamh != -1)) {
        Future localFuture = (Future)new zzd(null).zzpz();
      }
      if (paramBundle == null)
      {
        if ((zzbss.zzbtp != null) && (zzbtg)) {
          zzbss.zzbtp.zzdz();
        }
        if ((zzbss.zzbtw != 1) && (zzbss.zzbto != null)) {
          zzbss.zzbto.onAdClicked();
        }
      }
      zzbta = new zzb(mActivity, zzbss.zzbty);
      zzbta.setId(1000);
      switch (zzbss.zzbtw)
      {
      }
    }
    for (;;)
    {
      throw new zza("Could not determine ad overlay type.");
      zzbsz = false;
      break label151;
      zzaa(false);
      return;
      zzbst = new zzc(zzbss.zzbtq);
      zzaa(false);
      return;
      zzaa(true);
      return;
      if (zzbsy)
      {
        zzbtc = 3;
        mActivity.finish();
        return;
      }
      if (com.google.android.gms.ads.internal.zzu.zzfn().zza(mActivity, zzbss.zzbtn, zzbss.zzbtv)) {
        break;
      }
      zzbtc = 3;
      mActivity.finish();
      return;
    }
  }
  
  public void onDestroy()
  {
    if (zzbgj != null) {
      zzbta.removeView(zzbgj.getView());
    }
    zzoa();
  }
  
  public void onPause()
  {
    zzbtd.pause();
    zznw();
    if (zzbss.zzbtp != null) {
      zzbss.zzbtp.onPause();
    }
    if ((zzbgj != null) && ((!mActivity.isFinishing()) || (zzbst == null))) {
      com.google.android.gms.ads.internal.zzu.zzfs().zzj(zzbgj);
    }
    zzoa();
  }
  
  public void onRestart() {}
  
  public void onResume()
  {
    if ((zzbss != null) && (zzbss.zzbtw == 4))
    {
      if (zzbsy)
      {
        zzbtc = 3;
        mActivity.finish();
      }
    }
    else
    {
      if (zzbss.zzbtp != null) {
        zzbss.zzbtp.onResume();
      }
      if ((zzbgj == null) || (zzbgj.isDestroyed())) {
        break label107;
      }
      com.google.android.gms.ads.internal.zzu.zzfs().zzk(zzbgj);
    }
    for (;;)
    {
      zzbtd.resume();
      return;
      zzbsy = true;
      break;
      label107:
      zzkh.zzcy("The webview does not exit. Ignoring action.");
    }
  }
  
  public void onSaveInstanceState(Bundle paramBundle)
  {
    paramBundle.putBoolean("com.google.android.gms.ads.internal.overlay.hasResumed", zzbsy);
  }
  
  public void onStart() {}
  
  public void onStop()
  {
    zzoa();
  }
  
  public void setRequestedOrientation(int paramInt)
  {
    mActivity.setRequestedOrientation(paramInt);
  }
  
  public void zza(View paramView, WebChromeClient.CustomViewCallback paramCustomViewCallback)
  {
    zzbsw = new FrameLayout(mActivity);
    zzbsw.setBackgroundColor(-16777216);
    zzbsw.addView(paramView, -1, -1);
    mActivity.setContentView(zzbsw);
    zzdc();
    zzbsx = paramCustomViewCallback;
    zzbsv = true;
  }
  
  public void zza(boolean paramBoolean1, boolean paramBoolean2)
  {
    if (zzbsu != null) {
      zzbsu.zza(paramBoolean1, paramBoolean2);
    }
  }
  
  protected void zzaa(boolean paramBoolean)
    throws zzd.zza
  {
    if (!zzbte) {
      mActivity.requestWindowFeature(1);
    }
    Object localObject = mActivity.getWindow();
    if (localObject == null) {
      throw new zza("Invalid activity, no window available.");
    }
    if ((!zzbsz) || ((zzbss.zzbtz != null) && (zzbss.zzbtz.zzamd))) {
      ((Window)localObject).setFlags(1024, 1024);
    }
    boolean bool2 = zzbss.zzbtq.zzuk().zzho();
    zzbtb = false;
    boolean bool1;
    if (bool2)
    {
      if (zzbss.orientation != com.google.android.gms.ads.internal.zzu.zzfs().zztk()) {
        break label597;
      }
      if (mActivity.getResources().getConfiguration().orientation == 1)
      {
        bool1 = true;
        zzbtb = bool1;
      }
    }
    else
    {
      label147:
      bool1 = zzbtb;
      zzkh.zzcw(46 + "Delay onShow to next orientation change: " + bool1);
      setRequestedOrientation(zzbss.orientation);
      if (com.google.android.gms.ads.internal.zzu.zzfs().zza((Window)localObject)) {
        zzkh.zzcw("Hardware acceleration on the AdActivity window enabled.");
      }
      if (zzbsz) {
        break label645;
      }
      zzbta.setBackgroundColor(-16777216);
      label222:
      mActivity.setContentView(zzbta);
      zzdc();
      if (!paramBoolean) {
        break label712;
      }
      zzbgj = com.google.android.gms.ads.internal.zzu.zzfr().zza(mActivity, zzbss.zzbtq.zzdo(), true, bool2, null, zzbss.zzaou, null, null, zzbss.zzbtq.zzuh());
      zzbgj.zzuk().zza(null, null, zzbss.zzbtr, zzbss.zzbtv, true, zzbss.zzbtx, null, zzbss.zzbtq.zzuk().zzuy(), null, null);
      zzbgj.zzuk().zza(new zzlm.zza()
      {
        public void zza(zzll paramAnonymouszzll, boolean paramAnonymousBoolean)
        {
          paramAnonymouszzll.zzoc();
        }
      });
      if (zzbss.url == null) {
        break label658;
      }
      zzbgj.loadUrl(zzbss.url);
      label391:
      if (zzbss.zzbtq != null) {
        zzbss.zzbtq.zzc(this);
      }
      label414:
      zzbgj.zzb(this);
      localObject = zzbgj.getParent();
      if ((localObject != null) && ((localObject instanceof ViewGroup))) {
        ((ViewGroup)localObject).removeView(zzbgj.getView());
      }
      if (zzbsz) {
        zzbgj.setBackgroundColor(zzbsr);
      }
      zzbta.addView(zzbgj.getView(), -1, -1);
      if ((!paramBoolean) && (!zzbtb)) {
        zzoc();
      }
      zzz(bool2);
      if (zzbgj.zzul()) {
        zza(bool2, true);
      }
      localObject = zzbgj.zzuh();
      if (localObject == null) {
        break label739;
      }
    }
    label597:
    label645:
    label658:
    label712:
    label739:
    for (localObject = zzakl;; localObject = null)
    {
      if (localObject == null) {
        break label745;
      }
      zzbtd = ((zzm)localObject).zza(mActivity, zzbgj, zzbta);
      return;
      bool1 = false;
      break;
      if (zzbss.orientation != com.google.android.gms.ads.internal.zzu.zzfs().zztl()) {
        break label147;
      }
      if (mActivity.getResources().getConfiguration().orientation == 2) {}
      for (bool1 = true;; bool1 = false)
      {
        zzbtb = bool1;
        break;
      }
      zzbta.setBackgroundColor(zzbsr);
      break label222;
      if (zzbss.zzbtu != null)
      {
        zzbgj.loadDataWithBaseURL(zzbss.zzbts, zzbss.zzbtu, "text/html", "UTF-8", null);
        break label391;
      }
      throw new zza("No URL or HTML to display in ad overlay.");
      zzbgj = zzbss.zzbtq;
      zzbgj.setContext(mActivity);
      break label414;
    }
    label745:
    zzkh.zzcy("Appstreaming controller is null.");
  }
  
  protected void zzaf(int paramInt)
  {
    zzbgj.zzaf(paramInt);
  }
  
  public void zzdc()
  {
    zzbte = true;
  }
  
  public void zzf(zzll paramzzll, Map<String, String> paramMap)
  {
    zzbtd.zzf(paramzzll, paramMap);
  }
  
  public void zznw()
  {
    if ((zzbss != null) && (zzbsv)) {
      setRequestedOrientation(zzbss.orientation);
    }
    if (zzbsw != null)
    {
      mActivity.setContentView(zzbta);
      zzdc();
      zzbsw.removeAllViews();
      zzbsw = null;
    }
    if (zzbsx != null)
    {
      zzbsx.onCustomViewHidden();
      zzbsx = null;
    }
    zzbsv = false;
  }
  
  public void zznx()
  {
    zzbtc = 1;
    mActivity.finish();
  }
  
  public boolean zzny()
  {
    boolean bool1 = true;
    boolean bool2 = true;
    zzbtc = 0;
    if (zzbgj == null) {
      return bool2;
    }
    if ((zzbgj.zzow()) && (zzbtd.zzow())) {}
    for (;;)
    {
      bool2 = bool1;
      if (bool1) {
        break;
      }
      zzbgj.zza("onbackblocked", Collections.emptyMap());
      return bool1;
      bool1 = false;
    }
  }
  
  public void zznz()
  {
    zzbta.removeView(zzbsu);
    zzz(true);
  }
  
  protected void zzoa()
  {
    if ((!mActivity.isFinishing()) || (zzbtf)) {
      return;
    }
    zzbtf = true;
    if (zzbgj != null)
    {
      zzaf(zzbtc);
      zzbta.removeView(zzbgj.getView());
      if (zzbst == null) {
        break label169;
      }
      zzbgj.setContext(zzbst.zzagf);
      zzbgj.zzah(false);
      zzbst.zzbtk.addView(zzbgj.getView(), zzbst.index, zzbst.zzbtj);
      zzbst = null;
    }
    for (;;)
    {
      zzbgj = null;
      if ((zzbss != null) && (zzbss.zzbtp != null)) {
        zzbss.zzbtp.zzdy();
      }
      zzbtd.destroy();
      return;
      label169:
      if (mActivity.getApplicationContext() != null) {
        zzbgj.setContext(mActivity.getApplicationContext());
      }
    }
  }
  
  public void zzob()
  {
    if (zzbtb)
    {
      zzbtb = false;
      zzoc();
    }
  }
  
  protected void zzoc()
  {
    zzbgj.zzoc();
  }
  
  public void zzod()
  {
    zzbta.disable();
  }
  
  public void zzz(boolean paramBoolean)
  {
    RelativeLayout.LayoutParams localLayoutParams;
    if (paramBoolean)
    {
      i = 50;
      zzbsu = new zzo(mActivity, i, this);
      localLayoutParams = new RelativeLayout.LayoutParams(-2, -2);
      localLayoutParams.addRule(10);
      if (!paramBoolean) {
        break label88;
      }
    }
    label88:
    for (int i = 11;; i = 9)
    {
      localLayoutParams.addRule(i);
      zzbsu.zza(paramBoolean, zzbss.zzbtt);
      zzbta.addView(zzbsu, localLayoutParams);
      return;
      i = 32;
      break;
    }
  }
  
  @zzir
  private static final class zza
    extends Exception
  {
    public zza(String paramString)
    {
      super();
    }
  }
  
  @zzir
  static class zzb
    extends RelativeLayout
  {
    zzko zzaqd;
    boolean zzbti;
    
    public zzb(Context paramContext, String paramString)
    {
      super();
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
  
  @zzir
  public static class zzc
  {
    public final int index;
    public final Context zzagf;
    public final ViewGroup.LayoutParams zzbtj;
    public final ViewGroup zzbtk;
    
    public zzc(zzll paramzzll)
      throws zzd.zza
    {
      zzbtj = paramzzll.getLayoutParams();
      ViewParent localViewParent = paramzzll.getParent();
      zzagf = paramzzll.zzug();
      if ((localViewParent != null) && ((localViewParent instanceof ViewGroup)))
      {
        zzbtk = ((ViewGroup)localViewParent);
        index = zzbtk.indexOfChild(paramzzll.getView());
        zzbtk.removeView(paramzzll.getView());
        paramzzll.zzah(true);
        return;
      }
      throw new zzd.zza("Could not get the parent of the WebView for an overlay.");
    }
  }
  
  @zzir
  private class zzd
    extends zzkg
  {
    private zzd() {}
    
    public void onStop() {}
    
    public void zzew()
    {
      final Object localObject = com.google.android.gms.ads.internal.zzu.zzgh().zza(Integer.valueOf(zzbss.zzbtz.zzamh));
      if (localObject != null)
      {
        localObject = com.google.android.gms.ads.internal.zzu.zzfs().zza(zzd.zza(zzd.this), (Bitmap)localObject, zzbss.zzbtz.zzamf, zzbss.zzbtz.zzamg);
        zzkl.zzclg.post(new Runnable()
        {
          public void run()
          {
            zzd.zza(zzd.this).getWindow().setBackgroundDrawable(localObject);
          }
        });
      }
    }
  }
}

/* Location:
 * Qualified Name:     com.google.android.gms.ads.internal.overlay.zzd
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */