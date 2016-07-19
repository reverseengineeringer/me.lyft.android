package com.braintreepayments.api.models;

import android.os.Parcel;
import android.os.Parcelable.Creator;

final class PayPalAccount$1
  implements Parcelable.Creator<PayPalAccount>
{
  public PayPalAccount createFromParcel(Parcel paramParcel)
  {
    return new PayPalAccount(paramParcel, null);
  }
  
  public PayPalAccount[] newArray(int paramInt)
  {
    return new PayPalAccount[paramInt];
  }
}

/* Location:
 * Qualified Name:     com.braintreepayments.api.models.PayPalAccount.1
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */