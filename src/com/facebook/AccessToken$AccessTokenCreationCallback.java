package com.facebook;

public abstract interface AccessToken$AccessTokenCreationCallback
{
  public abstract void onError(FacebookException paramFacebookException);
  
  public abstract void onSuccess(AccessToken paramAccessToken);
}

/* Location:
 * Qualified Name:     com.facebook.AccessToken.AccessTokenCreationCallback
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */