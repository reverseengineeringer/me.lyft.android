package me.lyft.android.notifications;

import com.google.gson.annotations.SerializedName;

public class QuickAction
{
  @SerializedName("button_text")
  private String buttonText;
  @SerializedName("deep_link")
  private String deeplink;
  @SerializedName("url_path")
  private String urlPath;
  
  public String getButtonText()
  {
    return buttonText;
  }
  
  public String getDeeplink()
  {
    return deeplink;
  }
  
  public String getUrlPath()
  {
    return urlPath;
  }
}

/* Location:
 * Qualified Name:     me.lyft.android.notifications.QuickAction
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */