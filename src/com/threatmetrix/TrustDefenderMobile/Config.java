package com.threatmetrix.TrustDefenderMobile;

import android.content.Context;

public class Config
  extends BaseConfig
{
  private int m_accuracy = 1;
  private String m_apiKey = null;
  private Context m_context = null;
  private boolean m_disableAppHash = false;
  private boolean m_disableInitPackageScan = false;
  private boolean m_disableProfilePackageScan = false;
  private boolean m_disableWebView = false;
  private String m_fp_server = "h.online-metrix.net";
  private long m_highPowerUpdateTime = 3600000L;
  private boolean m_initPackageScanInterruptible = true;
  private int m_initPackageScanLimit = 0;
  private int m_initPackageScanTimeLimit = 30000;
  private long m_lowPowerUpdateTime = 900000L;
  private EndNotifierBase m_notifier = null;
  private int m_options = 64766;
  private int m_packageScanLimit = 0;
  private int m_packageScanTimeLimit = 10000;
  private boolean m_registerForLocationServices = false;
  private int m_timeout = 30;
  private boolean m_useOkHttp = true;
  
  String getApiKey()
  {
    return m_apiKey;
  }
  
  Context getContext()
  {
    return m_context;
  }
  
  boolean getDisableInitPackageScan()
  {
    return m_disableInitPackageScan;
  }
  
  boolean getDisableProfilePackageScan()
  {
    return m_disableProfilePackageScan;
  }
  
  EndNotifierBase getEndNotifier()
  {
    return m_notifier;
  }
  
  String getFPServer()
  {
    return m_fp_server;
  }
  
  long getHighPowerUpdateTime()
  {
    return m_highPowerUpdateTime;
  }
  
  int getInitPackageScanLimit()
  {
    return m_initPackageScanLimit;
  }
  
  int getInitPackageScanTimeLimit()
  {
    return m_initPackageScanTimeLimit;
  }
  
  int getLocationAccuracy()
  {
    return m_accuracy;
  }
  
  long getLowPowerUpdateTime()
  {
    return m_lowPowerUpdateTime;
  }
  
  int getOptions()
  {
    int j = m_options;
    int i = j;
    if (m_disableWebView) {
      i = j & 0xFFFFFFD9;
    }
    j = i;
    if (m_disableAppHash) {
      j = i & 0xCFFF;
    }
    return j;
  }
  
  int getPackageScanLimit()
  {
    return m_packageScanLimit;
  }
  
  int getPackageScanTimeLimit()
  {
    return m_packageScanTimeLimit;
  }
  
  int getTimeout()
  {
    return m_timeout;
  }
  
  boolean getUseOkHttp()
  {
    return m_useOkHttp;
  }
  
  boolean isInitPackageScanInterruptible()
  {
    return m_initPackageScanInterruptible;
  }
  
  boolean isRegisterForLocationServices()
  {
    return m_registerForLocationServices;
  }
  
  public Config setContext(Context paramContext)
  {
    m_context = paramContext;
    return this;
  }
  
  public Config setEndNotifier(EndNotifierBase paramEndNotifierBase)
  {
    m_notifier = paramEndNotifierBase;
    return this;
  }
  
  public Config setRegisterForLocationServices(boolean paramBoolean)
  {
    m_registerForLocationServices = paramBoolean;
    return this;
  }
}

/* Location:
 * Qualified Name:     com.threatmetrix.TrustDefenderMobile.Config
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */