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

public class Invoice
  extends APIResource
  implements MetadataStore<Invoice>
{
  Integer amountDue;
  Long applicationFee;
  Integer attemptCount;
  Boolean attempted;
  String charge;
  Boolean closed;
  Long created;
  String currency;
  String customer;
  Long date;
  String description;
  Discount discount;
  Integer endingBalance;
  Boolean forgiven;
  String id;
  InvoiceLineItemCollection lines;
  Boolean livemode;
  Map<String, String> metadata;
  Long nextPaymentAttempt;
  Boolean paid;
  Long periodEnd;
  Long periodStart;
  Integer startingBalance;
  String statementDescriptor;
  String subscription;
  Integer subtotal;
  Integer tax;
  Double taxPercent;
  Integer total;
  
  public static InvoiceCollection all(Map<String, Object> paramMap)
    throws AuthenticationException, InvalidRequestException, APIConnectionException, CardException, APIException
  {
    return all(paramMap, (RequestOptions)null);
  }
  
  public static InvoiceCollection all(Map<String, Object> paramMap, RequestOptions paramRequestOptions)
    throws AuthenticationException, InvalidRequestException, APIConnectionException, CardException, APIException
  {
    return (InvoiceCollection)request(APIResource.RequestMethod.GET, classURL(Invoice.class), paramMap, InvoiceCollection.class, paramRequestOptions);
  }
  
  @Deprecated
  public static InvoiceCollection all(Map<String, Object> paramMap, String paramString)
    throws AuthenticationException, InvalidRequestException, APIConnectionException, CardException, APIException
  {
    return all(paramMap, RequestOptions.builder().setApiKey(paramString).build());
  }
  
  public static Invoice create(Map<String, Object> paramMap)
    throws AuthenticationException, InvalidRequestException, APIConnectionException, CardException, APIException
  {
    return create(paramMap, (RequestOptions)null);
  }
  
  public static Invoice create(Map<String, Object> paramMap, RequestOptions paramRequestOptions)
    throws AuthenticationException, InvalidRequestException, APIConnectionException, CardException, APIException
  {
    return (Invoice)request(APIResource.RequestMethod.POST, classURL(Invoice.class), paramMap, Invoice.class, paramRequestOptions);
  }
  
  @Deprecated
  public static Invoice create(Map<String, Object> paramMap, String paramString)
    throws AuthenticationException, InvalidRequestException, APIConnectionException, CardException, APIException
  {
    return create(paramMap, RequestOptions.builder().setApiKey(paramString).build());
  }
  
  public static Invoice retrieve(String paramString)
    throws AuthenticationException, InvalidRequestException, APIConnectionException, CardException, APIException
  {
    return retrieve(paramString, (RequestOptions)null);
  }
  
  public static Invoice retrieve(String paramString, RequestOptions paramRequestOptions)
    throws AuthenticationException, InvalidRequestException, APIConnectionException, CardException, APIException
  {
    return (Invoice)request(APIResource.RequestMethod.GET, instanceURL(Invoice.class, paramString), null, Invoice.class, paramRequestOptions);
  }
  
  @Deprecated
  public static Invoice retrieve(String paramString1, String paramString2)
    throws AuthenticationException, InvalidRequestException, APIConnectionException, CardException, APIException
  {
    return retrieve(paramString1, RequestOptions.builder().setApiKey(paramString2).build());
  }
  
  public static Invoice upcoming(Map<String, Object> paramMap)
    throws AuthenticationException, InvalidRequestException, APIConnectionException, CardException, APIException
  {
    return upcoming(paramMap, (RequestOptions)null);
  }
  
  public static Invoice upcoming(Map<String, Object> paramMap, RequestOptions paramRequestOptions)
    throws AuthenticationException, InvalidRequestException, APIConnectionException, CardException, APIException
  {
    return (Invoice)request(APIResource.RequestMethod.GET, String.format("%s/upcoming", new Object[] { classURL(Invoice.class) }), paramMap, Invoice.class, paramRequestOptions);
  }
  
  @Deprecated
  public static Invoice upcoming(Map<String, Object> paramMap, String paramString)
    throws AuthenticationException, InvalidRequestException, APIConnectionException, CardException, APIException
  {
    return upcoming(paramMap, RequestOptions.builder().setApiKey(paramString).build());
  }
  
  public Integer getAmountDue()
  {
    return amountDue;
  }
  
  public Long getApplicationFee()
  {
    return applicationFee;
  }
  
  public Integer getAttemptCount()
  {
    return attemptCount;
  }
  
  public Boolean getAttempted()
  {
    return attempted;
  }
  
  public String getCharge()
  {
    return charge;
  }
  
  public Boolean getClosed()
  {
    return closed;
  }
  
  public Long getCreated()
  {
    return created;
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
  
  public Discount getDiscount()
  {
    return discount;
  }
  
  public Integer getEndingBalance()
  {
    return endingBalance;
  }
  
  public Boolean getForgiven()
  {
    return forgiven;
  }
  
  public String getId()
  {
    return id;
  }
  
  public InvoiceLineItemCollection getLines()
  {
    return lines;
  }
  
  public Boolean getLivemode()
  {
    return livemode;
  }
  
  public Map<String, String> getMetadata()
  {
    return metadata;
  }
  
  public Long getNextPaymentAttempt()
  {
    return nextPaymentAttempt;
  }
  
  public Boolean getPaid()
  {
    return paid;
  }
  
  public Long getPeriodEnd()
  {
    return periodEnd;
  }
  
  public Long getPeriodStart()
  {
    return periodStart;
  }
  
  public Integer getStartingBalance()
  {
    return startingBalance;
  }
  
  public String getStatementDescriptor()
  {
    return statementDescriptor;
  }
  
  public String getSubscription()
  {
    return subscription;
  }
  
  public Integer getSubtotal()
  {
    return subtotal;
  }
  
  public Integer getTax()
  {
    return tax;
  }
  
  public Double getTaxPercent()
  {
    return taxPercent;
  }
  
  public Integer getTotal()
  {
    return total;
  }
  
  public Invoice pay()
    throws AuthenticationException, InvalidRequestException, APIConnectionException, CardException, APIException
  {
    return pay((RequestOptions)null);
  }
  
  public Invoice pay(RequestOptions paramRequestOptions)
    throws AuthenticationException, InvalidRequestException, APIConnectionException, CardException, APIException
  {
    return (Invoice)request(APIResource.RequestMethod.POST, String.format("%s/pay", new Object[] { instanceURL(Invoice.class, getId()) }), null, Invoice.class, paramRequestOptions);
  }
  
  @Deprecated
  public Invoice pay(String paramString)
    throws AuthenticationException, InvalidRequestException, APIConnectionException, CardException, APIException
  {
    return pay(RequestOptions.builder().setApiKey(paramString).build());
  }
  
  public void setAmountDue(Integer paramInteger)
  {
    amountDue = paramInteger;
  }
  
  public void setApplicationFee(Long paramLong)
  {
    applicationFee = paramLong;
  }
  
  public void setAttemptCount(Integer paramInteger)
  {
    attemptCount = paramInteger;
  }
  
  public void setAttempted(Boolean paramBoolean)
  {
    attempted = paramBoolean;
  }
  
  public void setCharge(String paramString)
  {
    charge = paramString;
  }
  
  public void setClosed(Boolean paramBoolean)
  {
    closed = paramBoolean;
  }
  
  public void setCreated(Long paramLong)
  {
    created = paramLong;
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
  
  public void setDiscount(Discount paramDiscount)
  {
    discount = paramDiscount;
  }
  
  public void setEndingBalance(Integer paramInteger)
  {
    endingBalance = paramInteger;
  }
  
  public void setForgiven(Boolean paramBoolean)
  {
    forgiven = paramBoolean;
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
  
  public void setNextPaymentAttempt(Long paramLong)
  {
    nextPaymentAttempt = paramLong;
  }
  
  public void setPaid(Boolean paramBoolean)
  {
    paid = paramBoolean;
  }
  
  public void setPeriodEnd(Long paramLong)
  {
    periodEnd = paramLong;
  }
  
  public void setPeriodStart(Long paramLong)
  {
    periodStart = paramLong;
  }
  
  public void setStartingBalance(Integer paramInteger)
  {
    startingBalance = paramInteger;
  }
  
  public void setStatementDescriptor(String paramString)
  {
    statementDescriptor = paramString;
  }
  
  public void setSubscription(String paramString)
  {
    subscription = paramString;
  }
  
  public void setSubtotal(Integer paramInteger)
  {
    subtotal = paramInteger;
  }
  
  public void setTax(Integer paramInteger)
  {
    tax = paramInteger;
  }
  
  public void setTaxPercent(Double paramDouble)
  {
    taxPercent = paramDouble;
  }
  
  public void setTotal(Integer paramInteger)
  {
    total = paramInteger;
  }
  
  public Invoice update(Map<String, Object> paramMap)
    throws AuthenticationException, InvalidRequestException, APIConnectionException, CardException, APIException
  {
    return update(paramMap, (RequestOptions)null);
  }
  
  public Invoice update(Map<String, Object> paramMap, RequestOptions paramRequestOptions)
    throws AuthenticationException, InvalidRequestException, APIConnectionException, CardException, APIException
  {
    return (Invoice)request(APIResource.RequestMethod.POST, instanceURL(Invoice.class, id), paramMap, Invoice.class, paramRequestOptions);
  }
  
  @Deprecated
  public Invoice update(Map<String, Object> paramMap, String paramString)
    throws AuthenticationException, InvalidRequestException, APIConnectionException, CardException, APIException
  {
    return update(paramMap, RequestOptions.builder().setApiKey(paramString).build());
  }
}

/* Location:
 * Qualified Name:     com.stripe.model.Invoice
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */