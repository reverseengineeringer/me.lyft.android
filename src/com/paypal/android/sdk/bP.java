package com.paypal.android.sdk;

public final class bp
{
  private b a;
  private String b;
  private h c;
  
  static
  {
    if (!bp.class.desiredAssertionStatus()) {}
    for (boolean bool = true;; bool = false)
    {
      d = bool;
      return;
    }
  }
  
  public bp(b paramb, String paramString, h paramh)
  {
    if ((!d) && (paramb == null)) {
      throw new AssertionError();
    }
    a = paramb;
    b = ("com.paypal.android.sdk." + paramString + ".");
    c = paramh;
  }
  
  public final bu a(String paramString)
  {
    Object localObject = a.a(b + "tokenizedRedactedCardNumber", null);
    String str1 = a.a(b + "token", null);
    String str2 = a.a(b + "tokenPayerID", null);
    String str3 = a.a(b + "tokenValidUntil", null);
    String str4 = a.a(b + "tokenizedCardType", null);
    int i = Integer.parseInt(a.a(b + "tokenizedCardExpiryMonth", "1"));
    int j = Integer.parseInt(a.a(b + "tokenizedCardExpiryYear", "0"));
    String str5 = c.b(a.a(b + "tokenClientId", null));
    if ((R.b(str5)) || (!str5.equals(paramString))) {
      paramString = null;
    }
    do
    {
      return paramString;
      localObject = new bu(str1, str2, str3, (String)localObject, str4, i, j);
      paramString = (String)localObject;
    } while (((bu)localObject).b());
    return null;
  }
  
  public final void a(bq parambq)
  {
    Object localObject2 = null;
    if (parambq.a() != null) {}
    for (Object localObject1 = parambq.a().b();; localObject1 = null)
    {
      a.b(b + "loginPhoneNumber", (String)localObject1);
      a.b(b + "loginEmail", parambq.b());
      localObject1 = localObject2;
      if (parambq.c() != null) {
        localObject1 = parambq.c().toString();
      }
      a.b(b + "loginTypePrevious", (String)localObject1);
      return;
    }
  }
  
  public final void a(bu parambu, String paramString)
  {
    Object localObject2 = null;
    a.b(b + "token", parambu.e());
    a.b(b + "tokenPayerID", parambu.a());
    if (parambu.c() != null) {}
    for (Object localObject1 = new bU().format(parambu.c());; localObject1 = null)
    {
      a.b(b + "tokenValidUntil", (String)localObject1);
      a.b(b + "tokenizedRedactedCardNumber", parambu.d());
      localObject1 = localObject2;
      if (parambu.h() != null) {
        localObject1 = parambu.h().toString();
      }
      a.b(b + "tokenizedCardType", (String)localObject1);
      a.b(b + "tokenizedCardExpiryMonth", String.valueOf(parambu.f()));
      a.b(b + "tokenizedCardExpiryYear", String.valueOf(parambu.g()));
      a.b(b + "tokenClientId", c.a(paramString));
      return;
    }
  }
}

/* Location:
 * Qualified Name:     com.paypal.android.sdk.bp
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */