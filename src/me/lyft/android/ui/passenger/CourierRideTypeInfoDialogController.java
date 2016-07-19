package me.lyft.android.ui.passenger;

import android.content.res.Resources;
import android.widget.TextView;
import javax.inject.Inject;
import me.lyft.android.application.constants.Constants;
import me.lyft.android.application.constants.IConstantsProvider;
import me.lyft.android.application.cost.ICostService;
import me.lyft.android.common.DialogFlow;
import me.lyft.android.domain.cost.CostEstimate;
import me.lyft.android.domain.payment.Money;
import me.lyft.android.ui.dialogs.StandardDialogContainerController;

public class CourierRideTypeInfoDialogController
  extends StandardDialogContainerController
{
  private final IConstantsProvider constantsProvider;
  private final ICostService costService;
  TextView headerTextView;
  TextView priceGuaranteedMessageTextView;
  TextView priceGuaranteedTitleTextView;
  TextView ridePriceTextView;
  TextView smartlyRoutedMessageTextView;
  TextView smartlyRoutedTitleTextView;
  TextView titleTextView;
  
  @Inject
  public CourierRideTypeInfoDialogController(DialogFlow paramDialogFlow, IConstantsProvider paramIConstantsProvider, ICostService paramICostService)
  {
    super(paramDialogFlow);
    constantsProvider = paramIConstantsProvider;
    costService = paramICostService;
  }
  
  protected int layoutId()
  {
    return 2130903136;
  }
  
  public void onAttach()
  {
    int j = 0;
    super.onAttach();
    CostEstimate localCostEstimate = costService.getCostEstimate("lyft_line");
    boolean bool = localCostEstimate.hasPrice();
    TextView localTextView = headerTextView;
    if (bool)
    {
      i = 8;
      localTextView.setVisibility(i);
      localTextView = ridePriceTextView;
      if (!bool) {
        break label269;
      }
    }
    label269:
    for (int i = j;; i = 8)
    {
      localTextView.setVisibility(i);
      ridePriceTextView.setText(localCostEstimate.getEstimatedCostMin().format());
      titleTextView.setText((CharSequence)constantsProvider.get(Constants.COURIER_DIALOG_HEADER_TITLE, getResources().getString(2131165510)));
      headerTextView.setText((CharSequence)constantsProvider.get(Constants.COURIER_DIALOG_HEADER_MESSAGE, getResources().getString(2131165951)));
      smartlyRoutedTitleTextView.setText((CharSequence)constantsProvider.get(Constants.COURIER_DIALOG_INFO_TITLE_ONE, getResources().getString(2131165507)));
      smartlyRoutedMessageTextView.setText((CharSequence)constantsProvider.get(Constants.COURIER_DIALOG_INFO_MESSAGE_ONE, getResources().getString(2131165506)));
      priceGuaranteedTitleTextView.setText((CharSequence)constantsProvider.get(Constants.COURIER_DIALOG_INFO_TITLE_TWO, getResources().getString(2131165503)));
      priceGuaranteedMessageTextView.setText((CharSequence)constantsProvider.get(Constants.COURIER_DIALOG_INFO_MESSAGE_TWO, getResources().getString(2131165502)));
      return;
      i = 0;
      break;
    }
  }
}

/* Location:
 * Qualified Name:     me.lyft.android.ui.passenger.CourierRideTypeInfoDialogController
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */