package me.lyft.android.ui.payment;

import android.content.Context;
import android.content.res.Resources;
import javax.inject.Inject;
import me.lyft.android.application.payment.IPaymentService;
import me.lyft.android.common.AppFlow;
import me.lyft.android.common.DialogFlow;
import me.lyft.android.domain.payment.ChargeAccount;
import me.lyft.android.domain.payment.PayPalChargeAccount;
import me.lyft.android.ui.IProgressController;
import rx.Observable;

public class DebtPayPalListItemView
  extends DebtListItemView
{
  @Inject
  AppFlow appFlow;
  @Inject
  DialogFlow dialogFlow;
  @Inject
  IPaymentService paymentService;
  @Inject
  IProgressController progressController;
  
  public DebtPayPalListItemView(Context paramContext, PayPalChargeAccount paramPayPalChargeAccount, IPayDebtHandler paramIPayDebtHandler)
  {
    super(paramContext, paramPayPalChargeAccount, paramIPayDebtHandler);
  }
  
  private boolean isAddPayPal()
  {
    return getChargeAccount() == null;
  }
  
  private String resolveCardText()
  {
    ChargeAccount localChargeAccount = getChargeAccount();
    int i;
    if (isAddPayPal()) {
      i = 2131165522;
    }
    for (;;)
    {
      return getResources().getString(i);
      if (localChargeAccount.isFailed().booleanValue()) {
        i = 2131165533;
      } else {
        i = 2131165535;
      }
    }
  }
  
  protected int getIcon()
  {
    return 2130837654;
  }
  
  protected String getTitle()
  {
    return resolveCardText();
  }
  
  protected boolean isFailed()
  {
    if (isAddPayPal()) {
      return false;
    }
    return getChargeAccount().isFailed().booleanValue();
  }
  
  protected void onAttachedToWindow()
  {
    super.onAttachedToWindow();
  }
  
  public boolean performClick()
  {
    if ((isAddPayPal()) || (getChargeAccount().isFailed().booleanValue())) {}
    for (Observable localObservable = paymentService.savePayPal(null, null);; localObservable = paymentService.payDebtWithPayPal(getChargeAccount().getId()))
    {
      payDebtHandler.onPaymentMethodSelected(localObservable);
      return true;
    }
  }
}

/* Location:
 * Qualified Name:     me.lyft.android.ui.payment.DebtPayPalListItemView
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */