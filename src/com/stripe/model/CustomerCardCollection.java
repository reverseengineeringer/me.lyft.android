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

public class CustomerCardCollection
  extends StripeCollectionAPIResource<Card>
{
  public CustomerCardCollection all(Map<String, Object> paramMap)
    throws AuthenticationException, InvalidRequestException, APIConnectionException, CardException, APIException
  {
    return all(paramMap, (RequestOptions)null);
  }
  
  public CustomerCardCollection all(Map<String, Object> paramMap, RequestOptions paramRequestOptions)
    throws AuthenticationException, InvalidRequestException, APIConnectionException, CardException, APIException
  {
    String str = String.format("%s%s", new Object[] { Stripe.getApiBase(), getURL() });
    return (CustomerCardCollection)request(APIResource.RequestMethod.GET, str, paramMap, CustomerCardCollection.class, paramRequestOptions);
  }
  
  @Deprecated
  public CustomerCardCollection all(Map<String, Object> paramMap, String paramString)
    throws AuthenticationException, InvalidRequestException, APIConnectionException, CardException, APIException
  {
    return all(paramMap, RequestOptions.builder().setApiKey(paramString).build());
  }
  
  public Card create(Map<String, Object> paramMap)
    throws AuthenticationException, InvalidRequestException, APIConnectionException, CardException, APIException
  {
    return create(paramMap, (RequestOptions)null);
  }
  
  public Card create(Map<String, Object> paramMap, RequestOptions paramRequestOptions)
    throws AuthenticationException, InvalidRequestException, APIConnectionException, CardException, APIException
  {
    String str = String.format("%s%s", new Object[] { Stripe.getApiBase(), getURL() });
    return (Card)request(APIResource.RequestMethod.POST, str, paramMap, Card.class, paramRequestOptions);
  }
  
  @Deprecated
  public Card create(Map<String, Object> paramMap, String paramString)
    throws AuthenticationException, InvalidRequestException, APIConnectionException, CardException, APIException
  {
    return create(paramMap, RequestOptions.builder().setApiKey(paramString).build());
  }
  
  public Card retrieve(String paramString)
    throws AuthenticationException, InvalidRequestException, APIConnectionException, CardException, APIException
  {
    return retrieve(paramString, (RequestOptions)null);
  }
  
  public Card retrieve(String paramString, RequestOptions paramRequestOptions)
    throws AuthenticationException, InvalidRequestException, APIConnectionException, CardException, APIException
  {
    paramString = String.format("%s%s/%s", new Object[] { Stripe.getApiBase(), getURL(), paramString });
    return (Card)request(APIResource.RequestMethod.GET, paramString, null, Card.class, paramRequestOptions);
  }
  
  @Deprecated
  public Card retrieve(String paramString1, String paramString2)
    throws AuthenticationException, InvalidRequestException, APIConnectionException, CardException, APIException
  {
    return retrieve(paramString1, RequestOptions.builder().setApiKey(paramString2).build());
  }
}

/* Location:
 * Qualified Name:     com.stripe.model.CustomerCardCollection
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */