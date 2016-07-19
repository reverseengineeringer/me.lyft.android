package com.lyft.android.api.dto;

import com.google.gson.annotations.SerializedName;

public class ValidationErrorDeprecatedDTO
{
  @SerializedName("field")
  public final String field;
  @SerializedName("message")
  public final String message;
  @SerializedName("reason")
  public final String reason;
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("class ValidationErrorDeprecatedDTO {\n");
    localStringBuilder.append("  field: ").append(field).append("\n");
    localStringBuilder.append("  reason: ").append(reason).append("\n");
    localStringBuilder.append("  message: ").append(message).append("\n");
    localStringBuilder.append("}\n");
    return localStringBuilder.toString();
  }
}

/* Location:
 * Qualified Name:     com.lyft.android.api.dto.ValidationErrorDeprecatedDTO
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */