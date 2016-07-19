package me.lyft.android.infrastructure.wallet;

import com.google.android.gms.common.api.BooleanResult;
import com.google.android.gms.common.api.PendingResult;
import com.google.android.gms.common.api.ResultCallback;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.wallet.Payments;
import com.google.android.gms.wallet.Wallet;
import me.lyft.android.infrastructure.googleplay.IGoogleApiProvider;
import me.lyft.android.logging.L;
import rx.Observable.OnSubscribe;
import rx.Subscriber;

class AndroidPayService$3
  implements Observable.OnSubscribe<Boolean>
{
  AndroidPayService$3(AndroidPayService paramAndroidPayService) {}
  
  public void call(final Subscriber<? super Boolean> paramSubscriber)
  {
    try
    {
      Wallet.Payments.isReadyToPay(AndroidPayService.access$100(this$0).getApi()).setResultCallback(new ResultCallback()
      {
        public void onResult(BooleanResult paramAnonymousBooleanResult)
        {
          if (paramAnonymousBooleanResult.getStatus().isSuccess()) {
            paramSubscriber.onNext(Boolean.valueOf(paramAnonymousBooleanResult.getValue()));
          }
          for (;;)
          {
            paramSubscriber.onCompleted();
            return;
            L.e(new IllegalStateException("isReadyToPay returned non successful result"), "isReadyToPay Status: " + paramAnonymousBooleanResult.getStatus(), new Object[0]);
            paramSubscriber.onNext(Boolean.valueOf(false));
          }
        }
      });
      return;
    }
    catch (Throwable localThrowable)
    {
      L.e(localThrowable, "Failed to check Android Pay ready to pay", new Object[0]);
      paramSubscriber.onNext(Boolean.valueOf(false));
      paramSubscriber.onCompleted();
    }
  }
}

/* Location:
 * Qualified Name:     me.lyft.android.infrastructure.wallet.AndroidPayService.3
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */