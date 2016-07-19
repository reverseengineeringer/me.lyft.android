package com.appboy.ui;

import android.annotation.TargetApi;
import android.content.Intent;
import android.net.Uri;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.webkit.DownloadListener;
import android.webkit.WebChromeClient;
import android.webkit.WebSettings;
import android.webkit.WebSettings.PluginState;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.RelativeLayout.LayoutParams;
import com.appboy.Constants;
import com.appboy.support.AppboyLogger;
import com.appboy.ui.actions.ActionFactory;
import com.appboy.ui.actions.IAction;
import com.appboy.ui.actions.WebAction;
import com.appboy.ui.activities.AppboyBaseActivity;
import java.util.List;

public class AppboyWebViewActivity
  extends AppboyBaseActivity
{
  private static final String TAG = String.format("%s.%s", new Object[] { Constants.APPBOY_LOG_TAG_PREFIX, AppboyWebViewActivity.class.getName() });
  public static final String URL_EXTRA = "url";
  
  @TargetApi(11)
  private void setWebLayerTypeSafe(WebView paramWebView)
  {
    if (Build.VERSION.SDK_INT >= 11) {
      paramWebView.setLayerType(1, null);
    }
  }
  
  @TargetApi(11)
  private void setZoomSafe(WebSettings paramWebSettings)
  {
    if (Build.VERSION.SDK_INT >= 11) {
      paramWebSettings.setDisplayZoomControls(false);
    }
  }
  
  public void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    requestWindowFeature(2);
    requestWindowFeature(5);
    setContentView(R.layout.com_appboy_webview_activity);
    setProgressBarVisibility(true);
    paramBundle = (WebView)findViewById(R.id.com_appboy_webview_activity_webview);
    Object localObject = paramBundle.getSettings();
    ((WebSettings)localObject).setJavaScriptEnabled(true);
    ((WebSettings)localObject).setAllowFileAccess(false);
    ((WebSettings)localObject).setPluginState(WebSettings.PluginState.OFF);
    setZoomSafe((WebSettings)localObject);
    ((WebSettings)localObject).setBuiltInZoomControls(true);
    ((WebSettings)localObject).setUseWideViewPort(true);
    ((WebSettings)localObject).setLoadWithOverviewMode(true);
    ((WebSettings)localObject).setDomStorageEnabled(true);
    paramBundle.setLayoutParams(new RelativeLayout.LayoutParams(-1, -1));
    paramBundle.setWebChromeClient(new WebChromeClient()
    {
      public void onProgressChanged(WebView paramAnonymousWebView, int paramAnonymousInt)
      {
        if (paramAnonymousInt < 100)
        {
          setProgressBarVisibility(true);
          return;
        }
        setProgressBarVisibility(false);
      }
    });
    paramBundle.setDownloadListener(new DownloadListener()
    {
      public void onDownloadStart(String paramAnonymousString1, String paramAnonymousString2, String paramAnonymousString3, String paramAnonymousString4, long paramAnonymousLong)
      {
        paramAnonymousString2 = new Intent("android.intent.action.VIEW");
        paramAnonymousString2.setData(Uri.parse(paramAnonymousString1));
        startActivity(paramAnonymousString2);
      }
    });
    paramBundle.getSettings().setCacheMode(2);
    setWebLayerTypeSafe(paramBundle);
    paramBundle.setWebViewClient(new WebViewClient()
    {
      public boolean shouldOverrideUrlLoading(WebView paramAnonymousWebView, String paramAnonymousString)
      {
        try
        {
          if (!WebAction.getSupportedSchemes().contains(Uri.parse(paramAnonymousString).getScheme()))
          {
            ActionFactory.createViewUriAction(paramAnonymousString, getIntent().getExtras()).execute(paramAnonymousWebView.getContext());
            finish();
            return true;
          }
        }
        catch (Exception localException)
        {
          AppboyLogger.i(AppboyWebViewActivity.TAG, String.format("Unexpected exception while processing url %s. Passing url back to WebView.", new Object[] { paramAnonymousString }), localException);
        }
        return super.shouldOverrideUrlLoading(paramAnonymousWebView, paramAnonymousString);
      }
    });
    localObject = getIntent().getExtras();
    if ((localObject != null) && (((Bundle)localObject).containsKey("url"))) {
      paramBundle.loadUrl(((Bundle)localObject).getString("url"));
    }
  }
}

/* Location:
 * Qualified Name:     com.appboy.ui.AppboyWebViewActivity
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */