package me.lyft.android.ui.passenger.v2.request.widgets;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.TextView;
import butterknife.ButterKnife;
import com.lyft.scoop.dagger.DaggerInjector;
import javax.inject.Inject;
import me.lyft.android.common.DialogFlow;

public class WidgetContainer
  extends LinearLayout
  implements WidgetContainerPresenter.WidgetContainerView
{
  TextView businessCcLabel;
  ImageView businessCcLogo;
  LinearLayout businessPaymentWidget;
  @Inject
  PaymentWidgetPresenter businessPaymentWidgetPresenter;
  final PaymentWidgetPresenter.PaymentWidgetView businessPaymentWidgetView = new WidgetContainer.11(this);
  View businessProfileDivider;
  TextView businessProfileLabel;
  LinearLayout businessProfileLayout;
  ImageView businessProfileLogo;
  LinearLayout businessProfileWidget;
  @Inject
  BusinessProfileWidgetPresenter businessProfileWidgetPresenter;
  final BusinessProfileWidgetPresenter.BusinessProfileWidgetView businessProfileWidgetView = new WidgetContainer.12(this);
  ImageView ccConcurLogo;
  TextView ccLabel;
  ImageView ccLogo;
  @Inject
  DialogFlow dialogFlow;
  TextView errorStateLabel;
  TextView fixedFareComparisonLabel;
  TextView fixedFarePriceLabel;
  ProgressBar fixedFareProgress;
  final FixedFareWidgetPresenter.FixedFareView fixedFareView = new WidgetContainer.9(this);
  LinearLayout fixedFareWidget;
  FrameLayout fixedFareWidgetContainer;
  @Inject
  FixedFareWidgetPresenter fixedFareWidgetPresenter;
  LinearLayout paymentLayout;
  LinearLayout paymentWidget;
  TextView paymentWidgetLabel;
  @Inject
  PaymentWidgetPresenter paymentWidgetPresenter;
  final PaymentWidgetPresenter.PaymentWidgetView paymentWidgetView = new WidgetContainer.10(this);
  TextView priceEstimateLabel;
  ImageView priceEstimateLabelPlaceholder;
  View priceEstimateLayout;
  ProgressBar priceEstimateLoading;
  @Inject
  PriceEstimatePresenter priceEstimatePresenter;
  final PriceEstimatePresenter.PriceEstimateView priceEstimateView = new WidgetContainer.7(this);
  View priceEstimateWidget;
  TextView primeTimeAmountLabel;
  LinearLayout primeTimeWidget;
  @Inject
  PrimeTimeWidgetPresenter primeTimeWidgetPresenter;
  final PrimeTimeWidgetPresenter.PrimeTimeWidgetView primeTimeWidgetView = new WidgetContainer.8(this);
  @Inject
  WidgetContainerPresenter widgetContainerPresenter;
  
  public WidgetContainer(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    DaggerInjector.fromView(this).inject(this);
  }
  
  protected void onAttachedToWindow()
  {
    super.onAttachedToWindow();
    if (isInEditMode()) {
      return;
    }
    widgetContainerPresenter.attachView(this);
    fixedFareWidgetPresenter.attachView(fixedFareView);
    paymentWidgetPresenter.attachView(paymentWidgetView);
    businessPaymentWidgetPresenter.attachView(businessPaymentWidgetView);
    businessProfileWidgetPresenter.attachView(businessProfileWidgetView);
    primeTimeWidgetPresenter.attachView(primeTimeWidgetView);
    priceEstimatePresenter.attachView(priceEstimateView);
  }
  
  protected void onDetachedFromWindow()
  {
    widgetContainerPresenter.detachView(this);
    fixedFareWidgetPresenter.detachView(fixedFareView);
    paymentWidgetPresenter.detachView(paymentWidgetView);
    businessPaymentWidgetPresenter.detachView(businessPaymentWidgetView);
    businessProfileWidgetPresenter.detachView(businessProfileWidgetView);
    primeTimeWidgetPresenter.detachView(primeTimeWidgetView);
    priceEstimatePresenter.detachView(priceEstimateView);
    super.onDetachedFromWindow();
  }
  
  protected void onFinishInflate()
  {
    super.onFinishInflate();
    if (isInEditMode()) {
      return;
    }
    ButterKnife.bind(this);
    priceEstimateWidget.setOnClickListener(new WidgetContainer.1(this));
    primeTimeWidget.setOnClickListener(new WidgetContainer.2(this));
    fixedFareWidget.setOnClickListener(new WidgetContainer.3(this));
    paymentWidget.setOnClickListener(new WidgetContainer.4(this));
    businessPaymentWidget.setOnClickListener(new WidgetContainer.5(this));
    businessProfileWidget.setOnClickListener(new WidgetContainer.6(this));
  }
  
  public void showBusinessProfilePaymentWidget(boolean paramBoolean)
  {
    int j = 0;
    Object localObject = businessProfileLayout;
    if (paramBoolean)
    {
      i = 0;
      ((LinearLayout)localObject).setVisibility(i);
      localObject = businessProfileDivider;
      if (!paramBoolean) {
        break label45;
      }
    }
    label45:
    for (int i = j;; i = 8)
    {
      ((View)localObject).setVisibility(i);
      return;
      i = 8;
      break;
    }
  }
  
  public void showErrorMessage(String paramString)
  {
    errorStateLabel.setText(paramString);
  }
  
  public void showErrorWidget(boolean paramBoolean)
  {
    TextView localTextView = errorStateLabel;
    if (paramBoolean) {}
    for (int i = 0;; i = 8)
    {
      localTextView.setVisibility(i);
      return;
    }
  }
  
  public void showFixedFareWidget(boolean paramBoolean)
  {
    FrameLayout localFrameLayout = fixedFareWidgetContainer;
    if (paramBoolean) {}
    for (int i = 0;; i = 8)
    {
      localFrameLayout.setVisibility(i);
      return;
    }
  }
  
  public void showPaymentLayout(boolean paramBoolean)
  {
    LinearLayout localLinearLayout = paymentLayout;
    if (paramBoolean) {}
    for (int i = 0;; i = 8)
    {
      localLinearLayout.setVisibility(i);
      if (!paramBoolean) {
        businessProfileDivider.setVisibility(8);
      }
      return;
    }
  }
  
  public void showPaymentWidget(boolean paramBoolean)
  {
    LinearLayout localLinearLayout = paymentWidget;
    if (paramBoolean) {}
    for (int i = 0;; i = 8)
    {
      localLinearLayout.setVisibility(i);
      return;
    }
  }
  
  public void showPriceEstimateWidget(boolean paramBoolean)
  {
    View localView = priceEstimateWidget;
    if (paramBoolean) {}
    for (int i = 0;; i = 8)
    {
      localView.setVisibility(i);
      return;
    }
  }
  
  public void showPrimeTimeWidget(boolean paramBoolean)
  {
    LinearLayout localLinearLayout = primeTimeWidget;
    if (paramBoolean) {}
    for (int i = 0;; i = 8)
    {
      localLinearLayout.setVisibility(i);
      return;
    }
  }
}

/* Location:
 * Qualified Name:     me.lyft.android.ui.passenger.v2.request.widgets.WidgetContainer
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */