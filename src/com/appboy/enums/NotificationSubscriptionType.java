package com.appboy.enums;

import com.appboy.models.IPutIntoJson;

public enum NotificationSubscriptionType
  implements IPutIntoJson<String>
{
  private NotificationSubscriptionType() {}
  
  public final String forJsonPut()
  {
    switch (bo.app.ah.a[ordinal()])
    {
    default: 
      return null;
    case 1: 
      return "unsubscribed";
    case 2: 
      return "subscribed";
    }
    return "opted_in";
  }
}

/* Location:
 * Qualified Name:     com.appboy.enums.NotificationSubscriptionType
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */