package com.braintreepayments.api.models;

import android.os.Parcel;
import android.os.Parcelable.Creator;

final class Card$CardDetails$1
  implements Parcelable.Creator<Card.CardDetails>
{
  public Card.CardDetails createFromParcel(Parcel paramParcel)
  {
    return new Card.CardDetails(paramParcel, null);
  }
  
  public Card.CardDetails[] newArray(int paramInt)
  {
    return new Card.CardDetails[paramInt];
  }
}

/* Location:
 * Qualified Name:     com.braintreepayments.api.models.Card.CardDetails.1
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */