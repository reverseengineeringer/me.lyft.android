package me.lyft.android.infrastructure.deferred.deferredcalls;

import com.lyft.android.api.dto.RideUpdateRequestDTO;
import com.lyft.android.api.dto.RideUpdateRequestDTOBuilder;
import java.io.IOException;
import me.lyft.android.common.DeviceClock;
import me.lyft.android.infrastructure.lyft.ILyftApi;

public final class RateDeferredCall
  extends BaseLyftDeferredCall
{
  final long actionTimestampMs;
  final String feedback;
  final int rating;
  final String rideId;
  
  public RateDeferredCall(String paramString1, int paramInt, String paramString2, long paramLong)
  {
    rideId = paramString1;
    rating = paramInt;
    feedback = paramString2;
    actionTimestampMs = paramLong;
  }
  
  public void callUsing(ILyftApi paramILyftApi)
    throws IOException
  {
    RideUpdateRequestDTO localRideUpdateRequestDTO = new RideUpdateRequestDTOBuilder().withPassengerFeedback(feedback).withPassengerRating(Integer.valueOf(rating)).withActionTimestampMs(Long.valueOf(actionTimestampMs)).withCurrentClientTimestampMs(Long.valueOf(DeviceClock.getCurrentTimeMs())).build();
    paramILyftApi.ratePassenger(rideId, localRideUpdateRequestDTO);
  }
  
  public String toString()
  {
    return "RateDeferredCall{rideId='" + rideId + '\'' + ", rating=" + rating + ", feedback='" + feedback + '\'' + ", actionTimestampMs=" + actionTimestampMs + '}';
  }
}

/* Location:
 * Qualified Name:     me.lyft.android.infrastructure.deferred.deferredcalls.RateDeferredCall
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */