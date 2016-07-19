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

public class ApplicationFee
  extends APIResource
{
  Integer amount;
  Integer amountRefunded;
  String application;
  String balanceTransaction;
  String charge;
  Long created;
  String currency;
  String id;
  Boolean livemode;
  Boolean refunded;
  FeeRefundCollection refunds;
  String user;
  
  public static ApplicationFeeCollection all(Map<String, Object> paramMap)
    throws AuthenticationException, InvalidRequestException, APIConnectionException, CardException, APIException
  {
    return all(paramMap, (RequestOptions)null);
  }
  
  public static ApplicationFeeCollection all(Map<String, Object> paramMap, RequestOptions paramRequestOptions)
    throws AuthenticationException, InvalidRequestException, APIConnectionException, CardException, APIException
  {
    return (ApplicationFeeCollection)request(APIResource.RequestMethod.GET, classURL(ApplicationFee.class), paramMap, ApplicationFeeCollection.class, paramRequestOptions);
  }
  
  @Deprecated
  public static ApplicationFeeCollection all(Map<String, Object> paramMap, String paramString)
    throws AuthenticationException, InvalidRequestException, APIConnectionException, CardException, APIException
  {
    return all(paramMap, RequestOptions.builder().setApiKey(paramString).build());
  }
  
  public static ApplicationFee retrieve(String paramString)
    throws AuthenticationException, InvalidRequestException, APIConnectionException, CardException, APIException
  {
    return retrieve(paramString, (RequestOptions)null);
  }
  
  public static ApplicationFee retrieve(String paramString, RequestOptions paramRequestOptions)
    throws AuthenticationException, InvalidRequestException, APIConnectionException, CardException, APIException
  {
    return (ApplicationFee)request(APIResource.RequestMethod.GET, instanceURL(ApplicationFee.class, paramString), null, ApplicationFee.class, paramRequestOptions);
  }
  
  @Deprecated
  public static ApplicationFee retrieve(String paramString1, String paramString2)
    throws AuthenticationException, InvalidRequestException, APIConnectionException, CardException, APIException
  {
    return retrieve(paramString1, RequestOptions.builder().setApiKey(paramString2).build());
  }
  
  public Integer getAmount()
  {
    return amount;
  }
  
  public Integer getAmountRefunded()
  {
    return amountRefunded;
  }
  
  public String getApplication()
  {
    return application;
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
  
  public Boolean getLivemode()
  {
    return livemode;
  }
  
  public Boolean getRefunded()
  {
    return refunded;
  }
  
  public FeeRefundCollection getRefunds()
  {
    if (refunds.getURL() == null) {
      refunds.setURL(String.format("/v1/application_fees/%s/refunds", new Object[] { getId() }));
    }
    return refunds;
  }
  
  public String getUser()
  {
    return user;
  }
  
  public ApplicationFee refund()
    throws AuthenticationException, InvalidRequestException, APIConnectionException, CardException, APIException
  {
    return refund(null, (RequestOptions)null);
  }
  
  public ApplicationFee refund(RequestOptions paramRequestOptions)
    throws AuthenticationException, InvalidRequestException, APIConnectionException, CardException, APIException
  {
    return refund(null, paramRequestOptions);
  }
  
  @Deprecated
  public ApplicationFee refund(String paramString)
    throws AuthenticationException, InvalidRequestException, APIConnectionException, CardException, APIException
  {
    return refund(RequestOptions.builder().setApiKey(paramString).build());
  }
  
  public ApplicationFee refund(Map<String, Object> paramMap)
    throws AuthenticationException, InvalidRequestException, APIConnectionException, CardException, APIException
  {
    return refund(paramMap, (RequestOptions)null);
  }
  
  public ApplicationFee refund(Map<String, Object> paramMap, RequestOptions paramRequestOptions)
    throws AuthenticationException, InvalidRequestException, APIConnectionException, CardException, APIException
  {
    return (ApplicationFee)request(APIResource.RequestMethod.POST, String.format("%s/refund", new Object[] { instanceURL(ApplicationFee.class, getId()) }), paramMap, ApplicationFee.class, paramRequestOptions);
  }
  
  @Deprecated
  public ApplicationFee refund(Map<String, Object> paramMap, String paramString)
    throws AuthenticationException, InvalidRequestException, APIConnectionException, CardException, APIException
  {
    return refund(paramMap, RequestOptions.builder().setApiKey(paramString).build());
  }
  
  public void setAmount(Integer paramInteger)
  {
    amount = paramInteger;
  }
  
  public void setAmountRefunded(Integer paramInteger)
  {
    amountRefunded = paramInteger;
  }
  
  public void setApplication(String paramString)
  {
    application = paramString;
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
  
  public void setId(String paramString)
  {
    id = paramString;
  }
  
  public void setLivemode(Boolean paramBoolean)
  {
    livemode = paramBoolean;
  }
  
  public void setRefunded(Boolean paramBoolean)
  {
    refunded = paramBoolean;
  }
  
  public void setUser(String paramString)
  {
    user = paramString;
  }
}

/* Location:
 * Qualified Name:     com.stripe.model.ApplicationFee
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */