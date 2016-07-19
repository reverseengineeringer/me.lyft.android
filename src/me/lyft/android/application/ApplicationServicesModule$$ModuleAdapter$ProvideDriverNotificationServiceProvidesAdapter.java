package me.lyft.android.application;

import android.content.res.Resources;
import android.os.Handler;
import dagger.internal.Binding;
import dagger.internal.Linker;
import dagger.internal.ProvidesBinding;
import java.util.Set;
import me.lyft.android.common.DialogFlow;
import me.lyft.android.driver.notifications.IDriverNotificationService;
import me.lyft.android.infrastructure.foreground.IAppForegroundDetector;
import me.lyft.android.navigation.Navigator;
import me.lyft.android.utils.SoundManager;
import me.lyft.android.utils.TextToSpeech;
import me.lyft.android.utils.Vibrator;

public final class ApplicationServicesModule$$ModuleAdapter$ProvideDriverNotificationServiceProvidesAdapter
  extends ProvidesBinding<IDriverNotificationService>
{
  private Binding<IAppForegroundDetector> appForegroundDetector;
  private Binding<DialogFlow> dialogFlow;
  private Binding<Handler> handler;
  private final ApplicationServicesModule module;
  private Binding<Navigator> navigator;
  private Binding<Resources> resources;
  private Binding<SoundManager> soundManager;
  private Binding<TextToSpeech> textToSpeech;
  private Binding<Vibrator> vibrator;
  
  public ApplicationServicesModule$$ModuleAdapter$ProvideDriverNotificationServiceProvidesAdapter(ApplicationServicesModule paramApplicationServicesModule)
  {
    super("me.lyft.android.driver.notifications.IDriverNotificationService", true, "me.lyft.android.application.ApplicationServicesModule", "provideDriverNotificationService");
    module = paramApplicationServicesModule;
    setLibrary(true);
  }
  
  public void attach(Linker paramLinker)
  {
    textToSpeech = paramLinker.requestBinding("me.lyft.android.utils.TextToSpeech", ApplicationServicesModule.class, getClass().getClassLoader());
    dialogFlow = paramLinker.requestBinding("me.lyft.android.common.DialogFlow", ApplicationServicesModule.class, getClass().getClassLoader());
    soundManager = paramLinker.requestBinding("me.lyft.android.utils.SoundManager", ApplicationServicesModule.class, getClass().getClassLoader());
    resources = paramLinker.requestBinding("android.content.res.Resources", ApplicationServicesModule.class, getClass().getClassLoader());
    appForegroundDetector = paramLinker.requestBinding("me.lyft.android.infrastructure.foreground.IAppForegroundDetector", ApplicationServicesModule.class, getClass().getClassLoader());
    navigator = paramLinker.requestBinding("me.lyft.android.navigation.Navigator", ApplicationServicesModule.class, getClass().getClassLoader());
    vibrator = paramLinker.requestBinding("me.lyft.android.utils.Vibrator", ApplicationServicesModule.class, getClass().getClassLoader());
    handler = paramLinker.requestBinding("android.os.Handler", ApplicationServicesModule.class, getClass().getClassLoader());
  }
  
  public IDriverNotificationService get()
  {
    return module.provideDriverNotificationService((TextToSpeech)textToSpeech.get(), (DialogFlow)dialogFlow.get(), (SoundManager)soundManager.get(), (Resources)resources.get(), (IAppForegroundDetector)appForegroundDetector.get(), (Navigator)navigator.get(), (Vibrator)vibrator.get(), (Handler)handler.get());
  }
  
  public void getDependencies(Set<Binding<?>> paramSet1, Set<Binding<?>> paramSet2)
  {
    paramSet1.add(textToSpeech);
    paramSet1.add(dialogFlow);
    paramSet1.add(soundManager);
    paramSet1.add(resources);
    paramSet1.add(appForegroundDetector);
    paramSet1.add(navigator);
    paramSet1.add(vibrator);
    paramSet1.add(handler);
  }
}

/* Location:
 * Qualified Name:     me.lyft.android.application.ApplicationServicesModule..ModuleAdapter.ProvideDriverNotificationServiceProvidesAdapter
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */