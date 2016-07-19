package com.stripe.model;

public class NextRecurringCharge
  extends StripeObject
{
  Integer amount;
  String date;
  
  public Integer getAmount()
  {
    return amount;
  }
  
  public String getDate()
  {
    return date;
  }
  
  public void setAmount(Integer paramInteger)
  {
    amount = paramInteger;
  }
  
  public void setDate(String paramString)
  {
    date = paramString;
  }
}

/* Location:
 * Qualified Name:     com.stripe.model.NextRecurringCharge
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */