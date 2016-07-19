package me.lyft.android.ui.payment;

import android.content.Context;
import android.content.res.Resources;
import android.util.AttributeSet;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;
import butterknife.ButterKnife;
import com.lyft.scoop.Screen;
import com.lyft.scoop.dagger.DaggerInjector;
import javax.inject.Inject;
import me.lyft.android.application.payment.IPaymentService;
import me.lyft.android.common.AppFlow;
import me.lyft.android.controls.Toolbar;
import me.lyft.android.domain.payment.FacebookChargeAccount;
import me.lyft.android.ui.IProgressController;
import me.lyft.android.ui.passenger.v2.PassengerRideRouter;
import me.lyft.android.utils.WebBrowser;

public class EditFacebookCreditCardView
  extends LinearLayout
{
  @Inject
  AppFlow appFlow;
  TextView cardTitleTextView;
  private final FacebookChargeAccount chargeAccount;
  View errorView;
  LinearLayout footerView;
  @Inject
  IPaymentService paymentService;
  @Inject
  IProgressController progressController;
  @Inject
  PassengerRideRouter router;
  Toolbar toolbar;
  @Inject
  WebBrowser webBrowser;
  
  public EditFacebookCreditCardView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    DaggerInjector.fromView(this).inject(this);
    chargeAccount = ((PaymentScreens.EditFacebookCreditCardScreen)Screen.fromView(this)).getChargeAccount();
  }
  
  protected void onAttachedToWindow()
  {
    int i = 0;
    super.onAttachedToWindow();
    toolbar.setTitle(getResources().getString(2131166060));
    cardTitleTextView.setText(getResources().getString(2131166064, new Object[] { chargeAccount.getType(), chargeAccount.getLastFour() }));
    View localView = errorView;
    if (chargeAccount.isFailed().booleanValue()) {}
    for (;;)
    {
      localView.setVisibility(i);
      footerView.setOnClickListener(new EditFacebookCreditCardView.1(this));
      return;
      i = 8;
    }
  }
  
  protected void onFinishInflate()
  {
    super.onFinishInflate();
    ButterKnife.bind(this);
  }
}

/* Location:
 * Qualified Name:     me.lyft.android.ui.payment.EditFacebookCreditCardView
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */