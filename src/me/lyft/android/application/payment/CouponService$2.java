package me.lyft.android.application.payment;

import com.lyft.android.api.dto.UniversalDTO;
import me.lyft.android.analytics.core.ActionAnalytics;
import rx.functions.Action1;

class CouponService$2
  implements Action1<UniversalDTO>
{
  CouponService$2(CouponService paramCouponService, ActionAnalytics paramActionAnalytics) {}
  
  public void call(UniversalDTO paramUniversalDTO)
  {
    val$couponAnalytics.trackSuccess();
  }
}

/* Location:
 * Qualified Name:     me.lyft.android.application.payment.CouponService.2
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */