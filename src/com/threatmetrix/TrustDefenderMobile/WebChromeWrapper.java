package com.threatmetrix.TrustDefenderMobile;

import android.util.Log;
import android.webkit.JsResult;
import android.webkit.WebChromeClient;
import android.webkit.WebView;

class WebChromeWrapper
  extends WebChromeClient
{
  private final String TAG = StringUtils.getLogTag(WebChromeWrapper.class);
  private final JavaScriptInterface m_jsInterface;
  
  public WebChromeWrapper(JavaScriptInterface paramJavaScriptInterface)
  {
    m_jsInterface = paramJavaScriptInterface;
  }
  
  public boolean onJsAlert(WebView paramWebView, String paramString1, String paramString2, JsResult paramJsResult)
  {
    Log.d(TAG, "onJsAlert() -" + paramString2);
    m_jsInterface.getString(paramString2);
    paramJsResult.confirm();
    return true;
  }
}

/* Location:
 * Qualified Name:     com.threatmetrix.TrustDefenderMobile.WebChromeWrapper
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */