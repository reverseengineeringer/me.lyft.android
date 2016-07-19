package me.lyft.android.infrastructure.wallet;

import android.content.Intent;
import com.google.android.gms.wallet.FullWallet;
import com.google.android.gms.wallet.PaymentMethodToken;
import com.google.gson.Gson;
import com.stripe.model.Token;
import com.stripe.net.APIResource;
import me.lyft.android.infrastructure.androidpay.AndroidPayStripeToken;
import me.lyft.android.utils.ActivityResult;
import rx.Observable;
import rx.functions.Func1;

class AndroidPayService$6
  implements Func1<ActivityResult, Observable<AndroidPayStripeToken>>
{
  AndroidPayService$6(AndroidPayService paramAndroidPayService) {}
  
  public Observable<AndroidPayStripeToken> call(ActivityResult paramActivityResult)
  {
    if (paramActivityResult.getResultCode() == -1)
    {
      paramActivityResult = (FullWallet)paramActivityResult.getIntent().getParcelableExtra("com.google.android.gms.wallet.EXTRA_FULL_WALLET");
      Object localObject = paramActivityResult.getPaymentMethodToken().getToken();
      localObject = (Token)APIResource.GSON.fromJson((String)localObject, Token.class);
      paramActivityResult = AndroidPayService.access$500(paramActivityResult);
      return Observable.just(new AndroidPayStripeToken(((Token)localObject).getId(), paramActivityResult));
    }
    if (paramActivityResult.getResultCode() == 0) {
      return Observable.empty();
    }
    return Observable.error(AndroidPayService.access$300(this$0, paramActivityResult.getIntent()));
  }
}

/* Location:
 * Qualified Name:     me.lyft.android.infrastructure.wallet.AndroidPayService.6
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */