package me.lyft.android.domain.ridehistory;

import com.lyft.android.api.dto.AccountInfoDTO;
import com.lyft.android.api.dto.ChargeDTO;
import com.lyft.android.api.dto.LineItemDTO;
import com.lyft.android.api.dto.MoneyDTO;
import com.lyft.android.api.dto.PaymentBreakdownItemDTO;
import com.lyft.android.api.dto.RideHistoryDTO;
import com.lyft.android.api.dto.RideHistoryItemBriefDTO;
import com.lyft.android.api.dto.RideHistoryItemDetailedDTO;
import com.lyft.android.api.dto.SplitPaymentDTO;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Collections;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import java.util.TimeZone;
import java.util.concurrent.TimeUnit;
import me.lyft.android.common.Enums;
import me.lyft.android.common.Objects;
import me.lyft.android.common.Preconditions;
import me.lyft.android.domain.payment.Money;
import me.lyft.android.domain.ridehistory.charge.CouponAccountInfoItem;
import me.lyft.android.domain.ridehistory.charge.CreditCardAccountInfoItem;
import me.lyft.android.domain.ridehistory.charge.CreditLineAccountInfoItem;
import me.lyft.android.domain.ridehistory.charge.GoogleWalletAccountInfoItem;
import me.lyft.android.domain.ridehistory.charge.NullAccountInfoItem;
import me.lyft.android.domain.ridehistory.charge.PayPalAccountInfoItem;

public class PassengerRideHistoryMapper
  implements IPassengerRideHistoryMapper
{
  public static final int CONVERT_TO_MILES_TRESHOLD = 321;
  public static final SimpleDateFormat DATE_FORMAT_FULL = new SimpleDateFormat("MMM dd yyyy - h:mm aaa");
  public static final SimpleDateFormat DATE_FORMAT_SIMPLE = new SimpleDateFormat("MMM dd h:mm aaa");
  public static final SimpleDateFormat DATE_FORMAT_TIME_ONLY = new SimpleDateFormat("h:mm aaa");
  public static final float METERS_IN_FEET = 0.3048F;
  public static final int METERS_IN_MILE = 1609;
  public static final String RIDE_FINAL_STATE_CANCELLED = "cancelled";
  public static final String RIDE_FINAL_STATE_PROCESSED = "processed";
  
  private static int currentYear()
  {
    return Calendar.getInstance().get(1);
  }
  
  public static String formatDate(long paramLong, DateFormat paramDateFormat, String paramString)
  {
    paramDateFormat.setTimeZone(getTimeZone(paramString));
    return paramDateFormat.format(new Date(1000L * paramLong));
  }
  
  public static String formatDistanceMiles(int paramInt)
  {
    if (paramInt > 321) {
      return String.format("%.1fmi", new Object[] { Float.valueOf(paramInt / 1609.0F) });
    }
    return String.format("%.0fft", new Object[] { Float.valueOf(paramInt / 0.3048F) });
  }
  
  public static String formatDuration(long paramLong)
  {
    StringBuffer localStringBuffer = new StringBuffer(20);
    long l1 = TimeUnit.SECONDS.toHours(paramLong);
    if (l1 > 0L) {
      localStringBuffer.append(l1 + "h ");
    }
    long l2 = TimeUnit.SECONDS.toMinutes(paramLong - TimeUnit.HOURS.toSeconds(l1));
    if (l2 > 0L) {
      localStringBuffer.append(l2 + "m ");
    }
    paramLong = paramLong - TimeUnit.HOURS.toSeconds(l1) - TimeUnit.MINUTES.toSeconds(l2);
    if (paramLong > 0L) {
      localStringBuffer.append(paramLong + "s");
    }
    return localStringBuffer.toString();
  }
  
  private static String formatPickupDate(long paramLong, String paramString)
  {
    Calendar localCalendar = Calendar.getInstance();
    localCalendar.setTimeInMillis(1000L * paramLong);
    if (localCalendar.get(1) != currentYear()) {
      return formatDate(paramLong, DATE_FORMAT_FULL, paramString);
    }
    return formatDate(paramLong, DATE_FORMAT_SIMPLE, paramString);
  }
  
  public static TimeZone getTimeZone(String paramString)
  {
    if ((paramString.contains("UTC")) || (paramString.contains("GMT"))) {}
    for (boolean bool = true;; bool = false)
    {
      Preconditions.checkArgument(bool, "Timezone format should contain UTC or GMT");
      return TimeZone.getTimeZone(paramString.replace("UTC", "GMT"));
    }
  }
  
  private PaymentBreakdown mapPaymentBreakdown(PaymentBreakdownItemDTO paramPaymentBreakdownItemDTO)
  {
    ArrayList localArrayList = new ArrayList(lineItems.size());
    int i = 0;
    int j = lineItems.size();
    Object localObject1;
    while (i < j)
    {
      localObject1 = (LineItemDTO)lineItems.get(i);
      localArrayList.add(new PaymentBreakdown.ReceiptItem(title, Money.format(((Integer)Objects.firstNonNull(money.amount, Integer.valueOf(0))).intValue())));
      i += 1;
    }
    PaymentBreakdown.ReceiptItem localReceiptItem = new PaymentBreakdown.ReceiptItem(lineItemsTotal.title, Money.format(((Integer)Objects.firstNonNull(lineItemsTotal.money.amount, Integer.valueOf(0))).intValue()));
    PaymentBreakdown.SplitPayment localSplitPayment = null;
    if (splitPayment != null) {
      localSplitPayment = new PaymentBreakdown.SplitPayment(new PaymentBreakdown.ReceiptItem(splitPayment.title, "÷" + splitPayment.contributors), new PaymentBreakdown.ReceiptItem(splitPayment.subtotal.title, Money.format(((Integer)Objects.firstNonNull(splitPayment.subtotal.money.amount, Integer.valueOf(0))).intValue())), splitPayment.contributorPhotoUrls);
    }
    Object localObject3;
    if (coupons != null)
    {
      localObject1 = new ArrayList(coupons.size());
      localObject3 = coupons.iterator();
      for (;;)
      {
        localObject2 = localObject1;
        if (!((Iterator)localObject3).hasNext()) {
          break;
        }
        localObject2 = (ChargeDTO)((Iterator)localObject3).next();
        ((List)localObject1).add(new CouponAccountInfoItem(title, Money.format(((Integer)Objects.firstNonNull(money.amount, Integer.valueOf(0))).intValue()), chargeAccount.clientPaymentMethod, chargeAccount.type));
      }
    }
    Object localObject2 = Collections.emptyList();
    if (charges != null)
    {
      localObject3 = new ArrayList(charges.size());
      Iterator localIterator = charges.iterator();
      localObject1 = localObject3;
      if (localIterator.hasNext())
      {
        localObject1 = (ChargeDTO)localIterator.next();
        String str1 = Money.format(((Integer)Objects.firstNonNull(money.amount, Integer.valueOf(0))).intValue());
        String str2 = chargeAccount.clientPaymentMethod;
        i = -1;
        switch (str2.hashCode())
        {
        default: 
          switch (i)
          {
          default: 
            label540:
            localObject1 = new NullAccountInfoItem();
          }
          break;
        }
        for (;;)
        {
          ((List)localObject3).add(localObject1);
          break;
          if (!str2.equals("card")) {
            break label540;
          }
          i = 0;
          break label540;
          if (!str2.equals("creditLine")) {
            break label540;
          }
          i = 1;
          break label540;
          if (!str2.equals("paypal")) {
            break label540;
          }
          i = 2;
          break label540;
          if (!str2.equals("googleWallet")) {
            break label540;
          }
          i = 3;
          break label540;
          if (!str2.equals("coupon")) {
            break label540;
          }
          i = 4;
          break label540;
          localObject1 = new CreditCardAccountInfoItem(title, str1, chargeAccount.clientPaymentMethod, chargeAccount.type);
          continue;
          localObject1 = new CreditLineAccountInfoItem(title, str1, chargeAccount.clientPaymentMethod, chargeAccount.type);
          continue;
          localObject1 = new PayPalAccountInfoItem(title, str1, chargeAccount.clientPaymentMethod, chargeAccount.type);
          continue;
          localObject1 = new GoogleWalletAccountInfoItem(title, str1, chargeAccount.clientPaymentMethod, chargeAccount.type);
          continue;
          localObject1 = new CouponAccountInfoItem(title, str1, chargeAccount.clientPaymentMethod, chargeAccount.type);
        }
      }
    }
    else
    {
      localObject1 = Collections.emptyList();
    }
    return new PaymentBreakdown(title, localArrayList, localReceiptItem, localSplitPayment, (List)localObject2, (List)localObject1);
  }
  
  public final PassengerRideHistory fromDTO(RideHistoryDTO paramRideHistoryDTO)
  {
    PassengerRideHistory localPassengerRideHistory = new PassengerRideHistory(hasMore.booleanValue(), limit.intValue(), skip.intValue());
    Object localObject = data;
    if ((localObject == null) || (((List)localObject).size() <= 0)) {
      return localPassengerRideHistory;
    }
    paramRideHistoryDTO = new ArrayList(((List)localObject).size());
    localObject = ((List)localObject).iterator();
    while (((Iterator)localObject).hasNext()) {
      paramRideHistoryDTO.add(fromDTO((RideHistoryItemBriefDTO)((Iterator)localObject).next()));
    }
    localPassengerRideHistory.setRideHistory(paramRideHistoryDTO);
    return localPassengerRideHistory;
  }
  
  public PassengerRideHistoryDetails fromDTO(RideHistoryItemDetailedDTO paramRideHistoryItemDetailedDTO)
  {
    ArrayList localArrayList = new ArrayList(paymentBreakdown.size());
    Object localObject = paymentBreakdown.iterator();
    while (((Iterator)localObject).hasNext()) {
      localArrayList.add(mapPaymentBreakdown((PaymentBreakdownItemDTO)((Iterator)localObject).next()));
    }
    localObject = Enums.asList(RideHistoryFeature.class, features);
    if (rideState.equals("processed")) {
      return new PassengerRideHistoryDetails(mapImageUrl, formatDistanceMiles(distance.intValue()), formatDuration(dropoffTimestamp.longValue() - pickupTimestamp.longValue()), rideTypeLabel, pickupAddress, dropoffAddress, formatDate(pickupTimestamp.longValue(), DATE_FORMAT_TIME_ONLY, timeZone), formatDate(dropoffTimestamp.longValue(), DATE_FORMAT_TIME_ONLY, timeZone), formatDate(pickupTimestamp.longValue(), DATE_FORMAT_FULL, timeZone), driverPhotoUrl, driverName, Money.format(totalMoney.amount.intValue()), region, localArrayList, rideState, "", (List)localObject, pricingUrl);
    }
    return new PassengerRideHistoryDetails(mapImageUrl, rideTypeLabel, pickupAddress, formatDate(pickupTimestamp.longValue(), DATE_FORMAT_TIME_ONLY, timeZone), formatDate(pickupTimestamp.longValue(), DATE_FORMAT_FULL, timeZone), driverPhotoUrl, driverName, Money.format(totalMoney.amount.intValue()), region, localArrayList, rideState, cancelPenaltyReason, (List)localObject, pricingUrl);
  }
  
  PassengerRideHistoryItem fromDTO(RideHistoryItemBriefDTO paramRideHistoryItemBriefDTO)
  {
    String str3 = rideId;
    String str4 = driverPhotoUrl;
    String str5 = Money.format(((Integer)Objects.firstNonNull(totalMoney.amount, Integer.valueOf(0))).intValue());
    String str1 = "";
    String str2 = "";
    String str6 = formatPickupDate(pickupTimestamp.longValue(), timeZone);
    if (rideState.equals("processed"))
    {
      str1 = formatDistanceMiles(distance.intValue());
      str2 = formatDuration(dropoffTimestamp.longValue() - pickupTimestamp.longValue());
    }
    return new PassengerRideHistoryItem(str3, str4, str5, str1, str2, str6, rideTypeLabel, ((Boolean)Objects.firstNonNull(isBusinessRide, Boolean.valueOf(false))).booleanValue());
  }
}

/* Location:
 * Qualified Name:     me.lyft.android.domain.ridehistory.PassengerRideHistoryMapper
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */