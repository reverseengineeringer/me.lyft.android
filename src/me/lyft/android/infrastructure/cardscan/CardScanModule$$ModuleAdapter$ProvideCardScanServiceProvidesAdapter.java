package me.lyft.android.infrastructure.cardscan;

import dagger.internal.Binding;
import dagger.internal.Linker;
import dagger.internal.ProvidesBinding;
import java.util.Set;
import me.lyft.android.infrastructure.activity.IActivityLifecycleService;

public final class CardScanModule$$ModuleAdapter$ProvideCardScanServiceProvidesAdapter
  extends ProvidesBinding<ICardScanService>
{
  private Binding<IActivityLifecycleService> activityLifecycleService;
  private final CardScanModule module;
  
  public CardScanModule$$ModuleAdapter$ProvideCardScanServiceProvidesAdapter(CardScanModule paramCardScanModule)
  {
    super("me.lyft.android.infrastructure.cardscan.ICardScanService", false, "me.lyft.android.infrastructure.cardscan.CardScanModule", "provideCardScanService");
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

/* Location:
 * Qualified Name:     me.lyft.android.infrastructure.cardscan.CardScanModule..ModuleAdapter.ProvideCardScanServiceProvidesAdapter
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */