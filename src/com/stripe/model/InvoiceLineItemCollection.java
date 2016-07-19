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

public class InvoiceLineItemCollection
  extends StripeCollectionAPIResource<InvoiceLineItem>
{
  public InvoiceLineItemCollection all(Map<String, Object> paramMap)
    throws AuthenticationException, InvalidRequestException, APIConnectionException, CardException, APIException
  {
    return all(paramMap, (RequestOptions)null);
  }
  
  public InvoiceLineItemCollection all(Map<String, Object> paramMap, RequestOptions paramRequestOptions)
    throws AuthenticationException, InvalidRequestException, APIConnectionException, CardException, APIException
  {
    String str = String.format("%s%s", new Object[] { Stripe.getApiBase(), getURL() });
    return (InvoiceLineItemCollection)request(APIResource.RequestMethod.GET, str, paramMap, InvoiceLineItemCollection.class, paramRequestOptions);
  }
  
  @Deprecated
  public InvoiceLineItemCollection all(Map<String, Object> paramMap, String paramString)
    throws AuthenticationException, InvalidRequestException, APIConnectionException, CardException, APIException
  {
    return all(paramMap, RequestOptions.builder().setApiKey(paramString).build());
  }
}

/* Location:
 * Qualified Name:     com.stripe.model.InvoiceLineItemCollection
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */