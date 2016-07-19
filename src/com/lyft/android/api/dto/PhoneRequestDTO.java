package com.lyft.android.api.dto;

import com.google.gson.annotations.SerializedName;

public class PhoneRequestDTO
{
  @SerializedName("phone")
  public final PhoneDTO phone;
  
  public PhoneRequestDTO(PhoneDTO paramPhoneDTO)
  {
    phone = paramPhoneDTO;
  }
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("class PhoneRequestDTO {\n");
    localStringBuilder.append("  phone: ").append(phone).append("\n");
    localStringBuilder.append("}\n");
    return localStringBuilder.toString();
  }
}

/* Location:
 * Qualified Name:     com.lyft.android.api.dto.PhoneRequestDTO
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */