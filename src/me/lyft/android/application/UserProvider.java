package me.lyft.android.application;

import me.lyft.android.domain.User;
import me.lyft.android.rx.ReactiveProperty;
import rx.Observable;

public class UserProvider
  implements IUserProvider
{
  private final ReactiveProperty<User> userSubject = ReactiveProperty.create(User.empty());
  
  public User getUser()
  {
    return (User)userSubject.get();
  }
  
  public Observable<User> observeUserUpdates()
  {
    return userSubject.asObservable();
  }
  
  public void updateUser(User paramUser)
  {
    userSubject.onNext(paramUser);
  }
}

/* Location:
 * Qualified Name:     me.lyft.android.application.UserProvider
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */