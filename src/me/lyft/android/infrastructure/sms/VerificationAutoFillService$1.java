package me.lyft.android.infrastructure.sms;

import android.content.Context;
import android.content.IntentFilter;
import rx.Observable.OnSubscribe;
import rx.Subscriber;
import rx.functions.Action0;
import rx.functions.Action1;
import rx.subscriptions.Subscriptions;

class VerificationAutoFillService$1
  implements Observable.OnSubscribe<String>
{
  VerificationAutoFillService$1(VerificationAutoFillService paramVerificationAutoFillService, Context paramContext) {}
  
  public void call(final Subscriber<? super String> paramSubscriber)
  {
    final VerificationAutoFillService.SmsBroadcastReceiver localSmsBroadcastReceiver = new VerificationAutoFillService.SmsBroadcastReceiver(VerificationAutoFillService.access$000(this$0), VerificationAutoFillService.access$100(this$0), new Action1()
    {
      public void call(String paramAnonymousString)
      {
        paramSubscriber.onNext(paramAnonymousString);
      }
    });
    paramSubscriber.add(Subscriptions.create(new Action0()
    {
      public void call()
      {
        val$context.unregisterReceiver(localSmsBroadcastReceiver);
      }
    }));
    paramSubscriber = new IntentFilter();
    paramSubscriber.addAction("android.provider.Telephony.SMS_RECEIVED");
    val$context.registerReceiver(localSmsBroadcastReceiver, paramSubscriber);
  }
}

/* Location:
 * Qualified Name:     me.lyft.android.infrastructure.sms.VerificationAutoFillService.1
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */