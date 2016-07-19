package com.braintreepayments.api;

class ClientToken$PayPal
{
  private boolean allowHttp;
  private String clientId;
  private String directBaseUrl;
  private String displayName;
  private String environment;
  private String privacyUrl;
  private boolean touchDisabled;
  private String userAgreementUrl;
  
  ClientToken$PayPal(ClientToken paramClientToken) {}
  
  protected boolean getAllowHttp()
  {
    return allowHttp;
  }
  
  protected String getClientId()
  {
    return clientId;
  }
  
  protected String getDirectBaseUrl()
  {
    return directBaseUrl + "/v1/";
  }
  
  protected String getDisplayName()
  {
    return displayName;
  }
  
  protected String getEnvironment()
  {
    return environment;
  }
  
  protected String getPrivacyUrl()
  {
    return privacyUrl;
  }
  
  protected boolean getTouchDisabled()
  {
    return touchDisabled;
  }
  
  protected String getUserAgreementUrl()
  {
    return userAgreementUrl;
  }
}

/* Location:
 * Qualified Name:     com.braintreepayments.api.ClientToken.PayPal
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */