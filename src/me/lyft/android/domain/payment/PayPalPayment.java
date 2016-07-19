package me.lyft.android.domain.payment;

public class PayPalPayment
  extends ChargeAccountPayment
{
  private String chargeToken;
  
  public PayPalPayment(String paramString, Money paramMoney)
  {
    super(paramString, paramMoney);
  }
  
  public String getChargeToken()
  {
    return chargeToken;
  }
  
  public void setChargeToken(String paramString)
  {
    chargeToken = paramString;
  }
}

/* Location:
 * Qualified Name:     me.lyft.android.domain.payment.PayPalPayment
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */