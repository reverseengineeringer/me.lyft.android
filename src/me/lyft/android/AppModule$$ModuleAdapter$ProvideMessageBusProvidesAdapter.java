package me.lyft.android;

import com.lyft.rx.MessageBus;
import dagger.internal.ProvidesBinding;

public final class AppModule$$ModuleAdapter$ProvideMessageBusProvidesAdapter
  extends ProvidesBinding<MessageBus>
{
  private final AppModule module;
  
  public AppModule$$ModuleAdapter$ProvideMessageBusProvidesAdapter(AppModule paramAppModule)
  {
    super("com.lyft.rx.MessageBus", true, "me.lyft.android.AppModule", "provideMessageBus");
    module = paramAppModule;
    setLibrary(true);
  }
  
  public MessageBus get()
  {
    return module.provideMessageBus();
  }
}

/* Location:
 * Qualified Name:     me.lyft.android.AppModule..ModuleAdapter.ProvideMessageBusProvidesAdapter
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */