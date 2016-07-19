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

public class Reversal
  extends APIResource
  implements MetadataStore<Transfer>
{
  Integer amount;
  String balanceTransaction;
  Long created;
  String currency;
  String id;
  Map<String, String> metadata;
  String transfer;
  
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
  
  public String getId()
  {
    return id;
  }
  
  public String getInstanceURL()
  {
    if (transfer != null) {
      return String.format("%s/%s/reversals/%s", new Object[] { classURL(Transfer.class), transfer, getId() });
    }
    return null;
  }
  
  public Map<String, String> getMetadata()
  {
    return metadata;
  }
  
  public String getTransfer()
  {
    return transfer;
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
  
  public void setMetadata(Map<String, String> paramMap)
  {
    metadata = paramMap;
  }
  
  public void setTransfer(String paramString)
  {
    transfer = transfer;
  }
  
  public Reversal update(Map<String, Object> paramMap)
    throws AuthenticationException, InvalidRequestException, APIConnectionException, CardException, APIException
  {
    return update(paramMap, (RequestOptions)null);
  }
  
  public Reversal update(Map<String, Object> paramMap, RequestOptions paramRequestOptions)
    throws AuthenticationException, InvalidRequestException, APIConnectionException, CardException, APIException
  {
    return (Reversal)request(APIResource.RequestMethod.POST, getInstanceURL(), paramMap, Reversal.class, paramRequestOptions);
  }
  
  @Deprecated
  public Reversal update(Map<String, Object> paramMap, String paramString)
    throws AuthenticationException, InvalidRequestException, APIConnectionException, CardException, APIException
  {
    return update(paramMap, RequestOptions.builder().setApiKey(paramString).build());
  }
}

/* Location:
 * Qualified Name:     com.stripe.model.Reversal
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */