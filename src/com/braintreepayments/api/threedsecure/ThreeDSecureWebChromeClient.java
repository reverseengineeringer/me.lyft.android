package com.braintreepayments.api.threedsecure;

import android.os.Message;
import android.webkit.WebChromeClient;
import android.webkit.WebView;
import android.webkit.WebView.WebViewTransport;
import com.braintreepayments.api.annotations.Beta;

@Beta
public class ThreeDSecureWebChromeClient
  extends WebChromeClient
{
  private ThreeDSecureWebViewActivity mActivity;
  
  public ThreeDSecureWebChromeClient(ThreeDSecureWebViewActivity paramThreeDSecureWebViewActivity)
  {
    mActivity = paramThreeDSecureWebViewActivity;
  }
  
  public void onCloseWindow(WebView paramWebView)
  {
    mActivity.popCurrentWebView();
  }
  
  public boolean onCreateWindow(WebView paramWebView, boolean paramBoolean1, boolean paramBoolean2, Message paramMessage)
  {
    paramWebView = new ThreeDSecureWebView(mActivity);
    paramWebView.init(mActivity);
    mActivity.pushNewWebView(paramWebView);
    ((WebView.WebViewTransport)obj).setWebView(paramWebView);
    paramMessage.sendToTarget();
    return true;
  }
  
  public void onProgressChanged(WebView paramWebView, int paramInt)
  {
    super.onProgressChanged(paramWebView, paramInt);
    if (paramInt < 100)
    {
      mActivity.setProgress(paramInt);
      mActivity.setProgressBarVisibility(true);
      return;
    }
    mActivity.setProgressBarVisibility(false);
  }
}

/* Location:
 * Qualified Name:     com.braintreepayments.api.threedsecure.ThreeDSecureWebChromeClient
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */