package com.lyft.android.api.dto;

import com.google.gson.annotations.SerializedName;
import java.util.List;

public class SplitPaymentDTO
{
  @SerializedName("contributorPhotoUrls")
  public final List<String> contributorPhotoUrls;
  @SerializedName("contributors")
  public final Integer contributors;
  @SerializedName("subtotal")
  public final LineItemDTO subtotal;
  @SerializedName("title")
  public final String title;
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("class SplitPaymentDTO {\n");
    localStringBuilder.append("  title: ").append(title).append("\n");
    localStringBuilder.append("  contributors: ").append(contributors).append("\n");
    localStringBuilder.append("  contributorPhotoUrls: ").append(contributorPhotoUrls).append("\n");
    localStringBuilder.append("  subtotal: ").append(subtotal).append("\n");
    localStringBuilder.append("}\n");
    return localStringBuilder.toString();
  }
}

/* Location:
 * Qualified Name:     com.lyft.android.api.dto.SplitPaymentDTO
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */