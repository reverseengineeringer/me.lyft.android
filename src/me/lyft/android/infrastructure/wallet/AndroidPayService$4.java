package me.lyft.android.infrastructure.wallet;

import android.content.Intent;
import com.google.android.gms.wallet.MaskedWallet;
import com.google.android.gms.wallet.Payments;
import com.google.android.gms.wallet.Wallet;
import me.lyft.android.infrastructure.googleplay.IGoogleApiProvider;
import me.lyft.android.utils.ActivityResult;
import rx.Observable;
import rx.functions.Func1;
import rx.subjects.PublishSubject;

class AndroidPayService$4
  implements Func1<ActivityResult, Observable<ActivityResult>>
{
  AndroidPayService$4(AndroidPayService paramAndroidPayService) {}
  
  public Observable<ActivityResult> call(ActivityResult paramActivityResult)
  {
    if (paramActivityResult.getResultCode() == -1)
    {
      paramActivityResult = (MaskedWallet)paramActivityResult.getIntent().getParcelableExtra("com.google.android.gms.wallet.EXTRA_MASKED_WALLET");
      Wallet.Payments.changeMaskedWallet(AndroidPayService.access$100(this$0).getApi(), paramActivityResult.getGoogleTransactionId(), paramActivityResult.getMerchantTransactionId(), 24);
      AndroidPayService.access$200(this$0).first(new Func1()
      {
        public Boolean call(ActivityResult paramAnonymousActivityResult)
        {
          if (paramAnonymousActivityResult.getRequestCode() == 24) {}
          for (boolean bool = true;; bool = false) {
            return Boolean.valueOf(bool);
          }
        }
      });
    }
    if (paramActivityResult.getResultCode() == 0) {
      return Observable.empty();
    }
    return Observable.error(AndroidPayService.access$300(this$0, paramActivityResult.getIntent()));
  }
}

/* Location:
 * Qualified Name:     me.lyft.android.infrastructure.wallet.AndroidPayService.4
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */