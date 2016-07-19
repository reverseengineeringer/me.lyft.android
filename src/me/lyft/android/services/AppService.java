package me.lyft.android.services;

import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.os.IBinder;
import android.support.v4.app.NotificationCompat.Builder;
import javax.inject.Inject;
import me.lyft.android.application.IUserProvider;
import me.lyft.android.domain.User;
import me.lyft.android.errorhandling.IDefaultErrorHandler;
import me.lyft.android.infrastructure.service.AppProcessRegistry;
import me.lyft.android.logging.L;
import me.lyft.android.ui.MainActivity;
import rx.Observable;
import rx.Subscription;
import rx.android.schedulers.AndroidSchedulers;
import rx.functions.Action1;
import rx.subscriptions.CompositeSubscription;

public class AppService
  extends LyftService
{
  private static final int NOTIFY_ON_DUTY = 1;
  @Inject
  AppProcessRegistry appProcessRegistry;
  @Inject
  IDefaultErrorHandler defaultErrorHandler;
  private boolean isForeground = false;
  private Action1<User> onUserUpdated = new Action1()
  {
    public void call(User paramAnonymousUser)
    {
      if (paramAnonymousUser.isDispatchable())
      {
        AppService.this.startForegroundDriverMode();
        return;
      }
      AppService.this.stopForegroundDriverMode();
    }
  };
  private CompositeSubscription subscriptions = new CompositeSubscription();
  @Inject
  IUserProvider userProvider;
  
  public static void start(Context paramContext)
  {
    L.d("try to start", new Object[0]);
    paramContext.startService(new Intent(paramContext, AppService.class));
  }
  
  private void startForegroundDriverMode()
  {
    if (!isForeground)
    {
      isForeground = true;
      startForeground(1, new NotificationCompat.Builder(this).setSmallIcon(2130838364).setColor(getResources().getColor(2131493004)).setContentTitle(getString(2131165614)).setContentText(getString(2131165613)).setOngoing(true).setContentIntent(PendingIntent.getActivity(this, 0, new Intent(this, MainActivity.class), 0)).build());
    }
  }
  
  private void stopForegroundDriverMode()
  {
    stopForeground(true);
    isForeground = false;
  }
  
  public IBinder onBind(Intent paramIntent)
  {
    return null;
  }
  
  public void onCreate()
  {
    super.onCreate();
    L.d("onCreate", new Object[0]);
    Subscription localSubscription = userProvider.observeUserUpdates().observeOn(AndroidSchedulers.mainThread()).subscribe(onUserUpdated);
    subscriptions.add(localSubscription);
    appProcessRegistry.onServiceCreated();
    appProcessRegistry.setErrorHandler(new Action1()
    {
      public void call(Throwable paramAnonymousThrowable)
      {
        defaultErrorHandler.handle(paramAnonymousThrowable);
      }
    });
  }
  
  public void onDestroy()
  {
    super.onDestroy();
    L.d("onDestroy", new Object[0]);
    isForeground = false;
    subscriptions.unsubscribe();
    appProcessRegistry.onServiceDestroyed();
  }
  
  public void onLowMemory()
  {
    super.onLowMemory();
    L.d("onLowMemory", new Object[0]);
  }
  
  public int onStartCommand(Intent paramIntent, int paramInt1, int paramInt2)
  {
    return 1;
  }
  
  public void onTaskRemoved(Intent paramIntent)
  {
    super.onTaskRemoved(paramIntent);
    L.d("onTaskRemoved", new Object[0]);
    stopSelf();
  }
  
  public void onTrimMemory(int paramInt)
  {
    super.onTrimMemory(paramInt);
    L.d("onTrimMemory", new Object[0]);
  }
}

/* Location:
 * Qualified Name:     me.lyft.android.services.AppService
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */