package com.google.android.gms.internal;

import android.annotation.TargetApi;
import android.app.Activity;
import android.content.ActivityNotFoundException;
import android.content.Context;
import android.content.Intent;
import android.content.MutableContextWrapper;
import android.content.res.Resources;
import android.graphics.Canvas;
import android.net.Uri;
import android.os.Build.VERSION;
import android.os.Handler;
import android.util.DisplayMetrics;
import android.view.Display;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.MeasureSpec;
import android.view.View.OnClickListener;
import android.view.ViewTreeObserver.OnGlobalLayoutListener;
import android.view.WindowManager;
import android.webkit.DownloadListener;
import android.webkit.ValueCallback;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import com.google.android.gms.ads.internal.client.AdSizeParcel;
import com.google.android.gms.ads.internal.client.zzm;
import com.google.android.gms.ads.internal.util.client.VersionInfoParcel;
import com.google.android.gms.ads.internal.util.client.zza;
import com.google.android.gms.ads.internal.zzu;
import java.lang.ref.WeakReference;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONException;
import org.json.JSONObject;

@zzir
class zzlp
  extends WebView
  implements ViewTreeObserver.OnGlobalLayoutListener, DownloadListener, zzll
{
  private final Object zzail = new Object();
  private final com.google.android.gms.ads.internal.zzd zzajv;
  private final VersionInfoParcel zzalm;
  private AdSizeParcel zzang;
  private zzky zzaqe;
  private final WindowManager zzaqk;
  private final zzas zzbgh;
  private int zzbrj = -1;
  private int zzbrk = -1;
  private int zzbrm = -1;
  private int zzbrn = -1;
  private String zzbvu = "";
  private Boolean zzcka;
  private final zza zzcpf;
  private final com.google.android.gms.ads.internal.zzs zzcpg;
  private zzlm zzcph;
  private com.google.android.gms.ads.internal.overlay.zzd zzcpi;
  private boolean zzcpj;
  private boolean zzcpk;
  private boolean zzcpl;
  private boolean zzcpm;
  private int zzcpn;
  private boolean zzcpo = true;
  boolean zzcpp = false;
  private zzlq zzcpq;
  private boolean zzcpr;
  private zzdi zzcps;
  private zzdi zzcpt;
  private zzdi zzcpu;
  private zzdj zzcpv;
  private WeakReference<View.OnClickListener> zzcpw;
  private com.google.android.gms.ads.internal.overlay.zzd zzcpx;
  private Map<String, zzfh> zzcpy;
  
  protected zzlp(zza paramzza, AdSizeParcel paramAdSizeParcel, boolean paramBoolean1, boolean paramBoolean2, zzas paramzzas, VersionInfoParcel paramVersionInfoParcel, zzdk paramzzdk, com.google.android.gms.ads.internal.zzs paramzzs, com.google.android.gms.ads.internal.zzd paramzzd)
  {
    super(paramzza);
    zzcpf = paramzza;
    zzang = paramAdSizeParcel;
    zzcpl = paramBoolean1;
    zzcpn = -1;
    zzbgh = paramzzas;
    zzalm = paramVersionInfoParcel;
    zzcpg = paramzzs;
    zzajv = paramzzd;
    zzaqk = ((WindowManager)getContext().getSystemService("window"));
    setBackgroundColor(0);
    paramAdSizeParcel = getSettings();
    paramAdSizeParcel.setAllowFileAccess(false);
    paramAdSizeParcel.setJavaScriptEnabled(true);
    paramAdSizeParcel.setSavePassword(false);
    paramAdSizeParcel.setSupportMultipleWindows(true);
    paramAdSizeParcel.setJavaScriptCanOpenWindowsAutomatically(true);
    if (Build.VERSION.SDK_INT >= 21) {
      paramAdSizeParcel.setMixedContentMode(2);
    }
    zzu.zzfq().zza(paramzza, zzcs, paramAdSizeParcel);
    zzu.zzfs().zza(getContext(), paramAdSizeParcel);
    setDownloadListener(this);
    zzvj();
    if (com.google.android.gms.common.util.zzs.zzavo()) {
      addJavascriptInterface(new zzlr(this), "googleAdsJsInterface");
    }
    if (com.google.android.gms.common.util.zzs.zzavj())
    {
      removeJavascriptInterface("accessibility");
      removeJavascriptInterface("accessibilityTraversal");
    }
    zzaqe = new zzky(zzcpf.zzuf(), this, this, null);
    zzd(paramzzdk);
  }
  
  private void zzal(boolean paramBoolean)
  {
    HashMap localHashMap = new HashMap();
    if (paramBoolean) {}
    for (String str = "1";; str = "0")
    {
      localHashMap.put("isVisible", str);
      zza("onAdVisibilityChanged", localHashMap);
      return;
    }
  }
  
  static zzlp zzb(Context paramContext, AdSizeParcel paramAdSizeParcel, boolean paramBoolean1, boolean paramBoolean2, zzas paramzzas, VersionInfoParcel paramVersionInfoParcel, zzdk paramzzdk, com.google.android.gms.ads.internal.zzs paramzzs, com.google.android.gms.ads.internal.zzd paramzzd)
  {
    return new zzlp(new zza(paramContext), paramAdSizeParcel, paramBoolean1, paramBoolean2, paramzzas, paramVersionInfoParcel, paramzzdk, paramzzs, paramzzd);
  }
  
  private void zzd(zzdk paramzzdk)
  {
    zzvn();
    zzcpv = new zzdj(new zzdk(true, "make_wv", zzang.zzaup));
    zzcpv.zzkf().zzc(paramzzdk);
    zzcpt = zzdg.zzb(zzcpv.zzkf());
    zzcpv.zza("native:view_create", zzcpt);
    zzcpu = null;
    zzcps = null;
  }
  
  private void zzvh()
  {
    synchronized (zzail)
    {
      zzcka = zzu.zzft().zzsr();
      Boolean localBoolean = zzcka;
      if (localBoolean == null) {}
      try
      {
        evaluateJavascript("(function(){})()", null);
        zzb(Boolean.valueOf(true));
        return;
      }
      catch (IllegalStateException localIllegalStateException)
      {
        for (;;)
        {
          zzb(Boolean.valueOf(false));
        }
      }
    }
  }
  
  private void zzvi()
  {
    zzdg.zza(zzcpv.zzkf(), zzcpt, new String[] { "aeh2" });
  }
  
  private void zzvj()
  {
    for (;;)
    {
      synchronized (zzail)
      {
        if ((zzcpl) || (zzang.zzauq))
        {
          if (Build.VERSION.SDK_INT < 14)
          {
            zzkh.zzcw("Disabling hardware acceleration on an overlay.");
            zzvk();
            return;
          }
          zzkh.zzcw("Enabling hardware acceleration on an overlay.");
          zzvl();
        }
      }
      if (Build.VERSION.SDK_INT < 18)
      {
        zzkh.zzcw("Disabling hardware acceleration on an AdView.");
        zzvk();
      }
      else
      {
        zzkh.zzcw("Enabling hardware acceleration on an AdView.");
        zzvl();
      }
    }
  }
  
  private void zzvk()
  {
    synchronized (zzail)
    {
      if (!zzcpm) {
        zzu.zzfs().zzp(this);
      }
      zzcpm = true;
      return;
    }
  }
  
  private void zzvl()
  {
    synchronized (zzail)
    {
      if (zzcpm) {
        zzu.zzfs().zzo(this);
      }
      zzcpm = false;
      return;
    }
  }
  
  private void zzvm()
  {
    synchronized (zzail)
    {
      zzcpy = null;
      return;
    }
  }
  
  private void zzvn()
  {
    if (zzcpv == null) {}
    zzdk localzzdk;
    do
    {
      return;
      localzzdk = zzcpv.zzkf();
    } while ((localzzdk == null) || (zzu.zzft().zzsm() == null));
    zzu.zzft().zzsm().zza(localzzdk);
  }
  
  public void destroy()
  {
    synchronized (zzail)
    {
      zzvn();
      zzaqe.zztu();
      if (zzcpi != null)
      {
        zzcpi.close();
        zzcpi.onDestroy();
        zzcpi = null;
      }
      zzcph.reset();
      if (zzcpk) {
        return;
      }
      zzu.zzgj().zze(this);
      zzvm();
      zzcpk = true;
      zzkh.v("Initiating WebView self destruct sequence in 3...");
      zzcph.zzva();
      return;
    }
  }
  
  @TargetApi(19)
  public void evaluateJavascript(String paramString, ValueCallback<String> paramValueCallback)
  {
    synchronized (zzail)
    {
      if (isDestroyed())
      {
        zzkh.zzcy("The webview is destroyed. Ignoring action.");
        if (paramValueCallback != null) {
          paramValueCallback.onReceiveValue(null);
        }
        return;
      }
      super.evaluateJavascript(paramString, paramValueCallback);
      return;
    }
  }
  
  protected void finalize()
    throws Throwable
  {
    synchronized (zzail)
    {
      if (!zzcpk)
      {
        zzcph.reset();
        zzu.zzgj().zze(this);
        zzvm();
      }
      super.finalize();
      return;
    }
  }
  
  public String getRequestId()
  {
    synchronized (zzail)
    {
      String str = zzbvu;
      return str;
    }
  }
  
  public int getRequestedOrientation()
  {
    synchronized (zzail)
    {
      int i = zzcpn;
      return i;
    }
  }
  
  public View getView()
  {
    return this;
  }
  
  public WebView getWebView()
  {
    return this;
  }
  
  public boolean isDestroyed()
  {
    synchronized (zzail)
    {
      boolean bool = zzcpk;
      return bool;
    }
  }
  
  public void loadData(String paramString1, String paramString2, String paramString3)
  {
    synchronized (zzail)
    {
      if (!isDestroyed())
      {
        super.loadData(paramString1, paramString2, paramString3);
        return;
      }
      zzkh.zzcy("The webview is destroyed. Ignoring action.");
    }
  }
  
  public void loadDataWithBaseURL(String paramString1, String paramString2, String paramString3, String paramString4, String paramString5)
  {
    synchronized (zzail)
    {
      if (!isDestroyed())
      {
        super.loadDataWithBaseURL(paramString1, paramString2, paramString3, paramString4, paramString5);
        return;
      }
      zzkh.zzcy("The webview is destroyed. Ignoring action.");
    }
  }
  
  public void loadUrl(String paramString)
  {
    for (;;)
    {
      synchronized (zzail)
      {
        boolean bool = isDestroyed();
        if (!bool) {
          try
          {
            super.loadUrl(paramString);
            return;
          }
          catch (Throwable paramString)
          {
            paramString = String.valueOf(paramString);
            zzkh.zzcy(String.valueOf(paramString).length() + 24 + "Could not call loadUrl. " + paramString);
            continue;
          }
        }
      }
      zzkh.zzcy("The webview is destroyed. Ignoring action.");
    }
  }
  
  protected void onAttachedToWindow()
  {
    synchronized (zzail)
    {
      super.onAttachedToWindow();
      if (!isDestroyed()) {
        zzaqe.onAttachedToWindow();
      }
      zzal(zzcpr);
      return;
    }
  }
  
  protected void onDetachedFromWindow()
  {
    synchronized (zzail)
    {
      if (!isDestroyed()) {
        zzaqe.onDetachedFromWindow();
      }
      super.onDetachedFromWindow();
      zzal(false);
      return;
    }
  }
  
  public void onDownloadStart(String paramString1, String paramString2, String paramString3, String paramString4, long paramLong)
  {
    try
    {
      paramString2 = new Intent("android.intent.action.VIEW");
      paramString2.setDataAndType(Uri.parse(paramString1), paramString4);
      zzu.zzfq().zzb(getContext(), paramString2);
      return;
    }
    catch (ActivityNotFoundException paramString2)
    {
      zzkh.zzcw(String.valueOf(paramString1).length() + 51 + String.valueOf(paramString4).length() + "Couldn't find an Activity to view url/mimetype: " + paramString1 + " / " + paramString4);
    }
  }
  
  @TargetApi(21)
  protected void onDraw(Canvas paramCanvas)
  {
    if (isDestroyed()) {}
    while ((Build.VERSION.SDK_INT == 21) && (paramCanvas.isHardwareAccelerated()) && (!isAttachedToWindow())) {
      return;
    }
    super.onDraw(paramCanvas);
  }
  
  public void onGlobalLayout()
  {
    boolean bool = zzvg();
    com.google.android.gms.ads.internal.overlay.zzd localzzd = zzui();
    if ((localzzd != null) && (bool)) {
      localzzd.zzob();
    }
  }
  
  protected void onMeasure(int paramInt1, int paramInt2)
  {
    int k = Integer.MAX_VALUE;
    synchronized (zzail)
    {
      if (isDestroyed())
      {
        setMeasuredDimension(0, 0);
        return;
      }
      if ((isInEditMode()) || (zzcpl) || (zzang.zzaus) || (zzang.zzaut))
      {
        super.onMeasure(paramInt1, paramInt2);
        return;
      }
    }
    if (zzang.zzauq)
    {
      DisplayMetrics localDisplayMetrics = new DisplayMetrics();
      zzaqk.getDefaultDisplay().getMetrics(localDisplayMetrics);
      setMeasuredDimension(widthPixels, heightPixels);
      return;
    }
    int n = View.MeasureSpec.getMode(paramInt1);
    int i = View.MeasureSpec.getSize(paramInt1);
    int m = View.MeasureSpec.getMode(paramInt2);
    int j = View.MeasureSpec.getSize(paramInt2);
    if (n != Integer.MIN_VALUE) {
      if (n == 1073741824) {
        break label382;
      }
    }
    for (;;)
    {
      if ((zzang.widthPixels > paramInt1) || (zzang.heightPixels > paramInt2))
      {
        float f = zzcpf.getResources().getDisplayMetrics().density;
        paramInt1 = (int)(zzang.widthPixels / f);
        paramInt2 = (int)(zzang.heightPixels / f);
        i = (int)(i / f);
        j = (int)(j / f);
        zzkh.zzcy(103 + "Not enough space to show ad. Needs " + paramInt1 + "x" + paramInt2 + " dp, but only has " + i + "x" + j + " dp.");
        if (getVisibility() != 8) {
          setVisibility(4);
        }
        setMeasuredDimension(0, 0);
      }
      for (;;)
      {
        return;
        if (getVisibility() != 8) {
          setVisibility(0);
        }
        setMeasuredDimension(zzang.widthPixels, zzang.heightPixels);
      }
      paramInt1 = Integer.MAX_VALUE;
      break label385;
      label382:
      paramInt1 = i;
      label385:
      if (m != Integer.MIN_VALUE)
      {
        paramInt2 = k;
        if (m != 1073741824) {}
      }
      else
      {
        paramInt2 = j;
      }
    }
  }
  
  public void onPause()
  {
    if (isDestroyed()) {}
    for (;;)
    {
      return;
      try
      {
        if (com.google.android.gms.common.util.zzs.zzavj())
        {
          super.onPause();
          return;
        }
      }
      catch (Exception localException)
      {
        zzkh.zzb("Could not pause webview.", localException);
      }
    }
  }
  
  public void onResume()
  {
    if (isDestroyed()) {}
    for (;;)
    {
      return;
      try
      {
        if (com.google.android.gms.common.util.zzs.zzavj())
        {
          super.onResume();
          return;
        }
      }
      catch (Exception localException)
      {
        zzkh.zzb("Could not resume webview.", localException);
      }
    }
  }
  
  public boolean onTouchEvent(MotionEvent paramMotionEvent)
  {
    if (zzbgh != null) {
      zzbgh.zza(paramMotionEvent);
    }
    if (isDestroyed()) {
      return false;
    }
    return super.onTouchEvent(paramMotionEvent);
  }
  
  public void setContext(Context paramContext)
  {
    zzcpf.setBaseContext(paramContext);
    zzaqe.zzl(zzcpf.zzuf());
  }
  
  public void setOnClickListener(View.OnClickListener paramOnClickListener)
  {
    zzcpw = new WeakReference(paramOnClickListener);
    super.setOnClickListener(paramOnClickListener);
  }
  
  public void setRequestedOrientation(int paramInt)
  {
    synchronized (zzail)
    {
      zzcpn = paramInt;
      if (zzcpi != null) {
        zzcpi.setRequestedOrientation(zzcpn);
      }
      return;
    }
  }
  
  public void setWebViewClient(WebViewClient paramWebViewClient)
  {
    super.setWebViewClient(paramWebViewClient);
    if ((paramWebViewClient instanceof zzlm)) {
      zzcph = ((zzlm)paramWebViewClient);
    }
  }
  
  public void stopLoading()
  {
    if (isDestroyed()) {
      return;
    }
    try
    {
      super.stopLoading();
      return;
    }
    catch (Exception localException)
    {
      zzkh.zzb("Could not stop loading webview.", localException);
    }
  }
  
  public void zza(Context paramContext, AdSizeParcel paramAdSizeParcel, zzdk paramzzdk)
  {
    synchronized (zzail)
    {
      zzaqe.zztu();
      setContext(paramContext);
      zzcpi = null;
      zzang = paramAdSizeParcel;
      zzcpl = false;
      zzcpj = false;
      zzbvu = "";
      zzcpn = -1;
      zzu.zzfs().zzk(this);
      loadUrl("about:blank");
      zzcph.reset();
      setOnTouchListener(null);
      setOnClickListener(null);
      zzcpo = true;
      zzcpp = false;
      zzcpq = null;
      zzd(paramzzdk);
      zzcpr = false;
      zzu.zzgj().zze(this);
      zzvm();
      return;
    }
  }
  
  public void zza(AdSizeParcel paramAdSizeParcel)
  {
    synchronized (zzail)
    {
      zzang = paramAdSizeParcel;
      requestLayout();
      return;
    }
  }
  
  public void zza(zzcd arg1, boolean paramBoolean)
  {
    synchronized (zzail)
    {
      zzcpr = paramBoolean;
      zzal(paramBoolean);
      return;
    }
  }
  
  public void zza(zzlq paramzzlq)
  {
    synchronized (zzail)
    {
      if (zzcpq != null)
      {
        zzkh.e("Attempt to create multiple AdWebViewVideoControllers.");
        return;
      }
      zzcpq = paramzzlq;
      return;
    }
  }
  
  @TargetApi(19)
  protected void zza(String paramString, ValueCallback<String> paramValueCallback)
  {
    synchronized (zzail)
    {
      if (!isDestroyed()) {
        evaluateJavascript(paramString, paramValueCallback);
      }
      do
      {
        return;
        zzkh.zzcy("The webview is destroyed. Ignoring action.");
      } while (paramValueCallback == null);
      paramValueCallback.onReceiveValue(null);
    }
  }
  
  public void zza(String paramString, zzet paramzzet)
  {
    if (zzcph != null) {
      zzcph.zza(paramString, paramzzet);
    }
  }
  
  public void zza(String paramString, Map<String, ?> paramMap)
  {
    try
    {
      paramMap = zzu.zzfq().zzam(paramMap);
      zzb(paramString, paramMap);
      return;
    }
    catch (JSONException paramString)
    {
      zzkh.zzcy("Could not convert parameters to JSON.");
    }
  }
  
  public void zza(String paramString, JSONObject paramJSONObject)
  {
    JSONObject localJSONObject = paramJSONObject;
    if (paramJSONObject == null) {
      localJSONObject = new JSONObject();
    }
    zzj(paramString, localJSONObject.toString());
  }
  
  public void zzaf(int paramInt)
  {
    zzvi();
    HashMap localHashMap = new HashMap(2);
    localHashMap.put("closetype", String.valueOf(paramInt));
    localHashMap.put("version", zzalm.zzcs);
    zza("onhide", localHashMap);
  }
  
  public void zzah(boolean paramBoolean)
  {
    synchronized (zzail)
    {
      zzcpl = paramBoolean;
      zzvj();
      return;
    }
  }
  
  public void zzai(boolean paramBoolean)
  {
    synchronized (zzail)
    {
      if (zzcpi != null)
      {
        zzcpi.zza(zzcph.zzho(), paramBoolean);
        return;
      }
      zzcpj = paramBoolean;
    }
  }
  
  public void zzaj(boolean paramBoolean)
  {
    synchronized (zzail)
    {
      zzcpo = paramBoolean;
      return;
    }
  }
  
  public void zzb(com.google.android.gms.ads.internal.overlay.zzd paramzzd)
  {
    synchronized (zzail)
    {
      zzcpi = paramzzd;
      return;
    }
  }
  
  void zzb(Boolean paramBoolean)
  {
    synchronized (zzail)
    {
      zzcka = paramBoolean;
      zzu.zzft().zzb(paramBoolean);
      return;
    }
  }
  
  public void zzb(String paramString, zzet paramzzet)
  {
    if (zzcph != null) {
      zzcph.zzb(paramString, paramzzet);
    }
  }
  
  public void zzb(String paramString, JSONObject paramJSONObject)
  {
    Object localObject = paramJSONObject;
    if (paramJSONObject == null) {
      localObject = new JSONObject();
    }
    localObject = ((JSONObject)localObject).toString();
    paramJSONObject = new StringBuilder();
    paramJSONObject.append("AFMA_ReceiveMessage('");
    paramJSONObject.append(paramString);
    paramJSONObject.append("'");
    paramJSONObject.append(",");
    paramJSONObject.append((String)localObject);
    paramJSONObject.append(");");
    paramString = String.valueOf(paramJSONObject.toString());
    if (paramString.length() != 0) {}
    for (paramString = "Dispatching AFMA event: ".concat(paramString);; paramString = new String("Dispatching AFMA event: "))
    {
      zzkh.v(paramString);
      zzdd(paramJSONObject.toString());
      return;
    }
  }
  
  public void zzc(com.google.android.gms.ads.internal.overlay.zzd paramzzd)
  {
    synchronized (zzail)
    {
      zzcpx = paramzzd;
      return;
    }
  }
  
  public void zzcz(String paramString)
  {
    synchronized (zzail)
    {
      try
      {
        super.loadUrl(paramString);
        return;
      }
      catch (Throwable paramString)
      {
        for (;;)
        {
          paramString = String.valueOf(paramString);
          zzkh.zzcy(String.valueOf(paramString).length() + 24 + "Could not call loadUrl. " + paramString);
        }
      }
    }
  }
  
  public void zzda(String paramString)
  {
    Object localObject = zzail;
    String str = paramString;
    if (paramString == null) {
      str = "";
    }
    try
    {
      zzbvu = str;
      return;
    }
    finally {}
  }
  
  protected void zzdc(String paramString)
  {
    synchronized (zzail)
    {
      if (!isDestroyed())
      {
        loadUrl(paramString);
        return;
      }
      zzkh.zzcy("The webview is destroyed. Ignoring action.");
    }
  }
  
  protected void zzdd(String paramString)
  {
    if (com.google.android.gms.common.util.zzs.zzavq())
    {
      if (zzsr() == null) {
        zzvh();
      }
      if (zzsr().booleanValue())
      {
        zza(paramString, null);
        return;
      }
      paramString = String.valueOf(paramString);
      if (paramString.length() != 0) {}
      for (paramString = "javascript:".concat(paramString);; paramString = new String("javascript:"))
      {
        zzdc(paramString);
        return;
      }
    }
    paramString = String.valueOf(paramString);
    if (paramString.length() != 0) {}
    for (paramString = "javascript:".concat(paramString);; paramString = new String("javascript:"))
    {
      zzdc(paramString);
      return;
    }
  }
  
  public AdSizeParcel zzdo()
  {
    synchronized (zzail)
    {
      AdSizeParcel localAdSizeParcel = zzang;
      return localAdSizeParcel;
    }
  }
  
  public void zzeg()
  {
    synchronized (zzail)
    {
      zzcpp = true;
      if (zzcpg != null) {
        zzcpg.zzeg();
      }
      return;
    }
  }
  
  public void zzeh()
  {
    synchronized (zzail)
    {
      zzcpp = false;
      if (zzcpg != null) {
        zzcpg.zzeh();
      }
      return;
    }
  }
  
  public void zzj(String paramString1, String paramString2)
  {
    zzdd(String.valueOf(paramString1).length() + 3 + String.valueOf(paramString2).length() + paramString1 + "(" + paramString2 + ");");
  }
  
  public void zzoc()
  {
    if (zzcps == null)
    {
      zzdg.zza(zzcpv.zzkf(), zzcpu, new String[] { "aes" });
      zzcps = zzdg.zzb(zzcpv.zzkf());
      zzcpv.zza("native:view_show", zzcps);
    }
    HashMap localHashMap = new HashMap(1);
    localHashMap.put("version", zzalm.zzcs);
    zza("onshow", localHashMap);
  }
  
  public boolean zzow()
  {
    synchronized (zzail)
    {
      zzdg.zza(zzcpv.zzkf(), zzcpt, new String[] { "aebb2" });
      boolean bool = zzcpo;
      return bool;
    }
  }
  
  Boolean zzsr()
  {
    synchronized (zzail)
    {
      Boolean localBoolean = zzcka;
      return localBoolean;
    }
  }
  
  public void zzud()
  {
    zzvi();
    HashMap localHashMap = new HashMap(1);
    localHashMap.put("version", zzalm.zzcs);
    zza("onhide", localHashMap);
  }
  
  public void zzue()
  {
    HashMap localHashMap = new HashMap(3);
    localHashMap.put("app_muted", String.valueOf(zzu.zzfq().zzfa()));
    localHashMap.put("app_volume", String.valueOf(zzu.zzfq().zzey()));
    localHashMap.put("device_volume", String.valueOf(zzu.zzfq().zzal(getContext())));
    zza("volume", localHashMap);
  }
  
  public Activity zzuf()
  {
    return zzcpf.zzuf();
  }
  
  public Context zzug()
  {
    return zzcpf.zzug();
  }
  
  public com.google.android.gms.ads.internal.zzd zzuh()
  {
    return zzajv;
  }
  
  public com.google.android.gms.ads.internal.overlay.zzd zzui()
  {
    synchronized (zzail)
    {
      com.google.android.gms.ads.internal.overlay.zzd localzzd = zzcpi;
      return localzzd;
    }
  }
  
  public com.google.android.gms.ads.internal.overlay.zzd zzuj()
  {
    synchronized (zzail)
    {
      com.google.android.gms.ads.internal.overlay.zzd localzzd = zzcpx;
      return localzzd;
    }
  }
  
  public zzlm zzuk()
  {
    return zzcph;
  }
  
  public boolean zzul()
  {
    synchronized (zzail)
    {
      boolean bool = zzcpj;
      return bool;
    }
  }
  
  public zzas zzum()
  {
    return zzbgh;
  }
  
  public VersionInfoParcel zzun()
  {
    return zzalm;
  }
  
  public boolean zzuo()
  {
    synchronized (zzail)
    {
      boolean bool = zzcpl;
      return bool;
    }
  }
  
  public void zzup()
  {
    synchronized (zzail)
    {
      zzkh.v("Destroying WebView!");
      zzkl.zzclg.post(new Runnable()
      {
        public void run()
        {
          zzlp.zza(zzlp.this);
        }
      });
      return;
    }
  }
  
  public boolean zzuq()
  {
    synchronized (zzail)
    {
      boolean bool = zzcpp;
      return bool;
    }
  }
  
  public zzlk zzur()
  {
    return null;
  }
  
  public zzdi zzus()
  {
    return zzcpu;
  }
  
  public zzdj zzut()
  {
    return zzcpv;
  }
  
  public zzlq zzuu()
  {
    synchronized (zzail)
    {
      zzlq localzzlq = zzcpq;
      return localzzlq;
    }
  }
  
  public void zzuv()
  {
    zzaqe.zztt();
  }
  
  public void zzuw()
  {
    if (zzcpu == null)
    {
      zzcpu = zzdg.zzb(zzcpv.zzkf());
      zzcpv.zza("native:view_load", zzcpu);
    }
  }
  
  public View.OnClickListener zzux()
  {
    return (View.OnClickListener)zzcpw.get();
  }
  
  public boolean zzvg()
  {
    if (!zzuk().zzho()) {
      return false;
    }
    DisplayMetrics localDisplayMetrics = zzu.zzfq().zza(zzaqk);
    int k = zzm.zziw().zzb(localDisplayMetrics, widthPixels);
    int m = zzm.zziw().zzb(localDisplayMetrics, heightPixels);
    Object localObject = zzuf();
    int j;
    int i;
    if ((localObject == null) || (((Activity)localObject).getWindow() == null))
    {
      j = m;
      i = k;
      label77:
      if ((zzbrj == k) && (zzbrk == m) && (zzbrm == i) && (zzbrn == j)) {
        break label224;
      }
      if ((zzbrj == k) && (zzbrk == m)) {
        break label226;
      }
    }
    label224:
    label226:
    for (boolean bool = true;; bool = false)
    {
      zzbrj = k;
      zzbrk = m;
      zzbrm = i;
      zzbrn = j;
      new zzhj(this).zza(k, m, i, j, density, zzaqk.getDefaultDisplay().getRotation());
      return bool;
      localObject = zzu.zzfq().zzh((Activity)localObject);
      i = zzm.zziw().zzb(localDisplayMetrics, localObject[0]);
      j = zzm.zziw().zzb(localDisplayMetrics, localObject[1]);
      break label77;
      break;
    }
  }
  
  @zzir
  public static class zza
    extends MutableContextWrapper
  {
    private Context zzaqj;
    private Activity zzcmz;
    private Context zzcqa;
    
    public zza(Context paramContext)
    {
      super();
      setBaseContext(paramContext);
    }
    
    public Object getSystemService(String paramString)
    {
      return zzcqa.getSystemService(paramString);
    }
    
    public void setBaseContext(Context paramContext)
    {
      zzaqj = paramContext.getApplicationContext();
      if ((paramContext instanceof Activity)) {}
      for (Activity localActivity = (Activity)paramContext;; localActivity = null)
      {
        zzcmz = localActivity;
        zzcqa = paramContext;
        super.setBaseContext(zzaqj);
        return;
      }
    }
    
    public void startActivity(Intent paramIntent)
    {
      if (zzcmz != null)
      {
        zzcmz.startActivity(paramIntent);
        return;
      }
      paramIntent.setFlags(268435456);
      zzaqj.startActivity(paramIntent);
    }
    
    public Activity zzuf()
    {
      return zzcmz;
    }
    
    public Context zzug()
    {
      return zzcqa;
    }
  }
}

/* Location:
 * Qualified Name:     com.google.android.gms.internal.zzlp
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */