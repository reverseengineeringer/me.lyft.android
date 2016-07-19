package com.lyft.android.api.dto;

import com.google.gson.annotations.SerializedName;

public class UserOrganizationDTO
{
  @SerializedName("inviteText")
  public final InviteTextDTO inviteText;
  @SerializedName("organization")
  public final OrganizationDTO organization;
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("class UserOrganizationDTO {\n");
    localStringBuilder.append("  organization: ").append(organization).append("\n");
    localStringBuilder.append("  inviteText: ").append(inviteText).append("\n");
    localStringBuilder.append("}\n");
    return localStringBuilder.toString();
  }
}

/* Location:
 * Qualified Name:     com.lyft.android.api.dto.UserOrganizationDTO
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */