package com.paypal.android.sdk;

import java.util.Date;
import org.json.JSONException;
import org.json.JSONObject;

public final class ck
  extends ch
{
  public String a;
  private String b;
  private String c;
  private String d;
  private int e;
  private int f;
  private String g;
  private String h;
  private Date i;
  
  public ck(bh parambh, c paramc, String paramString1, String paramString2, String paramString3, String paramString4, String paramString5, int paramInt1, int paramInt2)
  {
    super(bm.g, parambh, paramc, paramString1);
    a = paramString2;
    b = paramString3;
    if (paramString4 == null) {
      throw new RuntimeException("cardNumber should not be null.  If it is, then you're probably trying to tokenize a card that's already been tokenized.");
    }
    c = paramString4;
    d = paramString5;
    e = paramInt1;
    f = paramInt2;
  }
  
  public final String b()
  {
    JSONObject localJSONObject = new JSONObject();
    localJSONObject.accumulate("payer_id", a);
    localJSONObject.accumulate("cvv2", d);
    localJSONObject.accumulate("expire_month", Integer.valueOf(e));
    localJSONObject.accumulate("expire_year", Integer.valueOf(f));
    localJSONObject.accumulate("number", c);
    localJSONObject.accumulate("type", b);
    return localJSONObject.toString();
  }
  
  public final void c()
  {
    JSONObject localJSONObject = n();
    try
    {
      g = localJSONObject.getString("id");
      String str = localJSONObject.getString("number");
      if ((h == null) || (!h.endsWith(str.substring(str.length() - 4)))) {
        h = str;
      }
      i = bU.a(localJSONObject.getString("valid_until"));
      return;
    }
    catch (JSONException localJSONException)
    {
      d();
    }
  }
  
  public final void d()
  {
    b(n());
  }
  
  public final String e()
  {
    return "{\"id\":\"CARD-50Y58962PH1899901KFFBSDA\",\"valid_until\":\"2016-03-19T00:00:00.000Z\",\"state\":\"ok\",\"type\":\"visa\",\"number\":\"xxxxxxxxxxxx" + c.substring(c.length() - 4) + "\",\"expire_month\":\"" + e + "\",\"expire_year\":\"" + f + "\",\"links\":[" + "{\"href\":\"https://api.sandbox.paypal.com/v1/vault/credit-card/CARD-50Y58962PH1899901KFFBSDA\"," + "\"rel\":\"self\",\"method\":\"GET\"" + "}]" + "}";
  }
  
  public final String u()
  {
    return g;
  }
  
  public final String v()
  {
    return h;
  }
  
  public final Date w()
  {
    return i;
  }
  
  public final String x()
  {
    return b;
  }
  
  public final int y()
  {
    return e;
  }
  
  public final int z()
  {
    return f;
  }
}

/* Location:
 * Qualified Name:     com.paypal.android.sdk.ck
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */