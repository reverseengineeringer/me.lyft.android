package me.lyft.android.infrastructure.settings;

import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.util.Map;
import me.lyft.android.ILyftPreferences;
import me.lyft.android.application.constants.IConstantsProvider;
import me.lyft.android.application.constants.ILeanplumOverrideService;
import me.lyft.android.application.constants.Priority;
import me.lyft.android.common.Objects;
import me.lyft.android.development.IDeveloperTools;
import me.lyft.android.infrastructure.json.IJsonSerializer;

public class AutomationOverrideService
  implements IAutomationOverrideService
{
  private static final String AUTOMATION_LEANPLUM_APP_ID = "app_xOFQA3pjzWepi82JDoQaqyHO7KfqEVmlyHE9yHx9QPI";
  private static final String AUTOMATION_LEANPLUM_KEY = "dev_J2gA2G0kWeoLAO6DkL7S5nBFOHbfvzPw8lZBR3bxEoU";
  private final IConstantsProvider constantsProvider;
  private final IDeveloperTools developerTools;
  private final IJsonSerializer jsonSerializer;
  private final ILeanplumOverrideService leanplumOverrideService;
  private final ILyftPreferences preferences;
  
  public AutomationOverrideService(ILyftPreferences paramILyftPreferences, IConstantsProvider paramIConstantsProvider, ILeanplumOverrideService paramILeanplumOverrideService, IJsonSerializer paramIJsonSerializer, IDeveloperTools paramIDeveloperTools)
  {
    preferences = paramILyftPreferences;
    constantsProvider = paramIConstantsProvider;
    leanplumOverrideService = paramILeanplumOverrideService;
    jsonSerializer = paramIJsonSerializer;
    developerTools = paramIDeveloperTools;
  }
  
  public void updateFromJsonString(String paramString)
  {
    boolean bool = true;
    try
    {
      paramString = URLDecoder.decode(paramString, "UTF-8");
      paramString = (OverridableSettingsDTO)jsonSerializer.fromJson(paramString, OverridableSettingsDTO.class);
      if (paramString == null) {
        return;
      }
    }
    catch (UnsupportedEncodingException paramString)
    {
      return;
    }
    if (paramString.getAutoNavigationEnabled() != null) {
      preferences.setAutoNavigationEnabled(paramString.getAutoNavigationEnabled().booleanValue());
    }
    if (paramString.useAutomationLeanplumEnvironment() != null)
    {
      preferences.setLeanplumAppId("app_xOFQA3pjzWepi82JDoQaqyHO7KfqEVmlyHE9yHx9QPI");
      preferences.setLeanplumKey("dev_J2gA2G0kWeoLAO6DkL7S5nBFOHbfvzPw8lZBR3bxEoU");
    }
    if (paramString.getIncludeMockHttpHeader() != null) {
      preferences.setIncludeMockHttpHeader(paramString.getIncludeMockHttpHeader().booleanValue());
    }
    Object localObject = paramString.getLeanplumValues();
    int i;
    if ((localObject != null) && (!((Map)localObject).isEmpty()))
    {
      i = 1;
      if (i != 0) {
        constantsProvider.update((Map)localObject, Priority.PRIMARY_OVERRIDE);
      }
      localObject = leanplumOverrideService;
      if (i != 0) {
        break label198;
      }
    }
    for (;;)
    {
      ((ILeanplumOverrideService)localObject).setLeanplumEnabled(bool);
      developerTools.setHttpLoggingLevel(((Integer)Objects.firstNonNull(paramString.getHttpLoggingLevel(), Integer.valueOf(0))).intValue());
      return;
      i = 0;
      break;
      label198:
      bool = false;
    }
  }
}

/* Location:
 * Qualified Name:     me.lyft.android.infrastructure.settings.AutomationOverrideService
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */