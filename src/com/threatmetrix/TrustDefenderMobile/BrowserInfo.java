package com.threatmetrix.TrustDefenderMobile;

class BrowserInfo
{
  String m_browserPluginCount = "0";
  String m_browserPlugins = null;
  String m_browserPluginsFromJS = null;
  String m_browserPluginsFromJSHash = null;
  String m_browserStringFromJS = null;
  int m_mimeTypeCount = 0;
  String m_mimeTypes = null;
  String m_mimeTypesHash = null;
  
  public String getBrowserPluginCount()
  {
    return m_browserPluginCount;
  }
  
  public String getBrowserPlugins()
  {
    return m_browserPlugins;
  }
  
  public String getBrowserPluginsFromJSHash()
  {
    return m_browserPluginsFromJSHash;
  }
  
  public String getBrowserStringFromJS()
  {
    return m_browserStringFromJS;
  }
  
  public int getMimeTypeCount()
  {
    return m_mimeTypeCount;
  }
  
  public String getMimeTypesHash()
  {
    return m_mimeTypesHash;
  }
}

/* Location:
 * Qualified Name:     com.threatmetrix.TrustDefenderMobile.BrowserInfo
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */