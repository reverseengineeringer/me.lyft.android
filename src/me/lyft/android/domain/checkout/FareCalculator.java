package me.lyft.android.domain.checkout;

import java.util.ArrayList;
import java.util.List;
import me.lyft.android.domain.payment.ChargeAccount;
import me.lyft.android.domain.payment.Coupon;
import me.lyft.android.domain.payment.IPaymentFactory;
import me.lyft.android.domain.payment.Money;
import me.lyft.android.domain.payment.Payment;

public class FareCalculator
{
  private int contributorsIncludingUserCount;
  private IPaymentFactory paymentFactory;
  private Money rideTotal;
  private ChargeAccount selectedChargeAccount;
  private Coupon selectedCoupon;
  private Integer tip;
  
  public FareCalculator(IPaymentFactory paramIPaymentFactory)
  {
    paymentFactory = paramIPaymentFactory;
  }
  
  public List<Payment> calculatePayments()
  {
    int m = rideTotal.getAmount().intValue();
    Object localObject = rideTotal.getAmountCurrency();
    int j = m;
    int i2 = 0;
    int k = j;
    int n = 0;
    int i = j;
    if (tip != null) {
      i = j + tip.intValue();
    }
    j = i;
    int i1 = m;
    if (contributorsIncludingUserCount > 1)
    {
      k = i;
      j = (int)Math.ceil(i / contributorsIncludingUserCount);
      i1 = (int)Math.ceil(m / contributorsIncludingUserCount);
      n = 1;
    }
    i = j;
    m = i2;
    if (selectedCoupon != null)
    {
      m = Math.min(selectedCoupon.getMoney().getAmount().intValue(), i1);
      i = j - m;
    }
    ArrayList localArrayList = new ArrayList();
    Money localMoney;
    if (i >= 0)
    {
      localMoney = Money.create(i, (String)localObject);
      localArrayList.add(paymentFactory.createPayment(selectedChargeAccount, localMoney));
    }
    if (m > 0)
    {
      localMoney = Money.create(m, (String)localObject);
      localArrayList.add(paymentFactory.createCouponPayment(selectedCoupon.getId(), localMoney));
    }
    if (n != 0)
    {
      localObject = Money.create(k, (String)localObject);
      localArrayList.add(paymentFactory.createSplitFarePayment((Money)localObject));
    }
    return localArrayList;
  }
  
  public void setRideTotal(Money paramMoney)
  {
    rideTotal = paramMoney;
  }
  
  public void setSelectedChargeAccount(ChargeAccount paramChargeAccount)
  {
    selectedChargeAccount = paramChargeAccount;
  }
  
  public void setSelectedCoupon(Coupon paramCoupon)
  {
    selectedCoupon = paramCoupon;
  }
  
  public void setTip(Integer paramInteger)
  {
    tip = paramInteger;
  }
  
  public void setTotalContributorsCount(int paramInt)
  {
    contributorsIncludingUserCount = paramInt;
  }
}

/* Location:
 * Qualified Name:     me.lyft.android.domain.checkout.FareCalculator
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */