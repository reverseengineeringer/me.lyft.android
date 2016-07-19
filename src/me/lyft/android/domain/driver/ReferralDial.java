package me.lyft.android.domain.driver;

import me.lyft.android.domain.payment.Money;

public class ReferralDial
  extends Dial
{
  final Money payout;
  
  public ReferralDial(Dial.Type paramType, String paramString1, String paramString2, Integer paramInteger1, Integer paramInteger2, Boolean paramBoolean, Money paramMoney)
  {
    super(paramType, paramString1, paramString2, paramInteger1, paramInteger2, paramBoolean);
    payout = paramMoney;
  }
  
  public Money getPayout()
  {
    return payout;
  }
}

/* Location:
 * Qualified Name:     me.lyft.android.domain.driver.ReferralDial
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */