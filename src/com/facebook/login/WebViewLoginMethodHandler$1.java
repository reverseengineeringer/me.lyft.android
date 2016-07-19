package com.facebook.login;

import android.os.Bundle;
import com.facebook.FacebookException;
import com.facebook.internal.WebDialog.OnCompleteListener;

class WebViewLoginMethodHandler$1
  implements WebDialog.OnCompleteListener
{
  WebViewLoginMethodHandler$1(WebViewLoginMethodHandler paramWebViewLoginMethodHandler, LoginClient.Request paramRequest) {}
  
  public void onComplete(Bundle paramBundle, FacebookException paramFacebookException)
  {
    this$0.onWebDialogComplete(val$request, paramBundle, paramFacebookException);
  }
}

/* Location:
 * Qualified Name:     com.facebook.login.WebViewLoginMethodHandler.1
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */