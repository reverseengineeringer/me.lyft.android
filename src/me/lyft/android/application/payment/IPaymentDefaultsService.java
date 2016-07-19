package me.lyft.android.application.payment;

import me.lyft.android.domain.payment.ChargeAccount;

public abstract interface IPaymentDefaultsService
{
  public abstract ChargeAccount getCurrentDefaultChargeAccount();
}

/* Location:
 * Qualified Name:     me.lyft.android.application.payment.IPaymentDefaultsService
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */