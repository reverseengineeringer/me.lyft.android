package me.lyft.android.domain.invite;

import me.lyft.android.domain.payment.NullMoney;

class CouponInfo$NullCouponInfo
  extends CouponInfo
{
  private static final CouponInfo INSTANCE = new NullCouponInfo();
  
  public CouponInfo$NullCouponInfo()
  {
    super("", NullMoney.getInstance(), CouponPayoutType.CREDIT);
  }
  
  public boolean isNull()
  {
    return true;
  }
}

/* Location:
 * Qualified Name:     me.lyft.android.domain.invite.CouponInfo.NullCouponInfo
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */