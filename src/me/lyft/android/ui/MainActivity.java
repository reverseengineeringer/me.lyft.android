package me.lyft.android.ui;

import android.annotation.TargetApi;
import android.app.Activity;
import android.app.ActivityManager.TaskDescription;
import android.content.Context;
import android.content.Intent;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.widget.DrawerLayout;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import butterknife.ButterKnife;
import com.lyft.scoop.RouteChange;
import com.lyft.scoop.Scoop;
import com.lyft.scoop.Scoop.Builder;
import com.lyft.scoop.Screen;
import com.lyft.scoop.dagger.DaggerInjector;
import dagger.ObjectGraph;
import java.util.List;
import javax.inject.Inject;
import me.lyft.android.LyftApplication;
import me.lyft.android.analytics.Analytics;
import me.lyft.android.analytics.core.ActionAnalytics;
import me.lyft.android.analytics.core.SpanningAnalytics;
import me.lyft.android.analytics.core.events.ActionEvent.Action;
import me.lyft.android.analytics.studies.AppLaunchAnalytics;
import me.lyft.android.analytics.studies.PushNotificationAnalytics;
import me.lyft.android.common.ActivityController;
import me.lyft.android.common.AppFlow;
import me.lyft.android.common.DialogFlow;
import me.lyft.android.common.ScreenUtils;
import me.lyft.android.common.Strings;
import me.lyft.android.deeplinks.DeepLink;
import me.lyft.android.deeplinks.DeepLinkManager;
import me.lyft.android.development.IDeveloperTools;
import me.lyft.android.infrastructure.activity.ActivityLifecycleService;
import me.lyft.android.infrastructure.activity.ActivityServiceRegistry;
import me.lyft.android.infrastructure.activity.IActivityLifecycleService;
import me.lyft.android.infrastructure.bootstrap.IBootstrapService;
import me.lyft.android.infrastructure.environment.IEnvironmentService;
import me.lyft.android.infrastructure.foreground.IAppForegroundDetector;
import me.lyft.android.infrastructure.googleplay.IGoogleApiProvider;
import me.lyft.android.infrastructure.instabug.IInstabugService;
import me.lyft.android.infrastructure.location.ILocationService;
import me.lyft.android.infrastructure.locationsettings.ILocationSettingsService;
import me.lyft.android.infrastructure.settings.IAutomationOverrideService;
import me.lyft.android.logging.L;
import me.lyft.android.maps.LocationServiceSourceHook;
import me.lyft.android.maps.LyftMapView;
import me.lyft.android.rx.Binder;
import me.lyft.android.services.AppService;
import me.lyft.android.ui.landing.LandingScreens.StarterScreen;
import me.lyft.android.utils.ActivityResult;
import me.lyft.android.utils.Keyboard;
import me.lyft.android.utils.VersionUtils;
import rx.functions.Action1;

public class MainActivity
  extends Activity
{
  private static final String EXTRA_ENVIRONMENT = "environment";
  private static final String EXTRA_SETTINGS = "settings";
  @Inject
  MainActivityAnalytics activityAnalytics;
  @Inject
  ActivityController activityController;
  IActivityLifecycleService activityLifecycleService;
  private ActivityResult activityResult;
  @Inject
  ActivityServiceRegistry activityServiceRegistry;
  @Inject
  AppFlow appFlow;
  @Inject
  IAppForegroundDetector appForegroundDetector;
  private Binder binder = new Binder();
  @Inject
  IBootstrapService bootstrapService;
  @Inject
  DeepLinkManager deepLinkManager;
  @Inject
  IDeveloperTools developerTools;
  @Inject
  DialogFlow dialogFlow;
  private ScreensContainer dialogScreensContainer;
  @Inject
  IEnvironmentService environmentService;
  @Inject
  IGoogleApiProvider googleApiProvider;
  @Inject
  IInstabugService instabugService;
  @Inject
  ILocationService locationService;
  @Inject
  ILocationSettingsService locationSettingsService;
  private ScreensContainer mainScreensContainer;
  LyftMapView mapView;
  DrawerLayout menuDrawer;
  ViewGroup menuPlaceholder;
  private Action1<RouteChange> onDialogChanged = new Action1()
  {
    public void call(RouteChange paramAnonymousRouteChange)
    {
      List localList1 = fromPath;
      List localList2 = toPath;
      if (!localList1.isEmpty()) {
        L.d("Dialog changed from: %s", new Object[] { ((Screen)localList1.get(localList1.size() - 1)).getClass().getName() });
      }
      if (!localList2.isEmpty()) {
        L.d("Dialog changed to: %s", new Object[] { ((Screen)localList2.get(localList2.size() - 1)).getClass().getName() });
      }
      Keyboard.hideKeyboard(dialogScreensContainer);
      dialogScreensContainer.goTo(paramAnonymousRouteChange);
    }
  };
  private Action1<RouteChange> onScreenChanged = new Action1()
  {
    public void call(RouteChange paramAnonymousRouteChange)
    {
      Screen localScreen = ScreenUtils.nextScreenFromRouteChange(paramAnonymousRouteChange);
      if (localScreen != null) {
        L.d("Screen: %s", new Object[] { localScreen.getClass().getName() });
      }
      if (localScreen != null)
      {
        Keyboard.hideKeyboard(mainScreensContainer);
        mainScreensContainer.goTo(paramAnonymousRouteChange);
      }
    }
  };
  ProgressController progressController;
  private ProgressView progressView;
  private Scoop rootScoop;
  ViewGroup rootView;
  ViewGroup screensPlaceholder;
  @Inject
  IAutomationOverrideService settingsOverrideService;
  SlideMenuController slideMenuController;
  
  private void checkForDeepLink()
  {
    Intent localIntent = getIntent();
    Uri localUri = localIntent.getData();
    if (localUri != null)
    {
      localIntent.setData(null);
      setIntent(localIntent);
    }
    if ((localUri == null) || (!deepLinkManager.tryHandleDeepLink(new DeepLink(localUri)))) {
      displayDefaultScreenIfNoneActive();
    }
  }
  
  private void checkForPush()
  {
    Intent localIntent = getIntent();
    String str1 = localIntent.getStringExtra("push_id");
    String str2 = localIntent.getStringExtra("campaign_id");
    if (!Strings.isNullOrEmpty(str1))
    {
      PushNotificationAnalytics.trackPushTapped(str1, str2);
      localIntent.removeExtra("push_id");
      localIntent.removeExtra("campaign_id");
      setIntent(localIntent);
    }
  }
  
  private void checkIfMockLocationsUsedInProduction()
  {
    if ((!developerTools.isDeveloperMode()) && (locationSettingsService.mockLocationEnabled())) {
      dialogFlow.show(new Dialogs.MockLocationsWarningDialog());
    }
  }
  
  public static Intent createIntent(Context paramContext)
  {
    paramContext = new Intent(paramContext, MainActivity.class);
    paramContext.addFlags(335544320);
    return paramContext;
  }
  
  private void displayDefaultScreenIfNoneActive()
  {
    if (!appFlow.hasActiveScreen()) {
      appFlow.resetTo(new LandingScreens.StarterScreen());
    }
  }
  
  public static void foregroundActivity(Context paramContext, String paramString)
  {
    new ActionAnalytics(ActionEvent.Action.APP_FOREGROUNDED).setReason(paramString).trackInitiation().trackSuccess();
    paramContext.startActivity(createIntent(paramContext));
  }
  
  private Scoop getActivityScoop()
  {
    if (rootScoop == null)
    {
      DaggerInjector localDaggerInjector = new DaggerInjector(getApp().getApplicationGraph().plus(new Object[] { new MainActivityModule(this) }));
      rootScoop = new Scoop.Builder("activity_scoop").service("dagger", localDaggerInjector).build();
    }
    return rootScoop;
  }
  
  private LyftApplication getApp()
  {
    return LyftApplication.from(this);
  }
  
  public static void restartActivity(Context paramContext)
  {
    paramContext.startActivity(createIntent(paramContext));
  }
  
  private void useExtrasFromIntent(Intent paramIntent)
  {
    if (developerTools.isDeveloperMode())
    {
      if (paramIntent.hasExtra("environment")) {
        environmentService.updateFromJsonString(getIntent().getStringExtra("environment"));
      }
      if (paramIntent.hasExtra("settings")) {
        settingsOverrideService.updateFromJsonString(getIntent().getStringExtra("settings"));
      }
    }
  }
  
  protected void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    super.onActivityResult(paramInt1, paramInt2, paramIntent);
    activityResult = ActivityResult.create(paramInt1, paramInt2, paramIntent);
    activityLifecycleService.onActivityResult(activityResult);
  }
  
  public void onBackPressed()
  {
    if (slideMenuController.isOpen()) {
      slideMenuController.close();
    }
    do
    {
      return;
      if (progressController.isActive())
      {
        super.onBackPressed();
        return;
      }
    } while ((dialogScreensContainer.onBack()) || (dialogFlow.dismiss()) || (mainScreensContainer.onBack()) || (appFlow.goBack()));
    super.onBackPressed();
  }
  
  public void onConfigurationChanged(Configuration paramConfiguration)
  {
    super.onConfigurationChanged(paramConfiguration);
    activityController.onConfigurationChanged(paramConfiguration);
  }
  
  @TargetApi(21)
  protected void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    activityLifecycleService = new ActivityLifecycleService(this);
    if (VersionUtils.hasKitKat()) {
      AppLaunchAnalytics.onCreateMainActivity();
    }
    DaggerInjector.fromScoop(getActivityScoop()).inject(this);
    bootstrapService.bootstrap();
    useExtrasFromIntent(getIntent());
    AppService.start(this);
    if (VersionUtils.hasLollipop()) {
      setTaskDescription(new ActivityManager.TaskDescription(getString(2131165301), null, getResources().getColor(2131493083)));
    }
    setContentView(2130903441);
    ButterKnife.bind(this);
    slideMenuController = new SlideMenuController(menuDrawer);
    mapView = new LyftMapView(this);
    mapView.setLocationSource(new LocationServiceSourceHook(locationService));
    instabugService.addMapView(mapView);
    if (paramBundle != null)
    {
      mapView.create(paramBundle.getBundle("map_bundle"));
      activityController.onCreate(this);
      Object localObject = getActivityScoop().inflater(this);
      progressController = new ProgressController();
      menuDrawer.setDrawerShadow(2130838039, 8388611);
      mainScreensContainer = ((ScreensContainer)((LayoutInflater)localObject).inflate(2130903447, screensPlaceholder, false));
      dialogScreensContainer = ((ScreensContainer)((LayoutInflater)localObject).inflate(2130903447, rootView, false));
      progressView = ((ProgressView)((LayoutInflater)localObject).inflate(2130903293, rootView, false));
      localObject = (MenuView)((LayoutInflater)localObject).inflate(2130903285, menuPlaceholder, false);
      menuPlaceholder.addView((View)localObject);
      screensPlaceholder.addView(mainScreensContainer);
      rootView.addView(dialogScreensContainer);
      rootView.addView(progressView);
      progressController.takeView(progressView, rootView);
      binder.bind(dialogFlow.observeDialogChange(), onDialogChanged);
      activityServiceRegistry.onActivityCreated(this, paramBundle);
      activityLifecycleService.onActivityCreated(paramBundle);
      binder.bind(appFlow.observeRouteChange(), onScreenChanged);
      if (googleApiProvider.checkGooglePlayServicesAvailable()) {
        break label448;
      }
      activityAnalytics.trackUnavailableGooglePlayServices();
    }
    for (;;)
    {
      getWindow().setBackgroundDrawableResource(2131493083);
      return;
      mapView.create(null);
      break;
      label448:
      displayDefaultScreenIfNoneActive();
    }
  }
  
  protected void onDestroy()
  {
    super.onDestroy();
    binder.detach();
    appFlow.clear();
    dialogFlow.clear();
    mapView.destroy();
    activityController.onDestroy(this);
    progressController.dropView();
    activityServiceRegistry.onActivityDestroyed(this);
    activityLifecycleService.onActivityDestroyed();
    Analytics.flush();
    getActivityScoop().destroy();
  }
  
  public void onLowMemory()
  {
    super.onLowMemory();
    mapView.lowMemory();
  }
  
  protected void onNewIntent(Intent paramIntent)
  {
    super.onNewIntent(paramIntent);
    setIntent(paramIntent);
  }
  
  protected void onPause()
  {
    super.onPause();
    mapView.pause();
    activityServiceRegistry.onActivityPaused(this);
    Analytics.flush();
  }
  
  protected void onPostResume()
  {
    super.onPostResume();
    mainScreensContainer.post(new Runnable()
    {
      public void run()
      {
        if (activityResult != null)
        {
          activityServiceRegistry.onActivityResult(MainActivity.this, activityResult);
          MainActivity.access$002(MainActivity.this, null);
        }
      }
    });
  }
  
  protected void onResume()
  {
    super.onResume();
    checkForPush();
    checkForDeepLink();
    mapView.resume();
    checkIfMockLocationsUsedInProduction();
    activityServiceRegistry.onActivityResumed(this);
  }
  
  protected void onSaveInstanceState(Bundle paramBundle)
  {
    activityServiceRegistry.onActivitySaveInstanceState(this, paramBundle);
    super.onSaveInstanceState(paramBundle);
  }
  
  protected void onStart()
  {
    super.onStart();
    appForegroundDetector.onStart();
    activityServiceRegistry.onActivityStarted(this);
  }
  
  protected void onStop()
  {
    appForegroundDetector.onStop();
    activityServiceRegistry.onActivityStopped(this);
    super.onStop();
  }
}

/* Location:
 * Qualified Name:     me.lyft.android.ui.MainActivity
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */