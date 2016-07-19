package com.braintreepayments.api.internal;

public class HttpResponse
{
  private String mData;
  private String mResponseBody;
  private int mResponseCode;
  private String mUrl;
  
  public HttpResponse(int paramInt, String paramString)
  {
    mResponseCode = paramInt;
    mResponseBody = paramString;
  }
  
  protected String getData()
  {
    return mData;
  }
  
  public String getResponseBody()
  {
    return mResponseBody;
  }
  
  public int getResponseCode()
  {
    return mResponseCode;
  }
  
  protected String getUrl()
  {
    return mUrl;
  }
  
  protected void setData(String paramString)
  {
    mData = paramString;
  }
  
  protected void setUrl(String paramString)
  {
    mUrl = paramString;
  }
}

/* Location:
 * Qualified Name:     com.braintreepayments.api.internal.HttpResponse
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */