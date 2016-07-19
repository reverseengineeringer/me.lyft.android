package me.lyft.android.ui.payment;

import android.content.Context;
import android.content.res.Resources;
import android.util.AttributeSet;
import android.view.View;
import com.lyft.rx.MessageBus;
import com.lyft.scoop.Screen;
import javax.inject.Inject;
import me.lyft.android.application.payment.IPaymentService;
import me.lyft.android.common.DialogFlow;
import me.lyft.android.common.Preconditions;
import me.lyft.android.common.Unit;
import me.lyft.android.domain.payment.CreditCardChargeAccount;
import me.lyft.android.domain.payment.ICard;
import me.lyft.android.persistence.payment.IChargeAccountsProvider;
import me.lyft.android.rx.Binder;
import me.lyft.android.ui.Dialogs.AlertDialog;
import me.lyft.android.ui.IProgressController;
import me.lyft.android.ui.dialogs.DialogResult;
import me.lyft.android.ui.payment.cardinput.CreditCardInput;
import rx.Observable;
import rx.functions.Action1;

public class EditCreditCardView
  extends BaseCreditCardView
{
  @Inject
  IChargeAccountsProvider chargeAccountsProvider;
  View deleteCardButton;
  private Action1<DialogResult> onDeleteCreditCardDialogResult = new EditCreditCardView.2(this);
  
  public EditCreditCardView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
  }
  
  private void deleteCard()
  {
    progressController.showProgress();
    binder.bind(paymentService.deleteChargeAccount(getChargeAccountId(), "credit_card"), createResponseHandler());
  }
  
  private String getChargeAccountId()
  {
    return getCreditCardChargeAccount().getId();
  }
  
  private CreditCardChargeAccount getCreditCardChargeAccount()
  {
    return ((PaymentScreens.EditCreditCardScreen)getScreen()).getChargeAccount();
  }
  
  private void initData()
  {
    CreditCardChargeAccount localCreditCardChargeAccount = getCreditCardChargeAccount();
    Preconditions.checkNotNull(localCreditCardChargeAccount);
    View localView = deleteCardButton;
    if (chargeAccountsProvider.hasLessThanTwoPaymentMethods()) {}
    for (int i = 8;; i = 0)
    {
      localView.setVisibility(i);
      creditCardInput.setExistingCard(localCreditCardChargeAccount.getLastFour(), localCreditCardChargeAccount.getType(), localCreditCardChargeAccount.isFailed().booleanValue());
      return;
    }
  }
  
  private void onDeleteCardClicked()
  {
    Object localObject = getCreditCardChargeAccount();
    localObject = getResources().getString(2131166048, new Object[] { ((CreditCardChargeAccount)localObject).getType(), ((CreditCardChargeAccount)localObject).getLastFour() });
    localObject = new Dialogs.AlertDialog("delete_card_confirmation_dialog").setTitle(getResources().getString(2131166049)).setMessage((String)localObject).addNegativeButton(getResources().getString(2131165358)).addPositiveButton(getResources().getString(2131165544), 2130903157).setDialogEventClass(EditCreditCardView.DeleteChargeAccountDialogResultEvent.class);
    dialogFlow.show((Screen)localObject);
  }
  
  protected int getToolbarTitleResource()
  {
    return 2131166060;
  }
  
  protected void onAttachedToWindow()
  {
    super.onAttachedToWindow();
    initData();
    binder.bind(bus.observe(EditCreditCardView.DeleteChargeAccountDialogResultEvent.class), onDeleteCreditCardDialogResult);
  }
  
  protected void onFinishInflate()
  {
    super.onFinishInflate();
    deleteCardButton.setOnClickListener(new EditCreditCardView.1(this));
  }
  
  protected Observable<Unit> saveCardRequest(ICard paramICard)
  {
    return paymentService.updateCreditCard(getChargeAccountId(), paramICard);
  }
}

/* Location:
 * Qualified Name:     me.lyft.android.ui.payment.EditCreditCardView
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */