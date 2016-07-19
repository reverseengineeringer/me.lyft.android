package com.google.android.gms.internal;

import android.webkit.WebView;
import android.webkit.WebViewClient;
import java.util.Set;

class zzhq$1
  implements Runnable
{
  zzhq$1(zzhq paramzzhq, String paramString1, String paramString2) {}
  
  public void run()
  {
    final WebView localWebView = zzbwo.zzpn();
    localWebView.setWebViewClient(new WebViewClient()
    {
      public void onPageFinished(WebView paramAnonymousWebView, String paramAnonymousString)
      {
        zzkh.zzcw("Loading assets have finished");
        zzbwo.zzbwl.remove(localWebView);
      }
      
      public void onReceivedError(WebView paramAnonymousWebView, int paramAnonymousInt, String paramAnonymousString1, String paramAnonymousString2)
      {
        zzkh.zzcy("Loading assets have failed.");
        zzbwo.zzbwl.remove(localWebView);
      }
    });
    zzbwo.zzbwl.add(localWebView);
    localWebView.loadDataWithBaseURL(zzbwm, zzbwn, "text/html", "UTF-8", null);
    zzkh.zzcw("Fetching assets finished.");
  }
}

/* Location:
 * Qualified Name:     com.google.android.gms.internal.zzhq.1
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */