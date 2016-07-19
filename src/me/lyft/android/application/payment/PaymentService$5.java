package me.lyft.android.application.payment;

import me.lyft.android.analytics.core.ActionAnalytics;
import me.lyft.android.analytics.utils.AnalyticsUtils;
import me.lyft.android.common.Unit;
import rx.Notification;
import rx.functions.Action1;

class PaymentService$5
  implements Action1<Notification<? super Unit>>
{
  PaymentService$5(PaymentService paramPaymentService, ActionAnalytics paramActionAnalytics) {}
  
  public void call(Notification<? super Unit> paramNotification)
  {
    AnalyticsUtils.trackResult(val$updateCardAnalytics, paramNotification);
  }
}

/* Location:
 * Qualified Name:     me.lyft.android.application.payment.PaymentService.5
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */