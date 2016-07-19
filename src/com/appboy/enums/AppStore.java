package com.appboy.enums;

import com.appboy.models.IPutIntoJson;
import java.util.Locale;

public enum AppStore
  implements IPutIntoJson<String>
{
  private AppStore() {}
  
  public static String serverStringToEnumString(String paramString)
  {
    return paramString.replace(" ", "_").toUpperCase(Locale.US);
  }
  
  public final String forJsonPut()
  {
    switch (bo.app.z.a[ordinal()])
    {
    default: 
      return null;
    case 1: 
      return "Google Play Store";
    }
    return "Kindle Store";
  }
}

/* Location:
 * Qualified Name:     com.appboy.enums.AppStore
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */