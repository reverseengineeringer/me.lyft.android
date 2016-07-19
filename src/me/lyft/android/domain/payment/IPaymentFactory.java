package me.lyft.android.domain.payment;

public abstract interface IPaymentFactory
{
  public abstract CouponPayment createCouponPayment(String paramString, Money paramMoney);
  
  public abstract ChargeAccountPayment createPayment(ChargeAccount paramChargeAccount, Money paramMoney);
  
  public abstract SplitFarePayment createSplitFarePayment(Money paramMoney);
  
  public static abstract interface IPaymentMetadataProvider
  {
    public abstract void provideMetadata(Payment paramPayment);
  }
}

/* Location:
 * Qualified Name:     me.lyft.android.domain.payment.IPaymentFactory
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */