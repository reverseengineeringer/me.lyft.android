package me.lyft.android.infrastructure.facebook;

import rx.Observable;

public abstract interface IFacebookLoginService
{
  public abstract Observable<FacebookLoginResult> observeLogin();
  
  public abstract void openFacebookSession();
  
  public abstract void start();
  
  public abstract void stop();
}

/* Location:
 * Qualified Name:     me.lyft.android.infrastructure.facebook.IFacebookLoginService
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */