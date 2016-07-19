package me.lyft.android.jobs;

import dagger.internal.Binding;
import dagger.internal.Linker;
import java.util.Set;
import me.lyft.android.ILyftPreferences;
import me.lyft.android.LyftApplication;
import me.lyft.android.application.constants.IConstantsProvider;
import me.lyft.android.application.ride.IDriverRideProvider;
import me.lyft.android.infrastructure.foreground.IAppForegroundDetector;
import me.lyft.android.infrastructure.location.ILocationService;
import me.lyft.android.utils.TextToSpeech;

public final class DriverCloseToCurrentStopJob$$InjectAdapter
  extends Binding<DriverCloseToCurrentStopJob>
{
  private Binding<IAppForegroundDetector> appForegroundDetector;
  private Binding<LyftApplication> application;
  private Binding<IConstantsProvider> constantsProvider;
  private Binding<ILocationService> locationService;
  private Binding<ILyftPreferences> lyftPreferences;
  private Binding<IDriverRideProvider> routeProvider;
  private Binding<TextToSpeech> textToSpeech;
  
  public DriverCloseToCurrentStopJob$$InjectAdapter()
  {
    super("me.lyft.android.jobs.DriverCloseToCurrentStopJob", "members/me.lyft.android.jobs.DriverCloseToCurrentStopJob", false, DriverCloseToCurrentStopJob.class);
  }
  
  public void attach(Linker paramLinker)
  {
    application = paramLinker.requestBinding("me.lyft.android.LyftApplication", DriverCloseToCurrentStopJob.class, getClass().getClassLoader());
    routeProvider = paramLinker.requestBinding("me.lyft.android.application.ride.IDriverRideProvider", DriverCloseToCurrentStopJob.class, getClass().getClassLoader());
    constantsProvider = paramLinker.requestBinding("me.lyft.android.application.constants.IConstantsProvider", DriverCloseToCurrentStopJob.class, getClass().getClassLoader());
    locationService = paramLinker.requestBinding("me.lyft.android.infrastructure.location.ILocationService", DriverCloseToCurrentStopJob.class, getClass().getClassLoader());
    lyftPreferences = paramLinker.requestBinding("me.lyft.android.ILyftPreferences", DriverCloseToCurrentStopJob.class, getClass().getClassLoader());
    textToSpeech = paramLinker.requestBinding("me.lyft.android.utils.TextToSpeech", DriverCloseToCurrentStopJob.class, getClass().getClassLoader());
    appForegroundDetector = paramLinker.requestBinding("me.lyft.android.infrastructure.foreground.IAppForegroundDetector", DriverCloseToCurrentStopJob.class, getClass().getClassLoader());
  }
  
  public DriverCloseToCurrentStopJob get()
  {
    DriverCloseToCurrentStopJob localDriverCloseToCurrentStopJob = new DriverCloseToCurrentStopJob();
    injectMembers(localDriverCloseToCurrentStopJob);
    return localDriverCloseToCurrentStopJob;
  }
  
  public void getDependencies(Set<Binding<?>> paramSet1, Set<Binding<?>> paramSet2)
  {
    paramSet2.add(application);
    paramSet2.add(routeProvider);
    paramSet2.add(constantsProvider);
    paramSet2.add(locationService);
    paramSet2.add(lyftPreferences);
    paramSet2.add(textToSpeech);
    paramSet2.add(appForegroundDetector);
  }
  
  public void injectMembers(DriverCloseToCurrentStopJob paramDriverCloseToCurrentStopJob)
  {
    application = ((LyftApplication)application.get());
    routeProvider = ((IDriverRideProvider)routeProvider.get());
    constantsProvider = ((IConstantsProvider)constantsProvider.get());
    locationService = ((ILocationService)locationService.get());
    lyftPreferences = ((ILyftPreferences)lyftPreferences.get());
    textToSpeech = ((TextToSpeech)textToSpeech.get());
    appForegroundDetector = ((IAppForegroundDetector)appForegroundDetector.get());
  }
}

/* Location:
 * Qualified Name:     me.lyft.android.jobs.DriverCloseToCurrentStopJob..InjectAdapter
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */