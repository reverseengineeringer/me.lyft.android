package com.paypal.android.sdk.payments;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import android.util.Log;
import com.paypal.android.sdk.R;
import com.paypal.android.sdk.bI;
import java.math.BigDecimal;
import org.json.JSONArray;
import org.json.JSONObject;

public final class PayPalItem
  implements Parcelable
{
  public static final Parcelable.Creator CREATOR = new ao();
  private String a;
  private Integer b;
  private BigDecimal c;
  private String d;
  private String e;
  
  static
  {
    PayPalItem.class.getSimpleName();
  }
  
  private PayPalItem(Parcel paramParcel)
  {
    a = paramParcel.readString();
    b = Integer.valueOf(paramParcel.readInt());
    try
    {
      c = new BigDecimal(paramParcel.readString());
      d = paramParcel.readString();
      e = paramParcel.readString();
      return;
    }
    catch (NumberFormatException localNumberFormatException)
    {
      for (;;) {}
    }
  }
  
  public PayPalItem(String paramString1, Integer paramInteger, BigDecimal paramBigDecimal, String paramString2, String paramString3)
  {
    a = paramString1;
    b = paramInteger;
    c = paramBigDecimal;
    d = paramString2;
    e = paramString3;
  }
  
  public static BigDecimal getItemTotal(PayPalItem[] paramArrayOfPayPalItem)
  {
    BigDecimal localBigDecimal = new BigDecimal("0.00");
    int j = paramArrayOfPayPalItem.length;
    int i = 0;
    while (i < j)
    {
      PayPalItem localPayPalItem = paramArrayOfPayPalItem[i];
      localBigDecimal = localBigDecimal.add(c.multiply(BigDecimal.valueOf(b.intValue())));
      i += 1;
    }
    return localBigDecimal;
  }
  
  public static JSONArray toJSONArray(PayPalItem[] paramArrayOfPayPalItem)
  {
    JSONArray localJSONArray = new JSONArray();
    int j = paramArrayOfPayPalItem.length;
    int i = 0;
    while (i < j)
    {
      PayPalItem localPayPalItem = paramArrayOfPayPalItem[i];
      JSONObject localJSONObject = new JSONObject();
      localJSONObject.accumulate("quantity", Integer.toString(b.intValue()));
      localJSONObject.accumulate("name", a);
      localJSONObject.accumulate("price", c.toString());
      localJSONObject.accumulate("currency", d);
      if (e != null) {
        localJSONObject.accumulate("sku", e);
      }
      localJSONArray.put(localJSONObject);
      i += 1;
    }
    return localJSONArray;
  }
  
  public final int describeContents()
  {
    return 0;
  }
  
  public final String getCurrency()
  {
    return d;
  }
  
  public final String getName()
  {
    return a;
  }
  
  public final BigDecimal getPrice()
  {
    return c;
  }
  
  public final Integer getQuantity()
  {
    return b;
  }
  
  public final String getSku()
  {
    return e;
  }
  
  public final boolean isValid()
  {
    if (b.intValue() <= 0)
    {
      Log.e("paypal.sdk", "item.quantity must be a positive integer.");
      return false;
    }
    if (!bI.a(d))
    {
      Log.e("paypal.sdk", "item.currency field is required, and must be a supported currency.");
      return false;
    }
    if (R.b(a))
    {
      Log.e("paypal.sdk", "item.name field is required.");
      return false;
    }
    if (!bI.a(c, d, false))
    {
      Log.e("paypal.sdk", "item.price field is required.");
      return false;
    }
    return true;
  }
  
  public final void writeToParcel(Parcel paramParcel, int paramInt)
  {
    paramParcel.writeString(a);
    paramParcel.writeInt(b.intValue());
    paramParcel.writeString(c.toString());
    paramParcel.writeString(d);
    paramParcel.writeString(e);
  }
}

/* Location:
 * Qualified Name:     com.paypal.android.sdk.payments.PayPalItem
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */