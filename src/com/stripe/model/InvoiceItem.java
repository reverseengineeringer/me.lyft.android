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

public class InvoiceItem
  extends APIResource
  implements MetadataStore<InvoiceItem>
{
  Integer amount;
  String currency;
  String customer;
  Long date;
  String description;
  String id;
  String invoice;
  Boolean livemode;
  Map<String, String> metadata;
  String subscription;
  
  public static InvoiceItemCollection all(Map<String, Object> paramMap)
    throws AuthenticationException, InvalidRequestException, APIConnectionException, CardException, APIException
  {
    return all(paramMap, (RequestOptions)null);
  }
  
  public static InvoiceItemCollection all(Map<String, Object> paramMap, RequestOptions paramRequestOptions)
    throws AuthenticationException, InvalidRequestException, APIConnectionException, CardException, APIException
  {
    return (InvoiceItemCollection)request(APIResource.RequestMethod.GET, classURL(InvoiceItem.class), paramMap, InvoiceItemCollection.class, paramRequestOptions);
  }
  
  @Deprecated
  public static InvoiceItemCollection all(Map<String, Object> paramMap, String paramString)
    throws AuthenticationException, InvalidRequestException, APIConnectionException, CardException, APIException
  {
    return all(paramMap, RequestOptions.builder().setApiKey(paramString).build());
  }
  
  public static InvoiceItem create(Map<String, Object> paramMap)
    throws AuthenticationException, InvalidRequestException, APIConnectionException, CardException, APIException
  {
    return create(paramMap, (RequestOptions)null);
  }
  
  public static InvoiceItem create(Map<String, Object> paramMap, RequestOptions paramRequestOptions)
    throws AuthenticationException, InvalidRequestException, APIConnectionException, CardException, APIException
  {
    return (InvoiceItem)request(APIResource.RequestMethod.POST, classURL(InvoiceItem.class), paramMap, InvoiceItem.class, paramRequestOptions);
  }
  
  @Deprecated
  public static InvoiceItem create(Map<String, Object> paramMap, String paramString)
    throws AuthenticationException, InvalidRequestException, APIConnectionException, CardException, APIException
  {
    return create(paramMap, RequestOptions.builder().setApiKey(paramString).build());
  }
  
  public static InvoiceItem retrieve(String paramString)
    throws AuthenticationException, InvalidRequestException, APIConnectionException, CardException, APIException
  {
    return retrieve(paramString, (RequestOptions)null);
  }
  
  public static InvoiceItem retrieve(String paramString, RequestOptions paramRequestOptions)
    throws AuthenticationException, InvalidRequestException, APIConnectionException, CardException, APIException
  {
    return (InvoiceItem)request(APIResource.RequestMethod.GET, instanceURL(InvoiceItem.class, paramString), null, InvoiceItem.class, paramRequestOptions);
  }
  
  @Deprecated
  public static InvoiceItem retrieve(String paramString1, String paramString2)
    throws AuthenticationException, InvalidRequestException, APIConnectionException, CardException, APIException
  {
    return retrieve(paramString1, RequestOptions.builder().setApiKey(paramString2).build());
  }
  
  public DeletedInvoiceItem delete()
    throws AuthenticationException, InvalidRequestException, APIConnectionException, CardException, APIException
  {
    return delete((RequestOptions)null);
  }
  
  public DeletedInvoiceItem delete(RequestOptions paramRequestOptions)
    throws AuthenticationException, InvalidRequestException, APIConnectionException, CardException, APIException
  {
    return (DeletedInvoiceItem)request(APIResource.RequestMethod.DELETE, instanceURL(InvoiceItem.class, id), null, DeletedInvoiceItem.class, paramRequestOptions);
  }
  
  @Deprecated
  public DeletedInvoiceItem delete(String paramString)
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
  
  public String getCustomer()
  {
    return customer;
  }
  
  public Long getDate()
  {
    return date;
  }
  
  public String getDescription()
  {
    return description;
  }
  
  public String getId()
  {
    return id;
  }
  
  public String getInvoice()
  {
    return invoice;
  }
  
  public Boolean getLivemode()
  {
    return livemode;
  }
  
  public Map<String, String> getMetadata()
  {
    return metadata;
  }
  
  public String getSubscription()
  {
    return subscription;
  }
  
  public void setAmount(Integer paramInteger)
  {
    amount = paramInteger;
  }
  
  public void setCurrency(String paramString)
  {
    currency = paramString;
  }
  
  public void setCustomer(String paramString)
  {
    customer = paramString;
  }
  
  public void setDate(Long paramLong)
  {
    date = paramLong;
  }
  
  public void setDescription(String paramString)
  {
    description = paramString;
  }
  
  public void setId(String paramString)
  {
    id = paramString;
  }
  
  public void setInvoice(String paramString)
  {
    invoice = paramString;
  }
  
  public void setLivemode(Boolean paramBoolean)
  {
    livemode = paramBoolean;
  }
  
  public void setMetadata(Map<String, String> paramMap)
  {
    metadata = paramMap;
  }
  
  public void setSubscription(String paramString)
  {
    subscription = paramString;
  }
  
  public InvoiceItem update(Map<String, Object> paramMap)
    throws AuthenticationException, InvalidRequestException, APIConnectionException, CardException, APIException
  {
    return update(paramMap, (RequestOptions)null);
  }
  
  public InvoiceItem update(Map<String, Object> paramMap, RequestOptions paramRequestOptions)
    throws AuthenticationException, InvalidRequestException, APIConnectionException, CardException, APIException
  {
    return (InvoiceItem)request(APIResource.RequestMethod.POST, instanceURL(InvoiceItem.class, id), paramMap, InvoiceItem.class, paramRequestOptions);
  }
  
  @Deprecated
  public InvoiceItem update(Map<String, Object> paramMap, String paramString)
    throws AuthenticationException, InvalidRequestException, APIConnectionException, CardException, APIException
  {
    return update(paramMap, RequestOptions.builder().setApiKey(paramString).build());
  }
}

/* Location:
 * Qualified Name:     com.stripe.model.InvoiceItem
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */