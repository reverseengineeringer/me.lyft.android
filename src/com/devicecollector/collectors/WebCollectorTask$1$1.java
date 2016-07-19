package com.devicecollector.collectors;

import android.net.http.SslError;
import android.webkit.SslErrorHandler;
import android.webkit.WebView;
import android.webkit.WebViewClient;

class WebCollectorTask$1$1
  extends WebViewClient
{
  WebCollectorTask task = this$1.this$0;
  
  WebCollectorTask$1$1(WebCollectorTask.1 param1) {}
  
  public void onLoadResource(WebView paramWebView, String paramString)
  {
    WebCollectorTask.access$100(task, paramWebView, paramString);
  }
  
  public void onPageFinished(WebView paramWebView, String paramString)
  {
    WebCollectorTask.access$200(task, paramWebView, paramString);
  }
  
  public void onReceivedError(WebView paramWebView, int paramInt, String paramString1, String paramString2)
  {
    WebCollectorTask.access$300(task, paramWebView, paramInt, paramString1, paramString2);
  }
  
  public void onReceivedSslError(WebView paramWebView, SslErrorHandler paramSslErrorHandler, SslError paramSslError)
  {
    WebCollectorTask.access$400(task, paramWebView, paramSslErrorHandler, paramSslError);
  }
  
  public boolean shouldOverrideUrlLoading(WebView paramWebView, String paramString)
  {
    return WebCollectorTask.access$500(task, paramWebView, paramString);
  }
}

/* Location:
 * Qualified Name:     com.devicecollector.collectors.WebCollectorTask.1.1
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */