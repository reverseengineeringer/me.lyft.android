package com.google.android.gms.internal;

import android.app.Activity;
import android.content.Context;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.View.OnTouchListener;
import android.webkit.WebChromeClient;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.FrameLayout;
import com.google.android.gms.ads.internal.client.AdSizeParcel;
import com.google.android.gms.ads.internal.util.client.VersionInfoParcel;
import java.util.Map;
import org.json.JSONObject;

@zzir
class zzlo
  extends FrameLayout
  implements zzll
{
  private final zzll zzcpd;
  private final zzlk zzcpe;
  
  public zzlo(zzll paramzzll)
  {
    super(paramzzll.getContext());
    zzcpd = paramzzll;
    zzcpe = new zzlk(paramzzll.zzug(), this, this);
    paramzzll = zzcpd.zzuk();
    if (paramzzll != null) {
      paramzzll.zzm(this);
    }
    addView(zzcpd.getView());
  }
  
  public void destroy()
  {
    zzcpd.destroy();
  }
  
  public String getRequestId()
  {
    return zzcpd.getRequestId();
  }
  
  public int getRequestedOrientation()
  {
    return zzcpd.getRequestedOrientation();
  }
  
  public View getView()
  {
    return this;
  }
  
  public WebView getWebView()
  {
    return zzcpd.getWebView();
  }
  
  public boolean isDestroyed()
  {
    return zzcpd.isDestroyed();
  }
  
  public void loadData(String paramString1, String paramString2, String paramString3)
  {
    zzcpd.loadData(paramString1, paramString2, paramString3);
  }
  
  public void loadDataWithBaseURL(String paramString1, String paramString2, String paramString3, String paramString4, String paramString5)
  {
    zzcpd.loadDataWithBaseURL(paramString1, paramString2, paramString3, paramString4, paramString5);
  }
  
  public void loadUrl(String paramString)
  {
    zzcpd.loadUrl(paramString);
  }
  
  public void onPause()
  {
    zzcpe.onPause();
    zzcpd.onPause();
  }
  
  public void onResume()
  {
    zzcpd.onResume();
  }
  
  public void setBackgroundColor(int paramInt)
  {
    zzcpd.setBackgroundColor(paramInt);
  }
  
  public void setContext(Context paramContext)
  {
    zzcpd.setContext(paramContext);
  }
  
  public void setOnClickListener(View.OnClickListener paramOnClickListener)
  {
    zzcpd.setOnClickListener(paramOnClickListener);
  }
  
  public void setOnTouchListener(View.OnTouchListener paramOnTouchListener)
  {
    zzcpd.setOnTouchListener(paramOnTouchListener);
  }
  
  public void setRequestedOrientation(int paramInt)
  {
    zzcpd.setRequestedOrientation(paramInt);
  }
  
  public void setWebChromeClient(WebChromeClient paramWebChromeClient)
  {
    zzcpd.setWebChromeClient(paramWebChromeClient);
  }
  
  public void setWebViewClient(WebViewClient paramWebViewClient)
  {
    zzcpd.setWebViewClient(paramWebViewClient);
  }
  
  public void stopLoading()
  {
    zzcpd.stopLoading();
  }
  
  public void zza(Context paramContext, AdSizeParcel paramAdSizeParcel, zzdk paramzzdk)
  {
    zzcpe.onDestroy();
    zzcpd.zza(paramContext, paramAdSizeParcel, paramzzdk);
  }
  
  public void zza(AdSizeParcel paramAdSizeParcel)
  {
    zzcpd.zza(paramAdSizeParcel);
  }
  
  public void zza(zzcd paramzzcd, boolean paramBoolean)
  {
    zzcpd.zza(paramzzcd, paramBoolean);
  }
  
  public void zza(zzlq paramzzlq)
  {
    zzcpd.zza(paramzzlq);
  }
  
  public void zza(String paramString, zzet paramzzet)
  {
    zzcpd.zza(paramString, paramzzet);
  }
  
  public void zza(String paramString, Map<String, ?> paramMap)
  {
    zzcpd.zza(paramString, paramMap);
  }
  
  public void zza(String paramString, JSONObject paramJSONObject)
  {
    zzcpd.zza(paramString, paramJSONObject);
  }
  
  public void zzaf(int paramInt)
  {
    zzcpd.zzaf(paramInt);
  }
  
  public void zzah(boolean paramBoolean)
  {
    zzcpd.zzah(paramBoolean);
  }
  
  public void zzai(boolean paramBoolean)
  {
    zzcpd.zzai(paramBoolean);
  }
  
  public void zzaj(boolean paramBoolean)
  {
    zzcpd.zzaj(paramBoolean);
  }
  
  public void zzb(com.google.android.gms.ads.internal.overlay.zzd paramzzd)
  {
    zzcpd.zzb(paramzzd);
  }
  
  public void zzb(String paramString, zzet paramzzet)
  {
    zzcpd.zzb(paramString, paramzzet);
  }
  
  public void zzb(String paramString, JSONObject paramJSONObject)
  {
    zzcpd.zzb(paramString, paramJSONObject);
  }
  
  public void zzc(com.google.android.gms.ads.internal.overlay.zzd paramzzd)
  {
    zzcpd.zzc(paramzzd);
  }
  
  public void zzcz(String paramString)
  {
    zzcpd.zzcz(paramString);
  }
  
  public void zzda(String paramString)
  {
    zzcpd.zzda(paramString);
  }
  
  public AdSizeParcel zzdo()
  {
    return zzcpd.zzdo();
  }
  
  public void zzeg()
  {
    zzcpd.zzeg();
  }
  
  public void zzeh()
  {
    zzcpd.zzeh();
  }
  
  public void zzj(String paramString1, String paramString2)
  {
    zzcpd.zzj(paramString1, paramString2);
  }
  
  public void zzoc()
  {
    zzcpd.zzoc();
  }
  
  public boolean zzow()
  {
    return zzcpd.zzow();
  }
  
  public void zzud()
  {
    zzcpd.zzud();
  }
  
  public void zzue()
  {
    zzcpd.zzue();
  }
  
  public Activity zzuf()
  {
    return zzcpd.zzuf();
  }
  
  public Context zzug()
  {
    return zzcpd.zzug();
  }
  
  public com.google.android.gms.ads.internal.zzd zzuh()
  {
    return zzcpd.zzuh();
  }
  
  public com.google.android.gms.ads.internal.overlay.zzd zzui()
  {
    return zzcpd.zzui();
  }
  
  public com.google.android.gms.ads.internal.overlay.zzd zzuj()
  {
    return zzcpd.zzuj();
  }
  
  public zzlm zzuk()
  {
    return zzcpd.zzuk();
  }
  
  public boolean zzul()
  {
    return zzcpd.zzul();
  }
  
  public zzas zzum()
  {
    return zzcpd.zzum();
  }
  
  public VersionInfoParcel zzun()
  {
    return zzcpd.zzun();
  }
  
  public boolean zzuo()
  {
    return zzcpd.zzuo();
  }
  
  public void zzup()
  {
    zzcpe.onDestroy();
    zzcpd.zzup();
  }
  
  public boolean zzuq()
  {
    return zzcpd.zzuq();
  }
  
  public zzlk zzur()
  {
    return zzcpe;
  }
  
  public zzdi zzus()
  {
    return zzcpd.zzus();
  }
  
  public zzdj zzut()
  {
    return zzcpd.zzut();
  }
  
  public zzlq zzuu()
  {
    return zzcpd.zzuu();
  }
  
  public void zzuv()
  {
    zzcpd.zzuv();
  }
  
  public void zzuw()
  {
    zzcpd.zzuw();
  }
  
  public View.OnClickListener zzux()
  {
    return zzcpd.zzux();
  }
}

/* Location:
 * Qualified Name:     com.google.android.gms.internal.zzlo
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */