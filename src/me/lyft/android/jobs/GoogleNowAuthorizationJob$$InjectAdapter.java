package me.lyft.android.jobs;

import dagger.internal.Binding;
import dagger.internal.Linker;
import java.util.Set;
import me.lyft.android.ILyftPreferences;
import me.lyft.android.LyftApplication;
import me.lyft.android.application.jobs.IGoogleNowService;

public final class GoogleNowAuthorizationJob$$InjectAdapter
  extends Binding<GoogleNowAuthorizationJob>
{
  private Binding<LyftApplication> application;
  private Binding<IGoogleNowService> jobService;
  private Binding<ILyftPreferences> preferences;
  
  public GoogleNowAuthorizationJob$$InjectAdapter()
  {
    super(null, "members/me.lyft.android.jobs.GoogleNowAuthorizationJob", false, GoogleNowAuthorizationJob.class);
  }
  
  public void attach(Linker paramLinker)
  {
    application = paramLinker.requestBinding("me.lyft.android.LyftApplication", GoogleNowAuthorizationJob.class, getClass().getClassLoader());
    preferences = paramLinker.requestBinding("me.lyft.android.ILyftPreferences", GoogleNowAuthorizationJob.class, getClass().getClassLoader());
    jobService = paramLinker.requestBinding("me.lyft.android.application.jobs.IGoogleNowService", GoogleNowAuthorizationJob.class, getClass().getClassLoader());
  }
  
  public void getDependencies(Set<Binding<?>> paramSet1, Set<Binding<?>> paramSet2)
  {
    paramSet2.add(application);
    paramSet2.add(preferences);
    paramSet2.add(jobService);
  }
  
  public void injectMembers(GoogleNowAuthorizationJob paramGoogleNowAuthorizationJob)
  {
    application = ((LyftApplication)application.get());
    preferences = ((ILyftPreferences)preferences.get());
    jobService = ((IGoogleNowService)jobService.get());
  }
}

/* Location:
 * Qualified Name:     me.lyft.android.jobs.GoogleNowAuthorizationJob..InjectAdapter
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */