package com.paypal.android.sdk;

import com.paypal.android.sdk.payments.PayPalService;
import java.util.HashMap;
import java.util.Map;

public final class bo
{
  private static final String a = PayPalService.class.getSimpleName();
  private static Map b = new HashMap();
  
  public static void a(String paramString)
  {
    b.remove(paramString);
  }
}

/* Location:
 * Qualified Name:     com.paypal.android.sdk.bo
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */