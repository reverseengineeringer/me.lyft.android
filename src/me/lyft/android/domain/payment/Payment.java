package me.lyft.android.domain.payment;

public abstract class Payment
{
  private final Money money;
  
  protected Payment(Money paramMoney)
  {
    money = paramMoney;
  }
  
  public Money getMoney()
  {
    return money;
  }
}

/* Location:
 * Qualified Name:     me.lyft.android.domain.payment.Payment
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */