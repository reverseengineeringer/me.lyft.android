package com.paypal.android.sdk.payments;

import com.paypal.android.sdk.R;
import com.paypal.android.sdk.ar;
import com.paypal.android.sdk.au;
import com.paypal.android.sdk.b;
import com.paypal.android.sdk.bH;
import com.paypal.android.sdk.bn;
import com.paypal.android.sdk.bx;
import com.paypal.android.sdk.cm;
import com.paypal.android.sdk.co;
import com.paypal.android.sdk.cp;
import java.util.Map;

final class i
  extends h
{
  public i(PayPalService paramPayPalService)
  {
    super(new aE(paramPayPalService));
  }
  
  protected final void a(String paramString, Map paramMap)
  {
    if (!aab.b()) {
      aab = new cm();
    }
    paramMap.put("v49", paramString);
    paramMap.put("v51", a().c().d().d());
    paramMap.put("v52", co.a + " " + co.d);
    paramMap.put("v53", co.e);
    paramMap.put("clid", a().b());
    paramMap.put("apid", bH.b() + "|" + paramString + "|" + a().f());
    au localau = new au(aab.a(), paramMap, co.c, co.b, false);
    paramMap = null;
    paramString = paramMap;
    if (a().a() != null)
    {
      paramString = paramMap;
      if (aac != null) {
        paramString = aac.a();
      }
    }
    a().a(localau, paramString);
  }
  
  protected final void a(Map paramMap, cp paramcp, String paramString1, String paramString2)
  {
    paramMap.put("g", a().e());
    paramMap.put("vers", co.a + ":" + a().d() + ":");
    paramMap.put("srce", "msdk");
    paramMap.put("sv", "mobile");
    paramMap.put("bchn", "msdk");
    paramMap.put("adte", "FALSE");
    paramMap.put("bzsr", "mobile");
    if (R.c(paramString1)) {
      paramMap.put("calc", paramString1);
    }
    if (R.c(paramString2)) {
      paramMap.put("prid", paramString2);
    }
    if (paramcp.b()) {}
    for (paramcp = "cl";; paramcp = "im")
    {
      paramMap.put("e", paramcp);
      return;
    }
  }
  
  protected final String b()
  {
    return "msdk";
  }
}

/* Location:
 * Qualified Name:     com.paypal.android.sdk.payments.i
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */