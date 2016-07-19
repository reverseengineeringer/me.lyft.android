package me.lyft.android.infrastructure.appboy;

import dagger.internal.Binding;
import dagger.internal.Linker;
import java.util.Set;
import me.lyft.android.infrastructure.gcm.IGcmIdService;

public final class AppboyBroadcastReceiver$$InjectAdapter
  extends Binding<AppboyBroadcastReceiver>
{
  private Binding<IGcmIdService> gcmIdService;
  
  public AppboyBroadcastReceiver$$InjectAdapter()
  {
    super("me.lyft.android.infrastructure.appboy.AppboyBroadcastReceiver", "members/me.lyft.android.infrastructure.appboy.AppboyBroadcastReceiver", false, AppboyBroadcastReceiver.class);
  }
  
  public void attach(Linker paramLinker)
  {
    gcmIdService = paramLinker.requestBinding("me.lyft.android.infrastructure.gcm.IGcmIdService", AppboyBroadcastReceiver.class, getClass().getClassLoader());
  }
  
  public AppboyBroadcastReceiver get()
  {
    AppboyBroadcastReceiver localAppboyBroadcastReceiver = new AppboyBroadcastReceiver();
    injectMembers(localAppboyBroadcastReceiver);
    return localAppboyBroadcastReceiver;
  }
  
  public void getDependencies(Set<Binding<?>> paramSet1, Set<Binding<?>> paramSet2)
  {
    paramSet2.add(gcmIdService);
  }
  
  public void injectMembers(AppboyBroadcastReceiver paramAppboyBroadcastReceiver)
  {
    gcmIdService = ((IGcmIdService)gcmIdService.get());
  }
}

/* Location:
 * Qualified Name:     me.lyft.android.infrastructure.appboy.AppboyBroadcastReceiver..InjectAdapter
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */