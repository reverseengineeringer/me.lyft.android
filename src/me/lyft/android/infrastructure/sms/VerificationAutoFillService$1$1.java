package me.lyft.android.infrastructure.sms;

import rx.Subscriber;
import rx.functions.Action1;

class VerificationAutoFillService$1$1
  implements Action1<String>
{
  VerificationAutoFillService$1$1(VerificationAutoFillService.1 param1, Subscriber paramSubscriber) {}
  
  public void call(String paramString)
  {
    val$subscriber.onNext(paramString);
  }
}

/* Location:
 * Qualified Name:     me.lyft.android.infrastructure.sms.VerificationAutoFillService.1.1
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */