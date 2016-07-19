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
import java.util.Collections;
import java.util.Map;

public class Charge
  extends APIResource
  implements MetadataStore<Charge>
{
  public static final String FRAUD_DETAILS = "fraud_details";
  Integer amount;
  Integer amountRefunded;
  String balanceTransaction;
  Boolean captured;
  Card card;
  Long created;
  String currency;
  String customer;
  String description;
  Dispute dispute;
  Boolean disputed;
  String failureCode;
  String failureMessage;
  FraudDetails fraudDetails;
  String id;
  String invoice;
  Boolean livemode;
  Map<String, String> metadata;
  Boolean paid;
  String receiptEmail;
  String receiptNumber;
  Boolean refunded;
  ChargeRefundCollection refunds;
  ShippingDetails shipping;
  ExternalAccount source;
  @Deprecated
  String statementDescription;
  String statementDescriptor;
  String status;
  
  public static ChargeCollection all(Map<String, Object> paramMap)
    throws AuthenticationException, InvalidRequestException, APIConnectionException, CardException, APIException
  {
    return all(paramMap, (RequestOptions)null);
  }
  
  public static ChargeCollection all(Map<String, Object> paramMap, RequestOptions paramRequestOptions)
    throws AuthenticationException, InvalidRequestException, APIConnectionException, CardException, APIException
  {
    return (ChargeCollection)request(APIResource.RequestMethod.GET, classURL(Charge.class), paramMap, ChargeCollection.class, paramRequestOptions);
  }
  
  @Deprecated
  public static ChargeCollection all(Map<String, Object> paramMap, String paramString)
    throws AuthenticationException, InvalidRequestException, APIConnectionException, CardException, APIException
  {
    return all(paramMap, RequestOptions.builder().setApiKey(paramString).build());
  }
  
  public static Charge create(Map<String, Object> paramMap)
    throws AuthenticationException, InvalidRequestException, APIConnectionException, CardException, APIException
  {
    return create(paramMap, (RequestOptions)null);
  }
  
  public static Charge create(Map<String, Object> paramMap, RequestOptions paramRequestOptions)
    throws AuthenticationException, InvalidRequestException, APIConnectionException, CardException, APIException
  {
    return (Charge)request(APIResource.RequestMethod.POST, classURL(Charge.class), paramMap, Charge.class, paramRequestOptions);
  }
  
  @Deprecated
  public static Charge create(Map<String, Object> paramMap, String paramString)
    throws AuthenticationException, InvalidRequestException, APIConnectionException, CardException, APIException
  {
    return create(paramMap, RequestOptions.builder().setApiKey(paramString).build());
  }
  
  public static Charge retrieve(String paramString)
    throws AuthenticationException, InvalidRequestException, APIConnectionException, CardException, APIException
  {
    return retrieve(paramString, (RequestOptions)null);
  }
  
  public static Charge retrieve(String paramString, RequestOptions paramRequestOptions)
    throws AuthenticationException, InvalidRequestException, APIConnectionException, CardException, APIException
  {
    return (Charge)request(APIResource.RequestMethod.GET, instanceURL(Charge.class, paramString), null, Charge.class, paramRequestOptions);
  }
  
  @Deprecated
  public static Charge retrieve(String paramString1, String paramString2)
    throws AuthenticationException, InvalidRequestException, APIConnectionException, CardException, APIException
  {
    return retrieve(paramString1, RequestOptions.builder().setApiKey(paramString2).build());
  }
  
  public Charge capture()
    throws AuthenticationException, InvalidRequestException, APIConnectionException, CardException, APIException
  {
    return capture(null, (RequestOptions)null);
  }
  
  public Charge capture(RequestOptions paramRequestOptions)
    throws AuthenticationException, InvalidRequestException, APIConnectionException, CardException, APIException
  {
    return capture(null, paramRequestOptions);
  }
  
  @Deprecated
  public Charge capture(String paramString)
    throws AuthenticationException, InvalidRequestException, APIConnectionException, CardException, APIException
  {
    return capture(RequestOptions.builder().setApiKey(paramString).build());
  }
  
  public Charge capture(Map<String, Object> paramMap)
    throws AuthenticationException, InvalidRequestException, APIConnectionException, CardException, APIException
  {
    return capture(paramMap, (RequestOptions)null);
  }
  
  public Charge capture(Map<String, Object> paramMap, RequestOptions paramRequestOptions)
    throws AuthenticationException, InvalidRequestException, APIConnectionException, CardException, APIException
  {
    return (Charge)request(APIResource.RequestMethod.POST, String.format("%s/capture", new Object[] { instanceURL(Charge.class, getId()) }), paramMap, Charge.class, paramRequestOptions);
  }
  
  @Deprecated
  public Charge capture(Map<String, Object> paramMap, String paramString)
    throws AuthenticationException, InvalidRequestException, APIConnectionException, CardException, APIException
  {
    return capture(paramMap, RequestOptions.builder().setApiKey(paramString).build());
  }
  
  public Dispute closeDispute()
    throws AuthenticationException, InvalidRequestException, APIConnectionException, CardException, APIException
  {
    return closeDispute((RequestOptions)null);
  }
  
  public Dispute closeDispute(RequestOptions paramRequestOptions)
    throws AuthenticationException, InvalidRequestException, APIConnectionException, CardException, APIException
  {
    return (Dispute)request(APIResource.RequestMethod.POST, String.format("%s/dispute/close", new Object[] { instanceURL(Charge.class, getId()) }), null, Dispute.class, paramRequestOptions);
  }
  
  @Deprecated
  public Dispute closeDispute(String paramString)
    throws AuthenticationException, InvalidRequestException, APIConnectionException, CardException, APIException
  {
    return closeDispute(RequestOptions.builder().setApiKey(paramString).build());
  }
  
  public Integer getAmount()
  {
    return amount;
  }
  
  public Integer getAmountRefunded()
  {
    return amountRefunded;
  }
  
  public String getBalanceTransaction()
  {
    return balanceTransaction;
  }
  
  public Boolean getCaptured()
  {
    return captured;
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
  
  public String getCustomer()
  {
    return customer;
  }
  
  public String getDescription()
  {
    return description;
  }
  
  public Dispute getDispute()
  {
    return dispute;
  }
  
  @Deprecated
  public Boolean getDisputed()
  {
    return disputed;
  }
  
  public String getFailureCode()
  {
    return failureCode;
  }
  
  public String getFailureMessage()
  {
    return failureMessage;
  }
  
  public FraudDetails getFraudDetails()
  {
    return fraudDetails;
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
  
  public Boolean getPaid()
  {
    return paid;
  }
  
  public String getReceiptEmail()
  {
    return receiptEmail;
  }
  
  public String getReceiptNumber()
  {
    return receiptNumber;
  }
  
  public Boolean getRefunded()
  {
    return refunded;
  }
  
  public ChargeRefundCollection getRefunds()
  {
    if ((refunds != null) && (refunds.getURL() == null)) {
      refunds.setURL(String.format("/v1/charges/%s/refunds", new Object[] { getId() }));
    }
    return refunds;
  }
  
  public ShippingDetails getShipping()
  {
    return shipping;
  }
  
  public ExternalAccount getSource()
  {
    return source;
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
  
  public String getStatus()
  {
    return status;
  }
  
  public Charge markFraudulent(RequestOptions paramRequestOptions)
    throws AuthenticationException, InvalidRequestException, APIConnectionException, CardException, APIException
  {
    return update(Collections.singletonMap("fraud_details", Collections.singletonMap("user_report", "fraudulent")), paramRequestOptions);
  }
  
  public Charge markSafe(RequestOptions paramRequestOptions)
    throws AuthenticationException, InvalidRequestException, APIConnectionException, CardException, APIException
  {
    return update(Collections.singletonMap("fraud_details", Collections.singletonMap("user_report", "safe")), paramRequestOptions);
  }
  
  public Charge refund()
    throws AuthenticationException, InvalidRequestException, APIConnectionException, CardException, APIException
  {
    return refund(null, (RequestOptions)null);
  }
  
  public Charge refund(RequestOptions paramRequestOptions)
    throws AuthenticationException, InvalidRequestException, APIConnectionException, CardException, APIException
  {
    return refund(null, paramRequestOptions);
  }
  
  @Deprecated
  public Charge refund(String paramString)
    throws AuthenticationException, InvalidRequestException, APIConnectionException, CardException, APIException
  {
    return refund(RequestOptions.builder().setApiKey(paramString).build());
  }
  
  public Charge refund(Map<String, Object> paramMap)
    throws AuthenticationException, InvalidRequestException, APIConnectionException, CardException, APIException
  {
    return refund(paramMap, (RequestOptions)null);
  }
  
  public Charge refund(Map<String, Object> paramMap, RequestOptions paramRequestOptions)
    throws AuthenticationException, InvalidRequestException, APIConnectionException, CardException, APIException
  {
    return (Charge)request(APIResource.RequestMethod.POST, String.format("%s/refund", new Object[] { instanceURL(Charge.class, getId()) }), paramMap, Charge.class, paramRequestOptions);
  }
  
  @Deprecated
  public Charge refund(Map<String, Object> paramMap, String paramString)
    throws AuthenticationException, InvalidRequestException, APIConnectionException, CardException, APIException
  {
    return refund(paramMap, RequestOptions.builder().setApiKey(paramString).build());
  }
  
  public void setAmount(Integer paramInteger)
  {
    amount = paramInteger;
  }
  
  public void setAmountRefunded(Integer paramInteger)
  {
    amountRefunded = paramInteger;
  }
  
  public void setBalanceTransaction(String paramString)
  {
    balanceTransaction = paramString;
  }
  
  public void setCaptured(Boolean paramBoolean)
  {
    captured = paramBoolean;
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
  
  public void setCustomer(String paramString)
  {
    customer = paramString;
  }
  
  public void setDescription(String paramString)
  {
    description = paramString;
  }
  
  public void setDispute(Dispute paramDispute)
  {
    dispute = paramDispute;
  }
  
  @Deprecated
  public void setDisputed(Boolean paramBoolean)
  {
    disputed = paramBoolean;
  }
  
  public void setFailureCode(String paramString)
  {
    failureCode = paramString;
  }
  
  public void setFailureMessage(String paramString)
  {
    failureMessage = paramString;
  }
  
  public void setFraudDetails(FraudDetails paramFraudDetails)
  {
    fraudDetails = paramFraudDetails;
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
  
  public void setPaid(Boolean paramBoolean)
  {
    paid = paramBoolean;
  }
  
  public void setReceiptEmail(String paramString)
  {
    receiptEmail = paramString;
  }
  
  public void setReceiptNumber(String paramString)
  {
    receiptNumber = paramString;
  }
  
  public void setRefunded(Boolean paramBoolean)
  {
    refunded = paramBoolean;
  }
  
  public void setShipping(ShippingDetails paramShippingDetails)
  {
    shipping = paramShippingDetails;
  }
  
  public void setSource(ExternalAccount paramExternalAccount)
  {
    source = paramExternalAccount;
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
  
  public Charge update(Map<String, Object> paramMap)
    throws AuthenticationException, InvalidRequestException, APIConnectionException, CardException, APIException
  {
    return update(paramMap, (RequestOptions)null);
  }
  
  public Charge update(Map<String, Object> paramMap, RequestOptions paramRequestOptions)
    throws AuthenticationException, InvalidRequestException, APIConnectionException, CardException, APIException
  {
    return (Charge)request(APIResource.RequestMethod.POST, instanceURL(Charge.class, id), paramMap, Charge.class, paramRequestOptions);
  }
  
  @Deprecated
  public Charge update(Map<String, Object> paramMap, String paramString)
    throws AuthenticationException, InvalidRequestException, APIConnectionException, CardException, APIException
  {
    return update(paramMap, RequestOptions.builder().setApiKey(paramString).build());
  }
  
  public Dispute updateDispute(Map<String, Object> paramMap)
    throws AuthenticationException, InvalidRequestException, APIConnectionException, CardException, APIException
  {
    return updateDispute(paramMap, (RequestOptions)null);
  }
  
  public Dispute updateDispute(Map<String, Object> paramMap, RequestOptions paramRequestOptions)
    throws AuthenticationException, InvalidRequestException, APIConnectionException, CardException, APIException
  {
    return (Dispute)request(APIResource.RequestMethod.POST, String.format("%s/dispute", new Object[] { instanceURL(Charge.class, id) }), paramMap, Dispute.class, paramRequestOptions);
  }
  
  @Deprecated
  public Dispute updateDispute(Map<String, Object> paramMap, String paramString)
    throws AuthenticationException, InvalidRequestException, APIConnectionException, CardException, APIException
  {
    return updateDispute(paramMap, RequestOptions.builder().setApiKey(paramString).build());
  }
}

/* Location:
 * Qualified Name:     com.stripe.model.Charge
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */