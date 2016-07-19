package com.facebook.login;

abstract interface LoginClient$BackgroundProcessingListener
{
  public abstract void onBackgroundProcessingStarted();
  
  public abstract void onBackgroundProcessingStopped();
}

/* Location:
 * Qualified Name:     com.facebook.login.LoginClient.BackgroundProcessingListener
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */