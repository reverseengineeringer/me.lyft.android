package com.stripe.model;

import com.stripe.exception.APIConnectionException;
import com.stripe.exception.APIException;
import com.stripe.exception.AuthenticationException;
import com.stripe.exception.CardException;
import com.stripe.exception.InvalidRequestException;
import com.stripe.net.APIResource.RequestMethod;
import com.stripe.net.RequestOptions;
import java.util.Map;

public class AlipayAccount
  extends ExternalAccount
{
  Long created;
  String fingerprint;
  Map<String, String> metadata;
  Integer paymentAmount;
  String paymentCurrency;
  Boolean reusable;
  String status;
  Boolean used;
  String username;
  
  public DeletedAlipayAccount delete()
    throws AuthenticationException, InvalidRequestException, APIConnectionException, CardException, APIException
  {
    return delete((RequestOptions)null);
  }
  
  public DeletedAlipayAccount delete(RequestOptions paramRequestOptions)
    throws AuthenticationException, InvalidRequestException, APIConnectionException, CardException, APIException
  {
    return (DeletedAlipayAccount)request(APIResource.RequestMethod.DELETE, getInstanceURL(), null, DeletedAlipayAccount.class, paramRequestOptions);
  }
  
  public Long getCreated()
  {
    return created;
  }
  
  public String getFingerprint()
  {
    return fingerprint;
  }
  
  public Map<String, String> getMetadata()
  {
    return metadata;
  }
  
  public Integer getPaymentAmount()
  {
    return paymentAmount;
  }
  
  public String getPaymentCurrency()
  {
    return paymentCurrency;
  }
  
  public Boolean getReusable()
  {
    return reusable;
  }
  
  public String getStatus()
  {
    return status;
  }
  
  public Boolean getUsed()
  {
    return used;
  }
  
  public String getUsername()
  {
    return username;
  }
  
  public void setCreated(Long paramLong)
  {
    created = paramLong;
  }
  
  public void setFingerprint(String paramString)
  {
    fingerprint = paramString;
  }
  
  public void setMetadata(Map<String, String> paramMap)
  {
    metadata = paramMap;
  }
  
  public void setPaymentAmount(Integer paramInteger)
  {
    paymentAmount = paramInteger;
  }
  
  public void setPaymentCurrency(String paramString)
  {
    paymentCurrency = paramString;
  }
  
  public void setReusable(Boolean paramBoolean)
  {
    reusable = paramBoolean;
  }
  
  public void setStatus(String paramString)
  {
    status = paramString;
  }
  
  public void setUsed(Boolean paramBoolean)
  {
    used = paramBoolean;
  }
  
  public void setUsername(String paramString)
  {
    username = paramString;
  }
  
  public AlipayAccount update(Map<String, Object> paramMap)
    throws AuthenticationException, InvalidRequestException, APIConnectionException, CardException, APIException
  {
    return update(paramMap, (RequestOptions)null);
  }
  
  public AlipayAccount update(Map<String, Object> paramMap, RequestOptions paramRequestOptions)
    throws AuthenticationException, InvalidRequestException, APIConnectionException, CardException, APIException
  {
    return (AlipayAccount)request(APIResource.RequestMethod.POST, getInstanceURL(), paramMap, AlipayAccount.class, paramRequestOptions);
  }
}

/* Location:
 * Qualified Name:     com.stripe.model.AlipayAccount
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */