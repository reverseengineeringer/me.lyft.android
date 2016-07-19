package me.lyft.android.ui.passenger.rateandpay;

import android.content.res.Resources;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import javax.inject.Inject;
import me.lyft.android.application.checkout.ICheckoutSession;
import me.lyft.android.common.DialogFlow;
import me.lyft.android.domain.passenger.ride.PassengerRideReceipt;
import me.lyft.android.domain.payment.Money;
import me.lyft.android.persistence.ride.IPassengerRideReceiptService;
import me.lyft.android.ui.dialogs.StandardDialogController;

public class TipDialogController
  extends StandardDialogController
{
  private static final int MIN_TIP_AMOUNT = 0;
  private static final int TIP_INCREMENTATION_AMOUNT = 100;
  private final ICheckoutSession checkoutSession;
  private Button decrementDonationButton;
  private Button incrementDonationButton;
  private int maxTipAmount;
  private final IPassengerRideReceiptService rideFareRepository;
  private int rideTotal;
  private int tip;
  private TextView tipAmountTextView;
  private TextView totalText;
  
  @Inject
  public TipDialogController(DialogFlow paramDialogFlow, ICheckoutSession paramICheckoutSession, IPassengerRideReceiptService paramIPassengerRideReceiptService)
  {
    super(paramDialogFlow);
    checkoutSession = paramICheckoutSession;
    rideFareRepository = paramIPassengerRideReceiptService;
  }
  
  private void decrementDonation()
  {
    setTip(tip - 100);
    updateTipAndTotalText();
  }
  
  private int getMaxTotalAmount()
  {
    Money localMoney = rideFareRepository.getRideReceipt().getMaximumTotalMoney();
    if (localMoney.isNull()) {
      return Integer.MAX_VALUE;
    }
    return localMoney.getAmount().intValue();
  }
  
  private void incrementDonation()
  {
    setTip(tip + 100);
    updateTipAndTotalText();
  }
  
  private void initTipAmount()
  {
    rideTotal = rideFareRepository.getRideReceipt().getTotalMoney().getAmount().intValue();
    maxTipAmount = (getMaxTotalAmount() - rideTotal);
    setTip(checkoutSession.getSelectedTipAmount());
  }
  
  private void setTip(int paramInt)
  {
    tip = paramInt;
    if (tip < 0) {
      tip = 0;
    }
    while (tip <= maxTipAmount) {
      return;
    }
    tip = maxTipAmount;
  }
  
  private void setupButtons()
  {
    addPositiveButton(2130903152, getResources().getString(2131165939), new TipDialogController.3(this));
  }
  
  private void setupHeader()
  {
    View localView = addHeaderLayout(2130903142);
    incrementDonationButton = ((Button)localView.findViewById(2131558896));
    incrementDonationButton.setOnClickListener(new TipDialogController.1(this));
    decrementDonationButton = ((Button)localView.findViewById(2131558894));
    decrementDonationButton.setOnClickListener(new TipDialogController.2(this));
    tipAmountTextView = ((TextView)localView.findViewById(2131558895));
    totalText = ((TextView)localView.findViewById(2131558897));
  }
  
  private void updateTipAndTotalText()
  {
    float f2 = 1.0F;
    tipAmountTextView.setText(Money.format(tip));
    totalText.setText(getResources().getString(2131166373, new Object[] { Money.format(tip + rideTotal) }));
    boolean bool;
    Button localButton;
    if (tip > 0)
    {
      bool = true;
      decrementDonationButton.setEnabled(bool);
      localButton = decrementDonationButton;
      if (!bool) {
        break label131;
      }
      f1 = 1.0F;
      label80:
      localButton.setAlpha(f1);
      if (tip >= maxTipAmount) {
        break label137;
      }
      bool = true;
      label99:
      incrementDonationButton.setEnabled(bool);
      localButton = incrementDonationButton;
      if (!bool) {
        break label142;
      }
    }
    label131:
    label137:
    label142:
    for (float f1 = f2;; f1 = 0.5F)
    {
      localButton.setAlpha(f1);
      return;
      bool = false;
      break;
      f1 = 0.5F;
      break label80;
      bool = false;
      break label99;
    }
  }
  
  public void onAttach()
  {
    super.onAttach();
    initTipAmount();
    setupHeader();
    setupButtons();
    updateTipAndTotalText();
  }
}

/* Location:
 * Qualified Name:     me.lyft.android.ui.passenger.rateandpay.TipDialogController
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */