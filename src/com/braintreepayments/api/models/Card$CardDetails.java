package com.braintreepayments.api.models;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import java.io.Serializable;

class Card$CardDetails
  implements Parcelable, Serializable
{
  public static final Parcelable.Creator<CardDetails> CREATOR = new Parcelable.Creator()
  {
    public Card.CardDetails createFromParcel(Parcel paramAnonymousParcel)
    {
      return new Card.CardDetails(paramAnonymousParcel, null);
    }
    
    public Card.CardDetails[] newArray(int paramAnonymousInt)
    {
      return new Card.CardDetails[paramAnonymousInt];
    }
  };
  private String cardType;
  private String lastTwo;
  
  public Card$CardDetails() {}
  
  private Card$CardDetails(Parcel paramParcel)
  {
    cardType = paramParcel.readString();
    lastTwo = paramParcel.readString();
  }
  
  public int describeContents()
  {
    return 0;
  }
  
  protected String getCardType()
  {
    return cardType;
  }
  
  protected String getLastTwo()
  {
    return lastTwo;
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    paramParcel.writeString(cardType);
    paramParcel.writeString(lastTwo);
  }
}

/* Location:
 * Qualified Name:     com.braintreepayments.api.models.Card.CardDetails
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */