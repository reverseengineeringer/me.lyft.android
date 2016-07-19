package com.paypal.android.sdk.payments;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import android.util.Log;
import org.json.JSONException;
import org.json.JSONObject;

public final class PayPalAuthorization
  implements Parcelable
{
  public static final Parcelable.Creator CREATOR = new ah();
  private String a;
  private String b;
  private String c;
  
  static
  {
    PayPalAuthorization.class.getSimpleName();
  }
  
  private PayPalAuthorization(Parcel paramParcel)
  {
    a = paramParcel.readString();
    b = paramParcel.readString();
    c = paramParcel.readString();
  }
  
  PayPalAuthorization(String paramString1, String paramString2, String paramString3)
  {
    a = paramString1;
    b = paramString2;
    c = paramString3;
  }
  
  public final int describeContents()
  {
    return 0;
  }
  
  public final String getAuthorizationCode()
  {
    return b;
  }
  
  public final String getEnvironment()
  {
    return a;
  }
  
  public final JSONObject toJSONObject()
  {
    JSONObject localJSONObject1 = new JSONObject();
    try
    {
      JSONObject localJSONObject2 = new JSONObject();
      localJSONObject2.put("environment", a);
      localJSONObject2.put("paypal_sdk_version", "2.9.0");
      localJSONObject2.put("platform", "Android");
      localJSONObject2.put("product_name", "PayPal-Android-SDK");
      localJSONObject1.put("client", localJSONObject2);
      localJSONObject2 = new JSONObject();
      localJSONObject2.put("code", b);
      localJSONObject1.put("response", localJSONObject2);
      localJSONObject2 = new JSONObject();
      localJSONObject2.put("display_string", c);
      localJSONObject1.put("user", localJSONObject2);
      localJSONObject1.put("response_type", "authorization_code");
      return localJSONObject1;
    }
    catch (JSONException localJSONException)
    {
      Log.e("paypal.sdk", "Error encoding JSON", localJSONException);
    }
    return null;
  }
  
  public final void writeToParcel(Parcel paramParcel, int paramInt)
  {
    paramParcel.writeString(a);
    paramParcel.writeString(b);
    paramParcel.writeString(c);
  }
}

/* Location:
 * Qualified Name:     com.paypal.android.sdk.payments.PayPalAuthorization
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */