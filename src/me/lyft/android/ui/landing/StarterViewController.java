package me.lyft.android.ui.landing;

import com.lyft.rx.MessageBus;
import javax.inject.Inject;
import me.lyft.android.analytics.studies.AppLaunchAnalytics;
import me.lyft.android.common.RxViewController;
import me.lyft.android.events.GeneralErrorDialogResultEvent;
import me.lyft.android.infrastructure.bootstrap.IBootstrapService;
import me.lyft.android.rx.RxUIBinder;
import me.lyft.android.ui.IViewErrorHandler;
import me.lyft.android.ui.dialogs.DialogResult;
import me.lyft.android.utils.VersionUtils;
import rx.functions.Action1;

public class StarterViewController
  extends RxViewController
{
  private final IBootstrapService bootstrapService;
  private final MessageBus bus;
  private final LandingFlow landingFlow;
  Action1<DialogResult> onGenericErrorHappened = new StarterViewController.3(this);
  private final IViewErrorHandler viewErrorHandler;
  
  @Inject
  public StarterViewController(IBootstrapService paramIBootstrapService, LandingFlow paramLandingFlow, IViewErrorHandler paramIViewErrorHandler, MessageBus paramMessageBus)
  {
    bootstrapService = paramIBootstrapService;
    landingFlow = paramLandingFlow;
    viewErrorHandler = paramIViewErrorHandler;
    bus = paramMessageBus;
  }
  
  private void launchApp()
  {
    landingFlow.launchFirstScreen();
  }
  
  private void retryLoadUser()
  {
    binder.bindAsyncCall(bootstrapService.retryLoadUser(), new StarterViewController.2(this));
  }
  
  protected int layoutId()
  {
    return 2130903459;
  }
  
  public void onAttach()
  {
    super.onAttach();
    binder.bindAction(bus.observe(GeneralErrorDialogResultEvent.class), onGenericErrorHappened);
    binder.bindAsyncCall(bootstrapService.observeBootstrapComplete(), new StarterViewController.1(this));
  }
  
  public void onDetach()
  {
    super.onDetach();
    if (VersionUtils.hasKitKat()) {
      AppLaunchAnalytics.onLoadingAnimationComplete();
    }
  }
}

/* Location:
 * Qualified Name:     me.lyft.android.ui.landing.StarterViewController
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */