package com.lyft.android.api.dto;

import com.google.gson.annotations.SerializedName;
import java.util.List;
import java.util.Map;

public class LyftErrorDTO
{
  @SerializedName("cost_token")
  public final String cost_token;
  @SerializedName("error")
  public final String error;
  @SerializedName("error_description")
  public final String error_description;
  @SerializedName("error_detail")
  public final Object error_detail;
  @SerializedName("errors")
  public final List<ValidationErrorDeprecatedDTO> errors;
  @SerializedName("meta")
  public final Map<String, Object> meta;
  @SerializedName("primetime_multiplier")
  public final Double primetime_multiplier;
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("class LyftErrorDTO {\n");
    localStringBuilder.append("  error: ").append(error).append("\n");
    localStringBuilder.append("  error_description: ").append(error_description).append("\n");
    localStringBuilder.append("  error_detail: ").append(error_detail).append("\n");
    localStringBuilder.append("  cost_token: ").append(cost_token).append("\n");
    localStringBuilder.append("  primetime_multiplier: ").append(primetime_multiplier).append("\n");
    localStringBuilder.append("  meta: ").append(meta).append("\n");
    localStringBuilder.append("  errors: ").append(errors).append("\n");
    localStringBuilder.append("}\n");
    return localStringBuilder.toString();
  }
}

/* Location:
 * Qualified Name:     com.lyft.android.api.dto.LyftErrorDTO
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */