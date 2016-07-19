package com.stripe.model;

import com.stripe.exception.APIConnectionException;
import com.stripe.exception.APIException;
import com.stripe.exception.AuthenticationException;
import com.stripe.exception.CardException;
import com.stripe.exception.InvalidRequestException;
import com.stripe.net.APIResource;
import com.stripe.net.APIResource.RequestMethod;
import com.stripe.net.RequestOptions;
import java.util.Map;

public class ExternalAccount
  extends APIResource
{
  String account;
  String customer;
  String id;
  String object;
  
  public DeletedExternalAccount delete()
    throws AuthenticationException, InvalidRequestException, APIConnectionException, CardException, APIException
  {
    return delete(null);
  }
  
  public DeletedExternalAccount delete(RequestOptions paramRequestOptions)
    throws AuthenticationException, InvalidRequestException, APIConnectionException, CardException, APIException
  {
    return (DeletedExternalAccount)request(APIResource.RequestMethod.DELETE, getInstanceURL(), null, DeletedExternalAccount.class, paramRequestOptions);
  }
  
  public String getAccount()
  {
    return account;
  }
  
  public String getCustomer()
  {
    return customer;
  }
  
  public String getId()
  {
    return id;
  }
  
  public String getInstanceURL()
  {
    if (getCustomer() != null) {
      return String.format("%s/%s/sources/%s", new Object[] { classURL(Customer.class), getCustomer(), getId() });
    }
    if (getAccount() != null) {
      return String.format("%s/%s/external_accounts/%s", new Object[] { classURL(Account.class), getAccount(), getId() });
    }
    return null;
  }
  
  public String getObject()
  {
    return object;
  }
  
  public void setAccount(String paramString)
  {
    account = paramString;
  }
  
  public void setCustomer(String paramString)
  {
    customer = paramString;
  }
  
  public ExternalAccount update(Map<String, Object> paramMap)
    throws AuthenticationException, InvalidRequestException, APIConnectionException, CardException, APIException
  {
    return update(paramMap, null);
  }
  
  public ExternalAccount update(Map<String, Object> paramMap, RequestOptions paramRequestOptions)
    throws AuthenticationException, InvalidRequestException, APIConnectionException, CardException, APIException
  {
    return (ExternalAccount)request(APIResource.RequestMethod.POST, getInstanceURL(), paramMap, ExternalAccount.class, paramRequestOptions);
  }
}

/* Location:
 * Qualified Name:     com.stripe.model.ExternalAccount
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */