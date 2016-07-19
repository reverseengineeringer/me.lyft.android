package me.lyft.android.domain.invite;

import me.lyft.android.common.INullable;
import me.lyft.android.domain.payment.Money;
import me.lyft.android.domain.payment.NullMoney;

public class CouponInfo
  implements INullable
{
  private final String code;
  private final Money payout;
  private final CouponPayoutType payoutType;
  
  public CouponInfo(String paramString, Money paramMoney, CouponPayoutType paramCouponPayoutType)
  {
    code = paramString;
    payout = paramMoney;
    payoutType = paramCouponPayoutType;
  }
  
  public static CouponInfo empty()
  {
    return NullCouponInfo.INSTANCE;
  }
  
  public String getCode()
  {
    return code;
  }
  
  public Money getPayout()
  {
    return payout;
  }
  
  public CouponPayoutType getPayoutType()
  {
    return payoutType;
  }
  
  public boolean isNull()
  {
    return false;
  }
  
  private static class NullCouponInfo
    extends CouponInfo
  {
    private static final CouponInfo INSTANCE = new NullCouponInfo();
    
    public NullCouponInfo()
    {
      super(NullMoney.getInstance(), CouponPayoutType.CREDIT);
    }
    
    public boolean isNull()
    {
      return true;
    }
  }
}

/* Location:
 * Qualified Name:     me.lyft.android.domain.invite.CouponInfo
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */