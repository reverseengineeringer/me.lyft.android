package me.lyft.android.domain.payment;

public class CouponPayment
  extends Payment
{
  private final String couponId;
  
  public CouponPayment(String paramString, Money paramMoney)
  {
    super(paramMoney);
    couponId = paramString;
  }
  
  public String getCouponId()
  {
    return couponId;
  }
}

/* Location:
 * Qualified Name:     me.lyft.android.domain.payment.CouponPayment
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */