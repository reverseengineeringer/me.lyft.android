package com.paypal.android.sdk.payments;

import android.app.Activity;
import android.app.Dialog;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;
import com.paypal.android.sdk.R;
import com.paypal.android.sdk.cA;
import com.paypal.android.sdk.cB;
import com.paypal.android.sdk.cq;
import com.paypal.android.sdk.cs;
import com.paypal.android.sdk.cy;
import com.paypal.android.sdk.cz;
import java.util.Arrays;
import java.util.Date;
import java.util.Timer;

public final class PayPalFuturePaymentActivity
  extends Activity
{
  public static final String EXTRA_RESULT_AUTHORIZATION = "com.paypal.android.sdk.authorization";
  public static final int RESULT_EXTRAS_INVALID = 2;
  private static final String a = PayPalFuturePaymentActivity.class.getSimpleName();
  private Date b;
  private Timer c;
  private PayPalService d;
  private final ServiceConnection e = new ak(this);
  private boolean f;
  
  private void b()
  {
    FuturePaymentConsentActivity.a(this, 1, d.e());
  }
  
  private aA c()
  {
    return new am(this);
  }
  
  public final void finish()
  {
    super.finish();
    new StringBuilder().append(a).append(".finish");
  }
  
  protected final void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    super.onActivityResult(paramInt1, paramInt2, paramIntent);
    new StringBuilder().append(a).append(".onActivityResult");
    if (paramInt1 == 1) {
      switch (paramInt2)
      {
      default: 
        Log.wtf(a, "unexpected request code " + paramInt1 + " call it a cancel");
      }
    }
    for (;;)
    {
      finish();
      return;
      if (paramIntent != null)
      {
        paramIntent = (PayPalAuthorization)paramIntent.getParcelableExtra("com.paypal.android.sdk.authorization");
        if (paramIntent != null)
        {
          Intent localIntent = new Intent();
          localIntent.putExtra("com.paypal.android.sdk.authorization", paramIntent);
          setResult(-1, localIntent);
        }
        else
        {
          Log.e(a, "result was OK, have data, but no authorization state in bundle, oops");
        }
      }
      else
      {
        Log.e(a, "result was OK, no intent data, oops");
      }
    }
  }
  
  protected final void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    new StringBuilder().append(a).append(".onCreate");
    new cB(this).a();
    new cA(this).a();
    new cz(this).a(Arrays.asList(new String[] { PayPalFuturePaymentActivity.class.getName(), LoginActivity.class.getName(), FuturePaymentInfoActivity.class.getName(), FuturePaymentConsentActivity.class.getName() }));
    f = bindService(d.a(this), e, 1);
    R.b(this);
    R.a(this);
    paramBundle = new cy(this);
    setContentView(a);
    b.setText(cq.a(cs.y));
    d.a(this, null, cs.y);
  }
  
  protected final Dialog onCreateDialog(int paramInt, Bundle paramBundle)
  {
    switch (paramInt)
    {
    default: 
      return d.a(this, cs.bb, paramBundle, paramInt);
    case 2: 
      return d.a(this, new aj(this));
    }
    return d.a(this, cs.bd, paramBundle, paramInt);
  }
  
  protected final void onDestroy()
  {
    new StringBuilder().append(a).append(".onDestroy");
    if (d != null)
    {
      d.o();
      d.r();
    }
    if (f)
    {
      unbindService(e);
      f = false;
    }
    super.onDestroy();
  }
}

/* Location:
 * Qualified Name:     com.paypal.android.sdk.payments.PayPalFuturePaymentActivity
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */