package com.braintreepayments.api.threedsecure;

import android.annotation.SuppressLint;
import android.annotation.TargetApi;
import android.content.Context;
import android.os.Build.VERSION;
import android.util.AttributeSet;
import android.webkit.WebSettings;
import android.webkit.WebView;
import com.braintreepayments.api.annotations.Beta;
import com.braintreepayments.api.internal.HttpRequest;

@SuppressLint({"SetJavaScriptEnabled"})
@Beta
public class ThreeDSecureWebView
  extends WebView
{
  public ThreeDSecureWebView(Context paramContext)
  {
    super(paramContext);
  }
  
  public ThreeDSecureWebView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
  }
  
  public ThreeDSecureWebView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
  }
  
  @TargetApi(21)
  public ThreeDSecureWebView(Context paramContext, AttributeSet paramAttributeSet, int paramInt1, int paramInt2)
  {
    super(paramContext, paramAttributeSet, paramInt1, paramInt2);
  }
  
  @TargetApi(11)
  public ThreeDSecureWebView(Context paramContext, AttributeSet paramAttributeSet, int paramInt, boolean paramBoolean)
  {
    super(paramContext, paramAttributeSet, paramInt, paramBoolean);
  }
  
  @TargetApi(11)
  private void disableOnScreenZoomControls(WebSettings paramWebSettings)
  {
    if (Build.VERSION.SDK_INT >= 11) {
      paramWebSettings.setDisplayZoomControls(false);
    }
  }
  
  protected void init(ThreeDSecureWebViewActivity paramThreeDSecureWebViewActivity)
  {
    setId(16908312);
    WebSettings localWebSettings = getSettings();
    localWebSettings.setUserAgentString(HttpRequest.getUserAgent());
    localWebSettings.setCacheMode(1);
    localWebSettings.setSupportMultipleWindows(true);
    localWebSettings.setJavaScriptEnabled(true);
    localWebSettings.setBuiltInZoomControls(true);
    disableOnScreenZoomControls(localWebSettings);
    setWebChromeClient(new ThreeDSecureWebChromeClient(paramThreeDSecureWebViewActivity));
    setWebViewClient(new ThreeDSecureWebViewClient(paramThreeDSecureWebViewActivity));
  }
}

/* Location:
 * Qualified Name:     com.braintreepayments.api.threedsecure.ThreeDSecureWebView
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */