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
import java.util.List;

public class Balance
  extends APIResource
{
  List<Money> available;
  Boolean livemode;
  List<Money> pending;
  
  public static Balance retrieve()
    throws AuthenticationException, InvalidRequestException, APIConnectionException, CardException, APIException
  {
    return retrieve((RequestOptions)null);
  }
  
  public static Balance retrieve(RequestOptions paramRequestOptions)
    throws AuthenticationException, InvalidRequestException, APIConnectionException, CardException, APIException
  {
    return (Balance)request(APIResource.RequestMethod.GET, singleClassURL(Balance.class), null, Balance.class, paramRequestOptions);
  }
  
  @Deprecated
  public static Balance retrieve(String paramString)
    throws AuthenticationException, InvalidRequestException, APIConnectionException, CardException, APIException
  {
    return retrieve(RequestOptions.builder().setApiKey(paramString).build());
  }
  
  public List<Money> getAvailable()
  {
    return available;
  }
  
  public Boolean getLivemode()
  {
    return livemode;
  }
  
  public List<Money> getPending()
  {
    return pending;
  }
}

/* Location:
 * Qualified Name:     com.stripe.model.Balance
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */