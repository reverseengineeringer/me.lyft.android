package com.appboy.enums;

import com.appboy.models.IPutIntoJson;

public enum Gender
  implements IPutIntoJson<String>
{
  private Gender() {}
  
  public final String forJsonPut()
  {
    switch (bo.app.ae.a[ordinal()])
    {
    default: 
      return null;
    case 1: 
      return "m";
    }
    return "f";
  }
}

/* Location:
 * Qualified Name:     com.appboy.enums.Gender
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */