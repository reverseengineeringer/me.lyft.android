package com.mobileapptracker;

import android.content.Context;

class MATDeferredDplinkr
{
  private static volatile MATDeferredDplinkr dplinkr;
  private String advertiserId = null;
  private String androidId = null;
  private String conversionKey = null;
  private boolean enabled;
  private String googleAdvertisingId = null;
  private int isLATEnabled = 0;
  private MATDeeplinkListener listener = null;
  private String packageName = null;
  private String userAgent = null;
  
  public static MATDeferredDplinkr initialize(String paramString1, String paramString2, String paramString3)
  {
    try
    {
      dplinkr = new MATDeferredDplinkr();
      dplinkradvertiserId = paramString1;
      dplinkrconversionKey = paramString2;
      dplinkrpackageName = paramString3;
      paramString1 = dplinkr;
      return paramString1;
    }
    finally
    {
      paramString1 = finally;
      throw paramString1;
    }
  }
  
  public void checkForDeferredDeeplink(Context paramContext, final MATUrlRequester paramMATUrlRequester)
  {
    new Thread(new Runnable()
    {
      public void run()
      {
        if (((dplinkradvertiserId == null) || (dplinkrconversionKey == null) || (dplinkrpackageName == null)) && (listener != null)) {
          listener.didFailDeeplink("Advertiser ID, conversion key, or package name not set");
        }
        if ((dplinkrgoogleAdvertisingId == null) && (dplinkrandroidId == null) && (listener != null)) {
          listener.didFailDeeplink("No device identifiers collected");
        }
        paramMATUrlRequester.requestDeeplink(MATDeferredDplinkr.dplinkr);
      }
    }).start();
  }
  
  public String getAdvertiserId()
  {
    return dplinkradvertiserId;
  }
  
  public String getAndroidId()
  {
    return dplinkrandroidId;
  }
  
  public String getConversionKey()
  {
    return dplinkrconversionKey;
  }
  
  public int getGoogleAdTrackingLimited()
  {
    return dplinkrisLATEnabled;
  }
  
  public String getGoogleAdvertisingId()
  {
    return dplinkrgoogleAdvertisingId;
  }
  
  public MATDeeplinkListener getListener()
  {
    return dplinkrlistener;
  }
  
  public String getPackageName()
  {
    return dplinkrpackageName;
  }
  
  public String getUserAgent()
  {
    return dplinkruserAgent;
  }
  
  public boolean isEnabled()
  {
    return enabled;
  }
  
  public void setAndroidId(String paramString)
  {
    dplinkrandroidId = paramString;
  }
  
  public void setGoogleAdvertisingId(String paramString, int paramInt)
  {
    dplinkrgoogleAdvertisingId = paramString;
    dplinkrisLATEnabled = paramInt;
  }
  
  public void setPackageName(String paramString)
  {
    dplinkrpackageName = paramString;
  }
  
  public void setUserAgent(String paramString)
  {
    dplinkruserAgent = paramString;
  }
}

/* Location:
 * Qualified Name:     com.mobileapptracker.MATDeferredDplinkr
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */