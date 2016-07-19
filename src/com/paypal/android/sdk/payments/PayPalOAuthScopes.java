package com.paypal.android.sdk.payments;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import android.text.TextUtils;
import com.paypal.android.sdk.L;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

public final class PayPalOAuthScopes
  implements Parcelable
{
  public static final Parcelable.Creator CREATOR = new ap();
  public static final String PAYPAL_SCOPE_ADDRESS;
  public static final String PAYPAL_SCOPE_EMAIL;
  public static final String PAYPAL_SCOPE_FUTURE_PAYMENTS = L.a.a();
  public static final String PAYPAL_SCOPE_OPENID;
  public static final String PAYPAL_SCOPE_PAYPAL_ATTRIBUTES;
  public static final String PAYPAL_SCOPE_PHONE;
  public static final String PAYPAL_SCOPE_PROFILE = L.b.a();
  private List a = new ArrayList();
  
  static
  {
    PAYPAL_SCOPE_PAYPAL_ATTRIBUTES = L.c.a();
    PAYPAL_SCOPE_EMAIL = L.e.a();
    PAYPAL_SCOPE_ADDRESS = L.f.a();
    PAYPAL_SCOPE_PHONE = L.g.a();
    PAYPAL_SCOPE_OPENID = L.d.a();
  }
  
  public PayPalOAuthScopes() {}
  
  private PayPalOAuthScopes(Parcel paramParcel)
  {
    int j = paramParcel.readInt();
    int i = 0;
    while (i < j)
    {
      a.add(paramParcel.readString());
      i += 1;
    }
  }
  
  public PayPalOAuthScopes(Set paramSet)
  {
    this();
    paramSet = paramSet.iterator();
    while (paramSet.hasNext())
    {
      String str = (String)paramSet.next();
      a.add(str);
    }
  }
  
  final List a()
  {
    return a;
  }
  
  final String b()
  {
    return TextUtils.join(" ", a);
  }
  
  public final int describeContents()
  {
    return 0;
  }
  
  public final String toString()
  {
    return String.format(PayPalOAuthScopes.class.getSimpleName() + ": {%s}", new Object[] { a });
  }
  
  public final void writeToParcel(Parcel paramParcel, int paramInt)
  {
    paramParcel.writeInt(a.size());
    paramInt = 0;
    while (paramInt < a.size())
    {
      paramParcel.writeString((String)a.get(paramInt));
      paramInt += 1;
    }
  }
}

/* Location:
 * Qualified Name:     com.paypal.android.sdk.payments.PayPalOAuthScopes
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */