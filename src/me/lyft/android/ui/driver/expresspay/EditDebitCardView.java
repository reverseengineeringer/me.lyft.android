package me.lyft.android.ui.driver.expresspay;

import android.content.Context;
import android.content.res.Resources;
import android.util.AttributeSet;
import android.widget.LinearLayout;
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
import me.lyft.android.common.AppFlow;
import me.lyft.android.common.DialogFlow;
import me.lyft.android.controls.Toolbar;
import me.lyft.android.domain.driver.ExpressPayAccount;
import me.lyft.android.domain.payment.ICard;
import me.lyft.android.rx.Binder;
import me.lyft.android.ui.IProgressController;
import me.lyft.android.ui.payment.IPaymentErrorHandler;
import me.lyft.android.ui.payment.cardinput.CreditCardInput;

public class EditDebitCardView
  extends LinearLayout
{
  @Inject
  AppFlow appFlow;
  private Binder binder;
  AdvancedEditText cardNumberEditText;
  @Inject
  IConstantsProvider constantsProvider;
  CreditCardInput creditCardInput;
  @Inject
  DialogFlow dialogFlow;
  final ExpressPayAccount expressPayAccount;
  @Inject
  IExpressPayRepository expressPayRepository;
  @Inject
  IExpressPayService expressPayService;
  TextView inlineErrorText;
  @Inject
  IPaymentErrorHandler paymentErrorHandler;
  @Inject
  IProgressController progressController;
  Toolbar toolbar;
  
  public EditDebitCardView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    DaggerInjector.fromView(this).inject(this);
    expressPayAccount = expressPayRepository.getExpressPayAccount();
  }
  
  private void initData()
  {
    creditCardInput.setExistingCard(expressPayAccount.getLastFour(), expressPayAccount.getType(), expressPayAccount.isFailed());
    if (expressPayAccount.isFailed()) {
      showCardErrors();
    }
    cardNumberEditText.addTextChangedListener(new EditDebitCardView.5(this));
  }
  
  private void initToolbar()
  {
    toolbar.setHomeIcon(2130838108);
    toolbar.setTitle(getResources().getString(2131166060));
    toolbar.addItem(2131558453, getResources().getString(2131166289), -1, getResources().getColor(2131492875), 1);
  }
  
  private void saveCard()
  {
    ICard localICard = creditCardInput.getCard();
    ExpressPayAnalytics.trackSaveDebitCardTaps("edit_debit_card_screen");
    if ((localICard.isEmpty()) && (expressPayAccount.isFailed()))
    {
      showCardErrors();
      return;
    }
    progressController.disableUI();
    progressController.showProgress();
    binder.bind(expressPayService.updateDebitCard(localICard), new EditDebitCardView.6(this));
  }
  
  private void showCardErrors()
  {
    inlineErrorText.setVisibility(0);
    inlineErrorText.setText(expressPayAccount.getFailedMessage());
    creditCardInput.highlightCreditCardFields();
  }
  
  protected void onAttachedToWindow()
  {
    super.onAttachedToWindow();
    binder = Binder.attach(this);
    initToolbar();
    initData();
    binder.bind(toolbar.observeHomeClick(), new EditDebitCardView.2(this));
    binder.bind(toolbar.observeItemClick(), new EditDebitCardView.3(this));
    binder.bind(creditCardInput.observeOnDonePressed(), new EditDebitCardView.4(this));
    PaymentAnalytics.trackOpenEditCardItem("debit_card");
  }
  
  protected void onFinishInflate()
  {
    super.onFinishInflate();
    ButterKnife.bind(this);
    creditCardInput.addOnInputChangedListener(new EditDebitCardView.1(this));
    paymentErrorHandler.attach(creditCardInput, inlineErrorText);
  }
}

/* Location:
 * Qualified Name:     me.lyft.android.ui.driver.expresspay.EditDebitCardView
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */