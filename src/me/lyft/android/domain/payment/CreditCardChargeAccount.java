package me.lyft.android.domain.payment;

public class CreditCardChargeAccount
  extends ChargeAccount
{
  private String lastFour;
  private String type;
  
  public String getLastFour()
  {
    return lastFour;
  }
  
  public String getType()
  {
    return type;
  }
  
  public void setLastFour(String paramString)
  {
    lastFour = paramString;
  }
  
  public void setType(String paramString)
  {
    type = paramString;
  }
}

/* Location:
 * Qualified Name:     me.lyft.android.domain.payment.CreditCardChargeAccount
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */