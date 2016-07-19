package com.facebook;

public class FacebookSdkNotInitializedException
  extends FacebookException
{
  static final long serialVersionUID = 1L;
  
  public FacebookSdkNotInitializedException() {}
  
  public FacebookSdkNotInitializedException(String paramString)
  {
    super(paramString);
  }
  
  public FacebookSdkNotInitializedException(String paramString, Throwable paramThrowable)
  {
    super(paramString, paramThrowable);
  }
  
  public FacebookSdkNotInitializedException(Throwable paramThrowable)
  {
    super(paramThrowable);
  }
}

/* Location:
 * Qualified Name:     com.facebook.FacebookSdkNotInitializedException
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */