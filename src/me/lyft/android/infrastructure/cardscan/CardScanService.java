package me.lyft.android.infrastructure.cardscan;

import android.app.Activity;
import android.content.Intent;
import com.jakewharton.rxrelay.PublishRelay;
import io.card.payment.CardIOActivity;
import io.card.payment.CreditCard;
import me.lyft.android.analytics.core.ActionAnalytics;
import me.lyft.android.analytics.studies.PaymentAnalytics;
import me.lyft.android.domain.payment.Card;
import me.lyft.android.domain.payment.ICard;
import me.lyft.android.infrastructure.activity.IActivityLifecycleService;
import me.lyft.android.utils.ActivityResult;
import rx.Observable;
import rx.Subscription;
import rx.functions.Action1;
import rx.subscriptions.Subscriptions;

public class CardScanService
  implements ICardScanService
{
  private final IActivityLifecycleService activityLifecycleService;
  private final PublishRelay<ICard> scannedCardSubject = PublishRelay.create();
  private Subscription subscription = Subscriptions.empty();
  
  public CardScanService(IActivityLifecycleService paramIActivityLifecycleService)
  {
    activityLifecycleService = paramIActivityLifecycleService;
  }
  
  private ICard fromScanResult(CreditCard paramCreditCard)
  {
    String str1 = paramCreditCard.getFormattedCardNumber();
    String str2 = postalCode;
    String str3 = cvv;
    Integer localInteger1 = null;
    Integer localInteger2 = null;
    if (paramCreditCard.isExpiryValid())
    {
      localInteger1 = Integer.valueOf(expiryMonth);
      localInteger2 = Integer.valueOf(expiryYear);
    }
    return Card.create(str1, localInteger1, localInteger2, str3, str2);
  }
  
  private void onActivityResult(ActivityResult paramActivityResult)
  {
    ActionAnalytics localActionAnalytics;
    if (paramActivityResult.getRequestCode() == 21)
    {
      activityLifecycleService.clearResult();
      localActionAnalytics = PaymentAnalytics.trackScanCard();
      paramActivityResult = paramActivityResult.getIntent();
      if ((paramActivityResult != null) && (paramActivityResult.hasExtra("io.card.payment.scanResult")))
      {
        paramActivityResult = fromScanResult((CreditCard)paramActivityResult.getParcelableExtra("io.card.payment.scanResult"));
        localActionAnalytics.trackSuccess();
        scannedCardSubject.call(paramActivityResult);
      }
    }
    else
    {
      return;
    }
    localActionAnalytics.trackFailure("card_scan_canceled");
  }
  
  public Observable<ICard> observeScannedCard()
  {
    return scannedCardSubject.asObservable();
  }
  
  public void start()
  {
    subscription = activityLifecycleService.observeResult().subscribe(new Action1()
    {
      public void call(ActivityResult paramAnonymousActivityResult)
      {
        CardScanService.this.onActivityResult(paramAnonymousActivityResult);
      }
    });
  }
  
  public void startCardScan()
  {
    Intent localIntent = new Intent(activityLifecycleService.getCurrentActivity(), CardIOActivity.class);
    localIntent.putExtra("io.card.payment.requireExpiry", false);
    localIntent.putExtra("io.card.payment.requireCVV", false);
    localIntent.putExtra("io.card.payment.requirePostalCode", false);
    localIntent.putExtra("io.card.payment.scanExpiry", true);
    localIntent.putExtra("io.card.payment.suppressManual", true);
    localIntent.putExtra("io.card.payment.keepApplicationTheme", true);
    activityLifecycleService.getCurrentActivity().startActivityForResult(localIntent, 21);
  }
  
  public void stop()
  {
    subscription.unsubscribe();
  }
}

/* Location:
 * Qualified Name:     me.lyft.android.infrastructure.cardscan.CardScanService
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */