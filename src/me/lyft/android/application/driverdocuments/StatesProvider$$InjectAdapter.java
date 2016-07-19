package me.lyft.android.application.driverdocuments;

import dagger.internal.Binding;
import dagger.internal.Linker;
import java.util.Set;
import me.lyft.android.LyftApplication;

public final class StatesProvider$$InjectAdapter
  extends Binding<StatesProvider>
{
  private Binding<LyftApplication> lyftApplication;
  
  public StatesProvider$$InjectAdapter()
  {
    super("me.lyft.android.application.driverdocuments.StatesProvider", "members/me.lyft.android.application.driverdocuments.StatesProvider", true, StatesProvider.class);
  }
  
  public void attach(Linker paramLinker)
  {
    lyftApplication = paramLinker.requestBinding("me.lyft.android.LyftApplication", StatesProvider.class, getClass().getClassLoader());
  }
  
  public StatesProvider get()
  {
    return new StatesProvider((LyftApplication)lyftApplication.get());
  }
  
  public void getDependencies(Set<Binding<?>> paramSet1, Set<Binding<?>> paramSet2)
  {
    paramSet1.add(lyftApplication);
  }
}

/* Location:
 * Qualified Name:     me.lyft.android.application.driverdocuments.StatesProvider..InjectAdapter
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */