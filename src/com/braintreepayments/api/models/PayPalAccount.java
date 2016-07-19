package com.braintreepayments.api.models;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import android.text.TextUtils;
import com.braintreepayments.api.Utils;
import com.google.gson.Gson;
import java.io.Serializable;

public class PayPalAccount
  extends PaymentMethod
  implements Parcelable, Serializable
{
  public static final Parcelable.Creator<PayPalAccount> CREATOR = new Parcelable.Creator()
  {
    public PayPalAccount createFromParcel(Parcel paramAnonymousParcel)
    {
      return new PayPalAccount(paramAnonymousParcel, null);
    }
    
    public PayPalAccount[] newArray(int paramAnonymousInt)
    {
      return new PayPalAccount[paramAnonymousInt];
    }
  };
  protected static final String PAYMENT_METHOD_TYPE = "PayPalAccount";
  private String consentCode;
  private String correlationId;
  private PayPalDetails details;
  
  public PayPalAccount() {}
  
  private PayPalAccount(Parcel paramParcel)
  {
    consentCode = paramParcel.readString();
    correlationId = paramParcel.readString();
    details = ((PayPalDetails)paramParcel.readParcelable(PayPalDetails.class.getClassLoader()));
    nonce = paramParcel.readString();
    description = paramParcel.readString();
    options = ((PaymentMethodOptions)paramParcel.readSerializable());
    mSource = paramParcel.readString();
  }
  
  public static PayPalAccount fromJson(String paramString)
  {
    return (PayPalAccount)Utils.getGson().fromJson(paramString, PayPalAccount.class);
  }
  
  public int describeContents()
  {
    return 0;
  }
  
  public String getDescription()
  {
    if ((TextUtils.equals(super.getDescription(), "PayPal")) && (!TextUtils.isEmpty(getEmail()))) {
      return getEmail();
    }
    return super.getDescription();
  }
  
  public String getEmail()
  {
    if (details != null) {
      return details.getEmail();
    }
    return "";
  }
  
  public String getTypeLabel()
  {
    return "PayPal";
  }
  
  protected void setConsentCode(String paramString)
  {
    consentCode = paramString;
  }
  
  protected void setCorrelationId(String paramString)
  {
    correlationId = paramString;
  }
  
  protected void setEmail(String paramString)
  {
    details = new PayPalDetails();
    details.setEmail(paramString);
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    paramParcel.writeString(consentCode);
    paramParcel.writeString(correlationId);
    paramParcel.writeParcelable(details, 0);
    paramParcel.writeString(nonce);
    paramParcel.writeString(description);
    paramParcel.writeSerializable(options);
    paramParcel.writeString(mSource);
  }
  
  private static class PayPalDetails
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
    
    public PayPalDetails() {}
    
    private PayPalDetails(Parcel paramParcel)
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
}

/* Location:
 * Qualified Name:     com.braintreepayments.api.models.PayPalAccount
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */