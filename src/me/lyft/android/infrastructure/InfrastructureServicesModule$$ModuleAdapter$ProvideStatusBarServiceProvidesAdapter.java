package me.lyft.android.infrastructure;

import android.app.NotificationManager;
import dagger.internal.Binding;
import dagger.internal.Linker;
import dagger.internal.ProvidesBinding;
import java.util.Set;
import me.lyft.android.ILyftPreferences;
import me.lyft.android.deeplinks.DeepLinkManager;
import me.lyft.android.infrastructure.foreground.IAppForegroundDetector;
import me.lyft.android.infrastructure.json.IJsonSerializer;
import me.lyft.android.managers.ImageLoader;
import me.lyft.android.notifications.IStatusBarNotificationsService;

public final class InfrastructureServicesModule$$ModuleAdapter$ProvideStatusBarServiceProvidesAdapter
  extends ProvidesBinding<IStatusBarNotificationsService>
{
  private Binding<IAppForegroundDetector> appForegroundDetector;
  private Binding<DeepLinkManager> deepLinkManager;
  private Binding<ImageLoader> imageLoader;
  private Binding<IJsonSerializer> jsonSerializer;
  private final InfrastructureServicesModule module;
  private Binding<NotificationManager> notificationManager;
  private Binding<ILyftPreferences> preferences;
  
  public InfrastructureServicesModule$$ModuleAdapter$ProvideStatusBarServiceProvidesAdapter(InfrastructureServicesModule paramInfrastructureServicesModule)
  {
    super("me.lyft.android.notifications.IStatusBarNotificationsService", true, "me.lyft.android.infrastructure.InfrastructureServicesModule", "provideStatusBarService");
    module = paramInfrastructureServicesModule;
    setLibrary(true);
  }
  
  public void attach(Linker paramLinker)
  {
    imageLoader = paramLinker.requestBinding("me.lyft.android.managers.ImageLoader", InfrastructureServicesModule.class, getClass().getClassLoader());
    notificationManager = paramLinker.requestBinding("android.app.NotificationManager", InfrastructureServicesModule.class, getClass().getClassLoader());
    preferences = paramLinker.requestBinding("me.lyft.android.ILyftPreferences", InfrastructureServicesModule.class, getClass().getClassLoader());
    appForegroundDetector = paramLinker.requestBinding("me.lyft.android.infrastructure.foreground.IAppForegroundDetector", InfrastructureServicesModule.class, getClass().getClassLoader());
    jsonSerializer = paramLinker.requestBinding("me.lyft.android.infrastructure.json.IJsonSerializer", InfrastructureServicesModule.class, getClass().getClassLoader());
    deepLinkManager = paramLinker.requestBinding("me.lyft.android.deeplinks.DeepLinkManager", InfrastructureServicesModule.class, getClass().getClassLoader());
  }
  
  public IStatusBarNotificationsService get()
  {
    return module.provideStatusBarService((ImageLoader)imageLoader.get(), (NotificationManager)notificationManager.get(), (ILyftPreferences)preferences.get(), (IAppForegroundDetector)appForegroundDetector.get(), (IJsonSerializer)jsonSerializer.get(), (DeepLinkManager)deepLinkManager.get());
  }
  
  public void getDependencies(Set<Binding<?>> paramSet1, Set<Binding<?>> paramSet2)
  {
    paramSet1.add(imageLoader);
    paramSet1.add(notificationManager);
    paramSet1.add(preferences);
    paramSet1.add(appForegroundDetector);
    paramSet1.add(jsonSerializer);
    paramSet1.add(deepLinkManager);
  }
}

/* Location:
 * Qualified Name:     me.lyft.android.infrastructure.InfrastructureServicesModule..ModuleAdapter.ProvideStatusBarServiceProvidesAdapter
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */