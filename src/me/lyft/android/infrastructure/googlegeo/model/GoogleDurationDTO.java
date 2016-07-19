package me.lyft.android.infrastructure.googlegeo.model;

import com.google.gson.annotations.SerializedName;

public class GoogleDurationDTO
{
  @SerializedName("text")
  public final String text;
  @SerializedName("value")
  public final Long value;
  
  public GoogleDurationDTO(String paramString, Long paramLong)
  {
    text = paramString;
    value = paramLong;
  }
}

/* Location:
 * Qualified Name:     me.lyft.android.infrastructure.googlegeo.model.GoogleDurationDTO
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */