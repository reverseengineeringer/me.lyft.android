package me.lyft.android.ui.payment;

import android.content.Context;
import android.text.TextWatcher;
import android.util.AttributeSet;
import android.view.View.OnClickListener;
import android.view.View.OnFocusChangeListener;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.TextView.OnEditorActionListener;
import butterknife.ButterKnife;
import com.lyft.scoop.dagger.DaggerInjector;
import com.lyft.widgets.AdvancedEditText;
import javax.inject.Inject;
import me.lyft.android.application.IUserProvider;
import me.lyft.android.application.checkout.ICheckoutSession;
import me.lyft.android.application.payment.ICouponService;
import me.lyft.android.application.payment.IPaymentService;
import me.lyft.android.common.DialogFlow;
import me.lyft.android.common.Strings;
import me.lyft.android.rx.Binder;
import me.lyft.android.ui.IProgressController;
import me.lyft.android.utils.Keyboard;

public class AddCouponView
  extends LinearLayout
{
  Button applyCouponButton;
  private View.OnClickListener applyCouponClickListener = new AddCouponView.3(this);
  private Binder binder;
  @Inject
  ICheckoutSession checkoutSession;
  private View.OnFocusChangeListener couponEditFocusListener = new AddCouponView.5(this);
  AdvancedEditText couponEditText;
  private TextView.OnEditorActionListener couponEditorActionListener = new AddCouponView.4(this);
  @Inject
  ICouponService couponService;
  private TextWatcher couponTextChangedListener = new AddCouponView.2(this);
  @Inject
  DialogFlow dialogFlow;
  TextView inlineCouponError;
  @Inject
  IPaymentErrorHandler paymentErrorHandler;
  @Inject
  IPaymentService paymentService;
  @Inject
  IProgressController progressController;
  @Inject
  IUserProvider userProvider;
  
  public AddCouponView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    DaggerInjector.fromView(this).inject(this);
  }
  
  private void applyCoupon()
  {
    progressController.disableUI();
    progressController.showProgress();
    Keyboard.hideKeyboard(couponEditText);
    applyCouponButton.setEnabled(false);
    String str = couponEditText.getText().toString();
    binder.bind(couponService.applyCoupon(str), new AddCouponView.1(this));
  }
  
  private void resetCouponEditTextAndApplyButton()
  {
    couponEditText.setText("");
    couponEditText.clearFocus();
    applyCouponButton.setEnabled(false);
    applyCouponButton.setVisibility(8);
    inlineCouponError.setVisibility(8);
  }
  
  private void setCouponEditTextAndApplyButton()
  {
    if (couponEditText.length() < 1)
    {
      applyCouponButton.setEnabled(false);
      applyCouponButton.setVisibility(8);
      return;
    }
    Keyboard.showKeyboard(couponEditText);
    applyCouponButton.setVisibility(0);
  }
  
  protected void onAttachedToWindow()
  {
    super.onAttachedToWindow();
    if (isInEditMode()) {}
    do
    {
      return;
      binder = Binder.attach(this);
      couponEditText.addTextChangedListener(couponTextChangedListener);
      couponEditText.setOnEditorActionListener(couponEditorActionListener);
      couponEditText.setOnFocusChangeListener(couponEditFocusListener);
      couponEditText.setValidationMessageView(inlineCouponError);
      applyCouponButton.setOnClickListener(applyCouponClickListener);
      setCouponEditTextAndApplyButton();
    } while (Strings.isNullOrEmpty(couponEditText.getText().toString()));
    applyCoupon();
  }
  
  protected void onDetachedFromWindow()
  {
    super.onDetachedFromWindow();
    couponEditText.removeTextChangedListener(couponTextChangedListener);
    couponEditText.setOnEditorActionListener(null);
    couponEditText.setOnFocusChangeListener(null);
    Keyboard.hideKeyboard(couponEditText);
  }
  
  protected void onFinishInflate()
  {
    super.onFinishInflate();
    if (isInEditMode()) {
      return;
    }
    ButterKnife.bind(this);
  }
  
  public void setCoupon(String paramString)
  {
    couponEditText.setText(paramString.trim().toUpperCase());
  }
}

/* Location:
 * Qualified Name:     me.lyft.android.ui.payment.AddCouponView
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */