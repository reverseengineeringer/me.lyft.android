package me.lyft.android.ui.payment;

import android.content.Context;
import android.content.res.Resources;
import android.widget.TextView;
import com.lyft.scoop.dagger.DaggerInjector;
import javax.inject.Inject;
import me.lyft.android.application.checkout.ICheckoutSession;
import me.lyft.android.domain.passenger.ride.PassengerRideReceipt;
import me.lyft.android.domain.payment.Credit;
import me.lyft.android.persistence.ride.IPassengerRideReceiptService;
import me.lyft.android.ui.MainScreensRouter;

public class SelectableLyftCreditPaymentListItemView
  extends CouponPaymentListItemView
{
  private final Credit credit;
  @Inject
  MainScreensRouter mainScreensRouter;
  
  public SelectableLyftCreditPaymentListItemView(Context paramContext, Credit paramCredit)
  {
    super(paramContext, paramCredit);
    DaggerInjector.fromView(this).inject(this);
    credit = paramCredit;
  }
  
  protected void onAttachedToWindow()
  {
    super.onAttachedToWindow();
    if (!fareRepository.getRideReceipt().isCouponAvailableForRide(credit.getId()))
    {
      int i = getResources().getColor(2131493054);
      titleTextView.setTextColor(i);
      subtitleTextView.setTextColor(i);
    }
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
 * Qualified Name:     me.lyft.android.ui.payment.SelectableLyftCreditPaymentListItemView
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */