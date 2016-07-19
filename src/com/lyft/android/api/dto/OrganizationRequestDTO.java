package com.lyft.android.api.dto;

import com.google.gson.annotations.SerializedName;

public class OrganizationRequestDTO
{
  @SerializedName("email")
  public final String email;
  @SerializedName("source")
  public final String source;
  
  public OrganizationRequestDTO(String paramString1, String paramString2)
  {
    email = paramString1;
    source = paramString2;
  }
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("class OrganizationRequestDTO {\n");
    localStringBuilder.append("  email: ").append(email).append("\n");
    localStringBuilder.append("  source: ").append(source).append("\n");
    localStringBuilder.append("}\n");
    return localStringBuilder.toString();
  }
}

/* Location:
 * Qualified Name:     com.lyft.android.api.dto.OrganizationRequestDTO
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */