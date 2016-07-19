package com.lyft.android.api.dto;

import com.google.gson.annotations.SerializedName;
import java.util.List;

public class NewsFeedMessagesDTO
{
  @SerializedName("messages")
  public final List<NewsFeedMessageDTO> messages;
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("class NewsFeedMessagesDTO {\n");
    localStringBuilder.append("  messages: ").append(messages).append("\n");
    localStringBuilder.append("}\n");
    return localStringBuilder.toString();
  }
}

/* Location:
 * Qualified Name:     com.lyft.android.api.dto.NewsFeedMessagesDTO
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */