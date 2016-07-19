package com.stripe.model;

import com.stripe.Stripe;
import com.stripe.exception.APIConnectionException;
import com.stripe.exception.APIException;
import com.stripe.exception.AuthenticationException;
import com.stripe.exception.CardException;
import com.stripe.exception.InvalidRequestException;
import com.stripe.net.APIResource.RequestMethod;
import com.stripe.net.RequestOptions;
import java.util.Map;

public class ExternalAccountCollection
  extends StripeCollectionAPIResource<ExternalAccount>
{
  public ExternalAccountCollection all(Map<String, Object> paramMap)
    throws AuthenticationException, InvalidRequestException, APIConnectionException, CardException, APIException
  {
    return all(paramMap, (RequestOptions)null);
  }
  
  public ExternalAccountCollection all(Map<String, Object> paramMap, RequestOptions paramRequestOptions)
    throws AuthenticationException, InvalidRequestException, APIConnectionException, CardException, APIException
  {
    String str = String.format("%s%s", new Object[] { Stripe.getApiBase(), getURL() });
    return (ExternalAccountCollection)request(APIResource.RequestMethod.GET, str, paramMap, ExternalAccountCollection.class, paramRequestOptions);
  }
  
  public ExternalAccount create(Map<String, Object> paramMap)
    throws AuthenticationException, InvalidRequestException, APIConnectionException, CardException, APIException
  {
    return create(paramMap, (RequestOptions)null);
  }
  
  public ExternalAccount create(Map<String, Object> paramMap, RequestOptions paramRequestOptions)
    throws AuthenticationException, InvalidRequestException, APIConnectionException, CardException, APIException
  {
    String str = String.format("%s%s", new Object[] { Stripe.getApiBase(), getURL() });
    return (ExternalAccount)request(APIResource.RequestMethod.POST, str, paramMap, ExternalAccount.class, paramRequestOptions);
  }
  
  public ExternalAccount retrieve(String paramString)
    throws AuthenticationException, InvalidRequestException, APIConnectionException, CardException, APIException
  {
    return retrieve(paramString, (RequestOptions)null);
  }
  
  public ExternalAccount retrieve(String paramString, RequestOptions paramRequestOptions)
    throws AuthenticationException, InvalidRequestException, APIConnectionException, CardException, APIException
  {
    paramString = String.format("%s%s/%s", new Object[] { Stripe.getApiBase(), getURL(), paramString });
    return (ExternalAccount)request(APIResource.RequestMethod.GET, paramString, null, ExternalAccount.class, paramRequestOptions);
  }
}

/* Location:
 * Qualified Name:     com.stripe.model.ExternalAccountCollection
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */