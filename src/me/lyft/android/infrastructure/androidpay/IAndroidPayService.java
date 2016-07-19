package me.lyft.android.infrastructure.androidpay;

import rx.Observable;

public abstract interface IAndroidPayService
{
  public abstract Observable<AndroidPayStripeToken> changeWalletCard();
  
  public abstract Observable<AndroidPayStripeToken> getWalletToken();
  
  public abstract Observable<Boolean> observeReadyToPay();
}

/* Location:
 * Qualified Name:     me.lyft.android.infrastructure.androidpay.IAndroidPayService
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */