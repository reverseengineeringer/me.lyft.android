package me.lyft.android.ui.passenger.rateandpay;

import android.content.Context;
import android.content.res.Resources;
import android.util.AttributeSet;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import butterknife.ButterKnife;
import com.lyft.scoop.dagger.DaggerInjector;
import com.squareup.picasso.RequestCreator;
import java.util.List;
import javax.inject.Inject;
import me.lyft.android.application.IUserProvider;
import me.lyft.android.application.checkout.ICheckoutSession;
import me.lyft.android.application.ride.IExpenseNoteSession;
import me.lyft.android.common.AppFlow;
import me.lyft.android.common.DialogFlow;
import me.lyft.android.controls.Toolbar;
import me.lyft.android.domain.User;
import me.lyft.android.domain.passenger.ride.PassengerRideReceipt;
import me.lyft.android.domain.payment.ChargeAccount;
import me.lyft.android.managers.ImageLoader;
import me.lyft.android.persistence.ride.IPassengerRideReceiptService;
import me.lyft.android.persistence.splitfare.ISplitFareStateRepository;
import me.lyft.android.rx.Binder;
import me.lyft.android.ui.SlideMenuController;
import rx.Observable;

public class PassengerPayView
  extends LinearLayout
{
  @Inject
  AppFlow appFlow;
  BusinessPaymentMethodSelectionWidget businessPaymentMethodSelectionWidget;
  LinearLayout businessPaymentWidget;
  LinearLayout businessProfileWidget;
  private ChargeAccount chargeAccount;
  @Inject
  ICheckoutSession checkoutSession;
  @Inject
  DialogFlow dialogFlow;
  ImageView driverPhotoImageView;
  @Inject
  IExpenseNoteSession expenseNoteSession;
  private final boolean hasBusinessProfile;
  @Inject
  ImageLoader imageLoader;
  TextView lyftCreditAppliedTextView;
  Button nextButton;
  @Inject
  IPassengerRideReceiptService passengerRideReceiptService;
  PaymentMethodSelectionWidget paymentMethodSelectionWidget;
  private final PassengerPayPresenter presenter;
  @Inject
  SlideMenuController slideMenuController;
  @Inject
  ISplitFareStateRepository splitFareStateRepository;
  TextView splitInfo;
  TipSelectorWidget tipSelectorWidget;
  Toolbar toolbar;
  TextView totalAmountChargedTextView;
  @Inject
  IUserProvider userProvider;
  
  public PassengerPayView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    DaggerInjector.fromView(this).inject(this);
    presenter = new PassengerPayPresenter(checkoutSession, splitFareStateRepository, getResources(), userProvider);
    hasBusinessProfile = userProvider.getUser().hasBusinessProfile();
  }
  
  private void updatePaymentMethod(ChargeAccount paramChargeAccount)
  {
    int j = 0;
    chargeAccount = paramChargeAccount;
    Object localObject = paymentMethodSelectionWidget;
    if (hasBusinessProfile)
    {
      i = 8;
      ((PaymentMethodSelectionWidget)localObject).setVisibility(i);
      localObject = businessPaymentMethodSelectionWidget;
      if (!hasBusinessProfile) {
        break label124;
      }
    }
    label124:
    for (int i = j;; i = 8)
    {
      ((BusinessPaymentMethodSelectionWidget)localObject).setVisibility(i);
      if (!hasBusinessProfile) {
        break label130;
      }
      businessPaymentMethodSelectionWidget.updateBusinessProfile(checkoutSession.isBusinessProfile());
      businessPaymentMethodSelectionWidget.setBusinessPaymentMethodLabel(presenter.getPaymentMethodLabel(paramChargeAccount));
      businessPaymentMethodSelectionWidget.setBusinessPaymentMethodLabelColor(presenter.getPaymentMethodLabelColor(paramChargeAccount));
      businessPaymentMethodSelectionWidget.setBusinessPaymentMethodLogo(presenter.getPaymentMethodLogo(paramChargeAccount));
      return;
      i = 0;
      break;
    }
    label130:
    paymentMethodSelectionWidget.setSelectedPaymentMethodLabel(presenter.getPaymentMethodLabel(paramChargeAccount));
  }
  
  private void updatePriceInfo()
  {
    lyftCreditAppliedTextView.setText(presenter.getAppliedCreditsTitle());
    totalAmountChargedTextView.setText(presenter.getFormattedTotalAmount());
    splitInfo.setText(presenter.getSplitPaymentTitle());
    if (!hasBusinessProfile) {
      paymentMethodSelectionWidget.showConcur(expenseNoteSession.isConcurEnabled());
    }
  }
  
  private void updateViewWithTip()
  {
    int i = checkoutSession.getSelectedTipAmount();
    tipSelectorWidget.select(i);
    updatePriceInfo();
    updatePaymentMethod(chargeAccount);
  }
  
  protected void onAttachedToWindow()
  {
    super.onAttachedToWindow();
    if (isInEditMode()) {
      return;
    }
    chargeAccount = checkoutSession.getSelectedOrDefaultChargeAccount();
    toolbar.setTitle(getResources().getString(2131166204));
    slideMenuController.enableMenu();
    paymentMethodSelectionWidget.setOnClickListener(new PassengerPayView.1(this));
    businessPaymentWidget.setOnClickListener(new PassengerPayView.2(this));
    businessProfileWidget.setOnClickListener(new PassengerPayView.3(this));
    nextButton.setOnClickListener(new PassengerPayView.4(this));
    totalAmountChargedTextView.setOnClickListener(new PassengerPayView.5(this));
    imageLoader.load(passengerRideReceiptService.getRideReceipt().getDriverPhoto()).placeholder(2130838447).fit().centerCrop().into(driverPhotoImageView);
    List localList = passengerRideReceiptService.getRideReceipt().getTipOptions();
    tipSelectorWidget.createOptions(localList);
    Object localObject = Binder.attach(this);
    ((Binder)localObject).bind(tipSelectorWidget.observeSelectionChange(), new PassengerPayView.6(this));
    ((Binder)localObject).bind(checkoutSession.observeTipChange(), new PassengerPayView.7(this));
    ((Binder)localObject).bind(tipSelectorWidget.observeCustomTipClick(), new PassengerPayView.8(this));
    ((Binder)localObject).bind(checkoutSession.onDefaultChargeAccountForSessionChanged().skip(1), new PassengerPayView.9(this));
    localObject = tipSelectorWidget;
    if (localList.isEmpty()) {}
    for (int i = 4;; i = 0)
    {
      ((TipSelectorWidget)localObject).setVisibility(i);
      updateViewWithTip();
      return;
    }
  }
  
  protected void onDetachedFromWindow()
  {
    super.onDetachedFromWindow();
    slideMenuController.disableMenu();
  }
  
  protected void onFinishInflate()
  {
    super.onFinishInflate();
    if (isInEditMode()) {
      return;
    }
    ButterKnife.bind(this);
  }
}

/* Location:
 * Qualified Name:     me.lyft.android.ui.passenger.rateandpay.PassengerPayView
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */