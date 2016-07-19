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

public class Subscription
  extends APIResource
  implements MetadataStore<Subscription>
{
  Double applicationFeePercent;
  Boolean cancelAtPeriodEnd;
  Long canceledAt;
  Long currentPeriodEnd;
  Long currentPeriodStart;
  String customer;
  Discount discount;
  Long endedAt;
  String id;
  Map<String, String> metadata;
  Plan plan;
  Integer quantity;
  Long start;
  String status;
  Double taxPercent;
  Long trialEnd;
  Long trialStart;
  
  public Subscription cancel(Map<String, Object> paramMap)
    throws AuthenticationException, InvalidRequestException, APIConnectionException, CardException, APIException
  {
    return cancel(paramMap, (RequestOptions)null);
  }
  
  public Subscription cancel(Map<String, Object> paramMap, RequestOptions paramRequestOptions)
    throws AuthenticationException, InvalidRequestException, APIConnectionException, CardException, APIException
  {
    return (Subscription)request(APIResource.RequestMethod.DELETE, getInstanceURL(), paramMap, Subscription.class, paramRequestOptions);
  }
  
  @Deprecated
  public Subscription cancel(Map<String, Object> paramMap, String paramString)
    throws AuthenticationException, InvalidRequestException, APIConnectionException, CardException, APIException
  {
    return cancel(paramMap, RequestOptions.builder().setApiKey(paramString).build());
  }
  
  public void deleteDiscount()
    throws AuthenticationException, InvalidRequestException, APIConnectionException, CardException, APIException
  {
    deleteDiscount((RequestOptions)null);
  }
  
  public void deleteDiscount(RequestOptions paramRequestOptions)
    throws AuthenticationException, InvalidRequestException, APIConnectionException, CardException, APIException
  {
    request(APIResource.RequestMethod.DELETE, String.format("%s/discount", new Object[] { getInstanceURL() }), null, Discount.class, paramRequestOptions);
  }
  
  @Deprecated
  public void deleteDiscount(String paramString)
    throws AuthenticationException, InvalidRequestException, APIConnectionException, CardException, APIException
  {
    RequestOptions localRequestOptions = null;
    if (paramString != null) {
      localRequestOptions = RequestOptions.builder().setApiKey(paramString).build();
    }
    deleteDiscount(localRequestOptions);
  }
  
  public Double getApplicationFeePercent()
  {
    return applicationFeePercent;
  }
  
  public Boolean getCancelAtPeriodEnd()
  {
    return cancelAtPeriodEnd;
  }
  
  public Long getCanceledAt()
  {
    return canceledAt;
  }
  
  public Long getCurrentPeriodEnd()
  {
    return currentPeriodEnd;
  }
  
  public Long getCurrentPeriodStart()
  {
    return currentPeriodStart;
  }
  
  public String getCustomer()
  {
    return customer;
  }
  
  public Discount getDiscount()
  {
    return discount;
  }
  
  public Long getEndedAt()
  {
    return endedAt;
  }
  
  public String getId()
  {
    return id;
  }
  
  public String getInstanceURL()
  {
    return String.format("%s/%s/subscriptions/%s", new Object[] { classURL(Customer.class), getCustomer(), getId() });
  }
  
  public Map<String, String> getMetadata()
  {
    return metadata;
  }
  
  public Plan getPlan()
  {
    return plan;
  }
  
  public Integer getQuantity()
  {
    return quantity;
  }
  
  public Long getStart()
  {
    return start;
  }
  
  public String getStatus()
  {
    return status;
  }
  
  public Double getTaxPercent()
  {
    return taxPercent;
  }
  
  public Long getTrialEnd()
  {
    return trialEnd;
  }
  
  public Long getTrialStart()
  {
    return trialStart;
  }
  
  public void setApplicationFeePercent(Double paramDouble)
  {
    applicationFeePercent = paramDouble;
  }
  
  public void setCancelAtPeriodEnd(Boolean paramBoolean)
  {
    cancelAtPeriodEnd = paramBoolean;
  }
  
  public void setCanceledAt(Long paramLong)
  {
    canceledAt = paramLong;
  }
  
  public void setCurrentPeriodEnd(Long paramLong)
  {
    currentPeriodEnd = paramLong;
  }
  
  public void setCurrentPeriodStart(Long paramLong)
  {
    currentPeriodStart = paramLong;
  }
  
  public void setCustomer(String paramString)
  {
    customer = paramString;
  }
  
  public void setDiscount(Discount paramDiscount)
  {
    discount = paramDiscount;
  }
  
  public void setEndedAt(Long paramLong)
  {
    endedAt = paramLong;
  }
  
  public void setId(String paramString)
  {
    id = paramString;
  }
  
  public void setMetadata(Map<String, String> paramMap)
  {
    metadata = paramMap;
  }
  
  public void setPlan(Plan paramPlan)
  {
    plan = paramPlan;
  }
  
  public void setQuantity(Integer paramInteger)
  {
    quantity = paramInteger;
  }
  
  public void setStart(Long paramLong)
  {
    start = paramLong;
  }
  
  public void setStatus(String paramString)
  {
    status = paramString;
  }
  
  public void setTaxPercent(Double paramDouble)
  {
    taxPercent = paramDouble;
  }
  
  public void setTrialEnd(Long paramLong)
  {
    trialEnd = paramLong;
  }
  
  public void setTrialStart(Long paramLong)
  {
    trialStart = paramLong;
  }
  
  public Subscription update(Map<String, Object> paramMap)
    throws AuthenticationException, InvalidRequestException, APIConnectionException, CardException, APIException
  {
    return update(paramMap, (RequestOptions)null);
  }
  
  public Subscription update(Map<String, Object> paramMap, RequestOptions paramRequestOptions)
    throws AuthenticationException, InvalidRequestException, APIConnectionException, CardException, APIException
  {
    return (Subscription)request(APIResource.RequestMethod.POST, getInstanceURL(), paramMap, Subscription.class, paramRequestOptions);
  }
  
  @Deprecated
  public Subscription update(Map<String, Object> paramMap, String paramString)
    throws AuthenticationException, InvalidRequestException, APIConnectionException, CardException, APIException
  {
    return update(paramMap, RequestOptions.builder().setApiKey(paramString).build());
  }
}

/* Location:
 * Qualified Name:     com.stripe.model.Subscription
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */