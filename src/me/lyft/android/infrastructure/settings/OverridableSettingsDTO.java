package me.lyft.android.infrastructure.settings;

import java.util.Map;

public class OverridableSettingsDTO
{
  private final Boolean autoNavOn;
  private final Integer httpLoggingLevel;
  private final Boolean lpEnv;
  private final Map<String, Object> lpValues;
  private final Boolean useMockHeader;
  
  public OverridableSettingsDTO(Boolean paramBoolean1, Boolean paramBoolean2, Map<String, Object> paramMap, Boolean paramBoolean3, Integer paramInteger)
  {
    autoNavOn = paramBoolean1;
    lpEnv = paramBoolean2;
    lpValues = paramMap;
    useMockHeader = paramBoolean3;
    httpLoggingLevel = paramInteger;
  }
  
  public Boolean getAutoNavigationEnabled()
  {
    return autoNavOn;
  }
  
  public Integer getHttpLoggingLevel()
  {
    return httpLoggingLevel;
  }
  
  public Boolean getIncludeMockHttpHeader()
  {
    return useMockHeader;
  }
  
  public Map<String, Object> getLeanplumValues()
  {
    return lpValues;
  }
  
  public Boolean useAutomationLeanplumEnvironment()
  {
    return lpEnv;
  }
}

/* Location:
 * Qualified Name:     me.lyft.android.infrastructure.settings.OverridableSettingsDTO
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */