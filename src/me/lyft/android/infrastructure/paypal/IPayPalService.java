package me.lyft.android.infrastructure.paypal;

import rx.Observable;

public abstract interface IPayPalService
{
  public abstract String obtainChargeToken();
  
  public abstract Observable<PayPalChargeData> obtainPayPalChargeData(String paramString);
}

/* Location:
 * Qualified Name:     me.lyft.android.infrastructure.paypal.IPayPalService
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */