package me.lyft.android.ui.passenger.rateandpay;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.LinearLayout;
import butterknife.ButterKnife;
import com.lyft.scoop.dagger.DaggerInjector;
import javax.inject.Inject;
import me.lyft.android.controls.Toolbar;
import me.lyft.android.domain.passenger.ride.PassengerRideReceipt;
import me.lyft.android.persistence.ride.IPassengerRideReceiptService;
import me.lyft.android.ui.WebBrowserView;

public class PaymentHelpView
  extends LinearLayout
{
  @Inject
  IPassengerRideReceiptService rideFareRepository;
  Toolbar toolbar;
  WebBrowserView webBrowserView;
  
  public PaymentHelpView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    DaggerInjector.fromView(this).inject(this);
  }
  
  private String getPricingUrl()
  {
    return rideFareRepository.getRideReceipt().getPricingUrl();
  }
  
  protected void onFinishInflate()
  {
    super.onFinishInflate();
    ButterKnife.bind(this);
    webBrowserView.setProgressIndicatorBackgroundColor(-1);
    webBrowserView.setOverviewMode(true);
    webBrowserView.setTargetUrl(getPricingUrl());
    toolbar.setTitle(getContext().getString(2131166074));
  }
}

/* Location:
 * Qualified Name:     me.lyft.android.ui.passenger.rateandpay.PaymentHelpView
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */