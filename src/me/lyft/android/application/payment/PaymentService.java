package me.lyft.android.application.payment;

import com.lyft.android.api.dto.ChargeAccountRequestDTOBuilder;
import com.lyft.android.api.dto.ChargeAccountsResponseDTO;
import com.lyft.android.api.dto.PaypalClientTokenDTO;
import com.lyft.android.api.dto.UniversalDTO;
import java.util.Iterator;
import java.util.List;
import me.lyft.android.analytics.core.ActionAnalytics;
import me.lyft.android.analytics.studies.PaymentAnalytics;
import me.lyft.android.analytics.utils.AnalyticsUtils;
import me.lyft.android.application.IUserProvider;
import me.lyft.android.common.Strings;
import me.lyft.android.common.Unit;
import me.lyft.android.domain.User;
import me.lyft.android.domain.lyft.LyftValidationError;
import me.lyft.android.domain.payment.ChargeAccount;
import me.lyft.android.domain.payment.ChargeAccountMapper;
import me.lyft.android.domain.payment.ICard;
import me.lyft.android.infrastructure.androidpay.AndroidPayServiceException;
import me.lyft.android.infrastructure.androidpay.AndroidPayStripeToken;
import me.lyft.android.infrastructure.androidpay.IAndroidPayService;
import me.lyft.android.infrastructure.lyft.ILyftApi;
import me.lyft.android.infrastructure.lyft.LyftApiException;
import me.lyft.android.infrastructure.lyft.PaymentErrorParser;
import me.lyft.android.infrastructure.paypal.IPayPalService;
import me.lyft.android.infrastructure.paypal.PayPalChargeData;
import me.lyft.android.infrastructure.paypal.PayPalServiceException;
import me.lyft.android.infrastructure.stripe.IStripeService;
import me.lyft.android.infrastructure.stripe.StripeInvalidCardException;
import me.lyft.android.infrastructure.stripe.StripeServiceException;
import me.lyft.android.persistence.payment.IChargeAccountsProvider;
import rx.Notification;
import rx.Observable;
import rx.functions.Action1;
import rx.functions.Func1;
import rx.subjects.PublishSubject;

public class PaymentService
  implements IPaymentService
{
  private IAndroidPayService androidPayService;
  private IChargeAccountsProvider chargeAccountsProvider;
  private PublishSubject<Unit> createOrUpdateCreditCardSubject = PublishSubject.create();
  private ILyftApi lyftApi;
  private IPayPalService payPalService;
  private IStripeService stripeService;
  private IUserProvider userProvider;
  
  public PaymentService(ILyftApi paramILyftApi, IUserProvider paramIUserProvider, IStripeService paramIStripeService, IAndroidPayService paramIAndroidPayService, IPayPalService paramIPayPalService, IChargeAccountsProvider paramIChargeAccountsProvider)
  {
    lyftApi = paramILyftApi;
    userProvider = paramIUserProvider;
    stripeService = paramIStripeService;
    androidPayService = paramIAndroidPayService;
    payPalService = paramIPayPalService;
    chargeAccountsProvider = paramIChargeAccountsProvider;
  }
  
  private Observable<ChargeAccountsResponseDTO> createWalletChargeAccount(AndroidPayStripeToken paramAndroidPayStripeToken)
  {
    paramAndroidPayStripeToken = new ChargeAccountRequestDTOBuilder().withClientPaymentMethod("googleWallet").withToken(paramAndroidPayStripeToken.getToken()).withLabel(paramAndroidPayStripeToken.getLabel()).build();
    return lyftApi.createChargeAccount(paramAndroidPayStripeToken);
  }
  
  private <T> Observable<T> handleError(Throwable paramThrowable)
  {
    if (StripeServiceException.class.isAssignableFrom(paramThrowable.getClass()))
    {
      paramThrowable = (StripeServiceException)paramThrowable;
      if ((paramThrowable instanceof StripeInvalidCardException)) {
        paramThrowable = new InvalidCardException(InvalidCardException.Reason.STRIPE_ERROR, paramThrowable.getMessage(), paramThrowable);
      }
    }
    for (;;)
    {
      return Observable.error(paramThrowable);
      paramThrowable = new PaymentException(paramThrowable.getMessage(), paramThrowable, "stripe_error");
      continue;
      if ((paramThrowable instanceof LyftApiException))
      {
        LyftApiException localLyftApiException = (LyftApiException)paramThrowable;
        if (localLyftApiException.getStatusCode() == 422)
        {
          String str = "Invalid card";
          paramThrowable = InvalidCardException.Reason.INVALID_CARD_ERROR;
          Iterator localIterator = localLyftApiException.getValidationErrors().iterator();
          while (localIterator.hasNext())
          {
            LyftValidationError localLyftValidationError = (LyftValidationError)localIterator.next();
            if (!Strings.isNullOrEmpty(localLyftValidationError.getMessage()))
            {
              str = localLyftValidationError.getMessage();
              paramThrowable = InvalidCardException.Reason.SERVER_VALIDATION_ERROR;
            }
          }
          if (!Strings.isNullOrEmpty(localLyftApiException.getLyftErrorMessage()))
          {
            str = localLyftApiException.getLyftErrorMessage();
            paramThrowable = InvalidCardException.Reason.SERVER_VALIDATION_ERROR;
          }
          paramThrowable = new InvalidCardException(paramThrowable, str, localLyftApiException);
        }
        else
        {
          paramThrowable = new PaymentException("Failed to save card", localLyftApiException, "save_server_error_" + localLyftApiException.getStatusCode());
        }
      }
      else if ((paramThrowable instanceof AndroidPayServiceException))
      {
        paramThrowable = new InvalidWalletException("Unable to create wallet card", paramThrowable, ((AndroidPayServiceException)paramThrowable).getReason());
      }
      else if ((paramThrowable instanceof PayPalServiceException))
      {
        paramThrowable = new InvalidPayPalException("Unable to link PayPal account", paramThrowable, ((PayPalServiceException)paramThrowable).getReason());
      }
    }
  }
  
  private Observable<Unit> makeDefault(Observable<ChargeAccountsResponseDTO> paramObservable)
  {
    paramObservable.doOnNext(new Action1()
    {
      public void call(ChargeAccountsResponseDTO paramAnonymousChargeAccountsResponseDTO)
      {
        PaymentService.this.updateChargeAccountsProvider(paramAnonymousChargeAccountsResponseDTO);
      }
    }).onErrorResumeNext(new Func1()
    {
      public Observable<ChargeAccountsResponseDTO> call(Throwable paramAnonymousThrowable)
      {
        return Observable.error(PaymentErrorParser.parse(paramAnonymousThrowable));
      }
    }).map(Unit.func1());
  }
  
  private Observable<Unit> payDebt(Observable<ChargeAccountsResponseDTO> paramObservable, final String paramString1, final String paramString2)
  {
    paramObservable.flatMap(new Func1()
    {
      public Observable<Unit> call(ChargeAccountsResponseDTO paramAnonymousChargeAccountsResponseDTO)
      {
        paramAnonymousChargeAccountsResponseDTO = PaymentService.this.updateChargeAccountsProvider(paramAnonymousChargeAccountsResponseDTO);
        Object localObject = null;
        Iterator localIterator = paramAnonymousChargeAccountsResponseDTO.iterator();
        do
        {
          paramAnonymousChargeAccountsResponseDTO = (ChargeAccountsResponseDTO)localObject;
          if (!localIterator.hasNext()) {
            break;
          }
          paramAnonymousChargeAccountsResponseDTO = (ChargeAccount)localIterator.next();
        } while (!paramString1.equals(paramAnonymousChargeAccountsResponseDTO.getId()));
        if ((paramAnonymousChargeAccountsResponseDTO != null) && (paramAnonymousChargeAccountsResponseDTO.isFailed().booleanValue())) {
          return Observable.error(new PaymentException("Charging debt failed", null, paramString2));
        }
        return Observable.just(Unit.create());
      }
    }).onErrorResumeNext(new Func1()
    {
      public Observable<Unit> call(Throwable paramAnonymousThrowable)
      {
        return Observable.error(PaymentErrorParser.parse(paramAnonymousThrowable));
      }
    });
  }
  
  private List<ChargeAccount> updateChargeAccountsProvider(ChargeAccountsResponseDTO paramChargeAccountsResponseDTO)
  {
    paramChargeAccountsResponseDTO = ChargeAccountMapper.fromChargeAccountDTO(chargeAccounts);
    chargeAccountsProvider.updateChargeAccounts(paramChargeAccountsResponseDTO);
    return paramChargeAccountsResponseDTO;
  }
  
  public Observable<Unit> changeWalletCard()
  {
    final ActionAnalytics localActionAnalytics = PaymentAnalytics.trackEditCard("android_pay");
    androidPayService.changeWalletCard().flatMap(new Func1()
    {
      public Observable<ChargeAccountsResponseDTO> call(AndroidPayStripeToken paramAnonymousAndroidPayStripeToken)
      {
        return PaymentService.this.createWalletChargeAccount(paramAnonymousAndroidPayStripeToken);
      }
    }).doOnNext(new Action1()
    {
      public void call(ChargeAccountsResponseDTO paramAnonymousChargeAccountsResponseDTO)
      {
        PaymentService.this.updateChargeAccountsProvider(paramAnonymousChargeAccountsResponseDTO);
      }
    }).onErrorResumeNext(new Func1()
    {
      public Observable<ChargeAccountsResponseDTO> call(Throwable paramAnonymousThrowable)
      {
        return Observable.error(PaymentErrorParser.parse(paramAnonymousThrowable));
      }
    }).map(Unit.func1()).doOnEach(new Action1()
    {
      public void call(Notification<? super Unit> paramAnonymousNotification)
      {
        AnalyticsUtils.trackResult(localActionAnalytics, paramAnonymousNotification);
      }
    });
  }
  
  public Observable<Unit> createCreditCard(ICard paramICard, final Boolean paramBoolean1, final Boolean paramBoolean2)
  {
    createOrUpdateCreditCardSubject.onNext(Unit.create());
    final ActionAnalytics localActionAnalytics = PaymentAnalytics.trackAddPaymentMethod("credit_card");
    stripeService.validateCardAndCreateToken(paramICard).flatMap(new Func1()
    {
      public Observable<ChargeAccountsResponseDTO> call(String paramAnonymousString)
      {
        paramAnonymousString = new ChargeAccountRequestDTOBuilder().withClientPaymentMethod("card").withToken(paramAnonymousString).withDefault(paramBoolean1).withDefaultBusiness(paramBoolean2).build();
        return lyftApi.createChargeAccount(paramAnonymousString);
      }
    }).doOnNext(new Action1()
    {
      public void call(ChargeAccountsResponseDTO paramAnonymousChargeAccountsResponseDTO)
      {
        PaymentService.this.updateChargeAccountsProvider(paramAnonymousChargeAccountsResponseDTO);
      }
    }).onErrorResumeNext(new Func1()
    {
      public Observable<ChargeAccountsResponseDTO> call(Throwable paramAnonymousThrowable)
      {
        return Observable.error(PaymentErrorParser.parse(paramAnonymousThrowable));
      }
    }).map(Unit.func1()).doOnEach(new Action1()
    {
      public void call(Notification<? super Unit> paramAnonymousNotification)
      {
        AnalyticsUtils.trackResult(localActionAnalytics, paramAnonymousNotification);
      }
    });
  }
  
  public Observable<Unit> defaultBusinessProfileChargeAccount()
  {
    ChargeAccount localChargeAccount = chargeAccountsProvider.getDefaultOrFirstValidChargeAccount();
    if (localChargeAccount.isNull()) {
      return Observable.empty();
    }
    if (!chargeAccountsProvider.getBusinessChargeAccount().isNull()) {
      return Observable.empty();
    }
    return makeDefault(lyftApi.makeChargeAccountDefaultBusiness(localChargeAccount.getId()));
  }
  
  public Observable<Unit> deleteChargeAccount(String paramString1, final String paramString2)
  {
    paramString2 = PaymentAnalytics.trackRemovePaymentMethod(paramString2);
    lyftApi.deleteChargeAccount(paramString1).doOnNext(new Action1()
    {
      public void call(ChargeAccountsResponseDTO paramAnonymousChargeAccountsResponseDTO)
      {
        PaymentService.this.updateChargeAccountsProvider(paramAnonymousChargeAccountsResponseDTO);
      }
    }).onErrorResumeNext(new Func1()
    {
      public Observable<ChargeAccountsResponseDTO> call(Throwable paramAnonymousThrowable)
      {
        return Observable.error(PaymentErrorParser.parse(paramAnonymousThrowable));
      }
    }).map(Unit.func1()).doOnEach(new Action1()
    {
      public void call(Notification<? super Unit> paramAnonymousNotification)
      {
        AnalyticsUtils.trackResult(paramString2, paramAnonymousNotification);
      }
    });
  }
  
  public Observable<Unit> makeCardDefault(String paramString, boolean paramBoolean)
  {
    if (paramBoolean) {}
    for (paramString = lyftApi.makeChargeAccountDefaultBusiness(paramString);; paramString = lyftApi.makeChargeAccountDefault(paramString)) {
      return makeDefault(paramString);
    }
  }
  
  public Observable<Unit> makeCreditLineDefault(String paramString)
  {
    return makeDefault(lyftApi.makeCreditLineDefault(paramString));
  }
  
  public Observable<Unit> makeFacebookDefault(String paramString)
  {
    lyftApi.makeFacebookDefault(paramString).doOnNext(new Action1()
    {
      public void call(ChargeAccountsResponseDTO paramAnonymousChargeAccountsResponseDTO)
      {
        PaymentService.this.updateChargeAccountsProvider(paramAnonymousChargeAccountsResponseDTO);
      }
    }).onErrorResumeNext(new Func1()
    {
      public Observable<ChargeAccountsResponseDTO> call(Throwable paramAnonymousThrowable)
      {
        return Observable.error(PaymentErrorParser.parse(paramAnonymousThrowable));
      }
    }).map(Unit.func1());
  }
  
  public Observable<Unit> makePayPalDefault(final String paramString)
  {
    Observable.just(payPalService.obtainChargeToken()).flatMap(new Func1()
    {
      public Observable<Unit> call(String paramAnonymousString)
      {
        paramAnonymousString = lyftApi.makePayPalDefault(paramString, paramAnonymousString);
        return PaymentService.this.makeDefault(paramAnonymousString);
      }
    });
  }
  
  public Observable<Unit> makeWalletDefault(String paramString)
  {
    return makeDefault(lyftApi.makeWalletDefault(paramString));
  }
  
  public Observable<Unit> observeCreateOrUpdateCreditCard()
  {
    return createOrUpdateCreditCardSubject.asObservable();
  }
  
  public Observable<Boolean> observeWalletReadyToPay()
  {
    return androidPayService.observeReadyToPay();
  }
  
  public Observable<Unit> payDebtWithCreditCard(String paramString)
  {
    return payDebt(lyftApi.payDebtWithCreditCard(paramString), paramString, "debt_card_failed");
  }
  
  public Observable<Unit> payDebtWithPayPal(final String paramString)
  {
    Observable.just(payPalService.obtainChargeToken()).flatMap(new Func1()
    {
      public Observable<Unit> call(String paramAnonymousString)
      {
        paramAnonymousString = lyftApi.payDebtWithPayPal(paramString, paramAnonymousString);
        return PaymentService.this.payDebt(paramAnonymousString, paramString, "debt_paypal_failed");
      }
    });
  }
  
  public Observable<Unit> payDebtWithWallet(final String paramString)
  {
    saveAndroidPayCard().flatMap(new Func1()
    {
      public Observable<Unit> call(Unit paramAnonymousUnit)
      {
        paramAnonymousUnit = lyftApi.payDebtWithWallet(paramString);
        return PaymentService.this.payDebt(paramAnonymousUnit, paramString, "debt_wallet_failed");
      }
    });
  }
  
  public Observable<Unit> refreshChargeAccounts()
  {
    lyftApi.loadChargeAccounts().doOnNext(new Action1()
    {
      public void call(ChargeAccountsResponseDTO paramAnonymousChargeAccountsResponseDTO)
      {
        PaymentService.this.updateChargeAccountsProvider(paramAnonymousChargeAccountsResponseDTO);
      }
    }).map(Unit.func1());
  }
  
  public Observable<Unit> saveAndroidPayCard()
  {
    final ActionAnalytics localActionAnalytics = PaymentAnalytics.trackAddPaymentMethod("android_pay");
    androidPayService.getWalletToken().flatMap(new Func1()
    {
      public Observable<ChargeAccountsResponseDTO> call(AndroidPayStripeToken paramAnonymousAndroidPayStripeToken)
      {
        return PaymentService.this.createWalletChargeAccount(paramAnonymousAndroidPayStripeToken);
      }
    }).doOnNext(new Action1()
    {
      public void call(ChargeAccountsResponseDTO paramAnonymousChargeAccountsResponseDTO)
      {
        PaymentService.this.updateChargeAccountsProvider(paramAnonymousChargeAccountsResponseDTO);
      }
    }).onErrorResumeNext(new Func1()
    {
      public Observable<ChargeAccountsResponseDTO> call(Throwable paramAnonymousThrowable)
      {
        return Observable.error(PaymentErrorParser.parse(paramAnonymousThrowable));
      }
    }).map(Unit.func1()).doOnEach(new Action1()
    {
      public void call(Notification<? super Unit> paramAnonymousNotification)
      {
        AnalyticsUtils.trackResult(localActionAnalytics, paramAnonymousNotification);
      }
    });
  }
  
  public Observable<Unit> savePayPal(final Boolean paramBoolean1, final Boolean paramBoolean2)
  {
    final ActionAnalytics localActionAnalytics = PaymentAnalytics.trackAddPaymentMethod("paypal");
    String str = userProvider.getUser().getId();
    lyftApi.getPayPalClientToken(str).flatMap(new Func1()
    {
      public Observable<PayPalChargeData> call(PaypalClientTokenDTO paramAnonymousPaypalClientTokenDTO)
      {
        return payPalService.obtainPayPalChargeData(clientToken);
      }
    }).flatMap(new Func1()
    {
      public Observable<ChargeAccountsResponseDTO> call(PayPalChargeData paramAnonymousPayPalChargeData)
      {
        String str = paramAnonymousPayPalChargeData.getNonce();
        paramAnonymousPayPalChargeData = paramAnonymousPayPalChargeData.getDeviceData();
        paramAnonymousPayPalChargeData = new ChargeAccountRequestDTOBuilder().withClientPaymentMethod("paypal").withNonce(str).withChargeToken(paramAnonymousPayPalChargeData).withDefault(paramBoolean1).withDefaultBusiness(paramBoolean2).build();
        return lyftApi.createChargeAccount(paramAnonymousPayPalChargeData);
      }
    }).doOnNext(new Action1()
    {
      public void call(ChargeAccountsResponseDTO paramAnonymousChargeAccountsResponseDTO)
      {
        PaymentService.this.updateChargeAccountsProvider(paramAnonymousChargeAccountsResponseDTO);
      }
    }).onErrorResumeNext(new Func1()
    {
      public Observable<ChargeAccountsResponseDTO> call(Throwable paramAnonymousThrowable)
      {
        return Observable.error(PaymentErrorParser.parse(paramAnonymousThrowable));
      }
    }).map(Unit.func1()).doOnEach(new Action1()
    {
      public void call(Notification<? super Unit> paramAnonymousNotification)
      {
        AnalyticsUtils.trackResult(localActionAnalytics, paramAnonymousNotification);
      }
    });
  }
  
  public Observable<Unit> unlinkConcur()
  {
    lyftApi.unlinkConcur(userProvider.getUser().getId()).onErrorResumeNext(new Func1()
    {
      public Observable<UniversalDTO> call(Throwable paramAnonymousThrowable)
      {
        return Observable.error(PaymentErrorParser.parse(paramAnonymousThrowable));
      }
    }).map(Unit.func1());
  }
  
  public Observable<Unit> updateConcurSendRideReceipts(boolean paramBoolean)
  {
    lyftApi.updateConcurSendRideReceipts(userProvider.getUser().getId(), paramBoolean).onErrorResumeNext(new Func1()
    {
      public Observable<UniversalDTO> call(Throwable paramAnonymousThrowable)
      {
        return Observable.error(PaymentErrorParser.parse(paramAnonymousThrowable));
      }
    }).map(Unit.func1());
  }
  
  public Observable<Unit> updateCreditCard(final String paramString, ICard paramICard)
  {
    createOrUpdateCreditCardSubject.onNext(Unit.create());
    final ActionAnalytics localActionAnalytics = PaymentAnalytics.trackEditCard("credit_card");
    if (paramICard.isEmpty()) {}
    for (paramICard = Observable.just(null);; paramICard = stripeService.validateCardAndCreateToken(paramICard)) {
      paramICard.flatMap(new Func1()
      {
        public Observable<ChargeAccountsResponseDTO> call(String paramAnonymousString)
        {
          return lyftApi.updateChargeAccount(paramString, paramAnonymousString);
        }
      }).doOnNext(new Action1()
      {
        public void call(ChargeAccountsResponseDTO paramAnonymousChargeAccountsResponseDTO)
        {
          PaymentService.this.updateChargeAccountsProvider(paramAnonymousChargeAccountsResponseDTO);
        }
      }).onErrorResumeNext(new Func1()
      {
        public Observable<ChargeAccountsResponseDTO> call(Throwable paramAnonymousThrowable)
        {
          return Observable.error(PaymentErrorParser.parse(paramAnonymousThrowable));
        }
      }).map(Unit.func1()).doOnEach(new Action1()
      {
        public void call(Notification<? super Unit> paramAnonymousNotification)
        {
          AnalyticsUtils.trackResult(localActionAnalytics, paramAnonymousNotification);
        }
      });
    }
  }
}

/* Location:
 * Qualified Name:     me.lyft.android.application.payment.PaymentService
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */