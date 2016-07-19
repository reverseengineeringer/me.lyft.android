package com.lyft.android.api.dto;

import com.google.gson.annotations.SerializedName;

public class PopupDTO
{
  @SerializedName("backgroundColor")
  public final String backgroundColor;
  @SerializedName("description")
  public final String description;
  @SerializedName("iconFile")
  public final String iconFile;
  @SerializedName("seats")
  public final String seats;
  @SerializedName("showOnFirstSelection")
  public final Boolean showOnFirstSelection;
  @SerializedName("title")
  public final String title;
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("class PopupDTO {\n");
    localStringBuilder.append("  backgroundColor: ").append(backgroundColor).append("\n");
    localStringBuilder.append("  iconFile: ").append(iconFile).append("\n");
    localStringBuilder.append("  title: ").append(title).append("\n");
    localStringBuilder.append("  seats: ").append(seats).append("\n");
    localStringBuilder.append("  description: ").append(description).append("\n");
    localStringBuilder.append("  showOnFirstSelection: ").append(showOnFirstSelection).append("\n");
    localStringBuilder.append("}\n");
    return localStringBuilder.toString();
  }
}

/* Location:
 * Qualified Name:     com.lyft.android.api.dto.PopupDTO
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */