package com.facebook;

public class FacebookDialogException
  extends FacebookException
{
  static final long serialVersionUID = 1L;
  private int errorCode;
  private String failingUrl;
  
  public FacebookDialogException(String paramString1, int paramInt, String paramString2)
  {
    super(paramString1);
    errorCode = paramInt;
    failingUrl = paramString2;
  }
  
  public int getErrorCode()
  {
    return errorCode;
  }
  
  public String getFailingUrl()
  {
    return failingUrl;
  }
  
  public final String toString()
  {
    return "{FacebookDialogException: " + "errorCode: " + getErrorCode() + ", message: " + getMessage() + ", url: " + getFailingUrl() + "}";
  }
}

/* Location:
 * Qualified Name:     com.facebook.FacebookDialogException
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */