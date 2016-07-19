package com.threatmetrix.TrustDefenderMobile;

import android.annotation.SuppressLint;
import android.content.Context;
import android.os.Build;
import android.os.Build.VERSION;
import android.util.Log;
import android.webkit.ValueCallback;
import android.webkit.WebSettings;
import android.webkit.WebSettings.PluginState;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Locale;
import java.util.Map.Entry;
import java.util.TreeMap;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;

class JSExecutor
  extends WrapperHelper
{
  private static final String TAG = StringUtils.getLogTag(JSExecutor.class);
  private static final Method m_addJavascriptInterface;
  private static final Method m_evaluateJavascript = getMethod(WebView.class, "evaluateJavascript", new Class[] { String.class, ValueCallback.class });
  private static final Method m_getDefaultUserAgent;
  private static final Method m_removeJavascriptInterface;
  private static final Method m_setPluginState;
  private static final TreeMap<Integer, String> webkitVersions;
  private boolean javascriptInterfaceBroken = false;
  private boolean m_inited = false;
  private JavaScriptInterface m_jsInterface = null;
  private final boolean m_useWebView;
  private WebSettings m_webSettings;
  private WebView m_webView = null;
  
  static
  {
    if ((m_evaluateJavascript == null) && (Build.VERSION.SDK_INT >= 19)) {
      Log.e(TAG, "Failed to find expected function: evaluateJavascript");
    }
    m_getDefaultUserAgent = getMethod(WebSettings.class, "getDefaultUserAgent", new Class[] { Context.class });
    if ((m_getDefaultUserAgent == null) && (Build.VERSION.SDK_INT >= 17)) {
      Log.e(TAG, "Failed to find expected function: getDefaultUserAgent");
    }
    m_setPluginState = getMethod(WebSettings.class, "setPluginState", new Class[] { WebSettings.PluginState.class });
    if ((m_setPluginState == null) && ((Build.VERSION.SDK_INT >= 8) || (Build.VERSION.SDK_INT <= 18))) {
      Log.e(TAG, "Failed to find expected function: setPluginState");
    }
    m_removeJavascriptInterface = getMethod(WebView.class, "removeJavascriptInterface", new Class[] { String.class });
    if ((m_removeJavascriptInterface == null) && (Build.VERSION.SDK_INT >= 11)) {
      Log.e(TAG, "Failed to find expected function: removeJavascriptInterface");
    }
    m_addJavascriptInterface = getMethod(WebView.class, "addJavascriptInterface", new Class[] { Object.class, String.class });
    if ((m_addJavascriptInterface == null) && (Build.VERSION.SDK_INT >= 17)) {
      Log.e(TAG, "Failed to find expected function: addJavascriptInterface");
    }
    webkitVersions = new TreeMap();
    webkitVersions.put(Integer.valueOf(9), "533.1");
    webkitVersions.put(Integer.valueOf(10), "533.1");
    webkitVersions.put(Integer.valueOf(11), "533.1");
    webkitVersions.put(Integer.valueOf(12), "533.1");
    webkitVersions.put(Integer.valueOf(13), "534.13");
    webkitVersions.put(Integer.valueOf(14), "534.30");
    webkitVersions.put(Integer.valueOf(15), "534.30");
    webkitVersions.put(Integer.valueOf(16), "534.30");
    webkitVersions.put(Integer.valueOf(17), "534.30");
    webkitVersions.put(Integer.valueOf(18), "534.30");
  }
  
  @SuppressLint({"SetJavaScriptEnabled"})
  public JSExecutor(Context paramContext, JavaScriptInterface paramJavaScriptInterface, boolean paramBoolean)
  {
    String str = TAG;
    StringBuilder localStringBuilder = new StringBuilder().append("JSExecutor() Build: ").append(Build.VERSION.RELEASE);
    if (javascriptInterfaceBroken)
    {
      localObject = " busted js interface ";
      localStringBuilder = localStringBuilder.append((String)localObject);
      if (!hasAsyncInterface()) {
        break label148;
      }
    }
    label148:
    for (Object localObject = " has async interface ";; localObject = " has no async interface ")
    {
      Log.d(str, (String)localObject);
      m_jsInterface = paramJavaScriptInterface;
      m_useWebView = paramBoolean;
      if (paramBoolean)
      {
        paramBoolean = SingletonWebView.hasWebView();
        m_inited = false;
        m_webView = SingletonWebView.getInstance(paramContext);
        if (m_webView != null) {
          break label155;
        }
      }
      return;
      localObject = " normal js interface ";
      break;
    }
    label155:
    if ((paramBoolean) && (!m_inited)) {
      Log.w(TAG, "WebView re-used from previous instance. Using a short-lived TrustDefenderMobile object is not recommended. Better profiling performance will be achieved by re-using a long-lived TrustDefenderMobile instance");
    }
    paramJavaScriptInterface = TAG;
    localObject = new StringBuilder().append("Webview ");
    if (m_inited) {}
    for (paramContext = "init'd";; paramContext = "un-init'd")
    {
      Log.d(paramJavaScriptInterface, paramContext);
      if (m_jsInterface == null) {
        m_jsInterface = new JavaScriptInterface(null);
      }
      paramContext = new WebViewClient();
      m_webSettings = m_webView.getSettings();
      m_webSettings.setJavaScriptEnabled(true);
      invoke(m_webSettings, m_setPluginState, new Object[] { WebSettings.PluginState.ON });
      m_webView.setVisibility(4);
      if (!javascriptInterfaceBroken) {
        invoke(m_webView, m_removeJavascriptInterface, new Object[] { "androidJSInterface" });
      }
      m_webView.setWebViewClient(paramContext);
      if (!hasAsyncInterface()) {
        break;
      }
      if (m_jsInterface.latch == null) {
        Log.e(TAG, "alternate JS interface but no global latch");
      }
      Log.d(TAG, "JSExecutor() alternate JS interface detected");
      return;
    }
    if (!javascriptInterfaceBroken)
    {
      invoke(m_webView, m_addJavascriptInterface, new Object[] { m_jsInterface, "androidJSInterface" });
      return;
    }
    if (m_jsInterface.latch == null) {
      Log.e(TAG, "broken JS interface but no global latch");
    }
    Log.d(TAG, "JSExecutor() Broken JS interface detected, using workaround");
    m_webView.setWebChromeClient(new WebChromeWrapper(m_jsInterface));
  }
  
  public static String getUserAgentString()
  {
    Log.d(TAG, "Generating a browser string");
    if (webkitVersions.containsKey(Integer.valueOf(Build.VERSION.SDK_INT))) {}
    for (String str1 = (String)webkitVersions.get(Integer.valueOf(Build.VERSION.SDK_INT));; str1 = (String)webkitVersions.lastEntry().getValue() + "+")
    {
      String str3 = Locale.getDefault().getLanguage();
      String str4 = Locale.getDefault().getCountry();
      String str2 = str3;
      if (!str4.isEmpty()) {
        str2 = str3 + "-" + str4;
      }
      return "Mozilla/5.0 (Linux; U; Android " + Build.VERSION.RELEASE + "; " + str2.toLowerCase(Locale.US) + "; " + Build.MODEL + " Build/" + Build.DISPLAY + ") AppleWebKit/" + str1 + " (KHTML, like Gecko) Version/4.0 Mobile Safari/" + str1 + " " + TrustDefenderMobileCore.version;
    }
  }
  
  public static boolean hasAsyncInterface()
  {
    return m_evaluateJavascript != null;
  }
  
  public static boolean isBrokenJSInterface()
  {
    try
    {
      boolean bool = Build.VERSION.RELEASE.startsWith("2.3");
      return bool;
    }
    catch (Exception localException) {}
    return false;
  }
  
  public String getJSResult(String paramString)
    throws InterruptedException
  {
    if (!m_inited) {}
    Object localObject1;
    label94:
    label379:
    label407:
    do
    {
      return null;
      if (Thread.currentThread().isInterrupted()) {
        return "";
      }
      Object localObject2 = null;
      localObject1 = localObject2;
      if (!javascriptInterfaceBroken)
      {
        localObject1 = localObject2;
        if (!hasAsyncInterface())
        {
          localObject1 = new CountDownLatch(1);
          m_jsInterface.setLatch((CountDownLatch)localObject1);
        }
      }
      int i;
      if (hasAsyncInterface())
      {
        paramString = "javascript:(function(){try{return " + paramString + " + \"\";}catch(js_eval_err){return '';}})();";
        Log.d(TAG, "getJSResult() attempting to execute: " + paramString);
        m_jsInterface.returnedValue = null;
        i = 0;
        if (!hasAsyncInterface()) {
          break label379;
        }
      }
      for (;;)
      {
        try
        {
          m_evaluateJavascript.invoke(m_webView, new Object[] { paramString, m_jsInterface });
          if (i == 0) {
            break label407;
          }
          if (m_jsInterface.latch == null) {
            break;
          }
          Log.d(TAG, "getJSResult countdown for latch: " + m_jsInterface.latch.hashCode() + " with count: " + m_jsInterface.latch.getCount());
          m_jsInterface.latch.countDown();
          return null;
          if (!javascriptInterfaceBroken)
          {
            paramString = "javascript:window.androidJSInterface.getString((function(){try{return " + paramString + " + \"\";}catch(js_eval_err){return '';}})());";
            break label94;
          }
          paramString = "javascript:alert((function(){try{return " + paramString + " + \"\";}catch(js_eval_err){return '';}})());";
        }
        catch (IllegalAccessException paramString)
        {
          Log.e(TAG, "getJSResult() invoke failed: ", paramString);
          i = 1;
          continue;
        }
        catch (IllegalArgumentException paramString)
        {
          Log.e(TAG, "getJSResult() invoke failed: ", paramString);
          i = 1;
          continue;
        }
        catch (InvocationTargetException paramString)
        {
          Log.e(TAG, "getJSResult() invoke failed: ", paramString);
          i = 1;
          continue;
        }
        catch (RuntimeException paramString)
        {
          Log.e(TAG, "getJSResult() invoke failed: ", paramString);
          i = 1;
          continue;
        }
        try
        {
          m_webView.loadUrl(paramString);
        }
        catch (RuntimeException paramString)
        {
          Log.e(TAG, "getJSResult() invoke failed: ", paramString);
          i = 1;
        }
      }
    } while ((javascriptInterfaceBroken) || (hasAsyncInterface()));
    if (localObject1 != null)
    {
      Log.d(TAG, "getJSResult waiting for latch: " + localObject1.hashCode() + " with count: " + ((CountDownLatch)localObject1).getCount());
      if (!((CountDownLatch)localObject1).await(5L, TimeUnit.SECONDS)) {
        Log.d(TAG, "getJSResult timeout waiting for latch: " + localObject1.hashCode() + " with count: " + ((CountDownLatch)localObject1).getCount());
      }
      if (m_jsInterface.returnedValue != null) {
        break label564;
      }
      Log.d(TAG, "getJSResult() After latch: got null");
    }
    for (;;)
    {
      return m_jsInterface.returnedValue;
      Log.e(TAG, "latch == null");
      break;
      label564:
      Log.d(TAG, "getJSResult() After latch: got " + m_jsInterface.returnedValue);
    }
  }
  
  public String getUserAgentString(Context paramContext)
  {
    String str = (String)invoke(null, m_getDefaultUserAgent, new Object[] { paramContext });
    if ((str != null) && (!str.isEmpty())) {
      return str;
    }
    paramContext = str;
    if (m_useWebView)
    {
      paramContext = str;
      if (m_webSettings != null) {
        paramContext = m_webSettings.getUserAgentString();
      }
    }
    if ((paramContext != null) && (!paramContext.isEmpty())) {
      return paramContext;
    }
    return getUserAgentString();
  }
  
  public boolean hasBadOptions(boolean paramBoolean)
  {
    return (paramBoolean != m_useWebView) || (!m_inited);
  }
  
  public void init()
    throws InterruptedException
  {
    Log.d(TAG, "init() - init'd = " + m_inited);
    if (!m_inited)
    {
      if (m_webView != null) {
        break label60;
      }
      Log.d(TAG, "init() - No web view, nothing needs to be done");
      m_inited = true;
    }
    label60:
    CountDownLatch localCountDownLatch;
    for (;;)
    {
      return;
      Log.d(TAG, "init() loading bogus page");
      localCountDownLatch = null;
      String str;
      if ((!javascriptInterfaceBroken) && (!hasAsyncInterface()))
      {
        localCountDownLatch = new CountDownLatch(1);
        Log.d(TAG, "Creating latch: " + localCountDownLatch.hashCode() + " with count: " + localCountDownLatch.getCount());
        str = "<html><head></head><body onLoad='javascript:window.androidJSInterface.getString(1)'></body></html>";
        m_jsInterface.setLatch(localCountDownLatch);
        m_jsInterface.returnedValue = null;
      }
      while (!Thread.currentThread().isInterrupted())
      {
        m_webView.loadData(str, "text/html", null);
        if ((javascriptInterfaceBroken) || (localCountDownLatch == null) || (hasAsyncInterface())) {
          break label359;
        }
        Log.d(TAG, "waiting for latch: " + localCountDownLatch.hashCode() + " with count: " + localCountDownLatch.getCount());
        if (localCountDownLatch.await(5L, TimeUnit.SECONDS)) {
          break label269;
        }
        Log.e(TAG, "timed out waiting for javascript");
        return;
        str = "<html><head></head><body></body></html>";
      }
    }
    label269:
    m_inited = true;
    Log.d(TAG, "in init() count = " + localCountDownLatch.getCount());
    if (m_jsInterface.returnedValue == null)
    {
      Log.d(TAG, "init() After latch: got null");
      return;
    }
    Log.d(TAG, "init() After latch: got " + m_jsInterface.returnedValue);
    return;
    label359:
    m_inited = true;
  }
}

/* Location:
 * Qualified Name:     com.threatmetrix.TrustDefenderMobile.JSExecutor
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */