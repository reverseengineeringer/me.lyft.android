package me.lyft.android.ui.payment;

import android.content.Context;
import android.content.res.Resources;
import android.util.AttributeSet;
import android.view.View;
import android.widget.LinearLayout;
import butterknife.ButterKnife;
import com.lyft.scoop.Scoop;
import com.lyft.scoop.dagger.DaggerInjector;
import java.util.Iterator;
import java.util.List;
import javax.inject.Inject;
import me.lyft.android.application.IUserProvider;
import me.lyft.android.application.checkout.ICheckoutSession;
import me.lyft.android.application.payment.IPaymentService;
import me.lyft.android.common.AppFlow;
import me.lyft.android.common.DialogFlow;
import me.lyft.android.domain.User;
import me.lyft.android.domain.payment.ChargeAccount;
import me.lyft.android.persistence.payment.IChargeAccountsProvider;
import me.lyft.android.rx.AsyncCall;
import me.lyft.android.rx.Binder;
import me.lyft.android.ui.Dialogs.AlertDialog;
import me.lyft.android.ui.IProgressController;

public class PaymentDefaultCardListWidgetView
  extends LinearLayout
{
  private View addWalletView;
  @Inject
  AppFlow appFlow;
  private Binder binder;
  private IChargeAccountSelectionListener chargeAccountDefaultSelectionListener = new PaymentDefaultCardListWidgetView.2(this);
  @Inject
  IChargeAccountsProvider chargeAccountsProvider;
  @Inject
  ICheckoutSession checkoutSession;
  @Inject
  DialogFlow dialogFlow;
  @Inject
  IPaymentService paymentService;
  @Inject
  IProgressController progressController;
  @Inject
  IUserProvider userProvider;
  
  public PaymentDefaultCardListWidgetView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    DaggerInjector.fromView(this).inject(this);
    setOrientation(1);
  }
  
  private void insertAddWalletPaymentItem()
  {
    if (addWalletView == null) {
      addWalletView = new AddWalletCardPaymentItemView(getContext());
    }
    binder.bind(paymentService.observeWalletReadyToPay(), new PaymentDefaultCardListWidgetView.3(this));
  }
  
  private boolean isBusinessProfile()
  {
    return (userProvider.getUser().hasBusinessProfile()) && (checkoutSession.isBusinessProfile());
  }
  
  private void refreshChargeAccounts(List<ChargeAccount> paramList)
  {
    removeAllViews();
    if (!chargeAccountsProvider.hasWalletCard()) {
      insertAddWalletPaymentItem();
    }
    if (!chargeAccountsProvider.hasPayPalChargeAccount()) {
      addView(new AddPayPalPaymentItemView(getContext(), true, isBusinessProfile()));
    }
    paramList = paramList.iterator();
    while (paramList.hasNext())
    {
      ChargeAccount localChargeAccount = (ChargeAccount)paramList.next();
      PaymentListItemView localPaymentListItemView = PaymentListItemView.createSelectableChargeAccountListItem(Scoop.fromView(this).createContext(getContext()), localChargeAccount, chargeAccountDefaultSelectionListener);
      if (localPaymentListItemView != null)
      {
        if (((localChargeAccount.isDefaultBusiness().booleanValue()) && (isBusinessProfile())) || ((localChargeAccount.isDefault().booleanValue()) && (!isBusinessProfile()))) {
          localPaymentListItemView.select();
        }
        addView(localPaymentListItemView);
      }
    }
  }
  
  protected void onAttachedToWindow()
  {
    super.onAttachedToWindow();
    binder = Binder.attach(this);
    binder.bind(paymentService.refreshChargeAccounts(), new AsyncCall());
    binder.bind(chargeAccountsProvider.observeChargeAccounts(), new PaymentDefaultCardListWidgetView.1(this));
  }
  
  protected void onFinishInflate()
  {
    super.onFinishInflate();
    if (isInEditMode()) {
      return;
    }
    ButterKnife.bind(this);
  }
  
  public void showInvalidChargeAccountDialog()
  {
    Dialogs.AlertDialog localAlertDialog = new Dialogs.AlertDialog("invalid_card_dialog").setTitle(getResources().getString(2131166055)).setMessage(getResources().getString(2131166054)).addPositiveButton(getResources().getString(2131165939));
    dialogFlow.show(localAlertDialog);
  }
}

/* Location:
 * Qualified Name:     me.lyft.android.ui.payment.PaymentDefaultCardListWidgetView
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */