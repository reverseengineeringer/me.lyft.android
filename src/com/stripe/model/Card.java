package com.stripe.model;

import com.stripe.exception.APIConnectionException;
import com.stripe.exception.APIException;
import com.stripe.exception.AuthenticationException;
import com.stripe.exception.CardException;
import com.stripe.exception.InvalidRequestException;
import com.stripe.net.APIResource.RequestMethod;
import com.stripe.net.RequestOptions;
import com.stripe.net.RequestOptions.RequestOptionsBuilder;
import java.util.Map;

public class Card
  extends ExternalAccount
  implements MetadataStore<Card>
{
  String addressCity;
  String addressCountry;
  String addressLine1;
  String addressLine1Check;
  String addressLine2;
  String addressState;
  String addressZip;
  String addressZipCheck;
  String brand;
  String country;
  String cvcCheck;
  String dynamicLast4;
  Integer expMonth;
  Integer expYear;
  String fingerprint;
  String funding;
  String last4;
  Map<String, String> metadata;
  String name;
  String recipient;
  String status;
  String type;
  
  public DeletedCard delete()
    throws AuthenticationException, InvalidRequestException, APIConnectionException, CardException, APIException
  {
    return delete((RequestOptions)null);
  }
  
  public DeletedCard delete(RequestOptions paramRequestOptions)
    throws AuthenticationException, InvalidRequestException, APIConnectionException, CardException, APIException
  {
    return (DeletedCard)request(APIResource.RequestMethod.DELETE, getInstanceURL(), null, DeletedCard.class, paramRequestOptions);
  }
  
  @Deprecated
  public DeletedCard delete(String paramString)
    throws AuthenticationException, InvalidRequestException, APIConnectionException, CardException, APIException
  {
    return delete(RequestOptions.builder().setApiKey(paramString).build());
  }
  
  public String getAddressCity()
  {
    return addressCity;
  }
  
  public String getAddressCountry()
  {
    return addressCountry;
  }
  
  public String getAddressLine1()
  {
    return addressLine1;
  }
  
  public String getAddressLine1Check()
  {
    return addressLine1Check;
  }
  
  public String getAddressLine2()
  {
    return addressLine2;
  }
  
  public String getAddressState()
  {
    return addressState;
  }
  
  public String getAddressZip()
  {
    return addressZip;
  }
  
  public String getAddressZipCheck()
  {
    return addressZipCheck;
  }
  
  public String getBrand()
  {
    return brand;
  }
  
  public String getCountry()
  {
    return country;
  }
  
  public String getCvcCheck()
  {
    return cvcCheck;
  }
  
  public String getDynamicLast4()
  {
    return dynamicLast4;
  }
  
  public Integer getExpMonth()
  {
    return expMonth;
  }
  
  public Integer getExpYear()
  {
    return expYear;
  }
  
  public String getFingerprint()
  {
    return fingerprint;
  }
  
  public String getFunding()
  {
    return funding;
  }
  
  public String getInstanceURL()
  {
    String str = super.getInstanceURL();
    if (str != null) {
      return str;
    }
    if (getRecipient() != null) {
      return String.format("%s/%s/cards/%s", new Object[] { classURL(Recipient.class), getRecipient(), getId() });
    }
    return null;
  }
  
  public String getLast4()
  {
    return last4;
  }
  
  public Map<String, String> getMetadata()
  {
    return metadata;
  }
  
  public String getName()
  {
    return name;
  }
  
  public String getRecipient()
  {
    return recipient;
  }
  
  public String getStatus()
  {
    return status;
  }
  
  public String getType()
  {
    return type;
  }
  
  public void setAddressCity(String paramString)
  {
    addressCity = paramString;
  }
  
  public void setAddressCountry(String paramString)
  {
    addressCountry = paramString;
  }
  
  public void setAddressLine1(String paramString)
  {
    addressLine1 = paramString;
  }
  
  public void setAddressLine1Check(String paramString)
  {
    addressLine1Check = paramString;
  }
  
  public void setAddressLine2(String paramString)
  {
    addressLine2 = paramString;
  }
  
  public void setAddressState(String paramString)
  {
    addressState = paramString;
  }
  
  public void setAddressZip(String paramString)
  {
    addressZip = paramString;
  }
  
  public void setAddressZipCheck(String paramString)
  {
    addressZipCheck = paramString;
  }
  
  public void setBrand(String paramString)
  {
    brand = paramString;
  }
  
  public void setCountry(String paramString)
  {
    country = paramString;
  }
  
  public void setCvcCheck(String paramString)
  {
    cvcCheck = paramString;
  }
  
  public void setDynamicLast4(String paramString)
  {
    dynamicLast4 = paramString;
  }
  
  public void setExpMonth(Integer paramInteger)
  {
    expMonth = paramInteger;
  }
  
  public void setExpYear(Integer paramInteger)
  {
    expYear = paramInteger;
  }
  
  public void setFingerprint(String paramString)
  {
    fingerprint = paramString;
  }
  
  public void setFunding(String paramString)
  {
    funding = paramString;
  }
  
  public void setLast4(String paramString)
  {
    last4 = paramString;
  }
  
  public void setMetadata(Map<String, String> paramMap)
  {
    metadata = paramMap;
  }
  
  public void setName(String paramString)
  {
    name = paramString;
  }
  
  public void setRecipient(String paramString)
  {
    recipient = paramString;
  }
  
  public void setStatus(String paramString)
  {
    status = paramString;
  }
  
  public void setType(String paramString)
  {
    type = paramString;
  }
  
  public Card update(Map<String, Object> paramMap)
    throws AuthenticationException, InvalidRequestException, APIConnectionException, CardException, APIException
  {
    return update(paramMap, (RequestOptions)null);
  }
  
  public Card update(Map<String, Object> paramMap, RequestOptions paramRequestOptions)
    throws AuthenticationException, InvalidRequestException, APIConnectionException, CardException, APIException
  {
    return (Card)request(APIResource.RequestMethod.POST, getInstanceURL(), paramMap, Card.class, paramRequestOptions);
  }
  
  @Deprecated
  public Card update(Map<String, Object> paramMap, String paramString)
    throws AuthenticationException, InvalidRequestException, APIConnectionException, CardException, APIException
  {
    return update(paramMap, RequestOptions.builder().setApiKey(paramString).build());
  }
}

/* Location:
 * Qualified Name:     com.stripe.model.Card
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */