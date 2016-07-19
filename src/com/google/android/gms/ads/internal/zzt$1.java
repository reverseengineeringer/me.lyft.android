package com.google.android.gms.ads.internal;

import android.os.RemoteException;
import android.webkit.WebResourceError;
import android.webkit.WebResourceRequest;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import com.google.android.gms.ads.internal.client.zzq;
import com.google.android.gms.internal.zzcy;
import com.google.android.gms.internal.zzdc;
import com.google.android.gms.internal.zzkh;

class zzt$1
  extends WebViewClient
{
  zzt$1(zzt paramzzt) {}
  
  public void onReceivedError(WebView paramWebView, WebResourceRequest paramWebResourceRequest, WebResourceError paramWebResourceError)
  {
    if (zzt.zza(zzanm) != null) {}
    try
    {
      zzt.zza(zzanm).onAdFailedToLoad(0);
      return;
    }
    catch (RemoteException paramWebView)
    {
      zzkh.zzd("Could not call AdListener.onAdFailedToLoad().", paramWebView);
    }
  }
  
  public boolean shouldOverrideUrlLoading(WebView paramWebView, String paramString)
  {
    if (paramString.startsWith(zzanm.zzff())) {
      return false;
    }
    if (paramString.startsWith((String)zzdc.zzbcw.get()))
    {
      if (zzt.zza(zzanm) != null) {}
      try
      {
        zzt.zza(zzanm).onAdFailedToLoad(3);
        zzanm.zzj(0);
        return true;
      }
      catch (RemoteException paramWebView)
      {
        for (;;)
        {
          zzkh.zzd("Could not call AdListener.onAdFailedToLoad().", paramWebView);
        }
      }
    }
    if (paramString.startsWith((String)zzdc.zzbcx.get()))
    {
      if (zzt.zza(zzanm) != null) {}
      try
      {
        zzt.zza(zzanm).onAdFailedToLoad(0);
        zzanm.zzj(0);
        return true;
      }
      catch (RemoteException paramWebView)
      {
        for (;;)
        {
          zzkh.zzd("Could not call AdListener.onAdFailedToLoad().", paramWebView);
        }
      }
    }
    if (paramString.startsWith((String)zzdc.zzbcy.get()))
    {
      if (zzt.zza(zzanm) != null) {}
      try
      {
        zzt.zza(zzanm).onAdLoaded();
        int i = zzanm.zzw(paramString);
        zzanm.zzj(i);
        return true;
      }
      catch (RemoteException paramWebView)
      {
        for (;;)
        {
          zzkh.zzd("Could not call AdListener.onAdLoaded().", paramWebView);
        }
      }
    }
    if (paramString.startsWith("gmsg://")) {
      return true;
    }
    if (zzt.zza(zzanm) != null) {}
    try
    {
      zzt.zza(zzanm).onAdLeftApplication();
      paramWebView = zzt.zza(zzanm, paramString);
      zzt.zzb(zzanm, paramWebView);
      return true;
    }
    catch (RemoteException paramWebView)
    {
      for (;;)
      {
        zzkh.zzd("Could not call AdListener.onAdLeftApplication().", paramWebView);
      }
    }
  }
}

/* Location:
 * Qualified Name:     com.google.android.gms.ads.internal.zzt.1
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */