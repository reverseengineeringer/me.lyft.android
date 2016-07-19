package com.lyft.android.api.dto;

import com.google.gson.annotations.SerializedName;

public class InviteTextDTO
{
  @SerializedName("benefitsUrl")
  public final String benefitsUrl;
  @SerializedName("emailBody")
  public final String emailBody;
  @SerializedName("emailSubject")
  public final String emailSubject;
  @SerializedName("smsBody")
  public final String smsBody;
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("class InviteTextDTO {\n");
    localStringBuilder.append("  emailSubject: ").append(emailSubject).append("\n");
    localStringBuilder.append("  emailBody: ").append(emailBody).append("\n");
    localStringBuilder.append("  smsBody: ").append(smsBody).append("\n");
    localStringBuilder.append("  benefitsUrl: ").append(benefitsUrl).append("\n");
    localStringBuilder.append("}\n");
    return localStringBuilder.toString();
  }
}

/* Location:
 * Qualified Name:     com.lyft.android.api.dto.InviteTextDTO
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */