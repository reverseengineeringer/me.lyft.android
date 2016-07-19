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

public class Recipient
  extends APIResource
  implements MetadataStore<Recipient>
{
  BankAccount activeAccount;
  RecipientCardCollection cards;
  Long created;
  String defaultCard;
  Boolean deleted;
  String description;
  String email;
  String id;
  Boolean livemode;
  Map<String, String> metadata;
  String name;
  String type;
  Boolean verified;
  
  public static RecipientCollection all(Map<String, Object> paramMap)
    throws AuthenticationException, InvalidRequestException, APIConnectionException, CardException, APIException
  {
    return all(paramMap, (RequestOptions)null);
  }
  
  public static RecipientCollection all(Map<String, Object> paramMap, RequestOptions paramRequestOptions)
    throws AuthenticationException, InvalidRequestException, APIConnectionException, CardException, APIException
  {
    return (RecipientCollection)request(APIResource.RequestMethod.GET, classURL(Recipient.class), paramMap, RecipientCollection.class, paramRequestOptions);
  }
  
  @Deprecated
  public static RecipientCollection all(Map<String, Object> paramMap, String paramString)
    throws AuthenticationException, InvalidRequestException, APIConnectionException, CardException, APIException
  {
    return all(paramMap, RequestOptions.builder().setApiKey(paramString).build());
  }
  
  public static Recipient create(Map<String, Object> paramMap)
    throws AuthenticationException, InvalidRequestException, APIConnectionException, CardException, APIException
  {
    return create(paramMap, (RequestOptions)null);
  }
  
  public static Recipient create(Map<String, Object> paramMap, RequestOptions paramRequestOptions)
    throws AuthenticationException, InvalidRequestException, APIConnectionException, CardException, APIException
  {
    return (Recipient)request(APIResource.RequestMethod.POST, classURL(Recipient.class), paramMap, Recipient.class, paramRequestOptions);
  }
  
  @Deprecated
  public static Recipient create(Map<String, Object> paramMap, String paramString)
    throws AuthenticationException, InvalidRequestException, APIConnectionException, CardException, APIException
  {
    return create(paramMap, RequestOptions.builder().setApiKey(paramString).build());
  }
  
  public static Recipient retrieve(String paramString)
    throws AuthenticationException, InvalidRequestException, APIConnectionException, CardException, APIException
  {
    return retrieve(paramString, (RequestOptions)null);
  }
  
  public static Recipient retrieve(String paramString, RequestOptions paramRequestOptions)
    throws AuthenticationException, InvalidRequestException, APIConnectionException, CardException, APIException
  {
    return (Recipient)request(APIResource.RequestMethod.GET, instanceURL(Recipient.class, paramString), null, Recipient.class, paramRequestOptions);
  }
  
  @Deprecated
  public static Recipient retrieve(String paramString1, String paramString2)
    throws AuthenticationException, InvalidRequestException, APIConnectionException, CardException, APIException
  {
    return retrieve(paramString1, RequestOptions.builder().setApiKey(paramString2).build());
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
    return (Card)request(APIResource.RequestMethod.POST, String.format("%s/cards", new Object[] { instanceURL(Recipient.class, id) }), paramMap, Card.class, paramRequestOptions);
  }
  
  @Deprecated
  public Card createCard(Map<String, Object> paramMap, String paramString)
    throws AuthenticationException, InvalidRequestException, APIConnectionException, CardException, APIException
  {
    return createCard(paramMap, RequestOptions.builder().setApiKey(paramString).build());
  }
  
  public DeletedRecipient delete()
    throws AuthenticationException, InvalidRequestException, APIConnectionException, CardException, APIException
  {
    return delete((RequestOptions)null);
  }
  
  public DeletedRecipient delete(RequestOptions paramRequestOptions)
    throws AuthenticationException, InvalidRequestException, APIConnectionException, CardException, APIException
  {
    return (DeletedRecipient)request(APIResource.RequestMethod.DELETE, instanceURL(Recipient.class, id), null, DeletedRecipient.class, paramRequestOptions);
  }
  
  @Deprecated
  public DeletedRecipient delete(String paramString)
    throws AuthenticationException, InvalidRequestException, APIConnectionException, CardException, APIException
  {
    return delete(RequestOptions.builder().setApiKey(paramString).build());
  }
  
  public BankAccount getActiveAccount()
  {
    return activeAccount;
  }
  
  public RecipientCardCollection getCards()
  {
    return cards;
  }
  
  public Long getCreated()
  {
    return created;
  }
  
  public String getDefaultCard()
  {
    return defaultCard;
  }
  
  public Boolean getDeleted()
  {
    return deleted;
  }
  
  public String getDescription()
  {
    return description;
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
  
  public String getName()
  {
    return name;
  }
  
  public String getType()
  {
    return type;
  }
  
  public Boolean getVerified()
  {
    return verified;
  }
  
  public void setActiveAccount(BankAccount paramBankAccount)
  {
    activeAccount = paramBankAccount;
  }
  
  public void setCreated(Long paramLong)
  {
    created = paramLong;
  }
  
  public void setDefaultCard(String paramString)
  {
    defaultCard = paramString;
  }
  
  public void setDescription(String paramString)
  {
    description = paramString;
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
  
  public void setName(String paramString)
  {
    name = paramString;
  }
  
  public void setType(String paramString)
  {
    type = paramString;
  }
  
  public void setVerified(Boolean paramBoolean)
  {
    verified = paramBoolean;
  }
  
  public Recipient update(Map<String, Object> paramMap)
    throws AuthenticationException, InvalidRequestException, APIConnectionException, CardException, APIException
  {
    return update(paramMap, (RequestOptions)null);
  }
  
  public Recipient update(Map<String, Object> paramMap, RequestOptions paramRequestOptions)
    throws AuthenticationException, InvalidRequestException, APIConnectionException, CardException, APIException
  {
    return (Recipient)request(APIResource.RequestMethod.POST, instanceURL(Recipient.class, id), paramMap, Recipient.class, paramRequestOptions);
  }
  
  @Deprecated
  public Recipient update(Map<String, Object> paramMap, String paramString)
    throws AuthenticationException, InvalidRequestException, APIConnectionException, CardException, APIException
  {
    return update(paramMap, RequestOptions.builder().setApiKey(paramString).build());
  }
}

/* Location:
 * Qualified Name:     com.stripe.model.Recipient
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */