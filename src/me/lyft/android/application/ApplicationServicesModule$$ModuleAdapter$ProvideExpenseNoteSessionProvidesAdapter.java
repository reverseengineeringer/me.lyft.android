package me.lyft.android.application;

import dagger.internal.Binding;
import dagger.internal.Linker;
import dagger.internal.ProvidesBinding;
import java.util.Set;
import me.lyft.android.application.ride.IExpenseNoteSession;
import me.lyft.android.persistence.expensenotes.IExpenseNoteStorage;

public final class ApplicationServicesModule$$ModuleAdapter$ProvideExpenseNoteSessionProvidesAdapter
  extends ProvidesBinding<IExpenseNoteSession>
{
  private Binding<IExpenseNoteStorage> expenseNoteStorage;
  private final ApplicationServicesModule module;
  private Binding<IUserProvider> userProvider;
  
  public ApplicationServicesModule$$ModuleAdapter$ProvideExpenseNoteSessionProvidesAdapter(ApplicationServicesModule paramApplicationServicesModule)
  {
    super("me.lyft.android.application.ride.IExpenseNoteSession", true, "me.lyft.android.application.ApplicationServicesModule", "provideExpenseNoteSession");
    module = paramApplicationServicesModule;
    setLibrary(true);
  }
  
  public void attach(Linker paramLinker)
  {
    expenseNoteStorage = paramLinker.requestBinding("me.lyft.android.persistence.expensenotes.IExpenseNoteStorage", ApplicationServicesModule.class, getClass().getClassLoader());
    userProvider = paramLinker.requestBinding("me.lyft.android.application.IUserProvider", ApplicationServicesModule.class, getClass().getClassLoader());
  }
  
  public IExpenseNoteSession get()
  {
    return module.provideExpenseNoteSession((IExpenseNoteStorage)expenseNoteStorage.get(), (IUserProvider)userProvider.get());
  }
  
  public void getDependencies(Set<Binding<?>> paramSet1, Set<Binding<?>> paramSet2)
  {
    paramSet1.add(expenseNoteStorage);
    paramSet1.add(userProvider);
  }
}

/* Location:
 * Qualified Name:     me.lyft.android.application.ApplicationServicesModule..ModuleAdapter.ProvideExpenseNoteSessionProvidesAdapter
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */