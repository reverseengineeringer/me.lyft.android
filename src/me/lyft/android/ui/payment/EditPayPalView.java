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
import javax.inject.Inject;
import me.lyft.android.application.payment.IPaymentService;
import me.lyft.android.common.AppFlow;
import me.lyft.android.common.DialogFlow;
import me.lyft.android.controls.Toolbar;
import me.lyft.android.domain.payment.PayPalChargeAccount;
import me.lyft.android.persistence.payment.IChargeAccountsProvider;
import me.lyft.android.rx.Binder;
import me.lyft.android.ui.Dialogs.AlertDialog;
import me.lyft.android.ui.IProgressController;

public class EditPayPalView
  extends LinearLayout
{
  @Inject
  AppFlow appFlow;
  private Binder binder;
  @Inject
  MessageBus bus;
  private final PayPalChargeAccount chargeAccount;
  @Inject
  IChargeAccountsProvider chargeAccountsProvider;
  Button deleteButton;
  @Inject
  DialogFlow dialogFlow;
  TextView emailTextView;
  @Inject
  IPaymentErrorHandler errorHandler;
  @Inject
  IPaymentService paymentService;
  @Inject
  IProgressController progressController;
  Toolbar toolbar;
  
  public EditPayPalView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    DaggerInjector.fromView(this).inject(this);
    chargeAccount = ((PaymentScreens.EditPayPalScreen)Screen.fromView(this)).getChargeAccount();
  }
  
  private void deletePayPal()
  {
    progressController.showProgress();
    binder.bind(paymentService.deleteChargeAccount(chargeAccount.getId(), "paypal"), new EditPayPalView.3(this));
  }
  
  private void showDeleteConfirmationDialog()
  {
    Dialogs.AlertDialog localAlertDialog = new Dialogs.AlertDialog("delete_paypal_confirmation_dialog").setTitle(getResources().getString(2131166051)).setTitleColorResource(2131493111).setMessage(getResources().getString(2131166050, new Object[] { chargeAccount.getEmail() })).addNegativeButton(getResources().getString(2131165358)).addPositiveButton(getResources().getString(2131166326), 2130903156).setDialogEventClass(EditPayPalView.DeletePayPalDialogResultEvent.class);
    dialogFlow.show(localAlertDialog);
  }
  
  protected void onAttachedToWindow()
  {
    super.onAttachedToWindow();
    binder = Binder.attach(this);
    toolbar.setTitle(getResources().getString(2131166090));
    emailTextView.setText(chargeAccount.getEmail());
    boolean bool = chargeAccountsProvider.hasLessThanTwoPaymentMethods();
    Button localButton = deleteButton;
    if (bool) {}
    for (int i = 8;; i = 0)
    {
      localButton.setVisibility(i);
      deleteButton.setOnClickListener(new EditPayPalView.1(this));
      binder.bind(bus.observe(EditPayPalView.DeletePayPalDialogResultEvent.class), new EditPayPalView.2(this));
      return;
    }
  }
  
  protected void onFinishInflate()
  {
    super.onFinishInflate();
    ButterKnife.bind(this);
  }
}

/* Location:
 * Qualified Name:     me.lyft.android.ui.payment.EditPayPalView
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */