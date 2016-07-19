package com.lyft.android.api.dto;

import com.google.gson.annotations.SerializedName;

public class InvitePhoneNumberDTO
{
  @SerializedName("label")
  public final String label;
  @SerializedName("phone")
  public final String phone;
  
  public InvitePhoneNumberDTO(String paramString1, String paramString2)
  {
    phone = paramString1;
    label = paramString2;
  }
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("class InvitePhoneNumberDTO {\n");
    localStringBuilder.append("  phone: ").append(phone).append("\n");
    localStringBuilder.append("  label: ").append(label).append("\n");
    localStringBuilder.append("}\n");
    return localStringBuilder.toString();
  }
}

/* Location:
 * Qualified Name:     com.lyft.android.api.dto.InvitePhoneNumberDTO
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */