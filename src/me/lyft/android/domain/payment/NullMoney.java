package me.lyft.android.domain.payment;

public class NullMoney
  extends Money
{
  private static final NullMoney instance = new NullMoney();
  
  private NullMoney()
  {
    amount = Integer.valueOf(0);
    amountCurrency = "NONE";
  }
  
  public static Money getInstance()
  {
    return instance;
  }
  
  public static boolean isNull(Money paramMoney)
  {
    return instance.equals(paramMoney);
  }
}

/* Location:
 * Qualified Name:     me.lyft.android.domain.payment.NullMoney
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */