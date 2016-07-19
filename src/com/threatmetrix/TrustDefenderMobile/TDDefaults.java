package com.threatmetrix.TrustDefenderMobile;

class TDDefaults
{
  private long m_disabledOptions = 0L;
  private long m_enabledOptions = 0L;
  private String m_sdkVersion = "";
  
  public long getDisabledOptions()
  {
    return m_disabledOptions;
  }
  
  public long getEnabledOptions()
  {
    return m_enabledOptions;
  }
  
  public String getSkVersion()
  {
    return m_sdkVersion;
  }
  
  public void setDisabledOptions(long paramLong)
  {
    m_disabledOptions = paramLong;
  }
  
  public void setEnabledOptions(long paramLong)
  {
    m_enabledOptions = paramLong;
  }
  
  public void setSdkVersion(String paramString)
  {
    m_sdkVersion = paramString;
  }
  
  public boolean shouldUpdate(long paramLong1, long paramLong2, String paramString)
  {
    return (paramLong1 != m_enabledOptions) || (paramLong2 != m_disabledOptions) || (!paramString.equals(m_sdkVersion));
  }
}

/* Location:
 * Qualified Name:     com.threatmetrix.TrustDefenderMobile.TDDefaults
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */