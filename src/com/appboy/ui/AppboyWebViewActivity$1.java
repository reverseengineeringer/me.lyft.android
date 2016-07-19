package com.appboy.ui;

import android.webkit.WebChromeClient;
import android.webkit.WebView;

class AppboyWebViewActivity$1
  extends WebChromeClient
{
  AppboyWebViewActivity$1(AppboyWebViewActivity paramAppboyWebViewActivity) {}
  
  public void onProgressChanged(WebView paramWebView, int paramInt)
  {
    if (paramInt < 100)
    {
      this$0.setProgressBarVisibility(true);
      return;
    }
    this$0.setProgressBarVisibility(false);
  }
}

/* Location:
 * Qualified Name:     com.appboy.ui.AppboyWebViewActivity.1
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */