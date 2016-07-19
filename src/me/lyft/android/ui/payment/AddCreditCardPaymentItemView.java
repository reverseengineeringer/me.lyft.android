package me.lyft.android.ui.payment;

import android.content.Context;
import android.content.res.Resources;
import com.lyft.scoop.dagger.DaggerInjector;
import javax.inject.Inject;
import me.lyft.android.analytics.studies.PaymentAnalytics;
import me.lyft.android.common.AppFlow;

public class AddCreditCardPaymentItemView
  extends PaymentListItemView
{
  @Inject
  AppFlow appFlow;
  private final boolean isBusinessProfile;
  private final boolean isMakeDefault;
  
  public AddCreditCardPaymentItemView(Context paramContext, boolean paramBoolean1, boolean paramBoolean2)
  {
    super(paramContext);
    isMakeDefault = paramBoolean1;
    isBusinessProfile = paramBoolean2;
    DaggerInjector.fromView(this).inject(this);
    setOrientation(1);
  }
  
  protected int getIcon()
  {
    return 2130837640;
  }
  
  protected String getSubTitle()
  {
    return "";
  }
  
  protected String getTitle()
  {
    return getResources().getString(2131166024);
  }
  
  protected boolean isFailed()
  {
    return false;
  }
  
  public boolean performClick()
  {
    PaymentAnalytics.trackOpenAddCardItem("credit_card");
    appFlow.goTo(new PaymentScreens.AddCreditCardScreen(Boolean.valueOf(isMakeDefault), Boolean.valueOf(isBusinessProfile)));
    return true;
  }
}

/* Location:
 * Qualified Name:     me.lyft.android.ui.payment.AddCreditCardPaymentItemView
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */