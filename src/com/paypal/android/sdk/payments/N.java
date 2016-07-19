package com.paypal.android.sdk.payments;

import android.content.Context;
import com.paypal.android.sdk.O;

class n
{
  private static final String a = n.class.getSimpleName();
  
  static boolean a(Context paramContext, PayPalService paramPayPalService)
  {
    boolean bool = false;
    String str = paramPayPalService.f();
    int i;
    if ((str.startsWith("sandbox")) || (str.equals("mock")))
    {
      i = 1;
      if (i == 0) {
        break label72;
      }
      new StringBuilder("Is mock or sandbox:").append(paramPayPalService.f());
    }
    for (;;)
    {
      new StringBuilder("returning isValid:").append(bool);
      return bool;
      i = 0;
      break;
      label72:
      if (paramPayPalService.t()) {
        bool = new O().a(paramContext, paramPayPalService.u());
      }
    }
  }
}

/* Location:
 * Qualified Name:     com.paypal.android.sdk.payments.n
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */