package me.lyft.android.ui.payment;

import android.content.Context;
import android.content.res.Resources;
import android.util.AttributeSet;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;
import butterknife.ButterKnife;
import com.lyft.rx.MessageBus;
import com.lyft.scoop.Screen;
import com.lyft.scoop.dagger.DaggerInjector;
import com.lyft.widgets.Toggle;
import javax.inject.Inject;
import me.lyft.android.application.IUserProvider;
import me.lyft.android.application.payment.IPaymentService;
import me.lyft.android.application.ride.IExpenseNoteSession;
import me.lyft.android.common.AppFlow;
import me.lyft.android.common.DialogFlow;
import me.lyft.android.controls.Toolbar;
import me.lyft.android.domain.User;
import me.lyft.android.rx.Binder;
import me.lyft.android.ui.Dialogs.AlertDialog;
import me.lyft.android.ui.IProgressController;
import me.lyft.android.ui.IViewErrorHandler;

public class ConcurSendRideReceiptsView
  extends LinearLayout
{
  @Inject
  AppFlow appFlow;
  private Binder binder;
  @Inject
  MessageBus bus;
  @Inject
  DialogFlow dialogFlow;
  @Inject
  IExpenseNoteSession expenseNoteSession;
  private PaymentScreens.ConcurSendRideReceiptsScreen params;
  @Inject
  IPaymentService paymentService;
  @Inject
  IProgressController progressController;
  TextView sendToConcurDescription;
  Toggle sendToConcurToggle;
  Toolbar toolbar;
  Button unlinkConcurButton;
  @Inject
  IUserProvider userProvider;
  @Inject
  IViewErrorHandler viewErrorHandler;
  
  public ConcurSendRideReceiptsView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    DaggerInjector.fromView(this).inject(this);
    params = ((PaymentScreens.ConcurSendRideReceiptsScreen)Screen.fromView(this));
  }
  
  private boolean sendConcurRideReceipts()
  {
    return (params.sendConcurRideReceipts()) || (userProvider.getUser().sendConcurRideReceipts());
  }
  
  private void setSendToConcurDescription()
  {
    TextView localTextView = sendToConcurDescription;
    if (sendConcurRideReceipts()) {}
    for (int i = 0;; i = 8)
    {
      localTextView.setVisibility(i);
      return;
    }
  }
  
  private void showUnlinkConcurDialog()
  {
    Dialogs.AlertDialog localAlertDialog = new Dialogs.AlertDialog("unlink_concur_dialog").setButtonsOrientation(Integer.valueOf(1)).setTitle(getResources().getString(2131166398)).setMessage(getResources().getString(2131166397)).addPositiveButton(getResources().getString(2131166395), 2130903153).addNegativeButton(getResources().getString(2131165358)).setDialogEventClass(ConcurSendRideReceiptsView.UnlinkConcurDialogResultEvent.class);
    dialogFlow.show(localAlertDialog);
  }
  
  private void unlinkConcur()
  {
    progressController.showProgress();
    progressController.disableUI();
    binder.bind(paymentService.unlinkConcur(), new ConcurSendRideReceiptsView.5(this));
  }
  
  private void updateConcurSendRideReceipts(boolean paramBoolean)
  {
    progressController.showProgress();
    progressController.disableUI();
    binder.bind(paymentService.updateConcurSendRideReceipts(paramBoolean), new ConcurSendRideReceiptsView.4(this, paramBoolean));
  }
  
  protected void onAttachedToWindow()
  {
    super.onAttachedToWindow();
    if (isInEditMode()) {
      return;
    }
    binder = Binder.attach(this);
    toolbar.setTitle(getResources().getString(2131166033));
    sendToConcurToggle.setChecked(sendConcurRideReceipts(), false);
    binder.bind(sendToConcurToggle.observeChange(), new ConcurSendRideReceiptsView.1(this));
    binder.bind(bus.observe(ConcurSendRideReceiptsView.UnlinkConcurDialogResultEvent.class), new ConcurSendRideReceiptsView.2(this));
    unlinkConcurButton.setOnClickListener(new ConcurSendRideReceiptsView.3(this));
    setSendToConcurDescription();
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
 * Qualified Name:     me.lyft.android.ui.payment.ConcurSendRideReceiptsView
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */