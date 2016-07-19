package com.paypal.android.sdk;

public enum cp
{
  private boolean A;
  private String x;
  private String y;
  private boolean z;
  
  static
  {
    c = new cp("ConfirmPayment", 7, "confirmpayment", "confirm", false, false);
    w = new cp("ConfirmPaymentCancel", 8, "confirmpayment", "cancel", false, true);
    d = new cp("PaymentSuccessful", 9, "paymentsuccessful", "", false, false);
    e = new cp("LoginWindow", 10, "login", "password", true, false);
    f = new cp("LoginPassword", 11, "login", "password", true, true);
    g = new cp("LoginPIN", 12, "login", "PIN", true, true);
    h = new cp("SignUp", 13, "login", "password", true, true);
    i = new cp("LoginForgotPassword", 14, "login", "password", true, true);
    j = new cp("LoginCancel", 15, "login", "cancel", true, true);
    k = new cp("ConsentWindow", 16, "authorizationconsent", "", false, false);
    l = new cp("ConsentAgree", 17, "authorizationconsent", "agree", false, true);
    m = new cp("ConsentCancel", 18, "authorizationconsent", "cancel", false, true);
    n = new cp("ConsentMerchantUrl", 19, "authorizationconsent", "merchanturl", false, true);
    o = new cp("ConsentPayPalPrivacyUrl", 20, "authorizationconsent", "privacy", false, true);
    p = new cp("AuthorizationSuccessful", 21, "authorizationsuccessful", "", false, false);
    q = new cp("LegalTextWindow", 22, "legaltext", "", false, false);
  }
  
  private cp(String paramString2, String paramString3, boolean paramBoolean1, boolean paramBoolean2)
  {
    x = paramString2;
    y = paramString3;
    z = paramBoolean1;
    A = paramBoolean2;
  }
  
  public final String a()
  {
    return x + "::" + y;
  }
  
  public final String a(String paramString, boolean paramBoolean)
  {
    String str;
    if (z) {
      if (paramBoolean) {
        str = "returnuser";
      }
    }
    for (;;)
    {
      return co.a + ":" + paramString + ":" + str;
      str = "newuser";
      continue;
      str = "";
    }
  }
  
  public final boolean b()
  {
    return A;
  }
}

/* Location:
 * Qualified Name:     com.paypal.android.sdk.cp
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */