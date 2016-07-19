package com.stripe.model;

import com.stripe.Stripe;
import com.stripe.exception.APIConnectionException;
import com.stripe.exception.APIException;
import com.stripe.exception.AuthenticationException;
import com.stripe.exception.CardException;
import com.stripe.exception.InvalidRequestException;
import com.stripe.net.APIResource.RequestMethod;
import com.stripe.net.RequestOptions;
import com.stripe.net.RequestOptions.RequestOptionsBuilder;
import java.util.Map;

public class FeeRefundCollection
  extends StripeCollectionAPIResource<FeeRefund>
{
  public FeeRefundCollection all(Map<String, Object> paramMap)
    throws AuthenticationException, InvalidRequestException, APIConnectionException, CardException, APIException
  {
    return all(paramMap, (RequestOptions)null);
  }
  
  public FeeRefundCollection all(Map<String, Object> paramMap, RequestOptions paramRequestOptions)
    throws AuthenticationException, InvalidRequestException, APIConnectionException, CardException, APIException
  {
    String str = String.format("%s%s", new Object[] { Stripe.getApiBase(), getURL() });
    return (FeeRefundCollection)request(APIResource.RequestMethod.GET, str, paramMap, FeeRefundCollection.class, paramRequestOptions);
  }
  
  @Deprecated
  public FeeRefundCollection all(Map<String, Object> paramMap, String paramString)
    throws AuthenticationException, InvalidRequestException, APIConnectionException, CardException, APIException
  {
    return all(paramMap, RequestOptions.builder().setApiKey(paramString).build());
  }
  
  public FeeRefund create(Map<String, Object> paramMap)
    throws AuthenticationException, InvalidRequestException, APIConnectionException, CardException, APIException
  {
    return create(paramMap, (RequestOptions)null);
  }
  
  public FeeRefund create(Map<String, Object> paramMap, RequestOptions paramRequestOptions)
    throws AuthenticationException, InvalidRequestException, APIConnectionException, CardException, APIException
  {
    String str = String.format("%s%s", new Object[] { Stripe.getApiBase(), getURL() });
    return (FeeRefund)request(APIResource.RequestMethod.POST, str, paramMap, FeeRefund.class, paramRequestOptions);
  }
  
  @Deprecated
  public FeeRefund create(Map<String, Object> paramMap, String paramString)
    throws AuthenticationException, InvalidRequestException, APIConnectionException, CardException, APIException
  {
    return create(paramMap, RequestOptions.builder().setApiKey(paramString).build());
  }
  
  public FeeRefund retrieve(String paramString)
    throws AuthenticationException, InvalidRequestException, APIConnectionException, CardException, APIException
  {
    return retrieve(paramString, (RequestOptions)null);
  }
  
  public FeeRefund retrieve(String paramString, RequestOptions paramRequestOptions)
    throws AuthenticationException, InvalidRequestException, APIConnectionException, CardException, APIException
  {
    paramString = String.format("%s%s/%s", new Object[] { Stripe.getApiBase(), getURL(), paramString });
    return (FeeRefund)request(APIResource.RequestMethod.GET, paramString, null, FeeRefund.class, paramRequestOptions);
  }
  
  @Deprecated
  public FeeRefund retrieve(String paramString1, String paramString2)
    throws AuthenticationException, InvalidRequestException, APIConnectionException, CardException, APIException
  {
    return retrieve(paramString1, RequestOptions.builder().setApiKey(paramString2).build());
  }
}

/* Location:
 * Qualified Name:     com.stripe.model.FeeRefundCollection
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */