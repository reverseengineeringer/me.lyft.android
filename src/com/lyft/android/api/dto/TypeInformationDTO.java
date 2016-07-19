package com.lyft.android.api.dto;

import com.google.gson.annotations.SerializedName;
import java.util.List;

public class TypeInformationDTO
{
  @SerializedName("description")
  public final String description;
  @SerializedName("glyph")
  public final String glyph;
  @SerializedName("image")
  public final String image;
  @SerializedName("longDescription")
  public final String longDescription;
  @SerializedName("mapMarker")
  public final String mapMarker;
  @SerializedName("matchingStrings")
  public final List<String> matchingStrings;
  @SerializedName("pickupSubtitle")
  public final String pickupSubtitle;
  @SerializedName("shortTitle")
  public final String shortTitle;
  @SerializedName("subtitle")
  public final String subtitle;
  @SerializedName("title")
  public final String title;
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("class TypeInformationDTO {\n");
    localStringBuilder.append("  title: ").append(title).append("\n");
    localStringBuilder.append("  subtitle: ").append(subtitle).append("\n");
    localStringBuilder.append("  description: ").append(description).append("\n");
    localStringBuilder.append("  longDescription: ").append(longDescription).append("\n");
    localStringBuilder.append("  pickupSubtitle: ").append(pickupSubtitle).append("\n");
    localStringBuilder.append("  glyph: ").append(glyph).append("\n");
    localStringBuilder.append("  image: ").append(image).append("\n");
    localStringBuilder.append("  mapMarker: ").append(mapMarker).append("\n");
    localStringBuilder.append("  matchingStrings: ").append(matchingStrings).append("\n");
    localStringBuilder.append("  shortTitle: ").append(shortTitle).append("\n");
    localStringBuilder.append("}\n");
    return localStringBuilder.toString();
  }
}

/* Location:
 * Qualified Name:     com.lyft.android.api.dto.TypeInformationDTO
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */