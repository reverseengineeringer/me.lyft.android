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

public class BitcoinTransactionCollection
  extends StripeCollectionAPIResource<BitcoinTransaction>
{
  public BitcoinTransactionCollection all(Map<String, Object> paramMap)
    throws AuthenticationException, InvalidRequestException, APIConnectionException, CardException, APIException
  {
    return all(paramMap, (RequestOptions)null);
  }
  
  public BitcoinTransactionCollection all(Map<String, Object> paramMap, RequestOptions paramRequestOptions)
    throws AuthenticationException, InvalidRequestException, APIConnectionException, CardException, APIException
  {
    String str = String.format("%s%s", new Object[] { Stripe.getApiBase(), getURL() });
    return (BitcoinTransactionCollection)request(APIResource.RequestMethod.GET, str, paramMap, BitcoinTransactionCollection.class, paramRequestOptions);
  }
}

/* Location:
 * Qualified Name:     com.stripe.model.BitcoinTransactionCollection
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */