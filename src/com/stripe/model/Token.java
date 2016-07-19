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

public class Token
  extends APIResource
{
  Integer amount;
  Card card;
  Long created;
  String currency;
  String id;
  Boolean livemode;
  Boolean used;
  
  public static Token create(Map<String, Object> paramMap)
    throws AuthenticationException, InvalidRequestException, APIConnectionException, CardException, APIException
  {
    return create(paramMap, (RequestOptions)null);
  }
  
  public static Token create(Map<String, Object> paramMap, RequestOptions paramRequestOptions)
    throws AuthenticationException, InvalidRequestException, APIConnectionException, CardException, APIException
  {
    return (Token)request(APIResource.RequestMethod.POST, classURL(Token.class), paramMap, Token.class, paramRequestOptions);
  }
  
  @Deprecated
  public static Token create(Map<String, Object> paramMap, String paramString)
    throws AuthenticationException, InvalidRequestException, APIConnectionException, CardException, APIException
  {
    return create(paramMap, RequestOptions.builder().setApiKey(paramString).build());
  }
  
  public static Token retrieve(String paramString)
    throws AuthenticationException, InvalidRequestException, APIConnectionException, CardException, APIException
  {
    return retrieve(paramString, (RequestOptions)null);
  }
  
  public static Token retrieve(String paramString, RequestOptions paramRequestOptions)
    throws AuthenticationException, InvalidRequestException, APIConnectionException, CardException, APIException
  {
    return (Token)request(APIResource.RequestMethod.GET, instanceURL(Token.class, paramString), null, Token.class, paramRequestOptions);
  }
  
  @Deprecated
  public static Token retrieve(String paramString1, String paramString2)
    throws AuthenticationException, InvalidRequestException, APIConnectionException, CardException, APIException
  {
    return retrieve(paramString1, RequestOptions.builder().setApiKey(paramString2).build());
  }
  
  public Integer getAmount()
  {
    return amount;
  }
  
  public Card getCard()
  {
    return card;
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
  
  public Boolean getUsed()
  {
    return used;
  }
  
  public void setAmount(Integer paramInteger)
  {
    amount = paramInteger;
  }
  
  public void setCard(Card paramCard)
  {
    card = paramCard;
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
  
  public void setUsed(Boolean paramBoolean)
  {
    used = paramBoolean;
  }
}

/* Location:
 * Qualified Name:     com.stripe.model.Token
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */