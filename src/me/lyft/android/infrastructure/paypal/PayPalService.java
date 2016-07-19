package me.lyft.android.infrastructure.paypal;

import android.app.Activity;
import com.braintreepayments.api.Braintree;
import com.braintreepayments.api.Braintree.ErrorListener;
import com.braintreepayments.api.Braintree.PaymentMethodNonceListener;
import com.braintreepayments.api.data.BraintreeData;
import com.braintreepayments.api.data.BraintreeEnvironment;
import com.braintreepayments.api.exceptions.ErrorWithResponse;
import me.lyft.android.domain.payment.IPaymentFactory.IPaymentMetadataProvider;
import me.lyft.android.domain.payment.PayPalPayment;
import me.lyft.android.domain.payment.Payment;
import me.lyft.android.infrastructure.activity.ActivityService;
import me.lyft.android.utils.ActivityResult;
import rx.Observable;
import rx.Observable.OnSubscribe;
import rx.Subscriber;
import rx.functions.Action0;
import rx.functions.Func1;
import rx.subjects.PublishSubject;
import rx.subscriptions.Subscriptions;

public class PayPalService
  extends ActivityService
  implements IPaymentFactory.IPaymentMetadataProvider, IPayPalService
{
  private static final BraintreeEnvironment ENVIRONMENT = BraintreeEnvironment.PRODUCTION;
  private PublishSubject<ActivityResult> activityResultSubject = PublishSubject.create();
  private BraintreeData braintreeData;
  
  private Observable<PayPalChargeData> createPaypalResultObservable(final String paramString, final ActivityResult paramActivityResult)
  {
    paramString = getBraintree(paramString);
    if (paramActivityResult.getResultCode() == 0)
    {
      paramString.finishPayWithPayPal(getCurrentActivity(), paramActivityResult.getResultCode(), paramActivityResult.getIntent());
      return Observable.empty();
    }
    Observable.create(new Observable.OnSubscribe()
    {
      public void call(final Subscriber<? super PayPalChargeData> paramAnonymousSubscriber)
      {
        final Braintree.PaymentMethodNonceListener local1 = new Braintree.PaymentMethodNonceListener()
        {
          public void onPaymentMethodNonce(String paramAnonymous2String)
          {
            String str = val$braintree.collectDeviceData(getCurrentActivity(), PayPalService.ENVIRONMENT);
            paramAnonymousSubscriber.onNext(new PayPalChargeData(paramAnonymous2String, str));
            paramAnonymousSubscriber.onCompleted();
          }
        };
        final Braintree.ErrorListener local2 = new Braintree.ErrorListener()
        {
          public void onRecoverableError(ErrorWithResponse paramAnonymous2ErrorWithResponse)
          {
            paramAnonymousSubscriber.onError(new PayPalServiceException(paramAnonymous2ErrorWithResponse, "recoverable_error_" + paramAnonymous2ErrorWithResponse.toString()));
          }
          
          public void onUnrecoverableError(Throwable paramAnonymous2Throwable)
          {
            paramAnonymousSubscriber.onError(new PayPalServiceException(paramAnonymous2Throwable, "unrecoverable_error_" + paramAnonymous2Throwable.getMessage()));
          }
        };
        paramAnonymousSubscriber.add(Subscriptions.create(new Action0()
        {
          public void call()
          {
            val$braintree.removeListener(local1);
            val$braintree.removeListener(local2);
          }
        }));
        paramString.addListener(local1);
        paramString.addListener(local2);
        paramString.finishPayWithPayPal(getCurrentActivity(), paramActivityResult.getResultCode(), paramActivityResult.getIntent());
      }
    });
  }
  
  private Braintree getBraintree(String paramString)
  {
    return Braintree.getInstance(getCurrentActivity(), paramString);
  }
  
  private BraintreeData getBraintreeData()
  {
    if (braintreeData == null) {
      braintreeData = new BraintreeData(getCurrentActivity(), ENVIRONMENT);
    }
    return braintreeData;
  }
  
  public String obtainChargeToken()
  {
    return getBraintreeData().collectDeviceData();
  }
  
  public Observable<PayPalChargeData> obtainPayPalChargeData(final String paramString)
  {
    getBraintree(paramString).startPayWithPayPal(getCurrentActivity(), 22);
    activityResultSubject.first(new Func1()
    {
      public Boolean call(ActivityResult paramAnonymousActivityResult)
      {
        if (paramAnonymousActivityResult.getRequestCode() == 22) {}
        for (boolean bool = true;; bool = false) {
          return Boolean.valueOf(bool);
        }
      }
    }).flatMap(new Func1()
    {
      public Observable<PayPalChargeData> call(ActivityResult paramAnonymousActivityResult)
      {
        return PayPalService.this.createPaypalResultObservable(paramString, paramAnonymousActivityResult);
      }
    });
  }
  
  public void onActivityDestroyed(Activity paramActivity)
  {
    super.onActivityDestroyed(paramActivity);
    braintreeData = null;
  }
  
  public void onActivityResult(Activity paramActivity, ActivityResult paramActivityResult)
  {
    super.onActivityResult(paramActivity, paramActivityResult);
    activityResultSubject.onNext(paramActivityResult);
  }
  
  public void provideMetadata(Payment paramPayment)
  {
    if ((paramPayment instanceof PayPalPayment)) {
      ((PayPalPayment)paramPayment).setChargeToken(obtainChargeToken());
    }
  }
}

/* Location:
 * Qualified Name:     me.lyft.android.infrastructure.paypal.PayPalService
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */