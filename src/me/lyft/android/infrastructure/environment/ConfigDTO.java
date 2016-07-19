package me.lyft.android.infrastructure.environment;

import com.google.gson.annotations.SerializedName;

public class ConfigDTO
{
  private static final String PRODUCTION = "production";
  @SerializedName("analyticsUrl")
  private String analyticsUrl;
  @SerializedName("displayName")
  private String displayName;
  @SerializedName("facebookAppId")
  private String facebookAppId;
  @SerializedName("stripeKey")
  private String stripeKey;
  @SerializedName("url")
  private String url;
  @SerializedName("webUrl")
  private String webUrl;
  
  public String getAnalyticsUrl()
  {
    return analyticsUrl;
  }
  
  public String getDisplayName()
  {
    return displayName;
  }
  
  public String getFacebookAppId()
  {
    return facebookAppId;
  }
  
  public String getStripeKey()
  {
    return stripeKey;
  }
  
  public String getUrl()
  {
    return url;
  }
  
  public String getWebUrl()
  {
    return webUrl;
  }
  
  public boolean isProduction()
  {
    return "production".equalsIgnoreCase(displayName);
  }
}

/* Location:
 * Qualified Name:     me.lyft.android.infrastructure.environment.ConfigDTO
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */