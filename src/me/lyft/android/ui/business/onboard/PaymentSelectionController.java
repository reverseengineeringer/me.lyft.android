package me.lyft.android.ui.business.onboard;

import android.content.Context;
import android.content.res.Resources;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import com.lyft.scoop.Scoop;
import java.util.Iterator;
import java.util.List;
import javax.inject.Inject;
import me.lyft.android.application.IUserProvider;
import me.lyft.android.application.business.BusinessOnboardingAnalytics;
import me.lyft.android.application.payment.IPaymentService;
import me.lyft.android.common.AppFlow;
import me.lyft.android.common.DialogFlow;
import me.lyft.android.common.RxViewController;
import me.lyft.android.controls.Toolbar;
import me.lyft.android.domain.payment.ChargeAccount;
import me.lyft.android.persistence.payment.IChargeAccountsProvider;
import me.lyft.android.rx.RxUIBinder;
import me.lyft.android.ui.Dialogs.AlertDialog;
import me.lyft.android.ui.IProgressController;
import me.lyft.android.ui.payment.AddCreditCardPaymentItemView;
import me.lyft.android.ui.payment.AddPayPalPaymentItemView;
import me.lyft.android.ui.payment.AddWalletCardPaymentItemView;
import me.lyft.android.ui.payment.IChargeAccountSelectionListener;
import me.lyft.android.ui.payment.PaymentListItemView;

public class PaymentSelectionController
  extends RxViewController
{
  LinearLayout addCard;
  LinearLayout addPaymentLayout;
  private View addWalletView;
  private final AppFlow appFlow;
  private final BusinessOnboardingAnalytics businessOnboardingAnalytics;
  private IChargeAccountSelectionListener chargeAccountDefaultSelectionListener = new PaymentSelectionController.3(this);
  private final IChargeAccountsProvider chargeAccountsProvider;
  private final DialogFlow dialogFlow;
  ViewGroup paymentCardListWidgetView;
  private final IPaymentService paymentService;
  private final IProgressController progressController;
  Toolbar toolbar;
  private final IUserProvider userProvider;
  
  @Inject
  public PaymentSelectionController(IChargeAccountsProvider paramIChargeAccountsProvider, IPaymentService paramIPaymentService, IProgressController paramIProgressController, IUserProvider paramIUserProvider, AppFlow paramAppFlow, DialogFlow paramDialogFlow, BusinessOnboardingAnalytics paramBusinessOnboardingAnalytics)
  {
    chargeAccountsProvider = paramIChargeAccountsProvider;
    paymentService = paramIPaymentService;
    progressController = paramIProgressController;
    userProvider = paramIUserProvider;
    appFlow = paramAppFlow;
    dialogFlow = paramDialogFlow;
    businessOnboardingAnalytics = paramBusinessOnboardingAnalytics;
  }
  
  private void insertAddWalletPaymentItem()
  {
    if (addWalletView == null) {
      addWalletView = new AddWalletCardPaymentItemView(getView().getContext());
    }
    binder.bindAction(paymentService.observeWalletReadyToPay(), new PaymentSelectionController.4(this));
  }
  
  private void refreshChargeAccounts(List<ChargeAccount> paramList)
  {
    paymentCardListWidgetView.removeAllViews();
    if (!chargeAccountsProvider.hasWalletCard()) {
      insertAddWalletPaymentItem();
    }
    if (!chargeAccountsProvider.hasPayPalChargeAccount()) {
      paymentCardListWidgetView.addView(new AddPayPalPaymentItemView(getView().getContext(), true, true));
    }
    paramList = paramList.iterator();
    while (paramList.hasNext())
    {
      ChargeAccount localChargeAccount = (ChargeAccount)paramList.next();
      PaymentListItemView localPaymentListItemView = PaymentListItemView.createSelectableChargeAccountListItem(getScoop().createContext(getView().getContext()), localChargeAccount, chargeAccountDefaultSelectionListener);
      if (localPaymentListItemView != null)
      {
        if (localChargeAccount.isDefaultBusiness().booleanValue())
        {
          toolbar.enableItem(2131558445);
          localPaymentListItemView.select();
        }
        paymentCardListWidgetView.addView(localPaymentListItemView);
      }
    }
  }
  
  protected int layoutId()
  {
    return 2130903071;
  }
  
  public void onAttach()
  {
    super.onAttach();
    Object localObject = getView().getContext();
    toolbar.showTitle().setTitle(((Context)localObject).getString(2131166093));
    toolbar.addItem(2131558445, ((Context)localObject).getString(2131165934).toUpperCase());
    toolbar.disableItem(2131558445);
    LinearLayout localLinearLayout = addPaymentLayout;
    if (chargeAccountsProvider.hasMaximumCreditCardsAmount()) {}
    for (int i = 8;; i = 0)
    {
      localLinearLayout.setVisibility(i);
      if (!chargeAccountsProvider.hasMaximumCreditCardsAmount())
      {
        localObject = new AddCreditCardPaymentItemView((Context)localObject, true, true);
        addCard.addView((View)localObject);
      }
      binder.bindAction(toolbar.observeItemClick(), new PaymentSelectionController.1(this));
      binder.bindAction(chargeAccountsProvider.observeChargeAccounts(), new PaymentSelectionController.2(this));
      return;
    }
  }
  
  public void showInvalidChargeAccountDialog()
  {
    Dialogs.AlertDialog localAlertDialog = new Dialogs.AlertDialog("invalid_card_dialog").setTitle(getResources().getString(2131166055)).setMessage(getResources().getString(2131166054)).addPositiveButton(getResources().getString(2131165939));
    dialogFlow.show(localAlertDialog);
  }
}

/* Location:
 * Qualified Name:     me.lyft.android.ui.business.onboard.PaymentSelectionController
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */