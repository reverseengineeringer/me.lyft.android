package me.lyft.android.domain.passenger.ride;

import com.lyft.android.api.dto.CouponDTO;
import com.lyft.android.api.dto.LineItemDTO;
import com.lyft.android.api.dto.RideDTO;
import com.lyft.android.api.dto.RideUserDTO;
import com.lyft.android.api.dto.RouteDTO;
import com.lyft.android.api.dto.TipOptionDTO;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.TimeUnit;
import me.lyft.android.common.DeviceClock;
import me.lyft.android.common.Iterables;
import me.lyft.android.common.Objects;
import me.lyft.android.domain.payment.Coupon;
import me.lyft.android.domain.payment.Money;
import me.lyft.android.domain.payment.MoneyMapper;
import me.lyft.android.domain.time.Time;
import rx.functions.Func1;

public class PassengerRideReceiptMapper
{
  public static PassengerRideReceipt from(RideDTO paramRideDTO)
  {
    Money localMoney1 = MoneyMapper.fromMoneyDTO(recommendedTotalMoney);
    Money localMoney2 = MoneyMapper.fromMoneyDTO(maximumTotalMoney);
    List localList1 = fromCouponDTOs(validCoupons);
    List localList2 = fromLineItemDTOs(lineItems);
    List localList3 = fromTipOptions(tipOptions);
    if (statusTimestamp == null) {}
    for (long l = DeviceClock.getCurrentTimeMs();; l = TimeUnit.SECONDS.toMillis(statusTimestamp.longValue())) {
      return new PassengerRideReceipt(localMoney1, localMoney2, localList1, localList2, localList3, getDriverPhoto(paramRideDTO), getDriverName(paramRideDTO), (String)Objects.firstNonNull(pricingUrl, ""), new Time(l, timezone));
    }
  }
  
  private static Coupon fromCouponDTO(CouponDTO paramCouponDTO)
  {
    if (paramCouponDTO == null) {
      return null;
    }
    return new Coupon((String)Objects.firstNonNull(id, ""), MoneyMapper.fromMoneyDTO(money), (String)Objects.firstNonNull(lineItemTitle, ""));
  }
  
  private static List<Coupon> fromCouponDTOs(List<CouponDTO> paramList)
  {
    if ((paramList == null) || (paramList.isEmpty()))
    {
      paramList = Collections.emptyList();
      return paramList;
    }
    ArrayList localArrayList = new ArrayList(paramList.size());
    Iterator localIterator = paramList.iterator();
    for (;;)
    {
      paramList = localArrayList;
      if (!localIterator.hasNext()) {
        break;
      }
      paramList = fromCouponDTO((CouponDTO)localIterator.next());
      if (paramList != null) {
        localArrayList.add(paramList);
      }
    }
  }
  
  private static PriceBreakdownItem fromLineItemDTO(LineItemDTO paramLineItemDTO)
  {
    return new PriceBreakdownItem(title, MoneyMapper.fromMoneyDTO(money));
  }
  
  private static List<PriceBreakdownItem> fromLineItemDTOs(List<LineItemDTO> paramList)
  {
    if (paramList == null)
    {
      paramList = Collections.emptyList();
      return paramList;
    }
    ArrayList localArrayList = new ArrayList(paramList.size());
    Iterator localIterator = paramList.iterator();
    for (;;)
    {
      paramList = localArrayList;
      if (!localIterator.hasNext()) {
        break;
      }
      localArrayList.add(fromLineItemDTO((LineItemDTO)localIterator.next()));
    }
  }
  
  private static TipOption fromTipOptionDTO(TipOptionDTO paramTipOptionDTO)
  {
    return new TipOption(MoneyMapper.fromMoneyDTO(money), title);
  }
  
  private static List<TipOption> fromTipOptions(List<TipOptionDTO> paramList)
  {
    if (paramList == null) {
      return Collections.emptyList();
    }
    Iterables.map(paramList, new Func1()
    {
      public TipOption call(TipOptionDTO paramAnonymousTipOptionDTO)
      {
        return PassengerRideReceiptMapper.fromTipOptionDTO(paramAnonymousTipOptionDTO);
      }
    });
  }
  
  private static String getDriverName(RideDTO paramRideDTO)
  {
    if ((route != null) && (route.driver != null) && (route.driver.userPhoto != null)) {
      return route.driver.firstName;
    }
    return "";
  }
  
  private static String getDriverPhoto(RideDTO paramRideDTO)
  {
    if ((route != null) && (route.driver != null) && (route.driver.userPhoto != null)) {
      return route.driver.userPhoto;
    }
    return "";
  }
}

/* Location:
 * Qualified Name:     me.lyft.android.domain.passenger.ride.PassengerRideReceiptMapper
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */