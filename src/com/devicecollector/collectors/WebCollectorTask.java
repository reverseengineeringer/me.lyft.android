package com.devicecollector.collectors;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.net.http.SslError;
import android.webkit.ConsoleMessage;
import android.webkit.CookieSyncManager;
import android.webkit.SslErrorHandler;
import android.webkit.WebChromeClient;
import android.webkit.WebSettings;
import android.webkit.WebSettings.PluginState;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import com.devicecollector.DataCollection;
import java.net.MalformedURLException;
import java.net.URL;
import org.apache.http.HttpException;

public final class WebCollectorTask
  extends AbstractAsyncCollectorTask
{
  private boolean loadedLogoHtm;
  private WebView webview;
  
  public WebCollectorTask(Activity paramActivity, CollectorStatusListener paramCollectorStatusListener, DataCollection paramDataCollection, long paramLong)
  {
    super(paramActivity, paramCollectorStatusListener, paramDataCollection, CollectorEnum.WEB, paramLong);
  }
  
  private boolean onConsoleMessage(ConsoleMessage paramConsoleMessage)
  {
    debug("onConsoleMessage(%s)", new Object[] { paramConsoleMessage.message() });
    if (paramConsoleMessage.message().startsWith("●～*"))
    {
      if (paramConsoleMessage.message().substring("●～*".length()).equals("<head></head><body></body>")) {
        endProcess(SoftErrorCode.SERVICE_UNAVAILABLE, new IllegalStateException("Error response received from Device Collector."));
      }
    }
    else {
      return true;
    }
    if (!loadedLogoHtm)
    {
      endProcess(SoftErrorCode.SERVICE_UNAVAILABLE, new IllegalStateException("Never loaded logo.htm."));
      return true;
    }
    endProcess(null, null);
    return true;
  }
  
  private void onLoadResource(WebView paramWebView, String paramString)
  {
    debug("onLoadResource(%s)", new Object[] { paramString });
    try
    {
      paramWebView = new URL(paramString);
      if ((paramWebView.getPath().endsWith("logo.htm")) || (paramWebView.getPath().endsWith("logo.php")))
      {
        loadedLogoHtm = true;
        dc.setServerUrl("https://" + paramWebView.getHost());
      }
      return;
    }
    catch (MalformedURLException paramWebView)
    {
      debug("Unexpected URL problem [%s]", new Object[] { paramWebView.getMessage() });
    }
  }
  
  private void onPageFinished(WebView paramWebView, String paramString)
  {
    debug("onPageFinished(%s)", new Object[] { paramString });
    CookieSyncManager.getInstance().sync();
    paramWebView.loadUrl("javascript:console.log(" + "'" + "●～*" + "'" + "+" + "document.getElementsByTagName('html')[0].innerHTML" + ");");
  }
  
  private void onReceivedError(WebView paramWebView, int paramInt, String paramString1, String paramString2)
  {
    debug("onReceivedError(code:%d, desc:%s, url:%s)", new Object[] { Integer.valueOf(paramInt), paramString1, paramString2 });
    endProcess(SoftErrorCode.SERVICE_UNAVAILABLE, null);
  }
  
  private void onReceivedSslError(WebView paramWebView, SslErrorHandler paramSslErrorHandler, SslError paramSslError)
  {
    debug("onReceivedSslError(%s)", new Object[] { paramSslError });
    int i = paramSslError.getPrimaryError();
    if ((3 == i) || (2 == i))
    {
      debug("Ignoring trust chain validation error.", new Object[0]);
      paramSslErrorHandler.proceed();
      return;
    }
    debug("Halting due to SSL error.", new Object[0]);
    endProcess(SoftErrorCode.SERVICE_UNAVAILABLE, new HttpException("SSL ERROR:" + paramSslError.getPrimaryError()));
    paramSslErrorHandler.cancel();
  }
  
  private boolean shouldOverrideUrlLoading(WebView paramWebView, String paramString)
  {
    debug("shouldOverrideUrlLoading(%s)", new Object[] { paramString });
    return false;
  }
  
  @SuppressLint({"SetJavaScriptEnabled"})
  protected void run()
  {
    final String str = dc.getCollectorUrl() + "?m=" + dc.getMerchantId() + "&s=" + dc.getSessionId();
    debug("Calling URL: %s", new Object[] { str });
    activity.runOnUiThread(new Runnable()
    {
      public void run()
      {
        WebCollectorTask localWebCollectorTask = WebCollectorTask.this;
        WebCollectorTask.access$002(localWebCollectorTask, new WebView(activity.getApplicationContext()));
        WebSettings localWebSettings = webview.getSettings();
        localWebSettings.setJavaScriptEnabled(true);
        localWebSettings.setDomStorageEnabled(true);
        localWebSettings.setPluginState(WebSettings.PluginState.ON);
        webview.setWebViewClient(new WebViewClient()
        {
          WebCollectorTask task = WebCollectorTask.this;
          
          public void onLoadResource(WebView paramAnonymous2WebView, String paramAnonymous2String)
          {
            task.onLoadResource(paramAnonymous2WebView, paramAnonymous2String);
          }
          
          public void onPageFinished(WebView paramAnonymous2WebView, String paramAnonymous2String)
          {
            task.onPageFinished(paramAnonymous2WebView, paramAnonymous2String);
          }
          
          public void onReceivedError(WebView paramAnonymous2WebView, int paramAnonymous2Int, String paramAnonymous2String1, String paramAnonymous2String2)
          {
            task.onReceivedError(paramAnonymous2WebView, paramAnonymous2Int, paramAnonymous2String1, paramAnonymous2String2);
          }
          
          public void onReceivedSslError(WebView paramAnonymous2WebView, SslErrorHandler paramAnonymous2SslErrorHandler, SslError paramAnonymous2SslError)
          {
            task.onReceivedSslError(paramAnonymous2WebView, paramAnonymous2SslErrorHandler, paramAnonymous2SslError);
          }
          
          public boolean shouldOverrideUrlLoading(WebView paramAnonymous2WebView, String paramAnonymous2String)
          {
            return task.shouldOverrideUrlLoading(paramAnonymous2WebView, paramAnonymous2String);
          }
        });
        webview.setWebChromeClient(new WebChromeClient()
        {
          public boolean onConsoleMessage(ConsoleMessage paramAnonymous2ConsoleMessage)
          {
            return WebCollectorTask.this.onConsoleMessage(paramAnonymous2ConsoleMessage);
          }
        });
        webview.loadUrl(str);
      }
    });
    try
    {
      debug("Waiting on Collector for %d ms", new Object[] { Long.valueOf(getTimeoutMs()) });
      wait(getTimeoutMs());
      debug("Wait finished", new Object[0]);
      if (!isFinished()) {
        timeout();
      }
      for (;;)
      {
        return;
        debug("Current Host: %s", new Object[] { dc.getServerUrl() });
        endProcess(null, null);
      }
    }
    catch (InterruptedException localInterruptedException)
    {
      for (;;)
      {
        endProcess(SoftErrorCode.SERVICE_UNAVAILABLE, localInterruptedException);
      }
    }
    finally {}
  }
}

/* Location:
 * Qualified Name:     com.devicecollector.collectors.WebCollectorTask
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */