package com.tune.crosspromo;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Handler;
import android.util.Log;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.FrameLayout.LayoutParams;
import com.mobileapptracker.MATParameters;
import java.net.SocketException;
import java.util.concurrent.ExecutorService;
import org.json.JSONException;
import org.json.JSONObject;

public class TuneInterstitial
  implements TuneAd
{
  private TuneAdParams mAdParams;
  private Context mContext;
  private Handler mHandler;
  private int mLastOrientation;
  private TuneAdListener mListener;
  private TuneAdOrientation mOrientation;
  private boolean mShowOnLoad;
  private boolean nativeCloseButton;
  private TuneAdUtils utils;
  
  private void displayInterstitial(TuneAdView paramTuneAdView)
  {
    Activity localActivity = (Activity)mContext;
    Intent localIntent = new Intent(mContext, TuneAdActivity.class);
    localIntent.putExtra("INTERSTITIAL", true);
    localIntent.putExtra("REQUESTID", requestId);
    localIntent.putExtra("ADPARAMS", mAdParams.toJSON().toString());
    localIntent.putExtra("NATIVECLOSEBUTTON", nativeCloseButton);
    localIntent.putExtra("PLACEMENT", placement);
    localIntent.putExtra("ORIENTATION", mOrientation.value());
    localActivity.startActivity(localIntent);
    localActivity.overridePendingTransition(17432576, 17432577);
    TuneAdClient.logView(paramTuneAdView, mAdParams.toJSON());
    utils.changeView(placement);
    notifyOnShow();
    cache(placement, metadata);
  }
  
  private TuneAdView getCurrentAd(String paramString)
  {
    return utils.getCurrentView(paramString);
  }
  
  private void initAdViewSet(String paramString, TuneAdMetadata paramTuneAdMetadata)
  {
    paramString = new TuneAdViewSet(paramString, new TuneAdView(paramString, paramTuneAdMetadata, initializeWebView(mContext, paramString)), new TuneAdView(paramString, paramTuneAdMetadata, initializeWebView(mContext, paramString)));
    utils.addViewSet(paramString);
  }
  
  @SuppressLint({"SetJavaScriptEnabled"})
  private WebView initializeWebView(Context paramContext, final String paramString)
  {
    paramContext = new WebView(paramContext);
    Object localObject = new FrameLayout.LayoutParams(-1, -1);
    gravity = 17;
    paramContext.setLayoutParams((ViewGroup.LayoutParams)localObject);
    paramContext.setBackgroundColor(0);
    paramContext.setScrollBarStyle(0);
    localObject = paramContext.getSettings();
    ((WebSettings)localObject).setJavaScriptEnabled(true);
    ((WebSettings)localObject).setLoadWithOverviewMode(true);
    ((WebSettings)localObject).setUseWideViewPort(true);
    paramContext.setWebViewClient(new WebViewClient()
    {
      public void onPageFinished(WebView paramAnonymousWebView, String paramAnonymousString)
      {
        if (!paramAnonymousString.equals("about:blank")) {
          TuneInterstitial.this.notifyOnLoad(paramString);
        }
      }
      
      public boolean shouldOverrideUrlLoading(WebView paramAnonymousWebView, String paramAnonymousString)
      {
        ((ViewGroup)paramAnonymousWebView.getParent()).removeView(paramAnonymousWebView);
        TuneInterstitial.this.processClick(paramAnonymousString, paramString);
        ((Activity)utils.getAdContext()).finish();
        return true;
      }
    });
    return paramContext;
  }
  
  private void loadAd(String paramString, TuneAdMetadata paramTuneAdMetadata)
  {
    long l = System.currentTimeMillis();
    for (;;)
    {
      if (((utils.getParams().getGoogleAdvertisingId() != null) && (utils.getParams().getAndroidId() != null)) || (System.currentTimeMillis() - l > 500L))
      {
        mAdParams = new TuneAdParams(paramString, utils.getParams(), paramTuneAdMetadata, mOrientation, mLastOrientation);
        requestAd(paramString, 0);
        return;
      }
      try
      {
        Thread.sleep(50L);
      }
      catch (InterruptedException localInterruptedException)
      {
        localInterruptedException.printStackTrace();
      }
    }
  }
  
  private void loadWebView(final String paramString1, final String paramString2)
  {
    mHandler.post(new Runnable()
    {
      public void run()
      {
        TuneInterstitial.this.getCurrentAd(paramString1).loadView(paramString2);
      }
    });
  }
  
  private void notifyOnClick()
  {
    mHandler.post(new Runnable()
    {
      public void run()
      {
        if (mListener != null) {
          mListener.onAdClick(TuneInterstitial.this);
        }
      }
    });
  }
  
  private void notifyOnFailed(String paramString1, final String paramString2)
  {
    getCurrentAdloading = false;
    mHandler.post(new Runnable()
    {
      public void run()
      {
        if (mListener != null) {
          mListener.onAdLoadFailed(TuneInterstitial.this, paramString2);
        }
      }
    });
  }
  
  private void notifyOnLoad(String paramString)
  {
    paramString = getCurrentAd(paramString);
    loaded = true;
    loading = false;
    if (mShowOnLoad)
    {
      mShowOnLoad = false;
      displayInterstitial(paramString);
    }
    mHandler.post(new Runnable()
    {
      public void run()
      {
        if (mListener != null) {
          mListener.onAdLoad(TuneInterstitial.this);
        }
      }
    });
  }
  
  private void notifyOnShow()
  {
    mHandler.post(new Runnable()
    {
      public void run()
      {
        if (mListener != null) {
          mListener.onAdShown(TuneInterstitial.this);
        }
      }
    });
  }
  
  private void processClick(String paramString1, String paramString2)
  {
    paramString2 = utils.getPreviousView(paramString2);
    if (paramString1.contains("#close"))
    {
      TuneAdClient.logClose(paramString2, mAdParams.toJSON());
      return;
    }
    Intent localIntent = new Intent(mContext, TuneAdActivity.class);
    localIntent.putExtra("INTERSTITIAL", false);
    localIntent.putExtra("REDIRECT_URI", paramString1);
    ((Activity)mContext).startActivity(localIntent);
    notifyOnClick();
    TuneAdClient.logClick(paramString2, mAdParams.toJSON());
  }
  
  private void requestAd(String paramString, int paramInt)
  {
    if (mAdParams.debugMode) {
      Log.d("TUNE", "Requesting interstitial with: " + mAdParams.toJSON().toString());
    }
    try
    {
      Object localObject = TuneAdClient.requestInterstitialAd(mAdParams);
      if (localObject != null)
      {
        boolean bool = ((String)localObject).equals("");
        if (!bool) {
          try
          {
            localObject = new JSONObject((String)localObject);
            if ((((JSONObject)localObject).has("error")) && (((JSONObject)localObject).has("message")))
            {
              Log.d("TUNE", ((JSONObject)localObject).optString("error") + ": " + ((JSONObject)localObject).optString("message"));
              if (mAdParams.debugMode) {
                Log.d("TUNE", "Debug request url: " + ((JSONObject)localObject).optString("requestUrl"));
              }
              notifyOnFailed(paramString, ((JSONObject)localObject).optString("message"));
              return;
            }
            String str = ((JSONObject)localObject).optString("html");
            if (!str.equals(""))
            {
              getCurrentAdrequestId = ((JSONObject)localObject).optString("requestId");
              mAdParams.setRefs(((JSONObject)localObject).optJSONObject("refs"));
              if (((JSONObject)localObject).has("close")) {
                nativeCloseButton = ((JSONObject)localObject).optString("close").equals("native");
              }
              loadWebView(paramString, str);
              return;
            }
          }
          catch (JSONException localJSONException)
          {
            localJSONException.printStackTrace();
            return;
          }
        }
      }
      return;
    }
    catch (TuneBadRequestException localTuneBadRequestException)
    {
      if (paramInt == 4)
      {
        notifyOnFailed(paramString, "Bad request");
        return;
        notifyOnFailed(paramString, "Unknown error");
        return;
      }
    }
    catch (TuneServerErrorException localTuneServerErrorException)
    {
      if (paramInt == 4)
      {
        notifyOnFailed(paramString, "Server error");
        return;
        notifyOnFailed(paramString, "Unknown error");
        return;
      }
    }
    catch (SocketException localSocketException)
    {
      if (paramInt == 4)
      {
        notifyOnFailed(paramString, "Request timed out");
        return;
        notifyOnFailed(paramString, "Network error");
        return;
        requestAd(paramString, paramInt + 1);
        return;
        requestAd(paramString, paramInt + 1);
        return;
      }
      requestAd(paramString, paramInt + 1);
    }
  }
  
  public void cache(final String paramString, final TuneAdMetadata paramTuneAdMetadata)
  {
    if ((paramString == null) || (paramString.isEmpty()) || (paramString.equals("null"))) {
      throw new IllegalArgumentException("Placement must not be null or empty");
    }
    if (!utils.hasViewSet(paramString)) {
      initAdViewSet(paramString, paramTuneAdMetadata);
    }
    TuneAdView localTuneAdView = getCurrentAd(paramString);
    metadata = paramTuneAdMetadata;
    loaded = false;
    loading = true;
    utils.getAdThread().execute(new Runnable()
    {
      public void run()
      {
        TuneInterstitial.this.loadAd(paramString, paramTuneAdMetadata);
      }
    });
  }
}

/* Location:
 * Qualified Name:     com.tune.crosspromo.TuneInterstitial
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */