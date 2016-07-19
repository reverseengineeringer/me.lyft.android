package com.threatmetrix.TrustDefenderMobile;

import java.io.IOException;
import java.io.InputStream;
import java.util.Map;

abstract interface TDURLConnection
{
  public abstract void abort();
  
  public abstract void addHeaders(Map<String, String> paramMap);
  
  public abstract void consumeContentAndClose();
  
  public abstract long get(String paramString);
  
  public abstract String getHost();
  
  public abstract int getHttpStatusCode();
  
  public abstract InputStream getResponseStream()
    throws IOException;
  
  public abstract THMStatusCode getStatus();
  
  public abstract String getURL();
  
  public abstract long post(String paramString, HttpParameterMap paramHttpParameterMap);
}

/* Location:
 * Qualified Name:     com.threatmetrix.TrustDefenderMobile.TDURLConnection
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */