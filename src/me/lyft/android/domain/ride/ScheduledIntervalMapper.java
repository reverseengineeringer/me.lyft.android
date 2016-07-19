package me.lyft.android.domain.ride;

import com.lyft.android.api.dto.AvailableTimesListItemDTO;
import com.lyft.android.api.dto.ScheduledIntervalDTO;
import com.lyft.android.api.dto.ScheduledRideAvailableTimesResponseDTO;
import com.lyft.android.api.dto.TimeRangeDTO;
import com.lyft.android.api.dto.TimeRangeDeprecatedDTO;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import me.lyft.android.domain.time.Time;
import me.lyft.android.domain.time.TimeRange;

public class ScheduledIntervalMapper
{
  public static ScheduledInterval fromScheduledIntervalDTO(ScheduledIntervalDTO paramScheduledIntervalDTO, String paramString)
  {
    return new ScheduledInterval(fromTimeRangeDTO(pickup_range, paramString, 0L), fromTimeRangeDTO(dropoff_range, paramString, 0L));
  }
  
  public static List<ScheduledInterval> fromScheduledRideAvailableTimesResponseDTO(ScheduledRideAvailableTimesResponseDTO paramScheduledRideAvailableTimesResponseDTO)
  {
    if ((available_times == null) || (available_times.isEmpty()))
    {
      localObject = Collections.emptyList();
      return (List<ScheduledInterval>)localObject;
    }
    ArrayList localArrayList = new ArrayList(available_times.size());
    Iterator localIterator = available_times.iterator();
    AvailableTimesListItemDTO localAvailableTimesListItemDTO;
    ScheduledIntervalDTO localScheduledIntervalDTO;
    do
    {
      do
      {
        localObject = localArrayList;
        if (!localIterator.hasNext()) {
          break;
        }
        localAvailableTimesListItemDTO = (AvailableTimesListItemDTO)localIterator.next();
      } while ((first_interval == null) || (first_interval.pickup_range == null));
      localScheduledIntervalDTO = first_interval;
      localArrayList.add(fromScheduledIntervalDTO(localScheduledIntervalDTO, timezone));
    } while ((number_of_intervals == null) || (step_time_ms == null));
    int i = 1;
    label137:
    Time localTime;
    if (i < number_of_intervals.intValue())
    {
      localTime = fromTimeRangeDTO(pickup_range, timezone, step_time_ms.longValue() * i);
      if (dropoff_range == null) {
        break label230;
      }
    }
    label230:
    for (Object localObject = fromTimeRangeDTO(dropoff_range, timezone, step_time_ms.longValue() * i);; localObject = Time.empty())
    {
      localArrayList.add(new ScheduledInterval(localTime, (Time)localObject));
      i += 1;
      break label137;
      break;
    }
  }
  
  public static Time fromTimeRangeDTO(TimeRangeDTO paramTimeRangeDTO, String paramString, long paramLong)
  {
    if (paramTimeRangeDTO == null) {
      return Time.empty();
    }
    if ((range_ms == null) || (range_ms.longValue() == 0L)) {
      return new Time(timestamp_ms.longValue() + paramLong, paramString);
    }
    return new TimeRange(timestamp_ms.longValue() + paramLong, range_ms.longValue(), paramString);
  }
  
  public static TimeRange fromTimeRangeDTO(TimeRangeDTO paramTimeRangeDTO)
  {
    return new TimeRange(timestamp_ms.longValue(), range_ms.longValue(), "");
  }
  
  public static Time fromTimeRangeDTODeprecated(TimeRangeDeprecatedDTO paramTimeRangeDeprecatedDTO, String paramString)
  {
    if ((paramTimeRangeDeprecatedDTO == null) || (endTimestamp == null)) {
      return Time.empty();
    }
    if ((startTimestamp == null) || (startTimestamp.longValue() == 0L)) {
      return new Time(endTimestamp.longValue(), paramString);
    }
    return new TimeRange(startTimestamp.longValue(), endTimestamp.longValue() - startTimestamp.longValue(), paramString);
  }
  
  public static TimeRangeDTO toTimeRangeDTO(TimeRange paramTimeRange)
  {
    return new TimeRangeDTO(Long.valueOf(paramTimeRange.getTimestamp()), Long.valueOf(paramTimeRange.getRange()));
  }
}

/* Location:
 * Qualified Name:     me.lyft.android.domain.ride.ScheduledIntervalMapper
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */