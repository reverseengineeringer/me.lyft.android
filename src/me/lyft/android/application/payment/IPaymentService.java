package me.lyft.android.application.payment;

import me.lyft.android.common.Unit;
import me.lyft.android.domain.payment.ICard;
import rx.Observable;

public abstract interface IPaymentService
{
  public abstract Observable<Unit> changeWalletCard();
  
  public abstract Observable<Unit> createCreditCard(ICard paramICard, Boolean paramBoolean1, Boolean paramBoolean2);
  
  public abstract Observable<Unit> defaultBusinessProfileChargeAccount();
  
  public abstract Observable<Unit> deleteChargeAccount(String paramString1, String paramString2);
  
  public abstract Observable<Unit> makeCardDefault(String paramString, boolean paramBoolean);
  
  public abstract Observable<Unit> makeCreditLineDefault(String paramString);
  
  public abstract Observable<Unit> makeFacebookDefault(String paramString);
  
  public abstract Observable<Unit> makePayPalDefault(String paramString);
  
  public abstract Observable<Unit> makeWalletDefault(String paramString);
  
  public abstract Observable<Unit> observeCreateOrUpdateCreditCard();
  
  public abstract Observable<Boolean> observeWalletReadyToPay();
  
  public abstract Observable<Unit> payDebtWithCreditCard(String paramString);
  
  public abstract Observable<Unit> payDebtWithPayPal(String paramString);
  
  public abstract Observable<Unit> payDebtWithWallet(String paramString);
  
  public abstract Observable<Unit> refreshChargeAccounts();
  
  public abstract Observable<Unit> saveAndroidPayCard();
  
  public abstract Observable<Unit> savePayPal(Boolean paramBoolean1, Boolean paramBoolean2);
  
  public abstract Observable<Unit> unlinkConcur();
  
  public abstract Observable<Unit> updateConcurSendRideReceipts(boolean paramBoolean);
  
  public abstract Observable<Unit> updateCreditCard(String paramString, ICard paramICard);
}

/* Location:
 * Qualified Name:     me.lyft.android.application.payment.IPaymentService
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */