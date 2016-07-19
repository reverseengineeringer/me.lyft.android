package me.lyft.android.ui.payment;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.LinearLayout;
import butterknife.ButterKnife;
import com.lyft.scoop.Scoop;
import com.lyft.scoop.dagger.DaggerInjector;
import java.util.Iterator;
import java.util.List;
import javax.inject.Inject;
import me.lyft.android.application.checkout.ICheckoutSession;
import me.lyft.android.application.payment.ICouponService;
import me.lyft.android.application.payment.IPaymentService;
import me.lyft.android.common.DialogFlow;
import me.lyft.android.domain.payment.ChargeAccount;
import me.lyft.android.domain.payment.Credit;
import me.lyft.android.persistence.payment.IChargeAccountsProvider;
import me.lyft.android.rx.AsyncCall;
import me.lyft.android.rx.RxUIBinder;
import me.lyft.android.ui.MainScreensRouter;
import rx.Observable;
import rx.functions.Func2;

public class PaymentSelectableCardListWidgetView
  extends LinearLayout
{
  private View addWalletView;
  private RxUIBinder binder = new RxUIBinder();
  private IChargeAccountSelectionListener chargeAccountCheckoutSelectionListener = new PaymentSelectableCardListWidgetView.3(this);
  @Inject
  IChargeAccountsProvider chargeAccountsProvider;
  @Inject
  ICheckoutSession checkoutSession;
  @Inject
  ICouponService couponService;
  @Inject
  DialogFlow dialogFlow;
  @Inject
  MainScreensRouter mainScreensRouter;
  private Func2<List<Credit>, List<ChargeAccount>, List<ChargeAccount>> mergeCreditsAndChargeAccountsChanges;
  @Inject
  IPaymentService paymentService;
  
  public PaymentSelectableCardListWidgetView(Context paramContext, AttributeSet paramAttributeSet)
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
    binder.bindAction(paymentService.observeWalletReadyToPay(), new PaymentSelectableCardListWidgetView.4(this));
  }
  
  private void refreshChargeAccounts(List<ChargeAccount> paramList)
  {
    removeAllViews();
    if (!chargeAccountsProvider.hasWalletCard()) {
      insertAddWalletPaymentItem();
    }
    if (!chargeAccountsProvider.hasPayPalChargeAccount()) {
      addView(new AddPayPalPaymentItemView(getContext(), false, false));
    }
    paramList = paramList.iterator();
    while (paramList.hasNext())
    {
      ChargeAccount localChargeAccount = (ChargeAccount)paramList.next();
      PaymentListItemView localPaymentListItemView = PaymentListItemView.createSelectableChargeAccountListItem(Scoop.fromView(this).createContext(getContext()), localChargeAccount, chargeAccountCheckoutSelectionListener);
      if (localPaymentListItemView != null)
      {
        if (localChargeAccount.getId().equals(checkoutSession.getSelectedPaymentMethodId())) {
          localPaymentListItemView.select();
        }
        addView(localPaymentListItemView);
      }
    }
  }
  
  protected void onAttachedToWindow()
  {
    super.onAttachedToWindow();
    binder.attach();
    binder.bindAsyncCall(paymentService.refreshChargeAccounts(), new AsyncCall());
    mergeCreditsAndChargeAccountsChanges = new PaymentSelectableCardListWidgetView.1(this);
    binder.bindAction(Observable.combineLatest(couponService.observeCredits(), chargeAccountsProvider.observeChargeAccounts(), mergeCreditsAndChargeAccountsChanges), new PaymentSelectableCardListWidgetView.2(this));
  }
  
  protected void onDetachedFromWindow()
  {
    super.onDetachedFromWindow();
    binder.detach();
  }
  
  protected void onFinishInflate()
  {
    super.onFinishInflate();
    if (isInEditMode()) {
      return;
    }
    ButterKnife.bind(this);
  }
}

/* Location:
 * Qualified Name:     me.lyft.android.ui.payment.PaymentSelectableCardListWidgetView
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */