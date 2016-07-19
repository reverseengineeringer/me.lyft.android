package me.lyft.android.ui.payment;

import android.content.Context;
import android.content.res.Resources;
import android.util.AttributeSet;
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
import me.lyft.android.common.Unit;
import me.lyft.android.controls.Toolbar;
import me.lyft.android.domain.payment.ICard;
import me.lyft.android.rx.AsyncCall;
import me.lyft.android.rx.Binder;
import me.lyft.android.ui.IProgressController;
import me.lyft.android.ui.payment.cardinput.CreditCardInput;
import me.lyft.android.utils.Keyboard;
import rx.Observable;
import rx.functions.Action1;

public abstract class BaseCreditCardView
  extends LinearLayout
{
  @Inject
  AppFlow appFlow;
  Binder binder;
  @Inject
  MessageBus bus;
  CreditCardInput creditCardInput;
  @Inject
  DialogFlow dialogFlow;
  TextView editChargeAccountNote;
  private final Action1<Integer> onToolbarItemClicked = new BaseCreditCardView.2(this);
  @Inject
  IPaymentErrorHandler paymentErrorHandler;
  @Inject
  IPaymentService paymentService;
  @Inject
  IProgressController progressController;
  Toolbar toolbar;
  
  public BaseCreditCardView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    DaggerInjector.fromView(this).inject(this);
  }
  
  private void initToolbar()
  {
    toolbar.showTitle().addItem(2131558453, getResources().getString(2131166289));
    TextView localTextView = (TextView)ButterKnife.findById(toolbar.getToolbarItemView(2131558453), 2131558558);
    localTextView.setTypeface(null, 1);
    localTextView.setTextColor(getResources().getColor(2131492875));
    toolbar.setTitle(getResources().getString(getToolbarTitleResource()));
  }
  
  private void saveCard()
  {
    Keyboard.hideKeyboard(creditCardInput);
    progressController.showProgress();
    ICard localICard = creditCardInput.getCard();
    binder.bind(saveCardRequest(localICard), createResponseHandler());
  }
  
  protected final AsyncCall<Unit> createResponseHandler()
  {
    return new BaseCreditCardView.ResponseHandler(this, null);
  }
  
  protected final <T extends PaymentScreens> T getScreen()
  {
    return (PaymentScreens)Screen.fromView(this);
  }
  
  protected abstract int getToolbarTitleResource();
  
  protected void onAttachedToWindow()
  {
    super.onAttachedToWindow();
    binder = Binder.attach(this);
    initToolbar();
    binder.bind(toolbar.observeItemClick(), onToolbarItemClicked);
    binder.bind(creditCardInput.observeOnDonePressed(), new BaseCreditCardView.1(this));
    paymentErrorHandler.attach(creditCardInput, editChargeAccountNote);
  }
  
  protected void onFinishInflate()
  {
    super.onFinishInflate();
    ButterKnife.bind(this);
  }
  
  protected abstract Observable<Unit> saveCardRequest(ICard paramICard);
}

/* Location:
 * Qualified Name:     me.lyft.android.ui.payment.BaseCreditCardView
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */