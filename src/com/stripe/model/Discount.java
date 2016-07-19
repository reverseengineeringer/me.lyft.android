package com.stripe.model;

public class Discount
  extends StripeObject
{
  Coupon coupon;
  String customer;
  Long end;
  String id;
  Long start;
  String subscription;
  
  public Coupon getCoupon()
  {
    return coupon;
  }
  
  public String getCustomer()
  {
    return customer;
  }
  
  public Long getEnd()
  {
    return end;
  }
  
  public String getId()
  {
    return id;
  }
  
  public Long getStart()
  {
    return start;
  }
  
  public String getSubscription()
  {
    return subscription;
  }
  
  public void setCoupon(Coupon paramCoupon)
  {
    coupon = paramCoupon;
  }
  
  public void setCustomer(String paramString)
  {
    customer = paramString;
  }
  
  public void setEnd(Long paramLong)
  {
    end = paramLong;
  }
  
  public void setId(String paramString)
  {
    id = paramString;
  }
  
  public void setStart(Long paramLong)
  {
    start = paramLong;
  }
  
  public void setSubscription(String paramString)
  {
    subscription = paramString;
  }
}

/* Location:
 * Qualified Name:     com.stripe.model.Discount
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */