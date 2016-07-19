package me.lyft.android;

import android.view.inputmethod.InputMethodManager;
import dagger.internal.ProvidesBinding;

public final class AppModule$$ModuleAdapter$ProvideInputMethodManagerProvidesAdapter
  extends ProvidesBinding<InputMethodManager>
{
  private final AppModule module;
  
  public AppModule$$ModuleAdapter$ProvideInputMethodManagerProvidesAdapter(AppModule paramAppModule)
  {
    super("android.view.inputmethod.InputMethodManager", true, "me.lyft.android.AppModule", "provideInputMethodManager");
    module = paramAppModule;
    setLibrary(true);
  }
  
  public InputMethodManager get()
  {
    return module.provideInputMethodManager();
  }
}

/* Location:
 * Qualified Name:     me.lyft.android.AppModule..ModuleAdapter.ProvideInputMethodManagerProvidesAdapter
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */