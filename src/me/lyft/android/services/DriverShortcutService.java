package me.lyft.android.services;

import android.app.Service;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.res.Resources;
import android.os.Binder;
import android.os.IBinder;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import com.lyft.scoop.Screen;
import java.lang.ref.WeakReference;
import javax.inject.Inject;
import me.lyft.android.ILyftPreferences;
import me.lyft.android.LyftApplication;
import me.lyft.android.analytics.studies.DriverAnalytics;
import me.lyft.android.application.IUserProvider;
import me.lyft.android.application.payment.IPricingService;
import me.lyft.android.application.ride.IUserUiService;
import me.lyft.android.common.AppFlow;
import me.lyft.android.common.Unit;
import me.lyft.android.domain.User;
import me.lyft.android.domain.driver.UiState;
import me.lyft.android.domain.passenger.ridetypes.Pricing;
import me.lyft.android.rx.IRxBinder;
import me.lyft.android.rx.RxUIBinder;
import me.lyft.android.ui.MainActivity;
import me.lyft.android.ui.MainScreens.DriverRideScreen;
import me.lyft.android.ui.driver.shortcut.ChatheadView;
import me.lyft.android.ui.driver.shortcut.FloatingViewListener;
import me.lyft.android.ui.driver.shortcut.FloatingViewManager;
import me.lyft.android.ui.driver.shortcut.FloatingViewManager.Options;
import me.lyft.android.utils.MetricsUtils;
import rx.Observable;
import rx.functions.Action1;

public class DriverShortcutService
  extends Service
  implements FloatingViewListener
{
  @Inject
  AppFlow appFlow;
  private final IRxBinder binder = new RxUIBinder();
  private IBinder chatheadServiceBinder;
  private ChatheadView chatheadView;
  private FloatingViewManager floatingViewManager;
  @Inject
  ILyftPreferences lyftPreferences;
  private Action1<Unit> onPrimeTimeChanged = new Action1()
  {
    public void call(Unit paramAnonymousUnit)
    {
      paramAnonymousUnit = userProvider.getUser();
      Pricing localPricing = primeTimeService.getPricing();
      if (paramAnonymousUnit.isDispatchable())
      {
        chatheadView.showDispatchable();
        floatingViewManager.setExtraCenterY(getResources().getDimension(2131230872));
        return;
      }
      if (localPricing.hasDynamicPricing())
      {
        chatheadView.showPrimeTime(getResources().getString(2131165668, new Object[] { localPricing.getDynamicPricing() }));
        floatingViewManager.setExtraCenterY(getResources().getDimension(2131230872));
        return;
      }
      chatheadView.hidePrimetime();
      floatingViewManager.setExtraCenterY(getResources().getDimension(2131230855));
    }
  };
  private Action1<User> onUserChanged = new Action1()
  {
    public void call(User paramAnonymousUser)
    {
      DriverShortcutService.this.setFixedActionIconImage();
    }
  };
  @Inject
  IPricingService primeTimeService;
  @Inject
  IUserProvider userProvider;
  @Inject
  IUserUiService userUiService;
  
  private void bringAppToForeground(String paramString)
  {
    MainActivity.foregroundActivity(this, paramString);
  }
  
  private void destroy()
  {
    if (floatingViewManager != null)
    {
      floatingViewManager.removeAllViewToWindow();
      floatingViewManager = null;
    }
  }
  
  private void setFixedActionIconImage()
  {
    if (userProvider.getUser().isDispatchable())
    {
      floatingViewManager.updateModeToggleView(2130838195, getResources().getString(2131165734));
      return;
    }
    floatingViewManager.updateModeToggleView(2130838382, getResources().getString(2131165735));
  }
  
  public static void startService(Context paramContext)
  {
    paramContext.startService(new Intent(paramContext, DriverShortcutService.class));
  }
  
  public static void stopService(Context paramContext)
  {
    paramContext.stopService(new Intent(paramContext, DriverShortcutService.class));
  }
  
  protected LyftApplication getLyftApplication()
  {
    return (LyftApplication)getApplication();
  }
  
  public IBinder onBind(Intent paramIntent)
  {
    return chatheadServiceBinder;
  }
  
  public void onCreate()
  {
    super.onCreate();
    binder.attach();
    getLyftApplication().inject(this);
  }
  
  public void onDestroy()
  {
    destroy();
    binder.detach();
    super.onDestroy();
  }
  
  public void onFinishFloatingView()
  {
    stopSelf();
  }
  
  public void onModeToggleActionUp()
  {
    User localUser = userProvider.getUser();
    userUiService.updateUiState(new UiState(true));
    MainScreens.DriverRideScreen localDriverRideScreen = new MainScreens.DriverRideScreen();
    if (localUser.isDispatchable()) {
      localDriverRideScreen.enableGoOffline();
    }
    for (;;)
    {
      appFlow.replaceAllWith(new Screen[] { localDriverRideScreen });
      bringAppToForeground("switch_mode");
      return;
      localDriverRideScreen.enableGoOnline();
    }
  }
  
  public void onSingleTapUp(MotionEvent paramMotionEvent)
  {
    DriverAnalytics.trackDriverDefenseButtonTap();
    bringAppToForeground("driver_toggle_tap");
    stopSelf();
  }
  
  public int onStartCommand(Intent paramIntent, int paramInt1, int paramInt2)
  {
    if (floatingViewManager != null) {
      return 1;
    }
    paramIntent = MetricsUtils.fromContext(this);
    chatheadServiceBinder = new DriverShortcutServiceBinder(this);
    chatheadView = ((ChatheadView)LayoutInflater.from(this).inflate(2130903093, null, false));
    floatingViewManager = new FloatingViewManager(this, this);
    floatingViewManager.setFixedActionIconImage(2130838145);
    floatingViewManager.setModeToggleViewIcon(2130838044);
    floatingViewManager.setTrashViewIcon(2130837665);
    setFixedActionIconImage();
    FloatingViewManager.Options localOptions = new FloatingViewManager.Options();
    shape = 1.0F;
    overMargin = paramIntent.dpToPixels(getResources().getDimension(2131230863));
    floatingViewManager.addViewToWindow(chatheadView, localOptions);
    new IntentFilter("android.intent.action.SCREEN_OFF").addAction("android.intent.action.USER_PRESENT");
    binder.bindAction(userProvider.observeUserUpdates(), onUserChanged);
    binder.bindAction(Observable.combineLatest(primeTimeService.observePricingUpdates(), userProvider.observeUserUpdates(), Unit.func2()), onPrimeTimeChanged);
    return 3;
  }
  
  public void onTrashActionUp()
  {
    lyftPreferences.setDriverShortcutEnabled(false);
  }
  
  public static class DriverShortcutServiceBinder
    extends Binder
  {
    private final WeakReference<DriverShortcutService> service;
    
    DriverShortcutServiceBinder(DriverShortcutService paramDriverShortcutService)
    {
      service = new WeakReference(paramDriverShortcutService);
    }
    
    public DriverShortcutService getService()
    {
      return (DriverShortcutService)service.get();
    }
  }
}

/* Location:
 * Qualified Name:     me.lyft.android.services.DriverShortcutService
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */