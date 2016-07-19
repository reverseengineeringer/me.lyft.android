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

public class Plan
  extends APIResource
  implements MetadataStore<Plan>
{
  Integer amount;
  String currency;
  String id;
  String interval;
  Integer intervalCount;
  Boolean livemode;
  Map<String, String> metadata;
  String name;
  @Deprecated
  String statementDescription;
  String statementDescriptor;
  Integer trialPeriodDays;
  
  public static PlanCollection all(Map<String, Object> paramMap)
    throws AuthenticationException, InvalidRequestException, APIConnectionException, CardException, APIException
  {
    return all(paramMap, (RequestOptions)null);
  }
  
  public static PlanCollection all(Map<String, Object> paramMap, RequestOptions paramRequestOptions)
    throws AuthenticationException, InvalidRequestException, APIConnectionException, CardException, APIException
  {
    return (PlanCollection)request(APIResource.RequestMethod.GET, classURL(Plan.class), paramMap, PlanCollection.class, paramRequestOptions);
  }
  
  @Deprecated
  public static PlanCollection all(Map<String, Object> paramMap, String paramString)
    throws AuthenticationException, InvalidRequestException, APIConnectionException, CardException, APIException
  {
    return all(paramMap, RequestOptions.builder().setApiKey(paramString).build());
  }
  
  public static Plan create(Map<String, Object> paramMap)
    throws AuthenticationException, InvalidRequestException, APIConnectionException, CardException, APIException
  {
    return create(paramMap, (RequestOptions)null);
  }
  
  public static Plan create(Map<String, Object> paramMap, RequestOptions paramRequestOptions)
    throws AuthenticationException, InvalidRequestException, APIConnectionException, CardException, APIException
  {
    return (Plan)request(APIResource.RequestMethod.POST, classURL(Plan.class), paramMap, Plan.class, paramRequestOptions);
  }
  
  @Deprecated
  public static Plan create(Map<String, Object> paramMap, String paramString)
    throws AuthenticationException, InvalidRequestException, APIConnectionException, CardException, APIException
  {
    return create(paramMap, RequestOptions.builder().setApiKey(paramString).build());
  }
  
  public static Plan retrieve(String paramString)
    throws AuthenticationException, InvalidRequestException, APIConnectionException, CardException, APIException
  {
    return retrieve(paramString, (RequestOptions)null);
  }
  
  public static Plan retrieve(String paramString, RequestOptions paramRequestOptions)
    throws AuthenticationException, InvalidRequestException, APIConnectionException, CardException, APIException
  {
    return (Plan)request(APIResource.RequestMethod.GET, instanceURL(Plan.class, paramString), null, Plan.class, paramRequestOptions);
  }
  
  @Deprecated
  public static Plan retrieve(String paramString1, String paramString2)
    throws AuthenticationException, InvalidRequestException, APIConnectionException, CardException, APIException
  {
    return retrieve(paramString1, RequestOptions.builder().setApiKey(paramString2).build());
  }
  
  public DeletedPlan delete()
    throws AuthenticationException, InvalidRequestException, APIConnectionException, CardException, APIException
  {
    return delete((RequestOptions)null);
  }
  
  public DeletedPlan delete(RequestOptions paramRequestOptions)
    throws AuthenticationException, InvalidRequestException, APIConnectionException, CardException, APIException
  {
    return (DeletedPlan)request(APIResource.RequestMethod.DELETE, instanceURL(Plan.class, id), null, DeletedPlan.class, paramRequestOptions);
  }
  
  @Deprecated
  public DeletedPlan delete(String paramString)
    throws AuthenticationException, InvalidRequestException, APIConnectionException, CardException, APIException
  {
    return delete(RequestOptions.builder().setApiKey(paramString).build());
  }
  
  public Integer getAmount()
  {
    return amount;
  }
  
  public String getCurrency()
  {
    return currency;
  }
  
  public String getId()
  {
    return id;
  }
  
  public String getInterval()
  {
    return interval;
  }
  
  public Integer getIntervalCount()
  {
    return intervalCount;
  }
  
  public Boolean getLivemode()
  {
    return livemode;
  }
  
  public Map<String, String> getMetadata()
  {
    return metadata;
  }
  
  public String getName()
  {
    return name;
  }
  
  @Deprecated
  public String getStatementDescription()
  {
    return statementDescription;
  }
  
  public String getStatementDescriptor()
  {
    return statementDescriptor;
  }
  
  public Integer getTrialPeriodDays()
  {
    return trialPeriodDays;
  }
  
  public void setAmount(Integer paramInteger)
  {
    amount = paramInteger;
  }
  
  public void setCurrency(String paramString)
  {
    currency = paramString;
  }
  
  public void setId(String paramString)
  {
    id = paramString;
  }
  
  public void setInterval(String paramString)
  {
    interval = paramString;
  }
  
  public void setIntervalCount(Integer paramInteger)
  {
    intervalCount = paramInteger;
  }
  
  public void setLivemode(Boolean paramBoolean)
  {
    livemode = paramBoolean;
  }
  
  public void setMetadata(Map<String, String> paramMap)
  {
    metadata = paramMap;
  }
  
  public void setName(String paramString)
  {
    name = paramString;
  }
  
  @Deprecated
  public void setStatementDescription(String paramString)
  {
    statementDescription = paramString;
  }
  
  public void setStatementDescriptor(String paramString)
  {
    statementDescriptor = paramString;
  }
  
  public void setTrialPeriodDays(Integer paramInteger)
  {
    trialPeriodDays = paramInteger;
  }
  
  public Plan update(Map<String, Object> paramMap)
    throws AuthenticationException, InvalidRequestException, APIConnectionException, CardException, APIException
  {
    return update(paramMap, (RequestOptions)null);
  }
  
  public Plan update(Map<String, Object> paramMap, RequestOptions paramRequestOptions)
    throws AuthenticationException, InvalidRequestException, APIConnectionException, CardException, APIException
  {
    return (Plan)request(APIResource.RequestMethod.POST, instanceURL(Plan.class, id), paramMap, Plan.class, paramRequestOptions);
  }
  
  @Deprecated
  public Plan update(Map<String, Object> paramMap, String paramString)
    throws AuthenticationException, InvalidRequestException, APIConnectionException, CardException, APIException
  {
    return update(paramMap, RequestOptions.builder().setApiKey(paramString).build());
  }
}

/* Location:
 * Qualified Name:     com.stripe.model.Plan
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */