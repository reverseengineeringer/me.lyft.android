package me.lyft.android.application.checkout;

import me.lyft.android.common.Unit;
import me.lyft.android.domain.passenger.ride.PassengerRidePayment;
import me.lyft.android.domain.payment.ChargeAccount;
import me.lyft.android.domain.payment.Coupon;
import rx.Observable;

public abstract interface ICheckoutSession
{
  public abstract PassengerRidePayment getPayment();
  
  public abstract Coupon getSelectedCoupon();
  
  public abstract ChargeAccount getSelectedOrDefaultChargeAccount();
  
  public abstract Coupon getSelectedOrFirstEligibleCoupon();
  
  public abstract String getSelectedPaymentMethodId();
  
  public abstract int getSelectedTipAmount();
  
  public abstract boolean isBusinessProfile();
  
  public abstract Observable<Boolean> observeBusinessProfileChanged();
  
  public abstract Observable<Unit> observeTipChange();
  
  public abstract Observable<ChargeAccount> onDefaultChargeAccountForSessionChanged();
  
  public abstract boolean requireExpenseNote();
  
  public abstract void reset();
  
  public abstract void resetChargeAccountAndCoupon();
  
  public abstract void selectChargeAccount(String paramString);
  
  public abstract boolean selectCoupon(String paramString);
  
  public abstract void selectTip(int paramInt);
  
  public abstract void setBusinessProfile(boolean paramBoolean);
  
  public abstract void toggleBusinessProfile();
}

/* Location:
 * Qualified Name:     me.lyft.android.application.checkout.ICheckoutSession
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */