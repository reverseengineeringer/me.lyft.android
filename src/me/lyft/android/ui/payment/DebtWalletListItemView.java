package me.lyft.android.ui.payment;

import android.content.Context;
import android.content.res.Resources;
import javax.inject.Inject;
import me.lyft.android.application.payment.IPaymentService;
import me.lyft.android.common.AppFlow;
import me.lyft.android.common.DialogFlow;
import me.lyft.android.domain.payment.ChargeAccount;
import me.lyft.android.domain.payment.WalletChargeAccount;
import me.lyft.android.rx.Binder;
import me.lyft.android.ui.IProgressController;
import rx.Observable;

public class DebtWalletListItemView
  extends DebtListItemView
{
  @Inject
  AppFlow appFlow;
  private Binder binder;
  @Inject
  DialogFlow dialogFlow;
  @Inject
  IPaymentService paymentService;
  @Inject
  IProgressController progressController;
  
  public DebtWalletListItemView(Context paramContext, WalletChargeAccount paramWalletChargeAccount, IPayDebtHandler paramIPayDebtHandler)
  {
    super(paramContext, paramWalletChargeAccount, paramIPayDebtHandler);
  }
  
  private boolean isAddWallet()
  {
    return getChargeAccount() == null;
  }
  
  private String resolveCardText()
  {
    WalletChargeAccount localWalletChargeAccount = (WalletChargeAccount)getChargeAccount();
    if (isAddWallet()) {
      return getResources().getString(2131165521);
    }
    if (localWalletChargeAccount.isFailed().booleanValue()) {
      return getResources().getString(2131165532, new Object[] { localWalletChargeAccount.getLastFour() });
    }
    return getResources().getString(2131165534, new Object[] { localWalletChargeAccount.getLastFour() });
  }
  
  protected int getIcon()
  {
    return 2130837636;
  }
  
  protected String getTitle()
  {
    return resolveCardText();
  }
  
  protected boolean isFailed()
  {
    if (isAddWallet()) {
      return false;
    }
    return getChargeAccount().isFailed().booleanValue();
  }
  
  protected void onAttachedToWindow()
  {
    super.onAttachedToWindow();
    binder = Binder.attach(this);
    binder.bind(paymentService.observeWalletReadyToPay(), new DebtWalletListItemView.1(this));
  }
  
  public boolean performClick()
  {
    if ((isAddWallet()) || (getChargeAccount().isFailed().booleanValue())) {}
    for (Observable localObservable = paymentService.saveAndroidPayCard();; localObservable = paymentService.payDebtWithWallet(getChargeAccount().getId()))
    {
      payDebtHandler.onPaymentMethodSelected(localObservable);
      return true;
    }
  }
}

/* Location:
 * Qualified Name:     me.lyft.android.ui.payment.DebtWalletListItemView
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */