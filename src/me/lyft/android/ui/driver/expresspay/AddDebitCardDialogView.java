package me.lyft.android.ui.driver.expresspay;

import android.content.Context;
import android.content.res.Resources;
import android.util.AttributeSet;
import android.view.View;
import android.widget.TextView;
import butterknife.ButterKnife;
import com.lyft.scoop.dagger.DaggerInjector;
import com.lyft.widgets.AdvancedEditText;
import javax.inject.Inject;
import me.lyft.android.analytics.studies.ExpressPayAnalytics;
import me.lyft.android.analytics.studies.PaymentAnalytics;
import me.lyft.android.application.constants.IConstantsProvider;
import me.lyft.android.application.driver.expresspay.IExpressPayRepository;
import me.lyft.android.application.driver.expresspay.IExpressPayService;
import me.lyft.android.common.DialogFlow;
import me.lyft.android.domain.payment.ICard;
import me.lyft.android.rx.Binder;
import me.lyft.android.ui.IProgressController;
import me.lyft.android.ui.dialogs.DialogContainerView;
import me.lyft.android.ui.payment.IPaymentErrorHandler;
import me.lyft.android.ui.payment.cardinput.CreditCardInput;

public class AddDebitCardDialogView
  extends DialogContainerView
{
  TextView addCardButton;
  private Binder binder;
  AdvancedEditText cardNumberEditText;
  View closeButton;
  @Inject
  IConstantsProvider constantsProvider;
  CreditCardInput creditCardInput;
  @Inject
  DialogFlow dialogFlow;
  @Inject
  IExpressPayRepository expressPayRepository;
  @Inject
  IExpressPayService expressPayService;
  TextView inlineErrorText;
  @Inject
  IPaymentErrorHandler paymentErrorHandler;
  @Inject
  IProgressController progressController;
  
  public AddDebitCardDialogView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    DaggerInjector.fromView(this).inject(this);
  }
  
  private void saveCard()
  {
    ICard localICard = creditCardInput.getCard();
    ExpressPayAnalytics.trackSaveDebitCardTaps("add_debit_card_screen");
    progressController.disableUI();
    progressController.showProgress();
    binder.bind(expressPayService.createDebitCard(localICard), new AddDebitCardDialogView.6(this));
  }
  
  protected void onAttachedToWindow()
  {
    super.onAttachedToWindow();
    if (isInEditMode()) {
      return;
    }
    binder = Binder.attach(this);
    binder.bind(creditCardInput.observeOnDonePressed(), new AddDebitCardDialogView.4(this));
    creditCardInput.showSoftwareKeyboard();
    cardNumberEditText.addTextChangedListener(new AddDebitCardDialogView.5(this));
    PaymentAnalytics.trackOpenAddCardItem("debit_card");
  }
  
  protected void onFinishInflate()
  {
    if (isInEditMode()) {
      return;
    }
    super.onFinishInflate();
    ButterKnife.bind(this);
    closeButton.setOnClickListener(new AddDebitCardDialogView.1(this));
    creditCardInput.requestFocus();
    creditCardInput.addOnInputChangedListener(new AddDebitCardDialogView.2(this));
    paymentErrorHandler.attach(creditCardInput, inlineErrorText);
    addCardButton.setOnClickListener(new AddDebitCardDialogView.3(this));
    cardNumberEditText.setHint(getResources().getText(2131165519));
  }
}

/* Location:
 * Qualified Name:     me.lyft.android.ui.driver.expresspay.AddDebitCardDialogView
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */