package me.lyft.android.domain.payment;

import com.lyft.android.api.dto.RidePaymentDTO;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import me.lyft.android.common.Preconditions;
import me.lyft.android.domain.passenger.ride.PassengerRidePayment;

public class PaymentMapper
{
  private static RidePaymentDTO fromPaymentDomain(Payment paramPayment)
  {
    Preconditions.checkNotNull(paramPayment);
    return new RidePaymentDTO(resolvePaymentMethodFromPayment(paramPayment), resolveChargeAccountOrCouponId(paramPayment), MoneyMapper.fromMoneyDomain(paramPayment.getMoney()), getChargeToken(paramPayment));
  }
  
  public static List<RidePaymentDTO> fromPaymentDomain(PassengerRidePayment paramPassengerRidePayment)
  {
    ArrayList localArrayList = new ArrayList();
    paramPassengerRidePayment = paramPassengerRidePayment.getPayments().iterator();
    while (paramPassengerRidePayment.hasNext()) {
      localArrayList.add(fromPaymentDomain((Payment)paramPassengerRidePayment.next()));
    }
    return localArrayList;
  }
  
  private static String getChargeToken(Payment paramPayment)
  {
    if ((paramPayment instanceof PayPalPayment)) {
      return ((PayPalPayment)paramPayment).getChargeToken();
    }
    return null;
  }
  
  static String resolveChargeAccountOrCouponId(Payment paramPayment)
  {
    if ((paramPayment instanceof ChargeAccountPayment)) {
      return ((ChargeAccountPayment)paramPayment).getChargeAccountId();
    }
    if ((paramPayment instanceof CouponPayment)) {
      return ((CouponPayment)paramPayment).getCouponId();
    }
    return null;
  }
  
  static String resolvePaymentMethodFromPayment(Payment paramPayment)
  {
    if ((paramPayment instanceof ChargeAccountPayment)) {
      return "chargeaccount";
    }
    if ((paramPayment instanceof CouponPayment)) {
      return "coupon";
    }
    if ((paramPayment instanceof SplitFarePayment)) {
      return "splitfare";
    }
    if (paramPayment == null) {}
    for (paramPayment = "null";; paramPayment = paramPayment.getClass().getSimpleName()) {
      throw new IllegalArgumentException("Unknown payment type " + paramPayment);
    }
  }
}

/* Location:
 * Qualified Name:     me.lyft.android.domain.payment.PaymentMapper
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */