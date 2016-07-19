package com.paypal.android.sdk.payments;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import com.paypal.android.sdk.R;
import com.paypal.android.sdk.cq;
import com.paypal.android.sdk.cs;

public final class FuturePaymentInfoActivity
  extends Activity
{
  private G a;
  
  protected final void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    paramBundle = (F)getIntent().getExtras().getSerializable("com.paypal.details.scope");
    R.b(this);
    R.a(this);
    a = new G(this, paramBundle);
    setContentView(a.a);
    d.a(this, a.b, null);
    a.c.setText(cq.a(cs.d));
    a.c.setOnClickListener(new E(this));
  }
}

/* Location:
 * Qualified Name:     com.paypal.android.sdk.payments.FuturePaymentInfoActivity
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */