package me.lyft.android.ui.passenger;

import com.google.gson.annotations.SerializedName;

public class MatchingStartTime
{
  @SerializedName("rideId")
  String rideId;
  @SerializedName("startTime")
  long startTime;
  
  public MatchingStartTime(String paramString)
  {
    rideId = paramString;
    startTime = System.currentTimeMillis();
  }
  
  public String getRideId()
  {
    return rideId;
  }
  
  public long getStartTime()
  {
    return startTime;
  }
}

/* Location:
 * Qualified Name:     me.lyft.android.ui.passenger.MatchingStartTime
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */