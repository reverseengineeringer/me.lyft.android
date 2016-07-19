package me.lyft.android.domain.geo;

public class Address
{
  private final String routableAddress;
  private final String shortAddress;
  
  public Address(String paramString1, String paramString2)
  {
    shortAddress = paramString1;
    routableAddress = paramString2;
  }
  
  public String getRoutableAddress()
  {
    return routableAddress;
  }
  
  public String getShortAddress()
  {
    return shortAddress;
  }
}

/* Location:
 * Qualified Name:     me.lyft.android.domain.geo.Address
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */