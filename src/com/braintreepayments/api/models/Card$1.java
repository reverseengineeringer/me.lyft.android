package com.braintreepayments.api.models;

import android.os.Parcel;
import android.os.Parcelable.Creator;

final class Card$1
  implements Parcelable.Creator<Card>
{
  public Card createFromParcel(Parcel paramParcel)
  {
    return new Card(paramParcel, null);
  }
  
  public Card[] newArray(int paramInt)
  {
    return new Card[paramInt];
  }
}

/* Location:
 * Qualified Name:     com.braintreepayments.api.models.Card.1
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */