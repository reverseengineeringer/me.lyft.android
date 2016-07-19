package me.lyft.android.ui.passenger;

import android.content.res.Resources;
import com.lyft.rx.MessageBus;
import java.util.Iterator;
import java.util.List;
import javax.inject.Inject;
import me.lyft.android.application.constants.Constants;
import me.lyft.android.application.constants.IConstantsProvider;
import me.lyft.android.application.cost.ICostService;
import me.lyft.android.application.ride.IRideRequestSession;
import me.lyft.android.common.DialogFlow;
import me.lyft.android.common.Strings;
import me.lyft.android.common.Unit;
import me.lyft.android.domain.cost.CostEstimate;
import me.lyft.android.domain.passenger.ridetypes.RequestRideType;
import me.lyft.android.domain.payment.Money;
import me.lyft.android.ui.dialogs.StandardDialogController;

public class PartySizePickerDialogController
  extends StandardDialogController
{
  private final MessageBus bus;
  private final IConstantsProvider constantsProvider;
  private List<CostEstimate> costEstimates;
  private final ICostService costService;
  private final DialogFlow dialogFlow;
  private final IRideRequestSession rideRequestSession;
  
  @Inject
  public PartySizePickerDialogController(MessageBus paramMessageBus, IConstantsProvider paramIConstantsProvider, DialogFlow paramDialogFlow, IRideRequestSession paramIRideRequestSession, ICostService paramICostService)
  {
    super(paramDialogFlow);
    bus = paramMessageBus;
    constantsProvider = paramIConstantsProvider;
    dialogFlow = paramDialogFlow;
    rideRequestSession = paramIRideRequestSession;
    costService = paramICostService;
  }
  
  private void postResult(CostEstimate paramCostEstimate, int paramInt)
  {
    dialogFlow.dismiss();
    rideRequestSession.setPartySize(paramInt);
    rideRequestSession.setCostEstimate(paramCostEstimate);
    bus.post(PartySizePickerDialogController.SelectNumberOfPassengersResultEvent.class, Unit.create());
  }
  
  private void setPartySizeButton(CostEstimate paramCostEstimate, int paramInt)
  {
    String str1 = null;
    if (!paramCostEstimate.isNull()) {
      str1 = paramCostEstimate.getEstimatedCostMin().format();
    }
    String str2 = getResources().getQuantityString(2131689474, paramInt, new Object[] { Integer.valueOf(paramInt) });
    if (!Strings.isNullOrEmpty(str1)) {
      str2 = getResources().getQuantityString(2131689475, paramInt, new Object[] { Integer.valueOf(paramInt), str1 });
    }
    addPositiveButton(2130903156, str2, new PartySizePickerDialogController.1(this, paramCostEstimate, paramInt));
  }
  
  public void onAttach()
  {
    super.onAttach();
    costEstimates = costService.getCostEstimates(rideRequestSession.getCurrentRideType().getPublicId());
    setContentTitle((String)constantsProvider.get(Constants.PARTY_SIZE_CONFIRMATION_TITLE, getResources().getString(2131165505)));
    setContentMessage((CharSequence)constantsProvider.get(Constants.PARTY_SIZE_CONFIRMATION_MESSAGE, getResources().getString(2131165504)));
    if (costEstimates.size() > 1)
    {
      Iterator localIterator = costEstimates.iterator();
      while (localIterator.hasNext())
      {
        CostEstimate localCostEstimate = (CostEstimate)localIterator.next();
        setPartySizeButton(localCostEstimate, localCostEstimate.getSeats());
      }
    }
    int i = 0;
    while (i < 2)
    {
      setPartySizeButton(CostEstimate.empty(), i + 1);
      i += 1;
    }
    addNegativeButton(2130903152, getResources().getString(2131165358), getDismissListener());
  }
  
  protected int viewId()
  {
    return 2131558426;
  }
}

/* Location:
 * Qualified Name:     me.lyft.android.ui.passenger.PartySizePickerDialogController
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */