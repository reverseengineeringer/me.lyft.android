package me.lyft.android.domain.ride;

import com.lyft.android.api.dto.RideDTO;
import java.util.List;
import java.util.concurrent.TimeUnit;
import me.lyft.android.common.Enums;
import me.lyft.android.common.Objects;
import me.lyft.android.common.Strings;

public class RideStatusMapper
{
  public static RideStatus fromRideStatus(RideDTO paramRideDTO, List<String> paramList)
  {
    if (statusTimestamp != null) {}
    for (long l = TimeUnit.SECONDS.toMillis(statusTimestamp.longValue());; l = 0L) {
      return fromRideStatus(status, Long.valueOf(l), paramList);
    }
  }
  
  public static RideStatus fromRideStatus(String paramString, Long paramLong, List<String> paramList)
  {
    if (Strings.isNullOrEmpty(paramString)) {
      return RideStatus.empty();
    }
    boolean bool = paramList.contains(paramString);
    long l = ((Long)Objects.firstNonNull(paramLong, Long.valueOf(0L))).longValue();
    if (bool) {}
    for (paramString = RideStatus.Status.CANCELED;; paramString = (RideStatus.Status)Enums.valueOf(RideStatus.Status.class, paramString, RideStatus.Status.IDLE)) {
      return new RideStatus(paramString, l);
    }
  }
}

/* Location:
 * Qualified Name:     me.lyft.android.domain.ride.RideStatusMapper
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */