package com.facebook;

public abstract interface FacebookCallback<RESULT>
{
  public abstract void onCancel();
  
  public abstract void onError(FacebookException paramFacebookException);
  
  public abstract void onSuccess(RESULT paramRESULT);
}

/* Location:
 * Qualified Name:     com.facebook.FacebookCallback
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */