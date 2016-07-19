package me.lyft.android.infrastructure;

import android.accounts.AccountManager;
import android.content.pm.PackageManager;
import android.net.ConnectivityManager;
import android.telephony.TelephonyManager;
import android.view.WindowManager;
import dagger.internal.Binding;
import dagger.internal.Linker;
import dagger.internal.ProvidesBinding;
import java.util.Set;
import me.lyft.android.LyftApplication;
import me.lyft.android.infrastructure.device.IDevice;

public final class InfrastructureServicesModule$$ModuleAdapter$ProvideDeviceProvidesAdapter
  extends ProvidesBinding<IDevice>
{
  private Binding<AccountManager> accountManager;
  private Binding<LyftApplication> app;
  private Binding<ConnectivityManager> connectivityManager;
  private final InfrastructureServicesModule module;
  private Binding<PackageManager> packageManager;
  private Binding<TelephonyManager> telephonyManager;
  private Binding<WindowManager> windowManager;
  
  public InfrastructureServicesModule$$ModuleAdapter$ProvideDeviceProvidesAdapter(InfrastructureServicesModule paramInfrastructureServicesModule)
  {
    super("me.lyft.android.infrastructure.device.IDevice", true, "me.lyft.android.infrastructure.InfrastructureServicesModule", "provideDevice");
    module = paramInfrastructureServicesModule;
    setLibrary(true);
  }
  
  public void attach(Linker paramLinker)
  {
    app = paramLinker.requestBinding("me.lyft.android.LyftApplication", InfrastructureServicesModule.class, getClass().getClassLoader());
    windowManager = paramLinker.requestBinding("android.view.WindowManager", InfrastructureServicesModule.class, getClass().getClassLoader());
    telephonyManager = paramLinker.requestBinding("android.telephony.TelephonyManager", InfrastructureServicesModule.class, getClass().getClassLoader());
    connectivityManager = paramLinker.requestBinding("android.net.ConnectivityManager", InfrastructureServicesModule.class, getClass().getClassLoader());
    accountManager = paramLinker.requestBinding("android.accounts.AccountManager", InfrastructureServicesModule.class, getClass().getClassLoader());
    packageManager = paramLinker.requestBinding("android.content.pm.PackageManager", InfrastructureServicesModule.class, getClass().getClassLoader());
  }
  
  public IDevice get()
  {
    return module.provideDevice((LyftApplication)app.get(), (WindowManager)windowManager.get(), (TelephonyManager)telephonyManager.get(), (ConnectivityManager)connectivityManager.get(), (AccountManager)accountManager.get(), (PackageManager)packageManager.get());
  }
  
  public void getDependencies(Set<Binding<?>> paramSet1, Set<Binding<?>> paramSet2)
  {
    paramSet1.add(app);
    paramSet1.add(windowManager);
    paramSet1.add(telephonyManager);
    paramSet1.add(connectivityManager);
    paramSet1.add(accountManager);
    paramSet1.add(packageManager);
  }
}

/* Location:
 * Qualified Name:     me.lyft.android.infrastructure.InfrastructureServicesModule..ModuleAdapter.ProvideDeviceProvidesAdapter
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */