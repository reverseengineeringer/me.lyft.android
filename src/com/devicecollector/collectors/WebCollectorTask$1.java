package com.devicecollector.collectors;

import android.app.Activity;
import android.net.http.SslError;
import android.webkit.ConsoleMessage;
import android.webkit.SslErrorHandler;
import android.webkit.WebChromeClient;
import android.webkit.WebSettings;
import android.webkit.WebSettings.PluginState;
import android.webkit.WebView;
import android.webkit.WebViewClient;

class WebCollectorTask$1
  implements Runnable
{
  WebCollectorTask$1(WebCollectorTask paramWebCollectorTask, String paramString) {}
  
  public void run()
  {
    WebCollectorTask localWebCollectorTask = this$0;
    WebCollectorTask.access$002(localWebCollectorTask, new WebView(this$0.activity.getApplicationContext()));
    WebSettings localWebSettings = WebCollectorTask.access$000(localWebCollectorTask).getSettings();
    localWebSettings.setJavaScriptEnabled(true);
    localWebSettings.setDomStorageEnabled(true);
    localWebSettings.setPluginState(WebSettings.PluginState.ON);
    WebCollectorTask.access$000(localWebCollectorTask).setWebViewClient(new WebViewClient()
    {
      WebCollectorTask task = this$0;
      
      public void onLoadResource(WebView paramAnonymousWebView, String paramAnonymousString)
      {
        WebCollectorTask.access$100(task, paramAnonymousWebView, paramAnonymousString);
      }
      
      public void onPageFinished(WebView paramAnonymousWebView, String paramAnonymousString)
      {
        WebCollectorTask.access$200(task, paramAnonymousWebView, paramAnonymousString);
      }
      
      public void onReceivedError(WebView paramAnonymousWebView, int paramAnonymousInt, String paramAnonymousString1, String paramAnonymousString2)
      {
        WebCollectorTask.access$300(task, paramAnonymousWebView, paramAnonymousInt, paramAnonymousString1, paramAnonymousString2);
      }
      
      public void onReceivedSslError(WebView paramAnonymousWebView, SslErrorHandler paramAnonymousSslErrorHandler, SslError paramAnonymousSslError)
      {
        WebCollectorTask.access$400(task, paramAnonymousWebView, paramAnonymousSslErrorHandler, paramAnonymousSslError);
      }
      
      public boolean shouldOverrideUrlLoading(WebView paramAnonymousWebView, String paramAnonymousString)
      {
        return WebCollectorTask.access$500(task, paramAnonymousWebView, paramAnonymousString);
      }
    });
    WebCollectorTask.access$000(localWebCollectorTask).setWebChromeClient(new WebChromeClient()
    {
      public boolean onConsoleMessage(ConsoleMessage paramAnonymousConsoleMessage)
      {
        return WebCollectorTask.access$600(this$0, paramAnonymousConsoleMessage);
      }
    });
    WebCollectorTask.access$000(localWebCollectorTask).loadUrl(val$dcStartUrl);
  }
}

/* Location:
 * Qualified Name:     com.devicecollector.collectors.WebCollectorTask.1
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */