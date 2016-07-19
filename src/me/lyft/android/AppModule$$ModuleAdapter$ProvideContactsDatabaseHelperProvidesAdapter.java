package me.lyft.android;

import dagger.internal.ProvidesBinding;
import me.lyft.android.data.ContactsDatabaseHelper;

public final class AppModule$$ModuleAdapter$ProvideContactsDatabaseHelperProvidesAdapter
  extends ProvidesBinding<ContactsDatabaseHelper>
{
  private final AppModule module;
  
  public AppModule$$ModuleAdapter$ProvideContactsDatabaseHelperProvidesAdapter(AppModule paramAppModule)
  {
    super("me.lyft.android.data.ContactsDatabaseHelper", false, "me.lyft.android.AppModule", "provideContactsDatabaseHelper");
    module = paramAppModule;
    setLibrary(true);
  }
  
  public ContactsDatabaseHelper get()
  {
    return module.provideContactsDatabaseHelper();
  }
}

/* Location:
 * Qualified Name:     me.lyft.android.AppModule..ModuleAdapter.ProvideContactsDatabaseHelperProvidesAdapter
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */