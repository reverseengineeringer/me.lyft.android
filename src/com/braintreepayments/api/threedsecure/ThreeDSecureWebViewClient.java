package com.braintreepayments.api.threedsecure;

import android.graphics.Bitmap;
import android.net.Uri;
import android.net.http.SslError;
import android.webkit.SslErrorHandler;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import com.braintreepayments.api.annotations.Beta;
import com.braintreepayments.api.models.ThreeDSecureAuthenticationResponse;

@Beta
public class ThreeDSecureWebViewClient
  extends WebViewClient
{
  private ThreeDSecureWebViewActivity mActivity;
  
  public ThreeDSecureWebViewClient(ThreeDSecureWebViewActivity paramThreeDSecureWebViewActivity)
  {
    mActivity = paramThreeDSecureWebViewActivity;
  }
  
  public void onPageFinished(WebView paramWebView, String paramString)
  {
    super.onPageFinished(paramWebView, paramString);
    mActivity.setActionBarTitle(paramWebView.getTitle());
  }
  
  public void onPageStarted(WebView paramWebView, String paramString, Bitmap paramBitmap)
  {
    if (paramString.contains("html/authentication_complete_frame"))
    {
      paramWebView.stopLoading();
      paramWebView = Uri.parse(paramString).getQueryParameter("auth_response");
      mActivity.finishWithResult(ThreeDSecureAuthenticationResponse.fromJson(paramWebView));
      return;
    }
    super.onPageStarted(paramWebView, paramString, paramBitmap);
  }
  
  public void onReceivedError(WebView paramWebView, int paramInt, String paramString1, String paramString2)
  {
    paramWebView.stopLoading();
    mActivity.finishWithResult(ThreeDSecureAuthenticationResponse.fromException(paramString1));
  }
  
  public void onReceivedSslError(WebView paramWebView, SslErrorHandler paramSslErrorHandler, SslError paramSslError)
  {
    paramSslErrorHandler.cancel();
    paramWebView.stopLoading();
    mActivity.finishWithResult(ThreeDSecureAuthenticationResponse.fromException(paramSslError.toString()));
  }
}

/* Location:
 * Qualified Name:     com.braintreepayments.api.threedsecure.ThreeDSecureWebViewClient
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */