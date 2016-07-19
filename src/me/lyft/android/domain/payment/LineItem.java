package me.lyft.android.domain.payment;

import me.lyft.android.common.INullable;

public class LineItem
  implements INullable
{
  Money amount;
  String title;
  
  public LineItem(Money paramMoney, String paramString)
  {
    amount = paramMoney;
    title = paramString;
  }
  
  public static LineItem empty()
  {
    return NullLineItem.INSTANCE;
  }
  
  public Money getAmount()
  {
    return amount;
  }
  
  public String getTitle()
  {
    return title;
  }
  
  public boolean isNull()
  {
    return false;
  }
  
  public static class NullLineItem
    extends LineItem
  {
    private static final LineItem INSTANCE = new NullLineItem();
    
    public NullLineItem()
    {
      super("");
    }
    
    public boolean isNull()
    {
      return true;
    }
  }
}

/* Location:
 * Qualified Name:     me.lyft.android.domain.payment.LineItem
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */