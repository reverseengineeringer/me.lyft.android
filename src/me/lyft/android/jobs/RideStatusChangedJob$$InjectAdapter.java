package me.lyft.android.jobs;

import com.lyft.rx.MessageBus;
import dagger.internal.Binding;
import dagger.internal.Linker;
import java.util.Set;
import me.lyft.android.LyftApplication;
import me.lyft.android.application.constants.IConstantsProvider;
import me.lyft.android.application.ride.IDriverRideProvider;
import me.lyft.android.common.AppFlow;
import me.lyft.android.common.DialogFlow;
import me.lyft.android.driver.notifications.IDriverNotificationService;
import me.lyft.android.infrastructure.foreground.IAppForegroundDetector;
import me.lyft.android.infrastructure.instabug.IInstabugService;
import me.lyft.android.infrastructure.notifications.InAppNotificationService;
import me.lyft.android.ui.MainScreensRouter;
import me.lyft.android.utils.SoundManager;

public final class RideStatusChangedJob$$InjectAdapter
  extends Binding<RideStatusChangedJob>
{
  private Binding<AppFlow> appFlow;
  private Binding<IAppForegroundDetector> appForegroundDetector;
  private Binding<LyftApplication> application;
  private Binding<MessageBus> bus;
  private Binding<IConstantsProvider> constantsProvider;
  private Binding<DialogFlow> dialogFlow;
  private Binding<IDriverNotificationService> driverNotificationService;
  private Binding<IDriverRideProvider> driverRideProvider;
  private Binding<InAppNotificationService> inAppNotificationService;
  private Binding<IInstabugService> instabug;
  private Binding<MainScreensRouter> mainScreensRouter;
  private Binding<SoundManager> soundManager;
  
  public RideStatusChangedJob$$InjectAdapter()
  {
    super(null, "members/me.lyft.android.jobs.RideStatusChangedJob", false, RideStatusChangedJob.class);
  }
  
  public void attach(Linker paramLinker)
  {
    driverRideProvider = paramLinker.requestBinding("me.lyft.android.application.ride.IDriverRideProvider", RideStatusChangedJob.class, getClass().getClassLoader());
    constantsProvider = paramLinker.requestBinding("me.lyft.android.application.constants.IConstantsProvider", RideStatusChangedJob.class, getClass().getClassLoader());
    bus = paramLinker.requestBinding("com.lyft.rx.MessageBus", RideStatusChangedJob.class, getClass().getClassLoader());
    application = paramLinker.requestBinding("me.lyft.android.LyftApplication", RideStatusChangedJob.class, getClass().getClassLoader());
    appFlow = paramLinker.requestBinding("me.lyft.android.common.AppFlow", RideStatusChangedJob.class, getClass().getClassLoader());
    dialogFlow = paramLinker.requestBinding("me.lyft.android.common.DialogFlow", RideStatusChangedJob.class, getClass().getClassLoader());
    mainScreensRouter = paramLinker.requestBinding("me.lyft.android.ui.MainScreensRouter", RideStatusChangedJob.class, getClass().getClassLoader());
    soundManager = paramLinker.requestBinding("me.lyft.android.utils.SoundManager", RideStatusChangedJob.class, getClass().getClassLoader());
    appForegroundDetector = paramLinker.requestBinding("me.lyft.android.infrastructure.foreground.IAppForegroundDetector", RideStatusChangedJob.class, getClass().getClassLoader());
    inAppNotificationService = paramLinker.requestBinding("me.lyft.android.infrastructure.notifications.InAppNotificationService", RideStatusChangedJob.class, getClass().getClassLoader());
    instabug = paramLinker.requestBinding("me.lyft.android.infrastructure.instabug.IInstabugService", RideStatusChangedJob.class, getClass().getClassLoader());
    driverNotificationService = paramLinker.requestBinding("me.lyft.android.driver.notifications.IDriverNotificationService", RideStatusChangedJob.class, getClass().getClassLoader());
  }
  
  public void getDependencies(Set<Binding<?>> paramSet1, Set<Binding<?>> paramSet2)
  {
    paramSet2.add(driverRideProvider);
    paramSet2.add(constantsProvider);
    paramSet2.add(bus);
    paramSet2.add(application);
    paramSet2.add(appFlow);
    paramSet2.add(dialogFlow);
    paramSet2.add(mainScreensRouter);
    paramSet2.add(soundManager);
    paramSet2.add(appForegroundDetector);
    paramSet2.add(inAppNotificationService);
    paramSet2.add(instabug);
    paramSet2.add(driverNotificationService);
  }
  
  public void injectMembers(RideStatusChangedJob paramRideStatusChangedJob)
  {
    driverRideProvider = ((IDriverRideProvider)driverRideProvider.get());
    constantsProvider = ((IConstantsProvider)constantsProvider.get());
    bus = ((MessageBus)bus.get());
    application = ((LyftApplication)application.get());
    appFlow = ((AppFlow)appFlow.get());
    dialogFlow = ((DialogFlow)dialogFlow.get());
    mainScreensRouter = ((MainScreensRouter)mainScreensRouter.get());
    soundManager = ((SoundManager)soundManager.get());
    appForegroundDetector = ((IAppForegroundDetector)appForegroundDetector.get());
    inAppNotificationService = ((InAppNotificationService)inAppNotificationService.get());
    instabug = ((IInstabugService)instabug.get());
    driverNotificationService = ((IDriverNotificationService)driverNotificationService.get());
  }
}

/* Location:
 * Qualified Name:     me.lyft.android.jobs.RideStatusChangedJob..InjectAdapter
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */