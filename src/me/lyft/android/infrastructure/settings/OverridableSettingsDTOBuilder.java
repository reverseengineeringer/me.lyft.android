package me.lyft.android.infrastructure.settings;

import java.util.HashMap;
import java.util.Map;

public class OverridableSettingsDTOBuilder
{
  private Boolean autoNavigationEnabled;
  private Boolean automationLeanplumEnv;
  private Integer httpLoggingLevel;
  private Boolean includeMockHttpHeader;
  private Map<String, Object> leanplumValues;
  
  public OverridableSettingsDTO build()
  {
    return new OverridableSettingsDTO(autoNavigationEnabled, automationLeanplumEnv, leanplumValues, includeMockHttpHeader, httpLoggingLevel);
  }
  
  public OverridableSettingsDTOBuilder withAutoNavigationEnabled(Boolean paramBoolean)
  {
    autoNavigationEnabled = paramBoolean;
    return this;
  }
  
  public OverridableSettingsDTOBuilder withAutomationLeanplumEnvironment(boolean paramBoolean)
  {
    automationLeanplumEnv = Boolean.valueOf(paramBoolean);
    return this;
  }
  
  public OverridableSettingsDTOBuilder withHttpLoggingLevel(Integer paramInteger)
  {
    httpLoggingLevel = paramInteger;
    return this;
  }
  
  public OverridableSettingsDTOBuilder withIncludeMockHttpHeader(Boolean paramBoolean)
  {
    includeMockHttpHeader = paramBoolean;
    return this;
  }
  
  public OverridableSettingsDTOBuilder withLeanplumValue(String paramString, Object paramObject)
  {
    if (leanplumValues == null) {
      leanplumValues = new HashMap();
    }
    leanplumValues.put(paramString, paramObject);
    return this;
  }
}

/* Location:
 * Qualified Name:     me.lyft.android.infrastructure.settings.OverridableSettingsDTOBuilder
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */