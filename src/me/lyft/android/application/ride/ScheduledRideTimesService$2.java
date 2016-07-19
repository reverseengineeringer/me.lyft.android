package me.lyft.android.application.ride;

import com.lyft.android.api.dto.ScheduledRideAvailableTimesResponseDTO;
import java.util.List;
import me.lyft.android.domain.ride.ScheduledInterval;
import me.lyft.android.domain.ride.ScheduledIntervalMapper;
import rx.functions.Func1;

final class ScheduledRideTimesService$2
  implements Func1<ScheduledRideAvailableTimesResponseDTO, List<ScheduledInterval>>
{
  public List<ScheduledInterval> call(ScheduledRideAvailableTimesResponseDTO paramScheduledRideAvailableTimesResponseDTO)
  {
    return ScheduledIntervalMapper.fromScheduledRideAvailableTimesResponseDTO(paramScheduledRideAvailableTimesResponseDTO);
  }
}

/* Location:
 * Qualified Name:     me.lyft.android.application.ride.ScheduledRideTimesService.2
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */