package me.lyft.android.application.polling;

import me.lyft.android.application.IUserProvider;
import me.lyft.android.domain.User;
import me.lyft.android.infrastructure.foreground.IAppForegroundDetector;
import rx.Observable;
import rx.Subscription;
import rx.functions.Action1;
import rx.subscriptions.CompositeSubscription;

public class PollingAppProcess
  implements IPollingAppProcess
{
  private IAppForegroundDetector appForegroundDetector;
  private Action1<Boolean> onAppForegroundChange = new Action1()
  {
    public void call(Boolean paramAnonymousBoolean)
    {
      User localUser = userProvider.getUser();
      PollingAppProcess.this.invalidatePolling(localUser, paramAnonymousBoolean.booleanValue());
    }
  };
  private Action1<User> onUserUpdated = new Action1()
  {
    public void call(User paramAnonymousUser)
    {
      boolean bool = appForegroundDetector.isForegrounded();
      PollingAppProcess.this.invalidatePolling(paramAnonymousUser, bool);
    }
  };
  private IPollingService pollingService;
  private CompositeSubscription subscriptions = new CompositeSubscription();
  private IUserProvider userProvider;
  
  public PollingAppProcess(IPollingService paramIPollingService, IAppForegroundDetector paramIAppForegroundDetector, IUserProvider paramIUserProvider)
  {
    pollingService = paramIPollingService;
    appForegroundDetector = paramIAppForegroundDetector;
    userProvider = paramIUserProvider;
  }
  
  private void invalidatePolling(User paramUser, boolean paramBoolean)
  {
    if (paramUser.isDispatchable())
    {
      pollingService.start();
      return;
    }
    if ((!paramUser.isUnauthorized()) && (paramBoolean))
    {
      pollingService.start();
      return;
    }
    pollingService.stop();
  }
  
  public void onServiceCreated()
  {
    Subscription localSubscription = userProvider.observeUserUpdates().subscribe(onUserUpdated);
    subscriptions.add(localSubscription);
    localSubscription = appForegroundDetector.observeAppForegrounded().subscribe(onAppForegroundChange);
    subscriptions.add(localSubscription);
  }
  
  public void onServiceDestroyed()
  {
    pollingService.stop();
    subscriptions.unsubscribe();
  }
  
  public void setErrorHandler(Action1<Throwable> paramAction1)
  {
    pollingService.setErrorHandler(paramAction1);
  }
}

/* Location:
 * Qualified Name:     me.lyft.android.application.polling.PollingAppProcess
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */