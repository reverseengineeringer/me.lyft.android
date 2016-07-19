package com.appboy.ui.inappmessage.views;

import android.content.Context;
import android.os.Build.VERSION;
import android.util.AttributeSet;
import android.webkit.WebSettings;
import android.webkit.WebView;
import com.appboy.ui.R.id;

public class AppboyInAppMessageHtmlFullView
  extends AppboyInAppMessageHtmlBaseView
{
  private WebView mMessageWebView;
  
  public AppboyInAppMessageHtmlFullView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
  }
  
  public WebView getMessageWebView()
  {
    if (mMessageWebView == null)
    {
      mMessageWebView = ((AppboyInAppMessageWebView)findViewById(R.id.com_appboy_inappmessage_html_full_webview));
      if (mMessageWebView != null)
      {
        WebSettings localWebSettings = mMessageWebView.getSettings();
        localWebSettings.setJavaScriptEnabled(true);
        localWebSettings.setUseWideViewPort(true);
        localWebSettings.setLoadWithOverviewMode(true);
        if (Build.VERSION.SDK_INT >= 11)
        {
          localWebSettings.setDisplayZoomControls(false);
          mMessageWebView.setLayerType(1, null);
        }
        mMessageWebView.setBackgroundColor(0);
      }
    }
    return mMessageWebView;
  }
}

/* Location:
 * Qualified Name:     com.appboy.ui.inappmessage.views.AppboyInAppMessageHtmlFullView
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */