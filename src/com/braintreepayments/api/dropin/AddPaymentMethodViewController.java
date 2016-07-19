package com.braintreepayments.api.dropin;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.ScrollView;
import com.braintreepayments.api.Braintree;
import com.braintreepayments.api.dropin.view.LoadingHeader;
import com.braintreepayments.api.dropin.view.PaymentButton;
import com.braintreepayments.api.exceptions.ErrorWithResponse;
import com.braintreepayments.api.exceptions.ErrorWithResponse.BraintreeError;
import com.braintreepayments.api.exceptions.UnexpectedException;
import com.braintreepayments.api.models.CardBuilder;
import com.braintreepayments.cardform.OnCardFormFieldFocusedListener;
import com.braintreepayments.cardform.OnCardFormSubmitListener;
import com.braintreepayments.cardform.OnCardFormValidListener;
import com.braintreepayments.cardform.view.CardForm;

public class AddPaymentMethodViewController
  extends BraintreeViewController
  implements View.OnClickListener, OnCardFormFieldFocusedListener, OnCardFormSubmitListener, OnCardFormValidListener
{
  private static final String EXTRA_FORM_IS_SUBMITTING = "com.braintreepayments.api.dropin.EXTRA_FORM_IS_SUBMITTING";
  private static final String EXTRA_SUBMIT_BUTTON_ENABLED = "com.braintreepayments.api.dropin.EXTRA_SUBMIT_BUTTON_ENABLED";
  private static final String INTEGRATION_METHOD = "dropin";
  private CardForm mCardForm;
  private View mDescription;
  private boolean mIsSubmitting = false;
  private LoadingHeader mLoadingHeader;
  private PaymentButton mPaymentButton;
  private ScrollView mScrollView;
  private Button mSubmitButton;
  
  public AddPaymentMethodViewController(BraintreePaymentActivity paramBraintreePaymentActivity, Bundle paramBundle, View paramView, Braintree paramBraintree, Customization paramCustomization)
  {
    super(paramBraintreePaymentActivity, paramView, paramBraintree, paramCustomization);
    initViews();
    restoreState(paramBundle);
  }
  
  private CardBuilder getCardBuilder()
  {
    CardBuilder localCardBuilder = new CardBuilder().cardNumber(mCardForm.getCardNumber()).expirationMonth(mCardForm.getExpirationMonth()).expirationYear(mCardForm.getExpirationYear()).integration("dropin");
    if (mBraintree.isCvvChallenegePresent()) {
      localCardBuilder.cvv(mCardForm.getCvv());
    }
    if (mBraintree.isPostalCodeChallengePresent()) {
      localCardBuilder.postalCode(mCardForm.getPostalCode());
    }
    return localCardBuilder;
  }
  
  private void initViews()
  {
    mLoadingHeader = ((LoadingHeader)findView(R.id.bt_header_container));
    mScrollView = ((ScrollView)findView(R.id.bt_form_scroll_container));
    mDescription = findView(R.id.bt_description_container);
    mPaymentButton = ((PaymentButton)findView(R.id.bt_payment_button));
    mCardForm = ((CardForm)findView(R.id.bt_card_form));
    mSubmitButton = ((Button)findView(R.id.bt_card_form_submit_button));
    mPaymentButton.initialize(getActivity(), mBraintree);
    mCardForm.setRequiredFields(true, true, mBraintree.isCvvChallenegePresent(), mBraintree.isPostalCodeChallengePresent(), getCustomizedCallToAction());
    mCardForm.setOnCardFormValidListener(this);
    mCardForm.setOnCardFormSubmitListener(this);
    mCardForm.setOnFormFieldFocusedListener(this);
    mSubmitButton.setOnClickListener(this);
    mSubmitButton.setText(getSubmitButtonText());
  }
  
  private void restoreState(Bundle paramBundle)
  {
    mCardForm.onRestoreInstanceState(paramBundle);
    if (paramBundle.containsKey("com.braintreepayments.api.dropin.EXTRA_FORM_IS_SUBMITTING"))
    {
      mIsSubmitting = paramBundle.getBoolean("com.braintreepayments.api.dropin.EXTRA_FORM_IS_SUBMITTING");
      if (mIsSubmitting) {
        setUIForSubmit();
      }
    }
    if (paramBundle.containsKey("com.braintreepayments.api.dropin.EXTRA_SUBMIT_BUTTON_ENABLED")) {
      mSubmitButton.setEnabled(paramBundle.getBoolean("com.braintreepayments.api.dropin.EXTRA_SUBMIT_BUTTON_ENABLED"));
    }
    if (mCardForm.isValid()) {
      setEnabledSubmitButtonStyle();
    }
  }
  
  private void setDisabledSubmitButtonStyle()
  {
    mSubmitButton.setBackgroundResource(R.color.bt_button_disabled_color);
  }
  
  private void setEnabledSubmitButtonStyle()
  {
    mSubmitButton.setBackgroundResource(R.drawable.bt_submit_button_background);
  }
  
  private void setUIForSubmit()
  {
    mCardForm.setEnabled(false);
    mSubmitButton.setEnabled(false);
    mDescription.setVisibility(8);
    mLoadingHeader.setLoading();
  }
  
  private void showErrorUI()
  {
    mLoadingHeader.setError(getActivity().getString(R.string.bt_invalid_card));
  }
  
  private void startSubmit()
  {
    mCardForm.closeSoftKeyboard();
    mIsSubmitting = true;
    setUIForSubmit();
  }
  
  protected void endSubmit()
  {
    setDisabledSubmitButtonStyle();
    mCardForm.setEnabled(true);
    mSubmitButton.setEnabled(true);
    mIsSubmitting = false;
  }
  
  protected boolean isSubmitting()
  {
    return mIsSubmitting;
  }
  
  public void onCardFormFieldFocused(final View paramView)
  {
    mScrollView.postDelayed(new Runnable()
    {
      public void run()
      {
        mScrollView.smoothScrollTo(0, paramView.getTop());
      }
    }, 100L);
  }
  
  public void onCardFormSubmit()
  {
    mSubmitButton.performClick();
  }
  
  public void onCardFormValid(boolean paramBoolean)
  {
    if (paramBoolean)
    {
      setEnabledSubmitButtonStyle();
      return;
    }
    setDisabledSubmitButtonStyle();
  }
  
  public void onClick(View paramView)
  {
    if (paramView == mSubmitButton)
    {
      if (mCardForm.isValid())
      {
        startSubmit();
        mBraintree.create(getCardBuilder());
      }
    }
    else {
      return;
    }
    mCardForm.validate();
    setDisabledSubmitButtonStyle();
  }
  
  public void onPaymentResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    mIsSubmitting = true;
    mPaymentButton.onActivityResult(paramInt1, paramInt2, paramIntent);
  }
  
  public void onSaveInstanceState(Bundle paramBundle)
  {
    mCardForm.onSaveInstanceState(paramBundle);
    paramBundle.putBoolean("com.braintreepayments.api.dropin.EXTRA_FORM_IS_SUBMITTING", mIsSubmitting);
    paramBundle.putBoolean("com.braintreepayments.api.dropin.EXTRA_SUBMIT_BUTTON_ENABLED", mSubmitButton.isEnabled());
  }
  
  public void setErrors(ErrorWithResponse paramErrorWithResponse)
  {
    showErrorUI();
    endSubmit();
    if (paramErrorWithResponse.errorFor("creditCard") != null)
    {
      mBraintree.sendAnalyticsEvent("add-card.failed");
      paramErrorWithResponse = paramErrorWithResponse.errorFor("creditCard");
      if (paramErrorWithResponse.errorFor("number") != null) {
        mCardForm.setCardNumberError();
      }
      if ((paramErrorWithResponse.errorFor("expirationYear") != null) || (paramErrorWithResponse.errorFor("expirationMonth") != null) || (paramErrorWithResponse.errorFor("expirationDate") != null)) {
        mCardForm.setExpirationError();
      }
      if (paramErrorWithResponse.errorFor("cvv") != null) {
        mCardForm.setCvvError();
      }
      if (paramErrorWithResponse.errorFor("billingAddress") != null) {
        mCardForm.setPostalCodeError();
      }
      return;
    }
    getActivity().onUnrecoverableError(new UnexpectedException(paramErrorWithResponse.getMessage()));
  }
  
  protected void showSuccess()
  {
    mLoadingHeader.setSuccessful();
  }
}

/* Location:
 * Qualified Name:     com.braintreepayments.api.dropin.AddPaymentMethodViewController
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */