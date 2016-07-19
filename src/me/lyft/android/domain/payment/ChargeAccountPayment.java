package me.lyft.android.domain.payment;

public class ChargeAccountPayment
  extends Payment
{
  private final String chargeAccountId;
  
  public ChargeAccountPayment(String paramString, Money paramMoney)
  {
    super(paramMoney);
    chargeAccountId = paramString;
  }
  
  public final String getChargeAccountId()
  {
    return chargeAccountId;
  }
}

/* Location:
 * Qualified Name:     me.lyft.android.domain.payment.ChargeAccountPayment
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */