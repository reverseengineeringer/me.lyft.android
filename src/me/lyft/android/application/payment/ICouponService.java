package me.lyft.android.application.payment;

import java.util.List;
import me.lyft.android.common.Unit;
import me.lyft.android.domain.invite.CouponInfo;
import me.lyft.android.domain.payment.Credit;
import rx.Observable;

public abstract interface ICouponService
{
  public abstract Observable<Unit> applyCoupon(String paramString);
  
  public abstract Observable<List<Credit>> observeCredits();
  
  public abstract Observable<CouponInfo> observeUserCouponInfo();
  
  public abstract void updateCredits(List<Credit> paramList);
}

/* Location:
 * Qualified Name:     me.lyft.android.application.payment.ICouponService
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */