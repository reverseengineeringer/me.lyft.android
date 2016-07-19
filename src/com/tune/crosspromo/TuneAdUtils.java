package com.tune.crosspromo;

import android.content.Context;
import com.mobileapptracker.MATParameters;
import java.util.HashMap;
import java.util.concurrent.ExecutorService;

public class TuneAdUtils
{
  private static TuneAdUtils INSTANCE;
  protected boolean isInitialized = false;
  private Context mAdContext;
  private ExecutorService mAdThreadExecutor;
  private Context mContext;
  private ExecutorService mLogThreadExecutor;
  private MATParameters mParams;
  private HashMap<String, TuneAdViewSet> mPlacementMap;
  
  public static TuneAdUtils getInstance()
  {
    if (INSTANCE == null) {
      INSTANCE = new TuneAdUtils();
    }
    return INSTANCE;
  }
  
  protected void addViewSet(TuneAdViewSet paramTuneAdViewSet)
  {
    if (!hasViewSet(placement)) {
      mPlacementMap.put(placement, paramTuneAdViewSet);
    }
  }
  
  protected void changeView(String paramString)
  {
    getViewSet(paramString).changeView();
  }
  
  protected Context getAdContext()
  {
    return mAdContext;
  }
  
  protected ExecutorService getAdThread()
  {
    return mAdThreadExecutor;
  }
  
  protected Context getContext()
  {
    return mContext;
  }
  
  protected TuneAdView getCurrentView(String paramString)
  {
    return getViewSet(paramString).getCurrentView();
  }
  
  protected ExecutorService getLogThread()
  {
    return mLogThreadExecutor;
  }
  
  protected MATParameters getParams()
  {
    return mParams;
  }
  
  protected TuneAdView getPreviousView(String paramString)
  {
    return getViewSet(paramString).getPreviousView();
  }
  
  protected TuneAdViewSet getViewSet(String paramString)
  {
    return (TuneAdViewSet)mPlacementMap.get(paramString);
  }
  
  protected boolean hasViewSet(String paramString)
  {
    return mPlacementMap.containsKey(paramString);
  }
  
  protected void setAdContext(Context paramContext)
  {
    mAdContext = paramContext;
  }
}

/* Location:
 * Qualified Name:     com.tune.crosspromo.TuneAdUtils
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */