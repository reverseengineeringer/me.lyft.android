package com.lyft.android.api.dto;

import com.google.gson.annotations.SerializedName;

public class ContributorDTO
{
  @SerializedName("name")
  public final String name;
  @SerializedName("phone")
  public final String phone;
  @SerializedName("status")
  public final String status;
  
  public ContributorDTO(String paramString1, String paramString2, String paramString3)
  {
    phone = paramString1;
    name = paramString2;
    status = paramString3;
  }
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("class ContributorDTO {\n");
    localStringBuilder.append("  phone: ").append(phone).append("\n");
    localStringBuilder.append("  name: ").append(name).append("\n");
    localStringBuilder.append("  status: ").append(status).append("\n");
    localStringBuilder.append("}\n");
    return localStringBuilder.toString();
  }
}

/* Location:
 * Qualified Name:     com.lyft.android.api.dto.ContributorDTO
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */