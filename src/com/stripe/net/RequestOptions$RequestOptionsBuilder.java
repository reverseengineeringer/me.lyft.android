package com.stripe.net;

import com.stripe.Stripe;

public final class RequestOptions$RequestOptionsBuilder
{
  private String apiKey = Stripe.apiKey;
  private String idempotencyKey;
  private String stripeAccount;
  private String stripeVersion = Stripe.apiVersion;
  
  public RequestOptions build()
  {
    return new RequestOptions(RequestOptions.access$000(apiKey), RequestOptions.access$100(stripeVersion), RequestOptions.access$200(idempotencyKey), RequestOptions.access$300(stripeAccount), null);
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
    apiKey = RequestOptions.access$000(paramString);
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
    stripeVersion = RequestOptions.access$100(paramString);
    return this;
  }
}

/* Location:
 * Qualified Name:     com.stripe.net.RequestOptions.RequestOptionsBuilder
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */