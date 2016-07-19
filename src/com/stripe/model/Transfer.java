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
import java.util.Map;

public class Transfer
  extends APIResource
  implements MetadataStore<Transfer>
{
  BankAccount account;
  Integer amount;
  String balanceTransaction;
  String currency;
  Long date;
  String description;
  String id;
  Boolean livemode;
  Map<String, String> metadata;
  List<String> otherTransfers;
  String recipient;
  TransferReversalCollection reversals;
  @Deprecated
  String statementDescription;
  String statementDescriptor;
  String status;
  Summary summary;
  
  public static TransferCollection all(Map<String, Object> paramMap)
    throws AuthenticationException, InvalidRequestException, APIConnectionException, CardException, APIException
  {
    return all(paramMap, (RequestOptions)null);
  }
  
  public static TransferCollection all(Map<String, Object> paramMap, RequestOptions paramRequestOptions)
    throws AuthenticationException, InvalidRequestException, APIConnectionException, CardException, APIException
  {
    return (TransferCollection)request(APIResource.RequestMethod.GET, classURL(Transfer.class), paramMap, TransferCollection.class, paramRequestOptions);
  }
  
  @Deprecated
  public static TransferCollection all(Map<String, Object> paramMap, String paramString)
    throws AuthenticationException, InvalidRequestException, APIConnectionException, CardException, APIException
  {
    return all(paramMap, RequestOptions.builder().setApiKey(paramString).build());
  }
  
  public static Transfer create(Map<String, Object> paramMap)
    throws AuthenticationException, InvalidRequestException, APIConnectionException, CardException, APIException
  {
    return create(paramMap, (RequestOptions)null);
  }
  
  public static Transfer create(Map<String, Object> paramMap, RequestOptions paramRequestOptions)
    throws AuthenticationException, InvalidRequestException, APIConnectionException, CardException, APIException
  {
    return (Transfer)request(APIResource.RequestMethod.POST, classURL(Transfer.class), paramMap, Transfer.class, paramRequestOptions);
  }
  
  @Deprecated
  public static Transfer create(Map<String, Object> paramMap, String paramString)
    throws AuthenticationException, InvalidRequestException, APIConnectionException, CardException, APIException
  {
    return create(paramMap, RequestOptions.builder().setApiKey(paramString).build());
  }
  
  public static Transfer retrieve(String paramString)
    throws AuthenticationException, InvalidRequestException, APIConnectionException, CardException, APIException
  {
    return retrieve(paramString, (RequestOptions)null);
  }
  
  public static Transfer retrieve(String paramString, RequestOptions paramRequestOptions)
    throws AuthenticationException, InvalidRequestException, APIConnectionException, CardException, APIException
  {
    return (Transfer)request(APIResource.RequestMethod.GET, instanceURL(Transfer.class, paramString), null, Transfer.class, paramRequestOptions);
  }
  
  @Deprecated
  public static Transfer retrieve(String paramString1, String paramString2)
    throws AuthenticationException, InvalidRequestException, APIConnectionException, CardException, APIException
  {
    return retrieve(paramString1, RequestOptions.builder().setApiKey(paramString2).build());
  }
  
  @Deprecated
  public Transfer cancel()
    throws AuthenticationException, InvalidRequestException, APIConnectionException, CardException, APIException
  {
    return cancel((RequestOptions)null);
  }
  
  public Transfer cancel(RequestOptions paramRequestOptions)
    throws AuthenticationException, InvalidRequestException, APIConnectionException, CardException, APIException
  {
    return (Transfer)request(APIResource.RequestMethod.POST, instanceURL(Transfer.class, id) + "/cancel", null, Transfer.class, paramRequestOptions);
  }
  
  @Deprecated
  public Transfer cancel(String paramString)
    throws AuthenticationException, InvalidRequestException, APIConnectionException, CardException, APIException
  {
    return cancel(RequestOptions.builder().setApiKey(paramString).build());
  }
  
  public BankAccount getAccount()
  {
    return account;
  }
  
  public Integer getAmount()
  {
    return amount;
  }
  
  public String getBalanceTransaction()
  {
    return balanceTransaction;
  }
  
  public String getCurrency()
  {
    return currency;
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
  
  public Boolean getLivemode()
  {
    return livemode;
  }
  
  public Map<String, String> getMetadata()
  {
    return metadata;
  }
  
  public List<String> getOtherTransfers()
  {
    return otherTransfers;
  }
  
  public String getRecipient()
  {
    return recipient;
  }
  
  public TransferReversalCollection getReversals()
  {
    if (reversals.getURL() == null) {
      reversals.setURL(String.format("/v1/transfers/%s/reversals", new Object[] { getId() }));
    }
    return reversals;
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
  
  public Summary getSummary()
  {
    return summary;
  }
  
  public void setAccount(BankAccount paramBankAccount)
  {
    account = paramBankAccount;
  }
  
  public void setAmount(Integer paramInteger)
  {
    amount = paramInteger;
  }
  
  public void setBalanceTransaction(String paramString)
  {
    balanceTransaction = paramString;
  }
  
  public void setCurrency(String paramString)
  {
    currency = paramString;
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
  
  public void setLivemode(Boolean paramBoolean)
  {
    livemode = paramBoolean;
  }
  
  public void setMetadata(Map<String, String> paramMap)
  {
    metadata = paramMap;
  }
  
  public void setOtherTransfers(List<String> paramList)
  {
    otherTransfers = paramList;
  }
  
  public void setRecipient(String paramString)
  {
    recipient = paramString;
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
  
  public void setStatus(String paramString)
  {
    status = paramString;
  }
  
  public void setSummary(Summary paramSummary)
  {
    summary = paramSummary;
  }
  
  public TransferTransactionCollection transactions(Map<String, Object> paramMap)
    throws AuthenticationException, InvalidRequestException, APIConnectionException, CardException, APIException
  {
    return transactions(paramMap, (RequestOptions)null);
  }
  
  public TransferTransactionCollection transactions(Map<String, Object> paramMap, RequestOptions paramRequestOptions)
    throws AuthenticationException, InvalidRequestException, APIConnectionException, CardException, APIException
  {
    return (TransferTransactionCollection)request(APIResource.RequestMethod.GET, String.format("%s/transactions", new Object[] { instanceURL(Transfer.class, getId()) }), paramMap, TransferTransactionCollection.class, paramRequestOptions);
  }
  
  @Deprecated
  public TransferTransactionCollection transactions(Map<String, Object> paramMap, String paramString)
    throws AuthenticationException, InvalidRequestException, APIConnectionException, CardException, APIException
  {
    return transactions(paramMap, RequestOptions.builder().setApiKey(paramString).build());
  }
  
  public Transfer update(Map<String, Object> paramMap)
    throws AuthenticationException, InvalidRequestException, APIConnectionException, CardException, APIException
  {
    return update(paramMap, (RequestOptions)null);
  }
  
  public Transfer update(Map<String, Object> paramMap, RequestOptions paramRequestOptions)
    throws AuthenticationException, InvalidRequestException, APIConnectionException, CardException, APIException
  {
    return (Transfer)request(APIResource.RequestMethod.POST, instanceURL(Transfer.class, id), paramMap, Transfer.class, paramRequestOptions);
  }
  
  @Deprecated
  public Transfer update(Map<String, Object> paramMap, String paramString)
    throws AuthenticationException, InvalidRequestException, APIConnectionException, CardException, APIException
  {
    return update(paramMap, RequestOptions.builder().setApiKey(paramString).build());
  }
}

/* Location:
 * Qualified Name:     com.stripe.model.Transfer
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */