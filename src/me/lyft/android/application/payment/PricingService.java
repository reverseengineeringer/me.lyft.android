package me.lyft.android.application.payment;

import com.jakewharton.rxrelay.BehaviorRelay;
import me.lyft.android.domain.passenger.ridetypes.Pricing;
import rx.Observable;

public class PricingService
  implements IPricingService
{
  private final BehaviorRelay<Pricing> pricingBehaviorRelay = BehaviorRelay.create(Pricing.empty());
  
  public Pricing getPricing()
  {
    return (Pricing)pricingBehaviorRelay.getValue();
  }
  
  public Observable<Pricing> observePricingUpdates()
  {
    return pricingBehaviorRelay.asObservable();
  }
  
  public void updatePricing(Pricing paramPricing)
  {
    pricingBehaviorRelay.call(paramPricing);
  }
}

/* Location:
 * Qualified Name:     me.lyft.android.application.payment.PricingService
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */