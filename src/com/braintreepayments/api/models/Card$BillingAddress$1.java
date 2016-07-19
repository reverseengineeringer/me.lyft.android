package com.braintreepayments.api.models;

import android.os.Parcel;
import android.os.Parcelable.Creator;

final class Card$BillingAddress$1
  implements Parcelable.Creator<Card.BillingAddress>
{
  public Card.BillingAddress createFromParcel(Parcel paramParcel)
  {
    return new Card.BillingAddress(paramParcel, null);
  }
  
  public Card.BillingAddress[] newArray(int paramInt)
  {
    return new Card.BillingAddress[paramInt];
  }
}

/* Location:
 * Qualified Name:     com.braintreepayments.api.models.Card.BillingAddress.1
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */