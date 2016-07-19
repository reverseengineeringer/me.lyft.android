package com.google.android.gms.internal;

import android.content.Context;
import android.net.Uri;
import android.net.http.SslError;
import android.os.Bundle;
import android.os.Handler;
import android.text.TextUtils;
import android.view.KeyEvent;
import android.webkit.SslErrorHandler;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import com.google.android.gms.ads.internal.client.AdSizeParcel;
import com.google.android.gms.ads.internal.client.zza;
import com.google.android.gms.ads.internal.overlay.AdLauncherIntentInfoParcel;
import com.google.android.gms.ads.internal.overlay.AdOverlayInfoParcel;
import com.google.android.gms.ads.internal.overlay.zzd;
import com.google.android.gms.ads.internal.overlay.zzg;
import com.google.android.gms.ads.internal.overlay.zzp;
import com.google.android.gms.ads.internal.util.client.VersionInfoParcel;
import com.google.android.gms.ads.internal.zzu;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.CopyOnWriteArrayList;

@zzir
public class zzlm
  extends WebViewClient
{
  private static final String[] zzcon = { "UNKNOWN", "HOST_LOOKUP", "UNSUPPORTED_AUTH_SCHEME", "AUTHENTICATION", "PROXY_AUTHENTICATION", "CONNECT", "IO", "TIMEOUT", "REDIRECT_LOOP", "UNSUPPORTED_SCHEME", "FAILED_SSL_HANDSHAKE", "BAD_URL", "FILE", "FILE_NOT_FOUND", "TOO_MANY_REQUESTS" };
  private static final String[] zzcoo = { "NOT_YET_VALID", "EXPIRED", "ID_MISMATCH", "UNTRUSTED", "DATE_INVALID", "INVALID" };
  private final Object zzail = new Object();
  private boolean zzari;
  private zza zzati;
  protected zzll zzbgj;
  private zzeo zzbhq;
  private zzex zzbiv;
  private com.google.android.gms.ads.internal.zze zzbix;
  private zzhe zzbiy;
  private zzev zzbja;
  private zzhk zzbqr;
  private zza zzbye;
  private final HashMap<String, List<zzet>> zzcop = new HashMap();
  private zzg zzcoq;
  private zzb zzcor;
  private boolean zzcos = false;
  private boolean zzcot;
  private zzp zzcou;
  private final zzhi zzcov;
  protected zzjs zzcow;
  private boolean zzcox;
  private boolean zzcoy;
  private boolean zzcoz;
  private int zzcpa;
  
  public zzlm(zzll paramzzll, boolean paramBoolean)
  {
    this(paramzzll, paramBoolean, new zzhi(paramzzll, paramzzll.zzug(), new zzcu(paramzzll.getContext())), null);
  }
  
  zzlm(zzll paramzzll, boolean paramBoolean, zzhi paramzzhi, zzhe paramzzhe)
  {
    zzbgj = paramzzll;
    zzari = paramBoolean;
    zzcov = paramzzhi;
    zzbiy = paramzzhe;
  }
  
  private void zza(Context paramContext, String paramString1, String paramString2, String paramString3)
  {
    if (!((Boolean)zzdc.zzbat.get()).booleanValue()) {
      return;
    }
    Bundle localBundle = new Bundle();
    localBundle.putString("err", paramString1);
    localBundle.putString("code", paramString2);
    localBundle.putString("host", zzdb(paramString3));
    zzu.zzfq().zza(paramContext, zzbgj.zzun().zzcs, "gmob-apps", localBundle, true);
  }
  
  private String zzdb(String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {
      return "";
    }
    paramString = Uri.parse(paramString);
    if (paramString.getHost() != null) {
      return paramString.getHost();
    }
    return "";
  }
  
  private static boolean zzh(Uri paramUri)
  {
    paramUri = paramUri.getScheme();
    return ("http".equalsIgnoreCase(paramUri)) || ("https".equalsIgnoreCase(paramUri));
  }
  
  private void zzvc()
  {
    synchronized (zzail)
    {
      zzcot = true;
      zzcpa += 1;
      zzvf();
      return;
    }
  }
  
  private void zzvd()
  {
    zzcpa -= 1;
    zzvf();
  }
  
  private void zzve()
  {
    zzcoz = true;
    zzvf();
  }
  
  public final void onLoadResource(WebView paramWebView, String paramString)
  {
    paramWebView = String.valueOf(paramString);
    if (paramWebView.length() != 0) {}
    for (paramWebView = "Loading resource: ".concat(paramWebView);; paramWebView = new String("Loading resource: "))
    {
      zzkh.v(paramWebView);
      paramWebView = Uri.parse(paramString);
      if (("gmsg".equalsIgnoreCase(paramWebView.getScheme())) && ("mobileads.google.com".equalsIgnoreCase(paramWebView.getHost()))) {
        zzi(paramWebView);
      }
      return;
    }
  }
  
  public final void onPageFinished(WebView arg1, String paramString)
  {
    synchronized (zzail)
    {
      if (zzcox)
      {
        zzkh.v("Blank page loaded, 1...");
        zzbgj.zzup();
        return;
      }
      zzcoy = true;
      zzvf();
      return;
    }
  }
  
  public final void onReceivedError(WebView paramWebView, int paramInt, String paramString1, String paramString2)
  {
    if ((paramInt < 0) && (-paramInt - 1 < zzcon.length)) {}
    for (String str = zzcon[(-paramInt - 1)];; str = String.valueOf(paramInt))
    {
      zza(zzbgj.getContext(), "http_err", str, paramString2);
      super.onReceivedError(paramWebView, paramInt, paramString1, paramString2);
      return;
    }
  }
  
  public final void onReceivedSslError(WebView paramWebView, SslErrorHandler paramSslErrorHandler, SslError paramSslError)
  {
    int i;
    if (paramSslError != null)
    {
      i = paramSslError.getPrimaryError();
      if ((i < 0) || (i >= zzcoo.length)) {
        break label65;
      }
    }
    label65:
    for (String str = zzcoo[i];; str = String.valueOf(i))
    {
      zza(zzbgj.getContext(), "ssl_err", str, zzu.zzfs().zza(paramSslError));
      super.onReceivedSslError(paramWebView, paramSslErrorHandler, paramSslError);
      return;
    }
  }
  
  public final void reset()
  {
    if (zzcow != null)
    {
      zzcow.zzry();
      zzcow = null;
    }
    synchronized (zzail)
    {
      zzcop.clear();
      zzati = null;
      zzcoq = null;
      zzbye = null;
      zzbhq = null;
      zzcos = false;
      zzari = false;
      zzcot = false;
      zzbja = null;
      zzcou = null;
      zzcor = null;
      if (zzbiy != null)
      {
        zzbiy.zzs(true);
        zzbiy = null;
      }
      return;
    }
  }
  
  public boolean shouldOverrideKeyEvent(WebView paramWebView, KeyEvent paramKeyEvent)
  {
    switch (paramKeyEvent.getKeyCode())
    {
    default: 
      return false;
    }
    return true;
  }
  
  public final boolean shouldOverrideUrlLoading(WebView paramWebView, String paramString)
  {
    Object localObject = String.valueOf(paramString);
    if (((String)localObject).length() != 0)
    {
      localObject = "AdWebView shouldOverrideUrlLoading: ".concat((String)localObject);
      zzkh.v((String)localObject);
      localObject = Uri.parse(paramString);
      if ((!"gmsg".equalsIgnoreCase(((Uri)localObject).getScheme())) || (!"mobileads.google.com".equalsIgnoreCase(((Uri)localObject).getHost()))) {
        break label76;
      }
      zzi((Uri)localObject);
    }
    label76:
    label296:
    for (;;)
    {
      return true;
      localObject = new String("AdWebView shouldOverrideUrlLoading: ");
      break;
      if ((zzcos) && (paramWebView == zzbgj.getWebView()) && (zzh((Uri)localObject)))
      {
        if ((zzati != null) && (((Boolean)zzdc.zzazs.get()).booleanValue()))
        {
          zzati.onAdClicked();
          if (zzcow != null) {
            zzcow.zzcj(paramString);
          }
          zzati = null;
        }
        return super.shouldOverrideUrlLoading(paramWebView, paramString);
      }
      if (zzbgj.getWebView().willNotDraw()) {
        break label321;
      }
      try
      {
        zzas localzzas = zzbgj.zzum();
        paramWebView = (WebView)localObject;
        if (localzzas != null)
        {
          paramWebView = (WebView)localObject;
          if (localzzas.zzc((Uri)localObject)) {
            paramWebView = localzzas.zzb((Uri)localObject, zzbgj.getContext());
          }
        }
      }
      catch (zzat paramWebView)
      {
        paramWebView = String.valueOf(paramString);
        if (paramWebView.length() == 0) {
          break label296;
        }
        for (paramWebView = "Unable to append parameter to URL: ".concat(paramWebView);; paramWebView = new String("Unable to append parameter to URL: "))
        {
          zzkh.zzcy(paramWebView);
          paramWebView = (WebView)localObject;
          break;
        }
        zzbix.zzt(paramString);
      }
      if ((zzbix == null) || (zzbix.zzem())) {
        zza(new AdLauncherIntentInfoParcel("android.intent.action.VIEW", paramWebView.toString(), null, null, null, null, null));
      }
    }
    label321:
    paramWebView = String.valueOf(paramString);
    if (paramWebView.length() != 0) {}
    for (paramWebView = "AdWebView unable to handle URL: ".concat(paramWebView);; paramWebView = new String("AdWebView unable to handle URL: "))
    {
      zzkh.zzcy(paramWebView);
      break;
    }
  }
  
  public void zza(int paramInt1, int paramInt2, boolean paramBoolean)
  {
    zzcov.zze(paramInt1, paramInt2);
    if (zzbiy != null) {
      zzbiy.zza(paramInt1, paramInt2, paramBoolean);
    }
  }
  
  public void zza(zza paramzza, zzg paramzzg, zzeo paramzzeo, zzp paramzzp, boolean paramBoolean, zzev paramzzev, zzex paramzzex, com.google.android.gms.ads.internal.zze paramzze, zzhk paramzzhk, zzjs paramzzjs)
  {
    com.google.android.gms.ads.internal.zze localzze = paramzze;
    if (paramzze == null) {
      localzze = new com.google.android.gms.ads.internal.zze(zzbgj.getContext());
    }
    zzbiy = new zzhe(zzbgj, paramzzhk);
    zzcow = paramzzjs;
    zza("/appEvent", new zzen(paramzzeo));
    zza("/backButton", zzer.zzbib);
    zza("/refresh", zzer.zzbic);
    zza("/canOpenURLs", zzer.zzbhs);
    zza("/canOpenIntents", zzer.zzbht);
    zza("/click", zzer.zzbhu);
    zza("/close", zzer.zzbhv);
    zza("/customClose", zzer.zzbhx);
    zza("/instrument", zzer.zzbig);
    zza("/delayPageLoaded", new zzd(null));
    zza("/httpTrack", zzer.zzbhy);
    zza("/log", zzer.zzbhz);
    zza("/mraid", new zzez(localzze, zzbiy));
    zza("/mraidLoaded", zzcov);
    zza("/open", new zzfa(paramzzev, localzze, zzbiy));
    zza("/precache", zzer.zzbif);
    zza("/touch", zzer.zzbia);
    zza("/video", zzer.zzbid);
    zza("/videoMeta", zzer.zzbie);
    zza("/appStreaming", zzer.zzbhw);
    if (paramzzex != null) {
      zza("/setInterstitialProperties", new zzew(paramzzex));
    }
    zzati = paramzza;
    zzcoq = paramzzg;
    zzbhq = paramzzeo;
    zzbja = paramzzev;
    zzcou = paramzzp;
    zzbix = localzze;
    zzbqr = paramzzhk;
    zzbiv = paramzzex;
    zzak(paramBoolean);
  }
  
  public final void zza(AdLauncherIntentInfoParcel paramAdLauncherIntentInfoParcel)
  {
    zzg localzzg = null;
    boolean bool = zzbgj.zzuo();
    zza localzza;
    if ((bool) && (!zzbgj.zzdo().zzauq))
    {
      localzza = null;
      if (!bool) {
        break label75;
      }
    }
    for (;;)
    {
      zza(new AdOverlayInfoParcel(paramAdLauncherIntentInfoParcel, localzza, localzzg, zzcou, zzbgj.zzun()));
      return;
      localzza = zzati;
      break;
      label75:
      localzzg = zzcoq;
    }
  }
  
  public void zza(AdOverlayInfoParcel paramAdOverlayInfoParcel)
  {
    boolean bool2 = false;
    if (zzbiy != null) {}
    for (boolean bool1 = zzbiy.zzmy();; bool1 = false)
    {
      Object localObject1 = zzu.zzfo();
      Object localObject2 = zzbgj.getContext();
      if (!bool1) {
        bool2 = true;
      }
      ((com.google.android.gms.ads.internal.overlay.zze)localObject1).zza((Context)localObject2, paramAdOverlayInfoParcel, bool2);
      if (zzcow != null)
      {
        localObject2 = url;
        localObject1 = localObject2;
        if (localObject2 == null)
        {
          localObject1 = localObject2;
          if (zzbtn != null) {
            localObject1 = zzbtn.url;
          }
        }
        zzcow.zzcj((String)localObject1);
      }
      return;
    }
  }
  
  public void zza(zza paramzza)
  {
    zzbye = paramzza;
  }
  
  public void zza(zzb paramzzb)
  {
    zzcor = paramzzb;
  }
  
  public void zza(String paramString, zzet paramzzet)
  {
    synchronized (zzail)
    {
      List localList = (List)zzcop.get(paramString);
      Object localObject1 = localList;
      if (localList == null)
      {
        localObject1 = new CopyOnWriteArrayList();
        zzcop.put(paramString, localObject1);
      }
      ((List)localObject1).add(paramzzet);
      return;
    }
  }
  
  public final void zza(boolean paramBoolean, int paramInt)
  {
    if ((zzbgj.zzuo()) && (!zzbgj.zzdo().zzauq)) {}
    for (zza localzza = null;; localzza = zzati)
    {
      zza(new AdOverlayInfoParcel(localzza, zzcoq, zzcou, zzbgj, paramBoolean, paramInt, zzbgj.zzun()));
      return;
    }
  }
  
  public final void zza(boolean paramBoolean, int paramInt, String paramString)
  {
    Object localObject = null;
    boolean bool = zzbgj.zzuo();
    zza localzza;
    if ((bool) && (!zzbgj.zzdo().zzauq))
    {
      localzza = null;
      if (!bool) {
        break label95;
      }
    }
    for (;;)
    {
      zza(new AdOverlayInfoParcel(localzza, (zzg)localObject, zzbhq, zzcou, zzbgj, paramBoolean, paramInt, paramString, zzbgj.zzun(), zzbja));
      return;
      localzza = zzati;
      break;
      label95:
      localObject = new zzc(zzbgj, zzcoq);
    }
  }
  
  public final void zza(boolean paramBoolean, int paramInt, String paramString1, String paramString2)
  {
    boolean bool = zzbgj.zzuo();
    zza localzza;
    if ((bool) && (!zzbgj.zzdo().zzauq))
    {
      localzza = null;
      if (!bool) {
        break label97;
      }
    }
    label97:
    for (Object localObject = null;; localObject = new zzc(zzbgj, zzcoq))
    {
      zza(new AdOverlayInfoParcel(localzza, (zzg)localObject, zzbhq, zzcou, zzbgj, paramBoolean, paramInt, paramString1, paramString2, zzbgj.zzun(), zzbja));
      return;
      localzza = zzati;
      break;
    }
  }
  
  public void zzak(boolean paramBoolean)
  {
    zzcos = paramBoolean;
  }
  
  public void zzb(String paramString, zzet paramzzet)
  {
    synchronized (zzail)
    {
      paramString = (List)zzcop.get(paramString);
      if (paramString == null) {
        return;
      }
      paramString.remove(paramzzet);
      return;
    }
  }
  
  public void zzd(int paramInt1, int paramInt2)
  {
    if (zzbiy != null) {
      zzbiy.zzd(paramInt1, paramInt2);
    }
  }
  
  public boolean zzho()
  {
    synchronized (zzail)
    {
      boolean bool = zzari;
      return bool;
    }
  }
  
  public void zzi(Uri paramUri)
  {
    String str1 = paramUri.getPath();
    List localList = (List)zzcop.get(str1);
    if (localList != null)
    {
      Map localMap = zzu.zzfq().zzf(paramUri);
      if (zzkh.zzaz(2))
      {
        paramUri = String.valueOf(str1);
        if (paramUri.length() != 0) {}
        for (paramUri = "Received GMSG: ".concat(paramUri);; paramUri = new String("Received GMSG: "))
        {
          zzkh.v(paramUri);
          paramUri = localMap.keySet().iterator();
          while (paramUri.hasNext())
          {
            str1 = (String)paramUri.next();
            String str2 = (String)localMap.get(str1);
            zzkh.v(String.valueOf(str1).length() + 4 + String.valueOf(str2).length() + "  " + str1 + ": " + str2);
          }
        }
      }
      paramUri = localList.iterator();
      while (paramUri.hasNext()) {
        ((zzet)paramUri.next()).zza(zzbgj, localMap);
      }
    }
    paramUri = String.valueOf(paramUri);
    zzkh.v(String.valueOf(paramUri).length() + 32 + "No GMSG handler found for GMSG: " + paramUri);
  }
  
  public void zzm(zzll paramzzll)
  {
    zzbgj = paramzzll;
  }
  
  public final void zznz()
  {
    synchronized (zzail)
    {
      zzcos = false;
      zzari = true;
      zzu.zzfq().runOnUiThread(new Runnable()
      {
        public void run()
        {
          zzbgj.zzuv();
          zzd localzzd = zzbgj.zzui();
          if (localzzd != null) {
            localzzd.zznz();
          }
          if (zzlm.zzd(zzlm.this) != null)
          {
            zzlm.zzd(zzlm.this).zzen();
            zzlm.zza(zzlm.this, null);
          }
        }
      });
      return;
    }
  }
  
  public com.google.android.gms.ads.internal.zze zzuy()
  {
    return zzbix;
  }
  
  public boolean zzuz()
  {
    synchronized (zzail)
    {
      boolean bool = zzcot;
      return bool;
    }
  }
  
  public void zzva()
  {
    synchronized (zzail)
    {
      zzkh.v("Loading blank page in WebView, 2...");
      zzcox = true;
      zzbgj.zzcz("about:blank");
      return;
    }
  }
  
  public void zzvb()
  {
    if (zzcow != null) {
      zzkl.zzclg.post(new Runnable()
      {
        public void run()
        {
          if (zzcow != null) {
            zzcow.zzj(zzbgj.getView());
          }
        }
      });
    }
  }
  
  public final void zzvf()
  {
    zza localzza;
    zzll localzzll;
    if ((zzbye != null) && (((zzcoy) && (zzcpa <= 0)) || (zzcoz)))
    {
      localzza = zzbye;
      localzzll = zzbgj;
      if (zzcoz) {
        break label70;
      }
    }
    label70:
    for (boolean bool = true;; bool = false)
    {
      localzza.zza(localzzll, bool);
      zzbye = null;
      zzbgj.zzuw();
      return;
    }
  }
  
  public static abstract interface zza
  {
    public abstract void zza(zzll paramzzll, boolean paramBoolean);
  }
  
  public static abstract interface zzb
  {
    public abstract void zzen();
  }
  
  private static class zzc
    implements zzg
  {
    private zzg zzcoq;
    private zzll zzcpc;
    
    public zzc(zzll paramzzll, zzg paramzzg)
    {
      zzcpc = paramzzll;
      zzcoq = paramzzg;
    }
    
    public void onPause() {}
    
    public void onResume() {}
    
    public void zzdy()
    {
      zzcoq.zzdy();
      zzcpc.zzud();
    }
    
    public void zzdz()
    {
      zzcoq.zzdz();
      zzcpc.zzoc();
    }
  }
  
  private class zzd
    implements zzet
  {
    private zzd() {}
    
    public void zza(zzll paramzzll, Map<String, String> paramMap)
    {
      if (paramMap.keySet().contains("start")) {
        zzlm.zza(zzlm.this);
      }
      do
      {
        return;
        if (paramMap.keySet().contains("stop"))
        {
          zzlm.zzb(zzlm.this);
          return;
        }
      } while (!paramMap.keySet().contains("cancel"));
      zzlm.zzc(zzlm.this);
    }
  }
}

/* Location:
 * Qualified Name:     com.google.android.gms.internal.zzlm
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */