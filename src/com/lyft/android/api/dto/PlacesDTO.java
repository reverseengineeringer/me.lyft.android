package com.lyft.android.api.dto;

import com.google.gson.annotations.SerializedName;
import java.util.List;

public class PlacesDTO
{
  @SerializedName("places")
  public final List<DeprecatedPlaceDTO> places;
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("class PlacesDTO {\n");
    localStringBuilder.append("  places: ").append(places).append("\n");
    localStringBuilder.append("}\n");
    return localStringBuilder.toString();
  }
}

/* Location:
 * Qualified Name:     com.lyft.android.api.dto.PlacesDTO
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */