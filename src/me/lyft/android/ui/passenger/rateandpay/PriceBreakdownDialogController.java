package me.lyft.android.ui.passenger.rateandpay;

import android.content.res.Resources;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.lyft.scoop.Scoop;
import java.util.Iterator;
import java.util.List;
import javax.inject.Inject;
import me.lyft.android.application.checkout.ICheckoutSession;
import me.lyft.android.common.AppFlow;
import me.lyft.android.common.DialogFlow;
import me.lyft.android.domain.passenger.ride.PassengerRideReceipt;
import me.lyft.android.domain.passenger.ride.PriceBreakdownItem;
import me.lyft.android.domain.payment.Coupon;
import me.lyft.android.domain.payment.Money;
import me.lyft.android.domain.splitfare.SplitFareState;
import me.lyft.android.persistence.ride.IPassengerRideReceiptService;
import me.lyft.android.persistence.splitfare.ISplitFareStateRepository;
import me.lyft.android.ui.dialogs.StandardDialogContainerController;
import me.lyft.android.ui.passenger.PassengerScreens.PaymentHelpScreen;

public class PriceBreakdownDialogController
  extends StandardDialogContainerController
{
  private final AppFlow appFlow;
  View chargedLabel;
  private final ICheckoutSession checkoutSession;
  LinearLayout container;
  private final IPassengerRideReceiptService fareRepository;
  private final ISplitFareStateRepository splitFareStateRepository;
  TextView totalAmount;
  
  @Inject
  public PriceBreakdownDialogController(IPassengerRideReceiptService paramIPassengerRideReceiptService, ISplitFareStateRepository paramISplitFareStateRepository, DialogFlow paramDialogFlow, AppFlow paramAppFlow, ICheckoutSession paramICheckoutSession)
  {
    super(paramDialogFlow);
    fareRepository = paramIPassengerRideReceiptService;
    splitFareStateRepository = paramISplitFareStateRepository;
    appFlow = paramAppFlow;
    checkoutSession = paramICheckoutSession;
  }
  
  private void addPriceBreakdownItem(String paramString1, String paramString2)
  {
    ViewGroup localViewGroup = (ViewGroup)Scoop.fromView(getView()).inflate(2130903398, container, false);
    ((TextView)localViewGroup.getChildAt(0)).setText(paramString1);
    ((TextView)localViewGroup.getChildAt(1)).setText(paramString2);
    container.addView(localViewGroup);
  }
  
  protected int layoutId()
  {
    return 2130903396;
  }
  
  public void onAttach()
  {
    super.onAttach();
    int k = checkoutSession.getSelectedTipAmount();
    if (checkoutSession.isBusinessProfile()) {}
    PassengerRideReceipt localPassengerRideReceipt;
    int m;
    int i;
    Object localObject;
    for (Coupon localCoupon = checkoutSession.getSelectedCoupon();; localCoupon = checkoutSession.getSelectedOrFirstEligibleCoupon())
    {
      localPassengerRideReceipt = fareRepository.getRideReceipt();
      m = splitFareStateRepository.getSplitFareState().getTotalContributorsCount();
      i = 0;
      localObject = localPassengerRideReceipt.getPriceBreakdownItems().iterator();
      while (((Iterator)localObject).hasNext())
      {
        PriceBreakdownItem localPriceBreakdownItem = (PriceBreakdownItem)((Iterator)localObject).next();
        j = (int)Math.ceil(localPriceBreakdownItem.getMoney().getAmount().intValue() / m);
        addPriceBreakdownItem(localPriceBreakdownItem.getTitle(), Money.format(j));
        i += j;
      }
    }
    int j = i;
    if (localCoupon != null)
    {
      localObject = localCoupon.getMoney();
      j = i;
      if (((Money)localObject).getAmount().intValue() > 0)
      {
        j = Math.min((int)Math.ceil(localPassengerRideReceipt.getTotalMoney().getAmount().intValue() / m), ((Money)localObject).getAmount().intValue());
        addPriceBreakdownItem(localCoupon.getLineItemTitle(), Money.format(-j));
        j = i - j;
      }
    }
    if (k != 0)
    {
      i = (int)Math.ceil(k / m);
      chargedLabel.setVisibility(0);
      addPriceBreakdownItem(getResources().getString(2131166205), Money.format(i));
      j += i;
    }
    for (;;)
    {
      totalAmount.setText(Money.format(j));
      return;
      chargedLabel.setVisibility(8);
    }
  }
  
  void onPricingInfoClicked()
  {
    dismissDialog();
    appFlow.goTo(new PassengerScreens.PaymentHelpScreen());
  }
}

/* Location:
 * Qualified Name:     me.lyft.android.ui.passenger.rateandpay.PriceBreakdownDialogController
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */