package me.lyft.android.jobs;

import android.content.res.Resources;
import dagger.internal.Binding;
import dagger.internal.Linker;
import java.util.Set;
import me.lyft.android.ILyftPreferences;
import me.lyft.android.application.autofill.AutoFillResolutionService;
import me.lyft.android.application.ride.IUserUiService;
import me.lyft.android.common.DialogFlow;

public final class AutoFillLocationJob$$InjectAdapter
  extends Binding<AutoFillLocationJob>
{
  private Binding<AutoFillResolutionService> autoFillResolutionService;
  private Binding<DialogFlow> dialogFlow;
  private Binding<ILyftPreferences> preferences;
  private Binding<Resources> resources;
  private Binding<IUserUiService> userService;
  
  public AutoFillLocationJob$$InjectAdapter()
  {
    super(null, "members/me.lyft.android.jobs.AutoFillLocationJob", false, AutoFillLocationJob.class);
  }
  
  public void attach(Linker paramLinker)
  {
    userService = paramLinker.requestBinding("me.lyft.android.application.ride.IUserUiService", AutoFillLocationJob.class, getClass().getClassLoader());
    autoFillResolutionService = paramLinker.requestBinding("me.lyft.android.application.autofill.AutoFillResolutionService", AutoFillLocationJob.class, getClass().getClassLoader());
    dialogFlow = paramLinker.requestBinding("me.lyft.android.common.DialogFlow", AutoFillLocationJob.class, getClass().getClassLoader());
    preferences = paramLinker.requestBinding("me.lyft.android.ILyftPreferences", AutoFillLocationJob.class, getClass().getClassLoader());
    resources = paramLinker.requestBinding("android.content.res.Resources", AutoFillLocationJob.class, getClass().getClassLoader());
  }
  
  public void getDependencies(Set<Binding<?>> paramSet1, Set<Binding<?>> paramSet2)
  {
    paramSet2.add(userService);
    paramSet2.add(autoFillResolutionService);
    paramSet2.add(dialogFlow);
    paramSet2.add(preferences);
    paramSet2.add(resources);
  }
  
  public void injectMembers(AutoFillLocationJob paramAutoFillLocationJob)
  {
    userService = ((IUserUiService)userService.get());
    autoFillResolutionService = ((AutoFillResolutionService)autoFillResolutionService.get());
    dialogFlow = ((DialogFlow)dialogFlow.get());
    preferences = ((ILyftPreferences)preferences.get());
    resources = ((Resources)resources.get());
  }
}

/* Location:
 * Qualified Name:     me.lyft.android.jobs.AutoFillLocationJob..InjectAdapter
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */