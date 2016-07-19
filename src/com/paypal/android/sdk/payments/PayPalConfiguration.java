package com.paypal.android.sdk.payments;

import android.content.Context;
import android.net.Uri;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import android.util.Log;
import com.paypal.android.sdk.R;
import com.paypal.android.sdk.b;
import com.paypal.android.sdk.d;

public final class PayPalConfiguration
  implements Parcelable
{
  public static final Parcelable.Creator CREATOR = new ai();
  public static final String ENVIRONMENT_NO_NETWORK = "mock";
  public static final String ENVIRONMENT_PRODUCTION = "live";
  public static final String ENVIRONMENT_SANDBOX = "sandbox";
  private static final String a = PayPalConfiguration.class.getSimpleName();
  private String b;
  private String c;
  private String d;
  private String e;
  private String f;
  private boolean g;
  private String h;
  private String i;
  private boolean j = true;
  private String k;
  private String l;
  private Uri m;
  private Uri n;
  private boolean o = true;
  
  public PayPalConfiguration() {}
  
  private PayPalConfiguration(Parcel paramParcel)
  {
    c = paramParcel.readString();
    b = paramParcel.readString();
    d = paramParcel.readString();
    e = paramParcel.readString();
    f = paramParcel.readString();
    if (paramParcel.readByte() == 1)
    {
      bool1 = true;
      g = bool1;
      h = paramParcel.readString();
      i = paramParcel.readString();
      if (paramParcel.readByte() != 1) {
        break label171;
      }
      bool1 = true;
      label97:
      j = bool1;
      k = paramParcel.readString();
      l = paramParcel.readString();
      m = ((Uri)paramParcel.readParcelable(Uri.class.getClassLoader()));
      n = ((Uri)paramParcel.readParcelable(Uri.class.getClassLoader()));
      if (paramParcel.readByte() != 1) {
        break label176;
      }
    }
    label171:
    label176:
    for (boolean bool1 = bool2;; bool1 = false)
    {
      o = bool1;
      return;
      bool1 = false;
      break;
      bool1 = false;
      break label97;
    }
  }
  
  private static void a(boolean paramBoolean, String paramString)
  {
    if (!paramBoolean) {
      Log.e(a, paramString + " is invalid.  Please see the docs.");
    }
  }
  
  public static final String getApplicationCorrelationId(Context paramContext)
  {
    return getClientMetadataId(paramContext);
  }
  
  public static final String getClientMetadataId(Context paramContext)
  {
    new l();
    return d.a(paramContext, new b(paramContext, "AndroidBasePrefs"), "2.9.0");
  }
  
  public static final String getLibraryVersion()
  {
    return "2.9.0";
  }
  
  final String a()
  {
    return b;
  }
  
  public final PayPalConfiguration acceptCreditCards(boolean paramBoolean)
  {
    j = paramBoolean;
    return this;
  }
  
  final String b()
  {
    if (R.a(c))
    {
      c = "live";
      Log.w(a, "defaulting to production environment");
    }
    return c;
  }
  
  final String c()
  {
    return d;
  }
  
  public final PayPalConfiguration clientId(String paramString)
  {
    k = paramString;
    return this;
  }
  
  final String d()
  {
    return e;
  }
  
  public final PayPalConfiguration defaultUserEmail(String paramString)
  {
    d = paramString;
    return this;
  }
  
  public final PayPalConfiguration defaultUserPhone(String paramString)
  {
    e = paramString;
    return this;
  }
  
  public final PayPalConfiguration defaultUserPhoneCountryCode(String paramString)
  {
    f = paramString;
    return this;
  }
  
  public final int describeContents()
  {
    return 0;
  }
  
  final String e()
  {
    return f;
  }
  
  public final PayPalConfiguration environment(String paramString)
  {
    c = paramString;
    return this;
  }
  
  final boolean f()
  {
    return g;
  }
  
  public final PayPalConfiguration forceDefaultsOnSandbox(boolean paramBoolean)
  {
    g = paramBoolean;
    return this;
  }
  
  final String g()
  {
    return h;
  }
  
  final String h()
  {
    return i;
  }
  
  final boolean i()
  {
    return o;
  }
  
  final String j()
  {
    return k;
  }
  
  final String k()
  {
    return l;
  }
  
  final Uri l()
  {
    return m;
  }
  
  public final PayPalConfiguration languageOrLocale(String paramString)
  {
    b = paramString;
    return this;
  }
  
  final Uri m()
  {
    return n;
  }
  
  public final PayPalConfiguration merchantName(String paramString)
  {
    l = paramString;
    return this;
  }
  
  public final PayPalConfiguration merchantPrivacyPolicyUri(Uri paramUri)
  {
    m = paramUri;
    return this;
  }
  
  public final PayPalConfiguration merchantUserAgreementUri(Uri paramUri)
  {
    n = paramUri;
    return this;
  }
  
  final boolean n()
  {
    boolean bool2 = R.a(a, b(), "environment");
    a(bool2, "environment");
    boolean bool1;
    if (bool2) {
      if (b().equals("mock")) {
        bool1 = true;
      }
    }
    for (;;)
    {
      if ((bool2) && (bool1))
      {
        return true;
        bool1 = R.a(a, k, "clientId");
        a(bool1, "clientId");
      }
      else
      {
        return false;
        bool1 = false;
      }
    }
  }
  
  public final PayPalConfiguration rememberUser(boolean paramBoolean)
  {
    o = paramBoolean;
    return this;
  }
  
  public final PayPalConfiguration sandboxUserPassword(String paramString)
  {
    h = paramString;
    return this;
  }
  
  public final PayPalConfiguration sandboxUserPin(String paramString)
  {
    i = paramString;
    return this;
  }
  
  public final String toString()
  {
    return String.format(PayPalConfiguration.class.getSimpleName() + ": {environment:%s, client_id:%s, languageOrLocale:%s}", new Object[] { c, k, b });
  }
  
  public final void writeToParcel(Parcel paramParcel, int paramInt)
  {
    int i1 = 1;
    paramParcel.writeString(c);
    paramParcel.writeString(b);
    paramParcel.writeString(d);
    paramParcel.writeString(e);
    paramParcel.writeString(f);
    if (g)
    {
      paramInt = 1;
      paramParcel.writeByte((byte)paramInt);
      paramParcel.writeString(h);
      paramParcel.writeString(i);
      if (!j) {
        break label143;
      }
      paramInt = 1;
      label82:
      paramParcel.writeByte((byte)paramInt);
      paramParcel.writeString(k);
      paramParcel.writeString(l);
      paramParcel.writeParcelable(m, 0);
      paramParcel.writeParcelable(n, 0);
      if (!o) {
        break label148;
      }
    }
    label143:
    label148:
    for (paramInt = i1;; paramInt = 0)
    {
      paramParcel.writeByte((byte)paramInt);
      return;
      paramInt = 0;
      break;
      paramInt = 0;
      break label82;
    }
  }
}

/* Location:
 * Qualified Name:     com.paypal.android.sdk.payments.PayPalConfiguration
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */