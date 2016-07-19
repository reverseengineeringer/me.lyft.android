package com.paypal.android.sdk;

import java.util.Locale;

public final class cl
  extends aW
{
  private final boolean c;
  private final int d;
  
  public cl(bh parambh, int paramInt1, boolean paramBoolean, int paramInt2)
  {
    super(paramInt1, parambh);
    c = paramBoolean;
    d = paramInt2;
  }
  
  protected final String a()
  {
    int j = d;
    StringBuilder localStringBuilder = new StringBuilder();
    int i = 0;
    while (i < j)
    {
      if (i != 0) {
        localStringBuilder.append(",\n");
      }
      String str = new String(new char[4]).replace("\000", i).substring(0, 4);
      localStringBuilder.append(String.format(Locale.US, "    {\n        \"type\":\"sms_otp\",\n        \"token_identifier\":\"mock_token_id_%s\",\n        \"token_identifier_display\":\"xxx-xxx-%s\"\n    }\n", new Object[] { Integer.valueOf(i), str }));
      i += 1;
    }
    return String.format(Locale.US, "{\n    \"nonce\":\"mock-login-nonce\",\n    \"error\":\"2fa_required\",\n    \"error_description\":\"Unable to authenticate the user. 2fa flow completion is necessary for successful login.\",\n    \"visitor_id\":\"mock-visitor_id\",\n    \"2fa_enabled\":\"true\",\n    \"2fa_token_identifier\":[\n%s    ]\n}", new Object[] { localStringBuilder.toString() });
  }
  
  protected final int b()
  {
    return 401;
  }
  
  protected final boolean c(bg parambg)
  {
    return (c) && ((parambg instanceof ce)) && (!((ce)parambg).u());
  }
}

/* Location:
 * Qualified Name:     com.paypal.android.sdk.cl
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */