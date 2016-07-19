package me.lyft.android.infrastructure.cardscan;

import dagger.Module;
import dagger.Provides;
import me.lyft.android.infrastructure.activity.IActivityLifecycleService;

@Module(complete=false, library=true)
public class CardScanModule
{
  @Provides
  ICardScanService provideCardScanService(IActivityLifecycleService paramIActivityLifecycleService)
  {
    return new CardScanService(paramIActivityLifecycleService);
  }
}

/* Location:
 * Qualified Name:     me.lyft.android.infrastructure.cardscan.CardScanModule
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */