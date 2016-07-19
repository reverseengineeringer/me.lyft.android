package me.lyft.android.domain.passenger.ride;

import me.lyft.android.domain.payment.Money;

public class TipOption
{
  private final Money money;
  private final String title;
  
  public TipOption(Money paramMoney, String paramString)
  {
    money = paramMoney;
    title = paramString;
  }
  
  public Money getTipMoney()
  {
    return money;
  }
  
  public String getTitle()
  {
    return title;
  }
}

/* Location:
 * Qualified Name:     me.lyft.android.domain.passenger.ride.TipOption
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */