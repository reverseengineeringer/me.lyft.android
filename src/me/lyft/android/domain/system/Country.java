package me.lyft.android.domain.system;

public class Country
{
  private String countryCode;
  private String countryName;
  private boolean isTopCountry;
  
  public Country(String paramString1, String paramString2, boolean paramBoolean)
  {
    countryCode = paramString1;
    countryName = paramString2;
    isTopCountry = paramBoolean;
  }
  
  public String getCountryCode()
  {
    return countryCode;
  }
  
  public String getCountryName()
  {
    return countryName;
  }
  
  public boolean isTopCountry()
  {
    return isTopCountry;
  }
}

/* Location:
 * Qualified Name:     me.lyft.android.domain.system.Country
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */