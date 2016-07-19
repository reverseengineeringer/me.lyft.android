package me.lyft.android.ui.payment;

import android.content.Context;
import com.lyft.scoop.dagger.DaggerInjector;
import javax.inject.Inject;
import me.lyft.android.common.AppFlow;
import me.lyft.android.domain.payment.ChargeAccount;

public abstract class ChargeAccountPaymentItemView
  extends PaymentListItemView
{
  @Inject
  AppFlow appFlow;
  protected final ChargeAccount chargeAccount;
  
  public ChargeAccountPaymentItemView(Context paramContext, ChargeAccount paramChargeAccount)
  {
    super(paramContext);
    DaggerInjector.fromView(this).inject(this);
    chargeAccount = paramChargeAccount;
  }
  
  protected final ChargeAccount getChargeAccount()
  {
    return chargeAccount;
  }
  
  protected String getSubTitle()
  {
    return "";
  }
  
  protected boolean isFailed()
  {
    return chargeAccount.isFailed().booleanValue();
  }
}

/* Location:
 * Qualified Name:     me.lyft.android.ui.payment.ChargeAccountPaymentItemView
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */