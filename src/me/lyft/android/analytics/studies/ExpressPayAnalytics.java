package me.lyft.android.analytics.studies;

import me.lyft.android.analytics.core.UxAnalytics;
import me.lyft.android.analytics.definitions.UiElement;

public class ExpressPayAnalytics
{
  public static final String ADD_DEBIT_CARD_SCREEN = "add_debit_card_screen";
  public static final String EDIT_DEBIT_CARD_SCREEN = "edit_debit_card_screen";
  
  public static void trackAddDebitCardTaps()
  {
    UxAnalytics.tapped(UiElement.ADD_DEBIT_CARD_BUTTON).setParent("express_pay_screen").track();
  }
  
  public static void trackConfirmDepositTaps()
  {
    UxAnalytics.tapped(UiElement.CONFIRM_DEPOSIT_BUTTON).setParent("express_pay_screen").track();
  }
  
  public static void trackEditDebitCardTaps()
  {
    UxAnalytics.tapped(UiElement.EDIT_DEBIT_CARD_BUTTON).setParent("express_pay_screen").track();
  }
  
  public static void trackExpressPayPromoTaps()
  {
    UxAnalytics.tapped(UiElement.CHECK_IT_OUT_BUTTON).setParent("express_pay_promo").track();
  }
  
  public static void trackGetPaidTaps()
  {
    UxAnalytics.tapped(UiElement.GET_PAID_BUTTON).setParent("express_pay_card").track();
  }
  
  public static void trackSaveDebitCardTaps(String paramString)
  {
    UxAnalytics.tapped(UiElement.SAVE_DEBIT_CARD_BUTTON).setParent(paramString).track();
  }
}

/* Location:
 * Qualified Name:     me.lyft.android.analytics.studies.ExpressPayAnalytics
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */