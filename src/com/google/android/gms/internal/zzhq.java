package com.google.android.gms.internal;

import android.content.Context;
import android.os.Handler;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

@zzir
public class zzhq
  implements zzho
{
  private final Context mContext;
  final Set<WebView> zzbwl = Collections.synchronizedSet(new HashSet());
  
  public zzhq(Context paramContext)
  {
    mContext = paramContext;
  }
  
  public void zza(String paramString1, final String paramString2, final String paramString3)
  {
    zzkh.zzcw("Fetching assets for the given html");
    zzkl.zzclg.post(new Runnable()
    {
      public void run()
      {
        final WebView localWebView = zzpn();
        localWebView.setWebViewClient(new WebViewClient()
        {
          public void onPageFinished(WebView paramAnonymous2WebView, String paramAnonymous2String)
          {
            zzkh.zzcw("Loading assets have finished");
            zzbwl.remove(localWebView);
          }
          
          public void onReceivedError(WebView paramAnonymous2WebView, int paramAnonymous2Int, String paramAnonymous2String1, String paramAnonymous2String2)
          {
            zzkh.zzcy("Loading assets have failed.");
            zzbwl.remove(localWebView);
          }
        });
        zzbwl.add(localWebView);
        localWebView.loadDataWithBaseURL(paramString2, paramString3, "text/html", "UTF-8", null);
        zzkh.zzcw("Fetching assets finished.");
      }
    });
  }
  
  public WebView zzpn()
  {
    WebView localWebView = new WebView(mContext);
    localWebView.getSettings().setJavaScriptEnabled(true);
    return localWebView;
  }
}

/* Location:
 * Qualified Name:     com.google.android.gms.internal.zzhq
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */