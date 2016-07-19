package com.tune.crosspromo;

import android.annotation.SuppressLint;
import android.app.ActionBar;
import android.app.Activity;
import android.content.ActivityNotFoundException;
import android.content.Intent;
import android.net.Uri;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.webkit.WebView;
import android.widget.FrameLayout.LayoutParams;
import org.json.JSONException;
import org.json.JSONObject;

public class TuneAdActivity
  extends Activity
{
  protected JSONObject adParams;
  public TuneAdView adView;
  protected TuneCloseButton closeButton;
  private boolean nativeCloseButton;
  protected TuneAdUtils utils;
  protected WebView webView;
  
  protected boolean isAmazonUrl(Uri paramUri)
  {
    String str = paramUri.getScheme();
    paramUri = paramUri.getHost();
    if (str == null) {}
    for (;;)
    {
      return false;
      boolean bool = str.equals("amzn");
      if (((str.equals("http")) || (str.equals("https"))) && (paramUri.equals("www.amazon.com"))) {}
      for (int i = 1; (bool) || (i != 0); i = 0) {
        return true;
      }
    }
  }
  
  protected boolean isMarketUrl(Uri paramUri)
  {
    String str = paramUri.getScheme();
    paramUri = paramUri.getHost();
    if (str == null) {}
    for (;;)
    {
      return false;
      boolean bool = str.equals("market");
      if (((str.equals("http")) || (str.equals("https"))) && ((paramUri.equals("play.google.com")) || (paramUri.equals("market.android.com")))) {}
      for (int i = 1; (bool) || (i != 0); i = 0) {
        return true;
      }
    }
  }
  
  public void onBackPressed()
  {
    if (adView != null) {
      TuneAdClient.logClose(adView, adParams);
    }
    super.onBackPressed();
  }
  
  @SuppressLint({"SetJavaScriptEnabled"})
  protected void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    requestWindowFeature(1);
    utils = TuneAdUtils.getInstance();
    if (getIntent().getBooleanExtra("INTERSTITIAL", false))
    {
      paramBundle = TuneAdOrientation.forValue(getIntent().getStringExtra("ORIENTATION"));
      if (paramBundle == TuneAdOrientation.PORTRAIT_ONLY) {
        setRequestedOrientation(1);
      }
      for (;;)
      {
        paramBundle = getIntent().getStringExtra("PLACEMENT");
        adView = utils.getPreviousView(paramBundle);
        webView = adView.webView;
        utils.setAdContext(this);
        adView.requestId = getIntent().getStringExtra("REQUESTID");
        try
        {
          adParams = new JSONObject(getIntent().getStringExtra("ADPARAMS"));
          paramBundle = (ViewGroup)getWindow().getDecorView();
          paramBundle.setBackgroundColor(0);
          nativeCloseButton = getIntent().getBooleanExtra("NATIVECLOSEBUTTON", false);
          if (nativeCloseButton)
          {
            closeButton = new TuneCloseButton(this);
            FrameLayout.LayoutParams localLayoutParams = new FrameLayout.LayoutParams(-1, -1);
            closeButton.setLayoutParams(localLayoutParams);
            paramBundle.addView(closeButton);
          }
          setContentView(webView);
          return;
          if (paramBundle == TuneAdOrientation.LANDSCAPE_ONLY) {
            setRequestedOrientation(0);
          }
        }
        catch (JSONException paramBundle)
        {
          for (;;)
          {
            paramBundle.printStackTrace();
          }
        }
      }
    }
    paramBundle = getIntent().getStringExtra("REDIRECT_URI");
    getWindow().requestFeature(2);
    getWindow().setFeatureInt(2, -1);
    if (paramBundle != null)
    {
      paramBundle = Uri.parse(paramBundle);
      if (!isMarketUrl(paramBundle)) {
        break label295;
      }
      processMarketUri(paramBundle);
    }
    for (;;)
    {
      finish();
      return;
      label295:
      if (isAmazonUrl(paramBundle)) {
        processAmazonUri(paramBundle);
      } else {
        try
        {
          startActivity(new Intent("android.intent.action.VIEW", paramBundle));
        }
        catch (ActivityNotFoundException paramBundle)
        {
          paramBundle.printStackTrace();
        }
      }
    }
  }
  
  public void onDestroy()
  {
    ViewGroup localViewGroup = (ViewGroup)getWindow().getDecorView();
    if (nativeCloseButton) {
      localViewGroup.removeView(closeButton);
    }
    if ((webView != null) && (webView.getParent() != null))
    {
      ((ViewGroup)webView.getParent()).removeView(webView);
      webView.loadUrl("about:blank");
    }
    utils.setAdContext(null);
    super.onDestroy();
  }
  
  @SuppressLint({"NewApi"})
  public void onResume()
  {
    super.onResume();
    if (Build.VERSION.SDK_INT < 16) {
      getWindow().setFlags(1024, 1024);
    }
    for (;;)
    {
      if (Build.VERSION.SDK_INT >= 11)
      {
        ActionBar localActionBar = getActionBar();
        if (localActionBar != null) {
          localActionBar.hide();
        }
      }
      return;
      getWindow().getDecorView().setSystemUiVisibility(1028);
    }
  }
  
  protected void processAmazonUri(Uri paramUri)
  {
    paramUri = paramUri.getQuery();
    try
    {
      startActivity(new Intent("android.intent.action.VIEW", Uri.parse(String.format("amzn://apps/android?%s", new Object[] { paramUri }))));
      return;
    }
    catch (ActivityNotFoundException localActivityNotFoundException)
    {
      startActivity(new Intent("android.intent.action.VIEW", Uri.parse(String.format("http://www.amazon.com/gp/mas/dl/android?%s", new Object[] { paramUri }))));
    }
  }
  
  protected void processMarketUri(Uri paramUri)
  {
    paramUri = paramUri.getQuery();
    try
    {
      startActivity(new Intent("android.intent.action.VIEW", Uri.parse(String.format("market://details?%s", new Object[] { paramUri }))));
      return;
    }
    catch (ActivityNotFoundException localActivityNotFoundException)
    {
      startActivity(new Intent("android.intent.action.VIEW", Uri.parse(String.format("http://play.google.com/store/apps/details?%s", new Object[] { paramUri }))));
    }
  }
}

/* Location:
 * Qualified Name:     com.tune.crosspromo.TuneAdActivity
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */