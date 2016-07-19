package com.appboy.enums;

import com.appboy.models.IPutIntoJson;

public enum SocialNetwork
  implements IPutIntoJson<String>
{
  private SocialNetwork() {}
  
  public final String forJsonPut()
  {
    switch (bo.app.ak.a[ordinal()])
    {
    default: 
      return null;
    case 1: 
      return "fb";
    case 2: 
      return "tw";
    }
    return "g";
  }
}

/* Location:
 * Qualified Name:     com.appboy.enums.SocialNetwork
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */