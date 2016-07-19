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

public class TransferReversalCollection
  extends StripeCollectionAPIResource<Reversal>
{
  public TransferReversalCollection all(Map<String, Object> paramMap)
    throws AuthenticationException, InvalidRequestException, APIConnectionException, CardException, APIException
  {
    return all(paramMap, null);
  }
  
  public TransferReversalCollection all(Map<String, Object> paramMap, RequestOptions paramRequestOptions)
    throws AuthenticationException, InvalidRequestException, APIConnectionException, CardException, APIException
  {
    String str = String.format("%s%s", new Object[] { Stripe.getApiBase(), getURL() });
    return (TransferReversalCollection)request(APIResource.RequestMethod.GET, str, paramMap, TransferReversalCollection.class, paramRequestOptions);
  }
  
  public Reversal create(Map<String, Object> paramMap)
    throws AuthenticationException, InvalidRequestException, APIConnectionException, CardException, APIException
  {
    return create(paramMap, (RequestOptions)null);
  }
  
  public Reversal create(Map<String, Object> paramMap, RequestOptions paramRequestOptions)
    throws AuthenticationException, InvalidRequestException, APIConnectionException, CardException, APIException
  {
    String str = String.format("%s%s", new Object[] { Stripe.getApiBase(), getURL() });
    return (Reversal)request(APIResource.RequestMethod.POST, str, paramMap, Reversal.class, paramRequestOptions);
  }
  
  public Reversal retrieve(String paramString)
    throws AuthenticationException, InvalidRequestException, APIConnectionException, CardException, APIException
  {
    return retrieve(paramString, (RequestOptions)null);
  }
  
  public Reversal retrieve(String paramString, RequestOptions paramRequestOptions)
    throws AuthenticationException, InvalidRequestException, APIConnectionException, CardException, APIException
  {
    paramString = String.format("%s%s/%s", new Object[] { Stripe.getApiBase(), getURL(), paramString });
    return (Reversal)request(APIResource.RequestMethod.GET, paramString, null, Reversal.class, paramRequestOptions);
  }
  
  @Deprecated
  public Reversal retrieve(String paramString1, String paramString2)
    throws AuthenticationException, InvalidRequestException, APIConnectionException, CardException, APIException
  {
    return retrieve(paramString1, RequestOptions.builder().setApiKey(paramString2).build());
  }
}

/* Location:
 * Qualified Name:     com.stripe.model.TransferReversalCollection
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */