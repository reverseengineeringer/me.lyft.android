package com.stripe.model;

import com.stripe.Stripe;
import com.stripe.exception.APIConnectionException;
import com.stripe.exception.APIException;
import com.stripe.exception.AuthenticationException;
import com.stripe.exception.CardException;
import com.stripe.exception.InvalidRequestException;
import com.stripe.net.APIResource.RequestMethod;
import com.stripe.net.RequestOptions;
import java.util.Map;

public class BitcoinReceiver
  extends ExternalAccount
{
  Boolean active;
  Integer amount;
  Integer amountReceived;
  Integer bitcoinAmount;
  Integer bitcoinAmountReceived;
  String bitcoinUri;
  Long created;
  String currency;
  String description;
  String email;
  Boolean filled;
  String inboundAddress;
  Map<String, String> metadata;
  String payment;
  String refundAddress;
  Boolean rejectTransactions;
  String status;
  BitcoinTransactionCollection transactions;
  
  public static BitcoinReceiverCollection all(Map<String, Object> paramMap)
    throws AuthenticationException, InvalidRequestException, APIConnectionException, CardException, APIException
  {
    return all(paramMap, (RequestOptions)null);
  }
  
  public static BitcoinReceiverCollection all(Map<String, Object> paramMap, RequestOptions paramRequestOptions)
    throws AuthenticationException, InvalidRequestException, APIConnectionException, CardException, APIException
  {
    return (BitcoinReceiverCollection)request(APIResource.RequestMethod.GET, String.format("%s/%s", new Object[] { Stripe.getApiBase(), "v1/bitcoin/receivers" }), paramMap, BitcoinReceiverCollection.class, paramRequestOptions);
  }
  
  public static BitcoinReceiver create(Map<String, Object> paramMap)
    throws AuthenticationException, InvalidRequestException, APIConnectionException, CardException, APIException
  {
    return create(paramMap, (RequestOptions)null);
  }
  
  public static BitcoinReceiver create(Map<String, Object> paramMap, RequestOptions paramRequestOptions)
    throws AuthenticationException, InvalidRequestException, APIConnectionException, CardException, APIException
  {
    return (BitcoinReceiver)request(APIResource.RequestMethod.POST, String.format("%s/%s", new Object[] { Stripe.getApiBase(), "v1/bitcoin/receivers" }), paramMap, BitcoinReceiver.class, paramRequestOptions);
  }
  
  public static BitcoinReceiver retrieve(String paramString)
    throws AuthenticationException, InvalidRequestException, APIConnectionException, CardException, APIException
  {
    return retrieve(paramString, (RequestOptions)null);
  }
  
  public static BitcoinReceiver retrieve(String paramString, RequestOptions paramRequestOptions)
    throws AuthenticationException, InvalidRequestException, APIConnectionException, CardException, APIException
  {
    return (BitcoinReceiver)request(APIResource.RequestMethod.GET, String.format("%s/%s/%s", new Object[] { Stripe.getApiBase(), "v1/bitcoin/receivers", paramString }), null, BitcoinReceiver.class, paramRequestOptions);
  }
  
  public DeletedBitcoinReceiver delete()
    throws AuthenticationException, InvalidRequestException, APIConnectionException, CardException, APIException
  {
    return delete((RequestOptions)null);
  }
  
  public DeletedBitcoinReceiver delete(RequestOptions paramRequestOptions)
    throws AuthenticationException, InvalidRequestException, APIConnectionException, CardException, APIException
  {
    return (DeletedBitcoinReceiver)request(APIResource.RequestMethod.DELETE, getInstanceURL(), null, DeletedBitcoinReceiver.class, paramRequestOptions);
  }
  
  public Boolean getActive()
  {
    return active;
  }
  
  public Integer getAmount()
  {
    return amount;
  }
  
  public Integer getAmountReceived()
  {
    return amountReceived;
  }
  
  public Integer getBitcoinAmount()
  {
    return bitcoinAmount;
  }
  
  public Integer getBitcoinAmountReceived()
  {
    return bitcoinAmountReceived;
  }
  
  public String getBitcoinUri()
  {
    return bitcoinUri;
  }
  
  public Long getCreated()
  {
    return created;
  }
  
  public String getCurrency()
  {
    return currency;
  }
  
  public String getDescription()
  {
    return description;
  }
  
  public String getEmail()
  {
    return email;
  }
  
  public Boolean getFilled()
  {
    return filled;
  }
  
  public String getInboundAddress()
  {
    return inboundAddress;
  }
  
  public String getInstanceURL()
  {
    String str2 = super.getInstanceURL();
    String str1 = str2;
    if (str2 == null) {
      str1 = String.format("%s/%s/%s", new Object[] { Stripe.getApiBase(), "v1/bitcoin/receivers", getId() });
    }
    return str1;
  }
  
  public Map<String, String> getMetadata()
  {
    return metadata;
  }
  
  public String getPayment()
  {
    return payment;
  }
  
  public String getRefundAddress()
  {
    return refundAddress;
  }
  
  public Boolean getRejectTransactions()
  {
    return rejectTransactions;
  }
  
  public String getStatus()
  {
    return status;
  }
  
  public BitcoinTransactionCollection getTransactions()
  {
    return transactions;
  }
  
  public void setActive(Boolean paramBoolean)
  {
    active = paramBoolean;
  }
  
  public void setAmount(Integer paramInteger)
  {
    amount = paramInteger;
  }
  
  public void setAmountReceived(Integer paramInteger)
  {
    amountReceived = paramInteger;
  }
  
  public void setBitcoinAmount(Integer paramInteger)
  {
    bitcoinAmount = paramInteger;
  }
  
  public void setBitcoinAmountReceived(Integer paramInteger)
  {
    bitcoinAmountReceived = paramInteger;
  }
  
  public void setBitcoinUri(String paramString)
  {
    bitcoinUri = paramString;
  }
  
  public void setCreated(Long paramLong)
  {
    created = paramLong;
  }
  
  public void setCurrency(String paramString)
  {
    currency = paramString;
  }
  
  public void setDescription(String paramString)
  {
    description = paramString;
  }
  
  public void setEmail(String paramString)
  {
    email = paramString;
  }
  
  public void setFilled(Boolean paramBoolean)
  {
    filled = paramBoolean;
  }
  
  public void setInboundAddress(String paramString)
  {
    inboundAddress = paramString;
  }
  
  public void setMetadata(Map<String, String> paramMap)
  {
    metadata = paramMap;
  }
  
  public void setPayment(String paramString)
  {
    payment = paramString;
  }
  
  public void setRefundAddress(String paramString)
  {
    refundAddress = paramString;
  }
  
  public void setRejectTransactions(Boolean paramBoolean)
  {
    rejectTransactions = paramBoolean;
  }
  
  public void setStatus(String paramString)
  {
    status = paramString;
  }
  
  public void setTransactions(BitcoinTransactionCollection paramBitcoinTransactionCollection)
  {
    transactions = paramBitcoinTransactionCollection;
  }
  
  public BitcoinReceiver update(Map<String, Object> paramMap)
    throws AuthenticationException, InvalidRequestException, APIConnectionException, CardException, APIException
  {
    return update(paramMap, (RequestOptions)null);
  }
  
  public BitcoinReceiver update(Map<String, Object> paramMap, RequestOptions paramRequestOptions)
    throws AuthenticationException, InvalidRequestException, APIConnectionException, CardException, APIException
  {
    return (BitcoinReceiver)request(APIResource.RequestMethod.POST, getInstanceURL(), paramMap, BitcoinReceiver.class, paramRequestOptions);
  }
}

/* Location:
 * Qualified Name:     com.stripe.model.BitcoinReceiver
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */