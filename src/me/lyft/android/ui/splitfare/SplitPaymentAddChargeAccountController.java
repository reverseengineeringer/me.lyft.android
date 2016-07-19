package me.lyft.android.ui.splitfare;

import javax.inject.Inject;
import me.lyft.android.common.AppFlow;
import me.lyft.android.common.RxViewController;
import me.lyft.android.persistence.splitfare.ISplitFareRequestRepository;
import me.lyft.android.rx.RxUIBinder;
import me.lyft.android.ui.payment.AddChargeAccountView;

public class SplitPaymentAddChargeAccountController
  extends RxViewController
{
  AddChargeAccountView addChargeAccountView;
  private final AppFlow appFlow;
  private final ISplitFareRequestRepository splitFareRequestRepository;
  
  @Inject
  public SplitPaymentAddChargeAccountController(AppFlow paramAppFlow, ISplitFareRequestRepository paramISplitFareRequestRepository)
  {
    appFlow = paramAppFlow;
    splitFareRequestRepository = paramISplitFareRequestRepository;
  }
  
  protected int layoutId()
  {
    return 2130903461;
  }
  
  public void onAttach()
  {
    super.onAttach();
    binder.bindAction(addChargeAccountView.observeSaveSuccess(), new SplitPaymentAddChargeAccountController.1(this));
  }
}

/* Location:
 * Qualified Name:     me.lyft.android.ui.splitfare.SplitPaymentAddChargeAccountController
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */