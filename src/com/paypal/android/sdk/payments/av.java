package com.paypal.android.sdk.payments;

import android.content.Intent;
import android.net.Uri;
import com.paypal.android.sdk.L;
import com.paypal.android.sdk.R;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;

class av
  extends C
{
  private boolean a;
  
  av(Intent paramIntent, PayPalConfiguration paramPayPalConfiguration, boolean paramBoolean)
  {
    super(paramIntent, paramPayPalConfiguration);
    a = paramBoolean;
  }
  
  private static boolean a(String paramString)
  {
    try
    {
      new URL(paramString);
      return true;
    }
    catch (MalformedURLException paramString) {}
    return false;
  }
  
  protected String a()
  {
    return PayPalFuturePaymentActivity.class.getSimpleName();
  }
  
  boolean e()
  {
    boolean bool4 = R.c(c().k());
    a(bool4, "merchantName");
    boolean bool2;
    boolean bool3;
    label127:
    boolean bool1;
    label143:
    Object localObject;
    if ((c().l() != null) && (R.a(a(), c().l().toString(), "merchantPrivacyPolicyUrl")) && (a(c().l().toString())))
    {
      bool2 = true;
      a(bool2, "merchantPrivacyPolicyUrl");
      if ((c().m() == null) || (!R.a(a(), c().m().toString(), "merchantUserAgreementUrl")) || (!a(c().m().toString()))) {
        break label202;
      }
      bool3 = true;
      a(bool3, "merchantUserAgreementUrl");
      if (a) {
        break label207;
      }
      bool1 = true;
      if (a)
      {
        localObject = (PayPalOAuthScopes)b().getParcelableExtra("com.paypal.android.sdk.requested_scopes");
        if (localObject != null) {
          break label212;
        }
        bool1 = false;
      }
    }
    for (;;)
    {
      a(bool1, "paypalScopes");
      if ((!bool4) || (!bool2) || (!bool3) || (!bool1)) {
        break label295;
      }
      return true;
      bool2 = false;
      break;
      label202:
      bool3 = false;
      break label127;
      label207:
      bool1 = false;
      break label143;
      label212:
      if ((((PayPalOAuthScopes)localObject).a() == null) || (((PayPalOAuthScopes)localObject).a().size() <= 0))
      {
        bool1 = false;
      }
      else
      {
        localObject = ((PayPalOAuthScopes)localObject).a().iterator();
        for (;;)
        {
          if (((Iterator)localObject).hasNext())
          {
            String str = (String)((Iterator)localObject).next();
            if (!L.p.contains(str))
            {
              bool1 = false;
              break;
            }
          }
        }
        bool1 = true;
      }
    }
    label295:
    return false;
  }
}

/* Location:
 * Qualified Name:     com.paypal.android.sdk.payments.av
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */