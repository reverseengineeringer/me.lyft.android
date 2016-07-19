package me.lyft.android.infrastructure.googlegeo.model;

import com.google.gson.annotations.SerializedName;

public class DistanceMatrixElementDTO
{
  private static final String STATUS_OK = "OK";
  @SerializedName("duration")
  public final GoogleDurationDTO duration;
  @SerializedName("status")
  public final String status;
  
  public DistanceMatrixElementDTO(String paramString, GoogleDurationDTO paramGoogleDurationDTO)
  {
    status = paramString;
    duration = paramGoogleDurationDTO;
  }
  
  public boolean isOk()
  {
    return "OK".equalsIgnoreCase(status);
  }
}

/* Location:
 * Qualified Name:     me.lyft.android.infrastructure.googlegeo.model.DistanceMatrixElementDTO
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */