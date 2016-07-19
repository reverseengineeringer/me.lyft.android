package me.lyft.android.domain.payment;

public class PayPalChargeAccount
  extends ChargeAccount
{
  private String email;
  
  public String getEmail()
  {
    return email;
  }
  
  public void setEmail(String paramString)
  {
    email = paramString;
  }
}

/* Location:
 * Qualified Name:     me.lyft.android.domain.payment.PayPalChargeAccount
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */