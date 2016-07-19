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
import me.lyft.android.application.payment.IPaymentService;
import me.lyft.android.common.AppFlow;
import me.lyft.android.domain.payment.ChargeAccount;
import me.lyft.android.persistence.payment.IChargeAccountsProvider;
import me.lyft.android.rx.AsyncCall;
import me.lyft.android.rx.IRxBinder;
import me.lyft.android.rx.RxUIBinder;

public class PaymentCardListWidgetView
  extends LinearLayout
{
  private View addWalletView;
  @Inject
  AppFlow appFlow;
  private IRxBinder binder = new RxUIBinder();
  @Inject
  IChargeAccountsProvider chargeAccountsProvider;
  @Inject
  ICheckoutSession checkoutSession;
  @Inject
  IPaymentService paymentService;
  
  public PaymentCardListWidgetView(Context paramContext, AttributeSet paramAttributeSet)
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
    binder.bindAction(paymentService.observeWalletReadyToPay(), new PaymentCardListWidgetView.2(this));
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
      Object localObject = (ChargeAccount)paramList.next();
      localObject = PaymentListItemView.createEditChargeAccountListItem(Scoop.fromView(this).createContext(getContext()), (ChargeAccount)localObject);
      if (localObject != null) {
        addView((View)localObject);
      }
    }
  }
  
  protected void onAttachedToWindow()
  {
    super.onAttachedToWindow();
    binder.attach();
    binder.bindAsyncCall(paymentService.refreshChargeAccounts(), new AsyncCall());
    binder.bindAction(chargeAccountsProvider.observeChargeAccounts(), new PaymentCardListWidgetView.1(this));
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
 * Qualified Name:     me.lyft.android.ui.payment.PaymentCardListWidgetView
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */