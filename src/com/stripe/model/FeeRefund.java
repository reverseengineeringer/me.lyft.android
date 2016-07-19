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

public class FeeRefund
  extends APIResource
  implements MetadataStore<ApplicationFee>
{
  Integer amount;
  String balanceTransaction;
  Long created;
  String currency;
  String fee;
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
  
  public Long getCreated()
  {
    return created;
  }
  
  public String getCurrency()
  {
    return currency;
  }
  
  public String getFee()
  {
    return fee;
  }
  
  public String getId()
  {
    return id;
  }
  
  public String getInstanceURL()
  {
    if (fee != null) {
      return String.format("%s/%s/refunds/%s", new Object[] { classURL(ApplicationFee.class), fee, getId() });
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
  
  public void setCreated(Long paramLong)
  {
    created = paramLong;
  }
  
  public void setCurrency(String paramString)
  {
    currency = paramString;
  }
  
  public void setFee(String paramString)
  {
    fee = paramString;
  }
  
  public void setMetadata(Map<String, String> paramMap)
  {
    metadata = paramMap;
  }
  
  public FeeRefund update(Map<String, Object> paramMap)
    throws AuthenticationException, InvalidRequestException, APIConnectionException, CardException, APIException
  {
    return update(paramMap, (RequestOptions)null);
  }
  
  public FeeRefund update(Map<String, Object> paramMap, RequestOptions paramRequestOptions)
    throws AuthenticationException, InvalidRequestException, APIConnectionException, CardException, APIException
  {
    return (FeeRefund)request(APIResource.RequestMethod.POST, getInstanceURL(), paramMap, FeeRefund.class, paramRequestOptions);
  }
  
  @Deprecated
  public FeeRefund update(Map<String, Object> paramMap, String paramString)
    throws AuthenticationException, InvalidRequestException, APIConnectionException, CardException, APIException
  {
    return update(paramMap, RequestOptions.builder().setApiKey(paramString).build());
  }
}

/* Location:
 * Qualified Name:     com.stripe.model.FeeRefund
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */