package com.braintreepayments.api.dropin;

import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.TextView;
import com.braintreepayments.api.Braintree;

public abstract class BraintreeViewController
{
  private BraintreePaymentActivity mActivity;
  protected final Braintree mBraintree;
  private final Customization mCustomization;
  private View mRootView;
  
  public BraintreeViewController(BraintreePaymentActivity paramBraintreePaymentActivity, View paramView, Braintree paramBraintree, Customization paramCustomization)
  {
    mActivity = paramBraintreePaymentActivity;
    mRootView = paramView;
    mBraintree = paramBraintree;
    mCustomization = paramCustomization;
    initDescriptionView();
  }
  
  private void initDescriptionSubview(int paramInt, String paramString)
  {
    if (!TextUtils.isEmpty(paramString)) {
      ((TextView)findView(paramInt)).setText(paramString);
    }
  }
  
  private void initDescriptionView()
  {
    if (!TextUtils.isEmpty(mCustomization.getPrimaryDescription()))
    {
      initDescriptionSubview(R.id.bt_primary_description, mCustomization.getPrimaryDescription());
      initDescriptionSubview(R.id.bt_secondary_description, mCustomization.getSecondaryDescription());
      initDescriptionSubview(R.id.bt_description_amount, mCustomization.getAmount());
      findView(R.id.bt_description_container).setVisibility(0);
    }
  }
  
  public <T extends View> T findView(int paramInt)
  {
    return mRootView.findViewById(paramInt);
  }
  
  protected BraintreePaymentActivity getActivity()
  {
    return mActivity;
  }
  
  protected String getCustomizedCallToAction()
  {
    String str2 = mCustomization.getSubmitButtonText();
    String str1 = str2;
    if (TextUtils.isEmpty(str2)) {
      str1 = getActivity().getString(R.string.bt_default_submit_button_text);
    }
    return str1;
  }
  
  protected String getSubmitButtonText()
  {
    String str2 = getCustomizedCallToAction();
    String str1 = str2;
    if (!TextUtils.isEmpty(mCustomization.getAmount())) {
      str1 = mCustomization.getAmount() + " - " + str2;
    }
    return str1;
  }
  
  public abstract void onSaveInstanceState(Bundle paramBundle);
}

/* Location:
 * Qualified Name:     com.braintreepayments.api.dropin.BraintreeViewController
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */