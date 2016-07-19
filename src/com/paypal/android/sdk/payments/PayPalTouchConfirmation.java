package com.paypal.android.sdk.payments;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import android.util.Log;
import org.json.JSONException;
import org.json.JSONObject;

public final class PayPalTouchConfirmation
  implements Parcelable
{
  public static final Parcelable.Creator CREATOR = new aI();
  private static final String a = PayPalTouchConfirmation.class.getSimpleName();
  private aJ b;
  
  private PayPalTouchConfirmation(Parcel paramParcel)
  {
    b = ((aJ)paramParcel.readParcelable(aJ.class.getClassLoader()));
  }
  
  PayPalTouchConfirmation(aJ paramaJ)
  {
    b = paramaJ;
  }
  
  public final int describeContents()
  {
    return 0;
  }
  
  public final aJ getPayPalTouchResponseBundle()
  {
    return b;
  }
  
  public final JSONObject toJSONObject()
  {
    JSONObject localJSONObject1 = new JSONObject();
    try
    {
      JSONObject localJSONObject2 = new JSONObject();
      localJSONObject2.put("paypal_sdk_version", "2.9.0");
      localJSONObject2.put("platform", "Android");
      localJSONObject2.put("product_name", "PayPal-Android-SDK");
      localJSONObject1.put("client", localJSONObject2);
      localJSONObject1.put("response", b.a());
      return localJSONObject1;
    }
    catch (JSONException localJSONException)
    {
      Log.e(a, "Error encoding JSON", localJSONException);
    }
    return null;
  }
  
  public final void writeToParcel(Parcel paramParcel, int paramInt)
  {
    paramParcel.writeParcelable(b, 0);
  }
}

/* Location:
 * Qualified Name:     com.paypal.android.sdk.payments.PayPalTouchConfirmation
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */