package com.lyft.android.api.dto;

import com.google.gson.annotations.SerializedName;
import java.util.List;

public class InviteRequestDTO
{
  @SerializedName("invites")
  public final List<InviteDTO> invites;
  @SerializedName("type")
  public final String type;
  
  public InviteRequestDTO(String paramString, List<InviteDTO> paramList)
  {
    type = paramString;
    invites = paramList;
  }
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("class InviteRequestDTO {\n");
    localStringBuilder.append("  type: ").append(type).append("\n");
    localStringBuilder.append("  invites: ").append(invites).append("\n");
    localStringBuilder.append("}\n");
    return localStringBuilder.toString();
  }
}

/* Location:
 * Qualified Name:     com.lyft.android.api.dto.InviteRequestDTO
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */