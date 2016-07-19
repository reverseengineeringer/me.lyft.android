package me.lyft.android.infrastructure.lyft;

import com.google.gson.annotations.SerializedName;

public class XSession
{
  @SerializedName("f")
  String advertisingId;
  @SerializedName("a")
  String androidId;
  @SerializedName("g")
  String facebookAttributionId;
  @SerializedName("h")
  boolean googleAdTrackingEnable;
  
  public XSession(String paramString1, String paramString2, boolean paramBoolean)
  {
    androidId = paramString1;
    advertisingId = paramString2;
    googleAdTrackingEnable = paramBoolean;
  }
}

/* Location:
 * Qualified Name:     me.lyft.android.infrastructure.lyft.XSession
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */