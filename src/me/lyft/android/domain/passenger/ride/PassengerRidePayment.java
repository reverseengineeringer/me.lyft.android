package me.lyft.android.domain.passenger.ride;

import java.util.Iterator;
import java.util.List;
import me.lyft.android.domain.payment.ChargeAccountPayment;
import me.lyft.android.domain.payment.CouponPayment;
import me.lyft.android.domain.payment.Money;
import me.lyft.android.domain.payment.Payment;
import me.lyft.android.domain.payment.SplitFarePayment;

public class PassengerRidePayment
{
  private final List<Payment> payments;
  private int totalContributorsCount;
  
  public PassengerRidePayment(List<Payment> paramList, int paramInt)
  {
    payments = paramList;
    totalContributorsCount = paramInt;
  }
  
  private <T> int getTotalFor(Class<T> paramClass)
  {
    int j = 0;
    Iterator localIterator = payments.iterator();
    int i;
    do
    {
      Payment localPayment;
      do
      {
        i = j;
        if (!localIterator.hasNext()) {
          break;
        }
        localPayment = (Payment)localIterator.next();
      } while (!paramClass.isInstance(localPayment));
      i = localPayment.getMoney().getAmount().intValue();
    } while (i <= 0);
    return i;
  }
  
  public int getAppliedCreditsTotal()
  {
    return getTotalFor(CouponPayment.class);
  }
  
  public int getChargeAccountTotal()
  {
    return getTotalFor(ChargeAccountPayment.class);
  }
  
  public List<Payment> getPayments()
  {
    return payments;
  }
  
  public int getSplitFareTotal()
  {
    return getTotalFor(SplitFarePayment.class);
  }
  
  public int getTotalContributorsCount()
  {
    return totalContributorsCount;
  }
  
  public boolean isUsingCredits()
  {
    return getChargeAccountTotal() <= 0;
  }
}

/* Location:
 * Qualified Name:     me.lyft.android.domain.passenger.ride.PassengerRidePayment
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */