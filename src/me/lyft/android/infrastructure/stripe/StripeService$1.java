package me.lyft.android.infrastructure.stripe;

import com.stripe.exception.APIConnectionException;
import com.stripe.exception.AuthenticationException;
import com.stripe.exception.CardException;
import com.stripe.exception.InvalidRequestException;
import com.stripe.exception.StripeException;
import com.stripe.model.Token;
import com.stripe.net.RequestOptions;
import com.stripe.net.RequestOptions.RequestOptionsBuilder;
import me.lyft.android.ILyftPreferences;
import me.lyft.android.domain.payment.ICard;
import rx.Observable.OnSubscribe;
import rx.Subscriber;

class StripeService$1
  implements Observable.OnSubscribe<String>
{
  StripeService$1(StripeService paramStripeService, ICard paramICard) {}
  
  public void call(Subscriber<? super String> paramSubscriber)
  {
    try
    {
      localObject = StripeService.access$000(this$0).getStripeKey();
      StripeService.validateKey((String)localObject);
      localObject = RequestOptions.builder().setApiKey((String)localObject).build();
      paramSubscriber.onNext(Token.create(StripeService.hashMapFromCard(val$card), (RequestOptions)localObject).getId());
      paramSubscriber.onCompleted();
      return;
    }
    catch (Exception localException)
    {
      if (!(localException instanceof CardException)) {
        break label78;
      }
    }
    Object localObject = new StripeInvalidCardException(localException.getMessage(), localException);
    for (;;)
    {
      paramSubscriber.onError((Throwable)localObject);
      return;
      label78:
      if ((localException instanceof InvalidRequestException))
      {
        localObject = new StripeServiceException(localException.getMessage(), localException);
      }
      else if ((localException instanceof AuthenticationException))
      {
        localObject = new StripeServiceException(localException.getMessage(), localException);
      }
      else if ((localException instanceof APIConnectionException))
      {
        localObject = new StripeServiceException(localException.getMessage(), localException);
      }
      else
      {
        localObject = localException;
        if ((localException instanceof StripeException)) {
          localObject = new StripeServiceException(localException.getMessage(), localException);
        }
      }
    }
  }
}

/* Location:
 * Qualified Name:     me.lyft.android.infrastructure.stripe.StripeService.1
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */