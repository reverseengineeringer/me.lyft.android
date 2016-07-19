package me.lyft.android.ui.payment;

import android.content.Context;
import android.view.View;
import android.widget.LinearLayout;
import com.lyft.scoop.HandleBack;
import com.lyft.scoop.Scoop;
import com.lyft.scoop.ViewController;
import javax.inject.Inject;
import me.lyft.android.application.IUserProvider;
import me.lyft.android.controls.Toolbar;
import me.lyft.android.domain.User;
import me.lyft.android.persistence.payment.IChargeAccountsProvider;
import me.lyft.android.ui.MainScreensRouter;

public class PaymentSelectCheckoutController
  extends ViewController
  implements HandleBack
{
  LinearLayout addCard;
  private final IChargeAccountsProvider chargeAccountsProvider;
  LinearLayout concurLayout;
  private final MainScreensRouter mainScreensRouter;
  Toolbar toolbar;
  private final IUserProvider userProvider;
  
  @Inject
  public PaymentSelectCheckoutController(MainScreensRouter paramMainScreensRouter, IUserProvider paramIUserProvider, IChargeAccountsProvider paramIChargeAccountsProvider)
  {
    mainScreensRouter = paramMainScreensRouter;
    userProvider = paramIUserProvider;
    chargeAccountsProvider = paramIChargeAccountsProvider;
  }
  
  private void addChargeAccountView()
  {
    if (!chargeAccountsProvider.hasMaximumCreditCardsAmount())
    {
      AddCreditCardPaymentItemView localAddCreditCardPaymentItemView = new AddCreditCardPaymentItemView(getScoop().createContext(getView().getContext()), false, false);
      addCard.addView(localAddCreditCardPaymentItemView);
    }
  }
  
  protected int layoutId()
  {
    return 2130903375;
  }
  
  public void onAttach()
  {
    super.onAttach();
    Object localObject = getView().getContext().getString(2131166022);
    toolbar.showTitle().setTitle((String)localObject);
    boolean bool = userProvider.getUser().hasBusinessProfile();
    localObject = concurLayout;
    if (bool) {}
    for (int i = 8;; i = 0)
    {
      ((LinearLayout)localObject).setVisibility(i);
      addChargeAccountView();
      return;
    }
  }
  
  public boolean onBack()
  {
    mainScreensRouter.resetToHomeScreen();
    return true;
  }
  
  public void onDetach()
  {
    super.onDetach();
  }
}

/* Location:
 * Qualified Name:     me.lyft.android.ui.payment.PaymentSelectCheckoutController
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */