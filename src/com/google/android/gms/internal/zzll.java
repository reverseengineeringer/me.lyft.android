package com.google.android.gms.internal;

import android.app.Activity;
import android.content.Context;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.View.OnTouchListener;
import android.view.ViewGroup.LayoutParams;
import android.view.ViewParent;
import android.webkit.WebChromeClient;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import com.google.android.gms.ads.internal.client.AdSizeParcel;
import com.google.android.gms.ads.internal.util.client.VersionInfoParcel;
import com.google.android.gms.ads.internal.zzs;
import java.util.Map;
import org.json.JSONObject;

@zzir
public abstract interface zzll
  extends zzs, zzce, zzfx
{
  public abstract void destroy();
  
  public abstract Context getContext();
  
  public abstract ViewGroup.LayoutParams getLayoutParams();
  
  public abstract void getLocationOnScreen(int[] paramArrayOfInt);
  
  public abstract int getMeasuredHeight();
  
  public abstract int getMeasuredWidth();
  
  public abstract ViewParent getParent();
  
  public abstract String getRequestId();
  
  public abstract int getRequestedOrientation();
  
  public abstract View getView();
  
  public abstract WebView getWebView();
  
  public abstract boolean isDestroyed();
  
  public abstract void loadData(String paramString1, String paramString2, String paramString3);
  
  public abstract void loadDataWithBaseURL(String paramString1, String paramString2, String paramString3, String paramString4, String paramString5);
  
  public abstract void loadUrl(String paramString);
  
  public abstract void measure(int paramInt1, int paramInt2);
  
  public abstract void onPause();
  
  public abstract void onResume();
  
  public abstract void setBackgroundColor(int paramInt);
  
  public abstract void setContext(Context paramContext);
  
  public abstract void setOnClickListener(View.OnClickListener paramOnClickListener);
  
  public abstract void setOnTouchListener(View.OnTouchListener paramOnTouchListener);
  
  public abstract void setRequestedOrientation(int paramInt);
  
  public abstract void setWebChromeClient(WebChromeClient paramWebChromeClient);
  
  public abstract void setWebViewClient(WebViewClient paramWebViewClient);
  
  public abstract void stopLoading();
  
  public abstract void zza(Context paramContext, AdSizeParcel paramAdSizeParcel, zzdk paramzzdk);
  
  public abstract void zza(AdSizeParcel paramAdSizeParcel);
  
  public abstract void zza(zzlq paramzzlq);
  
  public abstract void zza(String paramString, Map<String, ?> paramMap);
  
  public abstract void zza(String paramString, JSONObject paramJSONObject);
  
  public abstract void zzaf(int paramInt);
  
  public abstract void zzah(boolean paramBoolean);
  
  public abstract void zzai(boolean paramBoolean);
  
  public abstract void zzaj(boolean paramBoolean);
  
  public abstract void zzb(com.google.android.gms.ads.internal.overlay.zzd paramzzd);
  
  public abstract void zzc(com.google.android.gms.ads.internal.overlay.zzd paramzzd);
  
  public abstract void zzcz(String paramString);
  
  public abstract void zzda(String paramString);
  
  public abstract AdSizeParcel zzdo();
  
  public abstract void zzj(String paramString1, String paramString2);
  
  public abstract void zzoc();
  
  public abstract boolean zzow();
  
  public abstract void zzud();
  
  public abstract void zzue();
  
  public abstract Activity zzuf();
  
  public abstract Context zzug();
  
  public abstract com.google.android.gms.ads.internal.zzd zzuh();
  
  public abstract com.google.android.gms.ads.internal.overlay.zzd zzui();
  
  public abstract com.google.android.gms.ads.internal.overlay.zzd zzuj();
  
  public abstract zzlm zzuk();
  
  public abstract boolean zzul();
  
  public abstract zzas zzum();
  
  public abstract VersionInfoParcel zzun();
  
  public abstract boolean zzuo();
  
  public abstract void zzup();
  
  public abstract boolean zzuq();
  
  public abstract zzlk zzur();
  
  public abstract zzdi zzus();
  
  public abstract zzdj zzut();
  
  public abstract zzlq zzuu();
  
  public abstract void zzuv();
  
  public abstract void zzuw();
  
  public abstract View.OnClickListener zzux();
}

/* Location:
 * Qualified Name:     com.google.android.gms.internal.zzll
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */