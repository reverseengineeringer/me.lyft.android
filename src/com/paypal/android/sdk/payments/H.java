package com.paypal.android.sdk.payments;

import com.paypal.android.sdk.R;
import com.paypal.android.sdk.bk;
import com.paypal.android.sdk.co;
import com.paypal.android.sdk.cp;
import java.util.HashMap;
import java.util.Locale;
import java.util.Map;

abstract class h
  implements k
{
  private aE a;
  
  protected h(aE paramaE)
  {
    a = paramaE;
  }
  
  private String a(cp paramcp, boolean paramBoolean)
  {
    String str = co.b + ":" + b() + ":" + paramcp.a();
    paramcp = str;
    if (paramBoolean) {
      paramcp = str + "|error";
    }
    return paramcp;
  }
  
  protected final aE a()
  {
    return a;
  }
  
  public final void a(cp paramcp, boolean paramBoolean, String paramString1, String paramString2, String paramString3)
  {
    bk.a();
    String str2 = Locale.getDefault().toString();
    HashMap localHashMap = new HashMap();
    boolean bool;
    String str1;
    if (!R.a(paramString1))
    {
      bool = true;
      localHashMap.put("gn", a(paramcp, bool));
      localHashMap.put("v31", a(paramcp, bool));
      str1 = a(paramcp, bool) + ":" + paramcp.a(a.d(), paramBoolean);
      if (!bool) {
        break label254;
      }
      str1 = str1 + "|error";
    }
    label254:
    for (;;)
    {
      localHashMap.put("c25", str1);
      localHashMap.put("v25", "D=c25");
      localHashMap.put("c37", co.a + "::");
      localHashMap.put("c50", str2);
      localHashMap.put("c35", "out");
      a(localHashMap, paramcp, paramString2, paramString3);
      if (paramString1 != null) {
        localHashMap.put("c29", paramString1);
      }
      a("2.9.0", localHashMap);
      return;
      bool = false;
      break;
    }
  }
  
  abstract void a(String paramString, Map paramMap);
  
  protected void a(Map paramMap, cp paramcp, String paramString1, String paramString2) {}
  
  protected abstract String b();
}

/* Location:
 * Qualified Name:     com.paypal.android.sdk.payments.h
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */