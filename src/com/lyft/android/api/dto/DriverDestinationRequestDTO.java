package com.lyft.android.api.dto;

import com.google.gson.annotations.SerializedName;

public class DriverDestinationRequestDTO
{
  @SerializedName("appInfoRevision")
  public final String appInfoRevision;
  @SerializedName("destination")
  public final DeprecatedPlaceDTO destination;
  
  public DriverDestinationRequestDTO(DeprecatedPlaceDTO paramDeprecatedPlaceDTO, String paramString)
  {
    destination = paramDeprecatedPlaceDTO;
    appInfoRevision = paramString;
  }
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("class DriverDestinationRequestDTO {\n");
    localStringBuilder.append("  destination: ").append(destination).append("\n");
    localStringBuilder.append("  appInfoRevision: ").append(appInfoRevision).append("\n");
    localStringBuilder.append("}\n");
    return localStringBuilder.toString();
  }
}

/* Location:
 * Qualified Name:     com.lyft.android.api.dto.DriverDestinationRequestDTO
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */