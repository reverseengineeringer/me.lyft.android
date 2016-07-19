package me.lyft.android.infrastructure.wallet;

import android.app.Activity;
import android.content.Intent;
import com.google.android.gms.common.api.BooleanResult;
import com.google.android.gms.common.api.PendingResult;
import com.google.android.gms.common.api.ResultCallback;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.wallet.Cart;
import com.google.android.gms.wallet.Cart.Builder;
import com.google.android.gms.wallet.FullWallet;
import com.google.android.gms.wallet.FullWalletRequest;
import com.google.android.gms.wallet.FullWalletRequest.Builder;
import com.google.android.gms.wallet.MaskedWallet;
import com.google.android.gms.wallet.MaskedWalletRequest;
import com.google.android.gms.wallet.MaskedWalletRequest.Builder;
import com.google.android.gms.wallet.PaymentMethodToken;
import com.google.android.gms.wallet.PaymentMethodTokenizationParameters;
import com.google.android.gms.wallet.PaymentMethodTokenizationParameters.Builder;
import com.google.android.gms.wallet.Payments;
import com.google.android.gms.wallet.Wallet;
import com.google.gson.Gson;
import com.stripe.model.Token;
import com.stripe.net.APIResource;
import me.lyft.android.ILyftPreferences;
import me.lyft.android.infrastructure.activity.ActivityService;
import me.lyft.android.infrastructure.androidpay.AndroidPayServiceException;
import me.lyft.android.infrastructure.androidpay.AndroidPayStripeToken;
import me.lyft.android.infrastructure.androidpay.IAndroidPayService;
import me.lyft.android.infrastructure.googleplay.IGoogleApiProvider;
import me.lyft.android.logging.L;
import me.lyft.android.rx.ReactiveProperty;
import me.lyft.android.utils.ActivityResult;
import rx.Observable;
import rx.Observable.OnSubscribe;
import rx.Subscriber;
import rx.functions.Action1;
import rx.functions.Func1;
import rx.subjects.PublishSubject;
import rx.subscriptions.CompositeSubscription;

public class AndroidPayService
  extends ActivityService
  implements IAndroidPayService
{
  private static final String DEFAULT_CURRENCY_CODE = "USD";
  private static final String DEFAULT_TOTAL = "0.00";
  private PublishSubject<ActivityResult> activityResultSubject = PublishSubject.create();
  private IGoogleApiProvider googleApiProvider;
  private ILyftPreferences lyftPreferences;
  private ReactiveProperty<Boolean> readyToPay = ReactiveProperty.create(Boolean.valueOf(false));
  private CompositeSubscription subscriptions = new CompositeSubscription();
  
  public AndroidPayService(IGoogleApiProvider paramIGoogleApiProvider, ILyftPreferences paramILyftPreferences)
  {
    googleApiProvider = paramIGoogleApiProvider;
    lyftPreferences = paramILyftPreferences;
  }
  
  private FullWalletRequest createFullWalletRequest(MaskedWallet paramMaskedWallet)
  {
    return FullWalletRequest.newBuilder().setGoogleTransactionId(paramMaskedWallet.getGoogleTransactionId()).setCart(Cart.newBuilder().setCurrencyCode("USD").setTotalPrice("0.00").build()).build();
  }
  
  private static MaskedWalletRequest createMaskedWalletRequest(String paramString)
  {
    return MaskedWalletRequest.newBuilder().setPaymentMethodTokenizationParameters(PaymentMethodTokenizationParameters.newBuilder().setPaymentMethodTokenizationType(1).addParameter("gateway", "stripe").addParameter("stripe:publishableKey", paramString).addParameter("stripe:version", "1.31.0").build()).setMerchantName("Lyft").setEstimatedTotalPrice("0.00").setPhoneNumberRequired(false).setAllowPrepaidCard(false).setCurrencyCode("USD").build();
  }
  
  private AndroidPayServiceException createWalletException(Intent paramIntent)
  {
    return new AndroidPayServiceException(paramIntent.getIntExtra("com.google.android.gms.wallet.EXTRA_ERROR_CODE", -1));
  }
  
  private Func1<ActivityResult, Observable<AndroidPayStripeToken>> fullWalletToStripeToken()
  {
    new Func1()
    {
      public Observable<AndroidPayStripeToken> call(ActivityResult paramAnonymousActivityResult)
      {
        if (paramAnonymousActivityResult.getResultCode() == -1)
        {
          paramAnonymousActivityResult = (FullWallet)paramAnonymousActivityResult.getIntent().getParcelableExtra("com.google.android.gms.wallet.EXTRA_FULL_WALLET");
          Object localObject = paramAnonymousActivityResult.getPaymentMethodToken().getToken();
          localObject = (Token)APIResource.GSON.fromJson((String)localObject, Token.class);
          paramAnonymousActivityResult = AndroidPayService.obtainLabel(paramAnonymousActivityResult);
          return Observable.just(new AndroidPayStripeToken(((Token)localObject).getId(), paramAnonymousActivityResult));
        }
        if (paramAnonymousActivityResult.getResultCode() == 0) {
          return Observable.empty();
        }
        return Observable.error(AndroidPayService.this.createWalletException(paramAnonymousActivityResult.getIntent()));
      }
    };
  }
  
  private Observable<Boolean> isReadyToPay()
  {
    Observable.create(new Observable.OnSubscribe()
    {
      public void call(final Subscriber<? super Boolean> paramAnonymousSubscriber)
      {
        try
        {
          Wallet.Payments.isReadyToPay(googleApiProvider.getApi()).setResultCallback(new ResultCallback()
          {
            public void onResult(BooleanResult paramAnonymous2BooleanResult)
            {
              if (paramAnonymous2BooleanResult.getStatus().isSuccess()) {
                paramAnonymousSubscriber.onNext(Boolean.valueOf(paramAnonymous2BooleanResult.getValue()));
              }
              for (;;)
              {
                paramAnonymousSubscriber.onCompleted();
                return;
                L.e(new IllegalStateException("isReadyToPay returned non successful result"), "isReadyToPay Status: " + paramAnonymous2BooleanResult.getStatus(), new Object[0]);
                paramAnonymousSubscriber.onNext(Boolean.valueOf(false));
              }
            }
          });
          return;
        }
        catch (Throwable localThrowable)
        {
          L.e(localThrowable, "Failed to check Android Pay ready to pay", new Object[0]);
          paramAnonymousSubscriber.onNext(Boolean.valueOf(false));
          paramAnonymousSubscriber.onCompleted();
        }
      }
    });
  }
  
  private Observable<ActivityResult> loadMaskedWallet()
  {
    MaskedWalletRequest localMaskedWalletRequest = createMaskedWalletRequest(lyftPreferences.getStripeKey());
    Wallet.Payments.loadMaskedWallet(googleApiProvider.getApi(), localMaskedWalletRequest, 18);
    activityResultSubject.first(new Func1()
    {
      public Boolean call(ActivityResult paramAnonymousActivityResult)
      {
        if (paramAnonymousActivityResult.getRequestCode() == 18) {}
        for (boolean bool = true;; bool = false) {
          return Boolean.valueOf(bool);
        }
      }
    });
  }
  
  private Func1<ActivityResult, Observable<ActivityResult>> maskedToFullWallet()
  {
    new Func1()
    {
      public Observable<ActivityResult> call(ActivityResult paramAnonymousActivityResult)
      {
        if (paramAnonymousActivityResult.getResultCode() == -1)
        {
          paramAnonymousActivityResult = (MaskedWallet)paramAnonymousActivityResult.getIntent().getParcelableExtra("com.google.android.gms.wallet.EXTRA_MASKED_WALLET");
          paramAnonymousActivityResult = AndroidPayService.this.createFullWalletRequest(paramAnonymousActivityResult);
          Wallet.Payments.loadFullWallet(googleApiProvider.getApi(), paramAnonymousActivityResult, 19);
          activityResultSubject.first(new Func1()
          {
            public Boolean call(ActivityResult paramAnonymous2ActivityResult)
            {
              if (paramAnonymous2ActivityResult.getRequestCode() == 19) {}
              for (boolean bool = true;; bool = false) {
                return Boolean.valueOf(bool);
              }
            }
          });
        }
        if (paramAnonymousActivityResult.getResultCode() == 0) {
          return Observable.empty();
        }
        return Observable.error(AndroidPayService.this.createWalletException(paramAnonymousActivityResult.getIntent()));
      }
    };
  }
  
  private static String obtainLabel(FullWallet paramFullWallet)
  {
    if (paramFullWallet != null)
    {
      paramFullWallet = paramFullWallet.getPaymentDescriptions();
      if ((paramFullWallet != null) && (paramFullWallet.length >= 1)) {
        return paramFullWallet[0];
      }
    }
    return null;
  }
  
  private Observable<AndroidPayStripeToken> performChangeWalletCard()
  {
    loadMaskedWallet().flatMap(new Func1()
    {
      public Observable<ActivityResult> call(ActivityResult paramAnonymousActivityResult)
      {
        if (paramAnonymousActivityResult.getResultCode() == -1)
        {
          paramAnonymousActivityResult = (MaskedWallet)paramAnonymousActivityResult.getIntent().getParcelableExtra("com.google.android.gms.wallet.EXTRA_MASKED_WALLET");
          Wallet.Payments.changeMaskedWallet(googleApiProvider.getApi(), paramAnonymousActivityResult.getGoogleTransactionId(), paramAnonymousActivityResult.getMerchantTransactionId(), 24);
          activityResultSubject.first(new Func1()
          {
            public Boolean call(ActivityResult paramAnonymous2ActivityResult)
            {
              if (paramAnonymous2ActivityResult.getRequestCode() == 24) {}
              for (boolean bool = true;; bool = false) {
                return Boolean.valueOf(bool);
              }
            }
          });
        }
        if (paramAnonymousActivityResult.getResultCode() == 0) {
          return Observable.empty();
        }
        return Observable.error(AndroidPayService.this.createWalletException(paramAnonymousActivityResult.getIntent()));
      }
    }).flatMap(maskedToFullWallet()).flatMap(fullWalletToStripeToken());
  }
  
  private void performReadyToPay()
  {
    subscriptions.add(isReadyToPay().subscribe(new Action1()
    {
      public void call(Boolean paramAnonymousBoolean)
      {
        readyToPay.onNext(paramAnonymousBoolean);
      }
    }));
  }
  
  public Observable<AndroidPayStripeToken> changeWalletCard()
  {
    return performChangeWalletCard();
  }
  
  public Observable<AndroidPayStripeToken> getWalletToken()
  {
    return loadMaskedWallet().flatMap(maskedToFullWallet()).flatMap(fullWalletToStripeToken());
  }
  
  public Observable<Boolean> observeReadyToPay()
  {
    performReadyToPay();
    return readyToPay.asObservable();
  }
  
  public void onActivityPaused(Activity paramActivity)
  {
    super.onActivityPaused(paramActivity);
    subscriptions.unsubscribe();
    subscriptions = new CompositeSubscription();
  }
  
  public void onActivityResult(Activity paramActivity, ActivityResult paramActivityResult)
  {
    super.onActivityResult(paramActivity, paramActivityResult);
    activityResultSubject.onNext(paramActivityResult);
  }
  
  public void onActivityResumed(Activity paramActivity)
  {
    super.onActivityResumed(paramActivity);
    performReadyToPay();
  }
}

/* Location:
 * Qualified Name:     me.lyft.android.infrastructure.wallet.AndroidPayService
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */