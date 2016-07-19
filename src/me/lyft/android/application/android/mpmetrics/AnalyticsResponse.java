package me.lyft.android.application.android.mpmetrics;

import com.google.gson.annotations.SerializedName;

public class AnalyticsResponse
{
  @SerializedName("success")
  Integer success;
  
  public Integer getSuccess()
  {
    return success;
  }
}

/* Location:
 * Qualified Name:     me.lyft.android.application.android.mpmetrics.AnalyticsResponse
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */