package me.lyft.android.infrastructure.cardscan;

import me.lyft.android.domain.payment.ICard;
import rx.Observable;

public abstract interface ICardScanService
{
  public abstract Observable<ICard> observeScannedCard();
  
  public abstract void start();
  
  public abstract void startCardScan();
  
  public abstract void stop();
}

/* Location:
 * Qualified Name:     me.lyft.android.infrastructure.cardscan.ICardScanService
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */