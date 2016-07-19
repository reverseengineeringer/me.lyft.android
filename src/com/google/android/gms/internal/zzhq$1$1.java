package com.google.android.gms.internal;

import android.webkit.WebView;
import android.webkit.WebViewClient;
import java.util.Set;

class zzhq$1$1
  extends WebViewClient
{
  zzhq$1$1(zzhq.1 param1, WebView paramWebView) {}
  
  public void onPageFinished(WebView paramWebView, String paramString)
  {
    zzkh.zzcw("Loading assets have finished");
    zzbwp.zzbwo.zzbwl.remove(zzass);
  }
  
  public void onReceivedError(WebView paramWebView, int paramInt, String paramString1, String paramString2)
  {
    zzkh.zzcy("Loading assets have failed.");
    zzbwp.zzbwo.zzbwl.remove(zzass);
  }
}

/* Location:
 * Qualified Name:     com.google.android.gms.internal.zzhq.1.1
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */