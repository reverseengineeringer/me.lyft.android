package com.tune.crosspromo;

import android.app.Activity;
import android.view.ViewGroup;
import android.webkit.WebView;
import android.webkit.WebViewClient;

class TuneInterstitial$1
  extends WebViewClient
{
  TuneInterstitial$1(TuneInterstitial paramTuneInterstitial, String paramString) {}
  
  public void onPageFinished(WebView paramWebView, String paramString)
  {
    if (!paramString.equals("about:blank")) {
      TuneInterstitial.access$200(this$0, val$placement);
    }
  }
  
  public boolean shouldOverrideUrlLoading(WebView paramWebView, String paramString)
  {
    ((ViewGroup)paramWebView.getParent()).removeView(paramWebView);
    TuneInterstitial.access$000(this$0, paramString, val$placement);
    ((Activity)TuneInterstitial.access$100(this$0).getAdContext()).finish();
    return true;
  }
}

/* Location:
 * Qualified Name:     com.tune.crosspromo.TuneInterstitial.1
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */