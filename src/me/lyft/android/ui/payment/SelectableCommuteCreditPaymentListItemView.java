package me.lyft.android.ui.payment;

import android.content.Context;
import com.lyft.scoop.dagger.DaggerInjector;
import javax.inject.Inject;
import me.lyft.android.application.checkout.ICheckoutSession;
import me.lyft.android.domain.payment.Credit;
import me.lyft.android.ui.MainScreensRouter;

public class SelectableCommuteCreditPaymentListItemView
  extends CouponPaymentListItemView
{
  @Inject
  MainScreensRouter mainScreensRouter;
  
  public SelectableCommuteCreditPaymentListItemView(Context paramContext, Credit paramCredit)
  {
    super(paramContext, paramCredit);
    DaggerInjector.fromView(this).inject(this);
  }
  
  public boolean performClick()
  {
    if ((credit.isValid()) && (checkoutSession.selectCoupon(credit.getId())))
    {
      mainScreensRouter.resetToHomeScreen();
      return true;
    }
    showInvalidCreditDialog();
    return true;
  }
}

/* Location:
 * Qualified Name:     me.lyft.android.ui.payment.SelectableCommuteCreditPaymentListItemView
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */