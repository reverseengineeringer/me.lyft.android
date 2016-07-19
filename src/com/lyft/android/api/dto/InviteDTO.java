package com.lyft.android.api.dto;

import com.google.gson.annotations.SerializedName;
import java.util.List;

public class InviteDTO
{
  @SerializedName("email")
  public final String email;
  @SerializedName("firstName")
  public final String firstName;
  @SerializedName("lastName")
  public final String lastName;
  @SerializedName("phoneNumbers")
  public final List<InvitePhoneNumberDTO> phoneNumbers;
  
  public InviteDTO(String paramString1, String paramString2, String paramString3, List<InvitePhoneNumberDTO> paramList)
  {
    firstName = paramString1;
    lastName = paramString2;
    email = paramString3;
    phoneNumbers = paramList;
  }
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("class InviteDTO {\n");
    localStringBuilder.append("  firstName: ").append(firstName).append("\n");
    localStringBuilder.append("  lastName: ").append(lastName).append("\n");
    localStringBuilder.append("  email: ").append(email).append("\n");
    localStringBuilder.append("  phoneNumbers: ").append(phoneNumbers).append("\n");
    localStringBuilder.append("}\n");
    return localStringBuilder.toString();
  }
}

/* Location:
 * Qualified Name:     com.lyft.android.api.dto.InviteDTO
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */