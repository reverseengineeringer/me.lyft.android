package com.braintreepayments.api.models;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import java.io.Serializable;

class PayPalAccount$PayPalDetails
  implements Parcelable, Serializable
{
  public static final Parcelable.Creator<PayPalDetails> CREATOR = new Parcelable.Creator()
  {
    public PayPalAccount.PayPalDetails createFromParcel(Parcel paramAnonymousParcel)
    {
      return new PayPalAccount.PayPalDetails(paramAnonymousParcel, null);
    }
    
    public PayPalAccount.PayPalDetails[] newArray(int paramAnonymousInt)
    {
      return new PayPalAccount.PayPalDetails[paramAnonymousInt];
    }
  };
  private String email;
  
  public PayPalAccount$PayPalDetails() {}
  
  private PayPalAccount$PayPalDetails(Parcel paramParcel)
  {
    email = paramParcel.readString();
  }
  
  private String getEmail()
  {
    return email;
  }
  
  private void setEmail(String paramString)
  {
    email = paramString;
  }
  
  public int describeContents()
  {
    return 0;
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    paramParcel.writeString(email);
  }
}

/* Location:
 * Qualified Name:     com.braintreepayments.api.models.PayPalAccount.PayPalDetails
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */