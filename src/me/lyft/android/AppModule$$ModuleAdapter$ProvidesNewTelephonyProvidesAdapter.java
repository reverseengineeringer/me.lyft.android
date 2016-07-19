package me.lyft.android;

import dagger.internal.ProvidesBinding;
import me.lyft.android.utils.Telephony;

public final class AppModule$$ModuleAdapter$ProvidesNewTelephonyProvidesAdapter
  extends ProvidesBinding<Telephony>
{
  private final AppModule module;
  
  public AppModule$$ModuleAdapter$ProvidesNewTelephonyProvidesAdapter(AppModule paramAppModule)
  {
    super("me.lyft.android.utils.Telephony", true, "me.lyft.android.AppModule", "providesNewTelephony");
    module = paramAppModule;
    setLibrary(true);
  }
  
  public Telephony get()
  {
    return module.providesNewTelephony();
  }
}

/* Location:
 * Qualified Name:     me.lyft.android.AppModule..ModuleAdapter.ProvidesNewTelephonyProvidesAdapter
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */