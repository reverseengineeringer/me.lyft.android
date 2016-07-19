package me.lyft.android.infrastructure.stripe;

import com.stripe.exception.APIConnectionException;
import com.stripe.exception.AuthenticationException;
import com.stripe.exception.CardException;
import com.stripe.exception.InvalidRequestException;
import com.stripe.exception.StripeException;
import com.stripe.model.Token;
import com.stripe.net.RequestOptions;
import com.stripe.net.RequestOptions.RequestOptionsBuilder;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Map;
import javax.inject.Inject;
import me.lyft.android.ILyftPreferences;
import me.lyft.android.application.payment.InvalidCardException;
import me.lyft.android.application.payment.InvalidCardException.Reason;
import me.lyft.android.common.Strings;
import me.lyft.android.domain.payment.ICard;
import rx.Observable;
import rx.Observable.OnSubscribe;
import rx.Subscriber;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;

public class StripeService
  implements IStripeService
{
  private static final String PREPAID_FUNDING = "prepaid";
  private ILyftPreferences preferences;
  
  @Inject
  public StripeService(ILyftPreferences paramILyftPreferences)
  {
    preferences = paramILyftPreferences;
  }
  
  static Map<String, Object> hashMapFromCard(ICard paramICard)
  {
    HashMap localHashMap1 = new HashMap();
    HashMap localHashMap2 = new HashMap();
    localHashMap2.put("number", nullIfBlank(paramICard.getNumber()));
    localHashMap2.put("cvc", nullIfBlank(paramICard.getCvc()));
    localHashMap2.put("exp_month", paramICard.getExpMonth());
    localHashMap2.put("exp_year", paramICard.getExpYear());
    localHashMap2.put("name", nullIfBlank(paramICard.getName()));
    localHashMap2.put("address_line1", nullIfBlank(paramICard.getAddressLine1()));
    localHashMap2.put("address_line2", nullIfBlank(paramICard.getAddressLine2()));
    localHashMap2.put("address_city", nullIfBlank(paramICard.getCity()));
    localHashMap2.put("address_zip", nullIfBlank(paramICard.getAddressZip()));
    localHashMap2.put("address_state", nullIfBlank(paramICard.getState()));
    localHashMap2.put("address_country", nullIfBlank(paramICard.getAddressCountry()));
    paramICard = new HashSet(localHashMap2.keySet()).iterator();
    while (paramICard.hasNext())
    {
      String str = (String)paramICard.next();
      if (localHashMap2.get(str) == null) {
        localHashMap2.remove(str);
      }
    }
    localHashMap1.put("card", localHashMap2);
    return localHashMap1;
  }
  
  static String nullIfBlank(String paramString)
  {
    String str = paramString;
    if (Strings.isNullOrBlank(paramString)) {
      str = null;
    }
    return str;
  }
  
  static ICard performClientValidation(ICard paramICard)
    throws InvalidCardException
  {
    int i;
    if (!paramICard.validateCard())
    {
      i = 1;
      if (paramICard.validateZip()) {
        break label50;
      }
    }
    label50:
    for (int j = 1;; j = 0)
    {
      if ((i == 0) && (j == 0)) {
        return paramICard;
      }
      throw new InvalidCardException(InvalidCardException.Reason.CLIENT_VALIDATION_ERROR, "Client validation failed", null, paramICard);
      i = 0;
      break;
    }
    return paramICard;
  }
  
  static void validateKey(String paramString)
    throws AuthenticationException
  {
    if ((paramString == null) || (paramString.length() == 0)) {
      throw new AuthenticationException("Invalid Publishable Key: You must use a valid publishable key to create a token.  For more info, see https://stripe.com/docs/stripe.js.");
    }
    if (paramString.startsWith("sk_")) {
      throw new AuthenticationException("Invalid Publishable Key: You are using a secret key to create a token, instead of the publishable one. For more info, see https://stripe.com/docs/stripe.js");
    }
  }
  
  public Observable<String> createCardToken(final ICard paramICard)
  {
    Observable.create(new Observable.OnSubscribe()
    {
      public void call(Subscriber<? super String> paramAnonymousSubscriber)
      {
        try
        {
          localObject = preferences.getStripeKey();
          StripeService.validateKey((String)localObject);
          localObject = RequestOptions.builder().setApiKey((String)localObject).build();
          paramAnonymousSubscriber.onNext(Token.create(StripeService.hashMapFromCard(paramICard), (RequestOptions)localObject).getId());
          paramAnonymousSubscriber.onCompleted();
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
          paramAnonymousSubscriber.onError((Throwable)localObject);
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
    }).subscribeOn(Schedulers.io()).observeOn(AndroidSchedulers.mainThread());
  }
  
  public Observable<String> validateCardAndCreateToken(ICard paramICard)
  {
    try
    {
      paramICard = createCardToken(performClientValidation(paramICard));
      return paramICard;
    }
    catch (InvalidCardException paramICard) {}
    return Observable.error(paramICard);
  }
}

/* Location:
 * Qualified Name:     me.lyft.android.infrastructure.stripe.StripeService
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */