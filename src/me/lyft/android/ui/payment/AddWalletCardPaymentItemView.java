package me.lyft.android.ui.payment;

import android.content.Context;
import android.content.res.Resources;
import com.lyft.scoop.dagger.DaggerInjector;
import javax.inject.Inject;
import me.lyft.android.application.payment.IPaymentService;
import me.lyft.android.rx.Binder;
import me.lyft.android.ui.IProgressController;

public class AddWalletCardPaymentItemView
  extends PaymentListItemView
{
  private Binder binder;
  @Inject
  IPaymentErrorHandler paymentErrorHandler;
  @Inject
  IPaymentService paymentService;
  @Inject
  IProgressController progressController;
  
  public AddWalletCardPaymentItemView(Context paramContext)
  {
    super(paramContext);
    DaggerInjector.fromView(this).inject(this);
  }
  
  protected int getIcon()
  {
    return 2130837636;
  }
  
  protected String getSubTitle()
  {
    return "";
  }
  
  protected String getTitle()
  {
    return getResources().getString(2131166026);
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
  
  public boolean performClick()
  {
    progressController.showProgress();
    binder.bind(paymentService.changeWalletCard(), new AddWalletCardPaymentItemView.1(this));
    return true;
  }
}

/* Location:
 * Qualified Name:     me.lyft.android.ui.payment.AddWalletCardPaymentItemView
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */