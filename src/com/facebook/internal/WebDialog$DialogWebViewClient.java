package com.facebook.internal;

import android.app.ProgressDialog;
import android.content.ActivityNotFoundException;
import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.net.Uri;
import android.net.http.SslError;
import android.os.Bundle;
import android.webkit.SslErrorHandler;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.FrameLayout;
import android.widget.ImageView;
import com.facebook.FacebookDialogException;
import com.facebook.FacebookRequestError;
import com.facebook.FacebookServiceException;

class WebDialog$DialogWebViewClient
  extends WebViewClient
{
  private WebDialog$DialogWebViewClient(WebDialog paramWebDialog) {}
  
  public void onPageFinished(WebView paramWebView, String paramString)
  {
    super.onPageFinished(paramWebView, paramString);
    if (!WebDialog.access$200(this$0)) {
      WebDialog.access$300(this$0).dismiss();
    }
    WebDialog.access$400(this$0).setBackgroundColor(0);
    WebDialog.access$500(this$0).setVisibility(0);
    WebDialog.access$600(this$0).setVisibility(0);
    WebDialog.access$702(this$0, true);
  }
  
  public void onPageStarted(WebView paramWebView, String paramString, Bitmap paramBitmap)
  {
    Utility.logd("FacebookSDK.WebDialog", "Webview loading URL: " + paramString);
    super.onPageStarted(paramWebView, paramString, paramBitmap);
    if (!WebDialog.access$200(this$0)) {
      WebDialog.access$300(this$0).show();
    }
  }
  
  public void onReceivedError(WebView paramWebView, int paramInt, String paramString1, String paramString2)
  {
    super.onReceivedError(paramWebView, paramInt, paramString1, paramString2);
    this$0.sendErrorToListener(new FacebookDialogException(paramString1, paramInt, paramString2));
  }
  
  public void onReceivedSslError(WebView paramWebView, SslErrorHandler paramSslErrorHandler, SslError paramSslError)
  {
    super.onReceivedSslError(paramWebView, paramSslErrorHandler, paramSslError);
    paramSslErrorHandler.cancel();
    this$0.sendErrorToListener(new FacebookDialogException(null, -11, null));
  }
  
  public boolean shouldOverrideUrlLoading(WebView paramWebView, String paramString)
  {
    Utility.logd("FacebookSDK.WebDialog", "Redirect URL: " + paramString);
    if (paramString.startsWith(WebDialog.access$100(this$0)))
    {
      Bundle localBundle = this$0.parseResponseUri(paramString);
      paramWebView = localBundle.getString("error");
      paramString = paramWebView;
      if (paramWebView == null) {
        paramString = localBundle.getString("error_type");
      }
      Object localObject = localBundle.getString("error_msg");
      paramWebView = (WebView)localObject;
      if (localObject == null) {
        paramWebView = localBundle.getString("error_message");
      }
      localObject = paramWebView;
      if (paramWebView == null) {
        localObject = localBundle.getString("error_description");
      }
      paramWebView = localBundle.getString("error_code");
      int i = -1;
      if (!Utility.isNullOrEmpty(paramWebView)) {}
      try
      {
        i = Integer.parseInt(paramWebView);
        if ((Utility.isNullOrEmpty(paramString)) && (Utility.isNullOrEmpty((String)localObject)) && (i == -1))
        {
          this$0.sendSuccessToListener(localBundle);
          return true;
        }
      }
      catch (NumberFormatException paramWebView)
      {
        for (;;)
        {
          i = -1;
          continue;
          if ((paramString != null) && ((paramString.equals("access_denied")) || (paramString.equals("OAuthAccessDeniedException"))))
          {
            this$0.cancel();
          }
          else if (i == 4201)
          {
            this$0.cancel();
          }
          else
          {
            paramWebView = new FacebookRequestError(i, paramString, (String)localObject);
            this$0.sendErrorToListener(new FacebookServiceException(paramWebView, (String)localObject));
          }
        }
      }
    }
    if (paramString.startsWith("fbconnect://cancel"))
    {
      this$0.cancel();
      return true;
    }
    if (paramString.contains("touch")) {
      return false;
    }
    try
    {
      this$0.getContext().startActivity(new Intent("android.intent.action.VIEW", Uri.parse(paramString)));
      return true;
    }
    catch (ActivityNotFoundException paramWebView) {}
    return false;
  }
}

/* Location:
 * Qualified Name:     com.facebook.internal.WebDialog.DialogWebViewClient
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */