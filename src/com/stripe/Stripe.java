package com.stripe;

public abstract class Stripe
{
  public static final String LIVE_API_BASE = "https://api.stripe.com";
  public static final String UPLOAD_API_BASE = "https://uploads.stripe.com";
  public static final String VERSION = "1.31.0";
  private static volatile String apiBase = "https://api.stripe.com";
  public static volatile String apiKey;
  public static volatile String apiVersion;
  
  public static String getApiBase()
  {
    return apiBase;
  }
  
  public static void overrideApiBase(String paramString)
  {
    apiBase = paramString;
  }
}

/* Location:
 * Qualified Name:     com.stripe.Stripe
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */