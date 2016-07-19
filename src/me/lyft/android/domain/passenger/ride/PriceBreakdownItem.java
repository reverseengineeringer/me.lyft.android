package me.lyft.android.domain.passenger.ride;

import me.lyft.android.domain.payment.Money;

public class PriceBreakdownItem
{
  private Money money;
  private String title;
  
  public PriceBreakdownItem(String paramString, Money paramMoney)
  {
    title = paramString;
    money = paramMoney;
  }
  
  public Money getMoney()
  {
    return money;
  }
  
  public String getTitle()
  {
    return title;
  }
}

/* Location:
 * Qualified Name:     me.lyft.android.domain.passenger.ride.PriceBreakdownItem
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */