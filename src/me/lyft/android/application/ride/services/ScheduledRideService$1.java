package me.lyft.android.application.ride.services;

import com.lyft.android.api.dto.ScheduledRideResponseDTO;
import me.lyft.android.application.requestridetypes.IRequestRideTypeService;
import me.lyft.android.domain.ride.ScheduledRideMapper;
import me.lyft.android.rx.AsyncCall;

class ScheduledRideService$1
  extends AsyncCall<ScheduledRideResponseDTO>
{
  ScheduledRideService$1(ScheduledRideService paramScheduledRideService) {}
  
  public void onSuccess(ScheduledRideResponseDTO paramScheduledRideResponseDTO)
  {
    super.onSuccess(paramScheduledRideResponseDTO);
    paramScheduledRideResponseDTO = ScheduledRideMapper.fromScheduledRideResponseDTO(paramScheduledRideResponseDTO, this$0.requestRideTypeService.getRideTypes());
    ScheduledRideService.access$000(this$0, paramScheduledRideResponseDTO);
  }
}

/* Location:
 * Qualified Name:     me.lyft.android.application.ride.services.ScheduledRideService.1
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */