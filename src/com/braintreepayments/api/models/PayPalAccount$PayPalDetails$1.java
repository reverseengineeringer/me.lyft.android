package com.braintreepayments.api.models;

import android.os.Parcel;
import android.os.Parcelable.Creator;

final class PayPalAccount$PayPalDetails$1
  implements Parcelable.Creator<PayPalAccount.PayPalDetails>
{
  public PayPalAccount.PayPalDetails createFromParcel(Parcel paramParcel)
  {
    return new PayPalAccount.PayPalDetails(paramParcel, null);
  }
  
  public PayPalAccount.PayPalDetails[] newArray(int paramInt)
  {
    return new PayPalAccount.PayPalDetails[paramInt];
  }
}

/* Location:
 * Qualified Name:     com.braintreepayments.api.models.PayPalAccount.PayPalDetails.1
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */