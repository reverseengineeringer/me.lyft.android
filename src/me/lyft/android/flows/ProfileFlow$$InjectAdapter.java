package me.lyft.android.flows;

import dagger.internal.Binding;
import dagger.internal.Linker;
import java.util.Set;
import me.lyft.android.application.IUserProvider;
import me.lyft.android.common.AppFlow;

public final class ProfileFlow$$InjectAdapter
  extends Binding<ProfileFlow>
{
  private Binding<AppFlow> appFlow;
  private Binding<IUserProvider> userProvider;
  
  public ProfileFlow$$InjectAdapter()
  {
    super("me.lyft.android.flows.ProfileFlow", "members/me.lyft.android.flows.ProfileFlow", false, ProfileFlow.class);
  }
  
  public void attach(Linker paramLinker)
  {
    appFlow = paramLinker.requestBinding("me.lyft.android.common.AppFlow", ProfileFlow.class, getClass().getClassLoader());
    userProvider = paramLinker.requestBinding("me.lyft.android.application.IUserProvider", ProfileFlow.class, getClass().getClassLoader());
  }
  
  public ProfileFlow get()
  {
    ProfileFlow localProfileFlow = new ProfileFlow();
    injectMembers(localProfileFlow);
    return localProfileFlow;
  }
  
  public void getDependencies(Set<Binding<?>> paramSet1, Set<Binding<?>> paramSet2)
  {
    paramSet2.add(appFlow);
    paramSet2.add(userProvider);
  }
  
  public void injectMembers(ProfileFlow paramProfileFlow)
  {
    appFlow = ((AppFlow)appFlow.get());
    userProvider = ((IUserProvider)userProvider.get());
  }
}

/* Location:
 * Qualified Name:     me.lyft.android.flows.ProfileFlow..InjectAdapter
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */