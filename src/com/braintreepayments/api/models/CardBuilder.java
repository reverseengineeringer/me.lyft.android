package com.braintreepayments.api.models;

import com.braintreepayments.api.Utils;
import com.google.gson.Gson;
import com.google.gson.annotations.SerializedName;
import java.util.HashMap;
import java.util.Map;

public class CardBuilder
  implements PaymentMethod.Builder<Card>
{
  private Card.BillingAddress mBillingAddress = null;
  @SerializedName("creditCard")
  private Card mCard = new Card();
  private String mIntegration = "custom";
  private String mSource = "form";
  
  public CardBuilder()
  {
    mCard.setSource(mSource);
  }
  
  private Card.BillingAddress getBillingAddress()
  {
    if (mBillingAddress == null)
    {
      mBillingAddress = new Card.BillingAddress();
      mCard.setBillingAddress(mBillingAddress);
    }
    return mBillingAddress;
  }
  
  public Card build()
  {
    return mCard;
  }
  
  public CardBuilder cardNumber(String paramString)
  {
    mCard.setCardNumber(paramString);
    return this;
  }
  
  public CardBuilder countryName(String paramString)
  {
    getBillingAddress().setCountryName(paramString);
    return this;
  }
  
  public CardBuilder cvv(String paramString)
  {
    mCard.setCvv(paramString);
    return this;
  }
  
  public CardBuilder expirationDate(String paramString)
  {
    mCard.setExpirationDate(paramString);
    return this;
  }
  
  public CardBuilder expirationMonth(String paramString)
  {
    mCard.setExpirationMonth(paramString);
    return this;
  }
  
  public CardBuilder expirationYear(String paramString)
  {
    mCard.setExpirationYear(paramString);
    return this;
  }
  
  public CardBuilder firstName(String paramString)
  {
    getBillingAddress().setFirstName(paramString);
    return this;
  }
  
  public Card fromJson(String paramString)
  {
    return Card.fromJson(paramString);
  }
  
  public String getApiPath()
  {
    return "credit_cards";
  }
  
  public String getApiResource()
  {
    return "creditCards";
  }
  
  public CardBuilder integration(String paramString)
  {
    mIntegration = paramString;
    return this;
  }
  
  public CardBuilder lastName(String paramString)
  {
    getBillingAddress().setLastName(paramString);
    return this;
  }
  
  public CardBuilder locality(String paramString)
  {
    getBillingAddress().setLocality(paramString);
    return this;
  }
  
  public CardBuilder postalCode(String paramString)
  {
    getBillingAddress().setPostalCode(paramString);
    return this;
  }
  
  public CardBuilder region(String paramString)
  {
    getBillingAddress().setRegion(paramString);
    return this;
  }
  
  public CardBuilder source(String paramString)
  {
    mSource = paramString;
    mCard.setSource(mSource);
    return this;
  }
  
  public CardBuilder streetAddress(String paramString)
  {
    getBillingAddress().setStreetAddress(paramString);
    return this;
  }
  
  public Map<String, Object> toJson()
  {
    HashMap localHashMap = new HashMap();
    localHashMap.put("creditCard", build());
    localHashMap.put("_meta", new Metadata(mIntegration, mSource));
    return localHashMap;
  }
  
  public String toJsonString()
  {
    return Utils.getGson().toJson(toJson());
  }
  
  public CardBuilder validate(boolean paramBoolean)
  {
    PaymentMethodOptions localPaymentMethodOptions = new PaymentMethodOptions();
    localPaymentMethodOptions.setValidate(paramBoolean);
    mCard.setOptions(localPaymentMethodOptions);
    return this;
  }
}

/* Location:
 * Qualified Name:     com.braintreepayments.api.models.CardBuilder
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */