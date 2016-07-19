package com.braintreepayments.api.dropin;

import android.app.AlertDialog.Builder;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.view.ContextThemeWrapper;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.TextView;
import com.braintreepayments.api.Braintree;
import com.braintreepayments.api.dropin.view.PaymentMethodView;
import com.braintreepayments.api.models.PaymentMethod;
import java.util.List;

public class SelectPaymentMethodViewController
  extends BraintreeViewController
  implements View.OnClickListener
{
  private static final String EXTRA_SELECTED_PAYMENT_METHOD = "com.braintreepayments.api.dropin.EXTRA_SELECTED_PAYMENT_METHOD";
  private int mActivePaymentMethod;
  private TextView mChangeMethodView;
  private PaymentMethodView mPaymentMethodView = (PaymentMethodView)findView(R.id.bt_selected_payment_method_view);
  private Button mSubmitButton;
  
  public SelectPaymentMethodViewController(BraintreePaymentActivity paramBraintreePaymentActivity, Bundle paramBundle, View paramView, Braintree paramBraintree, Customization paramCustomization)
  {
    super(paramBraintreePaymentActivity, paramView, paramBraintree, paramCustomization);
    mPaymentMethodView.setOnClickListener(this);
    mChangeMethodView = ((TextView)findView(R.id.bt_change_payment_method_link));
    mChangeMethodView.setOnClickListener(this);
    mSubmitButton = ((Button)findView(R.id.bt_select_payment_method_submit_button));
    mSubmitButton.setOnClickListener(this);
    mSubmitButton.setText(getSubmitButtonText());
    if (paramBundle.containsKey("com.braintreepayments.api.dropin.EXTRA_SELECTED_PAYMENT_METHOD")) {}
    for (mActivePaymentMethod = paramBundle.getInt("com.braintreepayments.api.dropin.EXTRA_SELECTED_PAYMENT_METHOD");; mActivePaymentMethod = 0)
    {
      setupPaymentMethod();
      return;
    }
  }
  
  private PaymentMethod getActivePaymentMethod()
  {
    return (PaymentMethod)mBraintree.getCachedPaymentMethods().get(mActivePaymentMethod);
  }
  
  private void launchFormView()
  {
    getActivity().initAddPaymentMethodView();
  }
  
  private void showPaymentMethodListDialog()
  {
    PaymentMethodListAdapter localPaymentMethodListAdapter = new PaymentMethodListAdapter(getActivity(), this, mBraintree.getCachedPaymentMethods());
    if (Build.VERSION.SDK_INT >= 11) {}
    for (ContextThemeWrapper localContextThemeWrapper = new ContextThemeWrapper(getActivity(), 16973941);; localContextThemeWrapper = new ContextThemeWrapper(getActivity(), 16973837))
    {
      new AlertDialog.Builder(localContextThemeWrapper).setTitle(R.string.bt_choose_payment_method).setAdapter(localPaymentMethodListAdapter, localPaymentMethodListAdapter).setPositiveButton(R.string.bt_add_new_payment_method, new DialogInterface.OnClickListener()
      {
        public void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
        {
          SelectPaymentMethodViewController.this.launchFormView();
        }
      }).show();
      return;
    }
  }
  
  public void onClick(View paramView)
  {
    if (paramView.getId() == mPaymentMethodView.getId()) {
      if (mBraintree.getCachedPaymentMethods().size() > 1) {
        showPaymentMethodListDialog();
      }
    }
    do
    {
      return;
      if (paramView.getId() == mChangeMethodView.getId())
      {
        if (mBraintree.getCachedPaymentMethods().size() == 1)
        {
          launchFormView();
          return;
        }
        showPaymentMethodListDialog();
        return;
      }
    } while (paramView.getId() != mSubmitButton.getId());
    mSubmitButton.setEnabled(false);
    getActivity().finalizeSelection(getActivePaymentMethod());
  }
  
  protected void onPaymentMethodSelected(int paramInt)
  {
    mActivePaymentMethod = paramInt;
    setupPaymentMethod();
  }
  
  public void onSaveInstanceState(Bundle paramBundle)
  {
    paramBundle.putInt("com.braintreepayments.api.dropin.EXTRA_SELECTED_PAYMENT_METHOD", mActivePaymentMethod);
  }
  
  protected void setupPaymentMethod()
  {
    mPaymentMethodView.setPaymentMethodDetails(getActivePaymentMethod());
    TextView localTextView = (TextView)findView(R.id.bt_change_payment_method_link);
    if (mBraintree.getCachedPaymentMethods().size() == 1)
    {
      localTextView.setText(R.string.bt_add_payment_method);
      return;
    }
    localTextView.setText(R.string.bt_change_payment_method);
  }
}

/* Location:
 * Qualified Name:     com.braintreepayments.api.dropin.SelectPaymentMethodViewController
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */