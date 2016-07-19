package me.lyft.android.application;

public abstract interface ILogoutService
{
  public abstract void logout(String paramString);
  
  public abstract void resetCachedState();
  
  public abstract void resetSignUp();
}

/* Location:
 * Qualified Name:     me.lyft.android.application.ILogoutService
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */