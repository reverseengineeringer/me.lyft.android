package me.lyft.android.domain.geo;

import me.lyft.android.common.Strings;

public class City
{
  private final String city;
  private final String state;
  
  public City(String paramString1, String paramString2)
  {
    city = Strings.nullToEmpty(paramString1);
    state = Strings.nullToEmpty(paramString2);
  }
  
  public String getCity()
  {
    return city;
  }
  
  public String getState()
  {
    return state;
  }
}

/* Location:
 * Qualified Name:     me.lyft.android.domain.geo.City
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */