package me.lyft.android.jobs;

import dagger.internal.Binding;
import dagger.internal.Linker;
import java.util.Set;
import me.lyft.android.ILyftPreferences;
import me.lyft.android.LyftApplication;
import me.lyft.android.application.profile.IProfileService;
import me.lyft.android.infrastructure.facebook.IFacebookTokenService;

public final class InitFacebookSdkJob$$InjectAdapter
  extends Binding<InitFacebookSdkJob>
{
  private Binding<LyftApplication> application;
  private Binding<IFacebookTokenService> facebookService;
  private Binding<ILyftPreferences> preferences;
  private Binding<IProfileService> profileService;
  
  public InitFacebookSdkJob$$InjectAdapter()
  {
    super("me.lyft.android.jobs.InitFacebookSdkJob", "members/me.lyft.android.jobs.InitFacebookSdkJob", false, InitFacebookSdkJob.class);
  }
  
  public void attach(Linker paramLinker)
  {
    application = paramLinker.requestBinding("me.lyft.android.LyftApplication", InitFacebookSdkJob.class, getClass().getClassLoader());
    preferences = paramLinker.requestBinding("me.lyft.android.ILyftPreferences", InitFacebookSdkJob.class, getClass().getClassLoader());
    facebookService = paramLinker.requestBinding("me.lyft.android.infrastructure.facebook.IFacebookTokenService", InitFacebookSdkJob.class, getClass().getClassLoader());
    profileService = paramLinker.requestBinding("me.lyft.android.application.profile.IProfileService", InitFacebookSdkJob.class, getClass().getClassLoader());
  }
  
  public InitFacebookSdkJob get()
  {
    InitFacebookSdkJob localInitFacebookSdkJob = new InitFacebookSdkJob();
    injectMembers(localInitFacebookSdkJob);
    return localInitFacebookSdkJob;
  }
  
  public void getDependencies(Set<Binding<?>> paramSet1, Set<Binding<?>> paramSet2)
  {
    paramSet2.add(application);
    paramSet2.add(preferences);
    paramSet2.add(facebookService);
    paramSet2.add(profileService);
  }
  
  public void injectMembers(InitFacebookSdkJob paramInitFacebookSdkJob)
  {
    application = ((LyftApplication)application.get());
    preferences = ((ILyftPreferences)preferences.get());
    facebookService = ((IFacebookTokenService)facebookService.get());
    profileService = ((IProfileService)profileService.get());
  }
}

/* Location:
 * Qualified Name:     me.lyft.android.jobs.InitFacebookSdkJob..InjectAdapter
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */