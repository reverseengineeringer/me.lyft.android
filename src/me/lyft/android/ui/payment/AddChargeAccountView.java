package me.lyft.android.ui.payment;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;
import butterknife.ButterKnife;
import com.lyft.scoop.Scoop;
import com.lyft.scoop.dagger.DaggerInjector;
import javax.inject.Inject;
import me.lyft.android.analytics.studies.PaymentAnalytics;
import me.lyft.android.application.payment.IPaymentService;
import me.lyft.android.common.Unit;
import me.lyft.android.domain.payment.ICard;
import me.lyft.android.rx.Binder;
import me.lyft.android.ui.IProgressController;
import me.lyft.android.ui.payment.cardinput.CreditCardInput;
import rx.Observable;
import rx.subjects.PublishSubject;

public class AddChargeAccountView
  extends LinearLayout
{
  View addPayPalButton;
  View addWalletButton;
  private Binder binder;
  CreditCardInput creditCardInput;
  TextView editChargeAccountNote;
  @Inject
  IPaymentErrorHandler paymentErrorHandler;
  @Inject
  IPaymentService paymentService;
  @Inject
  IProgressController progressController;
  Button saveButton;
  private final PublishSubject<Unit> saveSuccessSubject = PublishSubject.create();
  View subTitleTextView;
  
  public AddChargeAccountView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    setOrientation(1);
    DaggerInjector.fromView(this).inject(this);
    Scoop.fromView(this).inflater(getContext()).inflate(2130903362, this, true);
    ButterKnife.bind(this);
  }
  
  private void addCard()
  {
    ICard localICard = creditCardInput.getCard();
    progressController.disableUI();
    progressController.showProgress();
    binder.bind(paymentService.createCreditCard(localICard, Boolean.valueOf(false), Boolean.valueOf(false)), new AddChargeAccountView.7(this));
  }
  
  private void addPayPal()
  {
    progressController.showProgress();
    binder.bind(paymentService.savePayPal(null, null), new AddChargeAccountView.8(this));
  }
  
  private void addWallet()
  {
    progressController.showProgress();
    binder.bind(paymentService.changeWalletCard(), new AddChargeAccountView.6(this));
  }
  
  public Observable<Unit> observeSaveSuccess()
  {
    return saveSuccessSubject.asObservable();
  }
  
  protected void onAttachedToWindow()
  {
    super.onAttachedToWindow();
    binder = Binder.attach(this);
    binder.bind(creditCardInput.observeOnDonePressed(), new AddChargeAccountView.1(this));
    binder.bind(paymentService.observeWalletReadyToPay(), new AddChargeAccountView.2(this));
    subTitleTextView.setVisibility(8);
    paymentErrorHandler.attach(creditCardInput, editChargeAccountNote);
    saveButton.setOnClickListener(new AddChargeAccountView.3(this));
    addWalletButton.setOnClickListener(new AddChargeAccountView.4(this));
    addPayPalButton.setOnClickListener(new AddChargeAccountView.5(this));
    creditCardInput.showSoftwareKeyboard();
    PaymentAnalytics.trackOpenAddCardItem("dialog_payment");
  }
  
  protected void onDetachedFromWindow()
  {
    super.onDetachedFromWindow();
  }
}

/* Location:
 * Qualified Name:     me.lyft.android.ui.payment.AddChargeAccountView
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */