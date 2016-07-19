package com.braintreepayments.api.models;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import java.io.Serializable;

public class Card$BillingAddress
  implements Parcelable, Serializable
{
  public static final Parcelable.Creator<BillingAddress> CREATOR = new Parcelable.Creator()
  {
    public Card.BillingAddress createFromParcel(Parcel paramAnonymousParcel)
    {
      return new Card.BillingAddress(paramAnonymousParcel, null);
    }
    
    public Card.BillingAddress[] newArray(int paramAnonymousInt)
    {
      return new Card.BillingAddress[paramAnonymousInt];
    }
  };
  private String countryName;
  private String firstName;
  private String lastName;
  private String locality;
  private String postalCode;
  private String region;
  private String streetAddress;
  
  public Card$BillingAddress() {}
  
  private Card$BillingAddress(Parcel paramParcel)
  {
    firstName = paramParcel.readString();
    lastName = paramParcel.readString();
    countryName = paramParcel.readString();
    locality = paramParcel.readString();
    postalCode = paramParcel.readString();
    region = paramParcel.readString();
    streetAddress = paramParcel.readString();
  }
  
  public int describeContents()
  {
    return 0;
  }
  
  protected void setCountryName(String paramString)
  {
    countryName = paramString;
  }
  
  protected void setFirstName(String paramString)
  {
    firstName = paramString;
  }
  
  protected void setLastName(String paramString)
  {
    lastName = paramString;
  }
  
  protected void setLocality(String paramString)
  {
    locality = paramString;
  }
  
  protected void setPostalCode(String paramString)
  {
    postalCode = paramString;
  }
  
  protected void setRegion(String paramString)
  {
    region = paramString;
  }
  
  protected void setStreetAddress(String paramString)
  {
    streetAddress = paramString;
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    paramParcel.writeString(firstName);
    paramParcel.writeString(lastName);
    paramParcel.writeString(countryName);
    paramParcel.writeString(locality);
    paramParcel.writeString(postalCode);
    paramParcel.writeString(region);
    paramParcel.writeString(streetAddress);
  }
}

/* Location:
 * Qualified Name:     com.braintreepayments.api.models.Card.BillingAddress
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */