package io.fabric.sdk.android.services.settings;

public class PromptSettingsData
{
  public final String alwaysSendButtonTitle;
  public final String cancelButtonTitle;
  public final String message;
  public final String sendButtonTitle;
  public final boolean showAlwaysSendButton;
  public final boolean showCancelButton;
  public final String title;
  
  public PromptSettingsData(String paramString1, String paramString2, String paramString3, boolean paramBoolean1, String paramString4, boolean paramBoolean2, String paramString5)
  {
    title = paramString1;
    message = paramString2;
    sendButtonTitle = paramString3;
    showCancelButton = paramBoolean1;
    cancelButtonTitle = paramString4;
    showAlwaysSendButton = paramBoolean2;
    alwaysSendButtonTitle = paramString5;
  }
}

/* Location:
 * Qualified Name:     io.fabric.sdk.android.services.settings.PromptSettingsData
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */