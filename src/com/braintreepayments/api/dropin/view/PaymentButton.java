package com.braintreepayments.api.dropin.view;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.util.AttributeSet;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ImageButton;
import android.widget.RelativeLayout;
import com.braintreepayments.api.Braintree;
import com.braintreepayments.api.PayPalHelper;
import com.braintreepayments.api.dropin.R.id;
import com.braintreepayments.api.dropin.R.layout;

public class PaymentButton
  extends RelativeLayout
  implements View.OnClickListener
{
  public static final int REQUEST_CODE = 11876;
  private Activity mActivity;
  private Braintree mBraintree;
  private int mRequestCode;
  
  public PaymentButton(Context paramContext)
  {
    super(paramContext);
  }
  
  public PaymentButton(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
  }
  
  public PaymentButton(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
  }
  
  public void initialize(Activity paramActivity, Braintree paramBraintree)
  {
    initialize(paramActivity, paramBraintree, 11876);
  }
  
  public void initialize(Activity paramActivity, Braintree paramBraintree, int paramInt)
  {
    mActivity = paramActivity;
    mBraintree = paramBraintree;
    mRequestCode = paramInt;
    inflate(getContext(), R.layout.bt_payment_button, this);
    boolean bool1 = mBraintree.isPayPalEnabled();
    boolean bool2 = mBraintree.isVenmoEnabled();
    if ((!bool1) && (!bool2)) {
      setVisibility(8);
    }
    do
    {
      return;
      if (bool1)
      {
        paramActivity = (ImageButton)findViewById(R.id.bt_paypal_button);
        paramActivity.setVisibility(0);
        paramActivity.setOnClickListener(this);
      }
      if (bool2)
      {
        paramActivity = (ImageButton)findViewById(R.id.bt_venmo_button);
        paramActivity.setVisibility(0);
        paramActivity.setOnClickListener(this);
      }
    } while ((!bool1) || (!bool2));
    findViewById(R.id.bt_payment_button_divider).setVisibility(0);
  }
  
  public void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    if ((paramInt1 == mRequestCode) && (paramInt2 == -1))
    {
      if (PayPalHelper.isPayPalIntent(paramIntent)) {
        mBraintree.finishPayWithPayPal(mActivity, paramInt2, paramIntent);
      }
    }
    else {
      return;
    }
    mBraintree.finishPayWithVenmo(paramInt2, paramIntent);
  }
  
  public void onClick(View paramView)
  {
    if (paramView.getId() == R.id.bt_paypal_button) {
      mBraintree.startPayWithPayPal(mActivity, mRequestCode);
    }
    while (paramView.getId() != R.id.bt_venmo_button) {
      return;
    }
    mBraintree.startPayWithVenmo(mActivity, mRequestCode);
  }
}

/* Location:
 * Qualified Name:     com.braintreepayments.api.dropin.view.PaymentButton
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */