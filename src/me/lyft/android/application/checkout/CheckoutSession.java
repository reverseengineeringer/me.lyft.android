package me.lyft.android.application.checkout;

import com.jakewharton.rxrelay.BehaviorRelay;
import javax.inject.Inject;
import javax.inject.Singleton;
import me.lyft.android.application.cleanup.ICleanable;
import me.lyft.android.common.Objects;
import me.lyft.android.common.Strings;
import me.lyft.android.common.Unit;
import me.lyft.android.domain.checkout.FareCalculator;
import me.lyft.android.domain.passenger.ride.PassengerRidePayment;
import me.lyft.android.domain.passenger.ride.PassengerRideReceipt;
import me.lyft.android.domain.payment.ChargeAccount;
import me.lyft.android.domain.payment.Coupon;
import me.lyft.android.domain.payment.CreditLineChargeAccount;
import me.lyft.android.domain.payment.IPaymentFactory;
import me.lyft.android.domain.payment.NullChargeAccount;
import me.lyft.android.domain.splitfare.SplitFareState;
import me.lyft.android.logging.L;
import me.lyft.android.persistence.checkout.ICheckoutStateStorage;
import me.lyft.android.persistence.payment.IChargeAccountsProvider;
import me.lyft.android.persistence.ride.IPassengerRideReceiptService;
import me.lyft.android.persistence.splitfare.ISplitFareStateRepository;
import rx.Observable;
import rx.functions.Func1;
import rx.subjects.PublishSubject;

@Singleton
public class CheckoutSession
  implements ICheckoutSession, ICleanable
{
  private IChargeAccountsProvider chargeAccountsProvider;
  private IPassengerRideReceiptService fareRepository;
  private final BehaviorRelay<Boolean> isBusinessProfileRelay;
  private IPaymentFactory paymentFactory;
  private String selectedChargeAccountId = "";
  private String selectedCouponId = "";
  private int selectedTip = 0;
  private ISplitFareStateRepository splitFareStateRepository;
  private final ICheckoutStateStorage stateStorage;
  private PublishSubject<Unit> tipChangeSubject = PublishSubject.create();
  
  @Inject
  public CheckoutSession(IPassengerRideReceiptService paramIPassengerRideReceiptService, ICheckoutStateStorage paramICheckoutStateStorage, IPaymentFactory paramIPaymentFactory, IChargeAccountsProvider paramIChargeAccountsProvider, ISplitFareStateRepository paramISplitFareStateRepository)
  {
    fareRepository = paramIPassengerRideReceiptService;
    stateStorage = paramICheckoutStateStorage;
    paymentFactory = paramIPaymentFactory;
    chargeAccountsProvider = paramIChargeAccountsProvider;
    splitFareStateRepository = paramISplitFareStateRepository;
    selectedChargeAccountId = paramICheckoutStateStorage.getSelectedChargeAccountId();
    selectedCouponId = paramICheckoutStateStorage.getSelectedCouponId();
    selectedTip = paramICheckoutStateStorage.getSelectedTip();
    isBusinessProfileRelay = BehaviorRelay.create(Boolean.valueOf(paramICheckoutStateStorage.isBusinessProfile()));
  }
  
  private Coupon findValidCouponById(String paramString)
  {
    return fareRepository.getRideReceipt().findValidCouponById(paramString);
  }
  
  private Coupon getFirstValidCoupon()
  {
    return fareRepository.getRideReceipt().getFirstValidCoupon();
  }
  
  private boolean hasSelectedChargeAccount()
  {
    return !Strings.isNullOrEmpty(selectedChargeAccountId);
  }
  
  private void resetBusinessProfileStateStorage()
  {
    resetChargeAccountAndCoupon();
    stateStorage.setIsBusinessProfile(isBusinessProfile());
  }
  
  public void clear()
  {
    setBusinessProfile(false);
  }
  
  public PassengerRidePayment getPayment()
  {
    PassengerRideReceipt localPassengerRideReceipt = fareRepository.getRideReceipt();
    SplitFareState localSplitFareState = splitFareStateRepository.getSplitFareState();
    FareCalculator localFareCalculator = new FareCalculator(paymentFactory);
    if (isBusinessProfile()) {}
    for (Coupon localCoupon = getSelectedCoupon();; localCoupon = getSelectedOrFirstEligibleCoupon())
    {
      localFareCalculator.setSelectedCoupon(localCoupon);
      localFareCalculator.setSelectedChargeAccount(getSelectedOrDefaultChargeAccount());
      localFareCalculator.setRideTotal(localPassengerRideReceipt.getTotalMoney());
      localFareCalculator.setTip(Integer.valueOf(selectedTip));
      localFareCalculator.setTotalContributorsCount(localSplitFareState.getTotalContributorsCount());
      return new PassengerRidePayment(localFareCalculator.calculatePayments(), localSplitFareState.getTotalContributorsCount());
    }
  }
  
  public Coupon getSelectedCoupon()
  {
    return findValidCouponById(selectedCouponId);
  }
  
  public ChargeAccount getSelectedOrDefaultChargeAccount()
  {
    ChargeAccount localChargeAccount2 = chargeAccountsProvider.findChargeAccountById(selectedChargeAccountId);
    ChargeAccount localChargeAccount1 = localChargeAccount2;
    if (localChargeAccount2.isNull()) {
      if (!isBusinessProfile()) {
        break label69;
      }
    }
    label69:
    for (localChargeAccount1 = chargeAccountsProvider.getBusinessOrDefaultChargeAccount();; localChargeAccount1 = chargeAccountsProvider.getDefaultOrFirstValidChargeAccount())
    {
      localChargeAccount1 = (ChargeAccount)Objects.firstNonNull(localChargeAccount1, NullChargeAccount.getInstance());
      if (localChargeAccount1.isNull()) {
        L.d("CheckoutSession using NullChargeAccount.  This may be due to new user or all users charge accounts are invalid.", new Object[0]);
      }
      return localChargeAccount1;
    }
  }
  
  public Coupon getSelectedOrFirstEligibleCoupon()
  {
    Object localObject;
    if (hasSelectedChargeAccount()) {
      localObject = null;
    }
    Coupon localCoupon;
    do
    {
      return (Coupon)localObject;
      localCoupon = getSelectedCoupon();
      localObject = localCoupon;
    } while (localCoupon != null);
    return getFirstValidCoupon();
  }
  
  public String getSelectedPaymentMethodId()
  {
    if (isBusinessProfile()) {}
    for (Coupon localCoupon = getSelectedCoupon(); localCoupon != null; localCoupon = getSelectedOrFirstEligibleCoupon()) {
      return localCoupon.getId();
    }
    return getSelectedOrDefaultChargeAccount().getId();
  }
  
  public int getSelectedTipAmount()
  {
    return selectedTip;
  }
  
  public boolean isBusinessProfile()
  {
    return ((Boolean)isBusinessProfileRelay.getValue()).booleanValue();
  }
  
  public Observable<Boolean> observeBusinessProfileChanged()
  {
    return isBusinessProfileRelay.asObservable();
  }
  
  public Observable<Unit> observeTipChange()
  {
    return tipChangeSubject.asObservable();
  }
  
  public Observable<ChargeAccount> onDefaultChargeAccountForSessionChanged()
  {
    observeBusinessProfileChanged().switchMap(new Func1()
    {
      public Observable<ChargeAccount> call(Boolean paramAnonymousBoolean)
      {
        Observable localObservable1 = chargeAccountsProvider.observeDefaultBusinessChargeAccount();
        Observable localObservable2 = chargeAccountsProvider.observeDefaultChargeAccount();
        if (paramAnonymousBoolean.booleanValue()) {
          return localObservable1;
        }
        return localObservable2;
      }
    }).distinctUntilChanged();
  }
  
  public boolean requireExpenseNote()
  {
    ChargeAccount localChargeAccount = getSelectedOrDefaultChargeAccount();
    if ((localChargeAccount instanceof CreditLineChargeAccount)) {
      return ((CreditLineChargeAccount)localChargeAccount).isRequestNotes().booleanValue();
    }
    return isBusinessProfile();
  }
  
  public void reset()
  {
    selectedChargeAccountId = "";
    selectedCouponId = "";
    selectedTip = 0;
    stateStorage.reset();
  }
  
  public void resetChargeAccountAndCoupon()
  {
    selectedChargeAccountId = "";
    selectedCouponId = "";
    stateStorage.setSelectedCouponId(selectedCouponId);
    stateStorage.setSelectedChargeAccountId(selectedChargeAccountId);
  }
  
  public void selectChargeAccount(String paramString)
  {
    paramString = Strings.nullToEmpty(paramString);
    selectedChargeAccountId = paramString;
    stateStorage.setSelectedChargeAccountId(paramString);
    selectedCouponId = "";
    stateStorage.setSelectedCouponId(selectedCouponId);
  }
  
  public boolean selectCoupon(String paramString)
  {
    if (findValidCouponById(paramString) != null)
    {
      selectedCouponId = paramString;
      stateStorage.setSelectedCouponId(paramString);
      selectedChargeAccountId = "";
      stateStorage.setSelectedChargeAccountId(selectedChargeAccountId);
      return true;
    }
    return false;
  }
  
  public void selectTip(int paramInt)
  {
    selectedTip = paramInt;
    tipChangeSubject.onNext(Unit.create());
    stateStorage.setSelectedTip(paramInt);
  }
  
  public void setBusinessProfile(boolean paramBoolean)
  {
    isBusinessProfileRelay.call(Boolean.valueOf(paramBoolean));
    resetBusinessProfileStateStorage();
  }
  
  public void toggleBusinessProfile()
  {
    BehaviorRelay localBehaviorRelay = isBusinessProfileRelay;
    if (!((Boolean)isBusinessProfileRelay.getValue()).booleanValue()) {}
    for (boolean bool = true;; bool = false)
    {
      localBehaviorRelay.call(Boolean.valueOf(bool));
      resetBusinessProfileStateStorage();
      return;
    }
  }
}

/* Location:
 * Qualified Name:     me.lyft.android.application.checkout.CheckoutSession
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */