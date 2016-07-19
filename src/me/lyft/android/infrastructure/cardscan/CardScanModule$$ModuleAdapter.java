package me.lyft.android.infrastructure.cardscan;

import dagger.internal.Binding;
import dagger.internal.BindingsGroup;
import dagger.internal.Linker;
import dagger.internal.ModuleAdapter;
import dagger.internal.ProvidesBinding;
import java.util.Set;
import me.lyft.android.infrastructure.activity.IActivityLifecycleService;

public final class CardScanModule$$ModuleAdapter
  extends ModuleAdapter<CardScanModule>
{
  private static final Class<?>[] INCLUDES = new Class[0];
  private static final String[] INJECTS = new String[0];
  private static final Class<?>[] STATIC_INJECTIONS = new Class[0];
  
  public CardScanModule$$ModuleAdapter()
  {
    super(CardScanModule.class, INJECTS, STATIC_INJECTIONS, false, INCLUDES, false, true);
  }
  
  public void getBindings(BindingsGroup paramBindingsGroup, CardScanModule paramCardScanModule)
  {
    paramBindingsGroup.contributeProvidesBinding("me.lyft.android.infrastructure.cardscan.ICardScanService", new ProvideCardScanServiceProvidesAdapter(paramCardScanModule));
  }
  
  public CardScanModule newModule()
  {
    return new CardScanModule();
  }
  
  public static final class ProvideCardScanServiceProvidesAdapter
    extends ProvidesBinding<ICardScanService>
  {
    private Binding<IActivityLifecycleService> activityLifecycleService;
    private final CardScanModule module;
    
    public ProvideCardScanServiceProvidesAdapter(CardScanModule paramCardScanModule)
    {
      super(false, "me.lyft.android.infrastructure.cardscan.CardScanModule", "provideCardScanService");
      module = paramCardScanModule;
      setLibrary(true);
    }
    
    public void attach(Linker paramLinker)
    {
      activityLifecycleService = paramLinker.requestBinding("me.lyft.android.infrastructure.activity.IActivityLifecycleService", CardScanModule.class, getClass().getClassLoader());
    }
    
    public ICardScanService get()
    {
      return module.provideCardScanService((IActivityLifecycleService)activityLifecycleService.get());
    }
    
    public void getDependencies(Set<Binding<?>> paramSet1, Set<Binding<?>> paramSet2)
    {
      paramSet1.add(activityLifecycleService);
    }
  }
}

/* Location:
 * Qualified Name:     me.lyft.android.infrastructure.cardscan.CardScanModule..ModuleAdapter
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */