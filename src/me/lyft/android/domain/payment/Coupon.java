package me.lyft.android.domain.payment;

import me.lyft.android.common.Objects;

public class Coupon
{
  private final String id;
  private final String lineItemTitle;
  private final Money money;
  
  public Coupon(String paramString1, Money paramMoney, String paramString2)
  {
    id = paramString1;
    money = paramMoney;
    lineItemTitle = paramString2;
  }
  
  public String getId()
  {
    return (String)Objects.firstNonNull(id, "");
  }
  
  public String getLineItemTitle()
  {
    return (String)Objects.firstNonNull(lineItemTitle, "");
  }
  
  public Money getMoney()
  {
    return (Money)Objects.firstNonNull(money, NullMoney.getInstance());
  }
}

/* Location:
 * Qualified Name:     me.lyft.android.domain.payment.Coupon
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */