package me.lyft.android.domain.payment;

import me.lyft.android.common.Preconditions;

public class PaymentFactory
  implements IPaymentFactory
{
  private IPaymentFactory.IPaymentMetadataProvider metadataProvider;
  
  public PaymentFactory(IPaymentFactory.IPaymentMetadataProvider paramIPaymentMetadataProvider)
  {
    Preconditions.checkNotNull(paramIPaymentMetadataProvider);
    metadataProvider = paramIPaymentMetadataProvider;
  }
  
  public CouponPayment createCouponPayment(String paramString, Money paramMoney)
  {
    return new CouponPayment(paramString, paramMoney);
  }
  
  public ChargeAccountPayment createPayment(ChargeAccount paramChargeAccount, Money paramMoney)
  {
    if (paramChargeAccount.isPayPal()) {}
    for (paramChargeAccount = new PayPalPayment(paramChargeAccount.getId(), paramMoney);; paramChargeAccount = new ChargeAccountPayment(paramChargeAccount.getId(), paramMoney))
    {
      metadataProvider.provideMetadata(paramChargeAccount);
      return paramChargeAccount;
    }
  }
  
  public SplitFarePayment createSplitFarePayment(Money paramMoney)
  {
    return new SplitFarePayment(paramMoney);
  }
}

/* Location:
 * Qualified Name:     me.lyft.android.domain.payment.PaymentFactory
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */