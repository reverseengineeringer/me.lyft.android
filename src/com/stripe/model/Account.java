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

public class Account
  extends APIResource
  implements MetadataStore<Account>
{
  String businessLogo;
  String businessName;
  String businessUrl;
  Boolean chargesEnabled;
  String country;
  List<String> currenciesSupported;
  String defaultCurrency;
  Boolean detailsSubmitted;
  String displayName;
  String email;
  ExternalAccountCollection externalAccounts;
  String id;
  Keys keys;
  LegalEntity legalEntity;
  Boolean managed;
  Map<String, String> metadata;
  String statementDescriptor;
  String supportEmail;
  String supportPhone;
  String supportUrl;
  String timezone;
  Boolean transfersEnabled;
  Verification verification;
  
  public static Account create(Map<String, Object> paramMap)
    throws AuthenticationException, InvalidRequestException, APIConnectionException, CardException, APIException
  {
    return create(paramMap, (RequestOptions)null);
  }
  
  public static Account create(Map<String, Object> paramMap, RequestOptions paramRequestOptions)
    throws AuthenticationException, InvalidRequestException, APIConnectionException, CardException, APIException
  {
    return (Account)request(APIResource.RequestMethod.POST, classURL(Account.class), paramMap, Account.class, paramRequestOptions);
  }
  
  public static Account retrieve()
    throws AuthenticationException, InvalidRequestException, APIConnectionException, CardException, APIException
  {
    return retrieve((RequestOptions)null);
  }
  
  public static Account retrieve(RequestOptions paramRequestOptions)
    throws AuthenticationException, InvalidRequestException, APIConnectionException, CardException, APIException
  {
    return (Account)request(APIResource.RequestMethod.GET, singleClassURL(Account.class), null, Account.class, paramRequestOptions);
  }
  
  @Deprecated
  public static Account retrieve(String paramString)
    throws AuthenticationException, InvalidRequestException, APIConnectionException, CardException, APIException
  {
    if ((paramString == null) || (paramString.startsWith("sk_"))) {
      return retrieve(RequestOptions.builder().setApiKey(paramString).build());
    }
    return retrieve(paramString, (RequestOptions)null);
  }
  
  public static Account retrieve(String paramString, RequestOptions paramRequestOptions)
    throws AuthenticationException, InvalidRequestException, APIConnectionException, CardException, APIException
  {
    return (Account)request(APIResource.RequestMethod.GET, instanceURL(Account.class, paramString), null, Account.class, paramRequestOptions);
  }
  
  public String getBusinessLogo()
  {
    return businessLogo;
  }
  
  public String getBusinessName()
  {
    return businessName;
  }
  
  public String getBusinessUrl()
  {
    return businessUrl;
  }
  
  public Boolean getChargesEnabled()
  {
    return chargesEnabled;
  }
  
  public String getCountry()
  {
    return country;
  }
  
  public List<String> getCurrenciesSupported()
  {
    return currenciesSupported;
  }
  
  public String getDefaultCurrency()
  {
    return defaultCurrency;
  }
  
  public Boolean getDetailsSubmitted()
  {
    return detailsSubmitted;
  }
  
  public String getDisplayName()
  {
    return displayName;
  }
  
  public String getEmail()
  {
    return email;
  }
  
  public ExternalAccountCollection getExternalAccounts()
  {
    return externalAccounts;
  }
  
  public String getId()
  {
    return id;
  }
  
  public Keys getKeys()
  {
    return keys;
  }
  
  public LegalEntity getLegalEntity()
  {
    return legalEntity;
  }
  
  public Boolean getManaged()
  {
    return managed;
  }
  
  public Map<String, String> getMetadata()
  {
    return metadata;
  }
  
  public String getStatementDescriptor()
  {
    return statementDescriptor;
  }
  
  public String getSupportEmail()
  {
    return supportEmail;
  }
  
  public String getSupportPhone()
  {
    return supportPhone;
  }
  
  public String getSupportUrl()
  {
    return supportUrl;
  }
  
  public String getTimezone()
  {
    return timezone;
  }
  
  public Boolean getTransfersEnabled()
  {
    return transfersEnabled;
  }
  
  public Verification getVerification()
  {
    return verification;
  }
  
  public Account update(Map<String, Object> paramMap)
    throws AuthenticationException, InvalidRequestException, APIConnectionException, CardException, APIException
  {
    return update(paramMap, (RequestOptions)null);
  }
  
  public Account update(Map<String, Object> paramMap, RequestOptions paramRequestOptions)
    throws AuthenticationException, InvalidRequestException, APIConnectionException, CardException, APIException
  {
    return (Account)request(APIResource.RequestMethod.POST, instanceURL(Account.class, id), paramMap, Account.class, paramRequestOptions);
  }
  
  public static class Keys
    extends StripeObject
  {
    String publishable;
    String secret;
    
    public String getPublishable()
    {
      return publishable;
    }
    
    public String getSecret()
    {
      return secret;
    }
  }
  
  public static class Verification
    extends StripeObject
  {
    Boolean contacted;
    Long dueBy;
    List<String> fieldsNeeded;
    
    public Boolean getContacted()
    {
      return contacted;
    }
    
    public Long getDueBy()
    {
      return dueBy;
    }
    
    public List<String> getFieldsNeeded()
    {
      return fieldsNeeded;
    }
  }
}

/* Location:
 * Qualified Name:     com.stripe.model.Account
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */