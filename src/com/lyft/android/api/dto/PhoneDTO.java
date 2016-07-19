package com.lyft.android.api.dto;

import com.google.gson.annotations.SerializedName;

public class PhoneDTO
{
  @SerializedName("existingUsersOnly")
  public final Boolean existingUsersOnly;
  @SerializedName("number")
  public final String number;
  @SerializedName("verificationCode")
  public final Integer verificationCode;
  @SerializedName("verificationNeeded")
  public final Boolean verificationNeeded;
  
  public PhoneDTO(String paramString, Integer paramInteger, Boolean paramBoolean1, Boolean paramBoolean2)
  {
    number = paramString;
    verificationCode = paramInteger;
    verificationNeeded = paramBoolean1;
    existingUsersOnly = paramBoolean2;
  }
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("class PhoneDTO {\n");
    localStringBuilder.append("  number: ").append(number).append("\n");
    localStringBuilder.append("  verificationCode: ").append(verificationCode).append("\n");
    localStringBuilder.append("  verificationNeeded: ").append(verificationNeeded).append("\n");
    localStringBuilder.append("  existingUsersOnly: ").append(existingUsersOnly).append("\n");
    localStringBuilder.append("}\n");
    return localStringBuilder.toString();
  }
}

/* Location:
 * Qualified Name:     com.lyft.android.api.dto.PhoneDTO
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */