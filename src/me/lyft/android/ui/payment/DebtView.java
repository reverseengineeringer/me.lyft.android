package me.lyft.android.ui.payment;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.ImageButton;
import android.widget.LinearLayout;
import android.widget.ScrollView;
import android.widget.TextView;
import butterknife.ButterKnife;
import com.lyft.scoop.dagger.DaggerInjector;
import java.util.Iterator;
import java.util.List;
import javax.inject.Inject;
import me.lyft.android.application.IUserProvider;
import me.lyft.android.application.payment.IPaymentService;
import me.lyft.android.common.AppFlow;
import me.lyft.android.common.DialogFlow;
import me.lyft.android.common.Unit;
import me.lyft.android.domain.User;
import me.lyft.android.domain.payment.ChargeAccount;
import me.lyft.android.domain.payment.Money;
import me.lyft.android.persistence.payment.IChargeAccountsProvider;
import me.lyft.android.rx.AsyncCall;
import me.lyft.android.rx.Binder;
import me.lyft.android.ui.IProgressController;
import rx.Observable;

public class DebtView
  extends ScrollView
  implements IPayDebtHandler
{
  @Inject
  AppFlow appFlow;
  private Binder binder;
  LinearLayout cardList;
  @Inject
  IChargeAccountsProvider chargeAccountsProvider;
  ImageButton closeButton;
  TextView debtAmountTxt;
  @Inject
  DialogFlow dialogFlow;
  @Inject
  IPaymentErrorHandler errorHandler;
  @Inject
  IPaymentService paymentService;
  @Inject
  IProgressController progressController;
  @Inject
  IUserProvider userProvider;
  
  public DebtView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    DaggerInjector.fromView(this).inject(this);
  }
  
  private void loadPaymentMethods(List<ChargeAccount> paramList)
  {
    cardList.removeAllViews();
    if (!chargeAccountsProvider.hasWalletCard()) {
      cardList.addView(new DebtWalletListItemView(getContext(), null, this));
    }
    if (!chargeAccountsProvider.hasPayPalChargeAccount()) {
      cardList.addView(new DebtPayPalListItemView(getContext(), null, this));
    }
    paramList = paramList.iterator();
    while (paramList.hasNext())
    {
      Object localObject = (ChargeAccount)paramList.next();
      localObject = DebtListItemView.createItem(getContext(), (ChargeAccount)localObject, this);
      if (localObject != null) {
        cardList.addView((View)localObject);
      }
    }
    if (!chargeAccountsProvider.hasMaximumCreditCardsAmount()) {
      cardList.addView(new DebtAddCardListItemView(getContext()));
    }
  }
  
  protected void onAttachedToWindow()
  {
    super.onAttachedToWindow();
    closeButton.setOnClickListener(new DebtView.1(this));
    String str = userProvider.getUser().getDebtMoney().format();
    debtAmountTxt.setText(str);
    binder = Binder.attach(this);
    binder.bind(chargeAccountsProvider.observeChargeAccounts(), new DebtView.2(this));
    binder.bind(paymentService.refreshChargeAccounts(), new AsyncCall());
  }
  
  protected void onFinishInflate()
  {
    super.onFinishInflate();
    ButterKnife.bind(this);
  }
  
  public void onPaymentMethodSelected(Observable<Unit> paramObservable)
  {
    progressController.showProgress();
    String str = userProvider.getUser().getDebtMoney().format();
    binder.bind(paramObservable, new DebtView.3(this, str));
  }
}

/* Location:
 * Qualified Name:     me.lyft.android.ui.payment.DebtView
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */