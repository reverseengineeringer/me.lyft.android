package me.lyft.android.jobs;

import com.lyft.android.api.dto.RideUserDTO;
import rx.functions.Func1;

class CourierDriverRideUpdatedJob$1
  implements Func1<RideUserDTO, String>
{
  CourierDriverRideUpdatedJob$1(CourierDriverRideUpdatedJob paramCourierDriverRideUpdatedJob) {}
  
  public String call(RideUserDTO paramRideUserDTO)
  {
    return id;
  }
}

/* Location:
 * Qualified Name:     me.lyft.android.jobs.CourierDriverRideUpdatedJob.1
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */