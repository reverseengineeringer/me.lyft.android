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
import me.lyft.android.domain.payment.Credit;
import me.lyft.android.rx.Binder;

public class PaymentCreditsListWidgetView
  extends LinearLayout
{
  private Binder binder;
  @Inject
  ICheckoutSession checkoutSession;
  @Inject
  ICouponService couponService;
  
  public PaymentCreditsListWidgetView(Context paramContext, AttributeSet paramAttributeSet)
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
      Object localObject = (Credit)paramList.next();
      localObject = PaymentListItemView.createCreditListItem(Scoop.fromView(this).createContext(getContext()), (Credit)localObject);
      if (localObject != null) {
        addView((View)localObject);
      }
    }
  }
  
  protected void onAttachedToWindow()
  {
    super.onAttachedToWindow();
    binder = Binder.attach(this);
    binder.bind(couponService.observeCredits(), new PaymentCreditsListWidgetView.1(this));
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
 * Qualified Name:     me.lyft.android.ui.payment.PaymentCreditsListWidgetView
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */