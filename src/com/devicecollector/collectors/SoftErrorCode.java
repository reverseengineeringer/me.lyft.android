package com.devicecollector.collectors;

public enum SoftErrorCode
{
  MERCHANT_CANCELLED("merchant_cancelled"),  MERCHANT_SKIPPED("skipped"),  PERMISSION_DENIED("permission_denied"),  SERVICE_UNAVAILABLE("not_available"),  TIMEOUT("timeout"),  UNEXPECTED("unexpected");
  
  private String postValue;
  
  private SoftErrorCode(String paramString)
  {
    postValue = paramString;
  }
  
  public String postValue()
  {
    return postValue;
  }
}

/* Location:
 * Qualified Name:     com.devicecollector.collectors.SoftErrorCode
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */