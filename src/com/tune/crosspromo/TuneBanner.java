package com.tune.crosspromo;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.os.Handler;
import android.view.View.MeasureSpec;
import android.view.ViewGroup.LayoutParams;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.FrameLayout;
import android.widget.FrameLayout.LayoutParams;
import android.widget.RelativeLayout.LayoutParams;
import android.widget.ViewSwitcher;

public class TuneBanner
  extends FrameLayout
  implements TuneAd
{
  private TuneAdParams mAdParams;
  private TuneAdView mAdView;
  private Context mContext;
  private Handler mHandler;
  private int mLastOrientation;
  private TuneAdListener mListener;
  private TuneBannerPosition mPosition;
  private TuneAdSize mSize;
  private ViewSwitcher mViewSwitcher;
  private WebView mWebView1;
  
  private void notifyOnClick()
  {
    mHandler.post(new Runnable()
    {
      public void run()
      {
        if (mListener != null) {
          mListener.onAdClick(TuneBanner.this);
        }
      }
    });
  }
  
  private void notifyOnLoad()
  {
    mHandler.post(new Runnable()
    {
      public void run()
      {
        if (mListener != null) {
          mListener.onAdLoad(TuneBanner.this);
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
          mListener.onAdShown(TuneBanner.this);
        }
      }
    });
  }
  
  private void positionAd()
  {
    ViewGroup.LayoutParams localLayoutParams = getLayoutParams();
    if (localLayoutParams != null)
    {
      width = mSize.getWidthPixels(mContext);
      height = mSize.getHeightPixels(mContext);
    }
    if ((localLayoutParams instanceof FrameLayout.LayoutParams))
    {
      localObject = new FrameLayout.LayoutParams(width, height);
      switch (mPosition)
      {
      default: 
        gravity = 81;
      }
    }
    do
    {
      for (;;)
      {
        setLayoutParams((ViewGroup.LayoutParams)localObject);
        return;
        gravity = 49;
      }
      localObject = localLayoutParams;
    } while (!(localLayoutParams instanceof RelativeLayout.LayoutParams));
    Object localObject = new RelativeLayout.LayoutParams(width, height);
    switch (mPosition)
    {
    default: 
      ((RelativeLayout.LayoutParams)localObject).addRule(12);
      ((RelativeLayout.LayoutParams)localObject).addRule(14);
    }
    for (;;)
    {
      break;
      ((RelativeLayout.LayoutParams)localObject).addRule(10);
      ((RelativeLayout.LayoutParams)localObject).addRule(14);
    }
  }
  
  private void processClick(String paramString)
  {
    Intent localIntent = new Intent(getContext(), TuneAdActivity.class);
    localIntent.putExtra("INTERSTITIAL", false);
    localIntent.putExtra("REDIRECT_URI", paramString);
    ((Activity)getContext()).startActivity(localIntent);
    notifyOnClick();
    TuneAdClient.logClick(mAdView, mAdParams.toJSON());
  }
  
  public TuneAdView getCurrentAd()
  {
    return mAdView;
  }
  
  public TuneAdParams getParams()
  {
    return mAdParams;
  }
  
  public TuneBannerPosition getPosition()
  {
    return mPosition;
  }
  
  public TuneAdSize getSize()
  {
    return mSize;
  }
  
  protected void onMeasure(int paramInt1, int paramInt2)
  {
    super.onMeasure(paramInt1, paramInt2);
    paramInt1 = getResourcesgetConfigurationorientation;
    if (paramInt1 != mLastOrientation)
    {
      mLastOrientation = paramInt1;
      paramInt2 = mSize.getWidthPixels(mContext);
      paramInt1 = mSize.getHeightPixels(mContext);
      paramInt2 = View.MeasureSpec.makeMeasureSpec(paramInt2, 1073741824);
      paramInt1 = View.MeasureSpec.makeMeasureSpec(paramInt1, 1073741824);
      super.onMeasure(paramInt2, paramInt1);
      measureChildren(paramInt2, paramInt1);
    }
  }
  
  public void setListener(TuneAdListener paramTuneAdListener)
  {
    mListener = paramTuneAdListener;
  }
  
  public void setPosition(TuneBannerPosition paramTuneBannerPosition)
  {
    mPosition = paramTuneBannerPosition;
  }
}

/* Location:
 * Qualified Name:     com.tune.crosspromo.TuneBanner
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */