package com.threatmetrix.TrustDefenderMobile;

import android.webkit.WebView;

final class SingletonWebView$1
  implements Runnable
{
  SingletonWebView$1(WebView paramWebView) {}
  
  public void run()
  {
    val$tempWebView.removeAllViews();
    val$tempWebView.destroy();
  }
}

/* Location:
 * Qualified Name:     com.threatmetrix.TrustDefenderMobile.SingletonWebView.1
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */