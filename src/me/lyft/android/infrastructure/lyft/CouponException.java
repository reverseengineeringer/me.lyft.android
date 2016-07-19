package me.lyft.android.infrastructure.lyft;

import java.util.Iterator;
import java.util.List;
import me.lyft.android.application.payment.PaymentException;
import me.lyft.android.domain.lyft.LyftValidationError;

public class CouponException
  extends PaymentException
{
  public static final String ALREADY_USED_REASON = "alreadyUsed";
  private static final String COUPON_FIELD = "coupon";
  public static final String LOCATION_REQUIRED_REASON = "locationRequired";
  public static final String NEW_USERS_ONLY_REASON = "newUsersOnly";
  public static final String NONE_REMAINING_REASON = "noneRemaining";
  public static final String OUTSIDE_COUPON_REGION_REASON = "outsideCouponRegion";
  public static final String TRANSIENT_FAILURE_REASON = "transientFailure";
  
  public CouponException(Throwable paramThrowable)
  {
    super("Unable to apply coupon.", paramThrowable, "coupon_unknown");
  }
  
  public static boolean containsCouponValidationError(LyftApiException paramLyftApiException)
  {
    return firstCouponFailureReason(paramLyftApiException) != null;
  }
  
  private static String firstCouponFailureReason(LyftApiException paramLyftApiException)
  {
    paramLyftApiException = paramLyftApiException.getValidationErrors().iterator();
    while (paramLyftApiException.hasNext())
    {
      LyftValidationError localLyftValidationError = (LyftValidationError)paramLyftApiException.next();
      if ("coupon".equalsIgnoreCase(localLyftValidationError.getField())) {
        return localLyftValidationError.getReason();
      }
    }
    return null;
  }
  
  public String getFailureReason()
  {
    Object localObject = getCause();
    if ((localObject instanceof LyftApiException))
    {
      localObject = firstCouponFailureReason((LyftApiException)localObject);
      if (localObject != null) {
        return (String)localObject;
      }
    }
    return "unknown";
  }
  
  public String getReason()
  {
    Object localObject = getCause();
    if ((localObject instanceof LyftApiException))
    {
      localObject = firstCouponFailureReason((LyftApiException)localObject);
      if (localObject == null) {
        localObject = "other_lyft_error";
      }
    }
    for (;;)
    {
      return "coupon_" + (String)localObject;
      continue;
      localObject = "other_" + localObject.getClass().getSimpleName();
    }
  }
}

/* Location:
 * Qualified Name:     me.lyft.android.infrastructure.lyft.CouponException
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */