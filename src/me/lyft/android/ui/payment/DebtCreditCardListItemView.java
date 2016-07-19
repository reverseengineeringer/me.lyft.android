package me.lyft.android.ui.payment;

import android.content.Context;
import android.content.res.Resources;
import javax.inject.Inject;
import me.lyft.android.application.payment.IPaymentService;
import me.lyft.android.common.AppFlow;
import me.lyft.android.common.DialogFlow;
import me.lyft.android.domain.payment.ChargeAccount;
import me.lyft.android.domain.payment.CreditCardChargeAccount;
import me.lyft.android.ui.IProgressController;
import me.lyft.android.utils.CardExtensions;

public class DebtCreditCardListItemView
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
  
  public DebtCreditCardListItemView(Context paramContext, CreditCardChargeAccount paramCreditCardChargeAccount, IPayDebtHandler paramIPayDebtHandler)
  {
    super(paramContext, paramCreditCardChargeAccount, paramIPayDebtHandler);
  }
  
  private String getCardText(CreditCardChargeAccount paramCreditCardChargeAccount)
  {
    Resources localResources = getResources();
    if (paramCreditCardChargeAccount.isFailed().booleanValue()) {}
    for (int i = 2131165526;; i = 2131165527) {
      return localResources.getString(i, new Object[] { paramCreditCardChargeAccount.getLastFour() });
    }
  }
  
  private CreditCardChargeAccount getCreditCardChargeAccount()
  {
    return (CreditCardChargeAccount)getChargeAccount();
  }
  
  private void useChargeAccount(ChargeAccount paramChargeAccount)
  {
    payDebtHandler.onPaymentMethodSelected(paymentService.payDebtWithCreditCard(paramChargeAccount.getId()));
  }
  
  protected int getIcon()
  {
    return CardExtensions.getCardTypeImageResourceWithOutline(getCreditCardChargeAccount().getType());
  }
  
  protected String getTitle()
  {
    return getCardText(getCreditCardChargeAccount());
  }
  
  protected boolean isFailed()
  {
    return getChargeAccount().isFailed().booleanValue();
  }
  
  protected void onAttachedToWindow()
  {
    super.onAttachedToWindow();
  }
  
  public boolean performClick()
  {
    ChargeAccount localChargeAccount = getChargeAccount();
    if (localChargeAccount.isFailed().booleanValue()) {
      appFlow.goTo(new PaymentScreens.DebtAddChargeAccountScreen(localChargeAccount));
    }
    for (;;)
    {
      return true;
      useChargeAccount(localChargeAccount);
    }
  }
}

/* Location:
 * Qualified Name:     me.lyft.android.ui.payment.DebtCreditCardListItemView
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */