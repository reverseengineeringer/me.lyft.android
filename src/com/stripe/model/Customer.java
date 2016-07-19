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
import java.util.HashMap;
import java.util.Map;

public class Customer
  extends APIResource
  implements MetadataStore<Customer>
{
  Integer accountBalance;
  CustomerCardCollection cards;
  Long created;
  String currency;
  String defaultCard;
  String defaultSource;
  Boolean deleted;
  Boolean delinquent;
  String description;
  Discount discount;
  String email;
  String id;
  Boolean livemode;
  Map<String, String> metadata;
  NextRecurringCharge nextRecurringCharge;
  ExternalAccountCollection sources;
  Subscription subscription;
  CustomerSubscriptionCollection subscriptions;
  Long trialEnd;
  
  public static CustomerCollection all(Map<String, Object> paramMap)
    throws AuthenticationException, InvalidRequestException, APIConnectionException, CardException, APIException
  {
    return all(paramMap, (RequestOptions)null);
  }
  
  public static CustomerCollection all(Map<String, Object> paramMap, RequestOptions paramRequestOptions)
    throws AuthenticationException, InvalidRequestException, APIConnectionException, CardException, APIException
  {
    return (CustomerCollection)request(APIResource.RequestMethod.GET, classURL(Customer.class), paramMap, CustomerCollection.class, paramRequestOptions);
  }
  
  @Deprecated
  public static CustomerCollection all(Map<String, Object> paramMap, String paramString)
    throws AuthenticationException, InvalidRequestException, APIConnectionException, CardException, APIException
  {
    return all(paramMap, RequestOptions.builder().setApiKey(paramString).build());
  }
  
  public static Customer create(Map<String, Object> paramMap)
    throws AuthenticationException, InvalidRequestException, APIConnectionException, CardException, APIException
  {
    return create(paramMap, (RequestOptions)null);
  }
  
  public static Customer create(Map<String, Object> paramMap, RequestOptions paramRequestOptions)
    throws AuthenticationException, InvalidRequestException, APIConnectionException, CardException, APIException
  {
    return (Customer)request(APIResource.RequestMethod.POST, classURL(Customer.class), paramMap, Customer.class, paramRequestOptions);
  }
  
  @Deprecated
  public static Customer create(Map<String, Object> paramMap, String paramString)
    throws AuthenticationException, InvalidRequestException, APIConnectionException, CardException, APIException
  {
    return create(paramMap, RequestOptions.builder().setApiKey(paramString).build());
  }
  
  public static Customer retrieve(String paramString)
    throws AuthenticationException, InvalidRequestException, APIConnectionException, CardException, APIException
  {
    return retrieve(paramString, (RequestOptions)null);
  }
  
  public static Customer retrieve(String paramString, RequestOptions paramRequestOptions)
    throws AuthenticationException, InvalidRequestException, APIConnectionException, CardException, APIException
  {
    return (Customer)request(APIResource.RequestMethod.GET, instanceURL(Customer.class, paramString), null, Customer.class, paramRequestOptions);
  }
  
  @Deprecated
  public static Customer retrieve(String paramString1, String paramString2)
    throws AuthenticationException, InvalidRequestException, APIConnectionException, CardException, APIException
  {
    return retrieve(paramString1, RequestOptions.builder().setApiKey(paramString2).build());
  }
  
  public Subscription cancelSubscription()
    throws AuthenticationException, InvalidRequestException, APIConnectionException, CardException, APIException
  {
    return cancelSubscription(null, (RequestOptions)null);
  }
  
  public Subscription cancelSubscription(RequestOptions paramRequestOptions)
    throws AuthenticationException, InvalidRequestException, APIConnectionException, CardException, APIException
  {
    return cancelSubscription(null, paramRequestOptions);
  }
  
  @Deprecated
  public Subscription cancelSubscription(String paramString)
    throws AuthenticationException, InvalidRequestException, APIConnectionException, CardException, APIException
  {
    return cancelSubscription(RequestOptions.builder().setApiKey(paramString).build());
  }
  
  public Subscription cancelSubscription(Map<String, Object> paramMap)
    throws AuthenticationException, InvalidRequestException, APIConnectionException, CardException, APIException
  {
    return cancelSubscription(paramMap, (RequestOptions)null);
  }
  
  public Subscription cancelSubscription(Map<String, Object> paramMap, RequestOptions paramRequestOptions)
    throws AuthenticationException, InvalidRequestException, APIConnectionException, CardException, APIException
  {
    return (Subscription)request(APIResource.RequestMethod.DELETE, String.format("%s/subscription", new Object[] { instanceURL(Customer.class, id) }), paramMap, Subscription.class, paramRequestOptions);
  }
  
  @Deprecated
  public Subscription cancelSubscription(Map<String, Object> paramMap, String paramString)
    throws AuthenticationException, InvalidRequestException, APIConnectionException, CardException, APIException
  {
    return cancelSubscription(paramMap, RequestOptions.builder().setApiKey(paramString).build());
  }
  
  public Card createCard(String paramString)
    throws AuthenticationException, InvalidRequestException, APIConnectionException, CardException, APIException
  {
    return createCard(paramString, (RequestOptions)null);
  }
  
  public Card createCard(String paramString, RequestOptions paramRequestOptions)
    throws AuthenticationException, InvalidRequestException, APIConnectionException, CardException, APIException
  {
    HashMap localHashMap = new HashMap();
    localHashMap.put("card", paramString);
    return createCard(localHashMap, paramRequestOptions);
  }
  
  @Deprecated
  public Card createCard(String paramString1, String paramString2)
    throws AuthenticationException, InvalidRequestException, APIConnectionException, CardException, APIException
  {
    return createCard(paramString1, RequestOptions.builder().setApiKey(paramString2).build());
  }
  
  public Card createCard(Map<String, Object> paramMap)
    throws AuthenticationException, InvalidRequestException, APIConnectionException, CardException, APIException
  {
    return createCard(paramMap, (RequestOptions)null);
  }
  
  public Card createCard(Map<String, Object> paramMap, RequestOptions paramRequestOptions)
    throws AuthenticationException, InvalidRequestException, APIConnectionException, CardException, APIException
  {
    return (Card)request(APIResource.RequestMethod.POST, String.format("%s/cards", new Object[] { instanceURL(Customer.class, id) }), paramMap, Card.class, paramRequestOptions);
  }
  
  @Deprecated
  public Card createCard(Map<String, Object> paramMap, String paramString)
    throws AuthenticationException, InvalidRequestException, APIConnectionException, CardException, APIException
  {
    return createCard(paramMap, RequestOptions.builder().setApiKey(paramString).build());
  }
  
  public Subscription createSubscription(Map<String, Object> paramMap)
    throws AuthenticationException, InvalidRequestException, APIConnectionException, CardException, APIException
  {
    return createSubscription(paramMap, (RequestOptions)null);
  }
  
  public Subscription createSubscription(Map<String, Object> paramMap, RequestOptions paramRequestOptions)
    throws AuthenticationException, InvalidRequestException, APIConnectionException, CardException, APIException
  {
    return (Subscription)request(APIResource.RequestMethod.POST, String.format("%s/subscriptions", new Object[] { instanceURL(Customer.class, id) }), paramMap, Subscription.class, paramRequestOptions);
  }
  
  @Deprecated
  public Subscription createSubscription(Map<String, Object> paramMap, String paramString)
    throws AuthenticationException, InvalidRequestException, APIConnectionException, CardException, APIException
  {
    return createSubscription(paramMap, RequestOptions.builder().setApiKey(paramString).build());
  }
  
  public DeletedCustomer delete()
    throws AuthenticationException, InvalidRequestException, APIConnectionException, CardException, APIException
  {
    return delete((RequestOptions)null);
  }
  
  public DeletedCustomer delete(RequestOptions paramRequestOptions)
    throws AuthenticationException, InvalidRequestException, APIConnectionException, CardException, APIException
  {
    return (DeletedCustomer)request(APIResource.RequestMethod.DELETE, instanceURL(Customer.class, id), null, DeletedCustomer.class, paramRequestOptions);
  }
  
  @Deprecated
  public DeletedCustomer delete(String paramString)
    throws AuthenticationException, InvalidRequestException, APIConnectionException, CardException, APIException
  {
    return delete(RequestOptions.builder().setApiKey(paramString).build());
  }
  
  public void deleteDiscount()
    throws AuthenticationException, InvalidRequestException, APIConnectionException, CardException, APIException
  {
    deleteDiscount((RequestOptions)null);
  }
  
  public void deleteDiscount(RequestOptions paramRequestOptions)
    throws AuthenticationException, InvalidRequestException, APIConnectionException, CardException, APIException
  {
    request(APIResource.RequestMethod.DELETE, String.format("%s/discount", new Object[] { instanceURL(Customer.class, id) }), null, Discount.class, paramRequestOptions);
  }
  
  @Deprecated
  public void deleteDiscount(String paramString)
    throws AuthenticationException, InvalidRequestException, APIConnectionException, CardException, APIException
  {
    deleteDiscount(RequestOptions.builder().setApiKey(paramString).build());
  }
  
  public Integer getAccountBalance()
  {
    return accountBalance;
  }
  
  public CustomerCardCollection getCards()
  {
    return cards;
  }
  
  public Long getCreated()
  {
    return created;
  }
  
  public String getCurrency()
  {
    return currency;
  }
  
  public String getDefaultCard()
  {
    return defaultCard;
  }
  
  public String getDefaultSource()
  {
    return defaultSource;
  }
  
  public Boolean getDeleted()
  {
    return deleted;
  }
  
  public Boolean getDelinquent()
  {
    return delinquent;
  }
  
  public String getDescription()
  {
    return description;
  }
  
  public Discount getDiscount()
  {
    return discount;
  }
  
  public String getEmail()
  {
    return email;
  }
  
  public String getId()
  {
    return id;
  }
  
  public Boolean getLivemode()
  {
    return livemode;
  }
  
  public Map<String, String> getMetadata()
  {
    return metadata;
  }
  
  public NextRecurringCharge getNextRecurringCharge()
  {
    return nextRecurringCharge;
  }
  
  public ExternalAccountCollection getSources()
  {
    return sources;
  }
  
  public Subscription getSubscription()
  {
    return subscription;
  }
  
  public CustomerSubscriptionCollection getSubscriptions()
  {
    return subscriptions;
  }
  
  public Long getTrialEnd()
  {
    return trialEnd;
  }
  
  public void setAccountBalance(Integer paramInteger)
  {
    accountBalance = paramInteger;
  }
  
  public void setCreated(Long paramLong)
  {
    created = paramLong;
  }
  
  public void setCurrency(String paramString)
  {
    currency = paramString;
  }
  
  public void setDefaultCard(String paramString)
  {
    defaultCard = paramString;
  }
  
  public void setDefaultSource(String paramString)
  {
    defaultSource = paramString;
  }
  
  public void setDelinquent(Boolean paramBoolean)
  {
    delinquent = paramBoolean;
  }
  
  public void setDescription(String paramString)
  {
    description = paramString;
  }
  
  public void setDiscount(Discount paramDiscount)
  {
    discount = paramDiscount;
  }
  
  public void setEmail(String paramString)
  {
    email = paramString;
  }
  
  public void setId(String paramString)
  {
    id = paramString;
  }
  
  public void setLivemode(Boolean paramBoolean)
  {
    livemode = paramBoolean;
  }
  
  public void setMetadata(Map<String, String> paramMap)
  {
    metadata = paramMap;
  }
  
  public void setNextRecurringCharge(NextRecurringCharge paramNextRecurringCharge)
  {
    nextRecurringCharge = paramNextRecurringCharge;
  }
  
  public void setSources(ExternalAccountCollection paramExternalAccountCollection)
  {
    sources = paramExternalAccountCollection;
  }
  
  public void setSubscription(Subscription paramSubscription)
  {
    subscription = paramSubscription;
  }
  
  public void setTrialEnd(Long paramLong)
  {
    trialEnd = paramLong;
  }
  
  public Customer update(Map<String, Object> paramMap)
    throws AuthenticationException, InvalidRequestException, APIConnectionException, CardException, APIException
  {
    return update(paramMap, (RequestOptions)null);
  }
  
  public Customer update(Map<String, Object> paramMap, RequestOptions paramRequestOptions)
    throws AuthenticationException, InvalidRequestException, APIConnectionException, CardException, APIException
  {
    return (Customer)request(APIResource.RequestMethod.POST, instanceURL(Customer.class, id), paramMap, Customer.class, paramRequestOptions);
  }
  
  @Deprecated
  public Customer update(Map<String, Object> paramMap, String paramString)
    throws AuthenticationException, InvalidRequestException, APIConnectionException, CardException, APIException
  {
    return update(paramMap, RequestOptions.builder().setApiKey(paramString).build());
  }
  
  public Subscription updateSubscription(Map<String, Object> paramMap)
    throws AuthenticationException, InvalidRequestException, APIConnectionException, CardException, APIException
  {
    return updateSubscription(paramMap, (RequestOptions)null);
  }
  
  public Subscription updateSubscription(Map<String, Object> paramMap, RequestOptions paramRequestOptions)
    throws AuthenticationException, InvalidRequestException, APIConnectionException, CardException, APIException
  {
    return (Subscription)request(APIResource.RequestMethod.POST, String.format("%s/subscription", new Object[] { instanceURL(Customer.class, id) }), paramMap, Subscription.class, paramRequestOptions);
  }
  
  @Deprecated
  public Subscription updateSubscription(Map<String, Object> paramMap, String paramString)
    throws AuthenticationException, InvalidRequestException, APIConnectionException, CardException, APIException
  {
    return updateSubscription(paramMap, RequestOptions.builder().setApiKey(paramString).build());
  }
}

/* Location:
 * Qualified Name:     com.stripe.model.Customer
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */