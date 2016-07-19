package me.lyft.android.ui.payment;

import android.content.Context;
import android.view.View;
import android.widget.LinearLayout;
import com.lyft.scoop.HandleBack;
import com.lyft.scoop.Scoop;
import com.lyft.scoop.Screen;
import com.lyft.scoop.ViewController;
import java.util.List;
import javax.inject.Inject;
import me.lyft.android.application.IUserProvider;
import me.lyft.android.common.Strings;
import me.lyft.android.common.Unit;
import me.lyft.android.controls.Toolbar;
import me.lyft.android.domain.User;
import me.lyft.android.domain.payment.ChargeAccount;
import me.lyft.android.persistence.payment.IChargeAccountsProvider;
import me.lyft.android.rx.RxBinder;
import me.lyft.android.scoop.extensions.ViewControllers;
import me.lyft.android.ui.MainScreensRouter;
import me.lyft.android.ui.SlideMenuController;
import rx.functions.Action1;

public class PaymentScreenController
  extends ViewController
  implements HandleBack
{
  LinearLayout addCard;
  AddCouponView addCoupon;
  private final RxBinder binder;
  private final IChargeAccountsProvider chargeAccountsProvider;
  LinearLayout concurLayout;
  private final MainScreensRouter mainScreensRouter;
  private final Action1<List<ChargeAccount>> onChargeAccountsUpdated = new PaymentScreenController.2(this);
  private final Action1<Unit> onToolbarHomeClicked = new PaymentScreenController.1(this);
  PaymentBusinessDefaultsWidgetView paymentBusinessDefaultsWidgetView;
  LinearLayout paymentDefaultsLayout;
  private final SlideMenuController slideMenuController;
  Toolbar toolbar;
  private final IUserProvider userProvider;
  
  @Inject
  public PaymentScreenController(IChargeAccountsProvider paramIChargeAccountsProvider, MainScreensRouter paramMainScreensRouter, IUserProvider paramIUserProvider, SlideMenuController paramSlideMenuController, RxBinder paramRxBinder)
  {
    chargeAccountsProvider = paramIChargeAccountsProvider;
    mainScreensRouter = paramMainScreensRouter;
    userProvider = paramIUserProvider;
    slideMenuController = paramSlideMenuController;
    binder = paramRxBinder;
  }
  
  private void addChargeAccountView()
  {
    if (!chargeAccountsProvider.hasMaximumCreditCardsAmount())
    {
      AddCreditCardPaymentItemView localAddCreditCardPaymentItemView = new AddCreditCardPaymentItemView(getScoop().createContext(getView().getContext()), false, false);
      addCard.addView(localAddCreditCardPaymentItemView);
    }
  }
  
  private void updatePaymentDefaultViews(List<ChargeAccount> paramList)
  {
    int j = 0;
    boolean bool = userProvider.getUser().hasBusinessProfile();
    Object localObject = paymentDefaultsLayout;
    if (paramList.isEmpty())
    {
      i = 8;
      ((LinearLayout)localObject).setVisibility(i);
      localObject = concurLayout;
      if (!bool) {
        break label134;
      }
      i = 8;
      label54:
      ((LinearLayout)localObject).setVisibility(i);
      localObject = paymentBusinessDefaultsWidgetView;
      if (!bool) {
        break label139;
      }
    }
    label134:
    label139:
    for (int i = j;; i = 8)
    {
      ((PaymentBusinessDefaultsWidgetView)localObject).setVisibility(i);
      localObject = getScoop();
      paramList = new PaymentDefaultsWidgetModule(paramList);
      paramList = ViewControllers.create(PaymentDefaultsWidgetController.class).scoop((Scoop)localObject).parent(paymentDefaultsLayout).module(paramList).inflate();
      paymentDefaultsLayout.addView(paramList, 2);
      return;
      i = 0;
      break;
      i = 0;
      break label54;
    }
  }
  
  protected int layoutId()
  {
    return 2130903374;
  }
  
  public void onAttach()
  {
    super.onAttach();
    binder.attach();
    PaymentScreens.PaymentBaseScreen localPaymentBaseScreen = (PaymentScreens.PaymentBaseScreen)Screen.fromController(this);
    String str = getView().getContext().getString(2131166022);
    toolbar.showTitle().setTitle(str);
    slideMenuController.enableMenu();
    binder.bindAction(toolbar.observeHomeClick(), onToolbarHomeClicked);
    binder.bindAction(chargeAccountsProvider.observeChargeAccounts(), onChargeAccountsUpdated);
    if (!Strings.isNullOrEmpty(localPaymentBaseScreen.getCoupon()))
    {
      addCoupon.setCoupon(localPaymentBaseScreen.getCoupon());
      localPaymentBaseScreen.resetCoupon();
    }
    addChargeAccountView();
  }
  
  public boolean onBack()
  {
    mainScreensRouter.resetToHomeScreen();
    return true;
  }
  
  public void onDetach()
  {
    super.onDetach();
    binder.detach();
    slideMenuController.disableMenu();
  }
}

/* Location:
 * Qualified Name:     me.lyft.android.ui.payment.PaymentScreenController
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */