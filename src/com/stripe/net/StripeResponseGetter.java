package com.stripe.net;

import com.stripe.exception.APIConnectionException;
import com.stripe.exception.APIException;
import com.stripe.exception.AuthenticationException;
import com.stripe.exception.CardException;
import com.stripe.exception.InvalidRequestException;
import java.util.Map;

public abstract interface StripeResponseGetter
{
  public abstract <T> T request(APIResource.RequestMethod paramRequestMethod, String paramString, Map<String, Object> paramMap, Class<T> paramClass, APIResource.RequestType paramRequestType, RequestOptions paramRequestOptions)
    throws AuthenticationException, InvalidRequestException, APIConnectionException, CardException, APIException;
}

/* Location:
 * Qualified Name:     com.stripe.net.StripeResponseGetter
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */