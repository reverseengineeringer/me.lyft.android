package me.lyft.android.infrastructure.bootstrap;

import java.util.concurrent.Callable;
import me.lyft.android.ILyftPreferences;
import me.lyft.android.IUserSession;
import me.lyft.android.application.IAppInfoService;
import me.lyft.android.application.autofill.AutoFillAnalytics;
import me.lyft.android.application.autofill.AutoFillService;
import me.lyft.android.application.features.Features;
import me.lyft.android.application.features.IFeaturesProvider;
import me.lyft.android.application.landing.ILandingService;
import me.lyft.android.common.Strings;
import me.lyft.android.common.Unit;
import me.lyft.android.infrastructure.assets.IAssetPackagingService;
import me.lyft.android.logging.L;
import me.lyft.android.rx.SimpleSubscriber;
import rx.Observable;
import rx.functions.Func1;
import rx.schedulers.Schedulers;

public class BootstrapService
  implements IBootstrapService
{
  private final IAppInfoService appInfoService;
  private final IAssetPackagingService assetPackagingService;
  private final AutoFillAnalytics autoFillAnalytics;
  private final AutoFillService autoFillService;
  private Observable<Unit> bootstrapResult = null;
  private final IFeaturesProvider featuresProvider;
  private final ILandingService landingService;
  private final ILyftPreferences lyftPreferences;
  private IUserSession userSession;
  
  public BootstrapService(IUserSession paramIUserSession, ILyftPreferences paramILyftPreferences, IAppInfoService paramIAppInfoService, IAssetPackagingService paramIAssetPackagingService, ILandingService paramILandingService, AutoFillService paramAutoFillService, AutoFillAnalytics paramAutoFillAnalytics, IFeaturesProvider paramIFeaturesProvider)
  {
    userSession = paramIUserSession;
    lyftPreferences = paramILyftPreferences;
    appInfoService = paramIAppInfoService;
    assetPackagingService = paramIAssetPackagingService;
    landingService = paramILandingService;
    autoFillService = paramAutoFillService;
    autoFillAnalytics = paramAutoFillAnalytics;
    featuresProvider = paramIFeaturesProvider;
  }
  
  private Observable<Unit> observeSessionRestore()
  {
    Observable.fromCallable(new Callable()
    {
      public Unit call()
        throws Exception
      {
        BootstrapService.this.safeAppStateRestore();
        return Unit.create();
      }
    }).subscribeOn(Schedulers.io());
  }
  
  private void performLoadAppInfo()
  {
    String str = Strings.nullToEmpty(lyftPreferences.getInstallReferrer());
    appInfoService.loadAppInfo(str).subscribe(new SimpleSubscriber());
  }
  
  private Observable<Unit> performLoadUser()
  {
    return landingService.loadUser();
  }
  
  private void restoreAppStateAndDispatchBootstrap()
  {
    bootstrapResult = observeSessionRestore().flatMap(new Func1()
    {
      public Observable<Unit> call(Unit paramAnonymousUnit)
      {
        if (!Strings.isNullOrEmpty(lyftPreferences.getLyftToken())) {
          return BootstrapService.this.performLoadUser();
        }
        BootstrapService.this.performLoadAppInfo();
        return Unit.just();
      }
    }).cache();
    bootstrapResult.subscribe(new SimpleSubscriber());
  }
  
  private void safeAppStateRestore()
  {
    try
    {
      userSession.restoreAppState();
      return;
    }
    catch (Throwable localThrowable)
    {
      L.w(localThrowable, "restore app state failed", new Object[0]);
    }
  }
  
  public void bootstrap()
  {
    if (bootstrapResult != null) {}
    do
    {
      return;
      restoreAppStateAndDispatchBootstrap();
      assetPackagingService.unpackEmbededZipResources().subscribe(new SimpleSubscriber());
      autoFillAnalytics.initializeOnBootstrap();
    } while (!featuresProvider.isEnabled(Features.INITIATE_ULU_ON_BOOTSTRAP));
    autoFillService.requestAutofillLocations().subscribe(new SimpleSubscriber());
  }
  
  public Observable<Unit> observeBootstrapComplete()
  {
    return bootstrapResult;
  }
  
  public Observable<Unit> retryLoadUser()
  {
    bootstrapResult = performLoadUser().cache();
    return bootstrapResult;
  }
}

/* Location:
 * Qualified Name:     me.lyft.android.infrastructure.bootstrap.BootstrapService
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */