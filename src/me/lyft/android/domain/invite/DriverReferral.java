package me.lyft.android.domain.invite;

import me.lyft.android.common.INullable;
import me.lyft.android.domain.payment.Money;
import me.lyft.android.domain.payment.NullMoney;

public class DriverReferral
  implements INullable
{
  private final int daysUntilExpiration;
  private final Money payout;
  private final Money refereePayout;
  private final String regionLabel;
  private final int requiredRidesCount;
  
  public DriverReferral(Money paramMoney1, Money paramMoney2, int paramInt1, int paramInt2, String paramString)
  {
    payout = paramMoney1;
    refereePayout = paramMoney2;
    requiredRidesCount = paramInt1;
    daysUntilExpiration = paramInt2;
    regionLabel = paramString;
  }
  
  public static DriverReferral empty()
  {
    return NullDriverReferral.getInstance();
  }
  
  public int getDaysUntilExpiration()
  {
    return daysUntilExpiration;
  }
  
  public Money getPayout()
  {
    return payout;
  }
  
  public Money getRefereePayout()
  {
    return refereePayout;
  }
  
  public String getRegionLabel()
  {
    return regionLabel;
  }
  
  public int getRequiredRidesCount()
  {
    return requiredRidesCount;
  }
  
  public boolean isNull()
  {
    return false;
  }
  
  static class NullDriverReferral
    extends DriverReferral
  {
    private static DriverReferral INSTANCE = new NullDriverReferral();
    
    private NullDriverReferral()
    {
      super(NullMoney.getInstance(), 0, 0, "");
    }
    
    public static DriverReferral getInstance()
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
 * Qualified Name:     me.lyft.android.domain.invite.DriverReferral
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */