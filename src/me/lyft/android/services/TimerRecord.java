package me.lyft.android.services;

import com.google.gson.annotations.SerializedName;

public class TimerRecord
{
  @SerializedName("tag")
  String tag;
  @SerializedName("timestamp")
  Long timestamp;
  
  public TimerRecord(String paramString, Long paramLong)
  {
    tag = paramString;
    timestamp = paramLong;
  }
  
  public String getTag()
  {
    return tag;
  }
  
  public Long getTimestamp()
  {
    return timestamp;
  }
}

/* Location:
 * Qualified Name:     me.lyft.android.services.TimerRecord
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */