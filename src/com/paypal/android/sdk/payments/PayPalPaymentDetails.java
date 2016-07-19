package com.paypal.android.sdk.payments;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import android.util.Log;
import java.math.BigDecimal;
import org.json.JSONException;
import org.json.JSONObject;

public final class PayPalPaymentDetails
  implements Parcelable
{
  public static final Parcelable.Creator CREATOR = new aq();
  private static final String a = PayPalPaymentDetails.class.getSimpleName();
  private BigDecimal b;
  private BigDecimal c;
  private BigDecimal d;
  
  private PayPalPaymentDetails(Parcel paramParcel)
  {
    for (;;)
    {
      try
      {
        Object localObject1 = paramParcel.readString();
        if (localObject1 == null)
        {
          localObject1 = null;
          c = ((BigDecimal)localObject1);
          localObject1 = paramParcel.readString();
          if (localObject1 == null)
          {
            localObject1 = null;
            b = ((BigDecimal)localObject1);
            paramParcel = paramParcel.readString();
            if (paramParcel != null) {
              break label90;
            }
            paramParcel = (Parcel)localObject2;
            d = paramParcel;
          }
        }
        else
        {
          localObject1 = new BigDecimal((String)localObject1);
          continue;
        }
        localObject1 = new BigDecimal((String)localObject1);
      }
      catch (NumberFormatException paramParcel)
      {
        throw new RuntimeException("error unparceling PayPalPaymentDetails");
      }
      continue;
      label90:
      paramParcel = new BigDecimal(paramParcel);
    }
  }
  
  public PayPalPaymentDetails(BigDecimal paramBigDecimal1, BigDecimal paramBigDecimal2, BigDecimal paramBigDecimal3)
  {
    c = paramBigDecimal1;
    b = paramBigDecimal2;
    d = paramBigDecimal3;
  }
  
  public final int describeContents()
  {
    return 0;
  }
  
  public final boolean isProcessable()
  {
    return b != null;
  }
  
  public final JSONObject toJSONObject()
  {
    JSONObject localJSONObject = new JSONObject();
    try
    {
      if (c != null) {
        localJSONObject.put("shipping", c.toPlainString());
      }
      if (b != null) {
        localJSONObject.put("subtotal", b.toPlainString());
      }
      if (d != null) {
        localJSONObject.put("tax", d.toPlainString());
      }
      return localJSONObject;
    }
    catch (JSONException localJSONException)
    {
      Log.e(a, "error encoding JSON", localJSONException);
    }
    return null;
  }
  
  public final void writeToParcel(Parcel paramParcel, int paramInt)
  {
    Object localObject2 = null;
    if (c == null)
    {
      localObject1 = null;
      paramParcel.writeString((String)localObject1);
      if (b != null) {
        break label58;
      }
      localObject1 = null;
      label26:
      paramParcel.writeString((String)localObject1);
      if (d != null) {
        break label69;
      }
    }
    label58:
    label69:
    for (Object localObject1 = localObject2;; localObject1 = d.toString())
    {
      paramParcel.writeString((String)localObject1);
      return;
      localObject1 = c.toString();
      break;
      localObject1 = b.toString();
      break label26;
    }
  }
}

/* Location:
 * Qualified Name:     com.paypal.android.sdk.payments.PayPalPaymentDetails
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */