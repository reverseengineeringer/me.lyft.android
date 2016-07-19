package me.lyft.android;

import android.content.ContentResolver;
import dagger.internal.Binding;
import dagger.internal.Linker;
import dagger.internal.ProvidesBinding;
import java.util.Set;
import me.lyft.android.providers.ContactsProvider;

public final class AppModule$$ModuleAdapter$ProvideContactsProviderProvidesAdapter
  extends ProvidesBinding<ContactsProvider>
{
  private Binding<ContentResolver> contentResolver;
  private final AppModule module;
  
  public AppModule$$ModuleAdapter$ProvideContactsProviderProvidesAdapter(AppModule paramAppModule)
  {
    super("me.lyft.android.providers.ContactsProvider", true, "me.lyft.android.AppModule", "provideContactsProvider");
    module = paramAppModule;
    setLibrary(true);
  }
  
  public void attach(Linker paramLinker)
  {
    contentResolver = paramLinker.requestBinding("android.content.ContentResolver", AppModule.class, getClass().getClassLoader());
  }
  
  public ContactsProvider get()
  {
    return module.provideContactsProvider((ContentResolver)contentResolver.get());
  }
  
  public void getDependencies(Set<Binding<?>> paramSet1, Set<Binding<?>> paramSet2)
  {
    paramSet1.add(contentResolver);
  }
}

/* Location:
 * Qualified Name:     me.lyft.android.AppModule..ModuleAdapter.ProvideContactsProviderProvidesAdapter
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */