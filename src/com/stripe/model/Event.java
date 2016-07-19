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

public class Event
  extends APIResource
{
  Long created;
  EventData data;
  String id;
  Boolean livemode;
  Integer pendingWebhooks;
  String request;
  String type;
  String userId;
  
  public static EventCollection all(Map<String, Object> paramMap)
    throws AuthenticationException, InvalidRequestException, APIConnectionException, CardException, APIException
  {
    return all(paramMap, (RequestOptions)null);
  }
  
  public static EventCollection all(Map<String, Object> paramMap, RequestOptions paramRequestOptions)
    throws AuthenticationException, InvalidRequestException, APIConnectionException, CardException, APIException
  {
    return (EventCollection)request(APIResource.RequestMethod.GET, classURL(Event.class), paramMap, EventCollection.class, paramRequestOptions);
  }
  
  @Deprecated
  public static EventCollection all(Map<String, Object> paramMap, String paramString)
    throws AuthenticationException, InvalidRequestException, APIConnectionException, CardException, APIException
  {
    return all(paramMap, RequestOptions.builder().setApiKey(paramString).build());
  }
  
  public static Event retrieve(String paramString)
    throws AuthenticationException, InvalidRequestException, APIConnectionException, CardException, APIException
  {
    return retrieve(paramString, (RequestOptions)null);
  }
  
  public static Event retrieve(String paramString, RequestOptions paramRequestOptions)
    throws AuthenticationException, InvalidRequestException, APIConnectionException, CardException, APIException
  {
    return (Event)request(APIResource.RequestMethod.GET, instanceURL(Event.class, paramString), null, Event.class, paramRequestOptions);
  }
  
  @Deprecated
  public static Event retrieve(String paramString1, String paramString2)
    throws AuthenticationException, InvalidRequestException, APIConnectionException, CardException, APIException
  {
    return retrieve(paramString1, RequestOptions.builder().setApiKey(paramString2).build());
  }
  
  public Long getCreated()
  {
    return created;
  }
  
  public EventData getData()
  {
    return data;
  }
  
  public String getId()
  {
    return id;
  }
  
  public Boolean getLivemode()
  {
    return livemode;
  }
  
  public Integer getPendingWebhooks()
  {
    return pendingWebhooks;
  }
  
  public String getRequest()
  {
    return request;
  }
  
  public String getType()
  {
    return type;
  }
  
  public String getUserId()
  {
    return userId;
  }
  
  public void setCreated(Long paramLong)
  {
    created = paramLong;
  }
  
  public void setData(EventData paramEventData)
  {
    data = paramEventData;
  }
  
  public void setId(String paramString)
  {
    id = paramString;
  }
  
  public void setLivemode(Boolean paramBoolean)
  {
    livemode = paramBoolean;
  }
  
  public void setPendingWebhooks(Integer paramInteger)
  {
    pendingWebhooks = paramInteger;
  }
  
  public void setRequest(String paramString)
  {
    request = paramString;
  }
  
  public void setType(String paramString)
  {
    type = paramString;
  }
  
  public void setUserId(String paramString)
  {
    userId = paramString;
  }
}

/* Location:
 * Qualified Name:     com.stripe.model.Event
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */