package me.lyft.android.application.polling;

import me.lyft.android.application.IUserProvider;
import me.lyft.android.domain.User;
import rx.Observable;
import rx.Subscription;
import rx.functions.Action1;

public class BackgroundLocationAppProcess
  implements IBackgroundLocationAppProcess
{
  private IBackgroundLocationTracker backgroundLocationTracker;
  private Action1<User> onUserUpdated = new Action1()
  {
    public void call(User paramAnonymousUser)
    {
      BackgroundLocationAppProcess.this.invalidateLocationTracker(paramAnonymousUser);
    }
  };
  private IUserProvider userProvider;
  private Subscription userUpdateSubscription;
  
  public BackgroundLocationAppProcess(IBackgroundLocationTracker paramIBackgroundLocationTracker, IUserProvider paramIUserProvider)
  {
    backgroundLocationTracker = paramIBackgroundLocationTracker;
    userProvider = paramIUserProvider;
  }
  
  private void invalidateLocationTracker(User paramUser)
  {
    if (paramUser.isCoarseLocationTrackingEnabled())
    {
      backgroundLocationTracker.start();
      return;
    }
    backgroundLocationTracker.stop();
  }
  
  public void onServiceCreated()
  {
    userUpdateSubscription = userProvider.observeUserUpdates().subscribe(onUserUpdated);
  }
  
  public void onServiceDestroyed()
  {
    backgroundLocationTracker.stop();
    userUpdateSubscription.unsubscribe();
  }
  
  public void setErrorHandler(Action1<Throwable> paramAction1) {}
}

/* Location:
 * Qualified Name:     me.lyft.android.application.polling.BackgroundLocationAppProcess
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */