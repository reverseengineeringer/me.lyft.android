package me.lyft.android.jobs;

import java.util.HashSet;
import rx.functions.Func2;

class CourierDriverRideUpdatedJob$2
  implements Func2<HashSet<String>, String, HashSet<String>>
{
  CourierDriverRideUpdatedJob$2(CourierDriverRideUpdatedJob paramCourierDriverRideUpdatedJob) {}
  
  public HashSet<String> call(HashSet<String> paramHashSet, String paramString)
  {
    paramHashSet.add(paramString);
    return paramHashSet;
  }
}

/* Location:
 * Qualified Name:     me.lyft.android.jobs.CourierDriverRideUpdatedJob.2
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */