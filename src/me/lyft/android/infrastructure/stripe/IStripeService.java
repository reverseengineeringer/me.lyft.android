package me.lyft.android.infrastructure.stripe;

import me.lyft.android.domain.payment.ICard;
import rx.Observable;

public abstract interface IStripeService
{
  public abstract Observable<String> createCardToken(ICard paramICard);
  
  public abstract Observable<String> validateCardAndCreateToken(ICard paramICard);
}

/* Location:
 * Qualified Name:     me.lyft.android.infrastructure.stripe.IStripeService
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */