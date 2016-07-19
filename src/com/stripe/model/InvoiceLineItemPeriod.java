package com.stripe.model;

public class InvoiceLineItemPeriod
  extends StripeObject
{
  Long end;
  Long start;
  
  public Long getEnd()
  {
    return end;
  }
  
  public Long getStart()
  {
    return start;
  }
  
  public void setEnd(Long paramLong)
  {
    end = paramLong;
  }
  
  public void setStart(Long paramLong)
  {
    start = paramLong;
  }
}

/* Location:
 * Qualified Name:     com.stripe.model.InvoiceLineItemPeriod
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */