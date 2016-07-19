package com.braintreepayments.api.models;

import com.braintreepayments.api.Utils;
import com.google.gson.Gson;
import java.util.HashMap;
import java.util.Map;

public class PayPalAccountBuilder
  implements PaymentMethod.Builder<PayPalAccount>
{
  private String authorizationCode;
  private String correlationId;
  private String email;
  private String mIntegration = "custom";
  private String mSource;
  private PaymentMethodOptions options;
  
  public PayPalAccountBuilder authorizationCode(String paramString)
  {
    authorizationCode = paramString;
    return this;
  }
  
  public PayPalAccount build()
  {
    PayPalAccount localPayPalAccount = new PayPalAccount();
    localPayPalAccount.setConsentCode(authorizationCode);
    localPayPalAccount.setCorrelationId(correlationId);
    localPayPalAccount.setOptions(options);
    localPayPalAccount.setSource(mSource);
    return localPayPalAccount;
  }
  
  public PayPalAccountBuilder correlationId(String paramString)
  {
    correlationId = paramString;
    return this;
  }
  
  public PayPalAccountBuilder email(String paramString)
  {
    email = paramString;
    return this;
  }
  
  public PayPalAccount fromJson(String paramString)
  {
    paramString = PayPalAccount.fromJson(paramString);
    paramString.setEmail(email);
    return paramString;
  }
  
  public String getApiPath()
  {
    return "paypal_accounts";
  }
  
  public String getApiResource()
  {
    return "paypalAccounts";
  }
  
  public PayPalAccountBuilder integration(String paramString)
  {
    mIntegration = paramString;
    return this;
  }
  
  public PayPalAccountBuilder source(String paramString)
  {
    mSource = paramString;
    return this;
  }
  
  public Map<String, Object> toJson()
  {
    HashMap localHashMap = new HashMap();
    localHashMap.put("paypalAccount", build());
    localHashMap.put("_meta", new Metadata(mIntegration, mSource));
    return localHashMap;
  }
  
  public String toJsonString()
  {
    return Utils.getGson().toJson(toJson());
  }
  
  public PayPalAccountBuilder validate(boolean paramBoolean)
  {
    options = new PaymentMethodOptions();
    options.setValidate(paramBoolean);
    return this;
  }
}

/* Location:
 * Qualified Name:     com.braintreepayments.api.models.PayPalAccountBuilder
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */