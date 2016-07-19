package com.appboy.ui;

import android.content.Intent;
import android.net.Uri;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import com.appboy.support.AppboyLogger;
import com.appboy.ui.actions.ActionFactory;
import com.appboy.ui.actions.IAction;
import com.appboy.ui.actions.WebAction;
import java.util.List;

class AppboyWebViewActivity$3
  extends WebViewClient
{
  AppboyWebViewActivity$3(AppboyWebViewActivity paramAppboyWebViewActivity) {}
  
  public boolean shouldOverrideUrlLoading(WebView paramWebView, String paramString)
  {
    try
    {
      if (!WebAction.getSupportedSchemes().contains(Uri.parse(paramString).getScheme()))
      {
        ActionFactory.createViewUriAction(paramString, this$0.getIntent().getExtras()).execute(paramWebView.getContext());
        this$0.finish();
        return true;
      }
    }
    catch (Exception localException)
    {
      AppboyLogger.i(AppboyWebViewActivity.access$000(), String.format("Unexpected exception while processing url %s. Passing url back to WebView.", new Object[] { paramString }), localException);
    }
    return super.shouldOverrideUrlLoading(paramWebView, paramString);
  }
}

/* Location:
 * Qualified Name:     com.appboy.ui.AppboyWebViewActivity.3
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */