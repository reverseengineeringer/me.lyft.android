package me.lyft.android.application;

import me.lyft.android.domain.User;
import rx.Observable;

public abstract interface IUserProvider
{
  public abstract User getUser();
  
  public abstract Observable<User> observeUserUpdates();
  
  public abstract void updateUser(User paramUser);
}

/* Location:
 * Qualified Name:     me.lyft.android.application.IUserProvider
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */