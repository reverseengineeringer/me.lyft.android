package com.stripe.net;

import com.stripe.Stripe;

public class RequestOptions
{
  private final String apiKey;
  private final String idempotencyKey;
  private final String stripeAccount;
  private final String stripeVersion;
  
  private RequestOptions(String paramString1, String paramString2, String paramString3, String paramString4)
  {
    apiKey = paramString1;
    stripeVersion = paramString2;
    idempotencyKey = paramString3;
    stripeAccount = paramString4;
  }
  
  public static RequestOptionsBuilder builder()
  {
    return new RequestOptionsBuilder();
  }
  
  public static RequestOptions getDefault()
  {
    return new RequestOptions(Stripe.apiKey, Stripe.apiVersion, null, null);
  }
  
  private static String normalizeApiKey(String paramString)
  {
    if (paramString == null) {
      paramString = null;
    }
    String str;
    do
    {
      return paramString;
      str = paramString.trim();
      paramString = str;
    } while (!str.isEmpty());
    throw new InvalidRequestOptionsException("Empty API key specified!");
  }
  
  private static String normalizeIdempotencyKey(String paramString)
  {
    if (paramString == null) {
      paramString = null;
    }
    String str;
    do
    {
      return paramString;
      str = paramString.trim();
      if (str.isEmpty()) {
        throw new InvalidRequestOptionsException("Empty Idempotency Key Specified!");
      }
      paramString = str;
    } while (str.length() <= 255);
    throw new InvalidRequestOptionsException(String.format("Idempotency Key length was %d, which is larger than the 255 character maximum!", new Object[] { Integer.valueOf(str.length()) }));
  }
  
  private static String normalizeStripeAccount(String paramString)
  {
    if (paramString == null) {
      paramString = null;
    }
    String str;
    do
    {
      return paramString;
      str = paramString.trim();
      paramString = str;
    } while (!str.isEmpty());
    throw new InvalidRequestOptionsException("Empty stripe account specified!");
  }
  
  private static String normalizeStripeVersion(String paramString)
  {
    if (paramString == null) {
      paramString = null;
    }
    String str;
    do
    {
      return paramString;
      str = paramString.trim();
      paramString = str;
    } while (!str.isEmpty());
    throw new InvalidRequestOptionsException("Empty Stripe version specified!");
  }
  
  public boolean equals(Object paramObject)
  {
    if (this == paramObject) {}
    do
    {
      return true;
      if ((paramObject == null) || (getClass() != paramObject.getClass())) {
        return false;
      }
      paramObject = (RequestOptions)paramObject;
      if (apiKey != null)
      {
        if (apiKey.equals(apiKey)) {}
      }
      else {
        while (apiKey != null) {
          return false;
        }
      }
      if (idempotencyKey != null)
      {
        if (idempotencyKey.equals(idempotencyKey)) {}
      }
      else {
        while (idempotencyKey != null) {
          return false;
        }
      }
      if (stripeVersion == null) {
        break;
      }
    } while (stripeVersion.equals(stripeVersion));
    for (;;)
    {
      return false;
      if (stripeVersion == null) {
        break;
      }
    }
  }
  
  public String getApiKey()
  {
    return apiKey;
  }
  
  public String getIdempotencyKey()
  {
    return idempotencyKey;
  }
  
  public String getStripeAccount()
  {
    return stripeAccount;
  }
  
  public String getStripeVersion()
  {
    return stripeVersion;
  }
  
  public int hashCode()
  {
    int k = 0;
    int i;
    if (apiKey != null)
    {
      i = apiKey.hashCode();
      if (stripeVersion == null) {
        break label64;
      }
    }
    label64:
    for (int j = stripeVersion.hashCode();; j = 0)
    {
      if (idempotencyKey != null) {
        k = idempotencyKey.hashCode();
      }
      return (i * 31 + j) * 31 + k;
      i = 0;
      break;
    }
  }
  
  public RequestOptionsBuilder toBuilder()
  {
    return new RequestOptionsBuilder().setApiKey(apiKey).setStripeVersion(stripeVersion).setStripeAccount(stripeAccount);
  }
  
  public static class InvalidRequestOptionsException
    extends RuntimeException
  {
    public InvalidRequestOptionsException(String paramString)
    {
      super();
    }
  }
  
  public static final class RequestOptionsBuilder
  {
    private String apiKey = Stripe.apiKey;
    private String idempotencyKey;
    private String stripeAccount;
    private String stripeVersion = Stripe.apiVersion;
    
    public RequestOptions build()
    {
      return new RequestOptions(RequestOptions.normalizeApiKey(apiKey), RequestOptions.normalizeStripeVersion(stripeVersion), RequestOptions.normalizeIdempotencyKey(idempotencyKey), RequestOptions.normalizeStripeAccount(stripeAccount), null);
    }
    
    public RequestOptionsBuilder clearApiKey()
    {
      apiKey = null;
      return this;
    }
    
    public RequestOptionsBuilder clearIdempotencyKey()
    {
      idempotencyKey = null;
      return this;
    }
    
    public RequestOptionsBuilder clearStripeAccount()
    {
      return setStripeAccount(null);
    }
    
    public RequestOptionsBuilder clearStripeVersion()
    {
      stripeVersion = null;
      return this;
    }
    
    public String getApiKey()
    {
      return apiKey;
    }
    
    public String getIdempotencyKey()
    {
      return idempotencyKey;
    }
    
    public String getStripeAccount()
    {
      return stripeAccount;
    }
    
    public RequestOptionsBuilder setApiKey(String paramString)
    {
      apiKey = RequestOptions.normalizeApiKey(paramString);
      return this;
    }
    
    public RequestOptionsBuilder setIdempotencyKey(String paramString)
    {
      idempotencyKey = paramString;
      return this;
    }
    
    public RequestOptionsBuilder setStripeAccount(String paramString)
    {
      stripeAccount = paramString;
      return this;
    }
    
    public RequestOptionsBuilder setStripeVersion(String paramString)
    {
      stripeVersion = RequestOptions.normalizeStripeVersion(paramString);
      return this;
    }
  }
}

/* Location:
 * Qualified Name:     com.stripe.net.RequestOptions
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */