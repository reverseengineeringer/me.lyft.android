package com.stripe.model;

import com.stripe.Stripe;
import com.stripe.exception.APIConnectionException;
import com.stripe.exception.APIException;
import com.stripe.exception.AuthenticationException;
import com.stripe.exception.CardException;
import com.stripe.exception.InvalidRequestException;
import com.stripe.net.APIResource;
import com.stripe.net.APIResource.RequestMethod;
import com.stripe.net.RequestOptions;
import com.stripe.net.RequestOptions.RequestOptionsBuilder;
import java.util.List;
import java.util.Map;

public class BalanceTransaction
  extends APIResource
{
  Integer amount;
  Long availableOn;
  Long created;
  String currency;
  String description;
  Integer fee;
  List<Fee> feeDetails;
  String id;
  Integer net;
  String source;
  String status;
  String type;
  
  public static BalanceTransactionCollection all(Map<String, Object> paramMap)
    throws AuthenticationException, InvalidRequestException, APIConnectionException, CardException, APIException
  {
    return all(paramMap, (RequestOptions)null);
  }
  
  public static BalanceTransactionCollection all(Map<String, Object> paramMap, RequestOptions paramRequestOptions)
    throws AuthenticationException, InvalidRequestException, APIConnectionException, CardException, APIException
  {
    String str = String.format("%s/%s", new Object[] { Stripe.getApiBase(), "v1/balance/history" });
    return (BalanceTransactionCollection)request(APIResource.RequestMethod.GET, str, paramMap, BalanceTransactionCollection.class, paramRequestOptions);
  }
  
  @Deprecated
  public static BalanceTransactionCollection all(Map<String, Object> paramMap, String paramString)
    throws AuthenticationException, InvalidRequestException, APIConnectionException, CardException, APIException
  {
    return all(paramMap, RequestOptions.builder().setApiKey(paramString).build());
  }
  
  public static BalanceTransaction retrieve(String paramString)
    throws AuthenticationException, InvalidRequestException, APIConnectionException, CardException, APIException
  {
    return retrieve(paramString, (RequestOptions)null);
  }
  
  public static BalanceTransaction retrieve(String paramString, RequestOptions paramRequestOptions)
    throws AuthenticationException, InvalidRequestException, APIConnectionException, CardException, APIException
  {
    paramString = String.format("%s/%s/%s", new Object[] { Stripe.getApiBase(), "v1/balance/history", paramString });
    return (BalanceTransaction)request(APIResource.RequestMethod.GET, paramString, null, BalanceTransaction.class, paramRequestOptions);
  }
  
  @Deprecated
  public static BalanceTransaction retrieve(String paramString1, String paramString2)
    throws AuthenticationException, InvalidRequestException, APIConnectionException, CardException, APIException
  {
    String.format("%s/%s/%s", new Object[] { Stripe.getApiBase(), "v1/balance/history", paramString1 });
    return retrieve(paramString1, RequestOptions.builder().setApiKey(paramString2).build());
  }
  
  public Integer getAmount()
  {
    return amount;
  }
  
  public Long getAvailableOn()
  {
    return availableOn;
  }
  
  public Long getCreated()
  {
    return created;
  }
  
  public String getCurrency()
  {
    return currency;
  }
  
  public String getDescription()
  {
    return description;
  }
  
  public Integer getFee()
  {
    return fee;
  }
  
  public List<Fee> getFeeDetails()
  {
    return feeDetails;
  }
  
  public String getId()
  {
    return id;
  }
  
  public Integer getNet()
  {
    return net;
  }
  
  public String getSource()
  {
    return source;
  }
  
  public String getStatus()
  {
    return status;
  }
  
  public String getType()
  {
    return type;
  }
  
  public void setAmount(Integer paramInteger)
  {
    amount = paramInteger;
  }
  
  public void setAvailableOn(Long paramLong)
  {
    availableOn = paramLong;
  }
  
  public void setCreated(Long paramLong)
  {
    created = paramLong;
  }
  
  public void setCurrency(String paramString)
  {
    currency = paramString;
  }
  
  public void setDescription(String paramString)
  {
    description = paramString;
  }
  
  public void setFee(Integer paramInteger)
  {
    fee = paramInteger;
  }
  
  public void setFeeDetails(List<Fee> paramList)
  {
    feeDetails = paramList;
  }
  
  public void setId(String paramString)
  {
    id = paramString;
  }
  
  public void setNet(Integer paramInteger)
  {
    net = paramInteger;
  }
  
  public void setSource(String paramString)
  {
    source = paramString;
  }
  
  public void setStatus(String paramString)
  {
    status = paramString;
  }
  
  public void setType(String paramString)
  {
    type = paramString;
  }
}

/* Location:
 * Qualified Name:     com.stripe.model.BalanceTransaction
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */