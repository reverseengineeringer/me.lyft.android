package com.stripe.model;

import com.stripe.exception.APIConnectionException;
import com.stripe.exception.APIException;
import com.stripe.exception.AuthenticationException;
import com.stripe.exception.CardException;
import com.stripe.exception.InvalidRequestException;
import com.stripe.net.APIResource.RequestMethod;
import com.stripe.net.RequestOptions;
import java.util.Map;

public class BankAccount
  extends ExternalAccount
{
  String bankName;
  String country;
  String currency;
  Boolean defaultForCurrency;
  String fingerprint;
  String last4;
  String status;
  Boolean validated;
  
  public DeletedBankAccount delete()
    throws AuthenticationException, InvalidRequestException, APIConnectionException, CardException, APIException
  {
    return delete((RequestOptions)null);
  }
  
  public DeletedBankAccount delete(RequestOptions paramRequestOptions)
    throws AuthenticationException, InvalidRequestException, APIConnectionException, CardException, APIException
  {
    return (DeletedBankAccount)request(APIResource.RequestMethod.DELETE, getInstanceURL(), null, DeletedBankAccount.class, paramRequestOptions);
  }
  
  public String getBankName()
  {
    return bankName;
  }
  
  public String getCountry()
  {
    return country;
  }
  
  public String getCurrency()
  {
    return currency;
  }
  
  public Boolean getDefaultForCurrency()
  {
    return defaultForCurrency;
  }
  
  public String getFingerprint()
  {
    return fingerprint;
  }
  
  public String getLast4()
  {
    return last4;
  }
  
  public String getStatus()
  {
    return status;
  }
  
  public Boolean getValidated()
  {
    return validated;
  }
  
  public void setBankName(String paramString)
  {
    bankName = paramString;
  }
  
  public void setCountry(String paramString)
  {
    country = paramString;
  }
  
  public void setCurrency(String paramString)
  {
    currency = paramString;
  }
  
  public void setDefaultForCurrency(Boolean paramBoolean)
  {
    defaultForCurrency = paramBoolean;
  }
  
  public void setFingerprint(String paramString)
  {
    fingerprint = paramString;
  }
  
  public void setLast4(String paramString)
  {
    last4 = paramString;
  }
  
  public void setStatus(String paramString)
  {
    status = paramString;
  }
  
  public void setValidated(Boolean paramBoolean)
  {
    validated = paramBoolean;
  }
  
  public BankAccount update(Map<String, Object> paramMap)
    throws AuthenticationException, InvalidRequestException, APIConnectionException, CardException, APIException
  {
    return update(paramMap, (RequestOptions)null);
  }
  
  public BankAccount update(Map<String, Object> paramMap, RequestOptions paramRequestOptions)
    throws AuthenticationException, InvalidRequestException, APIConnectionException, CardException, APIException
  {
    return (BankAccount)request(APIResource.RequestMethod.POST, getInstanceURL(), paramMap, BankAccount.class, paramRequestOptions);
  }
}

/* Location:
 * Qualified Name:     com.stripe.model.BankAccount
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */