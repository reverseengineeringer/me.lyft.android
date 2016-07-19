package com.paypal.android.sdk.payments;

import com.paypal.android.sdk.ar;
import com.paypal.android.sdk.au;
import com.paypal.android.sdk.b;
import com.paypal.android.sdk.bC;
import com.paypal.android.sdk.bn;
import com.paypal.android.sdk.co;
import java.util.Map;

final class j
  extends h
{
  public j(PayPalService paramPayPalService)
  {
    super(new aE(paramPayPalService));
  }
  
  protected final void a(String paramString, Map paramMap)
  {
    if (!aaa.b())
    {
      aaa = new bC();
      paramMap.put("v49", paramString);
      paramMap.put("v51", a().c().d().d());
      paramMap.put("v52", co.a + " " + co.d);
      paramMap.put("v53", co.e);
    }
    paramString = new au(aaa.a(), paramMap, co.c, co.b, true);
    a().a(paramString, null);
  }
  
  protected final String b()
  {
    return "mpl";
  }
}

/* Location:
 * Qualified Name:     com.paypal.android.sdk.payments.j
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */