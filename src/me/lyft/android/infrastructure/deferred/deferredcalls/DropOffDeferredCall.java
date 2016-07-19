package me.lyft.android.infrastructure.deferred.deferredcalls;

import com.lyft.android.api.dto.RideUpdateRequestDTO;
import com.lyft.android.api.dto.RideUpdateRequestDTOBuilder;
import java.io.IOException;
import me.lyft.android.common.DeviceClock;
import me.lyft.android.domain.location.Location;
import me.lyft.android.domain.location.LocationMapper;
import me.lyft.android.infrastructure.lyft.ILyftApi;

public final class DropOffDeferredCall
  extends BaseLyftDeferredCall
{
  final long actionTimestampMs;
  final double lat;
  final double lng;
  final String rideId;
  
  public DropOffDeferredCall(String paramString, Location paramLocation, long paramLong)
  {
    rideId = paramString;
    lat = paramLocation.getLat();
    lng = paramLocation.getLng();
    actionTimestampMs = paramLong;
  }
  
  public void callUsing(ILyftApi paramILyftApi)
    throws IOException
  {
    RideUpdateRequestDTO localRideUpdateRequestDTO = new RideUpdateRequestDTOBuilder().withStatus("droppedOff").withLocation(LocationMapper.toLocationDTO(new Location(lat, lng, ""))).withActionTimestampMs(Long.valueOf(actionTimestampMs)).withCurrentClientTimestampMs(Long.valueOf(DeviceClock.getCurrentTimeMs())).build();
    paramILyftApi.dropOff(rideId, localRideUpdateRequestDTO);
  }
  
  public String toString()
  {
    return "DropOffDeferredCall{rideId='" + rideId + '\'' + ", lat=" + lat + ", lng=" + lng + ", actionTimestampMs=" + actionTimestampMs + '}';
  }
}

/* Location:
 * Qualified Name:     me.lyft.android.infrastructure.deferred.deferredcalls.DropOffDeferredCall
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */