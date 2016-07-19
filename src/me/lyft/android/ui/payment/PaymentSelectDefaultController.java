package me.lyft.android.ui.payment;

import android.content.Context;
import android.view.View;
import android.widget.LinearLayout;
import com.lyft.scoop.Scoop;
import com.lyft.scoop.Screen;
import com.lyft.scoop.ViewController;
import javax.inject.Inject;
import me.lyft.android.application.IUserProvider;
import me.lyft.android.application.checkout.ICheckoutSession;
import me.lyft.android.controls.Toolbar;
import me.lyft.android.domain.User;
import me.lyft.android.persistence.payment.IChargeAccountsProvider;

public class PaymentSelectDefaultController
  extends ViewController
{
  LinearLayout addCard;
  LinearLayout addPaymentLayout;
  private final IChargeAccountsProvider chargeAccountsProvider;
  private final ICheckoutSession checkoutSession;
  Toolbar toolbar;
  private final IUserProvider userProvider;
  
  @Inject
  public PaymentSelectDefaultController(IChargeAccountsProvider paramIChargeAccountsProvider, ICheckoutSession paramICheckoutSession, IUserProvider paramIUserProvider)
  {
    chargeAccountsProvider = paramIChargeAccountsProvider;
    checkoutSession = paramICheckoutSession;
    userProvider = paramIUserProvider;
  }
  
  private void addChargeAccountView(boolean paramBoolean1, boolean paramBoolean2)
  {
    if (!paramBoolean1)
    {
      AddCreditCardPaymentItemView localAddCreditCardPaymentItemView = new AddCreditCardPaymentItemView(getScoop().createContext(getView().getContext()), true, paramBoolean2);
      addCard.addView(localAddCreditCardPaymentItemView);
    }
  }
  
  private void showToolbarTitle()
  {
    int i = 2131165541;
    if (userProvider.getUser().hasBusinessProfile()) {
      if (!checkoutSession.isBusinessProfile()) {
        break label58;
      }
    }
    label58:
    for (i = 2131166093;; i = 2131166094)
    {
      String str = getView().getContext().getString(i);
      toolbar.showTitle().setTitle(str);
      return;
    }
  }
  
  protected int layoutId()
  {
    return 2130903376;
  }
  
  public void onAttach()
  {
    showToolbarTitle();
    PaymentScreens.PaymentSelectDefaultScreen localPaymentSelectDefaultScreen = (PaymentScreens.PaymentSelectDefaultScreen)Screen.fromController(this);
    boolean bool = chargeAccountsProvider.hasMaximumCreditCardsAmount();
    LinearLayout localLinearLayout = addPaymentLayout;
    if (bool) {}
    for (int i = 8;; i = 0)
    {
      localLinearLayout.setVisibility(i);
      addChargeAccountView(bool, localPaymentSelectDefaultScreen.isBusinessProfile());
      return;
    }
  }
}

/* Location:
 * Qualified Name:     me.lyft.android.ui.payment.PaymentSelectDefaultController
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */