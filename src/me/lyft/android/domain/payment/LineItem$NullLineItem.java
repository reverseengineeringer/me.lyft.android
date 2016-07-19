package me.lyft.android.domain.payment;

public class LineItem$NullLineItem
  extends LineItem
{
  private static final LineItem INSTANCE = new NullLineItem();
  
  public LineItem$NullLineItem()
  {
    super(NullMoney.getInstance(), "");
  }
  
  public boolean isNull()
  {
    return true;
  }
}

/* Location:
 * Qualified Name:     me.lyft.android.domain.payment.LineItem.NullLineItem
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */