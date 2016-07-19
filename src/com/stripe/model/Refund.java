package com.stripe.model;

import com.stripe.exception.APIConnectionException;
import com.stripe.exception.APIException;
import com.stripe.exception.AuthenticationException;
import com.stripe.exception.CardException;
import com.stripe.exception.InvalidRequestException;
import com.stripe.net.APIResource;
import com.stripe.net.APIResource.RequestMethod;
import com.stripe.net.RequestOptions;
import com.stripe.net.RequestOptions.RequestOptionsBuilder;
import java.util.Map;

public class Refund
  extends APIResource
  implements MetadataStore<Charge>
{
  Integer amount;
  String balanceTransaction;
  String charge;
  Long created;
  String currency;
  String id;
  Map<String, String> metadata;
  
  public Integer getAmount()
  {
    return amount;
  }
  
  public String getBalanceTransaction()
  {
    return balanceTransaction;
  }
  
  public String getCharge()
  {
    return charge;
  }
  
  public Long getCreated()
  {
    return created;
  }
  
  public String getCurrency()
  {
    return currency;
  }
  
  public String getId()
  {
    return id;
  }
  
  public String getInstanceURL()
  {
    if (charge != null) {
      return String.format("%s/%s/refunds/%s", new Object[] { classURL(Charge.class), charge, getId() });
    }
    return null;
  }
  
  public Map<String, String> getMetadata()
  {
    return metadata;
  }
  
  public void setAmount(Integer paramInteger)
  {
    amount = paramInteger;
  }
  
  public void setBalanceTransaction(String paramString)
  {
    balanceTransaction = paramString;
  }
  
  public void setCharge(String paramString)
  {
    charge = paramString;
  }
  
  public void setCreated(Long paramLong)
  {
    created = paramLong;
  }
  
  public void setCurrency(String paramString)
  {
    currency = paramString;
  }
  
  public void setMetadata(Map<String, String> paramMap)
  {
    metadata = paramMap;
  }
  
  public Refund update(Map<String, Object> paramMap)
    throws AuthenticationException, InvalidRequestException, APIConnectionException, CardException, APIException
  {
    return update(paramMap, (RequestOptions)null);
  }
  
  public Refund update(Map<String, Object> paramMap, RequestOptions paramRequestOptions)
    throws AuthenticationException, InvalidRequestException, APIConnectionException, CardException, APIException
  {
    return (Refund)request(APIResource.RequestMethod.POST, getInstanceURL(), paramMap, Refund.class, paramRequestOptions);
  }
  
  @Deprecated
  public Refund update(Map<String, Object> paramMap, String paramString)
    throws AuthenticationException, InvalidRequestException, APIConnectionException, CardException, APIException
  {
    return update(paramMap, RequestOptions.builder().setApiKey(paramString).build());
  }
}

/* Location:
 * Qualified Name:     com.stripe.model.Refund
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */