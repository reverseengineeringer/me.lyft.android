package com.braintreepayments.api.dropin.view;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.ImageButton;
import com.braintreepayments.api.dropin.R.drawable;

public class PayPalButton
  extends ImageButton
{
  public PayPalButton(Context paramContext)
  {
    super(paramContext);
    init();
  }
  
  public PayPalButton(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    init();
  }
  
  public PayPalButton(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    init();
  }
  
  private void init()
  {
    setBackgroundResource(R.drawable.bt_paypal_button_background);
    setImageResource(R.drawable.bt_paypal_button);
  }
}

/* Location:
 * Qualified Name:     com.braintreepayments.api.dropin.view.PayPalButton
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */