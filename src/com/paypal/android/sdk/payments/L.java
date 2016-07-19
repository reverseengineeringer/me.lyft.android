package com.paypal.android.sdk.payments;

import android.os.Build;
import android.os.Build.VERSION;
import com.paypal.android.sdk.R;
import com.paypal.android.sdk.c;

final class l
  implements c
{
  public final String a()
  {
    return "2.9.0";
  }
  
  public final String b()
  {
    String str1 = Build.VERSION.RELEASE;
    String str2 = Build.MANUFACTURER + " " + Build.MODEL;
    StringBuilder localStringBuilder = new StringBuilder();
    if (R.c("touch;")) {
      localStringBuilder.append("touch; ");
    }
    return String.format("PayPalSDK/%s %s (%s %s; %s; %s)", new Object[] { "PayPal-Android-SDK", "2.9.0", "Android", str1, str2, localStringBuilder.toString().trim() });
  }
  
  public final String c()
  {
    return "7e84a4db976e44cff9a7fe0efade91885d02afc6";
  }
}

/* Location:
 * Qualified Name:     com.paypal.android.sdk.payments.l
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */