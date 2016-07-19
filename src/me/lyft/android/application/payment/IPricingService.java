package me.lyft.android.application.payment;

import me.lyft.android.domain.passenger.ridetypes.Pricing;
import rx.Observable;

public abstract interface IPricingService
{
  public abstract Pricing getPricing();
  
  public abstract Observable<Pricing> observePricingUpdates();
  
  public abstract void updatePricing(Pricing paramPricing);
}

/* Location:
 * Qualified Name:     me.lyft.android.application.payment.IPricingService
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */