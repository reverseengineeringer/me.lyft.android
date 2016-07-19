package me.lyft.android;

import android.accounts.AccountManager;
import dagger.internal.ProvidesBinding;

public final class AppModule$$ModuleAdapter$ProvideAccountManagerProvidesAdapter
  extends ProvidesBinding<AccountManager>
{
  private final AppModule module;
  
  public AppModule$$ModuleAdapter$ProvideAccountManagerProvidesAdapter(AppModule paramAppModule)
  {
    super("android.accounts.AccountManager", false, "me.lyft.android.AppModule", "provideAccountManager");
    module = paramAppModule;
    setLibrary(true);
  }
  
  public AccountManager get()
  {
    return module.provideAccountManager();
  }
}

/* Location:
 * Qualified Name:     me.lyft.android.AppModule..ModuleAdapter.ProvideAccountManagerProvidesAdapter
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */