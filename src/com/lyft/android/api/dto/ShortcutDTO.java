package com.lyft.android.api.dto;

import com.google.gson.annotations.SerializedName;

public class ShortcutDTO
{
  @SerializedName("label")
  public final String label;
  @SerializedName("place")
  public final DeprecatedPlaceDTO place;
  
  public ShortcutDTO(String paramString, DeprecatedPlaceDTO paramDeprecatedPlaceDTO)
  {
    label = paramString;
    place = paramDeprecatedPlaceDTO;
  }
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("class ShortcutDTO {\n");
    localStringBuilder.append("  label: ").append(label).append("\n");
    localStringBuilder.append("  place: ").append(place).append("\n");
    localStringBuilder.append("}\n");
    return localStringBuilder.toString();
  }
}

/* Location:
 * Qualified Name:     com.lyft.android.api.dto.ShortcutDTO
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */