package com.facebook;

public abstract interface AccessToken$AccessTokenRefreshCallback
{
  public abstract void OnTokenRefreshFailed(FacebookException paramFacebookException);
  
  public abstract void OnTokenRefreshed(AccessToken paramAccessToken);
}

/* Location:
 * Qualified Name:     com.facebook.AccessToken.AccessTokenRefreshCallback
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */