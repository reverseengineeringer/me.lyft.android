package me.lyft.android.ui.payment;

import android.content.Context;
import android.content.res.Resources;
import javax.inject.Inject;
import me.lyft.android.common.AppFlow;

public class DebtAddCardListItemView
  extends DebtListItemView
{
  @Inject
  AppFlow appFlow;
  
  public DebtAddCardListItemView(Context paramContext)
  {
    super(paramContext, null, null);
  }
  
  protected int getIcon()
  {
    return 2130837640;
  }
  
  protected String getTitle()
  {
    return getResources().getString(2131165523);
  }
  
  protected boolean isFailed()
  {
    return false;
  }
  
  protected void onAttachedToWindow()
  {
    super.onAttachedToWindow();
  }
  
  public boolean performClick()
  {
    appFlow.goTo(new PaymentScreens.DebtAddChargeAccountScreen(null));
    return true;
  }
}

/* Location:
 * Qualified Name:     me.lyft.android.ui.payment.DebtAddCardListItemView
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */