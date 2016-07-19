package me.lyft.android.ui.payment;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.LinearLayout;
import butterknife.ButterKnife;
import com.lyft.scoop.Scoop;
import com.lyft.scoop.dagger.DaggerInjector;
import java.util.Iterator;
import java.util.List;
import javax.inject.Inject;
import me.lyft.android.application.checkout.ICheckoutSession;
import me.lyft.android.common.AppFlow;
import me.lyft.android.domain.payment.ChargeAccount;
import me.lyft.android.persistence.payment.IChargeAccountsProvider;
import me.lyft.android.rx.Binder;

public class PaymentBusinessDefaultsWidgetView
  extends LinearLayout
{
  @Inject
  AppFlow appFlow;
  private IChargeAccountSelectionListener businessDefaultListener = new PaymentBusinessDefaultsWidgetView.3(this);
  @Inject
  IChargeAccountsProvider chargeAccountsProvider;
  @Inject
  ICheckoutSession checkoutSession;
  private IChargeAccountSelectionListener personalDefaultListener = new PaymentBusinessDefaultsWidgetView.2(this);
  
  public PaymentBusinessDefaultsWidgetView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    DaggerInjector.fromView(this).inject(this);
    setOrientation(1);
  }
  
  protected void onAttachedToWindow()
  {
    super.onAttachedToWindow();
    Binder.attach(this).bind(chargeAccountsProvider.observeChargeAccounts(), new PaymentBusinessDefaultsWidgetView.1(this));
  }
  
  protected void onFinishInflate()
  {
    super.onFinishInflate();
    if (isInEditMode()) {
      return;
    }
    ButterKnife.bind(this);
  }
  
  public void refreshChargeAccounts(List<ChargeAccount> paramList)
  {
    removeAllViews();
    Object localObject = paramList.iterator();
    while (((Iterator)localObject).hasNext())
    {
      ChargeAccount localChargeAccount = (ChargeAccount)((Iterator)localObject).next();
      if (localChargeAccount.isDefault().booleanValue()) {
        addView(PaymentListItemView.createBusinessDefaultChargeAccountListItem(Scoop.fromView(this).createContext(getContext()), localChargeAccount, personalDefaultListener, 2130838121, 2131166094));
      }
    }
    paramList = paramList.iterator();
    while (paramList.hasNext())
    {
      localObject = (ChargeAccount)paramList.next();
      if (((ChargeAccount)localObject).isDefaultBusiness().booleanValue()) {
        addView(PaymentListItemView.createBusinessDefaultChargeAccountListItem(Scoop.fromView(this).createContext(getContext()), (ChargeAccount)localObject, businessDefaultListener, 2130838140, 2131166093));
      }
    }
  }
}

/* Location:
 * Qualified Name:     me.lyft.android.ui.payment.PaymentBusinessDefaultsWidgetView
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */