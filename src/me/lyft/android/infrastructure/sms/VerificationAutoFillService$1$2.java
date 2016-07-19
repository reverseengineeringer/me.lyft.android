package me.lyft.android.infrastructure.sms;

import android.content.Context;
import rx.functions.Action0;

class VerificationAutoFillService$1$2
  implements Action0
{
  VerificationAutoFillService$1$2(VerificationAutoFillService.1 param1, VerificationAutoFillService.SmsBroadcastReceiver paramSmsBroadcastReceiver) {}
  
  public void call()
  {
    this$1.val$context.unregisterReceiver(val$receiver);
  }
}

/* Location:
 * Qualified Name:     me.lyft.android.infrastructure.sms.VerificationAutoFillService.1.2
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */