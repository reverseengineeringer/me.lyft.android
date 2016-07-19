package me.lyft.android.gcm.commands;

import android.content.Context;
import com.lyft.android.api.dto.RideDTO;
import java.util.Map;
import me.lyft.android.gcm.GcmEventHandler;
import me.lyft.android.gcm.IGcmSerializer;
import me.lyft.android.infrastructure.lyft.IAppStateHandler;
import me.lyft.android.logging.L;

public class RideUpdateGcmEventHandler
  implements GcmEventHandler
{
  static final String RIDE_PARAM = "ride";
  static final String TIMESTAMP_PARAM = "timestamp";
  private final IAppStateHandler appStateHandler;
  private final IGcmSerializer jsonGcmSerializer;
  
  public RideUpdateGcmEventHandler(IGcmSerializer paramIGcmSerializer, IAppStateHandler paramIAppStateHandler)
  {
    jsonGcmSerializer = paramIGcmSerializer;
    appStateHandler = paramIAppStateHandler;
  }
  
  private Long getUniversalTimestamp(Map<String, String> paramMap)
  {
    return Long.valueOf((String)paramMap.get("timestamp"));
  }
  
  public void execute(Context paramContext, Map<String, String> paramMap)
  {
    try
    {
      paramContext = (RideDTO)jsonGcmSerializer.deserialize(paramMap, "ride", RideDTO.class, null);
      long l = getUniversalTimestamp(paramMap).longValue();
      appStateHandler.setRide(Long.valueOf(l), paramContext);
      return;
    }
    catch (Exception paramContext)
    {
      L.e(paramContext, "handleRideUpdateEvent", new Object[0]);
    }
  }
  
  public String getEventName()
  {
    return "rideUpdate";
  }
}

/* Location:
 * Qualified Name:     me.lyft.android.gcm.commands.RideUpdateGcmEventHandler
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */