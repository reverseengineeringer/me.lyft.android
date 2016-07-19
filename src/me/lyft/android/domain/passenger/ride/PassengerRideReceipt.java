package me.lyft.android.domain.passenger.ride;

import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import me.lyft.android.common.Iterables;
import me.lyft.android.common.Objects;
import me.lyft.android.common.Strings;
import me.lyft.android.domain.payment.Coupon;
import me.lyft.android.domain.payment.Money;
import me.lyft.android.domain.payment.NullMoney;
import me.lyft.android.domain.time.Time;

public class PassengerRideReceipt
{
  private static final PassengerRideReceipt EMPTY = new PassengerRideReceipt(NullMoney.getInstance(), NullMoney.getInstance(), Collections.emptyList(), Collections.emptyList(), Collections.emptyList(), "", "", "", Time.empty());
  private final String driverName;
  private final String driverPhoto;
  private final Time dropoffTime;
  private final Money maximumTotalMoney;
  private final List<PriceBreakdownItem> priceBreakdownItems;
  private final String pricingUrl;
  private final List<TipOption> tipOptions;
  private final Money totalMoney;
  private final List<Coupon> validCoupons;
  
  public PassengerRideReceipt(Money paramMoney1, Money paramMoney2, List<Coupon> paramList, List<PriceBreakdownItem> paramList1, List<TipOption> paramList2, String paramString1, String paramString2, String paramString3, Time paramTime)
  {
    totalMoney = paramMoney1;
    maximumTotalMoney = paramMoney2;
    validCoupons = paramList;
    priceBreakdownItems = paramList1;
    tipOptions = paramList2;
    driverPhoto = paramString1;
    driverName = paramString2;
    pricingUrl = paramString3;
    dropoffTime = paramTime;
  }
  
  public static PassengerRideReceipt empty()
  {
    return EMPTY;
  }
  
  public Coupon findValidCouponById(String paramString)
  {
    if (Strings.isNullOrEmpty(paramString)) {
      return null;
    }
    Iterator localIterator = getValidCoupons().iterator();
    while (localIterator.hasNext())
    {
      Coupon localCoupon = (Coupon)localIterator.next();
      if (localCoupon.getId().equalsIgnoreCase(paramString)) {
        return localCoupon;
      }
    }
    return null;
  }
  
  public String getDriverName()
  {
    return driverName;
  }
  
  public String getDriverPhoto()
  {
    return driverPhoto;
  }
  
  public Time getDropoffTime()
  {
    return dropoffTime;
  }
  
  public Coupon getFirstValidCoupon()
  {
    return (Coupon)Iterables.firstOrDefault(getValidCoupons(), null);
  }
  
  public Money getMaximumTotalMoney()
  {
    return maximumTotalMoney;
  }
  
  public List<PriceBreakdownItem> getPriceBreakdownItems()
  {
    return priceBreakdownItems;
  }
  
  public String getPricingUrl()
  {
    return pricingUrl;
  }
  
  public List<TipOption> getTipOptions()
  {
    return tipOptions;
  }
  
  public Money getTotalMoney()
  {
    return (Money)Objects.firstNonNull(totalMoney, NullMoney.getInstance());
  }
  
  protected List<Coupon> getValidCoupons()
  {
    return (List)Objects.firstNonNull(validCoupons, Collections.emptyList());
  }
  
  public boolean isCouponAvailableForRide(String paramString)
  {
    return findValidCouponById(paramString) != null;
  }
}

/* Location:
 * Qualified Name:     me.lyft.android.domain.passenger.ride.PassengerRideReceipt
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */