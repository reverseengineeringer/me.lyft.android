package com.braintreepayments.api.models;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.braintreepayments.api.Utils;
import com.braintreepayments.api.annotations.Beta;
import com.google.gson.Gson;
import com.google.gson.annotations.SerializedName;
import java.io.Serializable;

public class Card
  extends PaymentMethod
  implements Parcelable, Serializable
{
  public static final Parcelable.Creator<Card> CREATOR = new Parcelable.Creator()
  {
    public Card createFromParcel(Parcel paramAnonymousParcel)
    {
      return new Card(paramAnonymousParcel, null);
    }
    
    public Card[] newArray(int paramAnonymousInt)
    {
      return new Card[paramAnonymousInt];
    }
  };
  protected static final String PAYMENT_METHOD_TYPE = "CreditCard";
  private BillingAddress billingAddress;
  @SerializedName("number")
  private String cardNumber;
  private String cvv;
  private CardDetails details;
  private String expirationDate;
  private String expirationMonth;
  private String expirationYear;
  private ThreeDSecureInfo threeDSecureInfo;
  
  public Card() {}
  
  private Card(Parcel paramParcel)
  {
    billingAddress = ((BillingAddress)paramParcel.readParcelable(BillingAddress.class.getClassLoader()));
    details = ((CardDetails)paramParcel.readParcelable(CardDetails.class.getClassLoader()));
    expirationMonth = paramParcel.readString();
    expirationYear = paramParcel.readString();
    expirationDate = paramParcel.readString();
    cardNumber = paramParcel.readString();
    cvv = paramParcel.readString();
    nonce = paramParcel.readString();
    description = paramParcel.readString();
    options = ((PaymentMethodOptions)paramParcel.readSerializable());
    mSource = paramParcel.readString();
  }
  
  public static Card fromJson(String paramString)
  {
    return (Card)Utils.getGson().fromJson(paramString, Card.class);
  }
  
  public int describeContents()
  {
    return 0;
  }
  
  public String getLastTwo()
  {
    return details.getLastTwo();
  }
  
  @Beta
  public ThreeDSecureInfo getThreeDSecureInfo()
  {
    return threeDSecureInfo;
  }
  
  public String getTypeLabel()
  {
    return details.getCardType();
  }
  
  protected void setBillingAddress(BillingAddress paramBillingAddress)
  {
    billingAddress = paramBillingAddress;
  }
  
  protected void setCardNumber(String paramString)
  {
    cardNumber = paramString;
  }
  
  protected void setCvv(String paramString)
  {
    cvv = paramString;
  }
  
  protected void setExpirationDate(String paramString)
  {
    expirationDate = paramString;
  }
  
  protected void setExpirationMonth(String paramString)
  {
    expirationMonth = paramString;
  }
  
  protected void setExpirationYear(String paramString)
  {
    expirationYear = paramString;
  }
  
  @Beta
  protected void setThreeDSecureInfo(ThreeDSecureInfo paramThreeDSecureInfo)
  {
    threeDSecureInfo = paramThreeDSecureInfo;
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    paramParcel.writeParcelable(billingAddress, 0);
    paramParcel.writeParcelable(details, 0);
    paramParcel.writeString(expirationMonth);
    paramParcel.writeString(expirationYear);
    paramParcel.writeString(expirationDate);
    paramParcel.writeString(cardNumber);
    paramParcel.writeString(cvv);
    paramParcel.writeString(nonce);
    paramParcel.writeString(description);
    paramParcel.writeSerializable(options);
    paramParcel.writeString(mSource);
  }
  
  protected static class BillingAddress
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
    
    public BillingAddress() {}
    
    private BillingAddress(Parcel paramParcel)
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
  
  private static class CardDetails
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
    
    public CardDetails() {}
    
    private CardDetails(Parcel paramParcel)
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
}

/* Location:
 * Qualified Name:     com.braintreepayments.api.models.Card
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */