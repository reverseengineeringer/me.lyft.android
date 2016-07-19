package com.stripe.net;

import java.util.List;
import java.util.Map;

public class StripeResponse
{
  String responseBody;
  int responseCode;
  Map<String, List<String>> responseHeaders;
  
  public StripeResponse(int paramInt, String paramString)
  {
    responseCode = paramInt;
    responseBody = paramString;
    responseHeaders = null;
  }
  
  public StripeResponse(int paramInt, String paramString, Map<String, List<String>> paramMap)
  {
    responseCode = paramInt;
    responseBody = paramString;
    responseHeaders = paramMap;
  }
  
  public String getResponseBody()
  {
    return responseBody;
  }
  
  public int getResponseCode()
  {
    return responseCode;
  }
  
  public Map<String, List<String>> getResponseHeaders()
  {
    return responseHeaders;
  }
  
  public void setResponseBody(String paramString)
  {
    responseBody = paramString;
  }
  
  public void setResponseCode(int paramInt)
  {
    responseCode = paramInt;
  }
}

/* Location:
 * Qualified Name:     com.stripe.net.StripeResponse
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */