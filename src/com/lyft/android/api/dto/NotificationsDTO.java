package com.lyft.android.api.dto;

import com.google.gson.annotations.SerializedName;
import java.util.List;

public class NotificationsDTO
{
  @SerializedName("notifications")
  public final List<NotificationDTO> notifications;
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("class NotificationsDTO {\n");
    localStringBuilder.append("  notifications: ").append(notifications).append("\n");
    localStringBuilder.append("}\n");
    return localStringBuilder.toString();
  }
}

/* Location:
 * Qualified Name:     com.lyft.android.api.dto.NotificationsDTO
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */