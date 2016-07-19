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
import me.lyft.android.application.payment.ICouponService;
import me.lyft.android.domain.payment.Credit;
import me.lyft.android.rx.Binder;

public class PaymentSelectableCreditsListWidgetView
  extends LinearLayout
{
  private Binder binder;
  @Inject
  ICheckoutSession checkoutSession;
  @Inject
  ICouponService couponService;
  
  public PaymentSelectableCreditsListWidgetView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    DaggerInjector.fromView(this).inject(this);
    setOrientation(1);
  }
  
  private void refreshCoupons(List<Credit> paramList)
  {
    removeAllViews();
    paramList = paramList.iterator();
    while (paramList.hasNext())
    {
      Credit localCredit = (Credit)paramList.next();
      PaymentListItemView localPaymentListItemView = PaymentListItemView.createSelectableCreditListItem(Scoop.fromView(this).createContext(getContext()), localCredit);
      if (localPaymentListItemView != null)
      {
        if (localCredit.getId().equals(checkoutSession.getSelectedPaymentMethodId())) {
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
    binder.bind(couponService.observeCredits(), new PaymentSelectableCreditsListWidgetView.1(this));
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
 * Qualified Name:     me.lyft.android.ui.payment.PaymentSelectableCreditsListWidgetView
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */