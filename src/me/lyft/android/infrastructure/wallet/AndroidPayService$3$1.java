package me.lyft.android.infrastructure.wallet;

import com.google.android.gms.common.api.BooleanResult;
import com.google.android.gms.common.api.ResultCallback;
import com.google.android.gms.common.api.Status;
import me.lyft.android.logging.L;
import rx.Subscriber;

class AndroidPayService$3$1
  implements ResultCallback<BooleanResult>
{
  AndroidPayService$3$1(AndroidPayService.3 param3, Subscriber paramSubscriber) {}
  
  public void onResult(BooleanResult paramBooleanResult)
  {
    if (paramBooleanResult.getStatus().isSuccess()) {
      val$subscriber.onNext(Boolean.valueOf(paramBooleanResult.getValue()));
    }
    for (;;)
    {
      val$subscriber.onCompleted();
      return;
      L.e(new IllegalStateException("isReadyToPay returned non successful result"), "isReadyToPay Status: " + paramBooleanResult.getStatus(), new Object[0]);
      val$subscriber.onNext(Boolean.valueOf(false));
    }
  }
}

/* Location:
 * Qualified Name:     me.lyft.android.infrastructure.wallet.AndroidPayService.3.1
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */