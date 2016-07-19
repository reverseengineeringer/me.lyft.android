package me.lyft.android.infrastructure.facebook;

public abstract interface IFacebookTokenService
{
  public abstract String getFacebookToken();
  
  public abstract void logout();
}

/* Location:
 * Qualified Name:     me.lyft.android.infrastructure.facebook.IFacebookTokenService
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */