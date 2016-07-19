package me.lyft.android.domain.passenger.ridetypes;

class Pricing$NullPricing
  extends Pricing
{
  private static final Pricing INSTANCE = new NullPricing();
  
  Pricing$NullPricing()
  {
    super(Integer.valueOf(0), "", "", "", "");
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

/* Location:
 * Qualified Name:     me.lyft.android.domain.passenger.ridetypes.Pricing.NullPricing
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */