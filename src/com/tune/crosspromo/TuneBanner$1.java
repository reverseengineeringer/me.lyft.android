package com.tune.crosspromo;

import android.os.Handler;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.ViewSwitcher;

class TuneBanner$1
  extends WebViewClient
{
  TuneBanner$1(TuneBanner paramTuneBanner) {}
  
  public void onPageFinished(WebView paramWebView, String paramString)
  {
    TuneBanner.access$100(this$0);
    if (TuneBanner.access$200(this$0) != null)
    {
      TuneBanner.access$200(this$0).setVisibility(0);
      if (TuneBanner.access$200(this$0).getCurrentView() != TuneBanner.access$300(this$0)) {
        break label105;
      }
      TuneBanner.access$400(this$0).postDelayed(new Runnable()
      {
        public void run()
        {
          if (TuneBanner.access$200(this$0) != null) {
            TuneBanner.access$200(this$0).showNext();
          }
        }
      }, 50L);
    }
    for (;;)
    {
      TuneAdClient.logView(TuneBanner.access$500(this$0), TuneBanner.access$600(this$0).toJSON());
      TuneBanner.access$700(this$0);
      TuneBanner.access$800(this$0);
      return;
      label105:
      TuneBanner.access$400(this$0).postDelayed(new Runnable()
      {
        public void run()
        {
          if (TuneBanner.access$200(this$0) != null) {
            TuneBanner.access$200(this$0).showPrevious();
          }
        }
      }, 50L);
    }
  }
  
  public boolean shouldOverrideUrlLoading(WebView paramWebView, String paramString)
  {
    TuneBanner.access$000(this$0, paramString);
    return true;
  }
}

/* Location:
 * Qualified Name:     com.tune.crosspromo.TuneBanner.1
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */