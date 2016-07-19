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
import me.lyft.android.common.Strings;
import me.lyft.android.controls.Toolbar;
import me.lyft.android.domain.payment.WalletChargeAccount;
import me.lyft.android.persistence.payment.IChargeAccountsProvider;
import me.lyft.android.rx.Binder;
import me.lyft.android.ui.Dialogs.AlertDialog;
import me.lyft.android.ui.IProgressController;

public class EditAndroidPayView
  extends LinearLayout
{
  @Inject
  AppFlow appFlow;
  private Binder binder;
  @Inject
  MessageBus bus;
  TextView cardTitleTextView;
  private final WalletChargeAccount chargeAccount;
  @Inject
  IChargeAccountsProvider chargeAccountsProvider;
  Button deleteButton;
  @Inject
  DialogFlow dialogFlow;
  Button editCardButton;
  @Inject
  IPaymentErrorHandler errorHandler;
  @Inject
  IPaymentService paymentService;
  @Inject
  IProgressController progressController;
  Toolbar toolbar;
  
  public EditAndroidPayView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    DaggerInjector.fromView(this).inject(this);
    chargeAccount = ((PaymentScreens.EditAndroidPayScreen)Screen.fromView(this)).getChargeAccount();
  }
  
  private void deleteAndroidPay()
  {
    progressController.showProgress();
    binder.bind(paymentService.deleteChargeAccount(chargeAccount.getId(), "android_pay"), new EditAndroidPayView.5(this));
  }
  
  private void editCard()
  {
    progressController.showProgress();
    binder.bind(paymentService.changeWalletCard(), new EditAndroidPayView.4(this));
  }
  
  private void showDeleteConfirmationDialog()
  {
    Dialogs.AlertDialog localAlertDialog = new Dialogs.AlertDialog("delete_wallet_confirmation_dialog").setTitle(getResources().getString(2131166053)).setTitleColorResource(2131493111).setMessage(getResources().getString(2131166052)).addNegativeButton(getResources().getString(2131165358)).addPositiveButton(getResources().getString(2131165559), 2130903157).setDialogEventClass(EditAndroidPayView.DeleteWalletDialogResultEvent.class);
    dialogFlow.show(localAlertDialog);
  }
  
  protected void onAttachedToWindow()
  {
    super.onAttachedToWindow();
    binder = Binder.attach(this);
    toolbar.setTitle(getResources().getString(2131166101));
    String str2 = chargeAccount.getLabel();
    String str1;
    if (!Strings.isNullOrEmpty(str2))
    {
      str1 = str2;
      if (!str2.contains("Wallet")) {}
    }
    else
    {
      str1 = getResources().getString(2131166066, new Object[] { chargeAccount.getType(), chargeAccount.getLastFour() });
    }
    cardTitleTextView.setText(str1);
    if (chargeAccountsProvider.hasLessThanTwoPaymentMethods()) {
      deleteButton.setVisibility(8);
    }
    for (;;)
    {
      editCardButton.setOnClickListener(new EditAndroidPayView.1(this));
      deleteButton.setOnClickListener(new EditAndroidPayView.2(this));
      binder.bind(bus.observe(EditAndroidPayView.DeleteWalletDialogResultEvent.class), new EditAndroidPayView.3(this));
      return;
      deleteButton.setVisibility(0);
    }
  }
  
  protected void onFinishInflate()
  {
    super.onFinishInflate();
    ButterKnife.bind(this);
  }
}

/* Location:
 * Qualified Name:     me.lyft.android.ui.payment.EditAndroidPayView
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */