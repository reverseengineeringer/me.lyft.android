package com.braintreepayments.api;

import android.text.TextUtils;
import android.util.Base64;
import com.braintreepayments.api.annotations.Beta;
import com.google.gson.Gson;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

class ClientToken
{
  private Analytics analytics;
  private String authorizationFingerprint;
  private String[] challenges;
  private String clientApiUrl;
  private String merchantAccountId;
  private String merchantId;
  private PayPal paypal;
  private boolean paypalEnabled;
  private boolean threeDSecureEnabled;
  private String venmo;
  
  protected static ClientToken getClientToken(String paramString)
  {
    String str = paramString;
    if (Pattern.compile("([A-Za-z0-9+/]{4})*([A-Za-z0-9+/]{4}|[A-Za-z0-9+/]{3}=|[A-Za-z0-9+/]{2}==)").matcher(paramString).matches()) {
      str = new String(Base64.decode(paramString, 0));
    }
    return (ClientToken)Utils.getGson().fromJson(str, ClientToken.class);
  }
  
  private boolean isChallengePresent(String paramString)
  {
    if ((challenges != null) && (challenges.length > 0))
    {
      String[] arrayOfString = challenges;
      int j = arrayOfString.length;
      int i = 0;
      while (i < j)
      {
        if (arrayOfString[i].equals(paramString)) {
          return true;
        }
        i += 1;
      }
    }
    return false;
  }
  
  protected Analytics getAnalytics()
  {
    return analytics;
  }
  
  protected String getAuthorizationFingerprint()
  {
    return authorizationFingerprint;
  }
  
  protected String getClientApiUrl()
  {
    return clientApiUrl;
  }
  
  protected String getMerchantAccountId()
  {
    return merchantAccountId;
  }
  
  protected String getMerchantId()
  {
    return merchantId;
  }
  
  protected PayPal getPayPal()
  {
    return paypal;
  }
  
  protected String getVenmoState()
  {
    if (venmo == null) {
      return "off";
    }
    return venmo;
  }
  
  protected boolean isAnalyticsEnabled()
  {
    return (analytics != null) && (!TextUtils.isEmpty(analytics.getUrl()));
  }
  
  protected boolean isCvvChallengePresent()
  {
    return isChallengePresent("cvv");
  }
  
  protected boolean isPayPalEnabled()
  {
    return (paypalEnabled) && (paypal != null);
  }
  
  protected boolean isPostalCodeChallengePresent()
  {
    return isChallengePresent("postal_code");
  }
  
  @Beta
  protected boolean isThreeDSecureEnabled()
  {
    return threeDSecureEnabled;
  }
  
  class Analytics
  {
    private String url;
    
    Analytics() {}
    
    protected String getUrl()
    {
      return url;
    }
  }
  
  class PayPal
  {
    private boolean allowHttp;
    private String clientId;
    private String directBaseUrl;
    private String displayName;
    private String environment;
    private String privacyUrl;
    private boolean touchDisabled;
    private String userAgreementUrl;
    
    PayPal() {}
    
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
}

/* Location:
 * Qualified Name:     com.braintreepayments.api.ClientToken
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */