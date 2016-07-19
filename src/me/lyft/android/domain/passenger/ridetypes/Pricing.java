package me.lyft.android.domain.passenger.ridetypes;

import me.lyft.android.common.INullable;

public class Pricing
  implements INullable
{
  private final Integer dynamicPricing;
  private final String minimum;
  private final String perMile;
  private final String perMinute;
  private final String pickup;
  
  public Pricing(Integer paramInteger, String paramString1, String paramString2, String paramString3, String paramString4)
  {
    dynamicPricing = paramInteger;
    minimum = paramString1;
    pickup = paramString2;
    perMile = paramString3;
    perMinute = paramString4;
  }
  
  public static Pricing empty()
  {
    return NullPricing.getInstance();
  }
  
  public Integer getDynamicPricing()
  {
    return dynamicPricing;
  }
  
  public String getMinimum()
  {
    return minimum;
  }
  
  public String getPerMile()
  {
    return perMile;
  }
  
  public String getPerMinute()
  {
    return perMinute;
  }
  
  public String getPickup()
  {
    return pickup;
  }
  
  public boolean hasDynamicPricing()
  {
    return dynamicPricing.intValue() > 0;
  }
  
  public boolean isNull()
  {
    return false;
  }
  
  static class NullPricing
    extends Pricing
  {
    private static final Pricing INSTANCE = new NullPricing();
    
    NullPricing()
    {
      super("", "", "", "");
    }
    
    static Pricing getInstance()
    {
      return INSTANCE;
    }
    
    public boolean isNull()
    {
      return true;
    }
  }
}

/* Location:
 * Qualified Name:     me.lyft.android.domain.passenger.ridetypes.Pricing
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */