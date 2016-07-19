package me.lyft.android.ui.payment;

import android.content.Context;
import android.content.res.Resources;
import com.lyft.scoop.dagger.DaggerInjector;
import javax.inject.Inject;
import me.lyft.android.application.payment.IPaymentService;
import me.lyft.android.rx.Binder;
import me.lyft.android.ui.IProgressController;

public class AddPayPalPaymentItemView
  extends PaymentListItemView
{
  private Binder binder;
  private final boolean isBusinessProfile;
  private final boolean isMakeDefault;
  @Inject
  IPaymentErrorHandler paymentErrorHandler;
  @Inject
  IPaymentService paymentService;
  @Inject
  IProgressController progressController;
  
  public AddPayPalPaymentItemView(Context paramContext, boolean paramBoolean1, boolean paramBoolean2)
  {
    super(paramContext);
    isMakeDefault = paramBoolean1;
    isBusinessProfile = paramBoolean2;
    DaggerInjector.fromView(this).inject(this);
  }
  
  protected int getIcon()
  {
    return 2130837654;
  }
  
  protected String getSubTitle()
  {
    return "";
  }
  
  protected String getTitle()
  {
    return getResources().getString(2131166027);
  }
  
  protected boolean isFailed()
  {
    return false;
  }
  
  protected void onAttachedToWindow()
  {
    super.onAttachedToWindow();
    binder = Binder.attach(this);
  }
  
  protected void onDetachedFromWindow()
  {
    super.onDetachedFromWindow();
    binder.detach();
  }
  
  public boolean performClick()
  {
    Boolean localBoolean1 = null;
    Boolean localBoolean2 = null;
    if (isMakeDefault) {
      if (isBusinessProfile) {
        break label71;
      }
    }
    label71:
    for (boolean bool = true;; bool = false)
    {
      localBoolean1 = Boolean.valueOf(bool);
      localBoolean2 = Boolean.valueOf(isBusinessProfile);
      progressController.showProgress();
      binder.bind(paymentService.savePayPal(localBoolean1, localBoolean2), new AddPayPalPaymentItemView.1(this));
      return true;
    }
  }
}

/* Location:
 * Qualified Name:     me.lyft.android.ui.payment.AddPayPalPaymentItemView
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */