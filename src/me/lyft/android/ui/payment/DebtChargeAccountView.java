package me.lyft.android.ui.payment;

import android.content.Context;
import android.content.res.Resources;
import android.text.Html;
import android.util.AttributeSet;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ScrollView;
import android.widget.TextView;
import butterknife.ButterKnife;
import com.lyft.scoop.Screen;
import com.lyft.scoop.dagger.DaggerInjector;
import javax.inject.Inject;
import me.lyft.android.analytics.studies.PaymentAnalytics;
import me.lyft.android.application.IUserProvider;
import me.lyft.android.application.payment.IPaymentService;
import me.lyft.android.common.AppFlow;
import me.lyft.android.common.DialogFlow;
import me.lyft.android.common.Strings;
import me.lyft.android.domain.User;
import me.lyft.android.domain.payment.ChargeAccount;
import me.lyft.android.domain.payment.CreditCardChargeAccount;
import me.lyft.android.domain.payment.ICard;
import me.lyft.android.domain.payment.Money;
import me.lyft.android.rx.Binder;
import me.lyft.android.ui.IProgressController;
import me.lyft.android.ui.MainScreensRouter;
import me.lyft.android.ui.payment.cardinput.CreditCardInput;
import rx.Observable;

public class DebtChargeAccountView
  extends ScrollView
{
  @Inject
  AppFlow appFlow;
  ImageButton backButton;
  private Binder binder;
  private String cardId;
  CreditCardInput creditCardInput;
  @Inject
  DialogFlow dialogFlow;
  TextView editCardNote;
  @Inject
  MainScreensRouter mainScreensRouter;
  private final PaymentScreens.DebtAddChargeAccountScreen params;
  @Inject
  IPaymentErrorHandler paymentErrorHandler;
  @Inject
  IPaymentService paymentService;
  @Inject
  IProgressController progressController;
  Button saveButton;
  TextView subTitleTxt;
  TextView titleTxt;
  @Inject
  IUserProvider userProvider;
  
  public DebtChargeAccountView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    DaggerInjector.fromView(this).inject(this);
    params = ((PaymentScreens.DebtAddChargeAccountScreen)Screen.fromView(this));
  }
  
  private void initData()
  {
    Object localObject = getSelectedChargeAccount();
    if (localObject != null)
    {
      cardId = ((ChargeAccount)localObject).getId();
      if ((localObject instanceof CreditCardChargeAccount))
      {
        localObject = (CreditCardChargeAccount)localObject;
        creditCardInput.setExistingCard(((CreditCardChargeAccount)localObject).getLastFour(), ((CreditCardChargeAccount)localObject).getType(), true);
      }
    }
    if (isNewCard()) {}
    for (localObject = getContext().getString(2131166025);; localObject = getContext().getString(2131166061))
    {
      titleTxt.setText((CharSequence)localObject);
      localObject = userProvider.getUser().getDebtMoney().format();
      localObject = getResources().getString(2131165530, new Object[] { localObject });
      subTitleTxt.setText(Html.fromHtml((String)localObject));
      if (!isNewCard()) {
        break;
      }
      PaymentAnalytics.trackOpenAddCardItem("credit_card");
      return;
    }
    PaymentAnalytics.trackOpenEditCardItem("credit_card");
  }
  
  private boolean isNewCard()
  {
    return Strings.isNullOrEmpty(cardId);
  }
  
  private void saveCard()
  {
    Object localObject = creditCardInput.getCard();
    if (isNewCard()) {}
    for (localObject = paymentService.createCreditCard((ICard)localObject, null, null);; localObject = paymentService.updateCreditCard(cardId, (ICard)localObject))
    {
      String str = userProvider.getUser().getDebtMoney().format();
      progressController.showProgress(getResources().getString(2131165529));
      binder.bind((Observable)localObject, new DebtChargeAccountView.3(this, str));
      return;
    }
  }
  
  public ChargeAccount getSelectedChargeAccount()
  {
    return params.getChargeAccount();
  }
  
  protected void onAttachedToWindow()
  {
    super.onAttachedToWindow();
    binder = Binder.attach(this);
    initData();
    backButton.setOnClickListener(new DebtChargeAccountView.2(this));
  }
  
  protected void onFinishInflate()
  {
    super.onFinishInflate();
    ButterKnife.bind(this);
    paymentErrorHandler.attach(creditCardInput, editCardNote);
    saveButton.setOnClickListener(new DebtChargeAccountView.1(this));
  }
}

/* Location:
 * Qualified Name:     me.lyft.android.ui.payment.DebtChargeAccountView
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */