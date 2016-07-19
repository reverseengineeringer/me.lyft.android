package com.lyft.android.api.dto;

import com.google.gson.annotations.SerializedName;
import java.util.List;

public class CreditDTO
{
  @SerializedName("commuteCredits")
  public final Boolean commuteCredits;
  @SerializedName("creditRestrictions")
  public final List<String> creditRestrictions;
  @SerializedName("description")
  public final String description;
  @SerializedName("id")
  public final String id;
  @SerializedName("invalidRestrictions")
  public final List<String> invalidRestrictions;
  @SerializedName("invalidTitle")
  public final String invalidTitle;
  @SerializedName("label")
  public final String label;
  @SerializedName("title")
  public final String title;
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("class CreditDTO {\n");
    localStringBuilder.append("  id: ").append(id).append("\n");
    localStringBuilder.append("  title: ").append(title).append("\n");
    localStringBuilder.append("  description: ").append(description).append("\n");
    localStringBuilder.append("  label: ").append(label).append("\n");
    localStringBuilder.append("  creditRestrictions: ").append(creditRestrictions).append("\n");
    localStringBuilder.append("  invalidTitle: ").append(invalidTitle).append("\n");
    localStringBuilder.append("  invalidRestrictions: ").append(invalidRestrictions).append("\n");
    localStringBuilder.append("  commuteCredits: ").append(commuteCredits).append("\n");
    localStringBuilder.append("}\n");
    return localStringBuilder.toString();
  }
}

/* Location:
 * Qualified Name:     com.lyft.android.api.dto.CreditDTO
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */